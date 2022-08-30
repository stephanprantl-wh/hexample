package at.willhaben.sp.hexample.domain.recommendation.ports

import at.willhaben.sp.hexample.domain.model.JobOffer

interface JobRecommendationServicePort {
    fun getRecommendationsForUser(userId: Int): List<JobOffer>
}