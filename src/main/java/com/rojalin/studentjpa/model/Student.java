package com.rojalin.studentjpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student 

{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String firstname;
   private String lastname;
   private String course;
   private String country;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
   
   
}
