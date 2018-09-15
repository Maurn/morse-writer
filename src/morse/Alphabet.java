package morse;

import java.util.Map;

import static java.util.Map.entry;

class Alphabet {
    private static Map<Character, String> map = Map.ofEntries(
            entry('A', ". ---"),
            entry('B', "--- . . ."),
            entry('C', "--- . --- ."),
            entry('D', "--- . ."),
            entry('E', "."),
            entry('F', ". . --- ."),
            entry('G', "--- --- ."),
            entry('H', ". . . ."),
            entry('I', ". ."),
            entry('J', ". --- --- ---"),
            entry('K', "--- . ---"),
            entry('L', ". --- . ."),
            entry('M', "--- ---"),
            entry('N', "--- ."),
            entry('O', "--- --- ---"),
            entry('P', ". --- --- ."),
            entry('Q', "--- --- . ---"),
            entry('R', ". --- ."),
            entry('S', ". . ."),
            entry('T', "---"),
            entry('U', ". . ---"),
            entry('V', ". . . ---"),
            entry('W', ". --- ---"),
            entry('X', "--- . . ---"),
            entry('Y', "--- . --- ---"),
            entry('Z', "--- --- . ."),
            entry(' ', "       ")
    );

    static String interpretChar(char c){
        char key = Character.toUpperCase(c);

        if(!map.containsKey(key))
            throw new IllegalArgumentException(c + " is not a valid character");

        return map.get(key);
    }
}
