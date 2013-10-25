/*
 * Longest Palindrome
 * Runs in O(n^2)
 * Algorithm consists in expanding the center of the palindrome.
 * 2 Cases :   one letter center and two letter center.
 */
public class LongestPalindrome {

    static int longPalindrome(String str) {
        int j, k;
        int lng=0;
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
    
    public static void main(String[] args) {
        String str = "ababbaba";
        int l = longPalindrome(str);
        System.out.println(l);
    }
}
