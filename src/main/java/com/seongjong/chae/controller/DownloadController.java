package com.seongjong.chae.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.activation.CommandMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seongjong.chae.Service.DownloadServiceImpl;


@Controller
public class DownloadController {
	
	private static final Logger logger = LoggerFactory.getLogger(DownloadController.class);
	
	@RequestMapping(value = "/download")
	public String download(Model model) {
		logger.info("다운로드 페이지 접속");
		
		DownloadServiceImpl downloadServiceImpl = new DownloadServiceImpl();
		ArrayList<String> fileList = downloadServiceImpl.getFileList();
		model.addAttribute("fileList", fileList );
		
		return "board/download";
	}
	
	@RequestMapping(value="/FileDownload") 
	public Object downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception{ 
		// Ŭ���̾�Ʈ���� ���� ���� �̸�
		String FileName = request.getParameter("selectFile");
		DownloadServiceImpl downloadServiceImpl = new DownloadServiceImpl();
		String CheckFile = downloadServiceImpl.FileDownLoad(FileName);
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		
		if(CheckFile == null) return resultMap.put("result","������ �����ϴ�.");
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File(CheckFile)); 
		response.setContentType("application/octet-stream"); 
		response.setContentLength(fileByte.length); 
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(CheckFile,"UTF-8")+"\";"); 
		response.setHeader("Content-Transfer-Encoding", "binary"); 
		response.getOutputStream().write(fileByte); 
		response.getOutputStream().flush(); 
		response.getOutputStream().close(); 
		
		return resultMap.put("result","true");
	}
	

	
}
