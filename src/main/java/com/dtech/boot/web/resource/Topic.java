package com.dtech.boot.web.resource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

	@Id
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
}
