package interfaces

import utils.TimeTable
import java.time.Duration

/**
 * Debatable name, since 'Visitable' usually implies tourism, but restaurants also have opening hours
 */

interface Visitable: Location {
    val timeTable: TimeTable

    // static in Kotlin
    companion object {
        fun getVisitingDuration(visitable: Visitable): utils.Duration =
            utils.Duration(visitable.timeTable.closingHour - visitable.timeTable.openingHour, "H")
    }

}