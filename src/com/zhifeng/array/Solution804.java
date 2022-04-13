package com.zhifeng.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 804. 唯一摩尔斯密码词
 * @author ganzhifeng
 * @date 2022/4/10
 */
public class Solution804 {

    public static final String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-",
            "...-", ".--", "-..-", "-.--", "--.."};


    public static int uniqueMorseRepresentations(String[] words) {

        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            StringBuffer buffer = new StringBuffer();
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                buffer.append(MORSE[c - 'a']);
            }
            String code = buffer.toString();
            System.out.println("code： " + code);
            set.add(code);
        }

        return set.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg","gan"};
        int i = uniqueMorseRepresentations(words);
        System.out.println(i);
    }

}
