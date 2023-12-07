package org.hongbo.minirebel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.hongbo.minirebel.model.FileSearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileSearchController {

	@GetMapping("/filesearch")
	public String showFileSearchForm(Model model) {
		model.addAttribute("fileSearchForm", new FileSearchForm());
		return "filesearch";
	}

	@PostMapping("/filesearch")
	public String searchFiles(@ModelAttribute("fileSearchForm") FileSearchForm fileSearchForm, Model model) {
		List<String> rootFilePaths = searchFile(fileSearchForm.getRootDirectoryPath(), fileSearchForm.getFileNameToCheck());
		List<String> destinationFilePaths = searchFile(fileSearchForm.getDestinationFolderPath(), fileSearchForm.getFileNameToCheck());
		model.addAttribute("rootFilePaths", rootFilePaths);
		model.addAttribute("destinationFilePaths", destinationFilePaths);
		model.addAttribute("rootFilePathsLength", rootFilePaths.size());
		model.addAttribute("destinationFilePathsLength", destinationFilePaths.size());
		return "filesearch";
	}

	private List<String> searchFile(String directoryPath, String fileName) {
		List<String> filePaths = new ArrayList<>();
		File rootDirectory = new File(directoryPath);

		File[] files = rootDirectory.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					filePaths.addAll(searchFile(file.getAbsolutePath(), fileName));
				} else if (file.getName().equals(fileName)) {
					filePaths.add(file.getAbsolutePath());
				}
			}
		}

		return filePaths;
	}
}
