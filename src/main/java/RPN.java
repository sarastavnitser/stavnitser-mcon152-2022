import java.util.*;

/**
 * Program takes a string entered by the user and splits it up by the spaces into an array list.
 * it checks to see if the elements are either numbers or acceptable operands and then goes through a process using
 * Stack to hold the numbers adn pop them once we start using the operands. If all goes smoothly, the program
 * returns the result of the reverse polish notation expression that was given by the user.
 *
 */
public class RPN {


    private void RPNGo() {
        String elements;


        Scanner scan = new Scanner(System.in);
        while (true) {

            System.out.println("\nEnter an RPN expression or <CR> to exit");
            elements = scan.nextLine();
            if (elements.equals("")) {
                System.out.println("goodbye");
                System.exit(0);


            } else {
                String answer = findRPNResult(elements);
                System.out.println(answer);


            }
        }
    }

    String findRPNResult(String elements) {
        boolean showResult = true;
        String[] operands = new String[]{"+", "-", "*", "/"};
        Double retVal = null;
        ArrayList<String> elementsArray;
        elementsArray = evaluate(elements);
        Stack<Double> stack = new Stack();


        while (elementsArray.size() > 0) {


            if (isNumber(elementsArray.get(0))) {
                stack.push(Double.valueOf(elementsArray.get(0)));
                elementsArray.remove(0);

            } else if (Arrays.asList(operands).contains(elementsArray.get(0))) {
                String operator = elementsArray.get(0);

                double right;
                double left;
                double result;

                if (!stack.empty()) {
                    right = stack.pop();

                    if (!stack.empty()) {
                        left = stack.pop();

                    } else {
//                        System.out.println("Syntax error");

                        elementsArray.clear();
                        showResult = false;
                        retVal = null;
                        return "Syntax error";

                    }
                } else {
//                    System.out.println("Syntax error");
                    elementsArray.clear();
                    showResult = false;
                    retVal = null;
                    return "Syntax error";

                }

                switch (operator) {
                    case ("+"):
                        result = left + right;
                        break;
                    case ("-"):
                        result = left - right;
                        break;
                    case ("*"):
                        result = left * right;
                        break;
                    case ("/"):
                        result = left / right;
                        break;

                    default:
                        return ("Unexpected value: " + operator.toString());
//                        throw new IllegalStateException("Unexpected value: " + operator);
                }
                elementsArray.remove(0);


                stack.push(result);


            } else {
//                System.out.println("unexpected symbol");
                showResult = false;
                retVal = null;
                return "unexpected symbol";

            }


        }
        if (showResult) {

            retVal = stack.pop();

            if (!stack.empty()) {
                return (String.valueOf(retVal) + "\nextra junk ignored");
//                System.out.println("extra junk ignored");
            }
        }
        return String.valueOf(retVal);
    }

    private ArrayList<String> evaluate(String s) {

        String[] sArray = s.split(" ");
        ArrayList<String> sArrayList = new ArrayList<>();

        Collections.addAll(sArrayList, sArray);
        return sArrayList;
    }

    private boolean isNumber(String num) {
        boolean number = true;
        try {
            Double.parseDouble(num);

        } catch (NumberFormatException e) {
            number = false;
        }
        return number;
    }


}
