package lesson_jdbc_01;

import java.math.BigDecimal;


public class Product implements java.io.Serializable {

	private String productId;
	private String mfrId;
	private String description;
	private BigDecimal price;
	private BigDecimal qtyOnHand;

	public Product() {
	}

	public Product(String productId) {
		this.productId = productId;
	}

	public Product(String productId, String mfrId, String description, BigDecimal price, BigDecimal qtyOnHand) {
		this.productId = productId;
		this.mfrId = mfrId;
		this.description = description;
		this.price = price;
		this.qtyOnHand = qtyOnHand;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getMfrId() {
		return this.mfrId;
	}

	public void setMfrId(String mfrId) {
		this.mfrId = mfrId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getQtyOnHand() {
		return this.qtyOnHand;
	}

	public void setQtyOnHand(BigDecimal qtyOnHand) {
		this.qtyOnHand = qtyOnHand;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", mfrId=" + mfrId + ", description=" + description + ", price="
				+ price + ", qtyOnHand=" + qtyOnHand + "]";
	}

}
