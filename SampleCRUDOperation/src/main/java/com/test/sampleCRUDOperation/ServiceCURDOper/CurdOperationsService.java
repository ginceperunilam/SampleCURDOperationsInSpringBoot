package com.test.sampleCRUDOperation.ServiceCURDOper;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sampleCRUDOperation.ModelCURDOper.MyBook;
import com.test.sampleCRUDOperation.RepositoryCURDOper.CurdOperationsRepository;

@Service
public class CurdOperationsService
{
	@Autowired
	CurdOperationsRepository curdOperationsRepository;//field injection
	
	public MyBook addBooks(MyBook myBook)
	{
		return curdOperationsRepository.save(myBook);
	}

	public List<MyBook> findAllbooks()
	{
		return 	curdOperationsRepository.findAll();
	}

	public MyBook findBookById(Long bookId)
	{
		Optional<MyBook> myBook = curdOperationsRepository.findById(bookId);
		if(myBook != null && myBook.isPresent())
		{
			return myBook.get();
		}
		return null;
	}

	public List<MyBook> findBookByAuthorAndType(String author, String bookType)
	{
		return curdOperationsRepository.findByAuthorAndBookType(author, bookType);
	}

	public List<MyBook> saveBooks(List<MyBook> myBooks)
	{
		return curdOperationsRepository.saveAll(myBooks);
	}

	public MyBook updateBookDetails(MyBook myBook)
	{
		return curdOperationsRepository.save(myBook);
	}

	public List<MyBook> findBookByAuthorAndPublisher(String author, String publisher)
	{
		return curdOperationsRepository.findByAuthorAndPublisher(author, publisher);
	}

	public List<MyBook> findByBookTypeUsingStream(String bookType)
	{
		List<MyBook> myBooks = findAllbooks();
		
		//Method 1
		List<MyBook> booksByType = 
				myBooks.stream()
				.filter(Objects :: nonNull)//check whether the object is null or not
				//simply we can check null
				.filter(myBook -> myBook.getBookType() != null && myBook.getBookType().equals(bookType)).collect(Collectors.toList());
		
		//optional with filter
		List<MyBook> booksByType1 = myBooks.stream()
				.filter(mybk -> Optional.ofNullable(mybk.getBookType())
				.filter(type -> type.equals(bookType))
				.isPresent())
				.collect(Collectors.toList());
		
		//filter and map
		List<MyBook> booksByType2 = myBooks.stream()
				.filter(mybk -> Optional.ofNullable(mybk.getBookType())
				.map(type -> type.equals(bookType))
				.orElse(false))
				.collect(Collectors.toList());
		
		return booksByType2;
	}

}
