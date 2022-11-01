package peopleInvolvedinOrdering;
import menu.Foods;
import placingOrder.WaiterOrderInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// Garsonun sipariş alma süreci.

public class Waiter {
	List<WaiterOrderInfo> orders = Collections.synchronizedList(new ArrayList <> ());

	public Waiter(int i) {
		// Restaurant.java dosyamda garsonların for döngüsünde kullanılması için kullandığım constructor
	}

	public List<WaiterOrderInfo> getOrders() {
		return orders;
	}

	public void setOrders(List<WaiterOrderInfo> orders) {
		this.orders = orders;
	}
	
// GarsonSiparişBilgisi nesnesine müşteri ve yemekler parametresi geçilerek 
// sipariş alınacak metot aşağıdaki gibidir.
	public void receiveOrder(Customer customer, List<Foods> foods) {
		WaiterOrderInfo waiterOrderInfo = new WaiterOrderInfo(customer, foods);
		orders.add(waiterOrderInfo);
	}
	
	
	

	


}
