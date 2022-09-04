package at.willhaben.sp.hexample.domain.jobsearch.ports;

import at.willhaben.sp.hexample.domain.model.JobOffer;

import java.util.List;

public interface JobSearchDatabasePort {

    List<JobOffer> searchForJobsWithTitle(String title);

}
