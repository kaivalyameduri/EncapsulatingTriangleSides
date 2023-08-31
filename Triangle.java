
public class Triangle {
	
	private double sideA;
	private double sideB;
	private double sideC;
	
	public static final String POLYGONSHAPE = "Triangle";
	public static final double DEFAULT_SIDE = 1;
	
	//initializes new Triangle
	public Triangle() {
		this.sideA = DEFAULT_SIDE;
		this.sideB = DEFAULT_SIDE;
		this.sideC = DEFAULT_SIDE;
	}
	
	//initializes new Triangle by assigning given values to instances variables
	public Triangle(double sideA, double sideB, double sideC) {
		try {
			if (isTriangle(sideA, sideB, sideC) == true) {
				this.sideA = sideA;
				this.sideB = sideB;
				this.sideC = sideC;
			}else {
				this.sideA = DEFAULT_SIDE;
				this.sideB = DEFAULT_SIDE;
				this.sideC = DEFAULT_SIDE;
			}
		}catch (Exception e) {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
	}
	
	//initializes new Triangle by assigning elements of given array tp instance variable
	public Triangle(double sides[]) {
		try {
			double sideA = sides[0];
			double sideB = sides[1];
			double sideC = sides[2];
			if (isTriangle(sideA, sideB, sideC)) {
				this.sideA = sideA;
				this.sideB = sideB;
				this.sideC = sideC;
			}else {
				this.sideA = DEFAULT_SIDE;
				this.sideB = DEFAULT_SIDE;
				this.sideC = DEFAULT_SIDE;
			}
		}catch (Exception e) {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
	}
	
	//Initialize new Triangle by assigning each instance variable of given triangle to corresponding variable of new triangle
	public Triangle(Triangle triangle) {
		try {
			this.sideA = triangle.getSideA();
			this.sideB = triangle.getSideB();
			this.sideC = triangle.getSideC();
		}catch(Exception e) {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
	}
	
	//Returns length of side A
	public double getSideA() {
		return sideA;
	}
	
	//Returns length of side B
	public double getSideB() {
		return sideB;
	}
	
	//Returns length of side C
	public double getSideC() {
		return sideC;
	}
	
	//Returns array with length of all 3 sides in order from A to C
	public double[] getSides() {
		double[] sides = {this.sideA, this.sideB, this.sideC};
		return sides;
	}
	
	//Method provides calculation between two sides of triangle using Law of Cosine
	public static double lawOfCosines(double a, double b, double c) {
		double answer = Math.acos(((a * a) + (b * b) - (c * c)) / (2 * a * b));
		answer = Math.toDegrees(answer);
		return answer;
	}
	
	//Method checks whether a triangle can be formed with the given side lengths by verifying the triangle inequality condition 
	//Ensures all side lengths are positive
	public static boolean isTriangle(double sides[]) {
		try {
			double a = sides[0];
			double b = sides[1];
			double c = sides[2];
			
			if ((a <= 0) || (b <= 0) || (c <= 0)) {
				
				return false;
			
			}else if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
			
				return false;
			
			}else {
			
				return true;
			}
		}catch (Exception e) {
			return false;
		}
	}
	
	//method checks whether a triangle can be formed with the given side lengths by verifying the triangle inequality condition
	public static boolean isTriangle(double a, double b, double c) {
		if ((a <= 0) || (b <= 0) || (c <= 0)) {
			return false;
	// checks values are positive
		}else if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
			return false;
		}else {
			return true;
		}
	}
	
	//Return the interior angle that is opposite to side A
	public double getAngleA() {
		double answer = lawOfCosines(this.sideB, this.sideC, this.sideA);
		return answer;
	}
	
	//Return the interior angle that is opposite to side B
	public double getAngleB() {
		double answer = lawOfCosines(this.sideA, this.sideC, this.sideB);
		return answer;
	}
	
	//Return the interior angle that is opposite to side C
	public double getAngleC() {
		double answer = lawOfCosines(this.sideB, this.sideA, this.sideC);
		return answer;
	}
	
	//Return an array with the three interior angles in order from A to C
	public double[] getAngles() {
		double[] answer = {this.getAngleA(), this.getAngleB(), this.getAngleC()};
		return answer;
		
	}
	
	//Assign the given value to sideA and return true
	public boolean setSideA(double sideA) {
		try{
			if (sideA <= 0) {
				return false;
			}
			if (isTriangle(sideA, this.sideB, this.sideC)) {
				this.sideA = sideA;
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			return false;
		}
		
	}
	
	//Assign the given value to sideB and return true
	public boolean setSideB(double sideB) {
		if (sideB <= 0) {
			return false;
		}
		if (isTriangle(this.sideA, sideB, this.sideC)) {
			this.sideB = sideB;
			return true;
		}else {
			return false;
		}
	}

	//Assign the given value to sideC and return true
	public boolean setSideC(double sideC) {
		if (sideC <= 0) {
			return false;
		}
		if (isTriangle(this.sideA, this.sideB, sideC)) {
			this.sideC = sideC;
			return true;
		}else {
			return false;
		}
	}
	
	//Assign the elements of the given array to the instance variables and return true
	public boolean setSides(double[] sides) {

		try{
			double sideA = sides[0];
			double sideB = sides[1];
			double sideC = sides[2];
			if ((sideA <= 0) || (sideB <= 0) || (sideC <= 0)) {
				return false;
			}
			if (isTriangle(sideA, sideB, sideC)) {
				this.sideA = sideA;
				this.sideB = sideB;
				this.sideC = sideC;
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	
	//Print method for object
	public String toString(){
		double a = this.sideA;
		double b = this.sideB;
		double c = this.sideC;
		String answer = String.format("%s(%.4f, %.4f, %.4f)", POLYGONSHAPE, a, b, c);
		return answer;
		
	}	
}


