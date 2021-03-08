import interfaces.Location
import interfaces.Visitable
import locations.*
import utils.DistanceAndID
import utils.HotelRanks
import utils.TimeTable

class Compulsory {
    fun run() {

        val v1 = Hotel(
            HotelRanks(HotelRanks.oneStar),
            "v1",
            "Generic hotel description",
            null, // introduced an image, but I don't see why we should use that for now
            Pair(20,30),
            100,
            mutableListOf(
                DistanceAndID(10,"v2"),
                DistanceAndID(50,"v3")
            ),
            "v1"
        )

        val v2 = Museum(
            "v2",
            "Museum A",
            null,
            Pair(30,20),
            100,
            TimeTable(8,20),
            mutableListOf(
                DistanceAndID(20,"v3"),
                DistanceAndID(20,"v4"),
                DistanceAndID(10,"v5")
            ),
            "v2"
        )

        val v3 = Museum(
            "v3",
            "Museum B",
            null,
            Pair(30,50),
            101,
            TimeTable(8,18),
            mutableListOf(
                DistanceAndID(20,"v4")
            ),
            "v3"
        )

        val v4 = Church(
            "Church A",
            "Church A",
            null,
            Pair(60,70),
            TimeTable(6,22),
            mutableListOf(
                DistanceAndID(30,"v5"),
                DistanceAndID(10,"v6")
            ),
            "v4"
        )

        val v5 = Church(
            "Church B",
            "Church B",
            null,
            Pair(5,70),
            TimeTable(5,24),
            mutableListOf(
                DistanceAndID(20,"v6")
            ),
            "v5"

        )

        val v6 = Restaurant(
            "Restaurant",
            "Restaurant",
            null,
            Pair(5, 5),
            200,
            TimeTable(10,23),
            mutableListOf(),
            "v6"
        )
        val city = City()
        city.addLocation(v1)
        city.addLocation(v2)
        city.addLocation(v3)
        city.addLocation(v4)
        city.addLocation(v5)
        city.addLocation(v6)

        city.displayCityInformation()
        city.displayFreelyVisitable()

        val tp = TravelPlan(city, mutableListOf(v6, v5, v4, v3, v2, v1))

        tp.displayTravelPlan()

        println(shortestPath(city, v1, v6))
    }

    private fun shortestPath(city: City, initialLocation: Location, targetLocation: Location): Int {

        /**
         * [pathsToTarget]
         * This works as follows: We take the whole city and filter it
         *                          by keeping ONLY the locations that lead to the target location
         * This is the initial step of the algorithm
         */

        /**
         * The idea of the algorithm is to go from the final location backwards until we reach an end point (or when we detect a LOOP)
         * We add the distance values as we go and check if the location we reached now is the initialLocation
         */

        /*var pathsToTarget = city.cityLocations.filter { locationIterator ->
            locationIterator.map.any {
                it.locationID == targetLocation.id
            }
        }*/

        var pathsAndCosts = mutableListOf<Pair<String, Int>>()
        var shortestPath = 999999

        city.cityLocations.forEach { location ->
            location.map.forEach { distanceAndID ->
                if(distanceAndID.locationID == targetLocation.id) {
                    pathsAndCosts.add(Pair(distanceAndID.locationID, distanceAndID.distance))
                    if(distanceAndID.locationID == initialLocation.id &&
                        shortestPath > distanceAndID.distance) {
                        shortestPath = distanceAndID.distance
                    }
                }
            }
        }

        var newPathsAndCosts = pathsAndCosts

        while(newPathsAndCosts.size > 0) {
            city.cityLocations.forEach { location ->
                location.map.forEach { distanceAndID ->
                    pathsAndCosts.forEach { currentTargetLocations ->
                        if(distanceAndID.locationID == currentTargetLocations.first) {
                            newPathsAndCosts.add(Pair(distanceAndID.locationID, distanceAndID.distance + currentTargetLocations.second))
                            if(distanceAndID.locationID == initialLocation.id &&
                                shortestPath > distanceAndID.distance) {
                                shortestPath = distanceAndID.distance
                            }
                        }
                    }
                }
            }
        }

        return shortestPath
    }
}
