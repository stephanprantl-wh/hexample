package at.willhaben.sp.hexample.domain.model;

import java.time.LocalDate;

public class JobOffer {

    private String title;
    private LocalDate publishingDate;

    /**
     * A non-anemic domain model allows you to have certain inner business definitions
     * along the objects
     */
    public Boolean isABrandNewJob() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        return publishingDate != null && publishingDate.isAfter(yesterday);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

}
