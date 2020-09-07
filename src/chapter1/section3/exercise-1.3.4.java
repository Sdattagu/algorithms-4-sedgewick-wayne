/*
 Write a stack client 'Parentheses' that reads in a text stream from std input,
 and uses a stack to determine whether its parentheses are properly balanced.
 For example, your program should print 'true' for:
 [ ( ) ] { } { [ ( ) ( ) ] ( ) }

 and 'false' for:
 [ ( ] )
*/

package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

class StackClient {
    private boolean evaluate(String stream) {
        char[] arr = stream.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c : arr) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char p = stack.pop();
                    if (p == '[' && c == ']'
                            || p == '(' && c == ')'
                            || p == '{' && c == '}') {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StackClient stackClient = new StackClient();

        StdOut.println("Is balanced [()]{}{[()()]()}: " + stackClient.evaluate("[()]{}{[()()]()}"));
        StdOut.println("Is balanced [(]): " + stackClient.evaluate("[(])"));

    }
}



