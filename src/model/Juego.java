package model;

import javax.swing.JOptionPane;

public class Juego {
	private int saldo;

	int income = 10000;
	int crdtBet = 5;
    int box1Val;
    int box2Val;
    int box3Val;

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	//Esto va en el controlador
	public void chkWin(int box1, int box2, int box3) {
		//GANAR CON LOS 3 IGUALES
		    	if (box1==box2 && box2==box3 && box1==box3) {
		    		int reply = JOptionPane.showConfirmDialog(null, "GANASTE!\n Queres aceptarlo?", "", JOptionPane.YES_NO_OPTION);
		    		income = income + crdtBet;
		    		if (reply == JOptionPane.YES_OPTION) {
			    		int wonAmnt = (box1*crdtBet)*10;
		//HAY RECAUDACION DISPONIBLE
			    		if (income>=wonAmnt) {
			    			income = income - wonAmnt;
				    		saldo = saldo+wonAmnt;
				    		crdtBet = 5;
		//NO HAY RECAUDACION DISPONIBLE
			    		}else {
			    			saldo = saldo + income;
		    				income = 0;
		    				crdtBet = 5;
			                System.exit(0);
			    		}

		    		}else {
		    			crdtBet = 0;

		    		}

		//GANAR CON 2 IGUALES
		    	} else if (box1==box2 || box2==box3 || box1==box3) {
		    		int reply2 = JOptionPane.showConfirmDialog(null, "GANASTE EL PREMIO CHICO!\n Queres aceptarlo?", "", JOptionPane.YES_NO_OPTION);
		    		income = income + crdtBet;
		    		if (reply2 == JOptionPane.YES_OPTION) {
		    			int wonAmnt;
		    			if (box1==box2 || box1==box3) {
		    				wonAmnt = (box1*crdtBet);
		    			}else {
		    				wonAmnt = (box2*crdtBet);
		    			}
		//HAY RECAUDACION DISPONIBLE
		    			if (income>=wonAmnt) {
			    			income = income - wonAmnt;
			        		saldo = saldo + wonAmnt;
			        		crdtBet = 5;

		//NO HAY RECAUDACION DISPONIBLE
		    			}else {
		    				saldo = saldo + income;
		    				income = 0;
		    				crdtBet = 5;

			                System.exit(0);
		    			}
		    		}else {

		    			crdtBet = 5;

		    		}

		//PERDER
		    	} else {

		    		income = income + crdtBet;
		    		crdtBet = 5;

		    	}
		    }
}
