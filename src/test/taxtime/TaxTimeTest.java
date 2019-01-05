package taxtime;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.jupiter.api.BeforeEach;


public class TaxTimeTest {
	private ByteArrayInputStream in;
	// https://stefanbirkner.github.io/system-rules/
	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();
	
	// ------ https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println ------
	// also tried this, but for our use it was inappropriate because the TaxTime is printing not only answers but questions to the console
	// didnt really need it anyway
	//private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	//private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	//private final PrintStream originalOut = System.out;
	//private final PrintStream originalErr = System.err;
	
	/*@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}*/

	/*@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}*/
	
	// ----------------------------
	
	@Test(expected = NumberFormatException.class)
	public void InvalidNumberIncome () {
		in = new ByteArrayInputStream("abc)2".getBytes());
		System.setIn(in);
		TaxTime.main(null);
	}
	
	@Test
	public void NegativeIncome () {
		in = new ByteArrayInputStream("-23".getBytes());
		System.setIn(in);
		exit.expectSystemExit();
		TaxTime.main(null);
	}
	
	@Test(expected = NumberFormatException.class)
	public void InvalidNumberDependents () {
		in = new ByteArrayInputStream("230\r\n2.3".getBytes());
		System.setIn(in);
		TaxTime.main(null);
	}
	
	@Test
	public void TooFewDependents () {
		in = new ByteArrayInputStream("230\r\n0".getBytes());
		System.setIn(in);
		exit.expectSystemExit();
		TaxTime.main(null);
	}
	
	@Test
	public void correctInput () {
		in = new ByteArrayInputStream("7000\r\n2".getBytes());
		System.setIn(in);
		TaxTime.main(null);
		assertEquals(540.0, TaxTime.taxTotal, 0.001);
	}
}
