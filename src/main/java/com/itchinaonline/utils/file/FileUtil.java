package com.itchinaonline.utils.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {

	/**
	 * 将本地资源转换为byte[]
	 * @author jiuzhou.hu
	 * @date 2015年12月28日 上午10:40:01
	 * @param filePath 本地资源地址
	 * @return
	 */
	public static byte[] readToByte(String filePath) {
		File file = new File(filePath);
		return readToByte(file);
	}

	/**
	 * 将文件转换为byte[]
	 * @author jiuzhou.hu
	 * @date 2015年12月28日 上午10:40:01
	 * @param filePath 本地资源地址
	 * @return
	 */
	public static byte[] readToByte(File file) {
		try (FileInputStream in = new FileInputStream(file)){
			return readToByte(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将InputStream转换为byte[]
	 * @author jiuzhou.hu
	 * @date 2016年1月11日 下午6:28:48
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static byte[] readToByte(InputStream is) {
		byte[] in2b = null;
		try (ByteArrayOutputStream swapStream = new ByteArrayOutputStream()){
			byte[] buff = new byte[100];
			int rc = 0;
			while ((rc = is.read(buff, 0, 100)) > 0) {
				swapStream.write(buff, 0, rc);
			}
			in2b = swapStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return in2b;
	}

}
