package com.sample.demo;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.model.User;

@RestController
@RequestMapping("/rest/user")
public class UserResource  {

	private UserRepository userRepository;
	
	public UserResource(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	@GetMapping("/add/{id}/{name}")
	public User add(@PathVariable("id") final String id,@PathVariable("name") final String name)
	{
	userRepository.save(new User(id,name,1000L));	
	return userRepository.findById(id);
	}
	
	@GetMapping("/update/{id}/{name}")
	public User update(@PathVariable("id") final String id,@PathVariable("name") final String name)
	{
	userRepository.update(new User(id,name,2000L));	
	return userRepository.findById(id);
	}
	@GetMapping("/all")
	
		public Map<String,User> update()
		{
		return userRepository.findAll();
		}
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable final String id)
	{
		userRepository.delete(id);
	}
	
}
