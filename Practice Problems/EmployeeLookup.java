import java.util.HashMap;

public class EmployeeLookup {
    public static void main(String[] args) {
        HashMap<String, String> lookup = new HashMap<>();

        lookup.put("E245", "Finance");
        lookup.put("E112", "Engineering");
        lookup.put("E390", "Marketing");
        lookup.put("E181", "Engineering");

        System.out.println(lookup.getOrDefault("E390", "Unknown"));
        System.out.println(lookup.getOrDefault("E998", "Unknown"));
    }
}
