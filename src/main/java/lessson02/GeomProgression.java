package lessson02;

public class GeomProgression {
	
	static int getElementGeometryProgression(int startElement, int coeff, int number) {
		return (int) (startElement * Math.pow(coeff, number - 1));
    }
	static int geomProgression(int startElement, int coeff, int number) {
		int result = 0;
		if (number <= 1) {
			return startElement;
		}
		else {
			result = result + startElement * coeff;
			return geomProgression(startElement * coeff, coeff, number - 1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(GeomProgression.getElementGeometryProgression(2, 4, 4));
		System.out.println(GeomProgression.geomProgression(2, 4, 4));
	}

}
