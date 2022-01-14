package recorridos;

import java.util.ArrayList;

import javax.swing.JProgressBar;

import estructuras.Pagina_R_M;

public class SegChanceSinDA {
	private ArrayList<String> proce;
	private int marcos;
	private String[] lote;
	private ArrayList<ArrayList<Pagina_R_M>> res;
	private JProgressBar barra;
	
	public SegChanceSinDA(ArrayList<String> proce, int marcos, String[] lote, ArrayList<ArrayList<Pagina_R_M>> res, JProgressBar barra) {
		this.proce = proce;
		this.marcos = marcos;
		this.lote = lote;
		this.res = res;
		this.barra = barra;
	}
	
	public int recorrer(ArrayList<Pagina_R_M> ult, ArrayList<Pagina_R_M> ord, ArrayList<String> pf) {
		int cantPF = 0, tmp = lote.length;
		int[] k = { 0 };
		int[] l = { 0 };
		boolean[] comienzo = { true };
		if (this.proce == null) {
			int mitad = tmp * 2;
			for (int i = 0; i < tmp; i++) {
				cantPF += recorrerNoAsync(i, k, ult, ord, pf, comienzo, l);
				this.barra.setValue(i / mitad);
			}
		} else {
			int ini = 0;
			this.barra.setIndeterminate(true);
			while (!proce.isEmpty()) {
				String s = proce.get(0);
				ArrayList<String> temp = new ArrayList<String>();
				int aux = s.length(), ind = Integer.parseInt(s.substring(0, aux - 1));
				for (int i = ini; i < ind; i++)
					cantPF += recorrerNoAsync(i, k, ult, ord, pf, comienzo, l);
				l[0] = 0;
				while (!proce.isEmpty() && proce.get(0).contains(Integer.toString(ind))) {
					temp.add(proce.get(0).substring(aux - 1, aux));
					proce.remove(0);
				}
				if (!proce.isEmpty()) {
					for (Pagina_R_M p : ult) {
						for (String pro : temp) {
							if (p.getValor().contains(pro)) {
								p.setValor("-");
								break;
							}
						}
					}
				}
				ini = ind;
				comienzo[0] = true;
			}
			this.barra.setIndeterminate(false);
			this.barra.setValue(50);
		}
		return cantPF;
	}
	
	private int recorrerNoAsync(int i, int[] k, ArrayList<Pagina_R_M> ult, ArrayList<Pagina_R_M> ord, ArrayList<String> pf, boolean[] comienzo,
			int[] l) {
		int cantPF = 0;
		String valor = lote[i];
		boolean existe = false;
		if (k[0] == this.marcos)
			k[0] = 0;
		if (!comienzo[0]) {
			if (!ult.get(k[0]).equals(ord.get(0))) {
				k[0] = ult.indexOf(ord.get(0));
			}
		}
		for (Pagina_R_M p : ult) {
			if (p.getValor().equals(valor)) {
				pf.add(" ");
				p.setRef(true);
				existe = true;
				break;
			}
		}
		if (!existe) {
			pf.add("X");
			cantPF++;
			if (comienzo[0]) {
				boolean sig = true;
				while (sig && l[0] < this.marcos) {
					Pagina_R_M pag = ult.get(l[0]);
					if (pag.getValor().equals("-")) {
						ult.remove(l[0]);
						ord.remove(pag);
						pag = new Pagina_R_M(valor);
						ult.add(l[0], pag);
						ord.add(pag);
						sig = false;
					}
					l[0]++;
				}
				if (l[0] < this.marcos) {
					comienzo[0] = false;
					while (l[0] < this.marcos) {
						if (ult.get(l[0]).getValor().equals("-")) {
							comienzo[0] = true;
							break;
						}
						l[0]++;
					}
				} else {
					comienzo[0] = false;
				}
			} else {
				boolean ok = false;
				while (!ok) {
					Pagina_R_M candidato = ord.get(0);
					if (candidato.isRef()) {
						candidato.setRef(false);
						ord.remove(0);
						ord.add(candidato);
					} else {
						k[0] = ult.indexOf(ord.get(0));
						ult.remove(k[0]);
						ord.remove(0);
						Pagina_R_M pag = new Pagina_R_M(valor);
						ult.add(k[0], pag);
						ord.add(pag);
						ok = true;
					}
					k[0]++;
					if (k[0] == this.marcos && !ok)
						k[0] = 0;
				}
			}
		}
		for (int j = 0; j < this.marcos; j++)
			res.get(j).add(new Pagina_R_M(ult.get(j).getValor(), ult.get(j).isRef()));
		i++;
		return cantPF;
	}
}
