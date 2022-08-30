package at.willhaben.sp.hexample.adapter.input.rest

import at.willhaben.sp.hexample.domain.jobsearch.JobItem
import at.willhaben.sp.hexample.domain.jobsearch.ports.JobSearchServicePort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/search")
class JobSearchController(
    private val jobSearchService: JobSearchServicePort
) {

    @GetMapping
    fun search(@RequestParam title: String? = null): JobSearchResponse {
        val result = jobSearchService.searchForJobsWithTitle(title)
        return mapResult(result)
    }

    private fun mapResult(result: List<JobItem>): JobSearchResponse {
        val resultItems = result.map {
            JobResponseItem(
                title = it.title
            )
        }
        return JobSearchResponse(items = resultItems)
    }

}

data class JobSearchResponse(
    val items: List<JobResponseItem> = emptyList()
)

data class JobResponseItem(
    val title: String
)
