
/**
 * ============================================================
 * Project: PascalsTriangle
 * Class: Output
 *
 * Description:
 * This class defines the Output Elements, for the triagle and uses the class "PascalCalc".
 * 
 * @author Josef Reinnagel Lueck
 * @version 1.00, 01.2026
 * ============================================================
 */

public class Output 
{
	final static long numberMin = 1;
	final static long numberMax = 20;
	
	static boolean inputSuccessful = false; // variable which controls successful inputs

	/**
	 * This Method tries to catch IOException if an Error occurs while the User input happens.
	 * It also buffers the input to save the value effective.
	 * @return Returns the input value of the user as a String.
	 */
	private static java.lang.String controlInput()
	{
		java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(java.lang.System.in);
		java.io.BufferedReader bufferedReader = new java.io.BufferedReader(inputStreamReader);
		java.lang.String input = " ";
		try
		{
			input = bufferedReader.readLine();
			inputSuccessful = true;
			return input;
		}
		catch (java.io.IOException ioException)
		{
			java.lang.System.out.println("Fehlerhafte eingabe: " + ioException);
			inputSuccessful = false;
			return "Conversion Error";
		}
	}

	/**
	 * This Method tries to format the String Input to a long type
	 * @param inputText The Input of the user.
	 * @return If the conversion was successful the user value is returned. If not the return is 0.
	 * @exception numberFormatException Occurs when the given String can't be converted to long.
	 */
	private static long tryToFormat(java.lang.String inputText)
	{
		long number = 0;
		try 
		{
			number = java.lang.Long.parseLong(inputText);
			java.lang.System.out.println("The input of your number was successful!");
			inputSuccessful = true;
			return number;
		}
		catch (java.lang.NumberFormatException numberFormatException)
		{
			java.lang.System.out.println("An Error occured: " + numberFormatException);
			inputSuccessful = false;
			return 0;
		}
		
	}

	/**
	 * This method controls if the read in number lays between a min and max.
	 * 
	 * @param number Input number of the User.
	 * @return Returns the number after controlling if the number lays between a min and max.
	 */
	private static  long controlMinMax(long number)
	{	
		long numberMinMax = 0;
		if (numberMin <= number && number <= numberMax)
		{
			java.lang.System.out.println("You're number lays between " + numberMin + " and " + numberMax + ".");
			 numberMinMax = number;
			inputSuccessful = true;
			return numberMinMax;
		}
		else
		{
			java.lang.System.out.println("The Input is not between " + numberMin + " and " + numberMax + ".");
			inputSuccessful = false;
			System.out.println(numberMinMax);
			return 0;
		}			
	}

	/**
	 * This method combines the methods in the class Output, to perform a User input request. 
	 * @return The given number of the user.
	 */
	private static long startOutput()
	{
		java.lang.String inputText = " ";
		long number = 0;
		long numberMinMax = 0;
		while (inputSuccessful == false)
		{
			inputText = controlInput();
			number = tryToFormat(inputText);
			numberMinMax = controlMinMax(number);
		}
		return numberMinMax;
	}

	public static void main(java.lang.String [] args)
	{
		java.lang.System.out.println("Please insert a number for the rows between " + numberMin + " and " + numberMax);
		long numberN = startOutput();
		PascalCalc.giveOutTriangle(numberN);
	}
}
