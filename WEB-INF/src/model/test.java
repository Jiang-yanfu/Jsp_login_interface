package model;
import java.security.*;
public class test {
	public static void main(String args[])
	{
		String password= "Liu123499" + "a";
		try{
			MessageDigest m = MessageDigest.getInstance("SHA-1");
			m.reset();
			m.update(password.getBytes());
			byte[] encrypt_pass = m.digest();
			System.out.println(byteArrayToHexString(encrypt_pass));
		}catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
	}
	public static String byteArrayToHexString(byte[] b) {
		  String result = "";
		  for (int i=0; i < b.length; i++) {
		    result +=
		          Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
		  }
		  return result;
		}

}
