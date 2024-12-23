package shann.java.problems.Strings;

public class LongestPalindromeSubString {
  public static void main(String[] args) {
    LongestPalindromeSubString lsp = new LongestPalindromeSubString();
    System.out.println(lsp.longestPalindrome("rwabcbawed"));
  }

  public String longestPalindrome(String A) {
    int longestSubString = 1;
    int subString = 0;
    // case odd character longest SubString
    int oddLongestSubString = 1;
    int oddLongestStartingIndex = 0;
    int oddLongestEndingIndex = 0;

    for (int i = 1; i < A.length(); i++) {
      int start = i, end = i;
      subString = 0;
      while (start >= 0 && end < A.length() && A.charAt(start) == A.charAt(end)) {
        if (start == end) subString += 1;
        else subString += 2;
        if (oddLongestSubString < subString) {
          oddLongestSubString = subString;
          oddLongestStartingIndex = start;
          oddLongestEndingIndex = end;
        }

        start--;
        end++;
      }
    }
    // case even character longest SubString
    int evenLongestSubString = 0;
    int evenLongestStartingIndex = 0;
    int evenLongestEndingIndex = 1;
    for (int i = 1; i < A.length(); i++) {
      int start = i - 1, end = i;
      subString = 0;
      while (start >= 0 && end < A.length() && A.charAt(start) == A.charAt(end)) {
        subString += 2;
        if (evenLongestSubString < subString) {
          evenLongestSubString = subString;
          evenLongestStartingIndex = start;
          evenLongestEndingIndex = end;
        }
        start--;
        end++;
      }
    }
    if (evenLongestSubString > oddLongestSubString)
      return A.substring(evenLongestStartingIndex, evenLongestEndingIndex + 1);
    else return A.substring(oddLongestStartingIndex, oddLongestEndingIndex + 1);
  }
}
