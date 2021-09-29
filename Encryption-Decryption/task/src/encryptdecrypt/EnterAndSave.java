package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EnterAndSave extends CryptingMethod implements SaveFile {

    private File outputFile;

    public EnterAndSave(String data, Crypt mode, int key, AlgoType alg, File outputFile) {
        super(data, mode, key, alg);
        this.outputFile = outputFile;
    }

    @Override
    void progress() {
        setData(super.printEncDec());
        writeFile(this.getData());
    }

    @Override
    public void writeFile(String data) {

        try (FileWriter writer = new FileWriter(this.outputFile)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
