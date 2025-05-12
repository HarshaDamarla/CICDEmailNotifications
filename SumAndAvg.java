package com.arrays.programs;

import java.util.Scanner;

public class SumAndAvg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		float avg;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of an array: ");
		int size = s.nextInt();
		int a[] = new int[size];
		System.out.println("Enter the array values: ");
		
		for(int i=0; i<a.length; i++)
		{
			a[i] = s.nextInt();
		}
		//Sum of array
		for(int j=0; j<a.length; j++)
		{
			sum=sum+a[j];
		}
		System.out.println("Sum of an array is: "+sum);
		
		//Average of an array
		avg=(float)sum/a.length;
		System.out.println("Average of an array is: "+ avg);

	}

}
