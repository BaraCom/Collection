import java.util.HashMap;
import java.util.Map;

public class Cache {
    private static Map<String, String> cache = new HashMap<>();

    static void showCache() {
        for (HashMap.Entry<String, String> entry : cache.entrySet()) {
            System.out.println(new StringBuilder().append("_______\n")
                    .append(entry.getKey())
                    .append("\n")
                    .append(entry.getValue())
                    .append("_______").toString());
        }
    }

    static String isContainsKeys(String inputLine, String countWordsRepetition) {
        if (cache.containsKey(inputLine)) {
            return getWord(inputLine);
        } else {
            addToCache(inputLine, countWordsRepetition);
            return getWord(inputLine);
        }
    }

    private static void addToCache(String inputLine, String countWordsRepetition) {
        cache.put(inputLine, countWordsRepetition);
    }

    private static String getWord(String inputLine) {
        return cache.get(inputLine);
    }
}
