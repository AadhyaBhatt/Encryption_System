
/**
 * 
 */

/*
File Name: S_Box.java
Author: Aadhya Bhatt
Date: 11-Feb-2019 03:01:58 PM
Description:
*/

import java.util.ArrayList;
import java.util.List;

public class Encryption_Sys
{
	public static int a;
  public static int b;
  public static String key_value="101101010010100101101011";
  public static String original_text="how do you like computer science";
   
 
    static int[][] str_1={{15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},{3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},{0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},{13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}};
    
     
    static int[][] str_2={{7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15},{13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},{10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},{3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14}};
    
   
    
    public static String[]ky=new String[2];
    
    Encryption_Sys()
    {
        ky=new String[2];
        ky[0]=key_value.substring(0, 12);
        ky[1]=key_value.substring(12,24);
    }
    
    // SETTING KEY VALUE UING SUBSTRING
    
    public static void key_set(String key)
    {
    	key_value=key;
        ky[0]=key_value.substring(0, 12);
        ky[1]=key_value.substring(12,24);
    }
    
    public static int[] num(String str)
    {
        
        int[] num=new int[str.length()];
         int tempo;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==' ')
            	tempo=26;
            else if(str.charAt(i)==',')
            	tempo=27;
            else if(str.charAt(i)=='.')
            	tempo=28;
            else if(str.charAt(i)=='?')
            	tempo=29;
            else if(str.charAt(i)=='(')
            	tempo=30;
            else if(str.charAt(i)==')')
            	tempo=31;
            else if(Character.isUpperCase(str.charAt(i)))
            	tempo=(int)str.charAt(i)-65;
            else
            	tempo=(int)str.charAt(i)-97;
            
            num[i]=tempo;
            
         }
        return num;
    }
    
    
    
    //CONVERTING FROM STRING TO ALPHABET
    
     public static String to_Alph(String s)
    {
        int c;
        int count=0;
        a=0;
        
        while(s.length()%5!=0)
        {
            s+='0';
            a++;
        }
       
        int[] num=new int[s.length()/5];
       
        for(int i=0;i<s.length();i=i+5)
        {
            c= Integer.parseInt(s.substring(i, i+5), 2);
            num[count]=c;
            count++;
        }
        char temp;
        String ciphertext="";
        
        for(int u=0;u<num.length;u++)
        {
        	
            if(num[u]==26)
            {
                temp=' ';
            }
            else if(num[u]==27) 
            {
                temp=',';
            }
            else if(num[u]==28)
            {    
            	temp='.';
            }
            else if(num[u]==29)
            {
            	temp='?';
            }
            else if(num[u]==30)
            {   
            	temp='(';
            }
            else if(num[u]==31)
            	
            {
            	temp=')';
            }
            else
                temp=(char)(num[u]+65);
           {
          	 ciphertext+=temp;
         }
           }
        return ciphertext;
    }
    
    public static String bit(int[] num)
    {
        String bit="";
        
        // INITIALIZE THE LENGTH 
        
        for(int i=0;i<num.length;i++)
        {
            String b= Integer.toBinaryString(num[i]);
        
            // CONDITION OF THE BIT LENGTH IS 5 BIT STRING
            
            while (b.length() < 5) 
               b = "0" + b;
            bit+=b;
        }
        return bit;
    }
    
    // LISTING THE STRING
    
    public static List<String> dec(String str)
    {
        List<String> temp_cip
        = new ArrayList<String>();
        List<String> blk = new ArrayList<String>();
     
        
        // CONDITION THAT THE STRING LENGTH SHOULD NOT BE MORE THAN 16, SINCE BLOCK LENGTH IS 16
       
        while(str.length()%16!=0)
            str+="0";
        
        // INITIALIZING THE STRING LENGTH
        
        for(int f=0;f<str.length();f=f+16)
        {
        	blk.add(str.substring(f, f+16));
        }
    
     // INITIALIZING THE BLOCK SIZE
        
        for(int bk=0;bk<blk.size();bk++)
        {
            String after=blk.get(bk).substring(0,8);
            String before=blk.get(bk).substring(8,16);
            for(int j=2;j>=1;j--)
            {
                String previous=before;
                before=after;
                String l="";
                
                for(int n=0;n<8;n++)
                {
                    String round=kl(before,ky[j-1]);
                    
                    // CONDITION THAT THE ROUND KEY LENGTH SHULD NOT BE MORE THAN 8 BITS
                    
                    while(round.length()!=8)
                        round="0"+round;
                    l+=previous.charAt(n)^round.charAt(n);
                }
                after=l;
            }
            temp_cip.add(after+before);
        }    
    return temp_cip;
   }
    
    
    public static String kl(String m,String key_val)
    {
        String bnew=m;
        StringBuilder bild = new StringBuilder();
        
        
        for(int i=0;i<m.length();i++)
        {
            if((i+1)%2==0)
                  bnew+=m.charAt(i);
        }
        
        for (int i = 0; i < bnew.length(); i++) 
        {
        	bild.append(bnew.charAt(i) ^ key_val.charAt(i));
        }

        String str= bild.toString();
        
        String row1="";
        String row2="";
        String col1="";
        String col2="";
        
        String a1=str.substring(0, 6);
        String a2=str.substring(6, str.length());
                
        for(int w=0;w<a1.length();w++)
        {   
            if(w==0||w==5)
            {
                row1+=Character.toString(a1.charAt(w));
                row2+=Character.toString(a2.charAt(w));
            }
            else
            {
                col1+=Character.toString(a1.charAt(w));
                col2+=Character.toString(a2.charAt(w));
            } 
        }
        
        int rows1=Integer.parseInt(row1,2);
        int cols1=Integer.parseInt(col1,2);
        int rows2=Integer.parseInt(row2,2);
        int cols2=Integer.parseInt(col2,2);
        
        // CONVERTING TO BINARY STRING
        
        String str_1_output=Integer.toBinaryString(str_1[rows1][cols1]);
        
        // SETTING CONDITION FOR THE OUTPUT TO BE NOT MORE THAN 4
        
        while(str_1_output.length()<4)
        str_1_output="0"+str_1_output;
        
        String str_2_output=Integer.toBinaryString(str_2[rows2][cols2]);
        while(str_1_output.length()<4)
        str_2_output="0"+str_2_output;
        
        // FINAL OUTPUT IS 4+4 = 8
        
        String final_output=str_1_output+str_2_output;        
        return final_output;  
    }

    
     public static List<String> en(String str)
    {
        
        List<String> blk = new ArrayList<String>();
        List<String> ciphertemp = new ArrayList<String>();
        b=0;
        
        // VALIDATING THAT THE STRING LENGTH IS NOT MORE THAN 16, SINCE THE BLOCK SIZE IS 16
        
        while(str.length()%16!=0)
        {
            str+="0";
            b++;
        }
        
        // INITIALIZING THE STRING LENGTH
        
        for(int i=0;i<str.length();i=i+16)
        {
        	blk.add(str.substring(i, i+16));
        }
        
        // INITIALIZING THE BLOCK SIZE
        
        for(int i=0;i<blk.size();i++)
        {
            String after=blk.get(i).substring(0,8);
            String before=blk.get(i).substring(8,16);
            for(int j=1;j<=2;j++)
            {
                String prev=after;
                String r="";
                after=before;
                
                for(int n=0;n<8;n++)
                {
                    String round=kl(before,ky[j-1]);
                    while(round.length()!=8)
                        round="0"+round;
                    r+=(prev.charAt(n)^round.charAt(n));
                }
                before=r;
            }
            ciphertemp.add(after+before);
        }
        
        return ciphertemp;
   }
     
     
     public static void main(String[] args)
     {
    	   List<String> ciptx_bin = new ArrayList<String>();
         List<String> cipher_dec = new ArrayList<String>();
         Encryption_Sys des=new Encryption_Sys();   
         System.out.println("------PROGRAM TITLE IS OF THIS PROGRAM IS------\n\n");
         System.out.println("MDES DECRYPTION");
         System.out.println(".................\n");
         System.out.println("THE ORIGINAL PLAIN TEXT:");
         System.out.println("........................\n");
         System.out.println(Encryption_Sys.original_text);
         System.out.println("");      
         String tempa="";
         int[] num_plain_txt=Encryption_Sys.num(Encryption_Sys.original_text);
         String bin_plain_txt= Encryption_Sys.bit(num_plain_txt);
         ciptx_bin=Encryption_Sys.en(bin_plain_txt);
        
         // INITIALIZING THE SIZE OF BINARY CIPHER TEXT
         
         for(int i=0;i<ciptx_bin.size();i++)
        	 tempa+=ciptx_bin.get(i);
         
         System.out.println("THE BINARY CIPHER TEXT IS:");
         System.out.println(".........................\n");
         System.out.println(tempa);
         System.out.println("");
                 
         String ciphertext=Encryption_Sys.to_Alph(tempa);
         System.out.println("THE CIPHER TEXT:");
         System.out.println(".................\n");
         System.out.println(ciphertext);
         
         System.out.println("");
         int[] num_ciphertext=Encryption_Sys.num(ciphertext);
         String bin_ciphertext=Encryption_Sys.bit(num_ciphertext);
         bin_ciphertext=bin_ciphertext.substring(0, bin_ciphertext.length()-Encryption_Sys.a);
          
         cipher_dec=Encryption_Sys.dec(bin_ciphertext);
         tempa="";
         for(int i=0;i<cipher_dec.size();i++)
         tempa+=cipher_dec.get(i);
        
         tempa=tempa.substring(0,tempa.length()-Encryption_Sys.b);
         String dec_text=Encryption_Sys.to_Alph(tempa);
         
         System.out.println("DECRYPTED TEXT:");
         System.out.println("...............\n");
         System.out.println(dec_text);
     }
}