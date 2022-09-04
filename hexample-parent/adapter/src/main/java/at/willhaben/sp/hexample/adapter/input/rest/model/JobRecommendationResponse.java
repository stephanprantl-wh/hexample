package at.willhaben.sp.hexample.adapter.input.rest.model;

import java.util.List;

public class JobRecommendationResponse {
    private List<JobResponseItem> items;

    public List<JobResponseItem> getItems() {
        return items;
    }

    public void setItems(List<JobResponseItem> items) {
        this.items = items;
    }
}
