package at.willhaben.sp.hexample.domain.recommendation.ports

import at.willhaben.sp.hexample.domain.model.JobItem

interface JobRecommendationDatabasePort {
    fun getJobsForIdList(jobIds: List<Int>): List<JobItem>
}