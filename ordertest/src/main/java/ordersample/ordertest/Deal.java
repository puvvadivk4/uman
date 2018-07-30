package ordersample.ordertest;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deal {

	public String productCode;
	public int quantity;
	public double discountedPrice;

	public static List<Deal> dealLists;
	private static Deal dealObj;

	private Deal() {
		dealLists = new ArrayList<Deal>();
		/*dealLists.add(new Deal("ORANGE", 1, 1));
		dealLists.add(new Deal("ORANGE", 3, 2));
		dealLists.add(new Deal("RICE", 1, 2));
		dealLists.add(new Deal("RICE", 2, 3));
		dealLists.add(new Deal("APPLE", 1, 0.5));
		dealLists.add(new Deal("APPLE", 3, 1.25));*/

	}

	private Deal(String productCode, int quantity, double discountedPrice) {
		this.productCode = productCode;
		this.quantity = quantity;
		this.discountedPrice = discountedPrice;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public static Deal getInstance() {
		if (dealObj == null) {
			dealObj = new Deal();
		}
		try {
			ClassLoader classLoader = new Deal().getClass().getClassLoader();
			File file = new File(classLoader.getResource("deals.json")
					.getFile());
			String content = new String(Files.readAllBytes(file.toPath()));
			//System.out.println(content);
			ObjectMapper mapper = new ObjectMapper();
			dealLists = mapper.readValue(content,
					new TypeReference<List<Deal>>() {
					});
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return dealObj;
	}

}
