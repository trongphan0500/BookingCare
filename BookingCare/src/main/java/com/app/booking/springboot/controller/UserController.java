package com.app.booking.springboot.controller;

import java.util.Base64;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.booking.springboot.entity.Doctor;
import com.app.booking.springboot.entity.Employee;
import com.app.booking.springboot.entity.Patient;
import com.app.booking.springboot.entity.Role;
import com.app.booking.springboot.entity.User;
import com.app.booking.springboot.entity.model.storeProcedure.UserModal;
import com.app.booking.springboot.request.CRUDLoginRequest;
import com.app.booking.springboot.request.ChangePasswordRequest;
import com.app.booking.springboot.request.CreateUserRequest;
import com.app.booking.springboot.response.BaseListDataResponse;
import com.app.booking.springboot.response.BaseResponse;
import com.app.booking.springboot.response.UserResponseV2;
import com.app.booking.springboot.service.UserService;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;

@RestController
@RequestMapping("api/users")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/change-password", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spUChangePassword(@RequestHeader(value = "authorization") String token,
			@Valid @RequestBody ChangePasswordRequest wrapper) throws Exception {
		BaseResponse response = new BaseResponse();
		User userToken = this.handleTokenAccess(token);

		User user = userService.findOne(userToken.getId());

		if (!(wrapper.getOldPass().equals(user.getPassword()))) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Old Password khong chinh xac");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		String newPass = wrapper.getNewPass();
		user.setPassword(Base64.getEncoder().encodeToString(newPass.getBytes()));
		userService.update(user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/roles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getAllRole(
			@RequestParam(name = "pre_name", required = true, defaultValue = "") String pre) throws Exception {
		BaseResponse response = new BaseResponse();
		List<Role> roles = userService.getAllRole(pre);
		response.setData(roles);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/create", consumes = { "multipart/form-data" })
	public ResponseEntity<BaseResponse> createUser(@RequestHeader(value = "authorization") String token,
			@Valid @ModelAttribute CreateUserRequest wrapper) throws Exception {
		BaseResponse response = new BaseResponse();

		Role role = userService.getRole(wrapper.getRoleId());

		System.out.println(wrapper.getDescription());

		if (role == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Không tìm thấy role tương ứng");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

//		byte[] avatarData = null;
//		try {
//			avatarData = wrapper.getAvatar().getBytes();
////			String avatarName = StringUtils.cleanPath(wrapper.getAvatar().getOriginalFilename());
//		} catch (IOException e) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}

		if (wrapper.getRoleId() == 1) {
			Doctor doctor = new Doctor();
			doctor.setName(wrapper.getName());
			doctor.setEmail(wrapper.getEmail());
			doctor.setPassword("0000");
			doctor.setPhone(wrapper.getPhone());
			doctor.setAddress(wrapper.getAddress());
			doctor.setGender(wrapper.getGender());
			doctor.setRoleId(role.getId());
			doctor.setPosition(wrapper.getPosition());
			doctor.setAvatar(wrapper.getAvatar());
			doctor.setDescription(wrapper.getDescription());
			userService.createDoctor(doctor);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		if (wrapper.getRoleId() == 2) {
			Employee employee = new Employee();
			employee.setName(wrapper.getName());
			employee.setEmail(wrapper.getEmail());
			employee.setPassword("0000");
			employee.setPhone(wrapper.getPhone());
			employee.setAddress(wrapper.getAddress());
			employee.setGender(wrapper.getGender());
			employee.setRoleId(role.getId());
			employee.setPosition(wrapper.getPosition());
			employee.setAvatar(wrapper.getAvatar());
			employee.setDescription(wrapper.getDescription());
			userService.createEmployee(employee);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		if (wrapper.getRoleId() == 5) {
			Patient patient = new Patient();
			patient.setName(wrapper.getName());
			patient.setEmail(wrapper.getEmail());
			patient.setPassword("0000");
			patient.setPhone(wrapper.getPhone());
			patient.setAddress(wrapper.getAddress());
			patient.setGender(wrapper.getGender());
			patient.setRoleId(role.getId());
			patient.setPosition(wrapper.getPosition());
			patient.setAvatar(wrapper.getAvatar());
			patient.setDescription(wrapper.getDescription());
			userService.createPatient(patient);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse<BaseListDataResponse<UserResponseV2>>> getUsers(
			@RequestHeader(value = "Authorization") String token,
			@RequestParam(name = "user_id", required = true, defaultValue = "-1") int userId,
			@RequestParam(name = "key_search", required = true, defaultValue = "") String keySearch,
			@RequestParam(name = "sort_by", required = true, defaultValue = "-1") int sortBy,
			@RequestParam(name = "is_active", required = true, defaultValue = "-1") int isActive,
			@RequestParam(name = "user_define", required = true, defaultValue = "-1") int userDefine,
			@RequestParam(name = "limit", required = true, defaultValue = "-1") int limit,
			@RequestParam(name = "page", required = true, defaultValue = "-1") int page) throws Exception {
		BaseResponse response = new BaseResponse();

		Pagination pagination = new Pagination(page, limit);

		StoreProcedureListResult<UserModal> medicines = userService.getUsers(userId, keySearch, sortBy, isActive,
				userDefine, pagination);
		BaseListDataResponse<UserResponseV2> listData = new BaseListDataResponse<>();
		listData.setList(new UserResponseV2().mapToList(medicines.getResult()));

		listData.setLimit(pagination.getLimit());
		listData.setTotalRecord(medicines.getTotalRecord());

		response.setData(listData);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "{id}/delete", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> deleteUser(@PathVariable("id") int id,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();

		User user = userService.findOne(id);

		if (user == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("User không hợp lệ");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		Role role = userService.getRole(user.getRoleId());

		if (role == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Không tìm thấy role tương ứng");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		if (role.getId() == 1) {
			Doctor doctor = userService.findDoctor(id);
			userService.deleteDoctor(doctor);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		if (role.getId() == 2) {
			Employee employee = userService.findEmployee(id);
			userService.deleteEmployee(employee);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		if (role.getId() == 5) {
			Patient patient = userService.findPatient(id);
			userService.deletePatient(patient);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/{id}/update", consumes = { "multipart/form-data" })
	public ResponseEntity<BaseResponse> updateUser(@PathVariable int id,
			@RequestHeader(value = "authorization") String token, @Valid @ModelAttribute CreateUserRequest wrapper)
			throws Exception {
		BaseResponse response = new BaseResponse();

		Role role = userService.getRole(wrapper.getRoleId());

		System.out.println(wrapper.getAvatar());

		if (role == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Không tìm thấy role tương ứng");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
//		byte[] avatarData = null;
//		if (wrapper.getAvatar() != null) {
//			try {
//				avatarData = wrapper.getAvatar().getBytes();
//				System.out.println(avatarData);
////				String avatarName = StringUtils.cleanPath(wrapper.getAvatar().getOriginalFilename());
//			} catch (IOException e) {
//				e.printStackTrace();
//				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//			}
//		}

		if (wrapper.getRoleId() == 1) {
			Doctor doctor = userService.findDoctor(id);
			doctor.setName(wrapper.getName());
			doctor.setEmail(wrapper.getEmail());
			doctor.setPassword("0000");
			doctor.setPhone(wrapper.getPhone());
			doctor.setAddress(wrapper.getAddress());
			doctor.setGender(wrapper.getGender());
			doctor.setDescription(wrapper.getDescription());
			doctor.setRoleId(role.getId());
			doctor.setPosition(wrapper.getPosition());
			doctor.setAvatar(wrapper.getAvatar());
			userService.update(doctor);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		if (wrapper.getRoleId() == 2) {
			Employee employee = userService.findEmployee(id);
			employee.setName(wrapper.getName());
			employee.setEmail(wrapper.getEmail());
			employee.setPassword("0000");
			employee.setPhone(wrapper.getPhone());
			employee.setAddress(wrapper.getAddress());
			employee.setGender(wrapper.getGender());
			employee.setDescription(wrapper.getDescription());
			employee.setRoleId(role.getId());
			employee.setPosition(wrapper.getPosition());
			employee.setAvatar(wrapper.getAvatar());
			userService.update(employee);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		if (wrapper.getRoleId() == 5) {
			Patient patient = userService.findPatient(id);
			patient.setName(wrapper.getName());
			patient.setEmail(wrapper.getEmail());
			patient.setPassword("0000");
			patient.setPhone(wrapper.getPhone());
			patient.setDescription(wrapper.getDescription());
			patient.setAddress(wrapper.getAddress());
			patient.setGender(wrapper.getGender());
			patient.setRoleId(role.getId());
			patient.setPosition(wrapper.getPosition());
			patient.setAvatar(wrapper.getAvatar());
			userService.update(patient);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/login", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse<BaseListDataResponse<UserModal>>> spULogin(
			@Valid @RequestBody CRUDLoginRequest w) throws Exception {
		BaseResponse response = new BaseResponse();

		response.setStatus(userService.spULogin(w.getEmail(), w.getPassword()).getStatusCode());
		response.setMessageError(userService.spULogin(w.getEmail(), w.getPassword()).getMessageError());
		if (userService.spULogin(w.getEmail(), w.getPassword()).getStatusCode() == 0) {
			response.setData(userService.findByEmail(w.getEmail()));
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
