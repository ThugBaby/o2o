package com.immoc.o2o.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ImageUtil {
	private static String basePath = Thread.currentThread()
			.getContextClassLoader().getResource("").getPath();
	private final static SimpleDateFormat sDateFormat = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	private final static Random random = new Random();

	public static String generateThumbnails(File thumbnail,
			String targetAddr) {

		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImageBasePath() + relativeAddr);
		try {
			Thumbnails
					.of(thumbnail)
					.size(200, 200)
					.watermark(Positions.BOTTOM_RIGHT,
							ImageIO.read(new File(basePath + "/watermark")),
							0.25f).outputQuality(0.8f).toFile(dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return relativeAddr;
	}

	private static String getRandomFileName() {
		// 获取随机五位数
		int rannum = random.nextInt(89999) + 10000;
		String nowTimeStr = sDateFormat.format(new Date());
		return nowTimeStr + rannum;
	}

	/*
	 * 获取输入文件流扩展名
	 */
	private static String getFileExtension(File cFile) {
		String originalFileName = cFile.getName();
		return originalFileName.substring(originalFileName.lastIndexOf("."));

	}

	/**
	 * 
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImageBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdir();
		}
	}
	/*
	 * public static void main(String[] args) {
	 * 
	 * try { Thumbnails .of(new File("D:\\test_image\\xiao.jpg")) .size(500,
	 * 500) .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath +
	 * "watermark.jpg")), 0.25f).outputQuality(0.8) .toFile(new
	 * File("D:\\test_image\\xiao2.jpg")); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */
}
