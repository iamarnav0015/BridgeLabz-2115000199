import java.util.*;
public class SetToSortedList {
    public static List<Integer> convertToSortedList(Set<Integer> set){
        List<Integer> sortedList=new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>(Arrays.asList(5,1,6,2,8));

        List<Integer> sortedList=convertToSortedList(set);
        System.out.println(sortedList);
    }
}