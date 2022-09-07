/* */

import java.util.*;

class Stack {
	int arr[] = new int[100];
	int tos;

	void initialize() {
		this.tos = -1;
	}

	void push(int ele) {
		if(tos >= 100) {
			System.out.println("Stack Overflow ...");
			return;
		}
		this.tos++;
		this.arr[this.tos] = ele;
	}

	void pop() {
		if(tos < 0) {
			System.out.println("Stack Underflow ...");
			return;
		}
		this.tos--;
	}

	void display() {
		if(tos >= 0) {
			System.out.println("Stack elements are: ");
			for(int i=0; i <= this.tos; i++) {
				System.out.print(this.arr[i] + "\t");
			}
			System.out.println();
		}
		else {
			System.out.println("Stack Empty");
		}
	}
}

public class exercise4 {
	static void ask_choice() {
		System.out.println("Avalilable Stack Operations: ");
		System.out.println("\t1.Display Stack");
		System.out.println("\t2.Push an Element");
		System.out.println("\t3.Pop an Element");
		System.out.println("\t4.Exit");
		System.out.print("Enter your choice: ");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack stack = new Stack();
		stack.initialize();
		int ele, choice;
		ask_choice();
		choice = sc.nextInt();
		while(choice != 4) { 
			switch(choice) {
				case 1:
					stack.display();
					break;
				case 2:
					System.out.print("Enter the element to be pushed into the stack: ");
					ele = sc.nextInt();
					stack.push(ele);
					break;
				case 3:
					stack.pop();
					break;
				case 4:
					break;
				default:
					System.out.println("Invalid User Input, Try Again");
					break;
			}
			System.out.println();
			ask_choice();
			choice = sc.nextInt();
		}
	}
}