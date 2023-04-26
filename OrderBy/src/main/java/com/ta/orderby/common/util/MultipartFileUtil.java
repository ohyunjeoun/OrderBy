package com.ta.orderby.common.util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultipartFileUtil {
	// 파일 저장
	public static String save(MultipartFile upfile, String location) {
		String renamedFileName = null;
		String originalFileName = upfile.getOriginalFilename();
		
		log.info("Upfile Name : {}", originalFileName);
		log.info("location : {}", location);
		
		// location이 실제로 존재하지 않으면 폴더를 생성하는 로직(원래는 폴더없으면 에러났는데 안나게 강사님이 만들어주심..)
		File folder = new File(location);
		
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		// 밀리세컨드단위로 파일만들고(중복 없게끔) 확장자만 떼어다가 파일명 만들어준다.
		renamedFileName = 
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS")) + 
				originalFileName.substring(originalFileName.lastIndexOf("."));
		
		try {
			// 업로드한 파일 데이터를 지정한 파일에 저장한다.(upfile은 사용자가 업로드한 데이터고 그걸 물리적인 경로 new File 오브젝트에 저장한다.)
			upfile.transferTo(new File(location + "/" + renamedFileName));
			
		} catch (IllegalStateException | IOException e) {
			log.error("파일 전송 에러");
			e.printStackTrace();
		}
		
		return renamedFileName;
	}

	// 파일 삭제
	public static void delete(String location) {
		log.info("location : {}", location);
		
		File file = new File(location);
		
		if(file.exists()) {
			file.delete();
		}
	}
}