package ar.edu.unlp.info.oo1.ejercicio10JobScheduler;


public class Lifo extends JobScheduler{
	
	protected JobDescription getElemento() {
		if(this.jobs != null)
			return this.jobs.get(jobs.size()-1);
		else
			return null;
	}

}