package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

//  Input:  "abb", d = 2
//          Output: "bab"

//Input:  "aacbbc", d = 3
//        Output: "abcabc"

//Input:  "aaabbc", d = 3
//        Output: "abcaba"

//a : 3
//b : 1
service

//i = 0;
//a - a -

// Input:  "aaa",  d = 2
// Output: "Not possible"
class Solution {

      public String arrange(String input, int d){
            Map<Character, Integer> hashMap = new HashMap<>();

            for(int i = 0; i < input.length(); i++)
                  hashMap.put(input.charAt(i), hashMap.getOrDefault(input.charAt(i), 0) + 1);

            int[] output = new int[input.length()];

            for(Map.Entry<Character, Integer> entry : hashMap.entrySet()){
                  Character c = entry.getKey();
                  int frequency = entry.getValue();

                  int index = 0;
                  if()

                  for(int i = 0; i < frequency; i++){

                        if(index >= input.length()) return "Not Possible";

                        while(output[index + d] == 0){
                              output[index]
                        }

                  }
            }


      }
}