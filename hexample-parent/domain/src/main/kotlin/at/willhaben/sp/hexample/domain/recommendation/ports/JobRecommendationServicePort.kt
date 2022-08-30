package at.willhaben.sp.hexample.domain.recommendation.ports

import at.willhaben.sp.hexample.domain.model.JobItem

interface JobRecommendationServicePort {
    fun getRecommendationsForUser(userId: Int): List<JobItem>
}