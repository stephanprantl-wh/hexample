package at.willhaben.sp.hexample.adapter.output.database

import at.willhaben.sp.hexample.domain.jobsearch.ports.JobSearchDatabasePort
import at.willhaben.sp.hexample.domain.model.JobItem
import at.willhaben.sp.hexample.domain.recommendation.ports.JobRecommendationDatabasePort
import org.springframework.stereotype.Repository
import java.util.stream.IntStream
import kotlin.streams.asSequence

@Repository
class DatabaseAdapter : JobSearchDatabasePort, JobRecommendationDatabasePort {
    private val jobItems = IntStream.range(1, 11)
        .asSequence()
        .map { JobItem(title = "Job $it") }
        .toList()

    override fun searchForJobsWithTitle(title: String?): List<JobItem> {
        return jobItems.filter { title == null || it.title == title }.toList()
    }

    override fun getJobsForIdList(jobIds: List<Int>): List<JobItem> {
        return jobIds.map { jobItems[it] }
    }
}
