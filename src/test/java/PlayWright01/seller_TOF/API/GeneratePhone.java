package PlayWright01.seller_TOF.API;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GeneratePhone {

	public static void main(String[] args) {

		System.out.println("Generated Unique Phone Number: " + generateUniquePhoneNumber());
	}

	private static final Set<String> generatedNumbers = new HashSet<>();
	private static final Random random = new Random();

	public static String generateUniquePhoneNumber() {
		String phoneNumber;
		do {
			// Ensure the first digit is between 6 and 9
			int firstDigit = 6 + random.nextInt(4); // 6, 7, 8, or 9

			// Generate the remaining 9 digits
			StringBuilder sb = new StringBuilder();
			sb.append(firstDigit);
			for (int i = 1; i < 10; i++) {
				int digit = random.nextInt(10); // Random digit between 0 and 9
				sb.append(digit);
			}
			phoneNumber = sb.toString();
		} while (generatedNumbers.contains(phoneNumber)); // Ensure uniqueness

		// Add the new unique number to the set
		generatedNumbers.add(phoneNumber);
		return phoneNumber;

	}

}
