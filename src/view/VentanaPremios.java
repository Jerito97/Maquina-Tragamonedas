package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.ItemSelectable;

import javax.swing.SwingConstants;

import controller.Controlador;
import model.Premio;
import modelView.PremioView;

public class VentanaPremios extends JFrame {
	JButton atras;
	JButton agregar;
	JButton eliminar;

	Controlador controlador;
	
	JLabel agregarPremios;
	JLabel eliminarPremios;
	JLabel listaPremios;
	JComboBox<String> lista;
	JLabel fruta1Eliminar;
	JLabel fruta2Eliminar;
	JLabel fruta3Eliminar;
	JLabel montoAgregarLabel;
	JTextField montoDisplay;
	JComboBox fruta1;
	JLabel fruta1AgregarLabel;
	JComboBox fruta2;
	JLabel fruta2AgregarLabel;
	JComboBox fruta3;
	JLabel fruta3AgregarLabel;

	String[] frutas = {"Campana", "Cherry", "Limon", "Ciruela", "Siete Rojo", "Melon", "-"};

	ArrayList<PremioView> premiosArray = new ArrayList<PremioView>();

	public VentanaPremios () {
		configurar();
		eventos();
	}

	private void configurar() {
		controlador = controlador.miInstancia(0);
		
		Container contenedor = this.getContentPane();
		contenedor.setLayout(null);
		this.setSize(300, 400);
		this.setResizable(false);
		this.setTitle("Administrar");
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
		agregar.setEnabled(true);

		eliminar = new JButton("Eliminar");
		eliminar.setBounds(180, 120, 95, 40);

		listaPremios = new JLabel("Premios");
		listaPremios.setBounds(20, 35, 70, 25);

		lista = new JComboBox();
		lista.setBounds(15, 55, 260, 25);

		montoAgregarLabel = new JLabel("Monto");
		montoAgregarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		montoAgregarLabel.setBounds(105, 220, 80, 14);

		montoDisplay = new JTextField();
		montoDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		montoDisplay.setBounds(105, 233, 80, 20);
		montoDisplay.setColumns(10);

		fruta1AgregarLabel = new JLabel("Fruta 1");
		fruta1AgregarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fruta1AgregarLabel.setBounds(15, 250, 80, 25);

		fruta1 = new JComboBox(frutas);
		fruta1.setBounds(15, 270, 80, 25);

		fruta2AgregarLabel = new JLabel("Fruta 2");
		fruta2AgregarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fruta2AgregarLabel.setBounds(105, 250, 80, 25);

		fruta2 = new JComboBox(frutas);
		fruta2.setBounds(105, 270, 80, 25);

		fruta3AgregarLabel = new JLabel("Fruta 3");
		fruta3AgregarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fruta3AgregarLabel.setBounds(195, 250, 80, 25);

		fruta3 = new JComboBox(frutas);
		fruta3.setBounds(195, 270, 80, 25);

		contenedor.add(eliminarPremios);
		contenedor.add(agregarPremios);
		contenedor.add(atras);
		contenedor.add(agregar);
		contenedor.add(eliminar);
		contenedor.add(listaPremios);
		contenedor.add(lista);
		contenedor.add(montoAgregarLabel);
		contenedor.add(montoDisplay);
		contenedor.add(fruta1AgregarLabel);
		contenedor.add(fruta1);
		contenedor.add(fruta2AgregarLabel);
		contenedor.add(fruta2);
		contenedor.add(fruta3AgregarLabel);
		contenedor.add(fruta3);
		
		actualizarLista();
	}

	private void actualizarLista() {
		lista.removeAllItems();
		premiosArray = controlador.getPremios();
		for (int i = 0; i < premiosArray.size(); ++i) {
			String nombre = premiosArray.get(i).getNombre1() + " - " + premiosArray.get(i).getNombre2() + " - " + premiosArray.get(i).getNombre3();
			lista.addItem(nombre);
		}
	}
	

	private boolean checkEstado() {
		if (fruta1.getSelectedIndex() < 6 || fruta2.getSelectedIndex() < 6 || fruta3.getSelectedIndex() < 6) {
			return true;
		} else {
			return false;
		}
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
				String text = montoDisplay.getText();
				if (!text.isEmpty()) {
					int saldo = Integer.parseInt(text);
					if (checkEstado() && saldo > 0) {
						controlador.addPremio(saldo, fruta1.getSelectedIndex(), fruta2.getSelectedIndex(), fruta3.getSelectedIndex());
						actualizarLista();
					}
				}
			}

		});

		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = lista.getSelectedIndex();
				if (index != -1) {
					controlador.eliminarPremio(index);
					actualizarLista();
				}
			}
		});
		
		lista.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				ItemSelectable  is = (ItemSelectable )actionEvent.getSource();
				Object selected[] = is.getSelectedObjects();
			}
		});
	}
}
