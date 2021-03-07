package utils

import interfaces.Ranks

/**
 * The hotels will have a special ranking system
 */
data class HotelRanks(private val currentRank: String): Ranks {
    companion object {
        val oneStar = "One Star"
        val twoStars = "Two stars"
        val threeStars = "Three stars"
        val fourStars = "Four stars"
        val fiveStars = "Five stars"
    }
    /**
     * Still not 100% sure how I should solve this part
     *                  (since ranking is subjective: e.g. is two star considered low or medium?)
     * Maybe a rank interface is not the answer...?
     */
    override val lowRank: String
        get() = oneStar
    override val mediumRank: String
        get() = threeStars
    override val highRank: String
        get() = fiveStars
}
