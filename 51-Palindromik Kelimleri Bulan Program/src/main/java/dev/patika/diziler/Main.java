package dev.patika.diziler;

public class Main {

    public static void main(String[] args) {
        String word = "poyraz";
        String tempWord = "";

        for (int i = word.length()-1; i >= 0; i--)
            tempWord += String.valueOf(word.charAt(i));

        if (tempWord.equalsIgnoreCase(word))
            System.out.println(word + " Palindromik bir kelimedir.");
        else
            System.out.println(word + " Palindromik bir kelime değildir.");
    }
}
