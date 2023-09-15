package org.example.util;

public class Generator {
    public String createPassword(int length){
        StringBuilder password= new StringBuilder();
        for(int i=0; i< length; i++){
            password.append(chooseCharacter((int) (Math.random() * 3)));
        }
        return password.toString();
    }

    private char chooseCharacter(int key){
        char res= ' ';
        switch (key) {
            case 0 -> {
                res = getRandomValue(48, 57);
            }
            case 1 -> {
                res = getRandomValue(65, 90);
            }
            case 2 -> {
                res = getRandomValue(97, 122);
            }
        }
        return res;
    }

    private char getRandomValue(int start, int finish){
        return (char)(start+(int)(Math.random()*(finish-start)));
    }
}
