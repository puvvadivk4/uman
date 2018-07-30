package ordersample.ordertest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

public class Order {
	public Map<String, Integer> orderedProductList = new HashMap<String, Integer>();
	public double price = 0;
	Product product;
	Deal deal;
	final static Logger logger = Logger.getLogger(Order.class);

	Order() {
		product = Product.getInstance();
		deal = Deal.getInstance();
	}

	public void addProductByCode(String code) {
		//logger.info("Entered into addProductByCode()");
		boolean codeFound = false;
		for (Product product : Product.products) {
			try {
				if (product.getCode().equals(code)) {
					codeFound = true;
					if (!orderedProductList.containsKey(code)) {
						orderedProductList.put(code, 1);
					} else {
						orderedProductList.put(code,
								(orderedProductList.get(code) + 1));
					}
				}
			} catch (UnsupportedOperationException exp) {
				try {
					throw new OrderFinalizedException("OrderFinalizedException");
				} catch (OrderFinalizedException e) {

					/*
					 * System.out.println("========" + e.getMessage() +
					 * "===========");
					 */
					logger.error("========" + e.getMessage() + "===========");
				}
			}

		}
		if (!codeFound) {
			try {
				throw new ProductNotFoundException("Product(" + code
						+ ") Not Found" + "============");
			} catch (ProductNotFoundException e) {
				// System.out.println(e.getMessage());
				logger.error(e.getMessage());
			}
		}

	}

	public double placeOrder() {
		orderedProductList = Collections.unmodifiableMap(orderedProductList);
		orderedProductList
				.forEach((k, v) -> {
					Map<Integer, Double> productPrices = new HashMap<Integer, Double>();
					for (Deal deals : Deal.dealLists) {
						if (deals.getProductCode().equals(k)) {
							productPrices.put(deals.getQuantity(),
									deals.getDiscountedPrice());

						}
					}
					TreeMap<Integer, Double> sorted = new TreeMap<Integer, Double>();
					sorted.putAll(productPrices);
					int rem = 0;
					int quo = 0;
					if (sorted.lastKey() <= v)// 2inQ 4lst // 1,3 org
					{
						rem = v % sorted.lastKey();
						quo = v / sorted.lastKey();
						if (rem == 0) {
							price = price + quo
									* (sorted.get(sorted.lastKey()));
							/*
							 * System.out.println(k + "(" + v + ")--->" + quo +
							 * "*" + sorted.get(sorted.lastKey()));
							 */
							logger.info(k + "(" + v + ")--->" + quo + "*"
									+ sorted.get(sorted.lastKey()));
						} else {
							price = price + quo
									* (sorted.get(sorted.lastKey()));// (sorted.lastKey())*
							price = price + rem
									* (sorted.get(sorted.firstKey()));
							/*
							 * System.out.println(k + "(" + (quo *
							 * sorted.lastKey()) + ")--->" + quo + "*" +
							 * sorted.get(sorted.lastKey()));
							 */
							logger.info(k + "(" + (quo * sorted.lastKey())
									+ ")--->" + quo + "*"
									+ sorted.get(sorted.lastKey()));
							/*
							 * System.out.println(k + "(" + (rem *
							 * sorted.firstKey()) + ")--->" + rem + "*" +
							 * sorted.get(sorted.firstKey()));
							 */
							logger.info(k + "(" + (rem * sorted.firstKey())
									+ ")--->" + rem + "*"
									+ sorted.get(sorted.firstKey()));
						}
					} else {
						price = price + v * (sorted.get(sorted.firstKey()));
					}

				});
		FileOutputStream file = null;
		ObjectOutputStream out = null;
		try {
			file = new FileOutputStream("test");

			out = new ObjectOutputStream(file);

			out.writeObject(Product.products);
			out.close();
			file.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return price;
	}

}
