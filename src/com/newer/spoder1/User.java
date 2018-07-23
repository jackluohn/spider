package com.newer.spoder1;

/**
 * Builder模式
 * @author ZX
 *
 */
public class User {

	public static void main(String[] args) {
		User u1 = new User();
	}
	
	String name;
	int age;
	String phone;
	String email;
	String address;
	
	private User() {
	}
	
	//替代构造方法,构造器模式
	public static class Builder{
		
		String name;
		int age;
		String phone;
		String email;
		String address;
		
		public Builder() {
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setAge(int age) {
			this.age = age;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		
		public Builder setPhone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}
		
		public User build() {
			User u = new User();
			u.age = age;
			u.name = name;
			u.phone = phone;
			u.email = email;
			u.address = address;
			
			return u;
		}
	}
}
