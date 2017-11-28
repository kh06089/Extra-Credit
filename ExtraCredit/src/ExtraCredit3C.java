import java.util.Scanner;

public class ExtraCredit3C {
	public static void main(String[]args){
		int [] num = new int [20];
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 20 integer values:");
		
		for(int i =0; i< num.length; i++){
			num[i]=s.nextInt();
		}
		int i = 0;
		int max =Integer.MIN_VALUE;
		
		bigNum(num,i,max);
		
	}
	
	public static void bigNum(int [] num, int i, int max){
		if(i==num.length){
		
			System.out.println(max);
			return;
		}
		if (num[i]>max){
			max= num[i];

		}
		bigNum(num,++i,max);
	}
	
	

}
