package RomanStack;

import java.util.*;
/*
 * Checks if Roman Numeral is in correct form
 */
public class check {
	private static ArrayList<String> stringDigits = new ArrayList<String>();
	/*public int check(String number, String v, String u){
		int check = 0;
		if(number.contains(v)){
		String a = replace(number, v);
		String a2 = "";
		Scanner s = new Scanner(a);
		String a1 = s.next();
		s.next();
		if(s.hasNext()){
	    a2 = s.next();
		}
		if(a1.contains(u)&&a2.contains(u)&&u!=v){
			if(number.replaceAll(u, "").length()==0){
				check = 0;
			}else{

			check = 1;
		}	
		}
		}
		return check;
	}
		  /check consecs
	public int checkConsec(String number, char x1, int y){
		int check = 0;
		int counter = 0;
		int length = number.length();
		for(int x = 0; x<length;x++){
		if(number.charAt(x)== x1){
			counter++;
		}else{
			//counter--;
		}
		if(counter>=y){
			//System.out.println("ERROR!");
			check = 1;
		}
		}
		return check;
	}
	// check consecs
	public int checkConsecs(String number){
		int a = checkConsec(number,'I',4);
		int b = checkConsec(number,'V',2);
		int c = checkConsec(number,'X',4);
		int d = checkConsec(number,'L',2);
		int e = checkConsec(number,'C',4);
		int f = checkConsec(number,'D',2);
		int g = checkConsec(number,'M',4);
		int total = a+b+c+d+e+f+g;
	//	System.out.println("CONSEC:" +total);
		return total;
	}
	/// check sides, final, and power

		// For Roman
	//checks operators
	// check operators
	public static int checkPower(String number){
		int x = 0;
		arabValue a = new arabValue();
		stringDigits = a.getDigits(number, x, stringDigits);
		Stack stack = a.getStack(stringDigits);
		Stack value = a.getValue(stringDigits);
		int length = number.length() - 1;
		int temp1 = (Integer) value.peek();
		int total = temp1;
		int check = 0;
		for(int j = 0; j<length;j++ ){
		int temp = (Integer) value.peek();
		if(j==0){
		value.pop();
		}
		int nextValue = (Integer) value.peek();
		//System.out.println(temp + "  "+ nextValue + "  " + total);
		if(temp>(nextValue+4)){
				check = 1;
		}
		value.pop();
		}
		return check;
	}
	// check sides
	public int checkAll(String number, String x){
		int a = check(number,"V",x);
		int b = check(number,"X",x);
		int c = check(number,"L",x);
		int d = check(number,"C",x);
		int e = check(number,"D",x);
		int f = check(number,"M",x);
		int total = a+b+c+d+e+f;
		return total;
	
	}
	//check sides
	public int checkSides(String number){
		int a = checkAll(number,"I");
		int b =checkAll(number,"V");
		int c = checkAll(number,"X");
		int d = checkAll(number,"L");
		int e = checkAll(number,"C");
		int f = checkAll(number,"D");
		int g = checkAll(number,"M");
		int total = a+b+c+d+e+f+g;
	//	System.out.println("SIDES:" +total);
		return total;
	}
	public int checkMult(String number, String v, String u, char u1){
		int check = 0;
		if(number.contains(v)){
		int counter = 0;
		String a = replace(number, v);
		String a2 = "";
		Scanner s = new Scanner(a);
		String a1 = s.next();
		if(s.hasNext()){
	    s.next();
		}
		a2 = s.next();
		if(a1.contains(u)){
			Scanner s1 = new Scanner(a1);
			int length = a1.length();
			for(int x = 0; x<length; x++){
				if(a1.charAt(x)==u1){
					counter++;
				}
			}
			if(counter>1){
				//System.out.println("ERROR!");
				check = 1;
			}
		}
	}
		return check;
	}
	public int checkAllMult(String number, String x, char x1){
		int a = checkMult(number, "V", x, x1);
		//int b = checkMult(number, "X", x, x1);
		int c = checkMult(number, "L", x, x1);
	//	int d = checkMult(number, "C", x, x1);
		int e = checkMult(number, "D", x, x1);
		int f = checkMult(number, "M", x, x1);
		int total = a+c+e+f;
		return total;
	}
	public int checkAllMults(String number){
	//	int a = checkAllMult(number,"I",'I');
		int b = checkAllMult(number,"V",'V');
	//	int c = checkAllMult(number,"X",'X');
		int d = checkAllMult(number,"L",'L');
		//int e = checkAllMult(number,"C",'C');
		int f = checkAllMult(number,"D",'D');
		int g =checkAllMult(number,"M",'M');
		int total = b+d+f+g;
		System.out.println("MULTS:" +total);
		return total;
	}
*/

	// Checks if roman numeral is in correct form
	public boolean checkFinal(String number){
		boolean check = true;
		RomanStack r = new RomanStack();
		int e = checkReal(number);
		int total = e;
		if(total>0){// if roman numeral is in inccorect form, send false boolean to main method
			System.out.println("ERROR! INVALID INPUT!");
			check = false;
		}
		return check;
	}
	public static String checkSpace(String line){
		if(line.contains("+")){
			line = line.replace("+", "\n + \n");
		}else if(line.contains("*")){
			line = line.replace("*", "\n * \n");
		}else if(line.contains("-")){
			line = line.replace("-", "\n - \n");
		}else if(line.contains("/")){
			line = line.replace("/", "\n / \n");	
		}
		return line;
	}
	/*
	 * Checks operators in the input given for Roman Numerals
	 */
	public void checkAction(String line, int value1, int value2){
		romanValue r = new romanValue();
		int sum = 0, product = 0, quotient = 0, difference = 0;
		if(line.contains("*")){ // if star multiply
			product = value1*value2;
			System.out.println("Product is "+ product);
			r.convert(product);
		}else if(line.contains("/")){ // if forward slash divide
			quotient = value1/value2;
			System.out.println("Quotient is "+ quotient);
			r.convert(quotient);
		}else if(line.contains("+")){ // if plus add
			sum = value1+value2;
			System.out.println("Sum is "+ sum);
			r.convert(sum);
		}else if(line.contains("-")){ // if minus subtract
			difference = value1-value2;
			System.out.println("Difference is "+ difference);
			r.convert(difference);
		}
	}
	// For Arabic;
	/*
	 * Checks operators in the input given for Arabic Numerals and performs action
	 */
	public void checkAction2(String line, int value1, int value2){
		romanValue r = new romanValue();
		int sum = 0, product = 0, quotient = 0, difference = 0;
		if(line.contains("*")){ // if star mulitply
			product = value1*value2;
			//System.out.println("Product is "+ product);
			System.out.print(product);
		}else if(line.contains("/")){ // if forward slash divide
			quotient = value1/value2;
			System.out.println(quotient);
			//System.out.println("Quotient is "+ quotient);
		}if(line.contains("+")){ // if plus sign add
			sum = value1+value2;
			System.out.println(sum);
			//System.out.println("Sum is "+ sum);
		}if(line.contains("-")){ // if minus subtract
			difference = value1-value2;
			System.out.print(difference);
			//System.out.println("Difference is "+ difference);
		}
	}
	/*
	 * Checks if the form of the Roman Numeral given is correct
	 */
	public static int checkReal(String number){
		arabValue a = new arabValue();
		romanValue r = new romanValue();
		int check = 0;
		int value1 = a.getFinal(number);
		if(!(number.equals(r.convert2(value1)))){ // if roman numeral given is not equal to the real roman numeral form, ERROR
			//System.out.println(value1);
			check = 1;
		}
		return check;
	}
}
//

	