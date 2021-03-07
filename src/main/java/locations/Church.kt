package locations

import interfaces.Visitable
import utils.DistanceAndID
import utils.TimeTable
import javax.swing.ImageIcon

/**
 * Opening hours because it might be a 'historic site'
 */

class Church(
    override val name: String,
    override val description: String,
    override val image: ImageIcon?,
    override val coordinates: Pair<Int, Int>,
    override val timeTable: TimeTable,
    override var map: MutableList<DistanceAndID>,
    override var id: String
) : Visitable {
    override fun myToString(): String {
        return super<Visitable>.myToString() +
                "Opening hours = Opening: ${timeTable.openingHour}, closing: ${timeTable.closingHour}"
    }
}