package estructuras;

public abstract class Pagina {

	public abstract String getValor();

	public abstract void setValor(String valor);

	public abstract boolean isRef();

	public abstract void setRef(boolean ref);
	
	public abstract boolean isMod();

	public abstract void setMod(boolean mod);
	
	public abstract String toString();
}
