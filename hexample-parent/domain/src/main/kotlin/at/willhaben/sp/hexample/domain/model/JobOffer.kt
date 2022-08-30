package at.willhaben.sp.hexample.domain.model

import java.time.LocalDate

data class JobOffer(
    val title: String,
    val publishingDate: LocalDate? = null
) {
    /**
     * A non-anemic domain model allows you to have certain inner business definitions
     * along the objects
     */
    fun isABrandNewJob(): Boolean {
        val yesterday = LocalDate.now().minusDays(1)
        return publishingDate?.isAfter(yesterday) ?: false
    }
}
