package ar.edu.unlp.info.oo1.ejercicio10JobScheduler;


public class HighestPriority extends JobScheduler{
	
	protected JobDescription getElemento() {
		return this.jobs.stream().max((a, b) -> Double.compare(a.getPriority(), b.getPriority())).orElseGet(null);
	}

}