package restaurant;
import menu.Foods;
import menu.Beverages;
import java.util.List;
import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

/*
 * Müşteriler en fazla 2 yemek ve 1 içecek siparişinde bulunabilirler.
 * O nedenle 'orderBeverage()' metodunda en fazla 1 adet olacak şekilde içecek oluşturulur. 'orderFood()' metodunda en fazla 2 adet olacak şekilde yemek oluşturulur.
 */

public class OrderList {
	public static Random rand = new Random();
	
	
public static String[] NameofBeverages = {"Limonata", "IceTea", "Ayran", "Meyve Suyu", "Cola", "Gazoz", "Çay", "Türk kahvesi", "Mocha"};
	public static synchronized List<Beverages> orderBeverage(){
		List<Beverages> beverage = new ArrayList<>();
		
// Oluşturulacak içecek adedinin en fazla 1 olması sağlanır
		int amountOfBeverages = rand.nextInt(2);
		
		for (int i=0; i<amountOfBeverages; i++) {
			Beverages beverages = new Beverages(NameofBeverages[rand.nextInt(2)],5,20); 
			//Beverages.java dosyamdaki Beverages constructor'ında name, prepTime,consumptionTime parametreleri geçiliyor.
			//O nedenle burada da içecek oluştururken her içeceğin hazırlanma süresini 5, tüketilme süresini 20 olarak belirledim
			
			beverages.add(beverages);	
		}
		return beverage;
	}
	
	
	
public static String[] NameOfFoods= {"Cajun", "Hamburger", "Pizza", "King Chicken Menu", "Izgara Köfte", "Tavuk Şiş", "Kasap Köfte"};
	public static synchronized List <Foods> orderFood(){
		List<Foods> food = new ArrayList<>();
		
//Oluşturulacak yemek adedinin en fazla 2 olması sağlanır.		
		int amountOfFoods = rand.nextInt(3);
		
		for (int i=0; i<amountOfFoods; i++) {
			Foods foods = new Foods(NameOfFoods[rand.nextInt(3)], 70, 40 );
			//Foods.java dosyamdaki Foods constructor'ında name, prepTime,consumptionTime parametreleri geçiliyor.
			//O nedenle burada da yemek oluştururken her yemeğin hazırlanma süresini 70, tüketilme süresini 40 olarak belirledim
			
			food.add(foods);
		}
		return food;
	}
	
	
	

}
