package com.promineotech;

import java.util.Random;

public class TestDemo {
	public int addPositive(int a, int b) {
		
		if(a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
		
		
		int subtractSmallFromBig(int a, int b) {
			if (a > b) {
				return a - b;
			} else {
				throw new IllegalArgumentException("The 1st parameter must be greater than the 2nd parameter!");
			}
			
		}
		
		public int randomNumberSquared() {
			int num = getRandomInt();
			return num * num;
		}
		
		int getRandomInt() {
			Random random = new Random();
			return random.nextInt(10) + 1;
		}
}

