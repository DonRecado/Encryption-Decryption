package encryptdecrypt;

public class EnterAndDisplay extends CryptingMethod {

    public EnterAndDisplay(String data, Crypt mode, int key, AlgoType alg) {
        super(data, mode, key, alg);
    }

    @Override
    void progress() {
        System.out.println(super.printEncDec());
    }
}
