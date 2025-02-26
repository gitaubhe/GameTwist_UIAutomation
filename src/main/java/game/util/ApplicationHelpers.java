package game.util;

import java.util.Random;

public class ApplicationHelpers {

	public static String generateUniqueEmail(String email) {
		Random random = new Random();
		String userName = "";
		String domain = "";
		String[] strArray = email.split("@");
		if (strArray.length == 2) {
			userName = strArray[0];
			domain = strArray[1];
		} else {
			System.out.println("Invalis email format: " + email);
		}

		String characters = "abcdefghijklmnopqrstuvwxyz0123456789";

		// Generate a random username with 3 to 5 characters
		int usernameLength = 3 + random.nextInt(2); // Random length between 3 and 5
		StringBuilder username = new StringBuilder();
		username.append(userName);
		for (int i = 0; i < usernameLength; i++) {
			username.append(characters.charAt(random.nextInt(characters.length())));
		}

		return new String(username) + "@" + domain;
	}

	public static String generateUniqueNickName(String nickName) {
		Random random = new Random();
		return nickName + random.nextInt(200);
	}

}
