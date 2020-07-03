package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class VentanaPremios extends JFrame {
	JButton atras;
	JButton confirmar;
	JList lista;
	
	public VentanaPremios () {
    	configurar();
    	eventos();
    }

	private void configurar() {
		Container contenedor = this.getContentPane();
    	contenedor.setLayout(null);
    	this.setSize(300, 300);
    	this.setResizable(false);
    	this.setTitle("Administrar Premios");

    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    	
    	atras = new JButton("Atras");
    	atras.setBounds(10, 235, 59, 25);
    	
    	confirmar = new JButton("Confirmar");
    	confirmar.setBounds(199, 220, 85, 40);
    	
    	lista = new JList();
    	lista.setBounds(10, 11, 85, 25);
    	
    	
    	contenedor.add(atras);
    	contenedor.add(confirmar);
    	contenedor.add(lista);
	}

	private void eventos() {
		
		
	}
}
