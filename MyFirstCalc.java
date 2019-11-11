import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.util.Stack;

public class MyFirstCalc extends JFrame implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextArea text = new JTextArea(3,14);
	double firstnum, secondnum, result; 
	int firstnumhex, secondnumhex;
	int hexresult = 0; 
	String formatresult, letter, secondletter;
	boolean letterflag = false; 
	String newstring = null;
	String operation, number, hex;
	
	boolean parenthesis = false; 
	
	//display components row 1
	JLabel display2 = new JLabel(); 
	JLabel display3 = new JLabel("WORD", SwingConstants.CENTER); 
	JLabel display4 = new JLabel("MS", SwingConstants.CENTER); 
	JLabel display5 = new JLabel("M", SwingConstants.CENTER); 
	
	
	//display components row 2 
	JLabel display6 = new JLabel("Lsh", SwingConstants.CENTER);
	JLabel display7 = new JLabel("Rsh", SwingConstants.CENTER);
	JLabel display8 = new JLabel("Or", SwingConstants.CENTER);
	JLabel display9 = new JLabel("Xor", SwingConstants.CENTER);
	JLabel display10 = new JLabel("Not", SwingConstants.CENTER);
	JLabel display11 = new JLabel("And", SwingConstants.CENTER);
	
	//hex, bin, oct 
	JLabel hexlab = new JLabel("HEX", SwingConstants.CENTER);
	JLabel hexval = new JLabel("0", SwingConstants.LEFT);
	
	JLabel declab = new JLabel("DEC", SwingConstants.CENTER);
	JLabel decval = new JLabel("0", SwingConstants.LEFT);
	
	JLabel octlab = new JLabel("OCT", SwingConstants.CENTER);
	JLabel octval = new JLabel("0", SwingConstants.LEFT);
	
	JLabel binlab = new JLabel("BIN", SwingConstants.CENTER);
	JLabel binval = new JLabel("0", SwingConstants.LEFT);
	
	
	//row 1 
	JButton button1 = new JButton("↑");
	JButton button2 = new JButton("Mod");
	JButton button3 = new JButton("CE");
	JButton button4 = new JButton("C");
	JButton button5 = new JButton("⌫");
	JButton button6 = new JButton("÷");
	
	//row 2
	JButton button7 = new JButton("A");
	JButton button8 = new JButton("B");
	JButton button9 = new JButton("7");
	JButton button10 = new JButton("8");
	JButton button11 = new JButton("9");
	JButton button12 = new JButton("x");

	//row 3
	JButton button13 = new JButton("C");
	JButton button14 = new JButton("D");
	JButton button15 = new JButton("4");
	JButton button16 = new JButton("5");
	JButton button17 = new JButton("6");
	JButton button18 = new JButton("-");

	//row 4 
	JButton button19 = new JButton("E");
	JButton button20 = new JButton("F");
	JButton button21 = new JButton("1");
	JButton button22 = new JButton("2");
	JButton button23 = new JButton("3");
	JButton button24 = new JButton("+");
	
	//row 5
	JButton button25 = new JButton("(");
	JButton button26 = new JButton(")");
	JButton button27 = new JButton("±");
	JButton button28 = new JButton("0");
	JButton button29 = new JButton(".");
	JButton button30 = new JButton("=");

	
	public MyFirstCalc()
	{
		int buttonx = 40;
		int buttony = 40; 
		 
		
		//frame
		frame.setTitle("Calculator");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(300, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//panel
		frame.add(panel);
		
		
		
		//text  area
		panel.add(text);
		Font font = new Font("garamond", Font.BOLD,20);
		text.setFont(font);
		text.setBackground(null);
		text.setForeground(Color.black);
		text.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		//hex, dec, binary, octal
		hexlab.setPreferredSize(new Dimension(50, 20));
		panel.add(hexlab);
		
		hexval.setPreferredSize(new Dimension(230, 20));
		panel.add(hexval);
		
		declab.setPreferredSize(new Dimension(50, 20));
		panel.add(declab); 
		
		decval.setPreferredSize(new Dimension(230, 20));
		panel.add(decval);
		
		octlab.setPreferredSize(new Dimension(50, 20));
		panel.add(octlab); 
		
		octval.setPreferredSize(new Dimension(230, 20));
		panel.add(octval);
		
		binlab.setPreferredSize(new Dimension(50, 20));
		panel.add(binlab); 
		
		binval.setPreferredSize(new Dimension(230, 20));
		panel.add(binval);
		

		//display row 1;
		ImageIcon icon = new ImageIcon("/Users/sniptamallick/Documents/icon1.png");
		JLabel display1 = new JLabel(icon, SwingConstants.CENTER); 
		display1.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(display1);
		
		ImageIcon icon2 = new ImageIcon("/Users/sniptamallick/Documents/icon2.png");
		JLabel display2 = new JLabel(icon2, SwingConstants.CENTER); 
		display2.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(display2);
		
		display3.setPreferredSize(new Dimension(80, buttony));
		panel.add(display3);
		display3.setForeground(Color.BLUE);
		
		display4.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(display4);
		
		display5.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(display5);
		
		
		//display row 2 
		display6.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(display6);
		
		display7.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(display7);
		
		display8.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(display8);
		
		display9.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(display9);
		
		display10.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(display10);
		
		display11.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(display11);
		
		
		//button 1
		button1.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button1);
		button1.addActionListener(this);
		
		button2.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button2);
		button2.addActionListener(this);
		
		button3.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button3);
		button3.addActionListener(this);
		
		button4.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button4);
		button4.addActionListener(this);
		
		button5.setPreferredSize(new Dimension(buttonx, buttony));

		panel.add(button5);
		button5.addActionListener(this);
		
		button6.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button6);
		button6.addActionListener(this);
		
		button7.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button7);
		button7.setForeground(Color.LIGHT_GRAY);
		button7.addActionListener(this);
		
		button8.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button8);
		button8.setForeground(Color.LIGHT_GRAY);
		button8.addActionListener(this);
		
		button9.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button9);
		button9.addActionListener(this);
		
		button10.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button10);
		button10.addActionListener(this);
		
		button11.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button11);
		button11.addActionListener(this);
		
		button12.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button12);
		button12.addActionListener(this);
		
		button13.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button13);
		button13.setForeground(Color.LIGHT_GRAY);
		button13.addActionListener(this);
		
		button14.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button14);
		button14.setForeground(Color.LIGHT_GRAY);
		button14.addActionListener(this);
		
		button15.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button15);
		button15.addActionListener(this);
		
		button16.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button16);
		button16.addActionListener(this);
		
		button17.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button17);
		button17.addActionListener(this);
		
		button18.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button18);
		button18.addActionListener(this);
		
		button19.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button19);
		button19.setForeground(Color.LIGHT_GRAY);
		button19.addActionListener(this);
		
		button20.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button20);
		button20.setForeground(Color.LIGHT_GRAY);
		button20.addActionListener(this);
		
		button21.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button21);
		button21.addActionListener(this);
		
		button22.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button22);
		button22.addActionListener(this);
		
		button23.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button23);
		button23.addActionListener(this);
		
		button24.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button24);
		button24.addActionListener(this);
		
		button25.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button25);
		button25.addActionListener(this);
		
		button26.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button26);
		button26.addActionListener(this);
		
		button27.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button27);
		button27.addActionListener(this);
		
		button28.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button28);
		button28.addActionListener(this);
		
		button29.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button29);
		button29.addActionListener(this);
		
		button30.setPreferredSize(new Dimension(buttonx, buttony));
		panel.add(button30);
		button30.addActionListener(this);

	}


	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		
		//numbers
		if (source == button9)
		{
			text.append("7");
		}
		if (source == button10)
		{
			text.append("8");
		}
		if (source == button11)
		{
			text.append("9");
		}
		if (source == button15)
		{
			text.append("4");
		}
		if (source == button16)
		{
			text.append("5");
		}
		if (source == button17)
		{
			text.append("6");
		}
		if (source == button21)
		{
			text.append("1");
		}
		if (source == button22)
		{
			text.append("2");
		}
		if (source == button23)
		{
			text.append("3");
		}
		if (source == button28)
		{
			text.append("0");
		}
		
		//other elements
		
		if (source == button7)
		{
			text.append("A");
			letterflag = true; 
 
		}
		if (source == button8)
		{
			text.append("B");
			letterflag = true;
		}
		if (source == button13)
		{
			text.append("C");
			letterflag = true;
		}
		if (source == button14)
		{
			text.append("D");
			letterflag = true;
		}
		if (source == button19)
		{
			text.append("E"); 
			letterflag = true;
		}
		if (source == button20)
		{
			text.append("F");
			letterflag = true;
		}
	
		if (source == button29)
		{
			text.append(".");
			 
		}
		
		//arithmetic operations 
		if (source == button6)
		{
			operation = "/";
			
			if (letterflag)
			{
				letter = text.getText(); 
				firstnumhex = Integer.parseInt(letter, 16); 
				text.setText("");
			}
			if (parenthesis)
			{
				String string = text.getText(); 
				text.setText(string + "/");
				
			}
			else
			{
				firstnum = getNum();
				text.setText("");
			}
			
			
		}
		if (source == button12)
		{
			operation = "*";
			
			if (letterflag)
			{
				letter = text.getText(); 
				firstnumhex = Integer.parseInt(letter, 16); 
				text.setText("");
			}
			if (parenthesis)
			{
				String string = text.getText(); 
				text.setText(string + "*");
				
			}
			else
			{
				firstnum = getNum();
				text.setText("");
			}
			
		}
		if (source == button18)
		{
			operation = "-";
			
			if (letterflag)
			{
				letter = text.getText(); 
				firstnumhex = Integer.parseInt(letter, 16); 
				text.setText("");
			}
			if (parenthesis)
			{
				String string = text.getText(); 
				text.setText(string + "-");
				
			}
			else
			{
				firstnum = getNum();
				text.setText("");
			}
			
		}
		if (source == button24)
		{
			operation = "+"; 
			
			if (letterflag)
			{
				letter = text.getText(); 
				firstnumhex = Integer.parseInt(letter, 16); 
				text.setText("");
			}
			if (parenthesis)
			{
				String string = text.getText(); 
				text.setText(string + "+");
				
			}
			else
			{
				firstnum = getNum();
				text.setText("");
			}
			
			
		}
		if (source == button2)
		{
			operation = "%"; 
			
			if (number == "1")
			{
				firstnum = getNum();
				text.setText("");
			}
			else
			{
				letter = text.getText(); 
				firstnumhex = Integer.parseInt(letter, 16); 
				text.setText("");
			}
		}
		if (source == button1)
		{
			operation = "exp";
			firstnum = getNum();
			text.setText("");
			
			
		}
		if (source == button27)
		{
			
			firstnum =getNum(); 
			firstnum = firstnum * -1; 
			String newNum = Double.toString(firstnum);
			text.setText(newNum);
			
		}
		
		//parenthesis
		if (source == button25)
		{
			operation = null; 
			text.append("(");
			parenthesis = true;
			
		}
		if (source == button26)
		{
			operation = null; 
			text.append(")");
			parenthesis = true; 
		}
		
		
		
		//equals button 
		if (source == button30)
		{ 
			
			if (operation == "*")
			{
				
				if (letterflag)
				{
					secondletter = text.getText(); 
					secondnumhex = Integer.parseInt(secondletter, 16); 
					hexresult = firstnumhex * secondnumhex; 
					conversion(hexresult); 
					formatresult = Integer.toHexString(hexresult); 
					text.setText(formatresult);
				}
				else
				{
					secondnum = getNum();
					result = firstnum * secondnum;
					int value = (int) result;
					conversion(value);
					formatresult = String.format("%.1f", result);
					text.setText(formatresult);
				}
				
			}
			if (operation == "/")
			{
				if (letterflag)
				{
					secondletter = text.getText(); 
					secondnumhex = Integer.parseInt(secondletter, 16); 
					hexresult = firstnumhex / secondnumhex;
					conversion(hexresult);
					formatresult = Integer.toHexString(hexresult); 
					text.setText(formatresult);
				}
				else
				{
					secondnum = getNum();
					result = firstnum / secondnum;
					int value = (int) result;
					conversion(value);
					formatresult = String.format("%.1f", result);
					text.setText(formatresult);
				}
				

			}
			if (operation == "-")
			{
				if (letterflag)
				{
					secondletter = text.getText(); 
					secondnumhex = Integer.parseInt(secondletter, 16); 
					hexresult = firstnumhex - secondnumhex;
					conversion(hexresult);
					formatresult = Integer.toHexString(hexresult); 
					text.setText(formatresult);
				}
				else
				{
					secondnum = getNum();
					result = firstnum - secondnum;
					int value = (int) result;
					conversion(value);
					formatresult = String.format("%.1f", result);
					text.setText(formatresult);
				}

			}
			if (operation == "+")
			{
				if (letterflag)
				{
					secondletter = text.getText(); 
					secondnumhex = Integer.parseInt(secondletter, 16); 
					hexresult = firstnumhex + secondnumhex;
					conversion(hexresult);
					formatresult = Integer.toHexString(hexresult); 
					text.setText(formatresult);
				}
				else
				{
					secondnum = getNum();
					result = firstnum + secondnum;
					int value = (int) result;
					conversion(value);
					formatresult = String.format("%.1f", result);
					text.setText(formatresult);
				}

			}
			if (operation == "%")
			{
				secondnum = getNum();
				result = firstnum % secondnum;
				int value = (int) result;
				conversion(value);
				formatresult = String.format("%.1f", result);
				text.setText(formatresult);
						
			}
			if (operation == "exp")
			{
				secondnum = getNum();
				result = Math.pow(firstnum, secondnum); 
				int value = (int) result;
				conversion(value);
				formatresult = String.format("%.1f", result);
				text.setText(formatresult);
				
			}
			if (parenthesis)
			{
				Integer result = precendence(text.getText()); 
				text.setText(result.toString());
				parenthesis = false; 
				
			}
			
			letterflag = false; 
				
		}
	
		
		//clear 
		if (source == button4)
		{
			firstnum = 0.0; 
			secondnum = 0.0;
			text.setText("");
			
		}
		
		//ce button
		
		if (source == button3)
		{
			if(text.getText().length() > 0)
			{
				StringBuilder str = new StringBuilder(text.getText()); 
				str.delete(0, text.getText().length());
				newstring = str.toString();
				text.setText(newstring);
			}
		}
		
		//backspace  
		if (source == button5)
		{
			if(text.getText().length() > 0)
			{
				StringBuilder str = new StringBuilder(text.getText()); 
				str.deleteCharAt(text.getText().length() - 1);
				newstring = str.toString();
				text.setText(newstring);
			}
		}
	}
	
	public double getNum()
	{
		double first; 
		String number; 
		number = text.getText(); 
		first = Double.parseDouble(number);
		
		return first; 
	}
	
	public void conversion(int value)
	{
		
		hexval.setText(Integer.toHexString(value));
		
		decval.setText(Integer.toString(value));
		
		octval.setText(Integer.toOctalString(value));
		
		binval.setText(Integer.toBinaryString(value));
		
	}
	
	public Integer precendence(String str)
	{
		Stack<Integer> operandStack = new Stack<>();
		
		Stack<Character> operatorStack = new Stack<>();
		
		str = space(str);
		
		String[] tokens = str.split(" ");
		
		for (String token: tokens)
		{
			if (token.length() == 0)
			{
				continue;
			}
			else if (token.charAt(0) == '+' || token.charAt(0) == '-')
			{
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-' || operatorStack.peek() == '*' || operatorStack.peek() == '/')) 
				{	
					processOperator(operandStack, operatorStack);
				}
				
				operatorStack.push(token.charAt(0));
			}
			else if (token.charAt(0) == '*' || token.charAt(0) == '/') 
			{ 
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/'))
				{
						processOperator(operandStack, operatorStack);
				}
				
				operatorStack.push(token.charAt(0));
				
			}
			else if (token.trim().charAt(0) == '(')
			{
				operatorStack.push('('); 
			}
			else if (token.trim().charAt(0) == ')')
			{
				while (operatorStack.peek() != '(')
				{
					processOperator(operandStack, operatorStack);
				}
				
				operatorStack.pop(); 
			}
			else 
			{
				operandStack.push(new Integer(token));
			}
	
		}
		
		while (!operatorStack.isEmpty())
		{
			processOperator(operandStack, operatorStack);
		}
		
		
		return operandStack.pop(); 
		
	}
	
	public static void processOperator(Stack<Integer> operandStack, Stack<Character> operatorStack)
	{
		char op = operatorStack.pop(); 
		int op1 = operandStack.pop(); 
		int op2 = operandStack.pop(); 
		
		if (op == '+')
		{
			operandStack.push(op2 + op1); 
		}
		else if (op == '-')
		{
			operandStack.push(op2 - op1); 
		}
		else if (op == '*')
		{
			operandStack.push(op2 * op1);
		}
		else if (op == '/')
		{
			    operandStack.push(op2 / op1);
			
		}
		
	}
	
	

	public static String space(String s) 
	{ 
		String result = "";
	
		for (int i = 0; i < s.length(); i++) 
		{
			if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-' ||s.charAt(i) == '*' || s.charAt(i) == '/') 
			{	
				result += " " + s.charAt(i) + " ";
			}
			else
			{
				result += s.charAt(i);
			}
	
		}
		
		return result; 
	}
	


}
