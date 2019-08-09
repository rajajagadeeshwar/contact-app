package statica;

public class MainApplication {
	public static void main(String[] args) {
		MoneyCounter money1 = new MoneyCounter();
		System.out.println(money1);
		MoneyCounter money2 = new MoneyCounter();
		System.out.println(money2);
		
		System.out.println("Amount money1: " + money1.amount );
		System.out.println("Amount money2: " + money2.amount );
		
		money1.amount = 10;
		
		money2 = money1;
		
		
		System.out.println("Amount money1: " + money1.amount );
		System.out.println("Amount money2: " + money2.amount );
	}
}
