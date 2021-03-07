package interfaces

import utils.DistanceAndID
import javax.swing.ImageIcon

interface Location {
    val name: String
    val description: String
    val image: ImageIcon?
    val coordinates: Pair<Int, Int> // X and Y
    var map: MutableList<DistanceAndID>
    var id: String

    fun nameEquals(location: Location) =
        this.name == location.name

    fun myToString(): String {
        return "Name = $name \n" +
                "Description = $description\n" +
                "Coordinates (X and Y) = $coordinates\n" +
                "Map: $map\n" +
                "ID: $id" +
                "\n"
    }
}