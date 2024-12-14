package dam.co.dig.system.access.constant;

public class UserConstant {

	public static String ACCESS_TOKEN_VALIDATE_VALUE = "Client-Employees-Access-Token";
	public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

	public static String INVALID_EMP_NAME = "Employee name should be Mandatory!";
	public static String INVALID_EMP_EMAIL = "Employee email should be Mandatory!";
	public static String INVALID_EMP_EMAIL_fORMAT = "Invalid email Format";
	public static String INVALID_OR_EXPIRED_TOKEN = "Access Token Expired or Invalid";
	public static String DATA_NOT_FOUND = "Employee Not Found.";
	public static String DATA_NOT_SAVED = "Data could not be Saved.";
	public static String EMPLOYEE_ADDED = "Employee Added";
	public static String INVALID_EMPLOYEE_ID = "Invalid employee Id.";
    public static String ADMIN_ROLE = "admin";
    public static String DATA_NOT_DELETED = "You do not have permission to delete this record.";
    public static String DATA_DELETED = "Record deleted sucessfully.";
    public static final String EMPLOYEE_UPDATED = "Record updated sucessfully.";
}
