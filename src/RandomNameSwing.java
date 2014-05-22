import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class RandomNameSwing extends JFrame {

	public static void main(String args[]) {
		new RandomNameSwing();
	}
	
	RandomNameSwing() {
		
		//setting frame settings and layout
		JFrame frame = new JFrame("Random Name Generator");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((int)(dim.getHeight()/2),(int)(dim.getWidth()/4), 500, 80);
		frame.setSize(500, 80);
		frame.setLayout(new GridLayout(2,1));
		frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	             System.exit(0);
	          }        
	       });  
		
		//setting button functionality
		final JLabel textArea = new JLabel("Your name is: ");
		JButton generate = new JButton("Generate");
		generate.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 randomName r = new randomName();
	        	 r.genNewName();
	            textArea.setText("Your name is: "+r.getName());
	         }          
	      });
		
		//adding the text and button to frame
		frame.add(textArea);
		frame.add(generate);
		
		frame.setVisible(true);

	}
}



