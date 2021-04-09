package com.demo.day04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

public class StudentTest {
	public static void main(String[] args) {
		test();
	}
	
	public static void test(){
		Student s1 = new Student("zc",85.5,86,90);
		Student s2 = new Student("z",70,72,60);
		Student s3 = new Student("c",85,88,99);
		Student s4 = new Student("zzz",82,80,75);
		Student s5 = new Student("ccc",100,30,40);
		Student[] ss = new Student[]{s1,s2,s3,s4,s5};
		TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
			double num = s2.getSum() - s1.getSum();
			double num2 = num == 0 ? s1.getChinese() - s2.getChinese() : num;
			double num3 = num2 == 0 ? s1.getMath() - s2.getMath() : num2;
			double num4 = num3 == 0 ? s1.getEnglish() - s2.getEnglish() : num3;
			double num5 = num4 == 0 ? s1.getName().compareTo(s2.getName())
			: num4;
			return (int) num5;
			}
		});
		for (Student student : ss) {
			ts.add(student);
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\students.txt"));
			bw.write("学生信息如下：");
			bw.newLine();
			bw.flush();
			bw.write("姓名,语文成绩,数学成绩,英语成绩");
			bw.newLine();
			bw.flush();
			for (Student s : ts) {
			StringBuilder sb = new StringBuilder();
			sb.append(s.getName()).append(",").append(s.getChinese())
			.append(",").append(s.getMath()).append(",")
			.append(s.getEnglish());
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
			}
			// 释放资源
			bw.close();
			System.out.println("学习信息存储完毕");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void write(String pathname,String str){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(pathname));
			out.write(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Student implements Serializable{
	private String name;
	private double chinese;
	private double english;
	private double math;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getChinese() {
		return chinese;
	}
	public void setChinese(double chinese) {
		this.chinese = chinese;
	}
	public double getEnglish() {
		return english;
	}
	public void setEnglish(double english) {
		this.english = english;
	}
	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}
	public double getSum() {
		return (this.chinese + this.math + this.english);
		}
	public Student(String name, double chinese, double english, double math) {
		this.name = name;
		this.chinese = chinese;
		this.english = english;
		this.math = math;
	}
	public Student() {
		
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", chinese=" + chinese + ", english="
				+ english + ", math=" + math + "]";
	}
	
	
}
