package com.seongjong.chae.Service;

import java.io.File;
import java.util.ArrayList;

public class DownloadServiceImpl implements DownloadService{
	
	//파일 경로
	final String Path = "F:/URL";
	@Override
	public ArrayList<String> getFileList(){
		
		ArrayList<String> Files = new ArrayList<String>();
		File Folder = new File(Path);
		// 파일 없으면 null 리턴
		if(!Folder.isDirectory()) {
			Files.add("파일이 없습니다.");
			return Files;
		} 
		File[] Filelist = Folder.listFiles();
		for(File file:Filelist) if(file.isFile()) Files.add(file.getName());
		
		return Files;
		
	}
	

	// 파일 다운로드 
	@Override
	public String FileDownLoad(String fileName) {
		
		ArrayList<String> FileList = getFileList();
		//파일 이름 없을 시 
		for(String file:FileList) if(file.equals(fileName)) return Path + "/" + file;
		return null;
	}

}
