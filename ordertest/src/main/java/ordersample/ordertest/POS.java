package ordersample.ordertest;

public class POS implements IPOS{
	
	private Order order;
	private static POS posObj;
	
	private POS()
	{
		
	}
	 public static POS getInstance(){
	        if(posObj == null){
	        	posObj = new POS();
	        }
	        return posObj;
	    }
	
	public Order createOrder() {
		 order=new Order();
		return order;
	}

}
