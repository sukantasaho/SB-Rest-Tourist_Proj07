package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Tourist;
import com.main.services.ITouristMgntService;

@RestController
@RequestMapping("/tourist/api")
public class TouristController 
{
	@Autowired
    private ITouristMgntService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist)
	{
		try
		{
			String msg = service.registerTourist(tourist);
			
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Problem in tourist enrollment.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@PostMapping("/addTouristList")
	public ResponseEntity<String> registerAllTourist(@RequestBody List<Tourist> tList)
	{
		try
		{
			String msg = service.registerAllTourist(tList);
			
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Problem in tourist enrollment",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/getAllTouristDetails")
	public ResponseEntity<?> getAllTouristDetails()
	{
		
		try
		{
			List<Tourist> list = service.getAllTouristDetails();
			
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Problem with fetching tourist details",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/getTouristById/{id}")
	public ResponseEntity<?> getTouristById(@PathVariable Integer id)
	{
		
		try
		{
			Tourist t = service.getTouristById(id);
			
			return new ResponseEntity<Tourist>(t,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Problem with fetching tourist detail",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/modify")
	public ResponseEntity<?> modifyTourist(@RequestBody Tourist tourist)
	{
		try
		{
			String msg = service.updateTourist(tourist);
			return new ResponseEntity<String>(msg,HttpStatus.OK); 
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
	}
	@GetMapping("/getTouristByName/{name}")
	public ResponseEntity<?> getTouristByName(@PathVariable String name)
	{
		try
		{
			  List<Tourist> tList = service.getTouristByName(name);
			  
			  return new ResponseEntity<List<Tourist>>(tList, HttpStatus.OK);
		}
		catch(Exception e)
		{
			 return new ResponseEntity<String>("Problem with fetching operation", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PatchMapping("/partialUpdate/{id}/{hikePercentage}")
	public ResponseEntity<String> updateTouristBudgetById(@PathVariable Integer id, @PathVariable Double hikePercentage)
	{
		try
		{
			String msg = service.updateTouristBudgetById(id, hikePercentage);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeTourist(@PathVariable Integer id)
	{
		try 
		{
			  String msg = service.removeTouristById(id);
			  return new ResponseEntity<String>(msg,HttpStatus.OK);
		} 
		catch (Exception e)
		{ 
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete/{start}/{end}")
	public ResponseEntity<String> removeTouristByBudgetRange(@PathVariable Double start, @PathVariable Double end) 
	{
		try 
		{
			 String msg = service.removeTouristByBudgetRange(start, end);
			  return new ResponseEntity<String>(msg,HttpStatus.OK);
		} 
		catch (Exception e)
		{ 
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
