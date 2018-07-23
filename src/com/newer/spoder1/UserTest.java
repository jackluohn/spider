package com.newer.spoder1;

public class UserTest {
	public static void main(String[] args) {
		User user = new User.Builder()
						.setAge(10)
						.setName("bob")
						.build();
	}
}
