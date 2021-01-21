package com.startjava.game;

public class Ugad{
	public static void main(String[] args){
		int zagad = 14;
		int i = 1;
		while(true){
			if(i == zagad){
				System.out.println("Вы угадали число!");
				break;
			}
			else{
				System.out.println("Вы не угадали число!");
			}
			i++;
		}
	}
}