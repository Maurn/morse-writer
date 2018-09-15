public class Main {
    public static void main(String[] args) {
        MorseWriter morseWriter = new MorseWriter();
        morseWriter.loadText("SOS");
        morseWriter.start();
    }
}
