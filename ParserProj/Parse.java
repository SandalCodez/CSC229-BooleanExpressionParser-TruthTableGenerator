package ParserProj;


public class Parse {
    
  
    String content;

    public char[] stringToArr(String val){   //takes in string and return char array
        return val.toCharArray();
    
    }
    public boolean checkOp(char ch){
       if(ch == '+'||ch == '*'||ch == '/'|| ch == '('|| ch == ')'){    //Method used in sort to check if character with array is an operator 
       return true;
       }return false; 
    }
 
    public int getPrec(char arr){
        // -+ 1
        // */ 2
        //lETTER -1
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

 
    public String sort(char[] arr){                  //infix to postfix
        List l = new List();
        List.LinkedListStack l1 = l.new LinkedListStack();
        String content = "";
        for(int i = 0; i < arr.length; i++){
            char ch = arr[i];
            if(getPrec(ch)==-1){
                content += ch;
            }else{
                while(!l1.isEmpty()){
                    if(getPrec(l1.peek()) >= getPrec(ch)){
                        content += l1.pop(); 
                    }l1.push(ch);
                }if(ch == '('){
                    l1.push(ch);
                }else if(ch == ')'){
                    while(!l1.isEmpty()&&l1.peek()!='('){
                        content += l1.pop();
                    }l1.pop();
                }
            }
        }return content;
      
    
    } public void table(char[] ch){
        

    //     int varCount = 0;

        
    //     int numRow = (int)Math.pow(2,varCount);
    //     char[][] table = new char [numRow][varCount + 1];
    //     for(int row = 0; row <= numRow; row ++ ){
    //         for(int col = 0; col <= varCount+1; col++){
    //             table[row][col] = 
    //         }
            
    //     }

        int and;
        int or;
        int not;
        
       
        for(int z = 0; z < ch.length; z++){
            char c = ch[z];
           
        if(checkOp(c)){
            //boolean ? (T whatevr : F watere
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

    
    
    
    
