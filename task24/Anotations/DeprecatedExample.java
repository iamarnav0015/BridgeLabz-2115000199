
class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("This is an old feature and should not be used.");
    }

    public void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // This should show a warning
        api.newFeature();
    }
}

