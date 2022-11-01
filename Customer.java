package peopleInvolvedinOrdering;
import menu.Foods;
import restaurant.OrderList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 Müşterinin sipariş verme süreci.
 Sipariş ile ilgili bilgiler: siparişin doğrulanması(kontrol edilmesi) -> isOrderGiven  ,müşterinin yiyeceği yemekler ve 
  bu yemeklerin tüketilme süresi -> foodsToBeEaten
*/

public class Customer {
	private List<Foods> foodsToBeEaten = Collections.synchronizedList(new ArrayList<> ());
	private boolean isOrderGiven;
	
	public Customer(int i, LinkedList<OrderList> order) {
		// Restaurant.java dosyamda müşterileri for döngüsüyle alırken kullanacağım constructor
	}

	public List<Foods> getFoodsToBeEaten() {
		return foodsToBeEaten;
	}
	
	public void setFoodsToBeEaten(List<Foods> foodsToBeEaten) {
		this.foodsToBeEaten = foodsToBeEaten;
	}
	
	
	public boolean isOrderGiven() {
		return isOrderGiven;
	}
	
	public void setOrderGiven(boolean isOrderGiven) {
		this.isOrderGiven = isOrderGiven;
	}
	
	public void foodsReady(List<Foods> foodsToBeEaten) {
		this.foodsToBeEaten = foodsToBeEaten;
	}

/*
 * Her yemek için 'Bitirme Süresi' ve 'Tüketilme Süresi' vardır.
 */
	
	public int getFoodCompletionTime() {
		int initTime = 0;
		for (Foods food: foodsToBeEaten) {
			initTime += food.getConsumptionTime();
		}
		return initTime;
	}

	
	
	

}
