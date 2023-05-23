package com.app.booking.springboot.service;

@Service("orderService")
@Transactional

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private WarehouseSessionDao warehouseDao;

	@Override
	public void createMedicneOrder(int employeeId, int discountPercent, int type, float discountAmount,
			String description, String warehouseDeitalJson) throws Exception {
		orderDao.createMedicneOrder(employeeId, discountPercent, type, discountAmount, description,
				warehouseDeitalJson);
		warehouseDao.createWarehouseSession(employeeId, discountPercent, type, discountAmount,
				Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), description, warehouseDeitalJson);
	}
	
	@Override
	public int checkQuantityMedicine(int medicineId, int quatity) throws Exception {
		return orderDao.checkQuantityMedicine(medicineId, quatity);
	}
	@Override
	public Order saveOrderMedicine(Order order) {
		return orderDao.saveOrderMedicine(order);
	}

	@Override
	public List<Order> getOrderByHistoryId(int id) {
		return orderDao.getOrderByHistoryId(id);
	}

}
