import javax.swing.JOptionPane;
public class Lab2261 {
	public static void main(String[] args){
		String strNum1, strNum2;
		
		
		strNum1 = JOptionPane.showInputDialog(null, "Please input a: ", "Input the first number", JOptionPane. INFORMATION_MESSAGE); 

		strNum2 = JOptionPane.showInputDialog(null, "Please input b: ", "Input the second number", JOptionPane. INFORMATION_MESSAGE); 
		
		double Num1 = Double.parseDouble(strNum1);
		double Num2 = Double.parseDouble(strNum2);
		if (Num1 == 0){
			if (Num2 == 0) {
				JOptionPane.showMessageDialog(null, "Phuong trinh vo so nghiem!");
			} else {
				JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem!");
			}
		} else {
			double x = -Num1/Num2;
			JOptionPane.showMessageDialog(null, x, "x =", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}