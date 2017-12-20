package experian.rabbit.fila;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Elemento.class)
public class Elemento {
	
	private String numSerie;
	private String id;
	
	
	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String nome) {
		this.numSerie = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Elementos [Numero Serie=" + numSerie + ", Id=" + id + "]";
	}


}
