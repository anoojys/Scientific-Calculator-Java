package calci;	
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	import  net.objecthunter.exp4j.Expression;
	import net.objecthunter.exp4j.ExpressionBuilder;
	public class ScientificCalculatorGUI extends JFrame
	implements ActionListener {
		JTextField display;

		JButton buttons[];

		String expression = "";
		double num1;
		double num2;
		String operator;
		public ScientificCalculatorGUI() {

		    setTitle("Scientific Calculator");

		    setSize(450,600);

		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		    setLayout(new BorderLayout());
		    display = new JTextField();

		    display.setFont(new Font("Arial",Font.BOLD,30));

		    display.setHorizontalAlignment(JTextField.RIGHT);

		    display.setEditable(false);

		    add(display,BorderLayout.NORTH);
		    JPanel panel = new JPanel();

		    panel.setLayout(new GridLayout(7,4,5,5));
		    String buttonNames[] = {

		            "7","8","9","/",

		            "4","5","6","*",

		            "1","2","3","-",

		            "0",".","+","=",

		            "(" , ")" , "C" , "<--",

		            "sin","cos","tan","log",

		            "sqrt","^","%","Exit"
		    };
		    buttons = new JButton[buttonNames.length];

		    for(int i=0;i<buttonNames.length;i++){

		        buttons[i]=new JButton(buttonNames[i]);

		        buttons[i].setFont(new Font("Arial",Font.BOLD,18));

		        buttons[i].addActionListener(this);

		        panel.add(buttons[i]);
		    }

		    add(panel,BorderLayout.CENTER);

		    setVisible(true);
		}
		    public void actionPerformed(ActionEvent e){

		        String command=e.getActionCommand();
		        if(command.matches("[0-9]")){

		            expression += command;

		            display.setText(expression);

		        }
		        else if(command.equals(".")){

		            expression += ".";

		            display.setText(expression);

		        }
		        else if(command.equals("+") ||
		                command.equals("-") ||
		                command.equals("*") ||
		                command.equals("/") ||
		                command.equals("%") ||
		                command.equals("^")){

		            expression += command;

		            display.setText(expression);

		        }
		        else if(command.equals("(") ||
		                command.equals(")")){

		            expression += command;

		            display.setText(expression);

		        }
		        else if(command.equals("sin")){

		            expression += "sin(";

		            display.setText(expression);

		        }

		        else if(command.equals("cos")){

		            expression += "cos(";

		            display.setText(expression);

		        }

		        else if(command.equals("tan")){

		            expression += "tan(";

		            display.setText(expression);

		        }

		        else if(command.equals("log")){

		            expression += "log(";

		            display.setText(expression);

		        }

		        else if(command.equals("sqrt")){

		            expression += "sqrt(";

		            display.setText(expression);
		        }
		            else if(command.equals("<--")){

		                if(expression.length()>0){

		                    expression =
		                            expression.substring(0,
		                            expression.length()-1);

		                    display.setText(expression);

		                }

		            }
		            else if(command.equals("C")){

		                expression="";

		                display.setText("");

		            }
		            else if(command.equals("=")){

		                try{

		                	System.out.println("Expression = " + expression);

		                	String expStr = expression;

		                	// Convert degrees to radians
		                	expStr = expStr.replaceAll("sin\\(([^\\)]*)\\)", "sin(($1)*pi/180)");
		                	expStr = expStr.replaceAll("cos\\(([^\\)]*)\\)", "cos(($1)*pi/180)");
		                	expStr = expStr.replaceAll("tan\\(([^\\)]*)\\)", "tan(($1)*pi/180)");
		                	// Check for undefined tan values
		                	if (expression.matches("tan\\((\\d+)\\)")) {

		                	    int angle = Integer.parseInt(
		                	            expression.replaceAll("tan\\((\\d+)\\)", "$1"));

		                	    angle = angle % 360;

		                	    if (angle == 90 || angle == 270) {
		                	        display.setText("Undefined");
		                	        expression = "";
		                	        return;
		                	    }
		                	}

		                	Expression exp = new ExpressionBuilder(expStr)
		                	        .variables("pi")
		                	        .build();

		                	exp.setVariable("pi", Math.PI);

		                	double result = exp.evaluate();

		                	display.setText(expression + " = " + new java.text.DecimalFormat("0.##########").format(result));

		                	expression = String.valueOf(result);

		                }

		                catch(Exception ex){

		                    display.setText("Error");

		                    expression="";

		                }

		            }
		            else if(command.equals("Exit")){

		                System.exit(0);}
		    }
		        
		        public static void main(String[] args){

		            new ScientificCalculatorGUI();

		        }
		    

		        }

