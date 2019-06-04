package kr.or.ddit.encrypt.kisa.sha256;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISH_SHA256_test {
	
	private static final Logger logger = LoggerFactory
			.getLogger(KISH_SHA256_test.class);

	/**
	 * Method : sha256Test
	 * 작성자 : PC02
	 * 변경이력 :
	 * Method 설명 : 복호화가 불가능한 해쉬 알고리즘
	 */
	@Test
	public void sha256Test() {
		
		/***Given***/
		
		String plainText = "red";

		/***When***/
		String encryptText = KISA_SHA256.encrypt(plainText);
		logger.debug("encryptText {} ",encryptText);
		logger.debug("encryptText {} ",encryptText);
		logger.debug("encryptText {} ",encryptText);

		
		/***Then***/
		

		
	}

}
