import java.util.*;
import java.io.*;
public class com{
  public static void main(String[] args) throws Exception{
    Scanner sc=new Scanner(new File("x.txt"));
    
    String [] keys={"int","float","if","else"};
 
    ArrayList<String> k=new ArrayList<String>();
    List<String> key=Arrays.asList(keys);
    
    String [] other={",",";","(",")","{","}"};
   
    List<String> others=Arrays.asList(other);
     ArrayList<String> o=new ArrayList<String>();
    
    String [] logic={"<",">"};
    
    List<String> logics=Arrays.asList(logic);
    ArrayList<String> l=new ArrayList<String>();
    ArrayList<String> math = new ArrayList<String>();
    math.add("+");
    math.add("-");
    math.add("/");
    math.add("*");
    math.add("=");
    ArrayList<String> m = new ArrayList<String>();
    
  
    ArrayList<String> nos = new ArrayList<String>();
    ArrayList<String> id = new ArrayList<String>();
    while(sc.hasNext()){
      String s=sc.next();
      if(isNumeric(s)){
        if(nos.contains(s)){
        }else {
          nos.add(s);
        }
      }else {
        if(key.contains(s)){
          if(k.contains(s)){
          }else {
            k.add(s);
          }
        } else if(logics.contains(s)){
          if(l.contains(s)){
          }else {
            l.add(s);
          }
          
        }else if(others.contains(s)){
          if(o.contains(s)){
          }else {
            o.add(s);
          }
        }else if(math.contains(s)){
          if(m.contains(s)){
          }else {
            m.add(s);
          }
        }else {
          if(id.contains(s)){
          }else {
            id.add(s);
          }
        }
          
      }
    }
    System.out.print("Keywords: ");
    for(String z:k){
      System.out.print(z+", ");
    }
    System.out.print("\nIdentifiers: ");
    for(String z:id){
      System.out.print(z+", ");
    }
    System.out.print("\nMath Operators: ");
    for(String z:m){
      System.out.print(z+", ");
    }
    System.out.print("\nLogical Operators: ");
    for(String z:l){
      System.out.print(z+", ");
    }
    System.out.print("\nNumerical Values: ");
    for(String z:nos){
      System.out.print(z+", ");
    }
    
    System.out.print("\nOthers: ");
    for(String z:o){
      System.out.print(z+" ");
    }
    
    
    
  }
  public static boolean isNumeric(String str) { 
    try {  
      Double.parseDouble(str);  
      return true;
    } catch(NumberFormatException e){  
      return false;  
    }  
  }
}