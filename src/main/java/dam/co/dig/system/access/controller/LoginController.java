package dam.co.dig.system.access.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import dam.co.dig.system.access.service.LoginService;

@RestController
public class LoginController {
	
    @Autowired
	private LoginService loginService;
    
    @PostMapping
    
}
