package algoritmos;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JProgressBar;

import recorridos.FIFOConDA;
import recorridos.FIFOSinDA;
import recorridos.GenerarSalida;
import recorridos.LRUConDA;
import recorridos.LRUSinDA;
import estructuras.Pagina_M;

import java.awt.Toolkit;

public class FIFOyLRU implements Runnable {
	private String[] lote;
	private int marcos;
	private boolean async;
	private ArrayList<String> proce;
	private ArrayList<ArrayList<Pagina_M>> res;
	private ArrayList<String> pf;
	private JProgressBar barra;
	private String alg;
	private JButton btnIniciar;

	public FIFOyLRU(String [] lote, int marcos, boolean async, ArrayList<String> proce, JProgressBar barra, String alg, JButton btnIniciar) {
		this.lote = lote;
		this.marcos = marcos - 1;
		this.async = async;
		this.proce = proce;
		this.barra = barra;
		this.alg = alg;
		this.btnIniciar = btnIniciar;
	}

	public void run() {
		ArrayList<Pagina_M> ult = new ArrayList<Pagina_M>();
		ArrayList<Pagina_M> ord = new ArrayList<Pagina_M>();
		this.res = new ArrayList<ArrayList<Pagina_M>>();
		this.pf = new ArrayList<String>();
		Pagina_M pag;
		for (int j = 0; j < this.marcos; j++) {
			res.add(new ArrayList<Pagina_M>());
			pag = new Pagina_M("-");
			ult.add(pag);
			ord.add(pag);
		}
		this.marcos++;
		res.add(new ArrayList<Pagina_M>());
		if (async) {
			pag = new Pagina_M("DA");
			ult.add(pag);
			ord.add(pag);
		} else {
			pag = new Pagina_M("-");
			ult.add(pag);
			ord.add(pag);
		}
		int cantPF;
		if (async) {
			if (this.alg.equals("FIFO"))
				cantPF = new FIFOConDA(this.proce, this.marcos, this.lote, this.res, this.barra).recorrer(ult, ord, pf);
			else
				cantPF = new LRUConDA(this.proce, this.marcos, this.lote, this.res, this.barra).recorrer(ult, ord, pf);
		}
		else {
			if (this.alg.equals("FIFO"))
				cantPF = new FIFOSinDA(this.proce, this.marcos, this.lote, this.res, this.barra).recorrer(ult, ord, pf);
			else
				cantPF = new LRUSinDA(this.proce, this.marcos, this.lote, this.res, this.barra).recorrer(ult, ord, pf);
		}
		GenerarSalida<Pagina_M> salida = new GenerarSalida<Pagina_M>(this.lote, this.res, this.pf, this.barra);
		salida.generar(cantPF,this.alg);
		this.btnIniciar.setEnabled(true);
		Toolkit.getDefaultToolkit().beep();
	}
}
