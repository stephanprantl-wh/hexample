package at.willhaben.sp.hexample.domain.jobsearch

import at.willhaben.sp.hexample.domain.jobsearch.ports.JobSearchDatabasePort
import at.willhaben.sp.hexample.domain.jobsearch.ports.JobSearchServicePort
import at.willhaben.sp.hexample.domain.model.JobItem
import org.springframework.stereotype.Service

@Service
class JobSearchService(
    private val jobSearchDatabasePort: JobSearchDatabasePort
) : JobSearchServicePort {
    override fun searchForJobsWithTitle(title: String?): List<JobItem> {
        return jobSearchDatabasePort.searchForJobsWithTitle(title)
    }
}
