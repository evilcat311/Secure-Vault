package sample;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class test_harness {

	public static void main(String[] args) throws NoSuchAlgorithmException{
		String key = "stuff";

	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(key.getBytes());
	    byte[] digest = md.digest();
	    String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
	    System.out.println(myHash);

	}

}
