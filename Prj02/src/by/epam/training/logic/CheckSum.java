package by.epam.training.logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CheckSum {

	private static final String ALGORITHM = "SHA-1";

	public static String getCheckSum(String filename) {
		StringBuilder sb = null;
		try {
			final MessageDigest md = MessageDigest.getInstance(ALGORITHM);
			final FileInputStream fis = new FileInputStream(filename);
			byte[] dataBytes = new byte[1024];
			int bytesRead;
			while ((bytesRead = fis.read(dataBytes)) > 0) {
				md.update(dataBytes, 0, bytesRead);
			}
			byte[] mdBytes = md.digest();

			sb = new StringBuilder();
			for (int i = 0; i < mdBytes.length; i++) {
				sb.append(Integer.toString((mdBytes[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
