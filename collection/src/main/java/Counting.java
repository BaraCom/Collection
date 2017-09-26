import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Counting {

    private static final String ENTER_MESSAGE = "1";
    private static final String SHOW_CACHE = "2";
    private static final String EXIT = "3";

    public static void startApp() {
        HashMap<String, String> cache = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            showMenu();
            String inputLine = scan.nextLine();

            switch (inputLine) {
                case ENTER_MESSAGE:
                    System.out.println("message: ");
                    inputLine = scan.nextLine();
                    getResultMessage(cache, inputLine);
                    break;
                case SHOW_CACHE:
                    showCache(cache);
                    break;
                case EXIT:
                    System.out.println("\n-+  See you...  +-");
                    flag = false;
                    scan.close();
                    break;
                default:
                    System.out.println("No-no-no, try again!");
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.print("---------------------\n"
            + ENTER_MESSAGE + " - enter the message\n"
            + SHOW_CACHE + " - show the cache\n"
            + EXIT + " - EXIT\n"
            + "---------------------\n");
    }

    private static void showCache(HashMap<String, String> cache) {
        for (HashMap.Entry<String, String> entry : cache.entrySet()) {
            System.out.println("_______\n"
                + entry.getKey() + "\n" + entry.getValue()
                + "_______");
        }
    }

    private static String getLineCountingWords(String inputLine) {
        int counter = 0;
        String resultLine = "";

        char[] charArr = inputLine.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < inputLine.length(); i++) {
            for (int j = 0; j < inputLine.length(); j++) {
                if (charArr[i] == charArr[j]) {
                    counter++;
                }
            }
            hashMap.put(charArr[i], counter);
            counter = 0;
        }
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            resultLine += "\"" + entry.getKey() + "\" - " + entry.getValue() + "\n";
        }
        return resultLine;
    }

    private static boolean isContainsKeys(HashMap<String, String> cache, String inputLine) {
        return cache.containsKey(inputLine);
    }

    private static void addedToMap(HashMap<String, String> cache, String inputLine) {
        cache.put(inputLine, getLineCountingWords(inputLine));
    }

    private static void getResultMessage(HashMap<String, String> cache, String inputLine) {
        if (isContainsKeys(cache, inputLine)) {
            System.out.println(cache.get(inputLine));
        } else {
            addedToMap(cache, inputLine);
            System.out.println("\n" + cache.get(inputLine));
        }
    }
}
