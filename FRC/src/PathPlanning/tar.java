package PathPlanning;
import java.util.Scanner;
public class tar {

	public static void main(String[] args) {
		
		// 1
		Scanner in = new Scanner(System.in);
		System.out.println("Insert 2 numbers");
		double a1 = in.nextDouble(), a2 = in.nextDouble();
		System.out.println(a1 > a2 ? a1 : a2);
		
		// 2
		System.out.println("------------\nENTER 3 NUMBERS");
		int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
		if (a <= b && a <= c)
			System.out.println(a);
		else if(b <= c && b <= a)
			System.out.println(b);
		else System.out.println(c);
	
		// 3
		System.out.println("------------\nInsert one number with only two digits");
		System.out.println((in.nextInt() + "").length() == 2 ? "Yes" : "No");
		
		// 4
		System.out.println("------------\nInsert 2 numbers");
		int n1 = in.nextInt(), n2 = in.nextInt();
		
		if (n1 + n2 > 1000)
			System.out.println("Yes");
		else System.out.println("No");
		
		// 5
		System.out.println("------------\nInsert 3 numbers one more time");
		int num1 = in.nextInt(), num2 = in.nextInt(), num3 = in.nextInt();
		
		if (num1 + num2 > 300 || num1 + num3 > 300 || num2 + num3 >300)
			System.out.println("Yes");
		else System.out.println("No");
		
		// 6
		System.out.println("------------\nInsert 4 numbers");
		n1 = in.nextInt();
		n2 = in.nextInt();
		int n3 = in.nextInt(), n4 = in.nextInt();
		
		if (n1 + n2 > n3 + n4)
			System.out.println("Yes");
		else System.out.println("No");
		
		// 7 
		System.out.println("------------\nInsert 4 numbers");
		n1 = in.nextInt();
		n2 = in.nextInt();
		n3 = in.nextInt();
		n4 = in.nextInt();
		
		if (n1 * n2 > n3 * n4)
			System.out.println("Yes");
		else System.out.println("No");
		
		
		// 8
		System.out.println("------------\nInsert 2 numbers");
		n1 = in.nextInt();
		n2 = in.nextInt();
		
		if (n1 < 0 && n2 < 0) 
			System.out.println("Minus");
		else if (n1 > 0 && n2 > 0)
			System.out.println("Plus");
		else
			System.out.println("Plus and Minus");
		
		// 9
		System.out.println("------------\nInsert 2 numbers");
		n1 = in.nextInt();
		n2 = in.nextInt();
		if (n1 + n2 >= 0)
			System.out.println("Plus");
		else System.out.println("Minus");
		
		// 10
		System.out.println("------------\nInsert 2 numbers");
		n1 = in.nextInt();
		n2 = in.nextInt();
		if (n1 * n2 >= 0)
			System.out.println("Plus");
		else System.out.println("Minus");
		
		// 11
		int sum = 0;
		System.out.println("------------\nInsert one number");
		int num = in.nextInt();
		while(num > 0) {
			sum += num%10;
			num /= 10;
		}
		System.out.println(sum);
		
		// 12
		System.out.println("------------\nInsert one number");
		num = in.nextInt();
		if ((num + "").length() == 2) {
			if (num%10 == num/10)
				System.out.println("Totally true");
			else System.out.println("False");
		} else System.out.println("Wrong input");
		
		// 13
		System.out.println("------------\nInsert one number");
		num = in.nextInt();
		if ((num + "").length() == 3) {
			if (num%10 == num/100)
				System.out.println("Totally true");
			else System.out.println("False");
		} else System.out.println("Wrong input");
			
		// 14
		System.out.println("------------\nInsert one number");
		num = in.nextInt();
		if ((num + "").length() == 4) {
			if (num%10 == num/10%10)
				System.out.println("Totally true");
			else System.out.println("False");
		} else System.out.println("Wrong input");
	
		
		// 15
		System.out.println("------------\nInsert two numbers");
		num = in.nextInt();
		num2 = in.nextInt();
		if ((num + "").length() == 3 && (num2 + "").length() == 3) {
			if (num/10%10 > num2/10%10)
				System.out.println("Totally true");
			else System.out.println("False");
		} else System.out.println("Wrong input");
		
	}
	
}
