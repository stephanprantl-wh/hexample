package at.willhaben.sp.hexample.domain.jobsearch.ports

import at.willhaben.sp.hexample.domain.jobsearch.JobItem

interface JobSearchServicePort {
    fun searchForJobsWithTitle(title: String?): List<JobItem>
}