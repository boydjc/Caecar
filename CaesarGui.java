import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class CaesarGui extends JFrame implements ActionListener {
	
	// program will be made out of 3 different panels
	
	private JPanel topPanel = new JPanel(); // used for top label only
	private JPanel inOutPanel = new JPanel(); // used to contain the input and output fields
	private JPanel buttonPanel = new JPanel(); // used to contain encrypt and decrypt buttons

	// Big label on top
	private JLabel topLabel = new JLabel("Caesar Cipher Engine");
	private Font topLabelFont = new Font("Times New Roman", Font.BOLD, 35);
	
	// combobox for shift
	
	private JLabel shiftLabel = new JLabel("Shift ");
	private Font shiftFont = new Font("Times New Roman", Font.BOLD, 20);
	
	private static String[] shifts = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"};
	
	private static JComboBox<String> shiftBox = new JComboBox<String>(shifts);
	
	// Input TextField and label
	
	private JLabel inLabel = new JLabel("Input:  ");
	private Font inOutLabelFont = new Font("Times New Roman", Font.PLAIN, 20);
	private JTextField inputText = new JTextField(50);
	
	// Output TextField and Label
	
	private JLabel outLabel = new JLabel("Output: ");
	private JTextField outputText = new JTextField(50);
	
	// Buttons for Encrypt and Decrypt
	
	private JButton enButton = new JButton("Encrypt");
	private JButton deButton = new JButton("Decrypt");

	
	CaesarGui(){
		// configurations for the Frame
		
		super("Caesar Cipher");
		setResizable(false);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// end Frame configurations with the exception of setSize
		
		// configurations for the panels
		
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
		inOutPanel.setLayout(new BoxLayout(inOutPanel, BoxLayout.PAGE_AXIS));
		buttonPanel.setLayout(new FlowLayout());
		
		// end configurations for panels
		
		
		// start adding stuff to panels
		
			// top Label stuff
		
		topLabel.setFont(topLabelFont);
		shiftLabel.setFont(shiftFont);
		topPanel.add(topLabel);
		topPanel.add(shiftLabel);
		topPanel.add(shiftBox);
		
			// Input Field and label
		
		inLabel.setFont(inOutLabelFont);
		outLabel.setFont(inOutLabelFont);
		outputText.setEditable(false);
		inOutPanel.add(inLabel);
		inOutPanel.add(inputText);
		inOutPanel.add(outLabel);
		inOutPanel.add(outputText);
		
			// Encrypt and Decrypt buttons
		
		enButton.addActionListener(this);
		deButton.addActionListener(this);
		
		buttonPanel.add(enButton);
		buttonPanel.add(deButton);
		
		// end adding things to panels
		
		// start adding panels to frame
		
		add(topPanel);
		add(inOutPanel);
		add(buttonPanel);
		
		// end adding to Frame
		
		setSize(600, 275); // This is last because if not then components wont show up on launch
	}
	
	public void displayFrame() {
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(((JButton) source).getText().equals("Encrypt")) {
			encryptText(inputText.getText());
		}else if(((JButton) source).getText().equals("Decrypt")) {
			decryptText(inputText.getText());
		}
		
	}
	
	/* a caesar cypher switches each letter with letters down from it based on a shift variable
	 * we will use a Map listing to decide which letter corresponds to another
	 * letter
	 */
	
	public void encryptText(String text) {

		
		String cipherText = "";
		
		Map<Character, Character> enMap  = new HashMap<Character, Character>();
		
		enMap = setEncryptMap(String.valueOf(shiftBox.getSelectedItem()));
		
		
		String textLower = text.toLowerCase();
		
		for(int textCount=0; textCount<textLower.length(); textCount++) {
			cipherText += enMap.get(textLower.charAt(textCount));
		}
		
		outputText.setText(cipherText);
		
	}
	
	public void decryptText(String text) {

		
		
		String plainText = "";
		
		Map<Character, Character> deMap  = new HashMap<Character, Character>();
		
		deMap = setDecryptMap(String.valueOf(shiftBox.getSelectedItem()));
		
		
		String textLower = text.toLowerCase();
		
		
		for(int textCount=0; textCount<textLower.length(); textCount++) {
			plainText += deMap.get(textLower.charAt(textCount));
		}
		
		outputText.setText(plainText);
		
	}
	
	public Map<Character, Character> setEncryptMap(String shift) {
		
		Map<Character, Character> enMap  = new HashMap<Character, Character>();
		
		/* each switch case corresponds to a letter shift for encryption and requires a different
		 * letter mapping
		 */
		
		switch(shift) {
		
			case "1":
				enMap.put('a', 'b'); enMap.put('b', 'c'); enMap.put('c', 'd'); enMap.put('d', 'e');
				enMap.put('e', 'f'); enMap.put('f', 'g'); enMap.put('g', 'h'); enMap.put('h', 'i');
			    enMap.put('i', 'j'); enMap.put('j', 'k'); enMap.put('k', 'l'); enMap.put('l', 'm');
				enMap.put('m', 'n'); enMap.put('n', 'o'); enMap.put('o', 'p'); enMap.put('p', 'q');
				enMap.put('q', 'r'); enMap.put('r', 's'); enMap.put('s', 't'); enMap.put('t', 'u');
				enMap.put('u', 'v'); enMap.put('v', 'w'); enMap.put('w', 'x'); enMap.put('x', 'y');
				enMap.put('y', 'z'); enMap.put('z', 'a'); enMap.put(' ', ' ');
				break;
			
			case "2":
				enMap.put('a', 'c'); enMap.put('b', 'd'); enMap.put('c', 'e'); enMap.put('d', 'f');
				enMap.put('e', 'g'); enMap.put('f', 'h'); enMap.put('g', 'i'); enMap.put('h', 'j');
				enMap.put('i', 'k'); enMap.put('j', 'l'); enMap.put('k', 'm'); enMap.put('l', 'n');
				enMap.put('m', 'o'); enMap.put('n', 'p'); enMap.put('o', 'q'); enMap.put('p', 'r');
				enMap.put('q', 's'); enMap.put('r', 't'); enMap.put('s', 'u'); enMap.put('t', 'v');
				enMap.put('u', 'w'); enMap.put('v', 'x'); enMap.put('w', 'y'); enMap.put('x', 'z');
				enMap.put('y', 'a'); enMap.put('z', 'b'); enMap.put(' ', ' ');
				break;
			case "3":
				enMap.put('a', 'd'); enMap.put('b', 'e'); enMap.put('c', 'f'); enMap.put('d', 'g');
				enMap.put('e', 'h'); enMap.put('f', 'i'); enMap.put('g', 'j'); enMap.put('h', 'k');
				enMap.put('i', 'l'); enMap.put('j', 'm'); enMap.put('k', 'n'); enMap.put('l', 'o');
				enMap.put('m', 'p'); enMap.put('n', 'q'); enMap.put('o', 'r'); enMap.put('p', 's');
				enMap.put('q', 't'); enMap.put('r', 'u'); enMap.put('s', 'v'); enMap.put('t', 'w');
				enMap.put('u', 'x'); enMap.put('v', 'y'); enMap.put('w', 'z'); enMap.put('x', 'a');
				enMap.put('y', 'b'); enMap.put('z', 'c'); enMap.put(' ', ' ');
				break;
			case "4":
				enMap.put('a', 'e'); enMap.put('b', 'f'); enMap.put('c', 'g'); enMap.put('d', 'h');
				enMap.put('e', 'i'); enMap.put('f', 'j'); enMap.put('g', 'k'); enMap.put('h', 'l');
				enMap.put('i', 'm'); enMap.put('j', 'n'); enMap.put('k', 'o'); enMap.put('l', 'p');
				enMap.put('m', 'q'); enMap.put('n', 'r'); enMap.put('o', 's'); enMap.put('p', 't');
				enMap.put('q', 'u'); enMap.put('r', 'v'); enMap.put('s', 'w'); enMap.put('t', 'x');
				enMap.put('u', 'y'); enMap.put('v', 'z'); enMap.put('w', 'a'); enMap.put('x', 'b');
				enMap.put('y', 'c'); enMap.put('z', 'd'); enMap.put(' ', ' ');
				break;
			case "5":
				enMap.put('a', 'f'); enMap.put('b', 'g'); enMap.put('c', 'h'); enMap.put('d', 'i');
				enMap.put('e', 'j'); enMap.put('f', 'k'); enMap.put('g', 'l'); enMap.put('h', 'm');
				enMap.put('i', 'n'); enMap.put('j', 'o'); enMap.put('k', 'p'); enMap.put('l', 'q');
				enMap.put('m', 'r'); enMap.put('n', 's'); enMap.put('o', 't'); enMap.put('p', 'u');
				enMap.put('q', 'v'); enMap.put('r', 'w'); enMap.put('s', 'x'); enMap.put('t', 'y');
				enMap.put('u', 'z'); enMap.put('v', 'a'); enMap.put('w', 'b'); enMap.put('x', 'c');
				enMap.put('y', 'd'); enMap.put('z', 'e'); enMap.put(' ', ' ');
				break;
			case "6":
				enMap.put('a', 'g'); enMap.put('b', 'h'); enMap.put('c', 'i'); enMap.put('d', 'j');
				enMap.put('e', 'k'); enMap.put('f', 'l'); enMap.put('g', 'm'); enMap.put('h', 'n');
				enMap.put('i', 'o'); enMap.put('j', 'p'); enMap.put('k', 'q'); enMap.put('l', 'r');
				enMap.put('m', 's'); enMap.put('n', 't'); enMap.put('o', 'u'); enMap.put('p', 'v');
				enMap.put('q', 'w'); enMap.put('r', 'x'); enMap.put('s', 'y'); enMap.put('t', 'z');
				enMap.put('u', 'a'); enMap.put('v', 'b'); enMap.put('w', 'c'); enMap.put('x', 'd');
				enMap.put('y', 'e'); enMap.put('z', 'f'); enMap.put(' ', ' ');
				break;
			case "7":
				enMap.put('a', 'h'); enMap.put('b', 'i'); enMap.put('c', 'j'); enMap.put('d', 'k');
				enMap.put('e', 'l'); enMap.put('f', 'm'); enMap.put('g', 'n'); enMap.put('h', 'o');
				enMap.put('i', 'p'); enMap.put('j', 'q'); enMap.put('k', 'r'); enMap.put('l', 's');
				enMap.put('m', 't'); enMap.put('n', 'u'); enMap.put('o', 'v'); enMap.put('p', 'w');
				enMap.put('q', 'x'); enMap.put('r', 'y'); enMap.put('s', 'z'); enMap.put('t', 'a');
				enMap.put('u', 'b'); enMap.put('v', 'c'); enMap.put('w', 'd'); enMap.put('x', 'e');
				enMap.put('y', 'f'); enMap.put('z', 'g'); enMap.put(' ', ' ');
				break;
			case "8":
				enMap.put('a', 'i'); enMap.put('b', 'j'); enMap.put('c', 'k'); enMap.put('d', 'l');
				enMap.put('e', 'm'); enMap.put('f', 'n'); enMap.put('g', 'o'); enMap.put('h', 'p');
				enMap.put('i', 'q'); enMap.put('j', 'r'); enMap.put('k', 's'); enMap.put('l', 't');
				enMap.put('m', 'u'); enMap.put('n', 'v'); enMap.put('o', 'w'); enMap.put('p', 'x');
				enMap.put('q', 'y'); enMap.put('r', 'z'); enMap.put('s', 'a'); enMap.put('t', 'b');
				enMap.put('u', 'c'); enMap.put('v', 'd'); enMap.put('w', 'e'); enMap.put('x', 'f');
				enMap.put('y', 'g'); enMap.put('z', 'h'); enMap.put(' ', ' ');
				break;
			case "9":
				enMap.put('a', 'j'); enMap.put('b', 'k'); enMap.put('c', 'l'); enMap.put('d', 'm');
				enMap.put('e', 'n'); enMap.put('f', 'o'); enMap.put('g', 'p'); enMap.put('h', 'q');
				enMap.put('i', 'r'); enMap.put('j', 's'); enMap.put('k', 't'); enMap.put('l', 'u');
				enMap.put('m', 'v'); enMap.put('n', 'w'); enMap.put('o', 'x'); enMap.put('p', 'y');
				enMap.put('q', 'z'); enMap.put('r', 'a'); enMap.put('s', 'b'); enMap.put('t', 'c');
				enMap.put('u', 'd'); enMap.put('v', 'e'); enMap.put('w', 'f'); enMap.put('x', 'g');
				enMap.put('y', 'h'); enMap.put('z', 'i'); enMap.put(' ', ' ');
				break;
			case "10":
				enMap.put('a', 'k'); enMap.put('b', 'l'); enMap.put('c', 'm'); enMap.put('d', 'n');
				enMap.put('e', 'o'); enMap.put('f', 'p'); enMap.put('g', 'q'); enMap.put('h', 'r');
				enMap.put('i', 's'); enMap.put('j', 't'); enMap.put('k', 'u'); enMap.put('l', 'v');
				enMap.put('m', 'w'); enMap.put('n', 'x'); enMap.put('o', 'y'); enMap.put('p', 'z');
				enMap.put('q', 'a'); enMap.put('r', 'b'); enMap.put('s', 'c'); enMap.put('t', 'd');
				enMap.put('u', 'e'); enMap.put('v', 'f'); enMap.put('w', 'g'); enMap.put('x', 'h');
				enMap.put('y', 'i'); enMap.put('z', 'j'); enMap.put(' ', ' ');
				break;
			case "11":
				enMap.put('a', 'l'); enMap.put('b', 'm'); enMap.put('c', 'n'); enMap.put('d', 'o');
				enMap.put('e', 'p'); enMap.put('f', 'q'); enMap.put('g', 'r'); enMap.put('h', 's');
				enMap.put('i', 't'); enMap.put('j', 'u'); enMap.put('k', 'v'); enMap.put('l', 'w');
				enMap.put('m', 'x'); enMap.put('n', 'y'); enMap.put('o', 'z'); enMap.put('p', 'a');
				enMap.put('q', 'b'); enMap.put('r', 'c'); enMap.put('s', 'd'); enMap.put('t', 'e');
				enMap.put('u', 'f'); enMap.put('v', 'g'); enMap.put('w', 'h'); enMap.put('x', 'i');
				enMap.put('y', 'j'); enMap.put('z', 'k'); enMap.put(' ', ' ');
				break;
			case "12":
				enMap.put('a', 'm'); enMap.put('b', 'n'); enMap.put('c', 'o'); enMap.put('d', 'p');
				enMap.put('e', 'q'); enMap.put('f', 'r'); enMap.put('g', 's'); enMap.put('h', 't');
				enMap.put('i', 'u'); enMap.put('j', 'v'); enMap.put('k', 'w'); enMap.put('l', 'x');
				enMap.put('m', 'y'); enMap.put('n', 'z'); enMap.put('o', 'a'); enMap.put('p', 'b');
				enMap.put('q', 'c'); enMap.put('r', 'd'); enMap.put('s', 'e'); enMap.put('t', 'f');
				enMap.put('u', 'g'); enMap.put('v', 'h'); enMap.put('w', 'i'); enMap.put('x', 'j');
				enMap.put('y', 'k'); enMap.put('z', 'l'); enMap.put(' ', ' ');
				break;
			case "13":
				enMap.put('a', 'n'); enMap.put('b', 'o'); enMap.put('c', 'p'); enMap.put('d', 'q');
				enMap.put('e', 'r'); enMap.put('f', 's'); enMap.put('g', 't'); enMap.put('h', 'u');
				enMap.put('i', 'v'); enMap.put('j', 'w'); enMap.put('k', 'x'); enMap.put('l', 'y');
				enMap.put('m', 'z'); enMap.put('n', 'a'); enMap.put('o', 'b'); enMap.put('p', 'c');
				enMap.put('q', 'd'); enMap.put('r', 'e'); enMap.put('s', 'f'); enMap.put('t', 'g');
				enMap.put('u', 'h'); enMap.put('v', 'i'); enMap.put('w', 'j'); enMap.put('x', 'k');
				enMap.put('y', 'l'); enMap.put('z', 'm'); enMap.put(' ', ' ');
				break;
			case "14":
				enMap.put('a', 'o'); enMap.put('b', 'p'); enMap.put('c', 'q'); enMap.put('d', 'r');
				enMap.put('e', 's'); enMap.put('f', 't'); enMap.put('g', 'u'); enMap.put('h', 'v');
				enMap.put('i', 'w'); enMap.put('j', 'x'); enMap.put('k', 'y'); enMap.put('l', 'z');
				enMap.put('m', 'a'); enMap.put('n', 'b'); enMap.put('o', 'c'); enMap.put('p', 'd');
				enMap.put('q', 'e'); enMap.put('r', 'f'); enMap.put('s', 'g'); enMap.put('t', 'h');
				enMap.put('u', 'i'); enMap.put('v', 'j'); enMap.put('w', 'k'); enMap.put('x', 'l');
				enMap.put('y', 'm'); enMap.put('z', 'n'); enMap.put(' ', ' ');
				break;
			case "15":
				enMap.put('a', 'p'); enMap.put('b', 'q'); enMap.put('c', 'r'); enMap.put('d', 's');
				enMap.put('e', 't'); enMap.put('f', 'u'); enMap.put('g', 'v'); enMap.put('h', 'w');
				enMap.put('i', 'x'); enMap.put('j', 'y'); enMap.put('k', 'z'); enMap.put('l', 'a');
				enMap.put('m', 'b'); enMap.put('n', 'c'); enMap.put('o', 'd'); enMap.put('p', 'e');
				enMap.put('q', 'f'); enMap.put('r', 'g'); enMap.put('s', 'h'); enMap.put('t', 'i');
				enMap.put('u', 'j'); enMap.put('v', 'k'); enMap.put('w', 'l'); enMap.put('x', 'm');
				enMap.put('y', 'n'); enMap.put('z', 'o'); enMap.put(' ', ' ');
				break;
			case "16":
				enMap.put('a', 'q'); enMap.put('b', 'r'); enMap.put('c', 's'); enMap.put('d', 't');
				enMap.put('e', 'u'); enMap.put('f', 'v'); enMap.put('g', 'w'); enMap.put('h', 'x');
				enMap.put('i', 'y'); enMap.put('j', 'z'); enMap.put('k', 'a'); enMap.put('l', 'b');
				enMap.put('m', 'c'); enMap.put('n', 'd'); enMap.put('o', 'e'); enMap.put('p', 'f');
				enMap.put('q', 'g'); enMap.put('r', 'h'); enMap.put('s', 'i'); enMap.put('t', 'j');
				enMap.put('u', 'k'); enMap.put('v', 'l'); enMap.put('w', 'm'); enMap.put('x', 'n');
				enMap.put('y', 'o'); enMap.put('z', 'p'); enMap.put(' ', ' ');
				break;
			case "17":
				enMap.put('a', 'r'); enMap.put('b', 's'); enMap.put('c', 't'); enMap.put('d', 'u');
				enMap.put('e', 'v'); enMap.put('f', 'w'); enMap.put('g', 'x'); enMap.put('h', 'y');
				enMap.put('i', 'z'); enMap.put('j', 'a'); enMap.put('k', 'b'); enMap.put('l', 'c');
				enMap.put('m', 'd'); enMap.put('n', 'e'); enMap.put('o', 'f'); enMap.put('p', 'g');
				enMap.put('q', 'h'); enMap.put('r', 'i'); enMap.put('s', 'j'); enMap.put('t', 'k');
				enMap.put('u', 'l'); enMap.put('v', 'm'); enMap.put('w', 'n'); enMap.put('x', 'o');
				enMap.put('y', 'p'); enMap.put('z', 'q'); enMap.put(' ', ' ');
				break;
			case "18":
				enMap.put('a', 's'); enMap.put('b', 't'); enMap.put('c', 'u'); enMap.put('d', 'v');
				enMap.put('e', 'w'); enMap.put('f', 'x'); enMap.put('g', 'y'); enMap.put('h', 'z');
				enMap.put('i', 'a'); enMap.put('j', 'b'); enMap.put('k', 'c'); enMap.put('l', 'd');
				enMap.put('m', 'e'); enMap.put('n', 'f'); enMap.put('o', 'g'); enMap.put('p', 'h');
				enMap.put('q', 'i'); enMap.put('r', 'j'); enMap.put('s', 'k'); enMap.put('t', 'l');
				enMap.put('u', 'm'); enMap.put('v', 'n'); enMap.put('w', 'o'); enMap.put('x', 'p');
				enMap.put('y', 'q'); enMap.put('z', 'r'); enMap.put(' ', ' ');
				break;
			case "19":
				enMap.put('a', 't'); enMap.put('b', 'u'); enMap.put('c', 'v'); enMap.put('d', 'w');
				enMap.put('e', 'x'); enMap.put('f', 'y'); enMap.put('g', 'z'); enMap.put('h', 'a');
				enMap.put('i', 'b'); enMap.put('j', 'c'); enMap.put('k', 'd'); enMap.put('l', 'e');
				enMap.put('m', 'f'); enMap.put('n', 'g'); enMap.put('o', 'h'); enMap.put('p', 'i');
				enMap.put('q', 'j'); enMap.put('r', 'k'); enMap.put('s', 'l'); enMap.put('t', 'm');
				enMap.put('u', 'n'); enMap.put('v', 'o'); enMap.put('w', 'p'); enMap.put('x', 'q');
				enMap.put('y', 'r'); enMap.put('z', 's'); enMap.put(' ', ' ');
				break;
			case "20":
				enMap.put('a', 'u'); enMap.put('b', 'v'); enMap.put('c', 'w'); enMap.put('d', 'x');
				enMap.put('e', 'y'); enMap.put('f', 'z'); enMap.put('g', 'a'); enMap.put('h', 'b');
				enMap.put('i', 'c'); enMap.put('j', 'd'); enMap.put('k', 'e'); enMap.put('l', 'f');
				enMap.put('m', 'g'); enMap.put('n', 'h'); enMap.put('o', 'i'); enMap.put('p', 'j');
				enMap.put('q', 'k'); enMap.put('r', 'l'); enMap.put('s', 'm'); enMap.put('t', 'n');
				enMap.put('u', 'o'); enMap.put('v', 'p'); enMap.put('w', 'q'); enMap.put('x', 'r');
				enMap.put('y', 's'); enMap.put('z', 't'); enMap.put(' ', ' ');
				break;
			case "21":
				enMap.put('a', 'v'); enMap.put('b', 'w'); enMap.put('c', 'x'); enMap.put('d', 'y');
				enMap.put('e', 'z'); enMap.put('f', 'a'); enMap.put('g', 'b'); enMap.put('h', 'c');
				enMap.put('i', 'd'); enMap.put('j', 'e'); enMap.put('k', 'f'); enMap.put('l', 'g');
				enMap.put('m', 'h'); enMap.put('n', 'i'); enMap.put('o', 'j'); enMap.put('p', 'k');
				enMap.put('q', 'l'); enMap.put('r', 'm'); enMap.put('s', 'n'); enMap.put('t', 'o');
				enMap.put('u', 'p'); enMap.put('v', 'q'); enMap.put('w', 'r'); enMap.put('x', 's');
				enMap.put('y', 't'); enMap.put('z', 'u'); enMap.put(' ', ' ');
				break;
			case "22":
				enMap.put('a', 'w'); enMap.put('b', 'x'); enMap.put('c', 'y'); enMap.put('d', 'z');
				enMap.put('e', 'a'); enMap.put('f', 'b'); enMap.put('g', 'c'); enMap.put('h', 'd');
				enMap.put('i', 'e'); enMap.put('j', 'f'); enMap.put('k', 'g'); enMap.put('l', 'h');
				enMap.put('m', 'i'); enMap.put('n', 'j'); enMap.put('o', 'k'); enMap.put('p', 'l');
				enMap.put('q', 'm'); enMap.put('r', 'n'); enMap.put('s', 'o'); enMap.put('t', 'p');
				enMap.put('u', 'q'); enMap.put('v', 'r'); enMap.put('w', 's'); enMap.put('x', 't');
				enMap.put('y', 'u'); enMap.put('z', 'v'); enMap.put(' ', ' ');
				break;
			case "23":
				enMap.put('a', 'x'); enMap.put('b', 'y'); enMap.put('c', 'z'); enMap.put('d', 'a');
				enMap.put('e', 'b'); enMap.put('f', 'c'); enMap.put('g', 'd'); enMap.put('h', 'e');
				enMap.put('i', 'f'); enMap.put('j', 'g'); enMap.put('k', 'h'); enMap.put('l', 'i');
				enMap.put('m', 'j'); enMap.put('n', 'k'); enMap.put('o', 'l'); enMap.put('p', 'm');
				enMap.put('q', 'n'); enMap.put('r', 'o'); enMap.put('s', 'p'); enMap.put('t', 'q');
				enMap.put('u', 'r'); enMap.put('v', 's'); enMap.put('w', 't'); enMap.put('x', 'u');
				enMap.put('y', 'v'); enMap.put('z', 'w'); enMap.put(' ', ' ');
				break;
			case "24":
				enMap.put('a', 'y'); enMap.put('b', 'z'); enMap.put('c', 'a'); enMap.put('d', 'b');
				enMap.put('e', 'c'); enMap.put('f', 'd'); enMap.put('g', 'e'); enMap.put('h', 'f');
				enMap.put('i', 'g'); enMap.put('j', 'h'); enMap.put('k', 'i'); enMap.put('l', 'j');
				enMap.put('m', 'k'); enMap.put('n', 'l'); enMap.put('o', 'm'); enMap.put('p', 'n');
				enMap.put('q', 'o'); enMap.put('r', 'p'); enMap.put('s', 'q'); enMap.put('t', 'r');
				enMap.put('u', 's'); enMap.put('v', 't'); enMap.put('w', 'u'); enMap.put('x', 'v');
				enMap.put('y', 'w'); enMap.put('z', 'x'); enMap.put(' ', ' ');
				break;
			case "25":
				enMap.put('a', 'z'); enMap.put('b', 'a'); enMap.put('c', 'b'); enMap.put('d', 'c');
				enMap.put('e', 'd'); enMap.put('f', 'e'); enMap.put('g', 'f'); enMap.put('h', 'g');
				enMap.put('i', 'h'); enMap.put('j', 'i'); enMap.put('k', 'j'); enMap.put('l', 'k');
				enMap.put('m', 'l'); enMap.put('n', 'm'); enMap.put('o', 'n'); enMap.put('p', 'o');
				enMap.put('q', 'p'); enMap.put('r', 'q'); enMap.put('s', 'r'); enMap.put('t', 's');
				enMap.put('u', 't'); enMap.put('v', 'u'); enMap.put('w', 'v'); enMap.put('x', 'w');
				enMap.put('y', 'x'); enMap.put('z', 'y'); enMap.put(' ', ' ');
				break;
			default:
				enMap.put('a', 'a'); enMap.put('b', 'b'); enMap.put('c', 'c'); enMap.put('d', 'd');
				enMap.put('e', 'e'); enMap.put('f', 'f'); enMap.put('g', 'g'); enMap.put('h', 'h');
				enMap.put('i', 'i'); enMap.put('j', 'j'); enMap.put('k', 'k'); enMap.put('l', 'l');
				enMap.put('m', 'm'); enMap.put('n', 'n'); enMap.put('o', 'o'); enMap.put('p', 'p');
				enMap.put('q', 'q'); enMap.put('r', 'r'); enMap.put('s', 's'); enMap.put('t', 't');
				enMap.put('u', 'u'); enMap.put('v', 'v'); enMap.put('w', 'w'); enMap.put('x', 'x');
				enMap.put('y', 'y'); enMap.put('z', 'z'); enMap.put(' ', ' ');
				break;
		}
		
		return enMap;

	}
	
	// mapping for the decryption process
	
	public Map<Character, Character> setDecryptMap(String shift) {
		
		Map<Character, Character> deMap  = new HashMap<Character, Character>();
		
		switch(shift) {
		
			case "1":
				deMap.put('b', 'a'); deMap.put('c', 'b'); deMap.put('d', 'c'); deMap.put('e', 'd');
				deMap.put('f', 'e'); deMap.put('g', 'f'); deMap.put('h', 'g'); deMap.put('i', 'h');
				deMap.put('j', 'i'); deMap.put('k', 'j'); deMap.put('l', 'k'); deMap.put('m', 'l');
				deMap.put('n', 'm'); deMap.put('o', 'n'); deMap.put('p', 'o'); deMap.put('q', 'p');
				deMap.put('r', 'q'); deMap.put('s', 'r'); deMap.put('t', 's'); deMap.put('u', 't');
				deMap.put('v', 'u'); deMap.put('w', 'v'); deMap.put('x', 'w'); deMap.put('y', 'x');
				deMap.put('z', 'y'); deMap.put('a', 'z'); deMap.put(' ', ' ');
				break;
			
			case "2":
				deMap.put('c', 'a'); deMap.put('d', 'b'); deMap.put('e', 'c'); deMap.put('f', 'd');
				deMap.put('g', 'e'); deMap.put('h', 'f'); deMap.put('i', 'g'); deMap.put('j', 'h');
				deMap.put('k', 'i'); deMap.put('l', 'j'); deMap.put('m', 'k'); deMap.put('n', 'l');
				deMap.put('o', 'm'); deMap.put('p', 'n'); deMap.put('q', 'o'); deMap.put('r', 'p');
				deMap.put('s', 'q'); deMap.put('t', 'r'); deMap.put('u', 's'); deMap.put('v', 't');
				deMap.put('w', 'u'); deMap.put('x', 'v'); deMap.put('y', 'w'); deMap.put('z', 'x');
				deMap.put('a', 'y'); deMap.put('b', 'z'); deMap.put(' ', ' ');
				break;
			case "3":
				deMap.put('d', 'a'); deMap.put('e', 'b'); deMap.put('f', 'c'); deMap.put('f', 'd');
				deMap.put('h', 'e'); deMap.put('i', 'f'); deMap.put('j', 'g'); deMap.put('k', 'h');
				deMap.put('l', 'i'); deMap.put('m', 'j'); deMap.put('n', 'k'); deMap.put('o', 'l');
				deMap.put('p', 'm'); deMap.put('q', 'n'); deMap.put('r', 'o'); deMap.put('s', 'p');
				deMap.put('t', 'q'); deMap.put('u', 'r'); deMap.put('v', 's'); deMap.put('w', 't');
				deMap.put('x', 'u'); deMap.put('y', 'v'); deMap.put('z', 'w'); deMap.put('a', 'x');
				deMap.put('b', 'y'); deMap.put('c', 'z'); deMap.put(' ', ' ');
				break;
			case "4":
				deMap.put('e', 'a'); deMap.put('f', 'b'); deMap.put('g', 'c'); deMap.put('h', 'd');
				deMap.put('i', 'e'); deMap.put('j', 'f'); deMap.put('k', 'g'); deMap.put('l', 'h');
				deMap.put('m', 'i'); deMap.put('n', 'j'); deMap.put('o', 'k'); deMap.put('p', 'l');
				deMap.put('q', 'm'); deMap.put('r', 'n'); deMap.put('s', 'o'); deMap.put('t', 'p');
				deMap.put('u', 'q'); deMap.put('v', 'r'); deMap.put('w', 's'); deMap.put('x', 't');
				deMap.put('y', 'u'); deMap.put('z', 'v'); deMap.put('a', 'w'); deMap.put('b', 'x');
				deMap.put('c', 'y'); deMap.put('d', 'z'); deMap.put(' ', ' ');
				break;
			case "5":
				deMap.put('f', 'a'); deMap.put('g', 'b'); deMap.put('h', 'c'); deMap.put('i', 'd');
				deMap.put('j', 'e'); deMap.put('k', 'f'); deMap.put('l', 'g'); deMap.put('m', 'h');
				deMap.put('n', 'i'); deMap.put('o', 'j'); deMap.put('p', 'k'); deMap.put('q', 'l');
				deMap.put('r', 'm'); deMap.put('s', 'n'); deMap.put('t', 'o'); deMap.put('u', 'p');
				deMap.put('v', 'q'); deMap.put('w', 'r'); deMap.put('x', 's'); deMap.put('y', 't');
				deMap.put('z', 'u'); deMap.put('a', 'v'); deMap.put('b', 'w'); deMap.put('c', 'x');
				deMap.put('d', 'y'); deMap.put('e', 'z'); deMap.put(' ', ' ');
				break;
			case "6":
				deMap.put('g', 'a'); deMap.put('h', 'b'); deMap.put('i', 'c'); deMap.put('j', 'd');
				deMap.put('k', 'e'); deMap.put('l', 'f'); deMap.put('m', 'g'); deMap.put('n', 'h');
				deMap.put('o', 'i'); deMap.put('p', 'j'); deMap.put('q', 'k'); deMap.put('r', 'l');
				deMap.put('s', 'm'); deMap.put('t', 'n'); deMap.put('u', 'o'); deMap.put('v', 'p');
				deMap.put('w', 'q'); deMap.put('x', 'r'); deMap.put('y', 's'); deMap.put('z', 't');
				deMap.put('a', 'u'); deMap.put('b', 'v'); deMap.put('c', 'w'); deMap.put('d', 'x');
				deMap.put('e', 'y'); deMap.put('f', 'z'); deMap.put(' ', ' ');
				break;
			case "7":
				deMap.put('h', 'a'); deMap.put('i', 'b'); deMap.put('j', 'c'); deMap.put('k', 'd');
				deMap.put('l', 'e'); deMap.put('m', 'f'); deMap.put('n', 'g'); deMap.put('o', 'h');
				deMap.put('p', 'i'); deMap.put('q', 'j'); deMap.put('r', 'k'); deMap.put('s', 'l');
				deMap.put('t', 'm'); deMap.put('u', 'n'); deMap.put('v', 'o'); deMap.put('w', 'p');
				deMap.put('x', 'q'); deMap.put('y', 'r'); deMap.put('z', 's'); deMap.put('a', 't');
				deMap.put('b', 'u'); deMap.put('c', 'v'); deMap.put('d', 'w'); deMap.put('e', 'x');
				deMap.put('f', 'y'); deMap.put('g', 'z'); deMap.put(' ', ' ');
				break;
			case "8":
				deMap.put('i', 'a'); deMap.put('j', 'b'); deMap.put('k', 'c'); deMap.put('l', 'd');
				deMap.put('m', 'e'); deMap.put('n', 'f'); deMap.put('o', 'g'); deMap.put('p', 'h');
				deMap.put('q', 'i'); deMap.put('r', 'j'); deMap.put('s', 'k'); deMap.put('t', 'l');
				deMap.put('u', 'm'); deMap.put('v', 'n'); deMap.put('w', 'o'); deMap.put('x', 'p');
				deMap.put('y', 'q'); deMap.put('z', 'r'); deMap.put('a', 's'); deMap.put('b', 't');
				deMap.put('c', 'u'); deMap.put('d', 'v'); deMap.put('e', 'w'); deMap.put('f', 'x');
				deMap.put('g', 'y'); deMap.put('h', 'z'); deMap.put(' ', ' ');
				break;
			case "9":
				deMap.put('j', 'a'); deMap.put('k', 'b'); deMap.put('l', 'c'); deMap.put('m', 'd');
				deMap.put('n', 'e'); deMap.put('o', 'f'); deMap.put('p', 'g'); deMap.put('q', 'h');
				deMap.put('r', 'i'); deMap.put('s', 'j'); deMap.put('t', 'k'); deMap.put('u', 'l');
				deMap.put('v', 'm'); deMap.put('w', 'n'); deMap.put('x', 'o'); deMap.put('y', 'p');
				deMap.put('z', 'q'); deMap.put('a', 'r'); deMap.put('b', 's'); deMap.put('c', 't');
				deMap.put('d', 'u'); deMap.put('e', 'v'); deMap.put('f', 'w'); deMap.put('g', 'x');
				deMap.put('h', 'y'); deMap.put('i', 'z'); deMap.put(' ', ' ');
				break;
			case "10":
				deMap.put('k', 'a'); deMap.put('l', 'b'); deMap.put('m', 'c'); deMap.put('n', 'd');
				deMap.put('o', 'e'); deMap.put('p', 'f'); deMap.put('q', 'g'); deMap.put('r', 'h');
				deMap.put('s', 'i'); deMap.put('t', 'j'); deMap.put('u', 'k'); deMap.put('v', 'l');
				deMap.put('w', 'm'); deMap.put('x', 'n'); deMap.put('y', 'o'); deMap.put('z', 'p');
				deMap.put('a', 'q'); deMap.put('b', 'r'); deMap.put('c', 's'); deMap.put('d', 't');
				deMap.put('e', 'u'); deMap.put('f', 'v'); deMap.put('g', 'w'); deMap.put('h', 'x');
				deMap.put('i', 'y'); deMap.put('j', 'z'); deMap.put(' ', ' ');
				break;
			case "11":
				deMap.put('l', 'a'); deMap.put('m', 'b'); deMap.put('n', 'c'); deMap.put('o', 'd');
				deMap.put('p', 'e'); deMap.put('q', 'f'); deMap.put('r', 'g'); deMap.put('s', 'h');
				deMap.put('t', 'i'); deMap.put('u', 'j'); deMap.put('v', 'k'); deMap.put('w', 'l');
				deMap.put('x', 'm'); deMap.put('y', 'n'); deMap.put('z', 'o'); deMap.put('a', 'p');
				deMap.put('b', 'q'); deMap.put('c', 'r'); deMap.put('d', 's'); deMap.put('e', 't');
				deMap.put('f', 'u'); deMap.put('g', 'v'); deMap.put('h', 'w'); deMap.put('i', 'x');
				deMap.put('j', 'y'); deMap.put('k', 'z'); deMap.put(' ', ' ');
				break;
			case "12":
				deMap.put('m', 'a'); deMap.put('n', 'b'); deMap.put('o', 'c'); deMap.put('p', 'd');
				deMap.put('q', 'e'); deMap.put('r', 'f'); deMap.put('s', 'g'); deMap.put('t', 'h');
				deMap.put('u', 'i'); deMap.put('v', 'j'); deMap.put('w', 'k'); deMap.put('x', 'l');
				deMap.put('y', 'm'); deMap.put('z', 'n'); deMap.put('a', 'o'); deMap.put('b', 'p');
				deMap.put('c', 'q'); deMap.put('d', 'r'); deMap.put('e', 's'); deMap.put('f', 't');
				deMap.put('g', 'u'); deMap.put('h', 'v'); deMap.put('i', 'w'); deMap.put('j', 'x');
				deMap.put('k', 'y'); deMap.put('l', 'z'); deMap.put(' ', ' ');
				break;
			case "13":
				deMap.put('n', 'a'); deMap.put('o', 'b'); deMap.put('p', 'c'); deMap.put('q', 'd');
				deMap.put('r', 'e'); deMap.put('s', 'f'); deMap.put('t', 'g'); deMap.put('u', 'h');
				deMap.put('v', 'i'); deMap.put('w', 'j'); deMap.put('x', 'k'); deMap.put('y', 'l');
				deMap.put('z', 'm'); deMap.put('a', 'n'); deMap.put('b', 'o'); deMap.put('c', 'p');
				deMap.put('d', 'q'); deMap.put('e', 'r'); deMap.put('f', 's'); deMap.put('g', 't');
				deMap.put('h', 'u'); deMap.put('i', 'v'); deMap.put('j', 'w'); deMap.put('k', 'x');
				deMap.put('l', 'y'); deMap.put('m', 'z'); deMap.put(' ', ' ');
				break;
			case "14":
				deMap.put('o', 'a'); deMap.put('p', 'b'); deMap.put('q', 'c'); deMap.put('r', 'd');
				deMap.put('s', 'e'); deMap.put('t', 'f'); deMap.put('u', 'g'); deMap.put('v', 'h');
				deMap.put('w', 'i'); deMap.put('x', 'j'); deMap.put('y', 'k'); deMap.put('z', 'l');
				deMap.put('a', 'm'); deMap.put('b', 'n'); deMap.put('c', 'o'); deMap.put('d', 'p');
				deMap.put('e', 'q'); deMap.put('f', 'r'); deMap.put('g', 's'); deMap.put('h', 't');
				deMap.put('i', 'u'); deMap.put('j', 'v'); deMap.put('k', 'w'); deMap.put('l', 'x');
				deMap.put('m', 'y'); deMap.put('n', 'z'); deMap.put(' ', ' ');
				break;
			case "15":
				deMap.put('p', 'a'); deMap.put('q', 'b'); deMap.put('r', 'c'); deMap.put('s', 'd');
				deMap.put('t', 'e'); deMap.put('u', 'f'); deMap.put('v', 'g'); deMap.put('w', 'h');
				deMap.put('x', 'i'); deMap.put('y', 'j'); deMap.put('z', 'k'); deMap.put('a', 'l');
				deMap.put('b', 'm'); deMap.put('c', 'n'); deMap.put('d', 'o'); deMap.put('e', 'p');
				deMap.put('f', 'q'); deMap.put('g', 'r'); deMap.put('h', 's'); deMap.put('i', 't');
				deMap.put('j', 'u'); deMap.put('k', 'v'); deMap.put('l', 'w'); deMap.put('m', 'x');
				deMap.put('n', 'y'); deMap.put('o', 'z'); deMap.put(' ', ' ');
				break;
			case "16":
				deMap.put('q', 'a'); deMap.put('r', 'b'); deMap.put('s', 'c'); deMap.put('t', 'd');
				deMap.put('u', 'e'); deMap.put('v', 'f'); deMap.put('w', 'g'); deMap.put('x', 'h');
				deMap.put('y', 'i'); deMap.put('z', 'j'); deMap.put('a', 'k'); deMap.put('b', 'l');
				deMap.put('c', 'm'); deMap.put('d', 'n'); deMap.put('e', 'o'); deMap.put('f', 'p');
				deMap.put('g', 'q'); deMap.put('h', 'r'); deMap.put('i', 's'); deMap.put('j', 't');
				deMap.put('k', 'u'); deMap.put('l', 'v'); deMap.put('m', 'w'); deMap.put('n', 'x');
				deMap.put('o', 'y'); deMap.put('p', 'z'); deMap.put(' ', ' ');
				break;
			case "17":
				deMap.put('r', 'a'); deMap.put('s', 'b'); deMap.put('t', 'c'); deMap.put('u', 'd');
				deMap.put('v', 'e'); deMap.put('w', 'f'); deMap.put('x', 'g'); deMap.put('y', 'h');
				deMap.put('z', 'i'); deMap.put('a', 'j'); deMap.put('b', 'k'); deMap.put('c', 'l');
				deMap.put('d', 'm'); deMap.put('e', 'n'); deMap.put('f', 'o'); deMap.put('g', 'p');
				deMap.put('h', 'q'); deMap.put('i', 'r'); deMap.put('j', 's'); deMap.put('k', 't');
				deMap.put('l', 'u'); deMap.put('m', 'v'); deMap.put('n', 'w'); deMap.put('o', 'x');
				deMap.put('p', 'y'); deMap.put('q', 'z'); deMap.put(' ', ' ');
				break;
			case "18":
				deMap.put('s', 'a'); deMap.put('t', 'b'); deMap.put('u', 'c'); deMap.put('v', 'd');
				deMap.put('w', 'e'); deMap.put('x', 'f'); deMap.put('y', 'g'); deMap.put('z', 'h');
				deMap.put('a', 'i'); deMap.put('b', 'j'); deMap.put('c', 'k'); deMap.put('d', 'l');
				deMap.put('e', 'm'); deMap.put('f', 'n'); deMap.put('g', 'o'); deMap.put('h', 'p');
				deMap.put('i', 'q'); deMap.put('j', 'r'); deMap.put('k', 's'); deMap.put('l', 't');
				deMap.put('m', 'u'); deMap.put('n', 'v'); deMap.put('o', 'w'); deMap.put('p', 'x');
				deMap.put('q', 'y'); deMap.put('r', 'z'); deMap.put(' ', ' ');
				break;
			case "19":
				deMap.put('t', 'a'); deMap.put('u', 'b'); deMap.put('v', 'c'); deMap.put('w', 'd');
				deMap.put('x', 'e'); deMap.put('y', 'f'); deMap.put('z', 'g'); deMap.put('a', 'h');
				deMap.put('b', 'i'); deMap.put('c', 'j'); deMap.put('d', 'k'); deMap.put('e', 'l');
				deMap.put('f', 'm'); deMap.put('g', 'n'); deMap.put('h', 'o'); deMap.put('i', 'p');
				deMap.put('j', 'q'); deMap.put('k', 'r'); deMap.put('l', 's'); deMap.put('m', 't');
				deMap.put('n', 'u'); deMap.put('o', 'v'); deMap.put('p', 'w'); deMap.put('q', 'x');
				deMap.put('r', 'y'); deMap.put('s', 'z'); deMap.put(' ', ' ');
				break;
			case "20":
				deMap.put('u', 'a'); deMap.put('v', 'b'); deMap.put('w', 'c'); deMap.put('x', 'd');
				deMap.put('y', 'e'); deMap.put('z', 'f'); deMap.put('a', 'g'); deMap.put('b', 'h');
				deMap.put('c', 'i'); deMap.put('d', 'j'); deMap.put('e', 'k'); deMap.put('f', 'l');
				deMap.put('g', 'm'); deMap.put('h', 'n'); deMap.put('i', 'o'); deMap.put('j', 'p');
				deMap.put('k', 'q'); deMap.put('l', 'r'); deMap.put('m', 's'); deMap.put('n', 't');
				deMap.put('o', 'u'); deMap.put('p', 'v'); deMap.put('q', 'w'); deMap.put('r', 'x');
				deMap.put('s', 'y'); deMap.put('t', 'z'); deMap.put(' ', ' ');
				break;
			case "21":
				deMap.put('v', 'a'); deMap.put('w', 'b'); deMap.put('x', 'c'); deMap.put('y', 'd');
				deMap.put('z', 'e'); deMap.put('a', 'f'); deMap.put('b', 'g'); deMap.put('c', 'h');
				deMap.put('d', 'i'); deMap.put('e', 'j'); deMap.put('f', 'k'); deMap.put('g', 'l');
				deMap.put('h', 'm'); deMap.put('i', 'n'); deMap.put('j', 'o'); deMap.put('k', 'p');
				deMap.put('l', 'q'); deMap.put('m', 'r'); deMap.put('n', 's'); deMap.put('o', 't');
				deMap.put('p', 'u'); deMap.put('q', 'v'); deMap.put('r', 'w'); deMap.put('s', 'x');
				deMap.put('t', 'y'); deMap.put('u', 'z'); deMap.put(' ', ' ');
				break;
			case "22":
				deMap.put('w', 'a'); deMap.put('x', 'b'); deMap.put('y', 'c'); deMap.put('z', 'd');
				deMap.put('a', 'e'); deMap.put('b', 'f'); deMap.put('c', 'g'); deMap.put('d', 'h');
				deMap.put('e', 'i'); deMap.put('f', 'j'); deMap.put('g', 'k'); deMap.put('h', 'l');
				deMap.put('i', 'm'); deMap.put('j', 'n'); deMap.put('k', 'o'); deMap.put('l', 'p');
				deMap.put('m', 'q'); deMap.put('n', 'r'); deMap.put('o', 's'); deMap.put('p', 't');
				deMap.put('q', 'u'); deMap.put('r', 'v'); deMap.put('s', 'w'); deMap.put('t', 'x');
				deMap.put('u', 'y'); deMap.put('v', 'z'); deMap.put(' ', ' ');
				break;
			case "23":
				deMap.put('x', 'a'); deMap.put('y', 'b'); deMap.put('z', 'c'); deMap.put('a', 'd');
				deMap.put('b', 'e'); deMap.put('c', 'f'); deMap.put('d', 'g'); deMap.put('e', 'h');
				deMap.put('f', 'i'); deMap.put('g', 'j'); deMap.put('h', 'k'); deMap.put('i', 'l');
				deMap.put('j', 'm'); deMap.put('k', 'n'); deMap.put('l', 'o'); deMap.put('m', 'p');
				deMap.put('n', 'q'); deMap.put('o', 'r'); deMap.put('p', 's'); deMap.put('q', 't');
				deMap.put('r', 'u'); deMap.put('s', 'v'); deMap.put('t', 'w'); deMap.put('u', 'x');
				deMap.put('v', 'y'); deMap.put('w', 'z'); deMap.put(' ', ' ');
				break;
			case "24":
				deMap.put('y', 'a'); deMap.put('z', 'b'); deMap.put('a', 'c'); deMap.put('b', 'd');
				deMap.put('c', 'e'); deMap.put('d', 'f'); deMap.put('e', 'g'); deMap.put('f', 'h');
				deMap.put('g', 'i'); deMap.put('h', 'j'); deMap.put('i', 'k'); deMap.put('j', 'l');
				deMap.put('k', 'm'); deMap.put('l', 'n'); deMap.put('m', 'o'); deMap.put('n', 'p');
				deMap.put('o', 'q'); deMap.put('p', 'r'); deMap.put('q', 's'); deMap.put('r', 't');
				deMap.put('s', 'u'); deMap.put('t', 'v'); deMap.put('u', 'w'); deMap.put('v', 'x');
				deMap.put('w', 'y'); deMap.put('x', 'z'); deMap.put(' ', ' ');
				break;
			case "25":
				deMap.put('z', 'a'); deMap.put('a', 'b'); deMap.put('b', 'c'); deMap.put('c', 'd');
				deMap.put('d', 'e'); deMap.put('e', 'f'); deMap.put('f', 'g'); deMap.put('g', 'h');
				deMap.put('h', 'i'); deMap.put('i', 'j'); deMap.put('j', 'k'); deMap.put('k', 'l');
				deMap.put('l', 'm'); deMap.put('m', 'n'); deMap.put('n', 'o'); deMap.put('o', 'p');
				deMap.put('p', 'q'); deMap.put('q', 'r'); deMap.put('r', 's'); deMap.put('s', 't');
				deMap.put('t', 'u'); deMap.put('u', 'v'); deMap.put('v', 'w'); deMap.put('w', 'x');
				deMap.put('x', 'y'); deMap.put('y', 'z'); deMap.put(' ', ' ');
				break;
			default:
				deMap.put('a', 'a'); deMap.put('b', 'b'); deMap.put('c', 'c'); deMap.put('d', 'd');
				deMap.put('e', 'e'); deMap.put('f', 'f'); deMap.put('g', 'g'); deMap.put('h', 'h');
				deMap.put('i', 'i'); deMap.put('j', 'j'); deMap.put('k', 'k'); deMap.put('l', 'l');
				deMap.put('m', 'm'); deMap.put('n', 'n'); deMap.put('o', 'o'); deMap.put('p', 'p');
				deMap.put('q', 'q'); deMap.put('r', 'r'); deMap.put('s', 's'); deMap.put('t', 't');
				deMap.put('u', 'u'); deMap.put('v', 'v'); deMap.put('w', 'w'); deMap.put('x', 'x');
				deMap.put('y', 'y'); deMap.put('z', 'z'); deMap.put(' ', ' ');
				break;
		}
		
		return deMap;

	}
}
