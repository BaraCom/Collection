import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Counting {
    private static final String ENTER_MESSAGE = "1";
    private static final String SHOW_CACHE = "2";
    private static final String EXIT = "3";

    public static void startApp() {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            showMenu();
            String inputLine = scan.nextLine();

            switch (inputLine) {
                case ENTER_MESSAGE:
                    System.out.println("message: ");
                    inputLine = scan.nextLine();
                    System.out.println(getResultMessage(inputLine));
                    break;
                case SHOW_CACHE:
                    Cache.showCache();
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

    private static String getCountWordsRepetition(String inputLine) {
        StringBuilder resultLine = new StringBuilder();

        char[] chars = inputLine.toCharArray();
        Map<Character, Integer> charsMap = new LinkedHashMap<>();

        for (int i = 0; i < inputLine.length(); i++) {
            int count = 0;
            for (int j = 0; j < inputLine.length(); j++) {
                if (chars[i] == chars[j]) {
                    count++;
                }
            }
            charsMap.put(chars[i], count);
        }
        for (Map.Entry<Character, Integer> pair : charsMap.entrySet()) {
            resultLine.append("\"")
                      .append(pair.getKey())
                      .append("\" - ")
                      .append(pair.getValue())
                      .append("\n");
        }
        return resultLine.toString();
    }

    public static String getResultMessage(String inputLine) {
        String countWordsRepetition = getCountWordsRepetition(inputLine);

        return Cache.isContainsKeys(inputLine, countWordsRepetition);
    }
}
