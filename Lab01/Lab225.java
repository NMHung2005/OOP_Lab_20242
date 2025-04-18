import javax.swing.JOptionPane;
public class Lab225 {
	public static void main(String[] args){
		String strNum1, strNum2;
		
		strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane. INFORMATION_MESSAGE); 

		strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane. INFORMATION_MESSAGE); 
		
		double Num1 = Double.parseDouble(strNum1);
		double Num2 = Double.parseDouble(strNum2);
		double result = Num1 + Num2;
		JOptionPane.showMessageDialog(null, result, "Sum is", JOptionPane.INFORMATION_MESSAGE); 
		result = Num1 - Num2;
		JOptionPane.showMessageDialog(null, result, "Difference is", JOptionPane.INFORMATION_MESSAGE); 
		result = Num1 * Num2;
		JOptionPane.showMessageDialog(null, result, "Product is", JOptionPane.INFORMATION_MESSAGE); 
		result = Num1 / Num2;
		JOptionPane.showMessageDialog(null, result, "Quotient is", JOptionPane.INFORMATION_MESSAGE); 
		JOptionPane.showMessageDialog(null, Num1, "Divisor is", JOptionPane.INFORMATION_MESSAGE); 
	}
}