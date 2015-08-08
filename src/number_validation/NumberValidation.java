/*
 * Write a program that prompts the user to enter a credit card number as a long
 * integer. Display whether the number is valid or invalid. Design your program to
 * use the following methods:
 * 
 * public static boolean isValid(long number) Return true if the card number is valid 
 * public static int sumOfDoubleEvenPlace(long number) Get the result from Step 2 
 * public static int getDigit(int number) Return this number if it is a single digit, otherwise, return the sum of the two digits 
 * public static int sumOfOddPlace(long number) Return sum of odd-place digits in number 
 * public static boolean prefixMatched(long number, int d) Return true if the digit d is a prefix for number 
 * public static int getSize(long d) Return the number of digits in d 
 * public static long getPrefix(long number, int k) Return the first k number of digits from number. If the number of digits in number is less than k, return number. 
 * 
 * Neke od ovih metoda nisam implementirao, jer u ovakvom formatu mi nisu odgovarale
 */ 

package number_validation;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberValidation {
	
	static ArrayList<Integer> broj = new ArrayList<>();

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		//unos broja kreditne kartice od strane korisnika
		System.out.println("Enter a credit card number as a long integer:");
		long broj = in.nextLong();
		in.close();
		//testiranje validnosti broja i ispisivanje rezultata
		if(isValid(broj) && prefixMatched() && getSize() >= 13 && getSize() <= 16){
			System.out.println(broj + " is valid.");
		}
		else{
			System.out.println(broj + " is invalid.");
		}
		
	}
	/*
	 * Return true if the card number is valid 
	 */
	public static boolean isValid(long number){
		boolean isValid = false;
		//testiranje validnosti broja kartice
		if((sumOfDoubleEvenPlace(number) + sumOfOddPlace()) % 10 == 0){
			isValid = true;
		}
		return isValid;
	}
	/*
	 * Double every second digit from right to left. If doubling of a digit results in a
     * two-digit number, add up the two digits to get a single-digit number.
     * Return sum of these numbers.
	 */
	public static int sumOfDoubleEvenPlace(long number){
		int rez = 0;
		//ubacivanje cifara broja kreditne kartice u listu
		while(number != 0){
			int cifra = (int)(number % 10);
			broj.add(cifra);
			number = number / 10;
		}
		//prolazak kroz listu cifara broja kreditne kartice smjestenih na parnim pozicijama
		for(int i = 1; i < broj.size(); i = i + 2){
			//ako je broj dvocifren, uzima se zbir cifara broja
			if((broj.get(i)) * 2 > 9){
				rez += (broj.get(i) * 2) % 10 + (broj.get(i) * 2) / 10;	
			} 
			else{				
				rez += (broj.get(i)) * 2;		
			}
		}
		return rez;
	}
	/*
	 * Return sum of odd-place digits in number
	 */
	public static int sumOfOddPlace(){
		int rez = 0;
		//prolazak kroz listu cifara broja kreditne kartice smjestenih na neparnim pozicijama
		for(int i = 0; i < broj.size(); i = i + 2){
			rez += broj.get(i);
		}
		return rez;
	}
	/*
	 * Return true if the card number start with 4, 5, 37, 6
	 */
	public static boolean prefixMatched(){
		boolean prefixMatched = false;
		if(broj.get(broj.size() - 1) == 4 || broj.get(broj.size() - 1) == 5 
				|| broj.get(broj.size() - 1) == 6 || (broj.get(broj.size() - 1) == 3 && broj.get(broj.size() - 2) == 7)){
			prefixMatched = true;
		}
		return prefixMatched;
	}

	/*
	 * Return the number of digits in d
	 */
	public static int getSize(){	
		return broj.size();
	}
}
