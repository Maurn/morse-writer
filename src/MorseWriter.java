public class MorseWriter {
    private String text;
    private int currentCharIndex = 0;
    private int sleepTimeMilliseconds = 500;

    public void loadText(String text){
        this.text = text;
    }

    public void start(){
        Thread morseThread = new Thread(() -> {
            while(currentCharIndex < text.length()){
                System.out.println(text.charAt(currentCharIndex));
                currentCharIndex++;
                // I hate checked exceptions...
                try {
                    Thread.sleep(sleepTimeMilliseconds);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        morseThread.start();
    }
}
