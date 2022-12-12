import java.io.*;
import java.util.Scanner;

// Program: 개선된 IndexMaker
// 단어의 앞뒤에 붙은 특수문자, 숫자 제거하기
// 대문자와 소문자를 같은 단어로 취급하기
// 단어들을 알파벳 순으로 정렬하기

public class Code04 {
    static String [] words = new String [100000];

    static int [] count = new int [100000];

    static int n = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while(true) {
            System.out.print("$ ");
            String command = kb.next();
            if(command.equals("read")) {
                String fileName = kb.next();
                makeIndex(fileName);
            }
            else if(command.equals("find")) {
                String str = kb.next();
                int index = findWord(str);
                if(index>-1) {
                    System.out.println("The word \"" + words[index] + "\" appears " + count[index] + " times.");
                }
                else System.out.println("The word \"" + str + "\" does not appear.");
            }
            else if(command.equals("saveas")) {
                String fileName = kb.next();
                saveAs(fileName);
            }
            else if(command.equals("exit"))
                break;
        }
        kb.close();
    }

    static void makeIndex(String fileName) {

        try {
            Scanner inFile = new Scanner(new File(fileName));
            while(inFile.hasNext()) {
                String str = inFile.next();
                String trimmed = trimming(str);

                // 아래 코드를 추가해주지 않으면, null을 addWord하여
                // findWord에서 equals할 때, NullPointerException이 발생한다.
                // NullPointerException: 실제 값이 아닌 null을 가지고 있는 객체/변수를 호출할때 발생하는 예외
                if (trimmed!=null) {
                    // 대문자와 소문자를 같은 단어로 취급하기
                    String t = trimmed.toLowerCase();
                    addWord(t);
                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
            return;
        }
    }

    static String trimming(String str) {
        int i=0, j=str.length()-1;

        // 단어의 앞뒤에 붙은 특수문자, 숫자 제거하기
        // while i-th character is not letter
        while( i<=str.length()-1 && !Character.isLetter(str.charAt(i) ) )
            i++;

        while( j>=0 && !Character.isLetter( str.charAt(j) ) )
            j--;

        // System.out.println(str + ":" + i + ":" + j);
        // "3." 이라는 단어를 만났을 때, i=2, j=1이다.
        // 아래 코드를 추가하지 않으면, str.substring(i, j+1)에서 StringIndexOutOfBoundsException이 발생한다.
        if(i>j)
            return null;

        return str.substring(i, j+1);
    }

    static void addWord(String str) {
        int index = findWord(str);
        if (index != -1) {
            count[index]++;
        }
        else {
            // 단어 정렬하기
            // ordered list에 insert하기
            // 앞에서부터 검사하기 vs 뒤에서부터 검사하기 => 후자!
            int i=n-1;
            while(i>=0 && words[i].compareTo(str)>0) {
                words[i+1]=words[i];
                count[i+1]=count[i];
                i--;
            }
            words[i+1]=str;
            count[i+1]=i;
            n++;
        }
    }

    static int findWord(String str) {
        for(int i=0; i<n; i++)
            if(words[i].equals(str))
                return i;
        return -1;
    }

    static void saveAs(String fileName) {
        PrintWriter outFile;
        try {
            outFile = new PrintWriter(new FileWriter(fileName));
            for(int i=0; i<n; i++)
                outFile.println(words[i] + ", " + count[i]);
            outFile.close();
        } catch (IOException e) {
            System.out.println("save failed");
            return;
        }
    }
}
