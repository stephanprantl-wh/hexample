package at.willhaben.sp.hexample.adapter.output.recommendation_engine

import at.willhaben.sp.hexample.domain.recommendation.ports.JobRecommendationEnginePort
import org.springframework.stereotype.Repository
import java.util.stream.IntStream
import kotlin.streams.toList

@Repository
class RecommendationEngineAdapter : JobRecommendationEnginePort {
    override fun getRecommendedJobIdsForUserId(userId: Int): List<Int> {
        return IntStream.range(userId, userId + 3).toList()
    }

}
