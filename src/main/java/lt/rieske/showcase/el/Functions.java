package lt.rieske.showcase.el;

import java.io.IOException;

public final class Functions {

	private Functions() {
	}

	public static String greetUser(String user) throws IOException {
		return "Hello" + (user == null ? "" : " " + user) + "!";
	}
}
