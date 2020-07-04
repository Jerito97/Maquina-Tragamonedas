package view;

import controller.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaInicio extends JFrame {
	JButton entrar;
	JButton adminPremios;
	
    public VentanaInicio () {
    	configurar();
    	eventos();
    }

	private void configurar() {
		Container contenedor = this.getContentPane();
    	contenedor.setLayout(null);
    	this.setSize(300, 150);
    	this.setResizable(false);
    	this.setTitle("Bienvenido");
    	
    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
    	entrar = new JButton("Jugar");
    	entrar.setBounds(100, 11, 85, 40);
    	
    	adminPremios = new JButton("Administrar Premios");
    	adminPremios.setBounds(62, 62, 160, 40);
    	
    	contenedor.add(entrar);
    	contenedor.add(adminPremios);
	}

	private void eventos() {
		entrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					VentanaSaldo saldo = new VentanaSaldo();
					saldo.setVisible(true);
					VentanaInicio.this.setVisible(false);
			}
		});
		
		adminPremios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPremios premios = new VentanaPremios();
				premios.setVisible(true);
				VentanaInicio.this.setVisible(false);
			}
		});
		
	}
    
    
}
