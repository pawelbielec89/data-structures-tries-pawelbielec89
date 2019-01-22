package com.codecool.javatries;

import sun.text.normalizer.Trie;

import javax.xml.soap.Node;
import java.util.HashSet;
import java.util.Set;

public class TrieDataNode {

    private char data;
    private Set<TrieDataNode> children;

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

    public boolean getIsThereChild(char character) {
        for (TrieDataNode n : children) {
            if (n.getData() == character) {
                return true;
            }
        }
        return false;
    }

    public TrieDataNode getChild(char character) {
        for (TrieDataNode n : children) {
            if (n.getData() == character) {
                return n;
            }
        }
        return null;
    }

    public void addChild(TrieDataNode newChild) {
        children.add(newChild);
    }

    public void removeChild(char character) {
        for (TrieDataNode n : children) {
            if (n.getData() == character) {
                children.remove(n);
            }
        }
    }

    public int getChildrenSetSize(){
        if(children.size()>0){
            return children.size();
        } else {
            return 0;
        }
    }

    public Set<TrieDataNode> getChildren(){
        return children;
    }
}
