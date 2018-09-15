import java.util.ArrayList;
import java.util.function.Consumer;

public class MorseWriter {
    private String text;
    private int currentCharIndex = 0;
    private int sleepTimeMilliseconds = 500;

    private ArrayList<Consumer<Integer>> handlers = new ArrayList<>();

    public void loadText(String text) {
        this.text = text;
    }

    public void start() {
        Thread morseThread = new Thread(() -> {
            while (currentCharIndex < text.length()) {
                // I hate checked exceptions...
                try {
                    writeChar(text.charAt(currentCharIndex));

                    // We need to wait 3 units after each char
                    for (int i = 0; i < 3; i++) {
                        transmit(0);
                        Thread.sleep(sleepTimeMilliseconds);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                currentCharIndex++;
            }
        });

        morseThread.start();
    }

    public void addHandler(Consumer<Integer> handler){
        this.handlers.add(handler);
    }

    private void writeChar(char c) throws InterruptedException {
        String morse = Alphabet.interpretChar(c);
        int val = 0;
        for (char m : morse.toCharArray()) {
            if (m == ' ')
                val = 0;
            if (m == '.')
                val = 1;
            if (m == '-')
                val = 1;

            transmit(val);

            Thread.sleep(sleepTimeMilliseconds);
        }
    }

    private void transmit(int tickValue) {
        handlers.forEach(handler -> handler.accept(tickValue));
    }
}
