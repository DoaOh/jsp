package kr.or.ddit.utill;

import static org.junit.Assert.*;
import kr.or.ddit.util.CookieUtil;

import org.junit.Test;

public class CookieUtillTest {

	/**
	 * 
	 * Method : getCookieTest
	 * 작성자 : PC03
	 * 변경이력 :
	 * Method 설명 : getCookie 테스트
	 */
	@Test
	public void getCookieTest() {
		/***Given***/
		String cookieString = "userId=brown; remeberme=true; test=testValue";
		CookieUtil.setCookieString(cookieString);

		/***When***/
		String cookieValue = CookieUtil.getCookie("userId");
		String cookieValue1 = CookieUtil.getCookie("remeberme");
		String cookieValue2 = CookieUtil.getCookie("test");
		String cookieValue3 = CookieUtil.getCookie("test123123");
		String cookieValue4= CookieUtil.getCookie("userI");
		
		/***Then***/
		assertEquals("brown", cookieValue);
		assertEquals("true", cookieValue1);
		assertEquals("testValue", cookieValue2);
		assertEquals("", cookieValue3);
		assertEquals("", cookieValue4);
		
		
	}

}
