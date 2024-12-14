package dam.co.dig.system.access.dto;

import java.util.List;

public class UserInfoListDto {
	
	private List<UserResponseDto> userList;

	public List<UserResponseDto> getUserList() {
		return userList;
	}

	public void setUserList(List<UserResponseDto> userList) {
		this.userList = userList;
	}
	
	

}
