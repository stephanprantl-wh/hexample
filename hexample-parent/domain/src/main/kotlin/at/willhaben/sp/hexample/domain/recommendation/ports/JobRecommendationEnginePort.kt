package at.willhaben.sp.hexample.domain.recommendation.ports

interface JobRecommendationEnginePort {
    fun getRecommendedJobIdsForUserId(userId: Int): List<Int>
}
