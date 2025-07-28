package com.test.sampleCRUDOperation.RepositoryCURDOper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.sampleCRUDOperation.ModelCURDOper.MyBook;

public interface CurdOperationsRepository extends JpaRepository<MyBook, Long>
{

	public List<MyBook> findByAuthorAndBookType(String author, String bookType);

	public List<MyBook> findByAuthorAndPublisher(String author, String publisher);

	public List<MyBook> findByBookType(String bookType);

}
