package com.app.booking.springboot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.app.booking.springboot.request.UploadAvatarRequest;
import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.booking.springboot.MyReceiver;
import com.app.booking.springboot.ReceiverSA;
import com.app.booking.springboot.dao.OrderDao;
import com.app.booking.springboot.entity.ExamninationHistory;
import com.app.booking.springboot.entity.Medicine;
import com.app.booking.springboot.entity.Order;
import com.app.booking.springboot.entity.OrderMediceneDetail;
import com.app.booking.springboot.entity.OrderServiceDetail;
import com.app.booking.springboot.entity.Patient;
import com.app.booking.springboot.entity.Service;
import com.app.booking.springboot.entity.Specialization;
import com.app.booking.springboot.response.BaseListDataResponse;
import com.app.booking.springboot.response.BaseResponse;
import com.app.booking.springboot.response.SpecializationResponse;
import com.app.booking.springboot.service.DoctorService;
import com.app.booking.springboot.service.ExaminitionHistoryService;
import com.app.booking.springboot.service.MedicineService;
import com.app.booking.springboot.service.OrderDetailService;
import com.app.booking.springboot.service.OrderServiceDetailsService;
import com.app.booking.springboot.service.SpecializtionService;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;

@RestController
@RequestMapping("api/doctors")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class DoctorController {

	
	
	MyReceiver buong1;
	MyReceiver buong2;
	ReceiverSA buong1SA;
	@Autowired
	private DoctorService doctorService;

	@Autowired
	private SpecializtionService specializtionService;
	
	@Autowired
	private MedicineService medicineService;
	@Autowired
	ExaminitionHistoryService examinitionHistoryService;
	@Autowired
	OrderDao orderDao;

	@Autowired
	OrderDetailService detailService;
	@Autowired
	OrderServiceDetailsService servicedetailService;
	@PostMapping("/openBuong")
	public int openBuong() throws NamingException, JMSException
	{
		if(buong1==null)
		{
			System.out.println("mo buong 1");
			buong1= new MyReceiver();
			return 1;
		}
		else if(buong2==null)
		{
			System.out.println("mo buong 2");
			buong2= new MyReceiver();
			return 2;
		}
		else {
			System.out.println("full buong");
			return 3;
		}
		
	}
	
	@PostMapping("/openbuong1SA")
	public void buong1SA() throws NamingException, JMSException
	{
		buong1SA= new ReceiverSA();
	}
	
	
	@GetMapping("/getBuong1")
	public ArrayList<Patient>getAllBNBuong1()
	{
		if(buong1!=null)
		{
			return buong1.getAllBN();
		}
		return null;
	}
	@GetMapping("/getBuong1UT")
	public ArrayList<Patient>getAllBNBuong1UT()
	{
		if(buong1!=null)
		{
			return buong1.getAllBNUT();
		}
		return null;
	}
	@GetMapping("/getBuong1SA")
	public ArrayList<Patient>getBuong1SA()
	{
		if(buong1SA!=null)
		{
			return buong1SA.getAllBN();
		}
		return null;
	}
	@GetMapping("/getBNBuong1")
	public Patient getBNBuong1(@RequestParam int index)
	{
		System.out.println("idex: "+ index);
		return buong1.getBN(index);
	}
	@GetMapping("/getBNBuong1UT")
	public Patient getBNBuong1UT(@RequestParam int index)
	{
		System.out.println("idex: "+ index);
		return buong1.getBNUT(index);
	}
	@GetMapping("/getBNBuong2")
	public Patient getBNBuong2(@RequestParam int index)
	{
		System.out.println("idex: "+ index);
		if(buong2!=null)
		{
			return buong2.getBN(index);
		}
		return null;
	}
	@GetMapping("/getBNBuong2UT")
	public Patient getBNBuong2UT(@RequestParam int index)
	{
		System.out.println("idex: "+ index);
		return buong2.getBNUT(index);
	}
	@GetMapping("/getBNBuong1SA")
	public Patient getBNBuong1SA(@RequestParam int index)
	{
		System.out.println("idex: "+ index);
		return buong1SA.getBN(index);
	}
	@PostMapping("/openBuong2")
	public void openBuong2() throws NamingException, JMSException
	{
		buong2= new MyReceiver();
	}
	@GetMapping("/getBuong2")
	public ArrayList<Patient>getAllBNBuong2()
	{
		if(buong2!=null)
		{
			return buong2.getAllBN();
		}
		return null;
	}
	@GetMapping("/getBuong2UT")
	public ArrayList<Patient>getAllBNBuong2UT()
	{
		if(buong2!=null)
		{
			return buong2.getAllBNUT();
		}
		return null;
	}
	@PostMapping("/saveLich")
	public String saveLich(String lich)
	{
		return "ok";
	}
	@GetMapping("/getMedia")
	public ArrayList<Medicine> getMedia(@RequestParam String name)
	{
		ArrayList<Medicine> ds = medicineService.getMediasfrom(name);
		System.out.println(ds);
		ArrayList<Medicine> dsTam = new ArrayList<>();
		for (Medicine medicine : ds) {
			Medicine test = new Medicine();
			test.setId(medicine.getId());
			test.setName(medicine.getName());
			test.setCostPrice(medicine.getCostPrice());
			test.setMethodOfUse(medicine.getMethodOfUse());
			test.setStorageUnit(medicine.getStorageUnit());
			test.setUseUnit(medicine.getUseUnit());
			dsTam.add(test);
		}
		
		return dsTam;
	}
	@PostMapping("/saveEx")
	public Order saveEx(@RequestBody Order or  )
	{
		ExamninationHistory examninationHistory = or.getExamninationHistory();
		ExamninationHistory exTam = examinitionHistoryService.addExamninationHistory(examninationHistory);
		exTam.setCreatedAt(new Date());
		or.setExamninationHistory(exTam);
		or.setCreatedAt(new Date());
		Order orTam =  orderDao.saveOrderMedicine(or);
		List<OrderMediceneDetail> list = or.getOrderMediceneDetails();
		for (OrderMediceneDetail orderMediceneDetail : list) {
			orderMediceneDetail.setOrder(orTam);
			detailService.saveOrderMediceneDetail(orderMediceneDetail);
		}
		return null;
	}
	@GetMapping("/getOrderByExId")
	public Order getOrderByExId(@RequestParam int  id  )
	{
		List<Order> list = orderDao.getOrderByHistoryId(id);
		if(list.size()>0)
		{
			Order ors = orderDao.getOrderByHistoryId(id).get(0);
			
			List<OrderMediceneDetail> orm = detailService.getorderDetailsbyorId(ors.getId());
//			System.out.println(orm.get(0).getId());
			List<OrderMediceneDetail> ormTam = new ArrayList<>();
			for (OrderMediceneDetail orderMediceneDetail : orm) {
//				
//				orderMediceneDetail.setOrder(null);
//				ormTam.add(orderMediceneDetail);
				OrderMediceneDetail od = new OrderMediceneDetail();
				od.setId(orderMediceneDetail.getId());
				od.setName(orderMediceneDetail.getName());
				Medicine me = orderMediceneDetail.getMedicine();
				me.setConsultations(null);
				me.setCategory(null);
				me.setWarehouseSessions(null);
				me.setOrders(null);
				od.setMedicine(me);
				od.setPrice(orderMediceneDetail.getPrice());
				od.setQuantity(orderMediceneDetail.getQuantity());
				ormTam.add(od);
			}
			OrderServiceDetail serverdetais = servicedetailService.getbyorderId(ors.getId());
			if(serverdetais!=null)
			{
				serverdetais.setOrder(null);
				List<OrderServiceDetail> ds = new ArrayList<>();
				ds.add(serverdetais);
				ors.setOrderServiceDetails(ds);
			}
			else
			{
				ors.setOrderServiceDetails(null);
			}
			
			
			
			ors.setExamninationHistory(null);
			ors.setServices(null);
			ors.setMedicines(null);
			ors.setOrderMediceneDetails(ormTam);
			
			
			return ors;
		}
		else
		{
			return null;
		}
		
	}
	@PostMapping("/saveSieuAm")
	public int saveSieuAm(@RequestBody Order or  )
	{
		ExamninationHistory examninationHistory = or.getExamninationHistory();
		ExamninationHistory exTam = examinitionHistoryService.addExamninationHistory(examninationHistory);
		exTam.setCreatedAt(new Date());
		or.setExamninationHistory(exTam);
		or.setCreatedAt(new Date());

		Service service = new Service();
		service.setId(1);
		OrderServiceDetail ordersevice = new OrderServiceDetail();
		ordersevice.setCreatedAt(new Date());
		ordersevice.setName("Siêu âm màu");
		ordersevice.setPrice(400000);
		ordersevice.setService(service);
		List<OrderServiceDetail> listorder = new ArrayList<>();
		listorder.add(ordersevice);
		or.setOrderServiceDetails(listorder);
		
		Order od= orderDao.saveOrderMedicine(or);
		ordersevice.setOrder(od);
		OrderServiceDetail odd =  servicedetailService.saveOrderServiceDetail(ordersevice);
		return odd.getId();
	}
	@PostMapping(value = "/upload-avatar", consumes = { "multipart/form-data" })
	public void uploadAvatar(@RequestHeader(value = "authorization") String token,
			@Valid @ModelAttribute UploadAvatarRequest wrapper) throws Exception {
		OrderServiceDetail od = servicedetailService.getbyId(wrapper.getId());
		od.setAvatar(wrapper.getAvatar());
		servicedetailService.saveOrderServiceDetail(od);
		
	}

	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getHistoryExamination(
			@RequestParam(name = "patient_id", required = true, defaultValue = "-1") int patientId,
			@RequestParam(name = "key_search", required = true, defaultValue = "") String keySearch) throws Exception {
		BaseResponse response = new BaseResponse<>();
		doctorService.getHistoryExamination(patientId, keySearch);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/specialties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse<BaseListDataResponse<SpecializationResponse>>> getSpecialization(
			@RequestParam(name = "specialization_id", required = true, defaultValue = "-1") int specializationId,
			@RequestParam(name = "key_search", required = true, defaultValue = "") String keySearch,
			@RequestParam(name = "limit", required = true, defaultValue = "-1") int limit,
			@RequestParam(name = "page", required = true, defaultValue = "-1") int page,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse<BaseListDataResponse<SpecializationResponse>> response = new BaseResponse();

		Pagination pagination = new Pagination(page, limit);

		StoreProcedureListResult<Specialization> specialties = specializtionService.getSpecialization(specializationId,
				keySearch, pagination);
		BaseListDataResponse<SpecializationResponse> listData = new BaseListDataResponse<>();

		listData.setList(new SpecializationResponse().mapToList(specialties.getResult()));

		listData.setLimit(pagination.getLimit());
		listData.setTotalRecord(specialties.getTotalRecord());

		response.setData(listData);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
