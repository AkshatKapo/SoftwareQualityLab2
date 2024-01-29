package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number) {
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch=number.charAt(i);
			if(ch!='0' && ch!='1') {
				number="0"; // if not store "0" and end the function
				return;
			}
		}
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any


		if(this.number=="") { // replace empty strings with a single zero
			this.number="0";
		}




    }
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}



	public static Binary OR (Binary num1,Binary num2) {

        //// the index of the first digit of each number
		int ind3 = num1.number.length()-1 ;
		int ind4 = num2.number.length()-1 ;

        // Defining variable
		int j ;
        // Defining a String to store the answer
		String Number = "";

		// Loop that iterate over each digit in numbers
		while(ind3>=0 || ind4>=0){
           // Variable to store 1 and 0 and it gets reset when loop runs each time
			 j =0;

		if (ind3 >= 0) {  // checks the index of each digit and if it's less then 0 means no more digit left

			  j = (num1.number.charAt(ind3) == '1') ? 1 : j;  // checks whether digit at that index is 1 or no, if its 1 then J stores 1 ,
			                                                 // if not 1 then it stores the value of the J which is 0
			ind3--; // index decrements because it starts from last digit

		}
		if (ind4 >= 0) { // checks the index of each digit of second binary number and if it's less then 0 means no more digit left

			j = (num2.number.charAt(ind4) == '1') ? 1 : j;  // checks if the digit at that index is 1, if it is J stores 1 and if not then j stores its previous value
			  // It means that if the digit of first number is 1 and the digit of second number is also 1 it stores 1 and if the digit of second number is not 1, its still stores 1 because the
                                                            // because the digit of first number is still 1 and that's how OR works
			ind4--; // index decrements because it starts from last digit


		}


		Number = ((j==1)? "1":"0") + Number;  // stores the Number to get overall result its stores 1 digit at a time and it checks if j is 1 then the digit of the answer would be 1, if not then it will be 0

	}
		Binary result1 = new Binary(Number); // creates a binary object and stores the answer is result variable
		return result1; // Returns the answer to the App.java
	}

	// AND Operator, it takes 2 binary numbers and do AND operation
	public static Binary And  (Binary num1,Binary num2) {
		//// the index of the first digit of each number
		int ind3 = num1.number.length()-1 ;
		int ind4 = num2.number.length()-1 ;
		int and=0 ;

		//Defining a String to store the answer
		String Answer = "";
		//
		while(ind3>=0 || ind4>=0){
			// Variables to store the digits of each number, and they get reset, whenever the loop runs again
			int x = 0;
			int y=0;
			and =0;


			// checks the index of each digit and if it's less then 0 means no more digit left
			if (ind3 >= 0) {
				x = (num1.number.charAt(ind3) == '1') ? 1 : 0; // X variable stores 1 if the digit at that index
				                                               // is 1 if not then it stores o
				ind3--;

			}
			// checks the index of each digit and if it's less then 0 means no more digit left
			if (ind4 >= 0) {
				y = (num2.number.charAt(ind4) == '1') ? 1:0;// y variable stores 1 if the digit at that index
				                                            // is 1 if not then it stores o
				ind4--; // index decrements because it starts from last digit
			}

			if(x==1 & y==1){  // Checks if the digits of both number are 1, if 1 then and stores 1
				 and = 1;    //  Its just how AND operator works, if the digits of both numbers are 1, then the answer is 1

			}
			Answer = ((and==1)? "1":"0") + Answer;  // It stores the eac digit, like if and variable is 1, it will put 1 or if its 0 it will put 0


		}
		Binary reult1 = new Binary(Answer); // Creates the binary Object
		return reult1; // Returns the answer to getter and then it returns the answer in main class
	}
	public static Binary multiply(Binary num1, Binary num2) {

        // Variables that stores 2  binary numbers, that we have
		String Binary_Number1 = num1.getValue();
		String Binary_Number2 = num2.getValue();



        // Converts first binary number in to Decimal and store it in the variable
		int Decimal_Number1 = Integer.parseInt(Binary_Number1,2);
		// Converts second binary number in to Decimal and store it in the variable
		int Decimal_Number2 = Integer.parseInt(Binary_Number2,2);
        // It multiplies both decimal numbers and store in the variable
		int Decimal_Number3 = Decimal_Number1*Decimal_Number2;
        // .toBinaryString converts the product of those two numbers into binary
		String Answer  = Integer.toBinaryString(Decimal_Number3);

		// Creates a binary Object
		Binary result = new Binary(Answer);

		return result; // Returns the answer to getter and then it returns the answer in main classD


	}









}

