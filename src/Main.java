import java.util.*;

public class Main {
    public static void main(String[] args) {

        String correctWord = "nissan";

        int tryCount = 0;
        boolean isWordCorrect = false;
        char[] correctWordArr = new char[correctWord.length()];
        Arrays.fill(correctWordArr, '_');

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter char:");
            char input = sc.next().charAt(0);

            char[] update = fillCorrectWordArray(input, correctWordArr, correctWord);
            tryCount = update == null ? tryCount + 1 : tryCount;

            System.out.println("try count is " + tryCount);
            if (tryCount >= 3) {
                System.out.println("Game over");
                break;
            }

            correctWordArr = update == null ? correctWordArr : update;
            isWordCorrect = !Arrays.asList(correctWordArr).contains('*');

            System.out.println(Arrays.toString(correctWordArr));

//            if(isWordCorrect) {
//                System.out.println("hooorey....");
//                break;
//            }

        }


    }

    static char[] fillCorrectWordArray(char input, char[] correctWordArr, String correctWord) {

        char[] updatedCorrectWordArr = correctWordArr.clone();
        int index = correctWord.indexOf(input);
        while (index >= 0) {
            updatedCorrectWordArr[index] = input;
            index = correctWord.toLowerCase().indexOf(input, index + 1);
        }
        if (Arrays.equals(updatedCorrectWordArr, correctWordArr)) {
            return null;
        }
        return updatedCorrectWordArr;
    }
}
