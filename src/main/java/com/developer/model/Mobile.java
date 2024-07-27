package com.developer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_mobile")
public class Mobile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mobile_id")
	private Long id;

	@Column(name = "mobile_name", nullable = false, length = 50)
	private String mobileName;

	@OneToOne(mappedBy = "mobile")
	@JsonBackReference
	private Employee employee;

}
