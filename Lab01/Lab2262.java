import javax.swing.JOptionPane;
public class Lab2262 {
	public static void main(String[] args){
		String strNum1, strNum2, strNum3, strNum4, strNum5, strNum6;
		
		strNum1 = JOptionPane.showInputDialog(null, "Please input a11: ", "Input the first number", JOptionPane. INFORMATION_MESSAGE); 

		strNum2 = JOptionPane.showInputDialog(null, "Please input a12: ", "Input the second number", JOptionPane. INFORMATION_MESSAGE); 
		
		strNum3 = JOptionPane.showInputDialog(null, "Please input a21:", "Input the second number", JOptionPane. INFORMATION_MESSAGE);

		strNum4 = JOptionPane.showInputDialog(null, "Please input a22: ", "Input the second number", JOptionPane. INFORMATION_MESSAGE);

		strNum5 = JOptionPane.showInputDialog(null, "Please input b1: ", "Input the second number", JOptionPane. INFORMATION_MESSAGE);

		strNum6 = JOptionPane.showInputDialog(null, "Please input b2: ", "Input the second number", JOptionPane. INFORMATION_MESSAGE);
		double a11 = Double.parseDouble(strNum1);
		double a12 = Double.parseDouble(strNum2);
		double a21 = Double.parseDouble(strNum3);
		double a22 = Double.parseDouble(strNum4);
		double b1 = Double.parseDouble(strNum5);
		double b2 = Double.parseDouble(strNum6);
		double D = a11*a22 - a12*a21;
		if (D == 0) {
			JOptionPane.showMessageDialog(null, "He vo nghiem hoac vo so nghiem");
		}
		double x1 = (b1*a22 - b2*a12)/D;
		double x2 = (a11*b2 - a21*b1)/D;
		JOptionPane.showMessageDialog(null, x1, "x1 is", JOptionPane.INFORMATION_MESSAGE); 
		JOptionPane.showMessageDialog(null, x2, "x2 is", JOptionPane.INFORMATION_MESSAGE); 

	}
}