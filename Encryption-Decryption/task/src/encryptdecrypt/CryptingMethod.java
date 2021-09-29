
package encryptdecrypt;

abstract class CryptingMethod {
    private String data;
    private Crypt mode;
    private int key;
    private AlgoType alg;

    CryptingMethod(String data, Crypt mode, int key, AlgoType alg) {
        this.data = data;
        this.mode = mode;
        this.key = key;
        this.alg = alg;
    }


    void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    String printEncDec() {
        StringBuilder sb = new StringBuilder();
        int start;
        int end;


        for (char c : this.data.toCharArray()) {
            int newChar = mode.equals(Crypt.ENCRYPT) ? c + key : c - key;
            if (alg.equals(AlgoType.UNICODE)) {
                start = 32;
                end = 126;
                if (newChar > end) {
                    sb.append((char) (start + (newChar - end)));
                } else if (newChar < start) {
                    sb.append((char) (end - (start - c)));
                } else {
                    sb.append((char) newChar);
                }
            } else {
                if (c == ' ') {
                    sb.append(c);
                } else {
                    start = 97;
                    end = 122;
                    if (newChar > end) {
                        sb.append((char) (start + (newChar - end - 1)));
                    } else if (newChar < start) {
                        sb.append((char) (end - (start - newChar) + 1));
                    } else {
                        sb.append((char) newChar);
                    }
                }

            }
        }
        return sb.toString();
    }


    abstract void progress();
}
