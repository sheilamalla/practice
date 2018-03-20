package com.learning.project;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BankAppServiceSample<T> {
	
	public final FileManipulationSample<T> fileManipulation = new FileManipulationSample<>();
	public static final String topLevelFolderPath = "bank/registeredUsersSample";
	public static final String registeredUserFileNameSample = "userSample.txt";
	public static final String existinfAcoountNumubersFile = "existing-acc.txt";
	public static final String allAccountsFilName = "all-acc.txt";
	
	public List<T> getDeserializedList(String filePath){
		List<T> deSerializedObject = fileManipulation.readFromFile(filePath);
		return deSerializedObject;
	}
	

	
	
	public String register(String username, String password) {
		File userFile = createFileIfNotExists(topLevelFolderPath,registeredUserFileNameSample);
		RegisteredUserSample registerUser = new RegisteredUserSample(username,password);
		
		return null;
	}
	private File createFileIfNotExists(String folder, String fileName) {
		String[] fileNames = fileName.split("/");
		for(String file: fileNames) {
			if(!file.contains(".txt")) {
				folder = folder +"/"+file;
				File folderToCreate = new File(folder);
				if(!folderToCreate.exists()){
					folderToCreate.mkdir();
				}
			}
			else {
				fileName = file;
			}
		}
		File userFile = new File(folder + "/"+fileName);
		
		if(!userFile.exists()) {
			try {
				userFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public RegisteredUserSample login(String username, String password) {
		
		File userFile = createFileIfNotExists(topLevelFolderPath,registeredUserFileNameSample);
		
		List<RegisteredUserSample> registeredUsers =(List<RegisteredUserSample>) getDeserializedList(userFile.getPath());
		for(RegisteredUserSample ru: registeredUsers) {
			if(username.equalsIgnoreCase(ru.getUsername())&& password.equals(ru.getPassword())) {
				return ru;
			}
		}
		return null;
	}




	public boolean hasExistingAccount(String username) {
		File userAccountFile = new File(topLevelFolderPath + "/"+username.toLowerCase()+ "/CHECKING.txt");
		if(userAccountFile.exists())
			return true;
		return false;
	}




	public String applyToOpenJointAccount(UserInfo userInfo, UserInfo jointUser, double balance){
		if(login(userInfo.getRegisteredUser().getUsername(),userInfo.getRegisteredUser().getPassword())==null) {
			return "You should register before applying for an account";
			
		}
		File userAccountFile = new File(topLevelFolderPath+"/"+userInfo.getRegisteredUser().getUsername().toLowerCase()+ "/CHECKING.txt");
		if(userAccountFile.exists()) {
			return "You already have an existing account with us. You can";
		}
		
		String accountFile ="applied.txt";
		AccountSample acc = new AccountSample();
		acc.setAccountType("CHECKING");
		acc.setBalance(balance);
		acc.setUser(userInfo);
		acc.setDelete(false);
		acc.setApproved(false);
		if(jointUser!=null)
		{
			acc.setJointUser(true);
			acc.setJointUser(jointUser);
		}
		
		
		
		
	}
	
	
	
	

}
