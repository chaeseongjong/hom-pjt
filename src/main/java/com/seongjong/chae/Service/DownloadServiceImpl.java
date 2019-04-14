package com.seongjong.chae.Service;

import java.io.File;
import java.util.ArrayList;

public class DownloadServiceImpl implements DownloadService{
	
	//���� ���
	final String Path = "F:/URL";
	@Override
	public ArrayList<String> getFileList(){
		
		//ArrayList<DownloadSVO> Files = new ArrayList<DownloadSVO>(); Ȯ�强�� ���ؼ�...(���߿� �ٸ������� �־�� ���� �𸣴�.....)1
		ArrayList<String> Files = new ArrayList<String>();
		// ���� 
		File Folder = new File(Path);
		// ������ ������ return Null; 
		if(!Folder.isDirectory()) return null;
		// ���� ����Ʈ ��������
		File[] Filelist = Folder.listFiles();
		// ���� ����Ʈ���� ������ ������ Files ��ü�� ���� �̸� �ֱ�
		//for(File file:Filelist) if(file.isFile()) Files.add(new DownloadSVO(file.getName()));Ȯ�强�� ���ؼ�...2
		for(File file:Filelist) if(file.isFile()) Files.add(file.getName());
		
		return Files;
		
	}
	

	//���� �ٿ� �ε�
	@Override
	public String FileDownLoad(String fileName) {
		
		ArrayList<String> FileList = getFileList();
		
		for(String file:FileList) if(file.equals(fileName)) return Path + "/" + file;
		// ������ ���� �� null ����
		return null;
	}

}
