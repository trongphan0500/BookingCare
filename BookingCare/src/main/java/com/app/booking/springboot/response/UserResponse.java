package com.app.booking.springboot.response;
//package com.app.booking.spirngboot.response;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import com.app.booking.spirngboot.entity.User;
//
//public class UserResponse {
//
//	private int id;
//	
//	private String name;
//	
//	private String address;
//	
//	public UserResponse() {
//	}
//
//	
//	
//	public UserResponse(User entity) {
//		this.id = entity.getId();
//		this.name = entity.getName();
//		this.address = entity.getAddress();
//	}
//
//	public List<UserResponse> mapToList(List<User> entiies) {
//		return entiies.stream().map(x -> new UserResponse(x)).collect(Collectors.toList());
//	}
//
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	
//	
//}
