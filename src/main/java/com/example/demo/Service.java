package com.example.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
public class Service {
  @Autowired
  DAO dao;
  @GetMapping("/")
  public String fun1() {
    return "This is home page";
  }
  @GetMapping("/welcome/{name}")
  public String fun1(@PathVariable String name) {
    return "welcome"+"  "+name;
  }
  
  @PostMapping("/user")
  //requestbody to get all data
    public String fun3(@RequestBody User user) {
    dao.insert(user);
      return "User inserted";
    }
  @GetMapping("/user")
//  @RequestMapping(value = "/user",method = RequestMethod.GET)//and method type it takes
  //requestparam is means ? queryparam in ep
    public String fun4(@RequestParam("email") String email) {
      
    return dao.findUser(email).toString();
      
    }
  
  
  @GetMapping("/all")
  public List<User> fun6() {
    return dao.find();
    
  }
  
  @GetMapping("/page")
  public String fun5() {
    return dao.findPage().toString();
  }
  
  @GetMapping("/delete")
  public String fun7(@RequestParam("email") String email) {
	return dao.deleteUser(email);
	  
	  
  }
  
  
}