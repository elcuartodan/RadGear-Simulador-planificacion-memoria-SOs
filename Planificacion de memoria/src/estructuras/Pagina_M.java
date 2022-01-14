package estructuras;

public class Pagina_M extends Pagina {
	private String valor;
	private boolean mod;
	
	public Pagina_M() {
	}
	
	public Pagina_M(String valor) {
		this.valor = valor;
	}
	
	public Pagina_M(String valor, boolean mod) {
		this.valor = valor;
		this.mod = mod;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
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
		return tmp;
	}

	@Override
	public boolean isRef() {
		return false;
	}

	@Override
	public void setRef(boolean ref) {
	}
}
