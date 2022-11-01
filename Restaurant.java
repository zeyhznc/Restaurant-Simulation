package restaurant;
import peopleInvolvedinOrdering.Customer;
import peopleInvolvedinOrdering.HeadWaiter;
import peopleInvolvedinOrdering.Waiter;
import menu.Beverages;
import menu.Foods;
import java.util.*;

// Müşteriler restoranta girer ve sipariş verirler.
// Garsonlar siparişleri alır ve aldıkları siparişleri şeflere iletir. Şefler siparişleri gelme sırasına göre hazırlar.

public class Restaurant {
	public static Random rand = new Random();	
	
// Bekleme sırası : Müşteri, garson ve şef için bekleme sırasını thread yapısıyla kurdum	
	public static List<Customer> waitingQueue;
	
	List<Customer> customerQueue = new ArrayList<>();
	List<Thread> customerQueueThread = new ArrayList<>();
	
	List <Waiter> waiterQueue = new ArrayList<>();
	List <Thread> waiterQueueThread = new ArrayList<>();
	
	List <HeadWaiter> headWaiterQueue = new ArrayList<>();
	List <Thread> headWaiterQueueThread = new ArrayList<>();
	
	
	Customer customer;
	Thread customerThread;
	Waiter waiter;
	Thread waiterThread;
	HeadWaiter headWaiter;
	Thread headWaiterThread;
	

public static String[] NameofBeverages = {"Limonata", "IceTea", "Ayran", "Meyve Suyu", "Cola", "Gazoz", "Çay", "Türk kahvesi", "Mocha"};
public static synchronized List<Beverages> orderBeverage(){
	List<Beverages> beverage = new ArrayList<>();
	
	int amountOfBeverages = rand.nextInt(2); // Siparişde en çok 1 içecek olabilir.
	 
	Beverages beverages = new Beverages(NameofBeverages[rand.nextInt(2)],5,20); 
	return beverage;
}	
	
	
public static String[] NameOfFoods= {"Cajun", "Hamburger", "Pizza", "King Chicken Menu", "Izgara Köfte", "Tavuk Şiş", "Kasap Köfte"};
public static synchronized List <Foods> orderFood(){
	List<Foods> food = new ArrayList<>();
	
	int amountOfFoods = rand.nextInt(3); //Siparişte en çok 2 yemek olabilir.
	
	Foods foods = new Foods(NameOfFoods[rand.nextInt(3)], 70, 40 ); 
	return food;
}	
	
// Thread yapısının çalışacağı müşteri, garson ve şef sayısını şu şekilde belirledim:
	int customers = 24;
	int waiters = 6;
	int headWaiters = 4;
	
		
public static List<Customer> getWaitingQueue() {
		return waitingQueue;
	}


public static void setWaitingQueue(List<Customer> waitingQueue) {
		Restaurant.waitingQueue = waitingQueue;
	}


public List<Customer> getCustomerQueue() {
		return customerQueue;
	}


public void setCustomerQueue(List<Customer> customerQueue) {
		this.customerQueue = customerQueue;
	}


public List<Thread> getCustomerQueueThread() {
		return customerQueueThread;
	}


public void setCustomerQueueThread(List<Thread> customerQueueThread) {
		this.customerQueueThread = customerQueueThread;
	}


public List<Waiter> getWaiterQueue() {
		return waiterQueue;
	}


public void setWaiterQueue(List<Waiter> waiterQueue) {
		this.waiterQueue = waiterQueue;
	}


public List<Thread> getWaiterQueueThread() {
		return waiterQueueThread;
	}


public void setWaiterQueueThread(List<Thread> waiterQueueThread) {
		this.waiterQueueThread = waiterQueueThread;
	}


public List<HeadWaiter> getHeadWaiterQueue() {
		return headWaiterQueue;
	}


public void setHeadWaiterQueue(List<HeadWaiter> headWaiterQueue) {
		this.headWaiterQueue = headWaiterQueue;
	}


public List<Thread> getHeadWaiterQueueThread() {
		return headWaiterQueueThread;
	}


public void setHeadWaiterQueueThread(List<Thread> headWaiterQueueThread) {
		this.headWaiterQueueThread = headWaiterQueueThread;
	}


public Customer getCustomer() {
		return customer;
	}


public void setCustomer(Customer customer) {
		this.customer = customer;
	}


public Thread getCustomerThread() {
		return customerThread;
	}


public void setCustomerThread(Thread customerThread) {
		this.customerThread = customerThread;
	}


public Waiter getWaiter() {
		return waiter;
	}


public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}


public Thread getWaiterThread() {
		return waiterThread;
	}


public void setWaiterThread(Thread waiterThread) {
		this.waiterThread = waiterThread;
	}


public HeadWaiter getHeadWaiter() {
		return headWaiter;
	}


public void setHeadWaiter(HeadWaiter headWaiter) {
		this.headWaiter = headWaiter;
	}


public Thread getHeadWaiterThread() {
		return headWaiterThread;
	}


public void setHeadWaiterThread(Thread headWaiterThread) {
		this.headWaiterThread = headWaiterThread;
	}



	// Müşteriler gelir
	public void restaurantBegins() {
		waitingQueue = new ArrayList<>();
		
//OrderList.java dosyamda kurduğum yemek&içecek oluşturma yapısını 
//belirlediğim müşteri sayısı,garson sayısı, şef sayısı ve bu garson,şef, müşteri yapılarının threadli versiyonlarına karşılık gelecek
//şekilde for döngüsünde kullanıyorum
		
// Thread yapısı - MÜŞTERİLER
		for (int i=1; i<= customers ; i++) {
			
			LinkedList<OrderList> order = new LinkedList<OrderList>();
			order.add((OrderList) orderBeverage()); //orderBeverage metodunun return tipi OrderList olmadığı için burada OrderList'e cast ettim.
			order.add((OrderList) orderFood()); //orderFood metodunun return tipi OrderList olmadığı için burada OrderList'e cast ettim.
			
			this.customer = new Customer(i,order);
			customerQueue.add(customer);
		
//Restaurant class'ının instance'ları threadler tarafından execute edildiği için Runnable interface'ini implement ediyor olmaları gerekir.
// O nedenle burada Runnable'a cast ettim.
			this.customerThread = new Thread((Runnable) customer); 
			customerQueueThread.add(customerThread);
			customerThread.start();
		}
		

		
// Thread Yapısı - GARSONLAR
		for (int i=1; i<=waiters; i++) {
			this.waiter = new Waiter(i);
			waiterQueue.add(waiter);
//Restaurant class'ının instance'ları threadler tarafından execute edildiği için Runnable interface'ini implement ediyor olmaları gerekir.
// O nedenle burada Runnable'a cast ettim.
			this.waiterThread = new Thread ((Runnable) waiter);
			waiterQueueThread.add(waiterThread);
			waiterThread.start();
		}
		
// Thread Yapısı - ŞEFLER
		for (int i=1; i<= headWaiters; i++) {
			this.headWaiter = new HeadWaiter(i);		
			headWaiterQueue.add(headWaiter);
//Restaurant class'ının instance'ları threadler tarafından execute edildiği için Runnable interface'ini implement ediyor olmaları gerekir.
// O nedenle burada Runnable'a cast ettim.
			this.headWaiterThread = new Thread((Runnable) headWaiter);
			headWaiterThread.start();
		}
		
		
		
		
		
		
	}
	
	


}
