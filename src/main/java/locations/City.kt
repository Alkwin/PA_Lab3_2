package locations

import interfaces.Location
import interfaces.Payable
import interfaces.Visitable

/**
 * The city will hold a number of locations
 */
class City() {

    var cityLocations = mutableListOf<Location>()

    fun addLocation(newLocation: Location)  {
        cityLocations.add(newLocation)
    }

    fun displayCityInformation() {
        println("Displaying all locations:")
        cityLocations.forEach {
            displayLocationInformation(it)
        }
    }

    private fun displayLocationInformation(location: Location) {
        println(location.myToString())
        println()
    }

    fun displayFreelyVisitable() {
        println("Displaying free and visitable locations:")
        var visitableLocations = cityLocations.filter {
            it is Visitable && it !is Payable
        }

        visitableLocations = visitableLocations.sortedBy {
            (it as Visitable).timeTable.openingHour
        }

        visitableLocations.forEach {
            displayLocationInformation(it)
        }
    }
}