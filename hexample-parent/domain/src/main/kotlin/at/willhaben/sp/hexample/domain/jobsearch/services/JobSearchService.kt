package at.willhaben.sp.hexample.domain.jobsearch.services

import at.willhaben.sp.hexample.domain.jobsearch.ports.JobSearchDatabasePort
import at.willhaben.sp.hexample.domain.jobsearch.ports.JobSearchServicePort
import at.willhaben.sp.hexample.domain.model.JobOffer
import org.springframework.stereotype.Service

@Service
class JobSearchService(
    private val jobSearchDatabasePort: JobSearchDatabasePort
) : JobSearchServicePort {
    override fun searchForJobsWithTitle(title: String?): List<JobOffer> {
        return jobSearchDatabasePort.searchForJobsWithTitle(title)
    }
}
