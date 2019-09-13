import java.util.*;

public class Tri
{
	public static void main(String[] args) {
		System.out.println("Plz enter 3 coordinates: x,y");

		Scanner input = new Scanner(System.in);

		double x1 = input.nextDouble();
		double y1 = input.nextDouble();


		double x2 = input.nextDouble();
		double y2 = input.nextDouble();


		double x3 = input.nextDouble();
		double y3 = input.nextDouble();

		double a = Math.sqrt((x3-x2)*(x3-x2) + (y3-y2)*(y3-y2));
		double b = Math.sqrt((x3-x1)*(x3-x1) + (y3-y1)*(y3-y1));
		double c = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));

		System.out.println(x1 + ", " + y1);
		System.out.println(x2 + ", " + y2);
		System.out.println(x3 + ", " + y3);

		System.out.println(a + " " + b + " " + c);

		double A = Math.acos((a*a - b*b - c*c)/(-2 * b *c));

		System.out.println(A);

	}
}