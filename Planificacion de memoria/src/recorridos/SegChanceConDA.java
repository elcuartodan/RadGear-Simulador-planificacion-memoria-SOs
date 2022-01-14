package recorridos;

import java.util.ArrayList;

import javax.swing.JProgressBar;

import estructuras.Pagina_R_M;

public class SegChanceConDA {
	private ArrayList<String> proce;
	private int marcos;
	private String[] lote;
	private ArrayList<ArrayList<Pagina_R_M>> res;
	private JProgressBar barra;
	
	public SegChanceConDA(ArrayList<String> proce, int marcos, String[] lote, ArrayList<ArrayList<Pagina_R_M>> res, JProgressBar barra) {
		this.proce = proce;
		this.marcos = marcos;
		this.lote = lote;
		this.res = res;
		this.barra = barra;
	}
	
	public int recorrer(ArrayList<Pagina_R_M> ult, ArrayList<Pagina_R_M> ord, ArrayList<String> pf) {
		int[] da = { this.marcos - 1 };
		int[] k = { 0 };
		int[] l = { 0 };
		int cantPF = 0, tmp = lote.length;
		boolean[] comienzo = { true };
		if (this.proce == null) {
			int mitad = tmp * 2;
			for (int i = 0; i < tmp; i++) {
				cantPF += recorrerAsync(i, k, l, ult, ord, pf, comienzo, da);
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
					cantPF += recorrerAsync(i, k, l, ult, ord, pf, comienzo, da);
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

	private int recorrerAsync(int i, int[] k, int[] l, ArrayList<Pagina_R_M> ult, ArrayList<Pagina_R_M> ord, ArrayList<String> pf, boolean[] comienzo,
			int[] da) {
		int cantPF = 0;
		String valor = lote[i];
		boolean existe = false;
		boolean mod = valor.contains("M");
		if (mod)
			valor = valor.replace("M", "");
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
				if (mod)
					p.setMod(true);
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
						if(mod)
							pag = new Pagina_R_M(valor,false,true);
						else
							pag = new Pagina_R_M(valor);
						ult.add(l[0], pag);
						ord.add(pag);
						sig = false;
					}
					l[0]++;
				}
				if (l[0] < this.marcos) {
					if (ult.get(l[0]).getValor().equals("DA")) {
						l[0]++;
					}
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
						if (candidato.isMod()) {
							ult.remove(da[0]);
							ord.remove(0);
							Pagina_R_M pag;
							if(mod)
								pag = new Pagina_R_M(valor,false,true);
							else
								pag = new Pagina_R_M(valor);
							ult.add(da[0], pag);
							ord.add(pag);
							da[0] = k[0];
							candidato.setValor("DA");
							candidato.setRef(false);
							candidato.setMod(false);
							ok = true;
						} else {
							if (!candidato.getValor().equals("DA")) {
								k[0] = ult.indexOf(ord.get(0));
								ult.remove(k[0]);
								ord.remove(0);
								Pagina_R_M pag;
								if (mod)
									pag = new Pagina_R_M(valor,false,true);
								else
									pag = new Pagina_R_M(valor);
								ult.add(k[0], pag);
								ord.add(pag);
								ok = true;
							}
						}
					}
					if (ord.get(0).getValor().equals("DA"))
						ord.remove(0);
					else
						k[0]++;
					if (k[0] == da[0]) {
						k[0]++;
					}
					if (k[0] == this.marcos && !ok) {
						if (da[0] == 0)
							k[0] = 1;
						else
							k[0] = 0;
					}
				}
			}
		}
		for (int j = 0; j < this.marcos; j++) {
			Pagina_R_M p = ult.get(j);
			res.get(j).add(new Pagina_R_M(p.getValor(), p.isRef(), p.isMod()));
		}
		i++;
		return cantPF;
	}
}
