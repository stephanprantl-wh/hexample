package at.willhaben.sp.hexample.domain.jobsearch.ports;

import at.willhaben.sp.hexample.domain.model.JobOffer;

import java.util.List;

public interface JobSearchServicePort {

    List<JobOffer> searchForJobsWithTitle(String title);

}
