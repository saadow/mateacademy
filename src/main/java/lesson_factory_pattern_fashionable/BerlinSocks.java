package lesson_factory_pattern_fashionable;

public class BerlinSocks extends FashionableNosochek{
	int city;

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "BerlinSocks [city=" + city + ", size=" + size + ", color=" + color + ", getCity()=" + getCity()
				+ ", getVechniy()=" + getVechniy() + ", toString()=" + super.toString() + ", getSize()=" + getSize()
				+ ", getColor()=" + getColor() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
