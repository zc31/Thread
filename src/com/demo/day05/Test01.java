package com.demo.day05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Properties;

import com.demo.day01.Test02;

public class Test01 {
	private IDao dao;
	public void setDao(IDao dao){
		this.dao=dao;
	}
	
	public static void main(String[] args) {
		/*Properties pro = new Properties();
		try {
			pro.load(new FileInputStream("E:\\rcieWorkSpace\\java2011\\src\\main\\java\\demo\\day05\\bean.properties"));
			
			String classname=pro.getProperty("classname");
			Class clazz=Class.forName(classname);
			IDao dao =(IDao)clazz.newInstance();
		
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Test01 t = new Test01();
		t.test04();
	}
	/**
	 * 获取Class类型的对象
	 */
	public void test01(){
		try {
			//1.全限定类名称  推荐
			/*Class<?> clazz = Class.forName("com.demo.day05.Student");
			Student st = (Student) clazz.newInstance();*/
			//2.类.class
			/*Class<?> clazz = Student.class;
			Student st = (Student) clazz.newInstance();*/
			//3.应用.getClass()
			/*Student st = new Student();
			Class<> clazz = st.getClass();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 反射获取构造方法
	 */
	public void test02(){
		try {
			Class<?> clazz = Class.forName("com.demo.day05.Student");
			//取修饰符为public的构造方法
			/*Constructor<?>[] constructors = clazz.getConstructors();*/
			//取任意修饰符的方法
			Constructor<?>[] constructors = clazz.getDeclaredConstructors();
			for (Constructor<?> c : constructors) {
				System.out.println("构造方法名称==="+c.getName()+",参数个数=="+c.getParameterCount());
			}
			
			//通过构造方法创建对象
			/*constructors[0].setAccessible(true);
			Student st = (Student) constructors[0].newInstance();*/
			
			//调用有参数的构造方法，创建对象
			Student st = (Student) constructors[1].newInstance("赵驰",20);
			System.out.println(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过反射获取类的变量
	 */
	public void test03(){
		try {
			Class<?> clazz = Class.forName("com.demo.day05.Student");
			Constructor<?> c= clazz.getDeclaredConstructor();
			c.setAccessible(true);
			Student st =(Student) c.newInstance();
			//获取修饰符是public的变量
//			Field[] fields = clazz.getFields();
			//获取所有权限修饰符的变量
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				String name = field.getName();
				System.out.println("修饰符=="+Modifier.toString(field.getModifiers())+",变量名称=="+field.getName()+",数据类型"+field.getType());
				if("name".equals(name)){
					//给指定对象的变量赋值
					field.set(st, "赵驰");
				}else if("age".equals(name)){
					field.setAccessible(true);
					field.set(st, 20);
				}
			}
			System.out.println(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void test04(){
		try {
			Class<?> clazz = Class.forName("com.demo.day05.Student");
			//有参数的构造方法
			Constructor<?> constructor = clazz.getConstructor(String.class,int.class);
			Student st = (Student) constructor.newInstance("李经理",20);
//			System.out.println(st);
			Method[] methods = clazz.getDeclaredMethods();
			for (Method m : methods) {
				System.out.println("修饰符=="+Modifier.toString(m.getModifiers())+
						",方法名称=="+m.getName()+",返回值类型=="+m.getReturnType()+
						"参数个数=="+m.getParameterCount());
				//方法名称
				String name = m.getName();
				if("setName".equals(name)){
					//调用setName方法
					m.invoke(st, "赵驰");
				}
			}
			//指定调用某个方法
			/*Method method = clazz.getMethod("setName", String.class);
			method.invoke(st, "张一豪");*/
			System.out.println(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

class Student{
	public String name;
	private int age;
	
	private Student(){
		
	}
	
	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
