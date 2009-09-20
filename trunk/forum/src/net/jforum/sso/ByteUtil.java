package net.jforum.sso;

public class ByteUtil {
	
	public final static String stringToHexString(String src) {
		
		return bytesToHexString(src.getBytes());
	}
	
	public final static String stringFromHexString(String hexSrc) {

		return new String(hexStringToBytes(hexSrc));
	}
	
	public final static String bytesToHexString(byte[] src) {
		
		if (src == null || src.length <= 0) {
	
			return null;
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int i = 0; i < src.length; i++) {
			
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			
			if (hv.length() < 2) {
				
				stringBuilder.append(0);
			}
			
			stringBuilder.append(hv);
		}
		
		return stringBuilder.toString();
	}
	
	public final static byte[] hexStringToBytes(String hexString) {
		
		if (hexString == null || hexString.equals("")) {
			
			return null;
		}

		hexString = hexString.toLowerCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		
		for (int i = 0; i < length; i++) {
			
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
			
		}
		
		return d;
	}
	
	 private final static byte charToByte(char c) {
		 
		return (byte) "0123456789abcdef".indexOf(c);
	}

}
