package contrib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Dimension;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ContribEditor extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton boton;
	private JTextArea textArea;
	public static String CONTRIBUTING = "CONTRIBUTING.md";

	public ContribEditor(String title) {
	    super(title);
	    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	    setPreferredSize(new Dimension(300, 350));
	    
	    textArea = new JTextArea();
	    textArea.setLineWrap(true);
	    textArea.setWrapStyleWord(true);
	    textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    try (FileReader reader = new FileReader(CONTRIBUTING)) {
	    	textArea.read(reader, null);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    
	    boton = new JButton("Guardar cambios");
	    boton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    boton.addActionListener(this);
	    
	    getContentPane().add(textArea);
	    getContentPane().add(boton); 	    
	    
	    pack();
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);  
	    
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	    if(ae.getSource() == boton)
	    {        
	        try ( 
	        	PrintWriter out = new PrintWriter(new FileWriter(CONTRIBUTING))) 
	        {
	            textArea.write(out);
	        } catch (IOException e) {
	            System.err.println("Ocurrió un error");
	            e.printStackTrace();
	        }
	    }
	}
	
	public static void main(String[] args) {
	    ContribEditor frame;
	
	    frame = new ContribEditor(CONTRIBUTING);      
	    frame.setVisible(true);                             
	}
	

}