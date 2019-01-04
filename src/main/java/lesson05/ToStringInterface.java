package lesson05;

public interface ToStringInterface {
	static String method1() {
		return "Method1";
	}
	static String method2() {
		return "Method1";
	}
	
//	default String toString() {
//		return ToStringInterface.method1() + ToStringInterface.method2();
//	}
}
