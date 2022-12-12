## C vs Java

<table>
    <tr align="center">
        <td colspan="2">구분</td>
        <td>C</td>
        <td>Java</td>
    </tr>
    <tr align="center">
        <td rowspan="2">프리미티브 타입<br/>(int, double, char...)</td>
        <td >보통 변수</td>
        <td>int a = 10; <br/>
            char ch = 'x';
        </td>
        <td>int a = 10; <br/>
            char ch = 'x';
        </td>
    </tr>
    <tr align="center">
        <td >참조 변수(포인터)</td>
        <td>int *p;<br/>
            char *q;
        </td>
        <td>X</td>
    </tr>
    <tr align="center">
        <td rowspan="2">사용자 정의 타입<br/>(struct, class)</td>
        <td >보통 변수</td>
        <td>struct person a; <br/>
            a.name = "John"; <br/>
            a.number = "01012345678";
        </td>
        <td>X</td>
    </tr>
    <tr align="center">
        <td >참조 변수(포인터)</td>
        <td>struct person *a;<br/>
            a = malloc(sizeof(...));<br/>
            a->name = "John"; <br/>
            a->number = "01012345678";
        </td>
        <td>Person b;<br>
            b = new Person(); <br>
            b.name = "David"; <br>
            b.number = "01023456789";</td>
    </tr>
</table>