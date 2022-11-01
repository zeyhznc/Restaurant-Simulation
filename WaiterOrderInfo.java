package placingOrder;
import java.util.List;
import menu.Foods;
import peopleInvolvedinOrdering.Customer;
import java.util.List;

// Garsonun sipariş aldığı müşteriler ve onlara ait sipariş listeleri vardır.

public class WaiterOrderInfo {
	private Customer customer;
	private List<Foods> orderList;

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Foods> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Foods> orderList) {
		this.orderList = orderList;
	}

/*
 *  Garsonun sipariş aldığı müşterilerin ve siparişlerdeki yemeklerin parametre 
 * olarak geçildiği WaiterOrderInfo constructor'ı. 
 *  Bu constructor, garsonun aldığı her bir siparişbilgisi için nesne oluşturmakta kullanılır.
 */
	public WaiterOrderInfo(Customer customer, List<Foods> orderList) {
		this.customer = customer;
		this.orderList = orderList;
	}
	
// Her yemek için 'Hazırlanma Süresi' vardır.
	
	public int getFoodPrepTime() {
		int startTime = 0;
		for(Foods food: orderList) {
			startTime += food.getPrepTime();
		}
		return startTime;
	}
	
	
	
	



}
