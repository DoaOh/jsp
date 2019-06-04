package kr.or.ddit.encrypt.kisa.sha256.alia;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import kr.or.ddit.encrypt.kisa.aria.ARIAUtil;
import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class aliaUtilTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(aliaUtilTest.class);

	@Test
	public void test() throws InvalidKeyException, UnsupportedEncodingException {
		
		
		/***Given***/
		
		String plainText = "brown1324";

		/***When***/
		String encryptText =ARIAUtil.ariaEncrypt(plainText);
		
		logger.debug("dddd{}",encryptText);

		/***Then***/
		String decryptText =ARIAUtil.ariaDecrypt(encryptText);
		logger.debug("dddd{}",decryptText);
		
		assertEquals(plainText, decryptText);
	}

}
