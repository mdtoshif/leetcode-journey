// Problem: Fizz Buzz (#412)
// Date: 18-04-2026

// Approach:
// Check multiples of 3 and 5 using modulo
// Add Fizz, Buzz or number accordingly
import java.util.*;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> li = new ArrayList<>(n);

        for(int i = 0; i < n; i++){
            if((i + 1) % 3 == 0 && (i + 1) % 5 == 0){
                li.add("FizzBuzz");
            } else if((i + 1) % 3 == 0){
                li.add("Fizz");
            } else if((i + 1) % 5 == 0){
                li.add("Buzz");
            } else {
                li.add(String.valueOf(i + 1));
            }
        }

        return li;
    }
}