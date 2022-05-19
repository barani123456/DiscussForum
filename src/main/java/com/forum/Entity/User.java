package com.forum.Entity;
public class User {
	int id;
/*	@NotEmpty(message="user name should not be blank")*/
	String name;
	//@Size(min=3,max=15,message="password must be 3 and 15")
	String password;
	//@Email (message="password must be 3 and 15")
	String email;
	Role role;
	String pic;

	public User(int id, String name, String password, String email, Role role, String pic) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
		this.pic = pic;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public User() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", role=" + role
				+ ", pic=" + pic + "]";
	}

	public User(int id, String name, String password, String email, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
	}






}
