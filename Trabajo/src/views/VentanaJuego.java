package views;

import models.*;
import java.util.Random;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Controlador;

public class VentanaJuego extends JFrame{
	//temporales

	int income = 10000;
	int crdtBet = 5;
	
	private Controlador controlador;
	
	public JFrame frame;
    public JPanel panel;
    public JPanel panelButtons;
    public JPanel panelDisplays;
    public JPanel panelSpin;
    public JPanel boxes;
    
    public JLabel creditsLeftLabel;		//CREDITOS RESTANTES APOSTADOR
    public JLabel creditsLeftDisplay;
    public JLabel betAmntLabel;			//CANTIDAD CREDITOS A APOSTAR
    public JLabel betAmntDisplay;
    public JLabel incomeLabel;			//RECAUDACION MAQUINA
    public JLabel incomeDisplay;
    public static JLabel box1;			//CASILLA 1
    public static JLabel box2;			//CASILLA 2
    public static JLabel box3;			//CASILLA 3

    public JButton addCoin;				//BOTON AGREGAR CREDITO PARA EL JUGADOR
    public JButton spin;				//BOTON GIRAR
    public JButton stop;				//BOTON FRENAR
    
    Thread t1;
    Thread t2;
    Thread t3;
    
    int spinClick = 0;					//PARA VERIFICAR EL APRETADO DE GIRAR
    int stopClick = 0;					//PARA VERIFICAR EL APRETADO DE FRENAR
    
    ArrayList<Symbol> imgsList = new ArrayList<Symbol>();
    int valRan;
    
    public VentanaJuego (int saldo) {
    	configurar(saldo);
    	eventos();
    }
    
    private void configurar(int saldo) {
    	this.controlador = controlador.miInstancia(saldo);
    	
    	Container contenedor = this.getContentPane();
    	contenedor.setLayout(null);
    	this.setSize(800, 400);
    	this.setResizable(false);
    	this.setBackground(Color.white);
    	
    	betAmntLabel = new JLabel("Cant. a Apostar");
    	betAmntLabel.setBounds(44, 100, 76, 30);
    	getContentPane().add(betAmntLabel);
    	
    	creditsLeftLabel = new JLabel("Creditos Restantes");
    	creditsLeftLabel.setBounds(29, 141, 100, 39);
    	getContentPane().add(creditsLeftLabel);
    	
    	incomeLabel= new JLabel("Recaudacion");
    	incomeLabel.setBounds(44, 191, 62, 30);
    	getContentPane().add(incomeLabel);
    	
    	betAmntDisplay = new JLabel();
    	betAmntDisplay.setHorizontalAlignment(SwingConstants.CENTER);
    	betAmntDisplay.setText(String.valueOf(crdtBet));
    	betAmntDisplay.setBounds(130, 104, 48, 22);
    	betAmntDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	getContentPane().add(betAmntDisplay);
    	
    	creditsLeftDisplay = new JLabel();
    	creditsLeftDisplay.setHorizontalAlignment(SwingConstants.CENTER);
    	creditsLeftDisplay.setText(String.valueOf(controlador.getSaldo()));
    	creditsLeftDisplay.setBounds(130, 147, 48, 22);
    	creditsLeftDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	getContentPane().add(creditsLeftDisplay);
    	
    	incomeDisplay = new JLabel();
    	incomeDisplay.setHorizontalAlignment(SwingConstants.CENTER);
    	incomeDisplay.setText(String.valueOf(income));
    	incomeDisplay.setBounds(130, 195, 48, 22);
    	incomeDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	getContentPane().add(incomeDisplay);
    	
    	box1 = new JLabel();
    	box1.setBounds(219, 11, 160, 250);
    	box1.setBorder(BorderFactory.createLineBorder(Color.black));
    	box1.setBackground(Color.white);
    	getContentPane().add(box1);
    	
    	box2 = new JLabel();
    	box2.setBounds(389, 11, 160, 250);
    	box2.setBorder(BorderFactory.createLineBorder(Color.black));
    	box2.setBackground(Color.white);
    	getContentPane().add(box2);
    	
    	box3 = new JLabel();
    	box3.setBounds(559, 11, 160, 250);
    	box3.setBorder(BorderFactory.createLineBorder(Color.black));
    	box3.setBackground(Color.white);
    	getContentPane().add(box3);
    	
    	
    	addCoin = new JButton("+5 Creditos");
    	addCoin.setBounds(250, 300, 100, 23);
    	getContentPane().add(addCoin);
    	
    	spin = new JButton("GIRAR");
    	spin.setBounds(360, 289, 100, 45);
    	getContentPane().add(spin);
    	
    	stop = new JButton("FRENAR");
    	stop.setBounds(470, 289, 100, 45);
    	getContentPane().add(stop);
    	
    }
    
    private void eventos() {
    	addCoin.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			
    		}
    	});
    	
    	spin.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			controlador.girar();
    			if (spinClick == 0 && controlador.getSaldo()>=5) {
					
					stopClick = 0;
					spinClick++;
					controlador.getSaldo() = controlador.getSaldo() - crdtBet;
					creditsLeftDisplay.setText(String.valueOf(controlador.getSaldo()));
				} else if (controlador.getSaldo()<5){
					JOptionPane.showMessageDialog(frame, "ERROR: NO TENES CREDITOS SUFICIENTES PARA APOSTAR");
				} else {
					JOptionPane.showMessageDialog(frame, "SOLO GIRAR UNA VEZ POR TURNO");
				}
    		}
    	});
    	
    	stop.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			int valSymbolo1 = numeroAzar();
    			int valSymbolo2 = numeroAzar();
    			int valSymbolo3 = numeroAzar();
    			controlador.frenar(valSymbolo1, valSymbolo2, valSymbolo3);
    		}
    	});
    }
    
    private void actualizarImagenSymbol() {
    	
    }
    
    private int numeroAzar() {
    	Random rand = new Random();
    	return rand.nextInt(5);
    }
}
