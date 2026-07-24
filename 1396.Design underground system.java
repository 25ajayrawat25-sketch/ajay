import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Helper class to store check-in details for a customer
    private static class CheckInInfo {
        String stationName;
        int checkInTime;

        CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    // Helper class to store aggregated trip metrics for a route
    private static class RouteInfo {
        double totalTime;
        int tripCount;

        RouteInfo(double totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    // Maps id -> CheckInInfo
    private final Map<Integer, CheckInInfo> checkInMap;
    
    // Maps "StartStation->EndStation" -> RouteInfo
    private final Map<String, RouteInfo> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo checkIn = checkInMap.remove(id);
        String routeKey = checkIn.stationName + "->" + stationName;
        int travelTime = t - checkIn.checkInTime;

        RouteInfo route = routeMap.computeIfAbsent(routeKey, k -> new RouteInfo(0, 0));
        route.totalTime += travelTime;
        route.tripCount++;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteInfo route = routeMap.get(routeKey);
        return route.totalTime / route.tripCount;
    }
}
