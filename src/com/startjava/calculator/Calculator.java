package com.startjava.calculator;

public class Calculator{
	public static void main(String[] args){
		int firstNum = 5;
		int secondNum = 3;
		char plus = '+';
		char minus = '-';
		char proizved = '*';
		char del = '/';
		char step = '^';
		char ost = '%';		
		if(plus == '+'){
			int sum = firstNum + secondNum;
			System.out.println("Сумма чисел = " + sum);
		}
		if(minus == '-'){
			int vich = firstNum - secondNum;
			System.out.println("Разность чисел = " + vich);
		}
		if(proizved == '*'){
			int pro = firstNum * secondNum;
			System.out.println("Произведение чисел = " + pro);
		}
		if(del == '/'){
			int dele = firstNum / secondNum;
			System.out.println("Частное чисел = " + dele);
		}
		if(step == '^'){
			int stepe = firstNum;
			for(int i = 1; i < secondNum; i++){
				stepe = stepe * firstNum;
			}
			System.out.println("Возведение в степень одного числа на другое = " + stepe);
		}
		if(ost == '%'){
			int osta = firstNum % secondNum;
			System.out.println("Остаток от деления чисел = " + osta);
		}
		
	}
}