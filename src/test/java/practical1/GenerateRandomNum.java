package practical1;

import java.util.Random;
import java.util.Scanner;

public class GenerateRandomNum {

	public static void main(String[] args) {

		Scanner ui = new Scanner(System.in);
		System.out.println("Enter the boundary number so that the random number can't go above it: ");
		int boundaryNum = ui.nextInt();
		System.out.println("Enter the number that the random number should be less than: ");
		int n = ui.nextInt();

		System.out.println("***************************************");

		for (int i = 0; i < 500; i++) {
			int randomNum = generateRandomNum(boundaryNum);
			System.out.println("The " + i + " random number is: " + randomNum);

			if (randomNum < n) {
				System.out.println("The number smaller than " + n + " is: " + randomNum);
			}
		}

	}

	public static int generateRandomNum(int boundaryNum) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(boundaryNum);

		return generatedNum;
	}

}
