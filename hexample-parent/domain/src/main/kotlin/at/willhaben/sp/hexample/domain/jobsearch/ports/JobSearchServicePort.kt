package at.willhaben.sp.hexample.domain.jobsearch.ports

import at.willhaben.sp.hexample.domain.model.JobOffer

interface JobSearchServicePort {
    fun searchForJobsWithTitle(title: String?): List<JobOffer>
}