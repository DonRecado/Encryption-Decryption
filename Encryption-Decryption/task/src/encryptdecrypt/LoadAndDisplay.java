package encryptdecrypt;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoadAndDisplay extends CryptingMethod implements LoadFile {

    private File inputFile;

    public LoadAndDisplay(String data, Crypt mode, int key, AlgoType alg, File inputFile) {
        super(data, mode, key, alg);
        this.inputFile = inputFile;
    }

    @Override
    void progress() {
        setData(load());
        System.out.println(printEncDec());
    }

    @Override
    public String load() {
        try (Scanner scanner = new Scanner(inputFile)) {
            return scanner.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
