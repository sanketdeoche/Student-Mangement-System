package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity

public class Batch {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int batchid;

	private String name;

	private String mode;

	private LocalDate time;

	private String startdate;

	private String enddate;

	public String getStartdate() {

		return startdate;

	}

	public Course getCourse() {

		return course;

	}

	public void setCourse(Course course) {

		this.course = course;

	}

	public void setStartdate(String startdate) {

		this.startdate = startdate;

	}

	public String getEnddate() {

		return enddate;

	}

	public void setEnddate(String enddate) {

		this.enddate = enddate;

	}

	@ManyToMany(mappedBy = "batches")

	@JsonIgnore

	private List<Trainer> trainers;

	@ManyToOne

	@JoinColumn(name = "course_id") // simple and standard

	private Course course;

	public int getBatchid() {

		return batchid;

	}

	public void setBatchid(int batchid) {

		this.batchid = batchid;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getMode() {

		return mode;

	}

	public void setMode(String mode) {

		this.mode = mode;

	}

	public LocalDate getTime() {

		return time;

	}

	public void setTime(LocalDate time) {

		this.time = time;

	}

	public List<Trainer> getTrainer() {

		return trainers;

	}

	public void setTrainer(List<Trainer> trainer) {

		this.trainers = trainer;

	}

}