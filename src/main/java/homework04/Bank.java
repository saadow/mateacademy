package homework04;

public class Bank<T extends AssetAbstClass> {
	private int id;
	private String name;
	private String address;
	private T asset;
	
	public Bank(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public T getAsset() {
		return asset;
	}

	public void setAsset(T asset) {
		this.asset = asset;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", address=" + address + ", asset=" + asset + "]";
	}
	
}