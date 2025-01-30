public class RemoveCharacter {
    public static void main(String[] args) {
        String inputString="Hello World";
        char charToRemove='l';
        String modifiedString=inputString.replaceAll(String.valueOf(charToRemove),"");
        System.out.println("Modified String:"+modifiedString);
    }
}
