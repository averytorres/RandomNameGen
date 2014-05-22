import java.applet.Applet;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class randomNameApp extends Applet implements ActionListener {

	Button generate;
	TextField textArea;
	randomName r = new randomName();


	public void init(){
		
		setSize(new Dimension(700,40));
		setBackground(new Color(12,12,12));
		setLayout(new FlowLayout()); 

		generate = new Button("Generate");
		generate.addActionListener(this);

		textArea = new TextField("Your name is: ",50);
		textArea.setEditable(false);

		add(textArea);
		add(generate);
	}

	public void paint(Graphics g) {

		r.genNewName();
		textArea.setText("Your name is: "+r.getName());

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == generate){ 
			this.repaint();
		}

	}
}
