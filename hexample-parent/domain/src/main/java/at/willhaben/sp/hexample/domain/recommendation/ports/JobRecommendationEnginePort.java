package at.willhaben.sp.hexample.domain.recommendation.ports;

import at.willhaben.sp.hexample.domain.model.JobOffer;

import java.util.List;

public interface JobRecommendationEnginePort {

    List<Integer> getRecommendedJobIdsForUserId(Integer userId);

}
