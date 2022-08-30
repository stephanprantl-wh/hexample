package at.willhaben.sp.hexample.domain.jobsearch.ports

import at.willhaben.sp.hexample.domain.model.JobItem

interface JobSearchServicePort {
    fun searchForJobsWithTitle(title: String?): List<JobItem>
}