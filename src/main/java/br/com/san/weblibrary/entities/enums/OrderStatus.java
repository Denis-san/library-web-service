package br.com.san.weblibrary.entities.enums;

public enum OrderStatus {

	AVAILABLE(1),
	UNAVAILABLE(2);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	
	public static OrderStatus valueOfCode(int code) {
		for(OrderStatus orderStatus: OrderStatus.values()) {
			if(orderStatus.getCode() == code) {
				return orderStatus;
			}
		}
		
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
