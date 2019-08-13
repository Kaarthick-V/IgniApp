package com.mbhit.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.mbhit.entity.User;
import com.mbhit.service.ILoginService;

@Controller
@RequestMapping("login")
public class LoginController {
@Autowired
private ILoginService loginService;
@GetMapping(path = "/logincheck")
@ResponseBody
public ResponseEntity<User> CheckLogin(@RequestParam String userName, @RequestParam String password) {
	ResponseEntity<User> response;
	User loggeduser=loginService.CheckUser(userName,password);
	if(loggeduser!=null) {
		response=new ResponseEntity<User>(loggeduser,HttpStatus.OK);
	}
	else {
		response=new ResponseEntity<User>(loggeduser,HttpStatus.FORBIDDEN);

	}
	return response;
}

@PostMapping("Register")
public ResponseEntity<Void> Register(@RequestBody User user, UriComponentsBuilder builder) {
    boolean flag = loginService.addUser(user);
    if (flag == false) {
    	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
     return new ResponseEntity<Void>(HttpStatus.CREATED);
}

}

