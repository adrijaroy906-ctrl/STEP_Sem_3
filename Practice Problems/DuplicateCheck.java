import java.util.HashSet;

public class DuplicateCheck {
    static boolean hasDuplicate(String[] ids) {
        HashSet<String> set = new HashSet<>();

        for (String id : ids) {
            if (set.contains(id))
                return true;

            set.add(id);
        }

        return false;
    }

    public static void main(String[] args) {
        String[] a = {"TX1", "TX2", "TX3", "TX1"};
        String[] b = {"TX1", "TX2", "TX3"};

        System.out.println(hasDuplicate(a));
        System.out.println(hasDuplicate(b));
    }
}
