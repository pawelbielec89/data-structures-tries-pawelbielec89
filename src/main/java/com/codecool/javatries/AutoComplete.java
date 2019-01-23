package com.codecool.javatries;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
                    TrieDataNode child = new TrieDataNode(character, node);
                    node.addChild(child);
                    node = child;
                }
            } else {
                TrieDataNode child = new TrieDataNode(character, node);
                node.addChild(child);
                node = child;
            }
        }
        TrieDataNode child = new TrieDataNode();
        node.addChild(child);
        child.setParent(node);
     }


    /**
     * Returns the possible completions of baseChars String from the Trie.
     * @param baseChars The String to autocomplete.
     * @return possible completions. An empty list if there are none.
     */
    public List<String> autoComplete(String baseChars) {

        TrieDataNode node = root;
        String reverseBaseChars = new StringBuilder(baseChars).reverse().toString();
        while(reverseBaseChars.length()>0){
            char character = getLastLetter(reverseBaseChars);
            reverseBaseChars = deleteLastLetter(reverseBaseChars);
            if(node.getIsThereChild(character)){
                node = node.getChild(character);
            }
        }

        List<String> words = traverseTrie(node); //Before adding First part
        for(String s: words) {
            s = baseChars + s;
        }
        List<String> results = take10AlphabeticalResults(words);
        return results;
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

    private List<String> traverseTrie(TrieDataNode focusNode){
        List<String> words = new ArrayList<>();
        if(focusNode != null && focusNode.getChildrenSetSize()>0) {
            for (TrieDataNode n : focusNode.getChildren()) {
                 List<String> returnedWords = traverseTrie(n);
                 words.addAll(returnedWords);
            }
        } else {
            String word = "";
            focusNode = focusNode.getParent();
            while(focusNode.getData() != '-'){
                word += focusNode.toString();
                focusNode = focusNode.getParent();
            }
            words.add(new StringBuilder(word).reverse().toString());
        }
        return words;
    }

    private List<String> take10AlphabeticalResults(List<String> words){
        words.sort(String.CASE_INSENSITIVE_ORDER);
        List<String> results = new ArrayList<>();
        int counter = 0;
        while (results.size()<10){
            results.add(words.get(counter));
            counter++;
        }
        return results;
    }
}
