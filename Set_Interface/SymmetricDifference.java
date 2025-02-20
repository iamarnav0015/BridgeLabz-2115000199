import java.util.*;
public class SymmetricDifference {
    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> diff1 = new HashSet<>(set1);
        Set<Integer> diff2 = new HashSet<>(set2);

        diff1.removeAll(set2);
        diff2.removeAll(set1);

        diff1.addAll(diff2);
        return diff1;
    }

    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> result=symmetricDifference(set1, set2);
        System.out.println(result);
    }
}
