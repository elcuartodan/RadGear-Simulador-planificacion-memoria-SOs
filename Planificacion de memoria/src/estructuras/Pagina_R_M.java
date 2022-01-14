package estructuras;

public class Pagina_R_M extends Pagina {
	private String valor;
	private boolean ref;
	private boolean mod;
	
	public Pagina_R_M() {
	}
	
	public Pagina_R_M(String valor) {
		this.valor = valor;
	}
	
	public Pagina_R_M(String valor, boolean ref) {
		this.valor = valor;
		this.ref = ref;
	}
	
	public Pagina_R_M(String valor, boolean ref, boolean mod) {
		this.valor = valor;
		this.ref = ref;
		this.mod = mod;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public boolean isRef() {
		return ref;
	}

	public void setRef(boolean ref) {
		this.ref = ref;
	}
	
	public boolean isMod() {
		return mod;
	}

	public void setMod(boolean mod) {
		this.mod = mod;
	}
	
	public String toString() {
		String tmp = "";
		if (this.isMod())
			tmp += "M";
		tmp += this.getValor();
		if(this.isRef()) {
			tmp += "*";
		}
		return tmp;
	}
}
