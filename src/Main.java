public class Main {
    public static void main(String[] args) {
        MorseWriter morseWriter = new MorseWriter();
        morseWriter.loadText("SOS SOS");
        morseWriter.addHandler(integer -> {
            System.out.printf("%d",integer);
        });
        morseWriter.start();
    }
}
