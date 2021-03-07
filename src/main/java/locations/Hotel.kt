package locations

import interfaces.Classifiable
import interfaces.Payable
import utils.DistanceAndID
import utils.HotelRanks
import javax.swing.ImageIcon

class Hotel(
    override val rank: HotelRanks,
    override val name: String,
    override val description: String,
    override val image: ImageIcon?,
    override val coordinates: Pair<Int, Int>,
    override val fee: Int, override var map: MutableList<DistanceAndID>,
    override var id: String
) : Payable, Classifiable {
    override fun myToString(): String {
        return super<Payable>.myToString() + "" +
                "Fee = $fee" + "\n" +
                "Rank: $rank"
    }
}