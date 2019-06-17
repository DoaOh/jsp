package kr.or.ddit.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.controller.Controller;
import kr.or.ddit.controller.MainController;
import kr.or.ddit.controller.UserListController;
import kr.or.ddit.model.urimappingVo;
import kr.or.ddit.service.IuriService;
import kr.or.ddit.service.UriService;

public class RequestMapping {
	private static final Logger logger = LoggerFactory
			.getLogger(RequestMapping.class);
	
	//main.do MainCOntroller
	//userList.do UserListController
	
	//private IuriService uriService;
	
	private static Map<String,String> requestMappingClass;
	private static Map<String,Controller> requestMapping;
	
	private static IuriService uriService = new UriService();
	
	//static 블럭을 이용해 데이터 초기화
	static{
		
		List<urimappingVo> urimappingList = uriService.urimappingList();
		
		
		 
		/*String uri=urimappingList.get(0).getUri();
		String classname =urimappingList.get(0).getClassname();
			*/	
		
		
		/* 
		 Map<String,String> requestMappingClass=new HashMap<String, String>();
		 requestMappingClass.put("/main.do","kr.or.ddit.controller.MainController");
		 //문자열정보를 바탕으로 클래스 생성
		 */
		
		
		requestMapping =new HashMap<String,Controller>();
		
		//for(String key : requestMappingClass.keySet()){
		
		for(urimappingVo urimappingVo : urimappingList){
			//classInfo="kr.or.ddit.controller.MainController"
			
			String classInfo =urimappingVo.getClassname();	
			//문자열을 만든다
			try {
				
				Class clazz =Class.forName(classInfo);
				Object obj = clazz.newInstance();
				requestMapping.put(urimappingVo.getUri(), (Controller)obj);
					
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		//Integer i = new Integer(5);
		//requestMapping.put("/main.do",new MainController());
		//requestMapping.put("/userList.do",new UserListController());
		
	}
	public static Controller getController(String uri) {
		logger.debug("getController : {} ", uri);
		return requestMapping.get(uri);
	}

}
