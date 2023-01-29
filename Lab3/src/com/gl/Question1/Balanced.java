package com.gl.Question1;

import java.util.Stack;


public class Balanced {
	 
    static boolean checkBalancedBrackets(String exp) {
        
        Stack<Character> stack = new Stack<Character>();
 
        for(int i = 0;i < exp.length();i++)
        {
            char character = exp.charAt(i);
 
            if (character == '(' || character == '[' || character == '{')
            {          
                stack.push(character);
                continue;
            }
 
            if (stack.isEmpty())
                return false;
            
            char c;
            
            switch (character) {
            
            case '}':
            	
            	c = stack.pop();
                if (c == '(' || c == '[')
                    return false;
                break;
                
            case ')':
            	
                c = stack.pop();
                if (c == '{' || c == '[')
                    return false;
                break;
 
            case ']':
                c = stack.pop();
                if (c == '(' || c == '{')
                    return false;
                break;
            }
        }	       
        return (stack.isEmpty());
    }
 
   
    public static void main(String[] args)
    {
        String exp = "([[{}]])";
         
        Boolean result;
        
        result = checkBalancedBrackets(exp);
        
        if (result)
            System.out.println("The Entered String Has Balanced Brackets");
        else
            System.out.println("The Entered Strings Do Not Has Balanced Brackets ");
	}
}
