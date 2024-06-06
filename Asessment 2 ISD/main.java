import java.util.*;

public class main {
    
    static class Kota {
        String name;
        String country;

        public Kota(String name, String country) {
            this.name = name;
            this.country = country;
        }
    }

    public static List<Kota> determineItinerary(String startingKota, List<Kota> kotaes, boolean nearestFirst) {
        List<Kota> itinerary = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<Kota> queue = new LinkedList<>();
        
        for (Kota kota : kotaes) {
            if (kota.name.equals(startingKota)) {
                itinerary.add(kota);
                visited.add(kota.name);
                queue.add(kota);
                break;
            }
        }
        while (!queue.isEmpty()) {
            Kota currentKota = queue.poll();
            for (Kota nextKota : kotaes) {
                if (!visited.contains(nextKota.name) && isConnected(currentKota, nextKota)) {
                    itinerary.add(nextKota);
                    visited.add(nextKota.name);
                    queue.add(nextKota);
                }
            }
        }
        if (!nearestFirst) {
            Collections.reverse(itinerary);
        }
        return itinerary;
    }
    public static boolean isConnected(Kota kota1, Kota kota2) {
        return true;
    }
    public static void main(String[] args) {

        List<Kota> kotaes = new ArrayList<>();
        kotaes.add(new Kota("Paris", "France"));
        kotaes.add(new Kota("Brussels", "Belgium"));
        kotaes.add(new Kota("Zurich", "Switzerland"));
        kotaes.add(new Kota("Amsterdam", "Netherlands"));
        kotaes.add(new Kota("Vienna", "Austria"));
        kotaes.add(new Kota("Prague", "Czechia"));
        kotaes.add(new Kota("Hamburg", "Jerman"));
        kotaes.add(new Kota("Warsaw", "Poland"));
        kotaes.add(new Kota("Budapest", "Hungary"));

        List<Kota> itineraryA = determineItinerary("Paris", kotaes, true);
        List<Kota> itineraryB = determineItinerary("Paris", kotaes, false);

        System.out.println("Itinerary berdasarkan aturan a (nearestFirst):");
        for (Kota kota : itineraryA) {
            System.out.println(kota.name + ", " + kota.country);
        }
        System.out.println("\nItinerary berdasarkan aturan b (farthestFirst):");
        for (Kota kota : itineraryB) {
            System.out.println(kota.name + ", " + kota.country);
        }
    }
}
