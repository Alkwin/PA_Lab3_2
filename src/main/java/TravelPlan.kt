import interfaces.Location
import locations.City

class TravelPlan(private var city: City, private var locationOrderPreferences: MutableList<Location>) {
    fun displayTravelPlan() {
        println("Displaying travel plan:")
        locationOrderPreferences.forEach {
            println(it.myToString())
            println()
        }
    }
}