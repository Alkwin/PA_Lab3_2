package locations

import interfaces.Payable
import interfaces.Visitable
import utils.DistanceAndID
import utils.TimeTable
import javax.swing.ImageIcon

class Restaurant(
    override val name: String,
    override val description: String,
    override val image: ImageIcon?,
    override val coordinates: Pair<Int, Int>,
    override val fee: Int,
    override val timeTable: TimeTable, override var map: MutableList<DistanceAndID>,
    override var id: String
) : Payable, Visitable {
    override fun myToString(): String {
        return super<Visitable>.myToString() +
                "Fee = $fee" + "\n" +
                "Opening hours = Opening: ${timeTable.openingHour}, closing: ${timeTable.closingHour}"
    }
}