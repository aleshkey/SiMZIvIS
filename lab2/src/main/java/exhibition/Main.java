package exhibition;

import exhibition.util.Decoder;
import exhibition.util.Encoder;

public class Main {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        Decoder decoder = new Decoder();

        String text = "the neighbors were building a fence just before we moved in";
        System.out.println(text);

        String code = encoder.encrypt(text, 3);
        System.out.println(code+"\n");
        decoder.decode(code);

        code=encoder.encryptHarder(text, 3);
        System.out.println("\n\n"+code+"\n");
        decoder.decode(code);

        System.out.println("\n\n");
        decoder.decodeHarder(code, 3);
    }
}