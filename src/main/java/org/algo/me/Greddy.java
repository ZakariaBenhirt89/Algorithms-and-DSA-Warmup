package org.algo.me;

import java.util.Stack;

public class Greddy {
    String reverseShuffleMerge(String s){
        int[] addCnt = new int[26];
        int[] skipCnt = new int[26];
        Stack<Character> st = new Stack<>();
        String rslt = "";

        char[] ss = s.toCharArray();

        for(int i = 0; i < ss.length; i++){
            addCnt[ss[i] - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            addCnt[i] /= 2;
        }

        System.arraycopy(addCnt, 0, skipCnt, 0, addCnt.length);

        for(int i = ss.length - 1; i >= 0; i--){
            while(!st.empty() && st.peek() > ss[i] && addCnt[ss[i] - 'a'] > 0 && skipCnt[st.peek() - 'a'] > 0){
                char c = st.pop();
                addCnt[c - 'a']++;
                skipCnt[c - 'a']--;
            }

            if(addCnt[ss[i] - 'a'] > 0){
                st.push(ss[i]);
                addCnt[ss[i] - 'a']--;
            }else{
                skipCnt[ss[i] - 'a']--;
            }
        }

        while(!st.empty()){
            rslt = st.pop() + rslt;
        }

        return rslt;

    }
}
