package at.willhaben.sp.hexample.domain.jobsearch.ports

import at.willhaben.sp.hexample.domain.jobsearch.JobItem

interface JobSearchDatabasePort {
    fun searchForJobsWithTitle(title: String?): List<JobItem>
}
