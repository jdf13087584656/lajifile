//package com.xlkj.website;
//
//import com.xlkj.website.model.ResultVo;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class WebsiteApplicationTests {
//
//	/**
//	 * @ClassName: FileTest
//	 * @Auther: jdf
//	 * @Date: 2018/8/14 18:42
//	 * @Description:
//	 */
//	public static class FileTest {
//		public void getFileList() {
//			File file = new File("C:\\Users\\admin\\Downloads\\icon");
//			File[] fileList = file.listFiles();
//			for (int i = 0; i < fileList.length; i++) {
//				if (fileList[i].isFile()) {
//					String fileName = fileList[i].getName();
//					fileName=i+".png";
//					File newFile = new File("F:\\firstcheck"+fileName);
//					fileList[i].renameTo(newFile);
//					System.out.println("文件：" + fileName);
//				}
//			}
//		}
//
//		//修改文件名
//		//  File newFile = new File("D:\\a\\121.jpg");
//		//  fileList[2].renameTo(newFile);
//		//获取文件不带后缀文件名称
//		//  originalFileName.substring(0, originalFileName.lastIndexOf("."))
//	}
//	@Test
//	public static void main(String[] args) {
//		FileTest rf = new FileTest();
//		rf.getFileList();
//
//
//	}
//
//
//}
//
//
//
//
