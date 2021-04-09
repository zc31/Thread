package com.hxzy;

import java.util.Scanner;

public class Water {
	public static void main(String[] args) {
		int money = 20;
		int number = 0;
		int cap = 0;
		int water = 0;
		int water2 = water(money, number,cap, water);
		System.out.println(money + "元钱一共能喝" + water2 + "瓶汽水！");
	}

	public static int water(int money, int number,int cap, int water) {
		water += money;
		cap += water;
		number += water;
		water = 0;
		money = 0;
		if (cap < 3) {
			return number;
		} else {
			return water(money, number,cap % 3, cap/3);
		}

	}

}
