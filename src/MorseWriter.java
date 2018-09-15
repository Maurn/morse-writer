public class MorseWriter {
    private String text;
    private int currentCharIndex = 0;
    private int sleepTimeMilliseconds = 500;

    public void loadText(String text) {
        this.text = text;
    }

    public void start() {
        Thread morseThread = new Thread(() -> {
            while (currentCharIndex < text.length()) {
//                System.out.println(text.charAt(currentCharIndex));
                writeChar(text.charAt(currentCharIndex));
                for (int i =0;i<3;i++){
                    System.out.print("0");
                    try {
                        Thread.sleep(sleepTimeMilliseconds);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                currentCharIndex++;
            }
        });

        morseThread.start();
    }

    private void writeChar(char c) {
        String morse = Alphabet.interpretChar(c);
        for (char m : morse.toCharArray()) {
            if (m == ' ')
                System.out.print("0");
            if (m == '.')
                System.out.print("1");
            if (m == '-')
                System.out.print("1");

            // I hate checked exceptions...
            try {
                Thread.sleep(sleepTimeMilliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
