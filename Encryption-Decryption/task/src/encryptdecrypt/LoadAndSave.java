package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LoadAndSave extends CryptingMethod implements LoadFile, SaveFile {

    private File inFile;
    private File outFile;

    public LoadAndSave(String data, Crypt mode, int key, AlgoType alg, File inFile, File outFile) {
        super(data, mode, key, alg);
        this.inFile = inFile;
        this.outFile = outFile;
    }


    @Override
    void progress() {
        String data = load();
        if (data != null) {
            setData(data);
            String crypt = printEncDec();
            writeFile(crypt);
        }
    }

    @Override
    public String load() {
        try (Scanner scanner = new Scanner(inFile)) {
            return scanner.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeFile(String data) {
        try (FileWriter writer = new FileWriter(this.outFile)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
