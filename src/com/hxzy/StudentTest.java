package com.hxzy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentTest {
	static Scanner sc = new Scanner(System.in);
	static List<Student> list = new ArrayList<>();
	public static void main(String[] args) {
		while(true) {
		System.out.println("[A 添加  B 删除]");
		String s = sc.next();
		if("a".equals(s)||"A".equals(s)){
			add();
		}else if("b".equals(s)||"B".equals(s)){
			del();
		}
		}
	}
	private static void add(){
		System.out.println("请输入学生的姓名：");
		String name = sc.next();
		System.out.println("请输入学生的年龄：");
		int age = sc.nextInt();
		Student s = new Student(name,age);
		list.add(s);
		for (Student student : list) {
			System.out.println(student);
		}
	}
	private static void del(){
		System.out.println("输入学生姓名：");
		String name = sc.next();
		for (int i=0;i<list.size();i++) {
			Student student = list.get(i);
			if(name.equals(student.getName())){
				list.remove(i);
			}
		}
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
