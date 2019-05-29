package kr.or.ddit.calculator;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class CalculatorTest {

	
	//3.문자열이 공백이거나, null 이면은 0을 리턴 :  "", null  ==> 0
	@Test
	public void empty_test() {
		
		
		/***Given***/
		Calculator cal= new Calculator();
		String text="";

		/***When***/
		int result = cal.calculate(text);
		/***Then***/
		assertEquals(0, result);

	}

	

	@Test
	public void null_test() {
		
		
		/***Given***/
		Calculator cal= new Calculator();
		String text=null;

		/***When***/
		int result = cal.calculate(text);
		/***Then***/
		assertEquals(0, result);

	}
	
	
	
	
	

	@Test
	public void customSeperatorTest (){
		/***Given***/
		Calculator cal= new Calculator();
		String text="//;\n1;5;10;20";
		

		/***When***/
		
		int result = cal.calculate(text);
		/***Then***/
	
		assertEquals(36, result);
	
	}
	
	
	//구분자를 섞을때
	
	@Test
	public void customDefaultSeperatorTest (){
		/***Given***/
		Calculator cal= new Calculator();
		String text="//;\n1;5;10;20";
		

		/***When***/
		
		int result = cal.calculate(text);
		/***Then***/
	
		assertEquals(36, result);
	
	}
	
	
	
	
	
	
	
	

	@Test
	public void regxpCapureTest (){
		/***Given***/
		String text="//;\n1;5;10;20";
		

		/***When***/
		
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		
		m.find();
		String customsSeperator = m.group(1);
		String textNumbers = m.group(2);

		/***Then***/
		assertEquals(";", customsSeperator);
		assertEquals("1;5;10;20", textNumbers);
		

		
	}
	
	
	
	
	
	
	
	@Test
	public void defaultSeperatorTest(){
		
		
		/***Given***/
		Calculator cal= new Calculator();
		String text="1,5:10,20";

		/***When***/
		int result = cal.calculate(text);
		/***Then***/

		/***Then***/
		assertEquals(36, result);

		
	}
	
	
	

	@Test
	public void Test(){
	
		
		String text="1,10,20";
		String[] textArray= text.split(",|:");
		
		assertEquals(3,textArray.length);
		assertEquals("1",textArray[0]);
		assertEquals("10",textArray[1]);
		assertEquals("20",textArray[2]);

		
	}
	
	
}
