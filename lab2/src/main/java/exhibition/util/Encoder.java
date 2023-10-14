package exhibition.util;

public class Encoder {

    public String encrypt(String str, int code){
        StringBuilder cipher = new StringBuilder();
        for (int i =0; i< str.length(); i++){
            cipher.append(shit(str.charAt(i), code));
        }
        return cipher.toString();
    }

    char shit(char ch, int code){
        if (ch == ' ')
            return ch;
        if ((int)ch + code <= 'z'){
            return (char) (ch+code);
        }
        while (ch+code > 'z'){
            ch= (char) (ch-26);
        }
        return shit(ch, code);
    }

    int hash(int code, int i){
        return (int)(code*Math.sqrt(i+1));
    }

    public String encryptHarder(String str, int code){
        StringBuilder cipher = new StringBuilder();
        for (int i =0; i< str.length(); i++){
            cipher.append(shit(str.charAt(i), hash(code, i)));
        }
        return cipher.toString();
    }

}
