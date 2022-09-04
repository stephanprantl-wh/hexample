package at.willhaben.sp.hexample.adapter.input.rest;

import at.willhaben.sp.hexample.adapter.input.rest.model.JobRecommendationResponse;
import at.willhaben.sp.hexample.adapter.input.rest.model.JobResponseItem;
import at.willhaben.sp.hexample.domain.model.JobOffer;
import at.willhaben.sp.hexample.domain.recommendation.ports.JobRecommendationServicePort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recommendation")
public class JobRecommendationController {

    private JobRecommendationServicePort jobRecommendationService;

    public JobRecommendationController(JobRecommendationServicePort jobRecommendationService) {
        this.jobRecommendationService = jobRecommendationService;
    }

    @GetMapping
    public JobRecommendationResponse getRecommendationsForUser(@RequestParam Integer userId) {
        List<JobOffer> result = jobRecommendationService.getRecommendationsForUser(userId);
        return mapResult(result);
    }

    private JobRecommendationResponse mapResult(List<JobOffer> items) {
        List<JobResponseItem> responseItems = items.stream().map(
                        item -> {
                            JobResponseItem responseItem = new JobResponseItem();
                            responseItem.setTitle(item.getTitle());
                            return responseItem;
                        }
                )
                .collect(Collectors.toList());

        JobRecommendationResponse response = new JobRecommendationResponse();
        response.setItems(responseItems);
        return response;
    }
}
