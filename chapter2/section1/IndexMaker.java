import java.io.*;
import java.util.Scanner;

// Program
// 인덱스 메이커 프로그램의 수정
public class IndexMaker {
    // Item 클래스 정의로 인해 line 8과 9를 11에서 한번에 정의할 수 있다.
    // static String [] words = new String [100000];
    // static int [] count = new int [100000];

    static Item [] items = new Item[100000];
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
                    System.out.println("The word \"" + items[index].word + "\" appears " + items[index].count + " times.");
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

                if (trimmed!=null) {
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

        while( i<=str.length()-1 && !Character.isLetter(str.charAt(i) ) )
            i++;

        while( j>=0 && !Character.isLetter( str.charAt(j) ) )
            j--;

        if(i>j)
            return null;

        return str.substring(i, j+1);
    }

    static void addWord(String str) {
        int index = findWord(str);
        if (index != -1) {
            items[index].count++;
        }
        else {
            int i=n-1;
            while(i>=0 && items[i].word.compareTo(str)>0) {
                // Item 클래스 정의로 인해 line 85와 86을 87에서 한번에 실행할 수 있다.
                // words[i+1]=words[i];
                // count[i+1]=count[i];
                items[i+1] = items[i];
                i--;
            }
            // 맨 뒤에 단어를 추가할 때, 참조 변수는 null을 가리키므로
            // 이 경우를 대비해 객체를 생성해준다.
            items[i+1] = new Item();
            items[i+1].word=str;
            items[i+1].count=1;
            n++;
        }
    }

    static int findWord(String str) {
        for(int i=0; i<n; i++)
            if(items[i].word.equals(str))
                return i;
        return -1;
    }

    static void saveAs(String fileName) {
        PrintWriter outFile;
        try {
            outFile = new PrintWriter(new FileWriter(fileName));
            for(int i=0; i<n; i++)
                outFile.println(items[i].word + ", " + items[i].count);
            outFile.close();
        } catch (IOException e) {
            System.out.println("save failed");
            return;
        }
    }
}
