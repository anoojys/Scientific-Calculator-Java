package calci;
import java.util.Scanner;
import java.util.ArrayList;
public class ScientificCalculator {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> history = new ArrayList<String>();

	public static void main(String args[]) {
		while (true) {

            System.out.println("\n---- SCIENTIFIC CALCULATOR ----");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Power");
            System.out.println("6. Square Root");
            System.out.println("7. Sine");
            System.out.println("8. Cosine");
            System.out.println("9. Tangent");
            System.out.println("10. Logarithm");
            System.out.println("11. Factorial");
            System.out.println("12. Average");
            System.out.println("13. View History");
            System.out.println("14. Clear History");
            System.out.println("15. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("How many numbers? ");
                int n = sc.nextInt();

                double sum = 0;
                String addHistory = "";

                for(int i = 1; i <= n; i++) {
                    System.out.print("Enter number " + i + ": ");
                    double num = sc.nextDouble();
                    sum += num;

                    addHistory += num;
                    if(i < n)
                        addHistory += " + ";
                }

                System.out.println("Result = " + sum);
                history.add(addHistory + " = " + sum);

                break;

                case 2:
                

                    System.out.print("How many numbers? ");
                    n = sc.nextInt();

                    System.out.print("Enter number 1: ");
                    double sub = sc.nextDouble();

                    String subHistory = sub + "";

                    for(int i = 2; i <= n; i++) {
                        System.out.print("Enter number " + i + ": ");
                        double num = sc.nextDouble();

                        sub -= num;
                        subHistory += " - " + num;
                    }

                    System.out.println("Result = " + sub);
                    history.add(subHistory + " = " + sub);

                    break;

                case 3:

                    System.out.print("How many numbers? ");
                    n = sc.nextInt();

                    double product = 1;
                    String mulHistory = "";

                    for(int i = 1; i <= n; i++) {
                        System.out.print("Enter number " + i + ": ");
                        double num = sc.nextDouble();

                        product *= num;

                        mulHistory += num;
                        if(i < n)
                            mulHistory += " * ";
                    }

                    System.out.println("Result = " + product);
                    history.add(mulHistory + " = " + product);

                    break;

                case 4:

                    System.out.print("How many numbers? ");
                    n = sc.nextInt();

                    System.out.print("Enter number 1: ");
                    double div = sc.nextDouble();

                    String divHistory = div + "";

                    for(int i = 2; i <= n; i++) {

                        System.out.print("Enter number " + i + ": ");
                        double num = sc.nextDouble();

                        if(num == 0) {
                            System.out.println("Cannot divide by zero.");
                            break;
                        }

                        div /= num;
                        divHistory += " / " + num;
                    }

                    System.out.println("Result = " + div);
                    history.add(divHistory + " = " + div);

                    break;

                case 5:

                    System.out.print("Enter base: ");
                    double base = sc.nextDouble();

                    System.out.print("Enter exponent: ");
                    double exponent = sc.nextDouble();

                    double power = Math.pow(base, exponent);

                    System.out.println("Result = " + power);

                    history.add(base + "^" + exponent + " = " + power);

                    break;

                case 6:

                    System.out.print("Enter a number: ");
                    double number = sc.nextDouble();

                    double squareRoot = Math.sqrt(number);

                    System.out.println("Result = " + squareRoot);

                    history.add("√" + number + " = " + squareRoot);

                    break;

                case 7:

                    System.out.print("Enter angle in degrees: ");
                    double angle = sc.nextDouble();

                    double sine = Math.sin(Math.toRadians(angle));

                    System.out.println("Result = " + sine);

                    history.add("sin(" + angle + ") = " + sine);

                    break;

                case 8:

                    System.out.print("Enter angle in degrees: ");
                    angle = sc.nextDouble();

                    double cosine = Math.cos(Math.toRadians(angle));

                    System.out.println("Result = " + cosine);

                    history.add("cos(" + angle + ") = " + cosine);

                    break;

                case 9:

                    System.out.print("Enter angle in degrees: ");
                    angle = sc.nextDouble();

                    double tangent = Math.tan(Math.toRadians(angle));

                    System.out.println("Result = " + tangent);

                    history.add("tan(" + angle + ") = " + tangent);

                    break;

                case 10:

                    System.out.print("Enter a number: ");
                    number = sc.nextDouble();

                    double log = Math.log10(number);

                    System.out.println("Result = " + log);

                    history.add("log(" + number + ") = " + log);

                    break;

                case 11:

                    System.out.print("Enter a number: ");
                    int fact = sc.nextInt();

                    long factorial = 1;

                    for(int i = 1; i <= fact; i++)
                    {
                        factorial *= i;
                    }

                    System.out.println("Result = " + factorial);

                    history.add(fact + "! = " + factorial);

                    break;

                case 12:

                    System.out.print("How many numbers? ");
                    int a= sc.nextInt();

                    double sums = 0;

                    String avgHistory = "";

                    for(int i = 1; i <= a; i++)
                    {
                        System.out.print("Enter number " + i + ": ");

                        double num = sc.nextDouble();

                        sums += num;

                        avgHistory += num;

                        if(i < a)
                            avgHistory += ", ";
                    }

                    double average = sums / a;

                    System.out.println("Average = " + average);

                    history.add("Average(" + avgHistory + ") = " + average);

                    break;

                case 13:

                    if(history.isEmpty())
                    {
                        System.out.println("No calculations found.");
                    }
                    else
                    {
                        System.out.println("\n========== CALCULATION HISTORY ==========");

                        for(String record : history)
                        {
                            System.out.println(record);
                        }
                    }

                    break;

                case 14:
                    history.clear();
                    System.out.println("History Cleared!");
                    break;

                case 15:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

	}


	