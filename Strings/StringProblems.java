
import java.util.Arrays;

/*
 * This class contains typical String problems asked in coding interviews
 */

/**
 *
 * @author robertt
 */
public class StringProblems {
    
    /**
     *  This solution is O(n log n)
     *  Sort both strings and compare
     * @param str1
     * @param str2
     * @return true if they are anagrams, false if not
    */
    public boolean areAnagramsSort(String str1, String str2)
    {
        char[] chars = str1.toCharArray();
        Arrays.sort(chars);
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars2);
        return (new String(chars).compareTo(new String(chars2))==0);
    }
    
    /**
    *
    *   This is a O(n) solution
    *   Assuming ASCII strings.
    *   Compute character frequencies of both strings
    *       and based on that check if they are anagrams
    *   
     * @param str1
     * @param str2  
     * @return 
    */
    public boolean areAnagramsBuffer(String str1, String str2)
    {
        int[] buffer = new int[256];
        for(int i=0;i<256;i++)
            buffer[i] = 0;
        for(Character c: str1.toCharArray())
        {
            buffer[c]++;
        }
        for(Character c: str2.toCharArray())
        {
            buffer[c]--;
        }    
        for(int i=0;i<256;i++)
        {
            if(buffer[i] !=0 )
            {
                return false;
            }
        }
        return true;
    }
 
    /**
    *  Longest Palindrome
    *  Runs in O(n^2)
    *  Algorithm consists in expanding the center of the palindrome.
    *  2 Cases :   one letter center and two letter center.
     * @param str - input string
     * @return the length of the longest palindrome in string
    */
    public int longestPalindrome(String str) {
        int j, k;
        int lng;
        int big=0;

        //check for palindromes with center formed of two letters
        for (int i = 0; i < str.length() - 1; i++) 
        {
            if (str.charAt(i) == str.charAt(i + 1)) {
                lng =0;
                j = i;
                k = i + 1;
                while (j >= 0 && k <= str.length() - 1) 
                {
                    if (str.charAt(j) != str.charAt(k)) 
                    {
                        break;
                    }
                    j--;k++;
                    lng++;
                }
                lng*=2;
                if(lng>big) big = lng;
            }
        }
        //check for palindromes with center formed of one letter
        for (int i = 0; i < str.length() - 1; i++) 
        {
                lng=0;
                j = i-1;
                k = i + 1;
                while (j >= 0 && k <= str.length() - 1) 
                {
                    if (str.charAt(j) != str.charAt(k)) 
                    {
                        break;
                    }
                    j--;k++;
                    lng++;
                }
                lng = (lng*2) + 1;
                if(lng>big) big = lng;
        }
        return big;
    }
    
}
