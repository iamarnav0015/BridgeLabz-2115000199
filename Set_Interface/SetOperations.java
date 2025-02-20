import java.util.*;
public class SetOperations {
    public static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> union=new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }
    public static Set<Integer> getInsertion(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> intersection=new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
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

        System.out.println("Union: "+getUnion(set1,set2));
        System.out.println("Intersection: "+getInsertion(set1,set2));
    }
}
