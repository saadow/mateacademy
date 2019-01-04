package homework05;

import java.time.LocalDate;

public class Fruit {

	private Type type;
	private int expireDays;
	private LocalDate arriveDate;
	private int price;

	public Fruit(Type type, int expireDays, LocalDate date, int price) {
		this.type = type;
		this.expireDays = expireDays;
		this.arriveDate = date;
		this.price = price;
	}

	public Type getType() {
		return type;
	}

	public int getExpireDays() {
		return expireDays;
	}

	public LocalDate getDate() {
		return arriveDate;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate expireDate() {
		return arriveDate.plusDays(expireDays);
	}

	public boolean isExpired(LocalDate checkDate) {
		if (checkDate.isAfter(arriveDate) || checkDate.equals(arriveDate)) {
			return checkDate.compareTo(this.expireDate()) < 0;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Fruit [type=" + type + ", expireDays=" + expireDays + ", arriveDate=" + arriveDate + ", price=" + price
				+ "]";
	}

}
