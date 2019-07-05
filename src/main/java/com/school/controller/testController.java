package com.school.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.school.util.AudioUtils;
import com.school.util.ise;

@RestController
public class testController {

	@RequestMapping("/upfile")
	public Map<String, Object> getFile(@RequestParam("file") MultipartFile file,HttpServletRequest request){
		String path = "F:\\cocos\\school\\school\\resource";
		OutputStream os = null;
		InputStream ins= null;
		Map<String, Object> res = new HashMap<String, Object>();
//		res.put("filename", );
		String mpPath = path + File.separator + file.getOriginalFilename();
		String pcmPath = path + File.separator + UUID.randomUUID() + ".PCM";
		try {
			os = new FileOutputStream(mpPath);
			ins = file.getInputStream();
			byte[] bs = new byte[1024];
			int len;
			File tempFile = new File(path);
			if(!tempFile.exists()) {
				tempFile.mkdirs();
			}
			
			while((len= ins.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				os.close();
				ins.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		AudioUtils utils  = AudioUtils.getInstance();
      utils.convertMP32Pcm(mpPath, pcmPath);
		try {
			ise.goPost(pcmPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
}
