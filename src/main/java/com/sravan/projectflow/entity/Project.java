package com.sravan.ProjectFlow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private String description;
    private LocalDate deadline;

    public Project(){}
    public Project(String title,String description, LocalDate deadline){
        this.title=title;
        this.description=description;
        this.deadline=deadline;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getTitle(){return title;}
    public void setTitle(String title){
        this.title=title;
    }

    public String getDescription(){return description;}
    public void setDescription(String description){
        this.description=description;
    }

    public LocalDate getDeadline(){return deadline;}
    public void setDeadline(LocalDate deadline){
        this.deadline=deadline;
    }
}
