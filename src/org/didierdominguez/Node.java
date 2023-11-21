package org.didierdominguez;

public class Node {
    private String letter;
    private int frequency;
    private String code;
    private Node leftBranch;
    private Node rightBranch;

    public Node(String letter) {
        this.letter = letter;
        this.frequency = -1;
        this.code = "";
        this.leftBranch = null;
        this.rightBranch = null;
    }

    public Node(String letter, int frequency) {
        this.letter = letter;
        this.frequency = frequency;
        this.code = "";
        this.leftBranch = null;
        this.rightBranch = null;
    }

    public Node(Node leftBranch, Node rightBranch) {
        this.letter = "";
        this.frequency = (leftBranch != null ? leftBranch.getFrequency() : 0) +
                (rightBranch != null ? rightBranch.getFrequency() : 0);
        this.code = "";
        this.leftBranch = leftBranch;
        this.rightBranch = rightBranch;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Node getLeftBranch() {
        return leftBranch;
    }

    public void setLeftBranch(Node leftBranch) {
        this.leftBranch = leftBranch;
    }

    public Node getRightBranch() {
        return rightBranch;
    }

    public void setRightBranch(Node rightBranch) {
        this.rightBranch = rightBranch;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Traverses the tree and assigns codes to nodes.
     * 
     * @param code The code associated with the node.
     */
    public void traverse(String code) {
        if (leftBranch != null && rightBranch != null) {
            leftBranch.traverse(code + '0');
            rightBranch.traverse(code + '1');
        } else {
            this.code = code;
            EncodingTable.getInstance().add(this);
        }
    }
}
