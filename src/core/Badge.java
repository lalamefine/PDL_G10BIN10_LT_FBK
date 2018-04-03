package core;

public class Badge {
	
	public Badge(int id, int proprietaireId, int bloque) {
		this.id = id;
		this.proprietaireId = proprietaireId;
		this.bloque = bloque;
	}
	public Badge() {}
	
	
	private int id;
	private int proprietaireId;
	private int bloque;
	
	public int getBloque() {
		return bloque;
	}
	public void setBloque(int bloque) {
		this.bloque = bloque;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProprietaireId() {
		return proprietaireId;
	}
	public void setProprietaireId(int proprietaireId) {
		this.proprietaireId = proprietaireId;
	}

}
