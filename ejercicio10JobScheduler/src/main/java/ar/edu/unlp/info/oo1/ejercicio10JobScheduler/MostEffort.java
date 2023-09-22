package ar.edu.unlp.info.oo1.ejercicio10JobScheduler;


public class MostEffort extends JobScheduler{
	
	protected JobDescription getElemento() {
		return this.jobs.stream().max((a, b) -> Double.compare(a.getEffort(), b.getEffort())).orElseGet(null);//el orElse me salva del optional y de usar el if
	}

}