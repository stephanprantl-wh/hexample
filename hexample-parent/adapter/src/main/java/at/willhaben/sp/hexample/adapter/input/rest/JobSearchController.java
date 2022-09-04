package at.willhaben.sp.hexample.adapter.input.rest;

import at.willhaben.sp.hexample.adapter.input.rest.model.JobResponseItem;
import at.willhaben.sp.hexample.adapter.input.rest.model.JobSearchResponse;
import at.willhaben.sp.hexample.domain.jobsearch.ports.JobSearchServicePort;
import at.willhaben.sp.hexample.domain.model.JobOffer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
public class JobSearchController {

    private final JobSearchServicePort jobSearchService;

    public JobSearchController(JobSearchServicePort jobSearchService) {
        this.jobSearchService = jobSearchService;
    }

    @GetMapping
    public JobSearchResponse search(@RequestParam(required = false) String title) {
        List<JobOffer> result = jobSearchService.searchForJobsWithTitle(title);
        return mapResult(result);
    }

    private JobSearchResponse mapResult(List<JobOffer> items) {
        List<JobResponseItem> responseItems = items.stream().map(
                        item -> {
                            JobResponseItem responseItem = new JobResponseItem();
                            responseItem.setTitle(item.getTitle());
                            return responseItem;
                        }
                )
                .collect(Collectors.toList());

        JobSearchResponse response = new JobSearchResponse();
        response.setItems(responseItems);
        return response;
    }
}
