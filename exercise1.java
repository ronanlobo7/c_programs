/* */

import java.util.*;

class Complex {
	int re;
	int im;

	void assign(int re, int im) {
		this.re = re;
		this.im = im;
	}

	void display() {
		if(this.im >= 0) 
			System.out.println(this.re + " + i" + this.im);
		else
			System.out.println(this.re + " - i" + Math.abs(this.im));
	}

	Complex add(Complex c) {
		Complex sum = new Complex();
		sum.assign(this.re + c.re, this.im + c.im);
		return sum;
	}

	Complex subtract(Complex c) {
		Complex diff = new Complex();
		diff.assign(this.re - c.re, this.im - c.im);
		return diff;
	}
}

public class exercise1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Complex z1 = new Complex();
		Complex z2 = new Complex();
		int a, b;

		System.out.print("Enter a Complex Number(real and imaginary parts), z1: ");
		a = sc.nextInt();
		b = sc.nextInt();

		z1.assign(a, b);

		System.out.print("Enter another Complex Number(real and imaginary parts), z2: ");
		a = sc.nextInt();
		b = sc.nextInt();

		z2.assign(a, b);

		System.out.print("The complex number entered is, z1 = ");
		z1.display();
		System.out.print("The complex number entered is, z2 = ");
		z2.display();

		Complex sum = z1.add(z2);
		Complex diff = z1.subtract(z2);

		System.out.print("Complex numbers addition, z1 + z2 = ");
		sum.display();

		System.out.print("Complex numbers subtraction, z1 - z2 = ");
		diff.display();
	}
}