package at.willhaben.sp.hexample.adapter.output.recommendation_engine;

import at.willhaben.sp.hexample.domain.recommendation.ports.JobRecommendationEnginePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class RecommendationEngineAdapter implements JobRecommendationEnginePort {

    @Override
    public List<Integer> getRecommendedJobIdsForUserId(Integer userId) {
        return IntStream.range(userId, userId + 3).boxed().collect(Collectors.toList());
    }

}
