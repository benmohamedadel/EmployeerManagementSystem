package com.getarrays.employeermanager.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Employer implements Serializable {
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setEmployerCode(String employerCode) {
        this.employerCode = employerCode;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;

    public Employer() {
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", employerCode='" + employerCode + '\'' +
                '}';
    }

    private String email;

    public Employer(Long id, String name, String email, String jobTitle, String phone, String imageUrl, String employerCode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.employerCode = employerCode;
    }

    private String jobTitle;
    private String phone;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getEmployerCode() {
        return employerCode;
    }

    private String imageUrl;
    @Column(nullable = false,updatable = false)
    private String employerCode;
}
