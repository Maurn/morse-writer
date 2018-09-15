import java.util.Map;

public class Alphabet {
    private static Map<Character, String> map = Map.of(
            'S', ". . .",
            'O', "--- --- ---"
    );

    public static String interpretChar(char c){
        if(!map.containsKey(c))
            throw new IllegalArgumentException(c + " is not a valid character");

        return map.get(c);
    }
}
