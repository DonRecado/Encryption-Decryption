package encryptdecrypt;

import java.io.File;
import java.util.Scanner;

enum Crypt {
    ENCRYPT,
    DECRYPT
}

enum AlgoType {
    UNICODE,
    SHIFT
}


public class StartCryption {
    private CryptingMethod method;
    private final Scanner scanner = new Scanner(System.in);

    public void setMethod(String[] args) {
        this.method = getMethod(args);
    }

    private CryptingMethod getMethod(String[] args) {
        AlgoType alg = AlgoType.SHIFT;
        Crypt mode = Crypt.ENCRYPT;
        int key = 0;
        String data = "";
        File inFile = null;
        File outFile = null;

        if (args.length % 2 == 0) {
            for (int i = 0; i < args.length; i += 2) {
                switch (args[i]) {
                    case "-mode":
                        mode = args[i + 1].equals("enc") ? Crypt.ENCRYPT : Crypt.DECRYPT;
                        break;
                    case "-key":
                        try {
                            key = Integer.parseInt(args[i + 1]);
                        } catch (NumberFormatException e) {
                            key = 0;
                        }
                        break;
                    case "-data":
                        System.out.println(args[i + 1]);
                        data = args[i + 1];
                        break;
                    case "-in":
                        inFile = new File(args[i + 1]);
                        break;
                    case "-out":
                        outFile = new File(args[i + 1]);
                        break;
                    case "-alg":
                        alg = args[i + 1].equals("unicode") ? AlgoType.UNICODE : AlgoType.SHIFT;
                        break;
                }
            }

            if (data.equals("") && inFile == null && outFile == null) {
                data = scanner.nextLine();
                return new EnterAndDisplay(data, mode, key, alg);
            } else if (!data.equals("") && inFile == null && outFile == null) {
                return new EnterAndDisplay(data, mode, key, alg);
            } else if (inFile != null && outFile == null) {
                return new LoadAndDisplay(data, mode, key, alg, inFile);
            } else if (inFile == null && outFile != null) {
                return new EnterAndSave(data, mode, key, alg, outFile);
            } else if (inFile != null && outFile != null) {
                return new LoadAndSave(data, mode, key, alg, inFile, outFile);
            } else {
                return null;
            }

        }
        return null;
    }

    public void startProgress() {
        this.method.progress();
    }

}




