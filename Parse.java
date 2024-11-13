package ParserProj;


public class Parse {
    
  
    String content;

    public char[] stringToArr(String val){                              //takes in string and return char array that will be used in sort()
        return val.toCharArray();
    
    }
    public boolean checkOp(char ch){
       if(ch == '+'||ch == '*'||ch == '/'|| ch == '('|| ch == ')'){    //Method used in sort to check if character with array is an operator that will also be used in sort()
       return true;
       }return false; 
    }
 
    public int getPrec(char arr){                                       //checks a character and sets a precedence according to the character 
       
       int precedence = 0;
        if(!checkOp(arr)){
            precedence = -1;
        }if(arr == '+'){
            precedence = 1;
        }if(arr == '*'){
            precedence = 2;
        }if(arr == '!'){
            precedence = 3;
        }

        return precedence;
    }

 
    public String sort(char[] arr){                                     //This is my infix to postfix method. 
        
        //creates a linkedlist that will be used as a stack 
        List l = new List();
        List.LinkedListStack l1 = l.new LinkedListStack();
        
        //empty string that will act as a place to pop element out of the stack
        String content = "";
        for(int i = 0; i < arr.length; i++){
            char ch = arr[i];
            //if letter, print to string
            if(getPrec(ch)==-1){
                content += ch;
            }else{
                //while the stack isnt empty, check if the precedence of the top of the stack is greater than the precedence of the current char iteration
                //if so, pop the that element in the stack, otherwise print the char currently iterated
                while(!l1.isEmpty()){
                    if(getPrec(l1.peek()) >= getPrec(ch)){
                        content += l1.pop(); 
                    }l1.push(ch);
                }if(ch == '('){
                //Although the program breaks with "(" in table(), sort() will take the ( and push into the stack. Sort() will iterate normally until it reaches ) and then it
                //will print the pop of the stack and then pop )
                    l1.push(ch);
                }else if(ch == ')'){
                    while(!l1.isEmpty()&&l1.peek()!='('){
                        content += l1.pop();
                    }l1.pop();
                }
            }
        }return content;
      
    
    } public void table(char[] ch){
        
        int and;
        int or;
        int not;
        
        for(int z = 0; z < ch.length; z++){
            char c = ch[z];
           
        if(checkOp(c)){
          //Here i loop through 0 and 1 and print the iterations of the loop along with a boolean expression that checks all possibilties of the respected truth table 
            if(c == '*'|| c== '+'){
                for(int i = 0; i <=1; i++){
                    for(int j = 0; j <=1 ; j++){
                        if(c == '*'){
                            if((i == 1 && j == 1)){
                                and = 1;
                               
                                System.out.println("|" + i + " | " + j + " | " + and + "|");
                            }else{
                                and = 0;
                               
                                System.out.println("|" + i + " | " + j + " | " + and + "|");}
                        }if(c == '+'){
                            if(i == 1 || j == 1){
                                or = 1;
                              
                                System.out.println("|" + i + " | "  + j + " | " + or + "|");
                            }else{or = 0;
                                
                                System.out.println("|" + i + " | " + j + " | " + or + "|");}
                        }
                    }
                }
                
            }if(c == '!'){
                for(int i = 0; i <= 1; i++){
                    for(int j = 0; j <= 1; j++){
                        if(i == 1){
                            not = 0;
                            System.out.println(i + " " + not);
                        }else{
                            not = 1;
                            System.out.println(i + ' ' + not);

                        }
                    }
                }
            }
        }
    }
        
}
}

    
    
    
    
