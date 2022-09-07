/* */

import java.util.*;

class Mixer {
	int[] arr;
	int n;
	void accept(int ) {
		int temp;
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-1-i; j++) {
				if(temparr[j] > temparr[j+1]) {
					temp = temparr[j];
					temparr[j] = temparr[j+1];
					temparr[j+1] = temp;
				}
			}
		}
 		int unq=1;
 		int curr = temparr[0];
		for(int i=1; i<n; i++) {
			if(curr != temparr[i]) {
				unq++;
				curr = temparr[i];
			}
		}

		this.arr = new int[unq];
		unq = 0;
		this.arr[unq] = temparr[0];
		for(int i=0; i<n; i++) {
			if(this.arr[unq] != temparr[i]) {
				this.arr[++unq] = temparr[i];
			}
		}
		this.n = unq + 1;

	}

	Mixer mix(Mixer A) {
		Mixer mixed = new Mixer();

		int[] temp = new int[this.n + A.n];

		return null;
	}

	void display() {
		for(int i=0; i<n; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}
}

public class exercise3 {
	public static void main(String[] args) {
		Mixer A = new Mixer();
		Mixer B = new Mixer();

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements of the array: ");
		this.n = sc.nextInt();
		int[] temparr = new int[n];
		System.out.println("Enter the array elements: ");
		for(int i=0; i<n; i++) {
			temparr[i] = sc.nextInt();
		}
		A.accept();
		B.accept();

		Mixer mixed = A.mix(B);

		System.out.println("The elements of the first mixer array: ");
		A.display();
		System.out.println("The elements of the second mixer array are: ");
		B.display();
		System.out.println("The elements of the mixed array are: ");
		mixed.display();
	}
}