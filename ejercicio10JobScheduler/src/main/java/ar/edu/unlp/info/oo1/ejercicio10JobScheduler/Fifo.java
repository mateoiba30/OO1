package ar.edu.unlp.info.oo1.ejercicio10JobScheduler;

public class Fifo extends JobScheduler{

	protected JobDescription getElemento() {
		if(this.jobs != null)
			return this.jobs.get(0);
		else
			return null;
	}

}
