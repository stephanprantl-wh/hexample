package at.willhaben.sp.hexample.domain.recommendation.ports

interface JobRecommendationEnginePort {
    fun getJobIdsForUserId(userId: Int): List<Int>
}
