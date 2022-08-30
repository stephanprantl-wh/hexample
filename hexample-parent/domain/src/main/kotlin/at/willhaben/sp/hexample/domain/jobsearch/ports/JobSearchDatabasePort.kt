package at.willhaben.sp.hexample.domain.jobsearch.ports

import at.willhaben.sp.hexample.domain.model.JobItem

interface JobSearchDatabasePort {
    fun searchForJobsWithTitle(title: String?): List<JobItem>
}
