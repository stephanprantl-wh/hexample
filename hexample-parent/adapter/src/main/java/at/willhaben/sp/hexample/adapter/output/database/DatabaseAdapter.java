package at.willhaben.sp.hexample.adapter.output.database;

import at.willhaben.sp.hexample.domain.jobsearch.ports.JobSearchDatabasePort;
import at.willhaben.sp.hexample.domain.model.JobOffer;
import at.willhaben.sp.hexample.domain.recommendation.ports.JobRecommendationDatabasePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class DatabaseAdapter implements JobSearchDatabasePort, JobRecommendationDatabasePort {

    private static List<JobOffer> jobOffersList;

    static {
        jobOffersList = IntStream.range(1, 11)
                .mapToObj(index -> {
                    JobOffer jobOffer = new JobOffer();
                    jobOffer.setTitle("Job " + index);
                    return jobOffer;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<JobOffer> searchForJobsWithTitle(String title) {
        return jobOffersList.stream()
                .filter(item -> title == null || title.equals(item.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public List<JobOffer> getJobsForIdList(List<Integer> jobIds) {
        return jobIds.stream()
                .map(id -> jobOffersList.get(id))
                .collect(Collectors.toList());
    }

}
