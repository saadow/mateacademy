package lesson03_builder;


public class BuilderExample {
	private String name;
	private String surname;
	private int age;
	
	private BuilderExample(Builder builder) {
		this.name = builder.name;
		this.surname = builder.surname;
		this.age = builder.age;
	}
	public static Builder builder() {
		return new Builder();
	}
	public static final class Builder {
		private String name;
		private String surname;
		private int age;

		private Builder() {
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withSurname(String surname) {
			this.surname = surname;
			return this;
		}

		public Builder withAge(int age) {
			this.age = age;
			return this;
		}

		public BuilderExample build() {
			return new BuilderExample(this);
		}
	}
	
	

}
