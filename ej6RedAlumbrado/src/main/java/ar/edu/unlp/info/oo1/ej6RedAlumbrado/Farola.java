package ar.edu.unlp.info.oo1.ej6RedAlumbrado;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	
	private List<Farola> neighbors;
	private boolean on;
	
	public Farola() {
		this.neighbors = new ArrayList<Farola>();
		this.on=false;
	}
	
	public void pairWithNeighbor( Farola farola ) {//los errores de overflow de suelen deber a bucles que no terminan
		if (!this.neighbors.contains(farola)) {
			this.neighbors.add(farola);
//		if (!farola.getNeighbors().contains(farola))//en cada lista de vecinas chequear que no se encuentre la farola, sinó this agrega la farolanueva, la farolanueva agrega this, entonces this agrega la farola ... = overflow
			//no hacer otro if porque esto me genera otro overflow al
			farola.pairWithNeighbor(this);//this es el objeto "actual"
		}
	}

	public List<Farola> getNeighbors() {
		return new ArrayList<>(neighbors);//paso como copia para que la manipulen
	}

	public void setnNeighbors(List<Farola> neighbors) { //idem arriba :)
		this.neighbors = neighbors;
	}

	public boolean isOn() {
		return on;
	}

	public void turnOn() {
		if(!this.on) {//solo recorro la lista en el caso de ser necesario
			this.on=true;
			for (Farola f : this.neighbors)
				f.turnOn();	
			//this.neighbors.stream().forEach(Farola::turnOn);
			//this.neighbors.stream().forEach(farola -> farola.turnOn());
		}	
	}
	
	public void turnOff() {
		if(this.on) {
			this.on=false;
			for (Farola f : this.neighbors)//recorro todos los elementos
				f.turnOff();	
		}	
	}
	
	

}
