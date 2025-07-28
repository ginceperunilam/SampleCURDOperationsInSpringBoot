package com.test.sampleCRUDOperation.ModelCURDOper;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//Marks the class as a JPA entity (mapped to a table).
@Table(name = "MY_BOOK")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyBook
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private Long id;
	@Column(name="REF_CODE", nullable=false, unique=true)
	private Long refCode;
	@Column(name="BOOK_NAME", nullable = false, unique=true)
	private String bookName;
	@Column(name="ISSUE_DATE", nullable=false)
	private Date issueDate;
	@Column(name="AUTHOR", nullable=false)
	private String author;
	@Column(name="PUBLISHER")
	private String publisher;
	@Column(name="BOOK_TYPE")
	private String bookType;
}
