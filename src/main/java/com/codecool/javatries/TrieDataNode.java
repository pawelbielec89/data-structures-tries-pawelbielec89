package com.codecool.javatries;

import sun.text.normalizer.Trie;

import javax.xml.soap.Node;
import java.util.HashSet;
import java.util.Set;

public class TrieDataNode {

    private char data;
    //private TrieDataNode parent;
    private Set<TrieDataNode> children;
    private String word;

    private TrieDataNode() {
    }

    public TrieDataNode(char data) {
        children = new HashSet<>();
        this.data = data;
    }

    public char getData() {
        return data;
    }

    @Override
    public String toString() {
        return Character.toString(data);
    }

    /*public TrieDataNode getParent() {
        return parent;
    }

    public void setParent(TrieDataNode parent) {
        this.parent = parent;
    }*/

    public TrieDataNode getChild(char character) {
        TrieDataNode childNode = null;
        for (TrieDataNode n : children) {
            if (n.getData() == character) {
                childNode = n;
            }
        }
        return childNode;
    }

    public void addChild(TrieDataNode newNode) {
        children.add(newNode);
    }

    public void removeChild(char character) {
        for (TrieDataNode n : children) {
            if (n.getData() == character) {
                children.remove(n);
            }
        }
    }
}
