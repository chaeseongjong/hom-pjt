package com.seongjong.chae.Service;

import java.util.ArrayList;

public interface DownloadService {
	//파일 명 리스트
	public ArrayList<String> getFileList();
	//파일 다운 로드
	public String FileDownLoad(String fileName);
	
}
