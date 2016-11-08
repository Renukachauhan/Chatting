package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="C_User_Details")
@Component
public class User extends BaseDomain{
	@Id
private String userId;
private String name;
private String email;
private String address;
private String mobile;
private String role;
private String password;
private char status;
private String reason;

public char getStatus() {
	return status;
}
public void setStatus(char status) {
	this.status = status;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public char getIsOnline() {
	return isOnline;
}
public void setIsOnline(char isOnline) {
	this.isOnline = isOnline;
}
public char getIsOffline() {
	return isOffline;
}
public void setIsOffline(char isOffline) {
	this.isOffline = isOffline;
}
@Column(name="is online")
private char isOnline;
@Column(name="is offline")
private char isOffline;
}
