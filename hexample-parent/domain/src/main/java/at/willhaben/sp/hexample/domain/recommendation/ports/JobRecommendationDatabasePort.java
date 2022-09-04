package at.willhaben.sp.hexample.domain.recommendation.ports;

import at.willhaben.sp.hexample.domain.model.JobOffer;

import java.util.List;

public interface JobRecommendationDatabasePort {

    List<JobOffer> getJobsForIdList(List<Integer> jobIds);

}
