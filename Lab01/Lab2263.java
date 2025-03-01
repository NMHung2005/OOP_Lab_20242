import javax.swing.JOptionPane;
public class Lab2263	 {
	public static void main(String[] args){
		String strNum1, strNum2, strNum3;
		
		strNum1 = JOptionPane.showInputDialog(null, "Please input a: ", "Input the first number", JOptionPane. INFORMATION_MESSAGE); 

		strNum2 = JOptionPane.showInputDialog(null, "Please input b: ", "Input the second number", JOptionPane. INFORMATION_MESSAGE); 
		
		strNum3 = JOptionPane.showInputDialog(null, "Please input c:", "Input the second number", JOptionPane. INFORMATION_MESSAGE);
		double a = Double.parseDouble(strNum1);
		double b = Double.parseDouble(strNum2);
		double c = Double.parseDouble(strNum3);
		double delta = b*b - 4*a*c;
		if (delta > 0) {
			double x1 = (-b + Math.sqrt(delta))/(2*a);
			double x2 = (-b - Math.sqrt(delta))/(2*a);
			JOptionPane.showMessageDialog(null, x1, "x1 is", JOptionPane.INFORMATION_MESSAGE); 
			JOptionPane.showMessageDialog(null, x2, "x2 is", JOptionPane.INFORMATION_MESSAGE); 
		} else if (delta == 0) {
			double x = -b/2*a;
			JOptionPane.showMessageDialog(null, x, "Phuong trinh co Nghiem kep x = ", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Phuong trinh khong co nghiem thuc");
		}
	
		

	}
}