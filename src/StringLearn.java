public class StringLearn {
    public static void main(String[] args) {
        String s = new String();
        char[] chars = {'a','b','c','d','e','f','g'};
        String s2 = new String(chars);
        System.out.println(s2);

        String s3 = new String(chars, 2, 4);
        System.out.println(s3);

        byte[] ascii = {65,66,67,68,69,70,71,72,73};
        String s4 = new String(ascii);
        String s5 = new String(ascii, 2, 5);
        System.out.println(s4);
        System.out.println(s5);

        String s6 = "Четыре: "+2+2;
        System.out.println(s6);

        String s7 = "Четыре: "+(2+2);
        System.out.println(s7);
    }
}

/*
Строки неизменяемы ради оптимизации, но есть классы StringBuffer и StringBuilder для таких задач
CharSequence - интерфейс реализуется всеми строковыми классами
String s = new String();                        // пустая строка ( "" )

char[] chars = {'a','b','c','d','e','f','g'};
String s2 = new String(chars);                  // создание строки из массива символов
String s3 = new String(chars, 2, 4) // Создание строки из массива символов, 4 символа со 2-ого индекса (cdef)

byte[] ascii = {65,66,67,68,69,70,71,72,73}; // можно использовать символы из ascii с помощью byte
String s4 = new String(ascii);
String s5 = new String(ascii, 2, 5);

String(int[] codePoints, int startIndex, int numChars) // для Unicode

String s6 = "Четыре: "+2+2; // "Четыре: 22", т.к. конкатенация срабатывает первой
String s7 = "Четыре: "+(2+2); // "Четыре: 4", теперь сложение чисел срабатывает первой


                 ~~~~~~~~~~~~~~~~~~~~~~~~~~~МЕТОДЫ СТРОК~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
toString() - метод каждого класса (тк он в Object). Тем самым объекты классов могут использовать как строки

void getChars(int sourceStart, int sourceEnd, char [] target, int targetStart) - извлекает из строки массив
символов по индексам start/end и помещает в массив символов target по индексу targetStart
byte[] getBytes() - сохраняет символы в массиве байтов (есть разные вариации этого метода)
char[] toCharArray() - преобразует в массив чаров

boolean regionMatches(int startIndex, String str2 , int str2StartIndex, int numChars) - сравнивает области
boolean regionMatches(boolean ignoreCase, int startIndex, ...) - то же самое, но ignoreCase
startsWith() и endsWith() - начинается/заканчивается ли строка с определенной строки
boolean startsWith(String str, int startIndex) - то же самое но с индексом начала проверки

String s1 = "Hello";
String s2 = new String(s1); // equals вернёт true, == вернёт false

int compareTo(String str) - '>0' вызывающая строка больше; '<0' меньше; 0 - строки равны
Символы с одинаковым количеством строк будут сравниваться по индексу букв
compareToIgnoreCase(String str) - игнорирует регистр

int indexOf(String str, int startIndex ) - можно указывать начало поиска и поиск подстроки
String substring (int startIndex, int endIndex ) - извлечь подстроку
String concat (String str) - конкатенация (аналогично с "+")

trim() - удаляет пробелы в начале и в конце
strip() - удаляет пробельные символы в начале и в конце (таб, пробел, возврат каретки, перевод строки, ...)
stripLeading() и stripTrailing() - strip вначале или в конце
stripIndent() - сохраняет осмысленные отступы
translateEscapes() - заменяет esc последовательности на их символы

valueOf() - переводит примитивные типы в str (но ещё перегружен и для Object (вернёт .toString значение))
для символьных массивов работает как конструктор String
static String valueOf(char[] chars, int startIndex, int numChars) - то же самое как и функция выше

static String join ( CharSequence delim, CharSequence... strs) - соединяет строки через delim

.formatted() - форматирует строку как printf

                 ~~~~~~~~~~~~~~~~~~~~~~~~~класс StringBuffer~~~~~~~~~~~~~~~~~~~~~~~~~
Дэфолт конструктор резервирует место для 16 символов
StringBuffer(int size) - резервирует размер в size символов
StringBuffer(String str) - сохраняет строки и дополнительно ещё место для 16 символов резервирует
StringBuffer(CharSequence chars) - то же самое

length() - возвращает длину строки, capacity() - размер памяти
void ensureCapacity(int minCapacity) - задаёт минимальный размер буфера
void setLength(int len) - задаёт размер строки (вырезает или добавляет символы если строка отличается)
setCharAt(int where, char ch) - задаёт символ по адресу
void getChars(int sourceStart, int sourceEnd, char [] target, int targetStart)

String s;
int а = 42;
StringBuffer sb = new StringBuffer(40);
s = sb.append("а = ").append(a).append("!").toString(); метод добавления в буфер
System.out.println(s); // а = 42!

insert() - вставляет в строку ещё строку (или другие примитивычи)
reverse()
StringBuffer delete(int startIndex, int endIndex)
StringBuffer deleteCharAt(int loc)
StringBuffer replace(int startIndex, int endIndex, String str ) - заменяет


                ~~~~~~~~~~~~~~~~~~~~~~~~~класс StringBuilder~~~~~~~~~~~~~~~~~~~~~~~~~
Не синхронизирован в отличии от Buffer, но выше производительность. А так схож с предыдущим классом

*/











