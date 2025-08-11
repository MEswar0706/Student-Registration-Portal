package com.example.registration.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Registration> registrations;

    public Student() {}
    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
    // Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Set<Registration> getRegistrations() {
		return registrations;
	}
	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}
    
}
