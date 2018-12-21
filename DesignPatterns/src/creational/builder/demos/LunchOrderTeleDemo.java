package creational.builder.demos;

public class LunchOrderTeleDemo {

	public static void main(String args[]) {

		//telescopic constructor
		//we only have get but we need a lot of constructors to cofigure a sandwitch without condiments
		LunchOrderTele lunchOrderTele = new LunchOrderTele("Wheat", "Lettuce", "Mustard", "Ham");

		// lunchOrderTele.setBread("Wheat");
		// lunchOrderTele.setCondiments("Lettuce");
		// lunchOrderTele.setDressing("Mustard");
		// lunchOrderTele.setMeat("Ham");

		System.out.println(lunchOrderTele.getBread());
		System.out.println(lunchOrderTele.getCondiments());
		System.out.println(lunchOrderTele.getDressing());
		System.out.println(lunchOrderTele.getMeat());
	}

}
