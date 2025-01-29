package Strings;

public class CompareStrings {
    public static void compareStrings(String str1, String str2) {
        int comparison = str1.compareTo(str2);
        if (comparison < 0) {
            System.out.println(str1 + " comes before " + str2 + " lexicographically.");
        } else if (comparison > 0) {
            System.out.println(str2 + " comes before " + str1 + " lexicographically.");
        } else {
            System.out.println("Both strings are equal.");
        }
    }
}

