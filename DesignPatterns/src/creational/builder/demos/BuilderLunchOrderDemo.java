package creational.builder.demos;

public class BuilderLunchOrderDemo {

	public static void main(String args[]) {
		
		LunchOrder.Builder order1 = new LunchOrder.Builder();
		
		order1.bread("Wheat").dressing("Mayo").meat("Turkey");


		LunchOrder.Builder order2 = new LunchOrder.Builder();

		order1.bread("Wheat").meat("Turkey");
		LunchOrder lunchOrder = order1.build();
		
		System.out.println(lunchOrder.getBread());
		System.out.println(lunchOrder.getCondiments());
		System.out.println(lunchOrder.getDressing());
		System.out.println(lunchOrder.getMeat());	
	}
}
