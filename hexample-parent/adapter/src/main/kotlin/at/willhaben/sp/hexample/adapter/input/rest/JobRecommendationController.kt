package at.willhaben.sp.hexample.adapter.input.rest

import at.willhaben.sp.hexample.domain.model.JobItem
import at.willhaben.sp.hexample.domain.recommendation.ports.JobRecommendationServicePort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/recommendation")
class JobRecommendationController(
    private val jobRecommendationService: JobRecommendationServicePort
) {

    @GetMapping
    fun getRecommendationsForUser(@RequestParam userId: Int): JobRecommendationResponse {
        val result = jobRecommendationService.getRecommendationsForUser(userId)
        return mapResult(result)
    }

    private fun mapResult(result: List<JobItem>): JobRecommendationResponse {
        val resultItems = result.map {
            JobResponseItem(
                title = it.title
            )
        }
        return JobRecommendationResponse(items = resultItems)
    }

}

data class JobRecommendationResponse(
    val items: List<JobResponseItem> = emptyList()
)
