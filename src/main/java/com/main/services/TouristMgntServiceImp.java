package com.main.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Tourist;
import com.main.repository.ITouristRepository;

@Service("touristService")
public class TouristMgntServiceImp implements ITouristMgntService 
{
    @Autowired
	private ITouristRepository repo;
    
	@Override
	public String registerTourist(Tourist tourist) 
	{
	      int tid =  repo.save(tourist).getTid();	 
		return "Tourist record is created with id-"+tid;
	}

	@Override
	public String registerAllTourist(List<Tourist> touristList) 
	{
		 List<Tourist> tList = repo.saveAll(touristList);
		 List<Integer> tIds = tList.stream().map(t->t.getTid()).collect(Collectors.toList());
		 
		return "Bulk of tourist is created with ids-"+tIds.toString();
	}

	@Override
	public List<Tourist> getAllTouristDetails()
	{
		 
		return repo.findAll();
	}

	@Override
	public Tourist getTouristById(Integer id) 
	{
		Optional<Tourist> opt = repo.findById(id);
		Tourist t = null;
		if(opt.isPresent())
		{
			t = opt.get();
		}
		
		return t;
	}

	@Override
	public String updateTourist(Tourist tourist)
	{
		Optional<Tourist> opt = repo.findById(tourist.getTid());
		if(opt.isPresent())
		{
			repo.save(tourist);
			
			return "Tourist record is updated with id-"+tourist.getTid();
		}
		else
		{
			return "Tourist is not found this id-"+tourist.getTid();
		}
		
	}

	@Override
	public List<Tourist> getTouristByName(String name) 
	{
		     
		return repo.findByName(name);
	}

	@Override
	public String updateTouristBudgetById(Integer id, Double hikePercentage)
	{
		  Optional<Tourist> opt = repo.findById(id);
		  if(opt.isPresent())
		  {
			  Tourist t = opt.get();
			  Double newBudget = t.getBudget()+(t.getBudget()*hikePercentage/100);
			  t.setBudget(newBudget);
			  repo.save(t);
			  
			  return "Tourist budget is updated with id-"+id+" and NewBudget is-"+newBudget;
		  }
		  else
		  {
			  return "Tourist is not found this id-"+id;
		  }
		
	}

	@Override
	public String removeTouristById(Integer id) 
	{
		 Optional<Tourist> opt = repo.findById(id);
		 if(opt.isPresent())
		 {
			 repo.deleteById(id);
			 
			 return "Tourist record is deleted with the id-"+id;
		 }
		 else
		 {
			 return "Tourist record is not found this id-"+id;
		 }
		
	}

	@Override
	public String removeTouristByBudgetRange(Double start, Double end) 
	{
		int i = repo.removeToristByBudgetRange(start, end);
		
		return i+" records got deleted";
	}

}
