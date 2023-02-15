package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class controller {
	
	@Autowired
	FetchDataService fetchDataService;

	@GetMapping("/getdata")
	List<demo>getUsers()
	{
		return fetchDataService.findAll(); 
	}
	
	@PostMapping("/post")
    public demo create(@RequestBody demo d) {
        return fetchDataService.save(d);
    }
	@PutMapping("/put")  
	public demo update(@RequestBody demo d)   
	{  
		fetchDataService.save(d);  
		return d;  
	}  
	@DeleteMapping("/delete/{employeeid}")  
	public void deleteBook(@PathVariable("employeeid") int employeeid)   
	{  
		fetchDataService.deleteById(employeeid);  
	}  
	
	
	
	
}