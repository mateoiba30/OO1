package ar.edu.unlp.info.oo1.ejercicio10JobScheduler;

import java.util.ArrayList;
import java.util.List;

public abstract class JobScheduler {
    protected List<JobDescription> jobs; //lista de trabajos pendientes

    public JobScheduler () {
        this.jobs = new ArrayList<>();
    }

    public void schedule(JobDescription job) {
        this.jobs.add(job);
    }

    public void unschedule(JobDescription job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public List<JobDescription> getJobs(){
        return jobs;
    }
    
    abstract protected JobDescription getElemento();

    public JobDescription next() {
        JobDescription nextJob = this.getElemento();
        if (nextJob !=null) {
            this.unschedule(nextJob);
            return nextJob;      	
        }
        else
        	return null;
    }

}
