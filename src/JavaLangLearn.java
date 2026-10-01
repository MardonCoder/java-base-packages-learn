public class JavaLangLearn {
    public static void main(String[] args) {
        double d1 = 1 / 0.;
        System.out.println(Double.isInfinite(d1));
        System.out.println(d1);

        double d2 = 0/0.;
        System.out.println(d2);
        System.out.println(Double.isNaN(d2));

        byte b = Byte.valueOf("12");
        System.out.println(b);
    }
}


/*
isInfinite() - является ли число бесконечно большое или маленькое (double d1 = 1 / 0.;)
isNaN() - не число (double d2 = 0/0.;)

byte b = Byte.valueOf("12"); можно так создавать числа
.toBinaryString() - переводит в двоичную строку
.toOctalString() - восьмерична
.toHexString() - шестнадцатеричная

charValue() - для получения значений char
имеет много .is методов для проверки типа символа
чар для символов которые больше 16 бит (Unicode): в чар используя 2 переменные (как 2 регистра)


Программа запуска приложения NotePad
Runtime - текущее окружение, в котором запущено java приложение. Создаётся автоматически при запуске программы
можно получить через .getRuntime
Используется для: Управление памятью, Выполнение системных команд,Shutdown Hooks (Хуки завершения)

Runtime r = Runtime.getRuntime();
Process р = null ;
try {
    р = r.exec ( "notepad" ) ;
    p.waitFor(); // ждём завершения процесса
} catch ( Exception е ) {
    System.out.println("Ошибка при выполнении notepad.");
}
System.out.println("Программа notepad возвратила " + p.exitValue());

ProcessBuilder - ещё одни способ запуска процессов и более подробного управления ими.
try {
    ProcessBuilder proc = new ProcessBuilder ("notepad.exe","testfile");
    proc.start(); // testfile - параметр, имя файла подлежащий редактированию
} catch (Exception е) {
System.out.println("Ошибка при выполнении notepad.");


arraycopy() - копирования данных из одного массива в другой: System.arraycopy(a, О,b, О, a.length);
clone() - создаёт дубликат объекта (потенциально опасно)


ThreadGroup - класс создания группы потоков, родительским потоком может быть нынешний или указанный в
конструкторе. ThreadGroup(String groupName) | ThreadGroup(ThreadGroup parentOЬ, String groupName)
Позволяет управлять группой потоков как единым целым. Группа потока указывается при его создании


 */