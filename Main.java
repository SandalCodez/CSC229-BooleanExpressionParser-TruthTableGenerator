package ParserProj;

import ParserProj.List.LinkedListStack;

public class Main {
    public static void main (String[]args){
        //
        String x1 = "A+B";                   
  Parse p1 = new Parse();
  System.out.println("Infix: " + x1);
  System.out.println("Postfix: " + p1.sort(p1.stringToArr(x1)));
  System.out.println(" T   F  "+ x1);
 p1.table(p1.stringToArr(x1));

    }
    
}
