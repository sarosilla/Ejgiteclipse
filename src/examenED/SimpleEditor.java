package examenED;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SimpleEditor extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton button = new JButton("Guardar cambios");
	JTextArea newItemArea = new JTextArea();

	public SimpleEditor(String title) {
	    super(title);                             
	    setDefaultCloseOperation(EXIT_ON_CLOSE);  
	    setSize(300, 350);                        
	    setLayout(null);
	    
	    newItemArea.setLocation(3, 3);
	    newItemArea.setSize(297, 282);
	    getContentPane().add(newItemArea);
	
	    button.setLocation(40,290);  
	    button.setSize(200, 25);
	    getContentPane().add(button);
	    
	    button.addActionListener(this);
	
	}
	
	public static void main(String[] args) {
	    SimpleEditor frame;
	
	    frame = new SimpleEditor("CONTRIBUTING.md");      
	    frame.setVisible(true);                             
	}
	
	public void actionPerformed(ActionEvent e) {
	
	    if(e.getSource() == button)
	    {        
	        try ( 
	        	PrintWriter out = new PrintWriter(new FileWriter("CONTRIBUTING.md"))) 
	        {
	            newItemArea.write(out);
	        } catch (IOException e1) {
	            System.err.println("Ocurrió un error");
	            e1.printStackTrace();
	        }
	    }
	}
}