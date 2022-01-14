package algoritmos;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JProgressBar;

import recorridos.SegChanceSinDA;
import recorridos.GenerarSalida;
import recorridos.SegChanceConDA;
import estructuras.Pagina_R_M;

public class SegChance implements Runnable {
	private String[] lote;
	private int marcos;
	private boolean async;
	private ArrayList<String> proce;
	private ArrayList<ArrayList<Pagina_R_M>> res;
	private ArrayList<String> pf;
	private JProgressBar barra;
	private JButton btnIniciar;

	public SegChance(String [] lote, int marcos, boolean async, ArrayList<String> proce, JProgressBar barra, JButton btnIniciar) {
		this.lote = lote;
		this.marcos = marcos - 1;
		this.async = async;
		this.proce = proce;
		this.barra = barra;
		this.btnIniciar = btnIniciar;
	}

	public void run() {
		ArrayList<Pagina_R_M> ult = new ArrayList<Pagina_R_M>();
		ArrayList<Pagina_R_M> ord = new ArrayList<Pagina_R_M>();
		this.res = new ArrayList<ArrayList<Pagina_R_M>>();
		this.pf = new ArrayList<String>();
		Pagina_R_M pag;
		for (int j = 0; j < this.marcos; j++) {
			res.add(new ArrayList<Pagina_R_M>());
			pag = new Pagina_R_M("-");
			ult.add(pag);
			ord.add(pag);
		}
		this.marcos++;
		res.add(new ArrayList<Pagina_R_M>());
		if (async) {
			pag = new Pagina_R_M("DA");
			ult.add(pag);
			ord.add(pag);
		} else {
			pag = new Pagina_R_M("-");
			ult.add(pag);
			ord.add(pag);
		}
		int cantPF;
		if (async) 
			cantPF = new SegChanceConDA(this.proce, this.marcos, this.lote, this.res, this.barra).recorrer(ult, ord, pf);
		else
			cantPF = new SegChanceSinDA(this.proce, this.marcos, this.lote, this.res, this.barra).recorrer(ult, ord, pf);
		GenerarSalida<Pagina_R_M> salida = new GenerarSalida<Pagina_R_M>(this.lote, this.res, this.pf, this.barra);
		salida.generar(cantPF,"SegChance");
		this.btnIniciar.setEnabled(true);
	}
}
