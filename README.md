# Encryption_System

Program of a encryption system as follows. First use the program in 1 to translate the English text to binary strings. Then divide the plaintext (binary strings) into blocks of 16 bitstrings. Each block is divided into L0 and R0 where L0 comprises the first 8 bits and R0 the last 8 bits. Then use the following iterations for 1 ≤ i ≤ 2, where f is defined in 2: 
Li = Ri−1 Ri = Li−1  f(Ri−1,Ki). The key is a 24-bit binary string. The first round key uses the first 12 bits and the second round key uses the last 12 bits. The output (ciphertext block) is L2R2. 
Suppose the plaintext is “how do you like computer science” and the key is 
{101101010010100101101011}. Use the above programs to compute the ciphertext. The ciphertext is written in English letters (from the correspondence described in 1.). 
 
Solution Description:  
STEP 1: Converted String to binary. 
STEP 2: Using substring we have set the key value. 
public static void key_set(String key) 
STEP 3: Divided the plain text into 16 bit block.  
while(str.length()%16!=0) 
STEP 4: The block is divided into after and before (L0 and R0) both f size 8 bits. 
STEP 5: Converting from interger to binary string having bit size as 5 for each divided string. STEP 6: Creating a list of strings where a temprarory chipher is generated (List<String> temp_cip) STEP 7: Initializing the length of the string  and the block size to 16 bit.  
STEP 8: Adding the after and before bit (L0 and R0). We have also created columns and rows in oder to find the integer value at that place. 
STEP 9: Used decryption algorithm to decrypt the plain_text using a temprary variable. 
