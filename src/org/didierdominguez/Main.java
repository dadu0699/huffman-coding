package org.didierdominguez;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        HuffmanEncoder huffmanEncoder = new HuffmanEncoder();

        String myString = "This is a test string for Huffman encoding and decoding";
        System.out.println(Colors.ANSI_CYAN + "Text to encode: " + Colors.ANSI_RESET + myString);
        huffmanEncoder.encode(myString);

        List<String> characterList = Arrays.asList(myString.split("(?!^)"));
        for (int i = 0; i < characterList.size(); i++) {
            String character = characterList.get(i);
            characterList.set(i, EncodingTable.getInstance().getCode(character));
        }
        String encodedString = String.join(" ", characterList);
        System.out.println(Colors.ANSI_CYAN + "Encoded text: " + Colors.ANSI_RESET + encodedString);

        characterList = Arrays.asList(encodedString.split(" "));
        for (int i = 0; i < characterList.size(); i++) {
            String code = characterList.get(i);
            characterList.set(i, EncodingTable.getInstance().getCharacter(code));
        }
        String decodedString = String.join("", characterList);
        System.out.println(Colors.ANSI_CYAN + "Decoded text: " + Colors.ANSI_RESET + decodedString);
    }
}
