package com.example.registration.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String schedule;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<Registration> registrations;

    public Course() {}
    public Course(String code, String name, String schedule) {
        this.code = code;
        this.name = name;
        this.schedule = schedule;
    }
    // Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public Set<Registration> getRegistrations() {
		return registrations;
	}
	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}
    
}
