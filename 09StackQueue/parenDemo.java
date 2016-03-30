import java.util.*;
public class parenDemo{
    public static boolean isMatching(String input){
	MyStack<Character> openparens = new MyStack<Character>();
	for(char next:input.toCharArray()){
	    if(next == '('||next=='{'||next=='['||next=='<'){
		openparens.push(next);
	    }
	    if(next == ')'||next=='}'||next==']'||next=='>'){
		char match = getMatch(next);
		try{
		    char expectedThing = openparens.pop();
		    if(match!=expectedThing){
			return false;
		    }
		}catch(NoSuchElementException e){
		    return false;
		}
	    }
	    if(next=='{'||next=='['||next=='('||next=='<'){
		openparens.push(next);
	    }
	}
	if(!openparens.isEmpty()){
	    return false;
	}
	return false;
    }
    public static char getMatch(char c){
	char match = 0 ;
	if(c == '}'){
	    match = '{';
	}
	if(c == ']'){
	    match = '[';
	}
	if(c == ')'){
	    match = 'C';
	}
	if(c == '>'){
	    match = '<';
	}
	return match;
    }
}