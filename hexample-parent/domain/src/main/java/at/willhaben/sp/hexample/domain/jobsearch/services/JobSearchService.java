package at.willhaben.sp.hexample.domain.jobsearch.services;

import at.willhaben.sp.hexample.domain.jobsearch.ports.JobSearchDatabasePort;
import at.willhaben.sp.hexample.domain.jobsearch.ports.JobSearchServicePort;
import at.willhaben.sp.hexample.domain.model.JobOffer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSearchService implements JobSearchServicePort {

    private JobSearchDatabasePort jobSearchDatabase;

    public JobSearchService(JobSearchDatabasePort jobSearchDatabase) {
        this.jobSearchDatabase = jobSearchDatabase;
    }

    @Override
    public List<JobOffer> searchForJobsWithTitle(String title) {
        return jobSearchDatabase.searchForJobsWithTitle(title);
    }

}
