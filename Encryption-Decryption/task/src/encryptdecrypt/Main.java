package encryptdecrypt;


public class Main {
    public static void main(String[] args) {
        StartCryption startCryption = new StartCryption();
        startCryption.setMethod(args);
        startCryption.startProgress();
    }
}

