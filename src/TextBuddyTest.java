import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;

public class TextBuddyTest extends TextBuddy {

	@Test
	public void testExecuteCommand() throws IOException {
		ArrayList<String> expected = openFile("testfile.txt");
		clearFile();

		// unit testing for add
		expected = new ArrayList<String>();
		expected.add("added to testfile.txt: \"little brown fox\"");
		testAddCommand("add first", expected, " little brown fox");

		// unit testing for display
		expected = new ArrayList<String>();
		expected.add("1. little brown fox");
		testDisplayCommand("display first", expected);

		// unit testing for delete
		expected = new ArrayList<String>();
		expected.add("deleted from testfile.txt: \"little brown fox\"");
		testDeleteCommand("delete 1", expected, "1");

		// unit testing for display
		expected = new ArrayList<String>();
		expected.add("testfile.txt is empty");
		testDisplayCommand("display empty", expected);
	}

	// execute command add
	private void testAddCommand(String description, ArrayList<String> expected, String text) throws IOException {
		assertEquals(description, expected, TextBuddy.addText(text));
	}

	// execute command display
	private void testDisplayCommand(String description, ArrayList<String> expected) throws IOException {
		assertEquals(description, expected, TextBuddy.displayFile());
	}

	private void testDeleteCommand(String description, ArrayList<String> expected, String index) throws IOException {
		assertEquals(description, expected, TextBuddy.deleteLine(index));
	}

}
