package com.itchinaonline.unit;

import org.junit.Test;

import com.itchinaonline.utils.encrypt.Base64Util;
import com.itchinaonline.utils.file.FileUtil;

public class Base64Test {
	
	private String targetPath = this.getClass().getResource("/").getPath();
	
	/**
	 * 图片base64加密
	 * @author jiuzhou.hu
	 * @date 2019年7月17日 上午11:28:22
	 */
	@Test
	public void encodeTest() {
		byte[] data = FileUtil.readToByte(targetPath + "logo.png");
		String base64Str = Base64Util.encode(data);
		System.out.println(base64Str);
	}
}