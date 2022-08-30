package at.willhaben.sp.hexample.domain.recommendation

import at.willhaben.sp.hexample.domain.model.JobItem
import at.willhaben.sp.hexample.domain.recommendation.ports.JobRecommendationDatabasePort
import at.willhaben.sp.hexample.domain.recommendation.ports.JobRecommendationEnginePort
import at.willhaben.sp.hexample.domain.recommendation.ports.JobRecommendationServicePort
import org.springframework.stereotype.Service

@Service
class JobRecommendationService(
    private val jobRecommendationEngine: JobRecommendationEnginePort,
    private val jobRecommendationDatabase: JobRecommendationDatabasePort
) : JobRecommendationServicePort {

    override fun getRecommendationsForUser(userId: Int): List<JobItem> {
        val recommendedJobsForUser = jobRecommendationEngine.getJobIdsForUserId(userId)
        return jobRecommendationDatabase.getJobsForIdList(recommendedJobsForUser)
    }

}
