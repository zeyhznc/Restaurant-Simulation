package menu;

public class Foods {
	
	private String name;
	private int prepTime;
	private int consumptionTime;
	
 // Her yemek için isim, hazırlanma süresi ve tüketilme süresinin parametre olarak geçildiği 'Foods' constructor'ı.
	
	public Foods (String name, int prepTime, int consumptionTime) {
		this.name = name;
		this.prepTime = prepTime;
		this.consumptionTime = consumptionTime;
	}
	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
//WaiterOrderInfo 	
	public int getPrepTime() {
		return prepTime;
	}
	
	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}

// Customer	
	public int getConsumptionTime() {
		return consumptionTime;
	}

	public void setConsumptionTime(int consumptionTime) {
		this.consumptionTime = consumptionTime;
	}

	
// 'Foods' nesnelerinin bilgilerini yazdırmak için kullanılacak metod
	
	public String toString() {
		return name;
	}
	

}
