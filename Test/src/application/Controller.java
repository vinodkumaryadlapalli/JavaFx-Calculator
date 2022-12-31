package application;
//vinod kumar, c0838767

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class Controller {
	static TextField textField;
	private double number1 = 0;
	private double number2 = 0;
	private double result = 0;
	private int dotcount = 0;
	private int count = 0;
	private String prevOperator = "";
	
	// for displaying text
public static void setText(TextField textField1) {
		textField = textField1;
	}
	
	// for a button clicked
	@FXML
	private void btnClick(ActionEvent event) {
		event.consume();
		String text = ((Button)event.getSource()).getText();
		
		if(text.equals(".") && dotcount == 1) {
			
		} else {
			String textInField = textField.getText();
			textInField += text;
			textField.setText(textInField);
		}
		
		if(text.equals(".") && dotcount < 1) {
			dotcount++;
		}
	}
	
	@FXML
	private void btnOperator(ActionEvent event) {
		String textInField = textField.getText();
		double num = Double.parseDouble(textInField);
		String operator = ((Button)event.getSource()).getText();
		clearText();
		
		if(operator.equals("sqrt")) {
			double sqr = Math.sqrt(num);
			textField.setText(Double.toString(sqr));
		}
		
		if(operator.equals("+/-")) {
			double negativeNum = num*2;
			number1 = num-negativeNum;
			textField.setText(Double.toString(number1));
		}
		
		if(count == 0) {
			number1 = num;
			count++;
			if(!operator.equals("+/-")) {
				prevOperator = operator;
			}
		}
		
		if(operator.equals("=")){
			if(prevOperator.equals("+")) {
				number2 = num;
				result = number1+number2;
				textField.setText(Double.toString(result));
			}
			if(prevOperator.equals("-")) {
				number2 = num;
				result = number1-number2;
				textField.setText(Double.toString(result));
			}
			if(prevOperator.equals("x")) {
				number2 = num;
				result = number1*number2;
				textField.setText(Double.toString(result));
			}
			if(prevOperator.equals("/")) {
				number2 = num;
				result = number1/number2;
				textField.setText(Double.toString(result));
			}
			System.out.println("Num - "+num);
			System.out.println("Num1 - "+number1);
			System.out.println("Num2 - "+number2);
			System.out.println("result - "+result);
			System.out.println(prevOperator);
			number1 = result;
			prevOperator = "";
			count = 0;
		}
	}
	
	private void clearText() {
		dotcount = 0;
		textField.setText("");
	}
	
	// for clearing the field to 0
	@FXML
	private void btnClear(ActionEvent event) {
		clearText();
		number1 = 0;
		number2 = 0;
		result = 0;
		count = 0;
		prevOperator = "";
		
	}
}


