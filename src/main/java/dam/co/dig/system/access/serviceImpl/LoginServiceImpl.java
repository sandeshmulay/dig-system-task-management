package dam.co.dig.system.access.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam.co.dig.system.access.repository.RoleRepository;
import dam.co.dig.system.access.repository.TaskRepository;
import dam.co.dig.system.access.repository.UserRepository;
import dam.co.dig.system.access.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService  {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	public void addEmployee(String accessToken,  )
}
