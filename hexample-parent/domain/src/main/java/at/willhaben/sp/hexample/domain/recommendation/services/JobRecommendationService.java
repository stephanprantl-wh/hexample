package at.willhaben.sp.hexample.domain.recommendation.services;

import at.willhaben.sp.hexample.domain.model.JobOffer;
import at.willhaben.sp.hexample.domain.recommendation.ports.JobRecommendationDatabasePort;
import at.willhaben.sp.hexample.domain.recommendation.ports.JobRecommendationEnginePort;
import at.willhaben.sp.hexample.domain.recommendation.ports.JobRecommendationServicePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobRecommendationService implements JobRecommendationServicePort {

    private JobRecommendationEnginePort jobRecommendationEngine;
    private JobRecommendationDatabasePort jobRecommendationDatabase;

    public JobRecommendationService(JobRecommendationEnginePort jobRecommendationEngine, JobRecommendationDatabasePort jobRecommendationDatabase) {
        this.jobRecommendationEngine = jobRecommendationEngine;
        this.jobRecommendationDatabase = jobRecommendationDatabase;
    }

    public List<JobOffer> getRecommendationsForUser(Integer userId) {
        List<Integer> recommendedJobsForUser = jobRecommendationEngine.getRecommendedJobIdsForUserId(userId);
        return jobRecommendationDatabase.getJobsForIdList(recommendedJobsForUser);
    }
}
