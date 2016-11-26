package com.commondwang.sparksample.util;

import org.apache.commons.codec.binary.Base64;

public class UUID {

	public static String random() {
		byte[] data = UUID.toByteArray(java.util.UUID.randomUUID());
		String s = Base64.encodeBase64URLSafeString(data);
		return s.split("=")[0];
	}
	
	public static String randomConfID() {
		byte[] data = UUID.toByteArray(java.util.UUID.randomUUID());
		return Base64.encodeBase64String(data);
	}

	public static byte[] toByteArray(java.util.UUID uuid) {
		long msb = uuid.getMostSignificantBits();
		long lsb = uuid.getLeastSignificantBits();
		byte[] buffer = new byte[16];

		for (int i = 0; i < 8; i++) {
			buffer[i] = (byte) (msb >>> 8 * (7 - i));
		}
		for (int i = 8; i < 16; i++) {
			buffer[i] = (byte) (lsb >>> 8 * (7 - i));
		}
		return buffer;
	}

	public static java.util.UUID toUUID(byte[] data) {
		long msb = 0;
		long lsb = 0;
		assert data.length == 16;
		for (int i = 0; i < 8; i++)
			msb = (msb << 8) | (data[i] & 0xff);
		for (int i = 8; i < 16; i++)
			lsb = (lsb << 8) | (data[i] & 0xff);
		java.util.UUID result = new java.util.UUID(msb, lsb);
		return result;
	}
	
	public static String toStandardUUID(String base64UUID) {
		byte[] data = Base64.decodeBase64(base64UUID);
		// upper case uuid to be consistent with MMR
		return toUUID(data).toString().toUpperCase();
	}
	
	public static String fromStandardUUID(String standardUUID) {
		byte[] data = toByteArray(java.util.UUID.fromString(standardUUID));
		return Base64.encodeBase64String(data);
	}
}
