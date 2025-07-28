package com.test.sampleCRUDOperation.controllerCRUDOper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.sampleCRUDOperation.ModelCURDOper.MyBook;
import com.test.sampleCRUDOperation.ServiceCURDOper.CurdOperationsService;

@RestController
@RequestMapping("/crudOper")
public class CrudOperationsController
{
	private CurdOperationsService curdOperationsService;
	
	@Autowired//constructor injection
	public void CrudOperationsController(CurdOperationsService curdOperationsService)
	{
		this.curdOperationsService = curdOperationsService;
	}
	
	@PostMapping("/addBook")
	public MyBook addNewBook(@RequestBody MyBook myBook)
	{
		MyBook savedMyBook = curdOperationsService.addBooks(myBook);
		return savedMyBook;
	}
	
	@GetMapping("/findAllBookDetails")
	public List<MyBook> finsAllBookDetails()
	{
		return curdOperationsService.findAllbooks();
	}

	@GetMapping("/findBookById")
	public MyBook findBookById(@RequestParam Long bookId)
	{
		return curdOperationsService.findBookById(bookId);
	}
	
	@GetMapping("/findByAuthorAndType/{author}/{bookType}")
	private List<MyBook> findBookByAuthorAndType(@PathVariable String author, @PathVariable String bookType)
	{
		return curdOperationsService.findBookByAuthorAndType(author, bookType);
	}
	
	@PostMapping("/addBooks")
	public List<MyBook> addBooks(@RequestBody List<MyBook> myBooks)
	{
		return curdOperationsService.saveBooks(myBooks);
	}
	
	@PutMapping("/updateBook")
	public MyBook updateBook(@RequestBody MyBook myBook)
	{
		return curdOperationsService.updateBookDetails(myBook);
	}
		
	@GetMapping("/finByAuthAndPublisher")
	public List<MyBook> findByAuthorAndPublisher(@RequestParam String author, @RequestParam String publisher)
	{
		return curdOperationsService.findBookByAuthorAndPublisher(author, publisher);
	}
	
	@GetMapping("/findByBookType/{myBookType}")
	public List<MyBook> findBybookType(@PathVariable String myBookType)
	{
		return curdOperationsService.findByBookTypeUsingStream(myBookType);
	}
}
