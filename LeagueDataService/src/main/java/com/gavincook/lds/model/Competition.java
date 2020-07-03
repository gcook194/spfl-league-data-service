package com.gavincook.lds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "competition")
public class Competition {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
	
	@Column(name="resource_id")
	private Long resourceId; // ID within the RapidAPI service 
	
	@Column(name="name")
	private String name;  
	
	@Column(name="type")
	private String type; 
	
	@Column(name="logo_url")
	private String logo;
}
