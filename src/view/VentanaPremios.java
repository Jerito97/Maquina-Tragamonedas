package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;

public class VentanaPremios extends JFrame {
	JButton atras;
	JButton agregar;
	JButton eliminar;
	
	//Eliminar Premios
	JLabel agregarPremios;
	JLabel eliminarPremios;
	JLabel listaPremios;
	JComboBox lista;
	JLabel montoEliminar;
	JLabel fruta1Eliminar;
	JLabel fruta2Eliminar;
	JLabel fruta3Eliminar;
	
	//Agregar Premios
	JLabel nombreLabel;
	JTextField nombreDisplay;
	JLabel montoAgregarLabel;
	JTextField montoDisplay;
	JComboBox fruta1;
	JLabel fruta1AgregarLabel;
	JComboBox fruta2;
	JLabel fruta2AgregarLabel;
	JComboBox fruta3;
	JLabel fruta3AgregarLabel;
	
	String[] premios = {"Campanas", "Limones"};
	String[] frutas = {"-", "Campana", "Cherry", "Limon", "Ciruela", "Siete Rojo", "Melon"};
	
	public VentanaPremios () {
    	configurar();
    	eventos();
    }

	private void configurar() {
		Container contenedor = this.getContentPane();
    	contenedor.setLayout(null);
    	this.setSize(300, 400);
    	this.setResizable(false);
    	this.setTitle("Administrar Premios");
    	JSeparator separator = new JSeparator();
    	separator.setBounds(0, 175, 300, 2);
    	contenedor.add(separator);

    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    	
    	eliminarPremios = new JLabel("Eliminar Premios");
    	eliminarPremios.setFont(new Font("Arial", Font.BOLD, 14));
    	eliminarPremios.setBounds(90, 10, 121, 25);
    	
    	agregarPremios = new JLabel("Agregar Premios");
    	agregarPremios.setFont(new Font("Arial", Font.BOLD, 14));
    	agregarPremios.setBounds(90, 185, 121, 25);
    	
    	atras = new JButton("Atras");
    	atras.setBounds(15, 320, 70, 25);
    	
    	agregar = new JButton("Agregar");
    	agregar.setBounds(180, 310, 95, 40);
    	agregar.setEnabled(false);
    	
    	eliminar = new JButton("Eliminar");
    	eliminar.setBounds(180, 120, 95, 40);
    	
    	listaPremios = new JLabel("Premios");
    	listaPremios.setBounds(20, 35, 70, 25);
    	
    	lista = new JComboBox(premios);
    	lista.setBounds(15, 55, 100, 25);
    	
    	montoEliminar = new JLabel("Monto: ");
    	montoEliminar.setBounds(180, 91, 70, 25);
    	
    	fruta1Eliminar = new JLabel("Fruta");
    	fruta1Eliminar.setBounds(15, 91, 70, 25);
    	
    	fruta2Eliminar = new JLabel("Fruta");
    	fruta2Eliminar.setBounds(59, 91, 70, 25);
    	
    	fruta3Eliminar = new JLabel("Fruta");
    	fruta3Eliminar.setBounds(105, 91, 70, 25);
    	
    	
    	nombreLabel = new JLabel("Nombre");
    	nombreLabel.setBounds(70, 215, 48, 14);
    	
    	nombreDisplay = new JTextField();
    	nombreDisplay.setBounds(59, 230, 70, 20);
    	nombreDisplay.setColumns(10);
    	
    	montoAgregarLabel = new JLabel("Monto");
    	montoAgregarLabel.setBounds(175, 215, 48, 14);
    	
    	montoDisplay = new JTextField();
    	montoDisplay.setBounds(160, 230, 70, 20);
    	montoDisplay.setColumns(10);
    	
    	fruta1AgregarLabel = new JLabel("Fruta 1");
    	fruta1AgregarLabel.setBounds(25, 250, 70, 25);
    	
    	fruta1 = new JComboBox(frutas);
    	fruta1.setBounds(15, 270, 80, 25);
    	
    	fruta2AgregarLabel = new JLabel("Fruta 2");
    	fruta2AgregarLabel.setBounds(115, 250, 70, 25);
    	
    	fruta2 = new JComboBox(frutas);
    	fruta2.setBounds(105, 270, 80, 25);
    	
    	fruta3AgregarLabel = new JLabel("Fruta 3");
    	fruta3AgregarLabel.setBounds(205, 250, 70, 25);
    	
    	fruta3 = new JComboBox(frutas);
    	fruta3.setBounds(195, 270, 80, 25);
    	
    	contenedor.add(eliminarPremios);
    	contenedor.add(agregarPremios);
    	contenedor.add(atras);
    	contenedor.add(agregar);
    	contenedor.add(eliminar);
    	contenedor.add(listaPremios);
    	contenedor.add(lista);
    	contenedor.add(nombreLabel);
    	contenedor.add(nombreDisplay);
    	contenedor.add(montoAgregarLabel);
    	contenedor.add(montoDisplay);
    	contenedor.add(fruta1AgregarLabel);
    	contenedor.add(fruta1);
    	contenedor.add(fruta2AgregarLabel);
    	contenedor.add(fruta2);
    	contenedor.add(fruta3AgregarLabel);
    	contenedor.add(fruta3);
    	contenedor.add(montoEliminar);
    	contenedor.add(fruta1Eliminar);
    	contenedor.add(fruta2Eliminar);
    	contenedor.add(fruta3Eliminar);
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
		
		agregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
	}
}
