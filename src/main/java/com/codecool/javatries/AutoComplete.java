package com.codecool.javatries;

import java.util.ArrayList;
import java.util.List;

public class AutoComplete {

    private TrieDataNode root;

    public AutoComplete() {
        root = new TrieDataNode('-');
    }

    /**
     * Adds a word to the Trie.
     */
    public void addWord(String wordToAdd) {
        String reverseWord = new StringBuilder(wordToAdd).reverse().toString();
        TrieDataNode node = root;
        while (reverseWord.length()>0){
            char character = getLastLetter(reverseWord);
            reverseWord = deleteLastLetter(reverseWord);
            if (node.getChildrenSetSize()>0 && node.getChildren() != null){
                if(node.getIsThereChild(character)){
                    node = node.getChild(character);
                } else {
                    TrieDataNode child = new TrieDataNode(character);
                    node.addChild(child);
                    node = child;
                }
            } else {
                TrieDataNode child = new TrieDataNode(character);
                node.addChild(child);
                node = child;

            }
        }
     }


    /**
     * Returns the possible completions of baseChars String from the Trie.
     * @param baseChars The String to autocomplete.
     * @return possible completions. An empty list if there are none.
     */
    public List<String> autoComplete(String baseChars) {
        List<String> words = new ArrayList<>();
        // TODO
        return words;
    }

    /**
     * Removes a word from the Trie
     * @return true if the removal was successful
     */
    public boolean removeWord(String wordToRemove) {
        // TODO -- Optional homework
        return false;
    }

    private char getLastLetter(String str){
        return str.charAt(str.length() - 1);
    }

    private String deleteLastLetter(String str){
        return str.substring(0, str.length() - 1);
    }
}
