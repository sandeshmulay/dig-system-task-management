package dam.co.dig.system.access.util;

import java.util.Objects;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import dam.co.dig.infra.exception.EmployeeInvalidDataException;
import dam.co.dig.infra.exception.EmployeeMandatoryFieldException;
import dam.co.dig.system.access.constant.UserConstant;
import dam.co.dig.system.access.dto.UserRequestDto;

public class RequestValidation {

	public static void userValidation(UserRequestDto employeeRequest) {

		validateMandatorySpecification(employeeRequest);
		isValidEmail(employeeRequest.getEmail());

	}

	private static void validateMandatorySpecification(UserRequestDto employeeRequest) {

		if (StringUtils.isEmpty(employeeRequest.getFirstName())) {
			throw new EmployeeMandatoryFieldException(UserConstant.INVALID_EMP_NAME);
		} else if (StringUtils.isEmpty(employeeRequest.getLastName())) {
			throw new EmployeeMandatoryFieldException(UserConstant.INVALID_EMP_NAME);
		} else if (StringUtils.isEmpty(employeeRequest.getEmail())) {
			throw new EmployeeMandatoryFieldException(UserConstant.INVALID_EMP_EMAIL);
		}

	}

	private static void isValidEmail(String email) {
		Pattern pattern = Pattern.compile(UserConstant.EMAIL_REGEX);
		if (!pattern.matcher(email).matches()) {
			throw new EmployeeInvalidDataException(UserConstant.INVALID_EMP_EMAIL_fORMAT);
		}

	}

	public static void validateEmployeeId(Integer id) {

		if (Objects.isNull(id) || id == 0) {
			throw new EmployeeInvalidDataException(UserConstant.INVALID_EMPLOYEE_ID);
		}

	}

}
