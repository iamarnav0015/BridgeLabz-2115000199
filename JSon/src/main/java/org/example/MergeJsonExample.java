import org.json.JSONObject;

public class MergeJsonExample {
    public static void main(String[] args) {
        JSONObject json1 = new JSONObject();
        json1.put("name", "Alice");
        json1.put("age", 25);

        JSONObject json2 = new JSONObject();
        json2.put("email", "alice@example.com");
        json2.put("city", "New York");

        JSONObject mergedJson = new JSONObject(json1, JSONObject.getNames(json1));
        for (String key : JSONObject.getNames(json2)) {
            mergedJson.put(key, json2.get(key));
        }

        System.out.println(mergedJson.toString());
    }
}
