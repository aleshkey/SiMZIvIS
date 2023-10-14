package exhibition.util;

public class Decoder {
    public void decode(String cipher){
        Encoder encoder = new Encoder();
        for (char i = 'a'; i<='z'; i++){
            System.out.format("%3d %s\n", (i-'a'), encoder.encrypt(cipher, i-'a'));
        }
    }

    public void decodeHarder(String cipher, int code){
        Encoder encoder = new Encoder();
        StringBuilder res = new StringBuilder();
        for(int i=0; i<cipher.length(); i++){
            res.append(encoder.shit(cipher.charAt(i), 26 - encoder.hash(code, i)));
        }
        System.out.println(res);
    }

}
