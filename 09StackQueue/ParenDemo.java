public class ParenDemo{
     public static boolean isMatching(String s){
	MyStack<Character> stack = new MyStack<Character>();
	char c = '0';
	for(int i = 0;i<s.length();i++){
	    c = s.charAt(i);
	    if((c=='{')||(c=='[')||(c=='(')||(c=='<')){
		stack.push(c);
	    }
	    if(c=='}'){
		if(stack.size==0){
		    System.out.println("Bad character: "+c);
		    return false;
		}
		if(stack.pop()!='{'){
		    System.out.println("Bad character: "+c);
		    return false;
		}
	    }
	    if(c==']'){
		if(stack.size==0){
		    System.out.println("Bad character: "+c);
		    return false;
		}
		if(stack.pop()!='['){
		    System.out.println("Bad character: "+c);
		    return false;
		}
	    }
	    if(c==')'){
		if(stack.size==0){
		    System.out.println("Bad character: "+c);
		    return false;
		}
		if(stack.pop()!='('){
		    System.out.println("Bad character: "+c);
		    return false;
		}
	    }
	    if(c=='>'){
		if(stack.size==0){
		    System.out.println("Bad character: "+c);
		    return false;
		}
		if(stack.pop()!='<'){
		    System.out.println("Bad character: "+c);
		    return false;
		}
	    }
	}
	return stack.size()==0;
    }

  public static void main(String[]args){
	String s = "";
	if(args.length>0){
	    s=args[0];
	}
	System.out.println(isMatching(s));
    }
}
