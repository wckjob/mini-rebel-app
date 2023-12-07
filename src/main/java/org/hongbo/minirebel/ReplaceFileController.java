package org.hongbo.minirebel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class ReplaceFileController {

    @PostMapping("/replacefile")
    public String replaceFile(@RequestParam("selectedFile-root") String selectedFileRoot,
    		@RequestParam("selectedFile-destination") String selectedFileDestination,
            Model model) {
    	
    	String replacementStatus = "";
        try {
            File fileToCopy = new File(selectedFileRoot);
            if (fileToCopy.exists()) {
                File destinationFile = new File(selectedFileDestination);

                Files.copy(Paths.get(fileToCopy.getPath()), Paths.get(destinationFile.getPath()), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File replaced successfully at: " + destinationFile.getPath());
                replacementStatus = "Successful";
            } else {
                replacementStatus = "Failed";
            }
        } catch (IOException e) {
            System.out.println("Error replacing the file: " + e.getMessage());
        }

        return "redirect:/filesearch?status=" + replacementStatus;
    }
}
