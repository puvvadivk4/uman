package ordersample.ordertest;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Product implements Serializable{

	private String code;
	private String name;
	private double price;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static List<Product> products = new ArrayList<Product>();
	private static Product productObj;
	Product product;

	private Product() {

		/*
		 * products.add(new Product("ORANGE", "NORANGE", 1)); products.add(new
		 * Product("RICE", "NRICE", 2)); products.add(new Product("APPLE",
		 * "NAPPLE", 0.5));
		 */

	}

	private Product(String code, String name, double price) {
		this.code = code;
		this.name = name;
		this.price = price;

	}

	public static Product getInstance() {
		if (productObj == null) {
			productObj = new Product();
		}
		try {
			ClassLoader classLoader = new Product().getClass()
					.getClassLoader();
			File file = new File(classLoader.getResource("products.json")
					.getFile());
			String content = new String(Files.readAllBytes(file.toPath()));
			//System.out.println(content);
			ObjectMapper mapper = new ObjectMapper();
			products = mapper.readValue(content,
					new TypeReference<List<Product>>() {
					});			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return productObj;
	}
@Override
public String toString() {
	
	return "code-->"+this.code+", name--->"+this.name+", price--->"+this.price;
}
}
