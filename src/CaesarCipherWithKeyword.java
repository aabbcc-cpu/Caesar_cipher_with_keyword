import java.util.Arrays;
import java.util.stream.Collectors;

public class CaesarCipherWithKeyword {
    private static final StringBuilder alphabet = new StringBuilder("абвгдежзийклмнопрстуфхцчшщъыьэюя");
    private static char[] key = new char[alphabet.length()];

    public static String encode(String s, int k, String kw) {
        if (s.isEmpty())
            return "";
        s = s.toLowerCase();
        kw = kw.toLowerCase();
        formatKey(k, kw);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)))
                builder.append(key[alphabet.indexOf(String.valueOf(s.charAt(i)))]);
            else
                builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static String decode(String s, int k, String kw) {
        if (s.isEmpty())
            return "";
        s = s.toLowerCase();
        kw = kw.toLowerCase();
        formatKey(k, kw);
        StringBuilder builder = new StringBuilder();
        String temp = new String(key);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)))
                builder.append(alphabet.charAt(temp.indexOf(String.valueOf(s.charAt(i)))));
            else
                builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static char[] formatKey(int k, String kw) {
        kw = removeDuplicates(kw);

        for (int i = k; i < kw.length() + k; i++)
            key[i] = kw.charAt(i - k);

        StringBuilder temp = new StringBuilder(kw + alphabet);
        temp = new StringBuilder(removeDuplicates(temp.toString()));
        temp = new StringBuilder(temp.toString().replace(kw, ""));

        for (int i = 0; i < alphabet.length(); i++) {
            if (key[i] == Character.MIN_VALUE) {
                if (i < k)
                    key[i] = temp.charAt(temp.length() - k + i);
                else if (i > k)
                    key[i] = temp.charAt(i - k - kw.length());
            }
        }
        return key;
    }

    public static String removeDuplicates(String key) {
        return Arrays.stream(key.split(""))
                .distinct()
                .collect(Collectors.joining());
    }
}
