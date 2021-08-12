import java.util.*;
import java.io.*;
public class mid1{
  public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(new File("m1.txt"));

      String[] keys = { "for", "and", "def", "float", "if", "else" };

      ArrayList<String> keywords = new ArrayList<String>();
      List<String> key = Arrays.asList(keys);


      
      String[] special = { ":" };

      String[] logic = { "abs", "input" };

      List<String> logics = Arrays.asList(logic);
      List<String> specials = Arrays.asList(special);

      
      ArrayList<String> sa = new ArrayList<String>();
      ArrayList<String> v = new ArrayList<String>();
      ArrayList<String> built = new ArrayList<String>();
      ArrayList<String> cast = new ArrayList<String>();
      ArrayList<String> lists = new ArrayList<String>();
      ArrayList<String> math = new ArrayList<String>();
      math.add("+");
      math.add("-");
      math.add("/");
      math.add("*");
      math.add("**");

      ArrayList<String> m = new ArrayList<String>();

      ArrayList<String> nos = new ArrayList<String>();
      
      while (sc.hasNext()) {
          String s = sc.next();
          if (isNumeric(s)) {
              if (nos.contains(s)) {
              } else {
                  nos.add(s);
              }
          } else {
              if (s.contains("=")) {
                  String a[] = s.split("=");
                  if (a[1].equals("[]")) {
                      lists.add(a[0]);
                  } else {
                      if (v.contains(a[0])) {

                      } else {
                          v.add(a[0]);

                      }
                      if(isNumeric(a[1]) ){

                      }else {
                        String c[] = a[1].split("\\(");
                        if (logics.contains(c[0])) {
                            if (!built.contains(c[0])) {
                                built.add(c[0]);
                            }
                        } else {
                            if(c[0].contains("str") && !c[0].contains("string")){
                            
                                if (!cast.contains(c[0])) {
                                    cast.add(c[0]);
                                }
                            }
                        }
                    
                      }

                  }

              } else if (key.contains(s)) {
                  if (keywords.contains(s)) {
                  } else {
                      keywords.add(s);
                  }
              } else if (math.contains(s)) {
                  if (m.contains(s)) {
                  } else {
                      m.add(s);
                  }
              } else if (specials.contains(s)) {
                  if (sa.contains(s)) {

                  } else {
                      sa.add(s);
                  }

              }else if(s.contains("str")){
                if (!cast.contains("str")) {
                    cast.add("str");
                }
              }

          }
      }
      System.out.print("Keywords- ");
      for (String z : keywords) {
          System.out.print(z + ", ");
      }
      System.out.print("\nList- ");
      for (String z : lists) {
          System.out.print(z + ", ");
      }
      System.out.print("\nVariable- ");
      for (String z : v) {
          System.out.print(z + ", ");
      }
      System.out.print("\nCasting- ");
      for (String z : cast) {
          System.out.print(z + "(), ");
      }
      System.out.print("\nBuilt-in- ");
      for (String z : built) {
          System.out.print(z + "(), ");
      }
      System.out.print("\nSpecial Character- ");
      for (String z : sa) {
          System.out.print(z + ", ");
      }
      System.out.print("\nOperator- ");
      for (String z : m) {
          System.out.print(z + ", ");
      }

  }

  public static boolean isNumeric(String str) {
      try {
          Double.parseDouble(str);
          return true;
      } catch (NumberFormatException e) {
      return false;  
    }  
  }
}