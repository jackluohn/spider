package com.newer.copy;

public class UserTest {

	public static void main(String[] args) {
		
		
		User u1 = new User.Builder("bob")
				.setAddress("")
				.setAge(21)
				.setEmail("")
				.setPhone("")
				.build();
		
		User u2 = new User.Builder("jack")
				.setPhone("")
				.build();
		
	}
}
