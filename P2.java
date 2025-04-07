/*
 * Time Complexity: O(n)

Space Complexity: O(n)

Use a greedy algorithm with a stack to remove digits that make the number larger (prioritizing smaller digits earlier).

After one pass, if digits are still left to remove, pop from the end (stack top).

Build the final number from the stack, remove leading zeros, and return the result (or "0" if empty).
 */

class Solution {
    public String removeKdigits(String num, int k) {
        int size=num.length();
        if(k==size)return "0";
        Stack <Character> stack= new Stack();
        //put nums on stack
        int counter=0;
        while(counter<size){
            while(k>0 && !stack.isEmpty()&& stack.peek()>num.charAt(counter)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(counter));
            counter++;
        }
        while(k>0){
            stack.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            char current_char=stack.pop();
            sb.append(current_char);
        }
        sb.reverse();
        while(sb.length()>1&& sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
    }
    return sb.toString();
}}

/*
greedy algorithm
*/
