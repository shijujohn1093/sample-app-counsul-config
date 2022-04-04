package com.cuckoo.sampleappconsulconfig.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.jasypt.encryption.StringEncryptor;


public class EncryptionService implements StringEncryptor {

	private final String AES = "AES";
	private final String securityKey="1234567890987654"; // This key needs to be passed from args

	private Cipher creatCipher(byte[] byteArray, int cipherMode)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		
		SecretKeySpec secretKeySpec = new SecretKeySpec(byteArray, AES);
		Cipher cipher = Cipher.getInstance(AES);
		cipher.init(cipherMode, secretKeySpec);
		return cipher;
	}

	public String encryptText(String textToEncrypt) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = creatCipher(securityKey.getBytes(), Cipher.ENCRYPT_MODE);
		byte[] encryptedBytes = cipher.doFinal(textToEncrypt.getBytes());
		return Hex.encodeHexString(encryptedBytes);
	}
	
	public String decryptText(String textToDecrypt) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, DecoderException {
		Cipher cipher = creatCipher(securityKey.getBytes(), Cipher.DECRYPT_MODE);
		return decrypt(textToDecrypt, cipher);
	}
	
	public String decrypt(String textToDecrypt, Cipher cipher) throws UnsupportedEncodingException, DecoderException, IllegalBlockSizeException, BadPaddingException {
		byte[] decodedText = new Hex().decode(textToDecrypt.getBytes("utf-8"));
		byte[] decryptedBytes = cipher.doFinal(decodedText);
		return new String(decryptedBytes);
	}
	
	@Override
	public String encrypt(String message) {
		try {
			return encryptText(message);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String decrypt(String encryptedMessage) {
		try {
			return decryptText(encryptedMessage);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException | UnsupportedEncodingException | DecoderException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
