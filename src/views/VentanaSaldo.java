package views;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class VentanaSaldo extends JFrame {
	JButton botonOk;
    JLabel labelSaldo;
    JTextField textSaldo;

    public VentanaSaldo () {
    	configurar();
    	eventos();
    }

    private void configurar() {
    	Container contenedor = this.getContentPane();
    	contenedor.setLayout(null);
    	this.setSize(300, 150);
    	this.setResizable(false);

    	labelSaldo = new JLabel("Ingrese saldo");
    	botonOk = new JButton("Ok");
    	textSaldo = new JTextField();

    	labelSaldo.setBounds(43, 20, 100, 30);
    	botonOk.setBounds(120, 80, 50, 30);
    	textSaldo.setBounds(147, 20, 100, 30);

    	contenedor.add(labelSaldo);
    	contenedor.add(botonOk);
    	contenedor.add(textSaldo);
    }

    private void eventos() {
    	botonOk.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			String text = textSaldo.getText();
    			int saldo = Integer.parseInt(text);
    			VentanaJuego juego = new VentanaJuego(saldo);
    			juego.setVisible(true);
    			VentanaSaldo.this.setVisible(false);
    		}
    	});
    }
}
