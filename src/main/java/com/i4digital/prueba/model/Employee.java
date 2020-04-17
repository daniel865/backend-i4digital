package com.i4digital.prueba.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="employees", schema="public")
public class Employee implements Serializable{

	
	private static final long serialVersionUID = 8023783657692212299L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Integer id;
	
	@Column(name = "name", length = 100)
	private String name;
	
	@Column(name = "surname", length = 100)
	private String surname;
	
	@Column(name = "occupation", length = 50)
	private String occupation;
	
	@Column(name = "phone", length = 20)
	private String phone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user", referencedColumnName = "id")
	private User user;

	public Employee() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static Employee from(Employee employee) {
		return new Employee.EmployeeBuilder()
				.setId(employee.getId())
				.setName(employee.getName())
				.setSurname(employee.getSurname())
				.setOccupation(employee.getOccupation())
				.setPhone(employee.getPhone())
				.setUser(employee.getUser())
				.build();
	}

	public static Employee from(Employee employee, User user) {
		return new Employee.EmployeeBuilder()
				.setId(employee.getId())
				.setName(employee.getName())
				.setSurname(employee.getSurname())
				.setOccupation(employee.getOccupation())
				.setPhone(employee.getPhone())
				.setUser(user)
				.build();
	}
	
	private Employee(EmployeeBuilder builder) {
		this.id  = builder.id;
		this.name = builder.name;
		this.surname = builder.surname;
		this.occupation = builder.occupation;
		this.phone = builder.phone;
		this.user  = builder.user;
	}

	public static class EmployeeBuilder {
		private Integer id;
		private String name;
		private String surname;
		private String occupation;
		private String phone;
		private User user;

		public EmployeeBuilder() {
		}

		public EmployeeBuilder(Integer id, String name, String surname, String occupation, String phone, User user) {
			this.id = id;
			this.name = name;
			this.surname = surname;
			this.occupation = occupation;
			this.phone = phone;
			this.user = user;
		}

		public EmployeeBuilder setId(Integer id) {
			this.id = id;
			return this;
		}

		public EmployeeBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public EmployeeBuilder setSurname(String surname) {
			this.surname = surname;
			return this;
		}

		public EmployeeBuilder setOccupation(String occupation) {
			this.occupation = occupation;
			return this;
		}

		public EmployeeBuilder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public EmployeeBuilder setUser(User user) {
			this.user = user;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}
	}

}
