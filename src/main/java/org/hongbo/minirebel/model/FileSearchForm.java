package org.hongbo.minirebel.model;

public class FileSearchForm {
	private String rootDirectoryPath;
	private String fileNameToCheck;
	private String destinationFolderPath;
	 
	public String getRootDirectoryPath() {
		return rootDirectoryPath;
	}
	public void setRootDirectoryPath(String rootDirectoryPath) {
		this.rootDirectoryPath = rootDirectoryPath;
	}
	public String getFileNameToCheck() {
		return fileNameToCheck;
	}
	public void setFileNameToCheck(String fileNameToCheck) {
		this.fileNameToCheck = fileNameToCheck;
	}
	public String getDestinationFolderPath() {
		return destinationFolderPath;
	}
	public void setDestinationFolderPath(String destinationFolderPath) {
		this.destinationFolderPath = destinationFolderPath;
	}
	 
}
