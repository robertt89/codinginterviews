/*
 *  This program reverses the orders of words in a sentence
 *  e.g.    input:  Hello this is a test
 *          output: test a is this Hello
*/
public class ReverseSentence {
    
    static String reverse_sentence(String s)
    {
        StringBuilder reverse =
        new StringBuilder(s).reverse();
        return reverse.toString();
    }
    
    public static void main(String[] args) {
        String test = "Hello This is a test";
        String reverse = reverse_sentence(test);
        String[] tokens = reverse.split(" ");
        System.out.println(test);
        for(int i=0;i<tokens.length;i++)
        {
            System.out.print(reverse_sentence(tokens[i])+" ");
        }
    }
}
