package org.didierdominguez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EncodingTable {

    private static EncodingTable instance;
    private ArrayList<Node> nodes;
    private Map<String, String> charToCodeMap;
    private Map<String, String> codeToCharMap;

    private EncodingTable() {
        nodes = new ArrayList<>();
        charToCodeMap = new HashMap<>();
        codeToCharMap = new HashMap<>();
    }

    public static EncodingTable getInstance() {
        return (instance == null) ? instance = new EncodingTable() : instance;
    }

    public void add(Node node) {
        nodes.add(node);
        charToCodeMap.put(node.getLetter(), node.getCode());
        codeToCharMap.put(node.getCode(), node.getLetter());
    }

    public void displayData() {
        for (Node node : nodes) {
            System.out.println("DATA: " + node.getLetter()
                    + ", FREQUENCY: " + node.getFrequency()
                    + ", CODE: " + node.getCode());
        }
    }

    /**
     * Retrieves the code associated with a character.
     * 
     * @param character The character to retrieve the code for.
     * @return The code associated with the character.
     */
    public String getCode(String character) {
        return charToCodeMap.getOrDefault(character, "");
    }

    /**
     * Retrieves the character associated with a code.
     * 
     * @param code The code to retrieve the character for.
     * @return The character associated with the code.
     */
    public String getCharacter(String code) {
        return codeToCharMap.getOrDefault(code, "");
    }
}
