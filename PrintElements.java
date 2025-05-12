package com.arrays.programs;

import java.util.Scanner;

public class PrintElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of an array: ");
		int size = s.nextInt();
		int a[]=new int[size];
		
		for(int i=0; i<a.length; i++)
		{
			a[i] = s.nextInt();
		}
		System.out.println(a[0]);
		System.out.println(a[a.length-1]);

	}

}
