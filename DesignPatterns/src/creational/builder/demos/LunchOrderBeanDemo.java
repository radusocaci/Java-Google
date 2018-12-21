package creational.builder.demos;

public class LunchOrderBeanDemo {

public static void main(String args[]) {
		//not immutable.no idea what this order is about and is not immutable. we have set
		LunchOrderBean lunchOrderBean = new LunchOrderBean();
		
		lunchOrderBean.setBread("Wheat");
		lunchOrderBean.setCondiments("Lettuce");
		lunchOrderBean.setDressing("Mustard");
		lunchOrderBean.setMeat("Ham");


	lunchOrderBean.setBread("");
		System.out.println(lunchOrderBean.getBread());
		System.out.println(lunchOrderBean.getCondiments());
		System.out.println(lunchOrderBean.getDressing());
		System.out.println(lunchOrderBean.getMeat());	
	}
	
}
