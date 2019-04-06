package com.chainsys.realestate.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

@Entity
@Table(name = "RL_EST_LAND_USER")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "rl_est_user_id_seq")
	@Column(name = "user_id", updatable = false, nullable = false)
	private long id;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "email", unique = true)
	@NotNull
	private String email;

	@Column(name = "password")
	@NotNull
	private String password;

	@Column(name = "phonenumber")
	@NotNull
	private long mobilenumber;

	@Column(name = "createddate")
	private LocalDateTime createdDate;

	@JoinColumn(name = "user_id")
	@Column(name = "modifiedby")
	private long modifiedBy;

	@Column(name = "modifieddate")
	private LocalDateTime modifiedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		if (id > 0)
			this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String stringRegex = "^([a-zA-Z]+)$";
		if (name != null && !name.isEmpty() && name.matches(stringRegex))
			this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		String emailRegex = "^([a-zA-Z0-9]+)@([a-zA-Z]+).([a-z]{2,3})$";
		if (email != null && !email.isEmpty() && email.matches(emailRegex))
			this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		String passwordRegex = "^([a-zA-Z0-9$@]+)$";
		if (password != null && !password.isEmpty()
				&& password.matches(passwordRegex))
			this.password = password;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		String numberRegex = "^([0-9]+)$";
		String mbleno = String.valueOf(mobilenumber);
		if (mbleno.length() == 10 && mbleno.matches(numberRegex))
			this.mobilenumber = mobilenumber;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	@JoinColumn(name = "user_id")
	public long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", mobilenumber=" + mobilenumber
				+ ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy
				+ ", modifiedDate=" + modifiedDate + "]";
	}

}
