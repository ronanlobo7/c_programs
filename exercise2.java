/* */

import java.util.*;

class Time {
	int hrs;
	int min;
	int sec;

	void assign(int h, int m, int s) {
		int totalsecs = h * 3600 + m * 60 + s;
		this.hrs = h  * 
	}

	void display() {
		System.out.println(this.hrs + ":" + this.min + ":" + this.sec);
	}

	void normalize() {
		if (this.sec >= 60) {
			this.min += this.sec / 60;
			this.sec %= 60;
		}

		if (this.min >= 60) {
			this.hrs += this.min / 60;
			this.min %= 60;
		}

		if (this.hrs >= 24) {
			this.hrs %= 24;
		}
	}

	Time add(Time t) {
		Time sum = new Time();
		sum.assign(this.hrs + t.hrs, this.min + t.min, this.sec + t.sec);
		sum.normalize();
		return sum;
	}

	Time subtract(Time t) {
		Time diff = new Time();
		diff.assign(this.hrs - t.hrs, this.min - t.min, this.sec - t.sec);
		diff.normalize();
		return diff;
	}

	boolean compare(Time t) {
		if (this.hrs > t.hrs) {
			return true;
		}
		else if (this.hrs == t.hrs) {
			if (this.min > t.min) {
				return true;
			}
			else if (this.min == t.min) {
				if(this.sec > t.sec) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}

public class exercise2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Time t1 = new Time();
		Time t2 = new Time();
		int h, m, s;

		System.out.print("Enter time in hours, minutes and second(hh mm ss), t1: ");
		h = sc.nextInt();
		m = sc.nextInt();
		s = sc.nextInt();

		t1.assign(h, m, s);
		t1.normalize();

		System.out.print("Enter another time in hours, minutes and second(hh mm ss), t2: ");
		h = sc.nextInt();
		m = sc.nextInt();
		s = sc.nextInt();

		t2.assign(h, m, s);

		System.out.print("The first time entered is, t1 = ");
		t1.display();
		System.out.print("The second time entered is, t2 = ");
		t2.display();

		Time sum = t1.add(t2);
		Time diff = t1.subtract(t2);

		System.out.print("The sum of the time's entered, t1 + t2 = ");
		sum.display();
		System.out.print("The difference of the time's entered, t1 - t2 = ");
		diff.display();


		if(t1.compare(t2)) {
			System.out.println("Time t1 is ahead of t2.");
		}
		else {
			System.out.println("Time t1 is behind t2.");
		}
	}
}