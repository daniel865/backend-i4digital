package com.i4digital.prueba.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="users", schema = "public")
public class User implements Serializable{

	private static final long serialVersionUID = -4495422464011768934L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Integer id;
	
	@Column(name = "username", unique = true, length = 100, nullable = false)
	private String username;
	
	@JsonIgnore
	@Column(name = "password", length = 200, nullable = false)
	private String password;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static User from(User user) {
		return new UserBuilder()
				.setId(user.getId())
				.setUsername(user.getUsername())
				.setPassword(user.getPassword())
				.setEmail(user.getEmail())
				.build();
	}

	public static User from(User user, String password) {
		return new UserBuilder()
				.setId(user.getId())
				.setUsername(user.getUsername())
				.setPassword(password)
				.setEmail(user.getEmail())
				.build();
	}

	private User(UserBuilder builder) {
		this.id = builder.id;
		this.username = builder.username;
		this.password = builder.password;
		this.email = builder.email;
	}

	public static class UserBuilder {
		private Integer id;
		private String username;
		private String password;
		private String email;

		public UserBuilder() {
		}

		public UserBuilder(Integer id, String username, String password, String email) {
			this.id = id;
			this.username = username;
			this.password = password;
			this.email = email;
		}

		public UserBuilder setId(Integer id) {
			this.id = id;
			return this;
		}

		public UserBuilder setUsername(String username) {
			this.username = username;
			return this;
		}

		public UserBuilder setPassword(String password) {
			this.password = password;
			return this;
		}

		public UserBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}


}

