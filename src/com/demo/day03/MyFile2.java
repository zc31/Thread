package com.demo.day03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyFile2 {
	public static void main(String[] args) {
		read("E:\\更新日志.txt");
	}
	public static void read(String filename){
		File src = new File(filename);
		InputStream in = null;
		byte[] b = new byte[2];
		int n = 0;
		try {
			in = new FileInputStream(src);
			while((n=in.read(b))!=-1){
				System.out.println(new String(b));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(null, in);
		}
	}
	
	public static void close(OutputStream out,InputStream in){
		try {
			if(out!=null){
				out.close();
			}
			if(in!=null){
				in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
