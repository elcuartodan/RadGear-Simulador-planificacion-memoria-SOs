package recorridos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JProgressBar;

import estructuras.Pagina;

public class GenerarSalida<T extends Pagina> {
	private String[] lote;
	private ArrayList<ArrayList<T>> res;
	private ArrayList<String> pf;
	private JProgressBar barra;
	
	public GenerarSalida(String[] lote, ArrayList<ArrayList<T>> res, ArrayList<String> pf, JProgressBar barra) {
		this.lote = lote;
		this.res = res;
		this.pf = pf;
		this.barra = barra;
	}
	
	public void generar(int cantPF, String alg) {
		File dir = new File(System.getProperty("user.dir"), "SalidaSPM");
		dir.mkdir();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("_dd_MM_yyyy_HH_mm_ss");
		File arch = new File(dir.getAbsolutePath() + System.getProperty("file.separator") + "DGantt" + alg + dtf.format(LocalDateTime.now()) + ".txt");
		try {
			arch.createNewFile();
			try {
				PrintWriter writer = new PrintWriter(new FileWriter(arch.getAbsolutePath(), false));
				int i = 0;
				// Primera linea
				writer.printf("%s", "M/P" + "\t");
				int dimLote = lote.length - 1; // Evita agregar caracteres \t extra
				for (int j = 0; j < dimLote; j++)
					writer.printf("%s", lote[j] + "\t");
				writer.printf("%s", lote[dimLote]);
				writer.printf("%n" + "%n");
				this.barra.setValue(70);
				// Lineas de valores
				int dimRes = res.size();
				for (int j = 0; j < dimRes; j++) {
					ArrayList<T> ar = res.get(j);
					int dimAr = ar.size() - 1; // Evita agregar caracteres \t extra
					writer.printf("%s", i + "\t");
					i++;
					for (int k = 0; k < dimAr; k++) {
						Pagina p = ar.get(k);
						if (!p.getValor().equals("-"))
							writer.printf("%s", p + "\t");
						else
							writer.printf("%s", " \t");
					}
					Pagina p = ar.get(dimAr);
					if (!p.getValor().equals("-"))
						writer.printf("%s", p);
					else
						writer.printf("%s", " ");
					writer.printf("%n" + "%n");
				}
				this.barra.setValue(90);
				// Linea de PF
				int dimPf = pf.size() - 1; // Evita agregar caracteres \t extra
				writer.printf("%s", "PF?" + "\t");
				for (int k = 0; k < dimPf; k++) {
					String s = pf.get(k);
					writer.printf("%s", s + "\t");
				}
				String s = pf.get(dimPf);
				writer.printf("%s", s);
				writer.printf("%n" + "%n");
				
				writer.printf("%s", "PF = " + cantPF);
				writer.close();
				this.barra.setValue(100);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
