package com.springboot.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "interviewer")
public class Interviewer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "intervieweeId")
    private Interviewee interviewee;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    
    @Temporal(TemporalType.DATE)
	@Column(name = "interviewDate", nullable = false)
	private String interviewDate;
}
