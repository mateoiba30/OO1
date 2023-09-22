package ar.edu.unlp.info.oo1.ejercicio10JobScheduler;

public class JobDescription {

	private double effort;

	private int priority;

	public JobDescription (double anEffort, int aPriority, String aDescription) {
		this.effort = anEffort;
		this.priority = aPriority;
	}

	public double getEffort() {
			return effort;
	}

	public int getPriority() {
		return priority;
	}
}
