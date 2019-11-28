package com.ustglobal.jpawithhibernateapp.onetoone;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="person")

public class Person {

	@Column
	@Id
	private int pid;
	
	@Column
	private String pname;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="vid")
	private VoterCard voterCard;
	
}
