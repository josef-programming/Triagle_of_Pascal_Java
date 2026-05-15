/**
 * This class calculates the triangle of pascal with the binomial coefficient.
 *
 * @author Josef Reinnagel Lueck
 * @version 1.00, 01.2026
 */

public class PascalCalc {

/**
 * Calculates the triangle rows, given by the user.
 * @param rowCount The row number.
 */
	public static void giveOutTriangle(long rowCount)
	{
		long counterN = 0;
		long counterK = 0;
		boolean distanceCounter = true;
		long result = 1;

		do 
		{
			if (distanceCounter)
			{
				moveSpace(rowCount, counterN);
			}
			if (counterK <= counterN)
			{
				result = calculateNoK(counterN, counterK);
				java.lang.System.out.print(result + " ");
				counterK++;
				distanceCounter = false;
			}
			else
			{
				counterN++;
				counterK = 0;
				System.out.print("\n");
				distanceCounter = true;
			}
		}while (counterN < rowCount);
	}
	
/**
 * Creates an offset between the numbers that are given out.
 * @param distance Used for calculation of the space distance between the numbers.
 * @param rowCounter Number given by the user.
 */
	static void moveSpace(long distance, long rowCounter)
	{

		long space = distance -rowCounter - 1;
		long spaceCounter = 0;
		while (spaceCounter < space)
		{
			java.lang.System.out.print(" ");
			spaceCounter++;
		}
	}

	/**
	 * This method calculates n over k and is needed for the method giveOutTriangle
	 * @param n 
	 * @param k
	 * @return Returns n over k value.
	 */
	public static long calculateNoK(long n, long k)
	{
		long result;
		result = calculateFaculty(n)/(calculateFaculty(k)*calculateFaculty(n - k));
		return result;
	}

	/**
	 * Calculates the faculty.
	 * @param target The number from which the faculty is to be calculated.
	 * @return Result of target number faculty.
	 */
	public static long calculateFaculty(long target)
	{
		long zaehler = 1;
		long zahl = 1;
		while (zaehler <= target)
		{
			zahl = zahl * zaehler;
			zaehler++;
		}
		return zahl;
	}
}
