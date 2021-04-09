package com.hxzy;

public class A {
	public static void main(String[] args) {
		int i =10;
		int j = 100;
		System.out.println(1/3+i);
		m1(i, j);
		System.out.println(i+"===="+j);

	}
	static void m1(int a,int b){
		int temp;
		temp=a;
		a=b;
		b=temp;
	}
}
