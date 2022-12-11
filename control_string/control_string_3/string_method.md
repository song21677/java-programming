## String 클래스 기본 메서드



|기능|           함수 원형            |                                                                                     예시                                                                                     |   result    |
|:---:|:--------------------------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------:|
|문자열 동일성 검사|   boolean equals(String)   |                                        String str1 = "java"; <br/> String str2 = "java"; <br/> boolean result = str1.equals(str2);                                         |    true     |
|문자열 사전식 순서|   int compareTo(String)    | String str1 = "absolute"; <br/> String str2 = "absolutely"; <br/> String str3 = "apple"; <br/> int result = str1.compareTo(str2); <br/> int result = str1.compareTo(str3); | 2 <br/> -14 |
|문자열 길이|        int length()        |                                                          String str = "abcdef"; <br/> int result = str.length();                                                           |      6      |
|특정 위치의 문자 |      char charAt(int)      |                                                         String str = "ABCDEFG"; <br/> char result = str.charAt(2);                                                         |      C      |
|지정한 문자의 위치 검색|     int indexOf(char)      |                                                        String str = "abcdef"; <br/> int result = str.indexOf("d");                                                         |      3      |
|지정된 범위의 부분 문자열| String substring(int, int) |                                                     String str = "ABCEDF"; <br/> String result = str.substring(0, 2);                                                      |     AB      |

