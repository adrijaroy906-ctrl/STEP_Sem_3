public class LibraryCatalog {
    static String findBook(String[][] catalog, String target) {
        int low = 0, high = catalog.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = catalog[mid][0].compareTo(target);

            if (cmp == 0)
                return catalog[mid][1];
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        String[][] catalog = {
            {"8002223334", "Beginning Python"},
            {"9003334445", "Classic Mythology"},
            {"9004445556", "Data and Society"},
            {"9005556667", "European History"},
            {"9901112223", "Introduction to Algebra"}
        };

        System.out.println(findBook(catalog, "9003334445"));
        System.out.println(findBook(catalog, "9009998887"));
    }
}
