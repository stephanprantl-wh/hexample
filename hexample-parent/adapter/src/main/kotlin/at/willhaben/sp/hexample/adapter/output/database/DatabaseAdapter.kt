package at.willhaben.sp.hexample.adapter.output.database

import at.willhaben.sp.hexample.domain.jobsearch.ports.JobSearchDatabasePort
import at.willhaben.sp.hexample.domain.model.JobOffer
import at.willhaben.sp.hexample.domain.recommendation.ports.JobRecommendationDatabasePort
import org.springframework.stereotype.Component
import java.util.stream.IntStream
import kotlin.streams.asSequence

@Component
class DatabaseAdapter : JobSearchDatabasePort, JobRecommendationDatabasePort {
    private val jobOffers = IntStream.range(1, 11)
        .asSequence()
        .map { JobOffer(title = "Job $it") }
        .toList()

    override fun searchForJobsWithTitle(title: String?): List<JobOffer> {
        return jobOffers.filter { title == null || it.title == title }.toList()
    }

    override fun getJobsForIdList(jobIds: List<Int>): List<JobOffer> {
        return jobIds.map { jobOffers[it] }
    }
}
