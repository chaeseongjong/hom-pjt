package com.seongjong.chae.Service;

import java.util.ArrayList;

public interface DownloadService {
	//���� �� ����Ʈ
	public ArrayList<String> getFileList();
	//���� �ٿ� �ε�
	public String FileDownLoad(String fileName);
	
}