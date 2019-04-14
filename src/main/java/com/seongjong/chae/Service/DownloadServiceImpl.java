package com.seongjong.chae.Service;

import java.io.File;
import java.util.ArrayList;

public class DownloadServiceImpl implements DownloadService{
	
	//파일 경로
	final String Path = "F:/URL";
	@Override
	public ArrayList<String> getFileList(){
		
		//ArrayList<DownloadSVO> Files = new ArrayList<DownloadSVO>(); 확장성을 위해서...(나중에 다른정보를 넣어야 할지 모르니.....)1
		ArrayList<String> Files = new ArrayList<String>();
		// 폴더 
		File Folder = new File(Path);
		// 폴더가 없으면 return Null; 
		if(!Folder.isDirectory()) return null;
		// 파일 리스트 가져오기
		File[] Filelist = Folder.listFiles();
		// 파일 리스트에서 파일이 있으면 Files 객체에 파일 이름 넣기
		//for(File file:Filelist) if(file.isFile()) Files.add(new DownloadSVO(file.getName()));확장성을 위해서...2
		for(File file:Filelist) if(file.isFile()) Files.add(file.getName());
		
		return Files;
		
	}
	

	//파일 다운 로드
	@Override
	public String FileDownLoad(String fileName) {
		
		ArrayList<String> FileList = getFileList();
		
		for(String file:FileList) if(file.equals(fileName)) return Path + "/" + file;
		// 파일이 없을 때 null 리턴
		return null;
	}

}
