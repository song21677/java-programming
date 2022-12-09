package control_string.control_string_2;

import java.io.*;
import java.util.Scanner;

// Lesson: 파일 출력, 단어 찾기, 모듈화
// Program
// $ read sample.txt
// 입력으로 하나의 텍스트 파일(sample.txt)을 읽는다.
// 텍스트 파일에 등장하는 모든 단어들의 목록을 만들고, 각 단어가 텍스트 파일에 등장하는 횟수를 센다.
// 단, 단어 개수는 100,000개 이하라고 가정한다.

// $ saveas index.txt
// 사용자가 요청하면 단어 목록을 하나의 파일(index.txt)로 저장한다.

// $ find 무궁화
// 사용자가 단어를 검색하면 그 단어가 텍스트 파일에 몇 번 등장하는지 출력한다.
// The word "무궁화" appears 4 times.

// $ exit
// 프로그램을 종료한다.

public class Code3 {
    static String [] words = new String [100000];

    // c와 다르게 java에선 정수형 변수는 초기화해주지 않아도 0으로 초기화된다.
    static int [] count = new int [100000];

    static int n = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while(true) {
            System.out.print("$ ");
            String command = kb.next();
            if(command.equals("read")) {
                String fileName = kb.next();
                // makeIndex: 단어 목록 만드는 함수
                makeIndex(fileName);
            }
            else if(command.equals("find")) {
                String str = kb.next();
                // findWord: 단어 찾는 함수
                int index = findWord(str);
                if(index>-1) {
                    System.out.println("The word \"" + words[index] + "\" appears " + count[index] + " times.");
                }
                else System.out.println("The word \"" + str + "\" does not appear.");
            }
            else if(command.equals("saveas")) {
                String fileName = kb.next();
                // saveAs: 단어목록 저장하는 함수
                saveAs(fileName);
            }
            else if(command.equals("exit"))
                break;
        }
        kb.close();

//        for (int i=0; i<n; i++)
//            System.out.println(words[i] + " " + count[i]);
    }

    // makeIndex: 단어 목록 만드는 함수
    static void makeIndex(String fileName) {

        try {
            Scanner inFile = new Scanner(new File(fileName));
            // hasNext(): 파일 끝에 도달했는지 알려주는 함수
            while(inFile.hasNext()) {
                String str = inFile.next();
                // addWord
                // 읽은 단어가 단어목록에 없다면 추가,
                // 단어목록에 있다면, 갯수 늘리기
                addWord(str);
            }
            inFile.close();
        // 파일을 찾지 못했을 때 처리 방법
        } catch (FileNotFoundException e) {
            System.out.println("No file");
            return;
        }
    }

    // addWord
    // 읽은 단어가 단어목록에 없다면 추가,
    // 단어목록에 있다면, 갯수 늘리기
    static void addWord(String str) {
        int index = findWord(str);  // return -1 if not found
        if (index != -1) {  // found words[index] == str
            count[index]++;
        }
        else {  // not found
            words[n] = str; // c에서는 strdup()을 사용해야 한다.
            count[n] = 1;
            n++;
        }
    }

    // findWord: 단어 찾는 함수
    static int findWord(String str) {
        for(int i=0; i<n; i++)
            // equalsIgnoreCase: 대소문자 구분 x
            if(words[i].equalsIgnoreCase(str))
                return i;
            return -1;
    }

    // saveAs: 단어목록 저장하는 함수
    static void saveAs(String fileName) {
        // 파일로 출력
        PrintWriter outFile;
        try {
            outFile = new PrintWriter(new FileWriter(fileName));
            for(int i=0; i<n; i++)
                outFile.println(words[i] + ", " + count[i]);
            outFile.close();
            // file이 생성되지 않았을 때
        } catch (IOException e) {
            System.out.println("save failed");
            return;
        }
    }
}
