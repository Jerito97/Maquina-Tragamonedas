package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class VentanaPremios extends JFrame {
	JButton atras;
	JButton confirmar;
	JButton eliminar;
	JLabel listaPremios;
	JList lista;
	JLabel nombreLabel;
	JTextField nombreDisplay;
	JLabel montoLabel;
	JTextField montoDisplay;
	JList fruta1;
	JLabel fruta1Label;
	JList fruta2;
	JLabel fruta2Label;
	JList fruta3;
	JLabel fruta3Label;
	
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
    	atras.setBounds(8, 218, 70, 25);
    	
    	confirmar = new JButton("Agregar");
    	confirmar.setBounds(180, 210, 95, 40);
    	confirmar.setEnabled(false);
    	
    	eliminar = new JButton("Eliminar");
    	eliminar.setBounds(85, 210, 95, 40);
    	
    	listaPremios = new JLabel("Premios");
    	listaPremios.setBounds(15, 11, 70, 25);
    	
    	lista = new JList();
    	lista.setBounds(8, 30, 70, 25);
    	
    	nombreLabel = new JLabel("Nombre");
    	nombreLabel.setBounds(97, 58, 48, 14);
    	
    	nombreDisplay = new JTextField();
    	nombreDisplay.setBounds(85, 72, 70, 20);
    	nombreDisplay.setColumns(10);
    	
    	montoLabel = new JLabel("Monto");
    	montoLabel.setBounds(191, 58, 48, 14);
    	
    	montoDisplay = new JTextField();
    	montoDisplay.setBounds(180, 72, 70, 20);
    	montoDisplay.setColumns(10);
    	
    	fruta1Label = new JLabel("Fruta 1");
    	fruta1Label.setBounds(55, 103, 70, 25);
    	
    	fruta1 = new JList();
    	fruta1.setBounds(45, 130, 70, 25);
    	
    	fruta2Label = new JLabel("Fruta 2");
    	fruta2Label.setBounds(135, 103, 70, 25);
    	
    	fruta2 = new JList();
    	fruta2.setBounds(125, 130, 70, 25);
    	
    	fruta3Label = new JLabel("Fruta 3");
    	fruta3Label.setBounds(215, 103, 70, 25);
    	
    	fruta3 = new JList();
    	fruta3.setBounds(205, 130, 70, 25);
    	
    	contenedor.add(atras);
    	contenedor.add(confirmar);
    	contenedor.add(eliminar);
    	contenedor.add(listaPremios);
    	contenedor.add(lista);
    	contenedor.add(nombreLabel);
    	contenedor.add(nombreDisplay);
    	contenedor.add(montoLabel);
    	contenedor.add(montoDisplay);
    	contenedor.add(fruta1Label);
    	contenedor.add(fruta1);
    	contenedor.add(fruta2Label);
    	contenedor.add(fruta2);
    	contenedor.add(fruta3Label);
    	contenedor.add(fruta3);
	}

	private void eventos() {
		atras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio inicio = new VentanaInicio();
				inicio.setVisible(true);
				VentanaPremios.this.setVisible(false);
			}
		});
		
		confirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
	}
}
