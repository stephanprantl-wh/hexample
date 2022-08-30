package at.willhaben.sp.hexample.adapter.output.database

import at.willhaben.sp.hexample.domain.jobsearch.JobItem
import at.willhaben.sp.hexample.domain.jobsearch.ports.JobSearchDatabasePort
import org.springframework.stereotype.Repository
import java.util.stream.IntStream
import kotlin.streams.asSequence

@Repository
class JobSearchDatabaseRepository : JobSearchDatabasePort {
    private val jobItems = IntStream.range(1, 10)
        .asSequence()
        .map { JobItem(title = "Job $it") }
        .toList()

    override fun searchForJobsWithTitle(title: String?): List<JobItem> {
        return jobItems.filter { title == null || it.title == title }.toList()
    }
}
