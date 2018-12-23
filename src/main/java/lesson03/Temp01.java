package lesson03;

public class Temp01 {
	private String vendor;
	private String model;
	private String color;
	
	public Temp01(String vendor, String model, String color) {
		this.vendor = vendor;
		this.model = model;
		this.color = color;
	}
	void some() {
		System.out.println("some Temp01");
	}
	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getModel() {
		return model;
	}
	public void some(Object ... objects) {
		
	}
	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Temp01 other = (Temp01) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (vendor == null) {
			if (other.vendor != null)
				return false;
		} else if (!vendor.equals(other.vendor))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		Temp01 t1 = new Temp01("BMW", "X6", "Black");
		Temp01 t2 = new Temp01("BMW", "X6", "Grey");
		System.out.println(t1.equals(t2));
	}
}
