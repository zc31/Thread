package com.demo.day07;

import com.demo.day05.LhDesign;

public class MyRunable3 implements Runnable{
	static LhDesign l=null;
	public static void main(String[] args) {
		MyRunable3 m = new MyRunable3();
		
		Thread t1 = new Thread(m,"A");
		Thread t2 = new Thread(m,"B");
		Thread t3 = new Thread(m,"C");
		Thread t4 = new Thread(m,"D");
		Thread t5 = new Thread(m,"E");
		Thread t6 = new Thread(m,"F");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}

	@Override
	public void run() {
		m();
	}
	
	public void m(){
		String name = Thread.currentThread().getName();
		l = LhDesign.getInstance();
		if(l==l){
			System.out.println(name+"一个对象");
		}else{
			System.out.println("不是一个对象");
		}
	}

}
