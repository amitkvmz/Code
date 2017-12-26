import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	Scanner sc = new Scanner(System.in);
	int input = sc.nextInt();
	String []s = new String[input*2];
	for(int i=0; i<input*2;i++) {
	    s[i] = sc.nextLine();
	}
	for(int j=0 ; j< input+1;j++) {
	    
	    if(checkAnagram(s[j],s[j+1])==true){
	        System.out.println("YES");
	    } 
	    else
	    System.out.println("NO");

	    j++;
	}

	
	}
	public static boolean checkAnagram(String s1, String s2) {
        if(s1.length() == s2.length()) {
            for(int i=0 ; i<s1.length();i++) {
                for(int j = 0; j< s1.length();j++) {
                    if(s1.charAt(i)==s2.charAt(j))
                    continue;
                    else
                    return
                }
            }
             
        }
        else return false;
    }
}
