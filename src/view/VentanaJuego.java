package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import controller.Controlador;

public class VentanaJuego extends JFrame{

	int income = 10000;
	int crdtBet = 5;

	private Controlador controlador;

	public JFrame frame;

    public JLabel creditsLeftLabel;		//CREDITOS RESTANTES APOSTADOR
    public JLabel creditsLeftDisplay;

    public JLabel betAmntLabel;			//CANTIDAD CREDITOS A APOSTAR
    public JLabel betAmntDisplay;

    public JLabel incomeLabel;			//RECAUDACION MAQUINA
    public JLabel incomeDisplay;

    public JLabel casilla1;
    public JLabel casilla2;
    public JLabel casilla3;

    public JButton addCoin;				//BOTON AGREGAR CREDITO PARA EL JUGADOR
    public JButton spin;				//BOTON GIRAR
    public JButton stop;				//BOTON FRENAR
    public JButton retirar;

    boolean isSpinning = false;

    public VentanaJuego (int saldo) {
    	configurar(saldo);
    	eventos();
    }

    private void configurar(int saldo) {
    	this.controlador = controlador.miInstancia(saldo);

    	Container contenedor = this.getContentPane();
    	contenedor.setLayout(null);
    	this.setTitle("Maquina Tragamonedas");
    	this.setSize(800, 400);
    	this.setResizable(false);
    	this.setBackground(Color.white);

    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

    	betAmntLabel = new JLabel("Cant. a Apostar");
    	betAmntLabel.setBounds(44, 100, 76, 30);
    	contenedor.add(betAmntLabel);

    	creditsLeftLabel = new JLabel("Creditos Restantes");
    	creditsLeftLabel.setBounds(29, 141, 100, 39);
    	contenedor.add(creditsLeftLabel);

    	incomeLabel= new JLabel("Recaudacion");
    	incomeLabel.setBounds(44, 191, 62, 30);
    	contenedor.add(incomeLabel);

    	betAmntDisplay = new JLabel();
    	betAmntDisplay.setHorizontalAlignment(SwingConstants.CENTER);
    	betAmntDisplay.setText(String.valueOf(crdtBet));
    	betAmntDisplay.setBounds(130, 104, 48, 22);
    	betAmntDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	contenedor.add(betAmntDisplay);

    	creditsLeftDisplay = new JLabel();
    	creditsLeftDisplay.setHorizontalAlignment(SwingConstants.CENTER);
    	creditsLeftDisplay.setText(String.valueOf(controlador.getSaldo()));
    	creditsLeftDisplay.setBounds(130, 147, 48, 22);
    	creditsLeftDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	contenedor.add(creditsLeftDisplay);

    	incomeDisplay = new JLabel();
    	incomeDisplay.setHorizontalAlignment(SwingConstants.CENTER);
    	incomeDisplay.setText(String.valueOf(income));
    	incomeDisplay.setBounds(130, 195, 48, 22);
    	incomeDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	contenedor.add(incomeDisplay);

    	casilla1 = new JLabel();
    	casilla1.setBounds(219, 11, 160, 250);
    	casilla1.setBorder(BorderFactory.createLineBorder(Color.black));
    	casilla1.setBackground(Color.white);
    	ImageIcon imgThisImg1 = new ImageIcon("C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\bell.png");
    	this.casilla1.setIcon(imgThisImg1);
    	contenedor.add(casilla1);

    	casilla2 = new JLabel();
    	casilla2.setBounds(389, 11, 160, 250);
    	casilla2.setBorder(BorderFactory.createLineBorder(Color.black));
    	casilla2.setBackground(Color.white);
    	ImageIcon imgThisImg2 = new ImageIcon("C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\redseven.png");
    	this.casilla2.setIcon(imgThisImg2);
    	contenedor.add(casilla2);

    	casilla3 = new JLabel();
    	casilla3.setBounds(559, 11, 160, 250);
    	casilla3.setBorder(BorderFactory.createLineBorder(Color.black));
    	casilla3.setBackground(Color.white);
    	ImageIcon imgThisImg3 = new ImageIcon("C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\lemon.png");
    	this.casilla3.setIcon(imgThisImg3);
    	contenedor.add(casilla3);


    	addCoin = new JButton("+5 Creditos");
    	addCoin.setBounds(250, 300, 100, 23);
    	contenedor.add(addCoin);

    	spin = new JButton("GIRAR");
    	spin.setBounds(360, 289, 100, 45);
    	contenedor.add(spin);

    	stop = new JButton("FRENAR");
    	stop.setBounds(470, 289, 100, 45);
    	contenedor.add(stop);

    	retirar = new JButton("Retiar credito");
    	retirar.setBounds(580, 300, 120, 23);
    	contenedor.add(retirar);

    }

    private void eventos() {
    	addCoin.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			controlador.agregarCreditos(5);
    			creditsLeftDisplay.setText(String.valueOf(controlador.getSaldo()));
    		}
    	});

    	spin.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {

    			if (isSpinning == true) {
    				JOptionPane.showMessageDialog(frame, "Estas girando! Apreta en Frenar para ver el resultado.");
    			} else {

    				if (controlador.getSaldo() < 5) {
    					JOptionPane.showMessageDialog(frame, "No contas con los creditos suficientes para jugar! Por favor agrega mas creditos.");
    				} else {
    					isSpinning = true;
            			setImagenInicial();
            			controlador.girar();
            			int texto = controlador.getPozoAcumulado();
            			incomeDisplay.setText(String.valueOf(texto));
            			creditsLeftDisplay.setText(String.valueOf(controlador.getSaldo()));
    				}
    			}
    		}
    	});

    	stop.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if (isSpinning == true) {
    				int[] symbolIDs = controlador.frenar();
        			actualizarImagenSymbol(symbolIDs[0], symbolIDs[1], symbolIDs[2]);
        			controlador.chequear(symbolIDs[0], symbolIDs[1], symbolIDs[2]);

        			int texto = controlador.getPozoAcumulado();
        			incomeDisplay.setText(String.valueOf(texto));

        			int textoSaldo = controlador.getSaldo();
        			creditsLeftDisplay.setText(String.valueOf(textoSaldo));
        			isSpinning = false;
    			}
    		}
    	});

    	retirar.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			creditsLeftDisplay.setText(String.valueOf(0));
    			JOptionPane.showMessageDialog(frame, "Te fuiste con " + controlador.getSaldo() + " creditos");
    			VentanaInicio inicio = new VentanaInicio();
    			inicio.setVisible(true);
    			VentanaJuego.this.setVisible(false);
    		}
    	});
    }

    private void setImagenInicial() {
    	ImageIcon imgThisImg1 = new ImageIcon("C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\spinAnim1.gif");
    	this.casilla1.setIcon(imgThisImg1);

    	ImageIcon imgThisImg2 = new ImageIcon("C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\spinAnim2.gif");
    	this.casilla2.setIcon(imgThisImg2);

    	ImageIcon imgThisImg3 = new ImageIcon("C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\spinAnim3.gif");
    	this.casilla3.setIcon(imgThisImg3);
    }

    private void actualizarImagenSymbol(int valSymbol1, int valSymbol2, int valSymbol3) {
    	ImageIcon cas1 = new ImageIcon(controlador.obtenerImagen(valSymbol1));
    	this.casilla1.setIcon(cas1);

    	ImageIcon cas2 = new ImageIcon(controlador.obtenerImagen(valSymbol2));
    	this.casilla2.setIcon(cas2);

    	ImageIcon cas3 = new ImageIcon(controlador.obtenerImagen(valSymbol3));
    	this.casilla3.setIcon(cas3);
    }
}
