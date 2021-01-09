import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import MorseCode.MorseCodeConverter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverterTestStudent {
	File inputFile;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrintTree()
	{
		//Note the extra space between j and b - that is because there is an empty string that
		//is the root, and in the LNR traversal, the root would come between the right most
		//child of the left tree (j) and the left most child of the right tree (b).
		String correctResult = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
		String s = MorseCodeConverter.printTree();
		s = s.trim(); // take off preceeding or succedding spaces
		assertEquals(correctResult, s);
	}
	
	@Test
	public void testConvertToEnglishString() {	
		String STUDENTtest = MorseCodeConverter.convertToEnglish("-.-. --- -- .--. ..- - . .-. / ... -.-. .. . -. -.-. .");
		assertEquals("computer science", STUDENTtest);
		
		String STUDENTtest2 = MorseCodeConverter.convertToEnglish("-- .- .-. ...- . .-..");
		assertEquals("marvel", STUDENTtest2);
	}

	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {
		String STUDENTtest = "with great power comes great responsibility";
		getFile("Spiderman.txt");
		String STUDENTconverter = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(STUDENTtest, STUDENTconverter);
		
		String STUDENTtest2 = "wives should be kissed not heard";
		getFile("FantasticFour.txt");
		String STUDENTconverter2 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(STUDENTtest2, STUDENTconverter2);
		

	}
	
	public void getFile(String in) throws FileNotFoundException {		
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if(status == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inputFile = chooser.getSelectedFile();
				// readFile();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
