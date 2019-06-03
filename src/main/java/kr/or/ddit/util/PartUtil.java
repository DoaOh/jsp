package kr.or.ddit.util;

import org.junit.Test;

public class PartUtil {



	/**
	 * Method : getFilename
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param contentDisposition
	 * @return
	 * Method 설명 : contentDisposition
	 */
	public static String getFileName(String contentDisposition) {
		
		//form-data; name="profile"; filename="sally.png"
		
		String [] splited = contentDisposition.split("; ");
		for(String split : splited)
			
			if(split.startsWith("filename=")){	
				int startIndex= split.indexOf("\"")+1;
				int lastIndex= split.lastIndexOf("\"");
				return split.substring(startIndex,lastIndex);	
			}
		
		return "";
	}

	/**
	 * Method : getExt
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param fileName
	 * @return
	 * Method 설명 : 파일명으로 부터 확장자를 반환
	 */
	public static String getExt(String fileName) {
		
		String [] splited = fileName.split("\\.");
		
		if(splited.length==1){
			return "";
			
		}else{
			return splited[splited.length - 1] ;

		}
		
		
		
		
	}
	
	
/*	
	public static String getExt(String fileName) {
		
	
		
		int startIndex  = fileName.lastIndexOf( "." );
		String ext = fileName.substring( startIndex + 1 );
		
		return ext;
		
	}
	*/

	
	
	

}
