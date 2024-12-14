package dam.co.dig.system.access.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dam.co.dig.system.access.constant.UserConstant;
import dam.co.dig.system.access.dto.UserInfoListDto;
import dam.co.dig.system.access.dto.UserRequestDto;
import dam.co.dig.system.access.dto.UserResponseDto;
import dam.co.dig.system.access.service.UserManagementService;
import dam.co.dig.system.access.util.RequestValidation;

@RestController
@RequestMapping("/user")
public class UserManagementController {

	private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);

	@Autowired
	private UserManagementService userManagementService;

	@PostMapping
	public ResponseEntity<String> createEmployee(@RequestBody UserRequestDto userRequestDto) {
		logger.info("Received request to create employee : {}");

		try {
			RequestValidation.employeeValidation(userRequestDto);
			userManagementService.addEmployee(userRequestDto);
			logger.info("Employee created successfully: {}", userRequestDto);
			return new ResponseEntity<>(UserConstant.EMPLOYEE_ADDED, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error occurred while creating employee: {}", e.getMessage(), e);
			throw e;
		}
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserResponseDto> getEmployeeInformation(@PathVariable Integer userId) {
		logger.info("Received request to get information for employee ID: {}", userId);

		try {
			RequestValidation.validateEmployeeId(userId);
			UserResponseDto response = userManagementService.getUserInfo(userId);
			logger.info("Retrieved employee information for ID: {}", userId);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error occurred while retrieving employee information for ID: {}: {}", userId, e.getMessage(),
					e);
			throw e;
		}
	}

	@GetMapping("/userList")
	public ResponseEntity<UserInfoListDto> getUserInfoList() {
		logger.info("Received request to get information for employee");

		try {

			UserInfoListDto response = userManagementService.getUserInfoList();
			logger.info("Retrieved employee information");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error occurred while retrieving employee information", e.getMessage(), e);
			throw e;
		}
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer userId) {
		logger.info("Received request to delete information for employee ID: {}", userId);

		try {

			RequestValidation.validateEmployeeId(userId);
			userManagementService.deleteEmployee(userId);
			logger.info("Deleted employee information for ID: {}", userId);
			return new ResponseEntity<>(UserConstant.DATA_DELETED, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error occurred while deleting employee information for ID: {}", userId, e.getMessage(), e);
			throw e;
		}
	}
}
