import java.io.*;

class MyClass implements Serializable{
    String s;
    int i;
    double d;

    public MyClass(String s, int i, double d){
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString(){
        return "s = %s, i = %d, d = %f".formatted(this.s, this.i, this.d);
    }
}

public class javaIOLearn {
    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serial"))){
            MyClass mc = new MyClass("Mardon", 19, 2.5);
            System.out.printf("До сериализации: %s\n", mc);
            oos.writeObject(mc);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serial"))){
            MyClass mc = (MyClass) ois.readObject();
            System.out.printf("После сериализации: %s\n", mc);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // фильтр
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serial"))){
            ObjectInputFilter myFilter = ObjectInputFilter.Config.createFilter("MyClass;!*");
            ois.setObjectInputFilter(myFilter);
            MyClass mc = (MyClass)ois.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

/*
File - описывает свойства файла, применяется для получения и управления информации связанной с файлом
Каталог в java - файл со списком имён файлов.
        File f1 = new File ("/"); // файл каталога
        File f2 = new File ("/", "autoexec.bat"); // сам файл 'autoexec.bat' по адресу '/'
        File fЗ = new File (f1, "autoexec.bat"); // сам файл, который в файле каталога f1
Имеет много геттеров для получения адреса, имени и т.д. (.renameTo(), .delete(), .isDirectory() и .isFile())
.list() список файлов в директории если файл является директорией
.list(FilenameFilter FFObj) - возвращает только определённые файлы
этот интерфейс имеет единственный метод boolean accept(File directory, String filename)
.mkdir() и mkdirs() - создаёт папки внутри каталога
.mark(int readlimit) - позволяет запомнить текущую позицию в потоке и вернуться к ней позже (не все потоки
поддерживают), readlimit - указывает сколько байт можно прочитать, прежде чем метка будет недействительной
.reset() - возвращает к метке (используется обычно в парсинге для преждевременного чтения и возвращения)


Flushable() - интерфейс механизма очистки буфера через метод .flush()
Когда мы записываем данные в буферизированный поток, данные не отправляются, а скапливаются в массиве во внутреннем
массиве байт (буфере), ради оптимизации, тк операции ввода/вывода дорогие. С помощью метода flush() мы очищаем
буфер и отправляем эти данные

FileNotFoundException - подкласс IOException и может быть перехвачен выше

Традиционный способ закрытия потоков совместимый со всеми версиями java:
try {
    ...
    myStream
    ...
} catch(IOException e){
    ...
} finally{
    try{
        if(myStream != 0) mySteam.close();
    } catch(IOException){ // ошибка закрытия потока
        ...
    }
}

ByteArrayInputStream - поток ввода использующий байтовый массив как источник. При создании требует массив байтов
ByteArrayOutputStream - наоборот вводит данные в массив байтов
Не требуют вызова close()


Фильтрующие потоки данных - оболочки базовых потоков, расширяющие функционал(буферизация, трансляция,
преобразование). Для работы они используют обобщённый поток

FilterInputStream и его аут - фильтрующие байтовые потоки. В constr требуют сам поток

Буферизированный поток - расширяет класс фильтрующего потока и использует буффер для оптимизации:
BufferedInputStream и его аут. Позволяет помещать любой объект InputStream в свою оболочку
BufferedInputStream (InputStream inputStream, int bufSize) можно не указывать bufSize

PushbackInputStream - реализует обратную передачу и делает .mark и ресет недействительными
Обратная передача (Pushback) - позволяет прочитать байт входного потока и вернуть его обратно (быстрый просмотр
того, что что поступает из входного потока, не нарушая его работу)
.unread() - обратная передача байтов. Просмотрели байт и обратно его засунули в поток


SequenceInputStream - объединяет множество потоков (принимает либо пару потоков, либо перечисление)
Выполняет запросы на чтение из первого потока пока он не закончится. Затем переходит на следующий до конца
По достижении конца всего поток закрывается и закрывает все связанные потоки

PrintStream - вывод как из system.out (он объект PrintStream)

DataInputStream и аут - запись/чтение примитивных данных в поток. При создании нужно указать поток куда идёт запись

RandomAccessFile - файл с произвольным доступом. При создании нужно указывать доступ r/w/rw
.seek() - указывает позицию в файле от начала


            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~СИМВОЛЬНЫЕ ПОТОКИ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
FileReader и врайтер - чтение и запись в файл. Если файла нет при создании врайтера, он автоматом создастся

CharReader и врайтер - потоки для символьных массивов

PushbackReader - тоже что и в байтах

PrintWriter - принтстрим, но для символов


Console - используется для чтения и записи консоли. Получается через System.console()
        Console c = System.console();
        String str = c.readLine("Enter your name: ");
        c.printf("Твоё имя %s", str);


Сериализация - процесс записи состояния объекта в байтовый поток. Необходима для удалённого вызова метода (Remote
Method Invocation: RMI), позволяет объекту на одной машине вызвать метод на другой машине. Программа сериализует
объект и отправляет другой программе, которая десериализует его и помещает в аргументы метода.

Допустим сериализуемый объект имеет ссылки на другие объекты, а они ещё на другие. Тем самым образуется
ориентированный граф. В нём могут быть циклические ссылки на объекты друг друга и на самих себя. Средства
сериализации правильно работают в таких ситуациях. Сериализация и десериализация объекта в верхней части графа
де/сериализует все остальные объекты.

Средства сериализации работают только с объектами реализующие интерфейс Serializable. В нём никакие члены не
определены. Он просто указывает что класс можно сериализовать. И все его подклассы тоже сериализуемы. Сохраняются
все переменные экземпляра при сериализации, кроме static и transient.

Externalizable - позволяет контролировать автоматический процесс de/ser-n:
void readExternal(ObjectInput inStream) - inStream байтовый поток из которого должен быть прочитан объект
void writeExternal(ObjectOutput outStream) - то же самое куда должен быть записан

ObjectOutput - интерфейс расширяет DataOutput, поддерживает сериализацию:
.writeObject() - записывает объект в поток

ObjectOutputStream - реализует этот интерфейс и расширяет OutputStream, отвечает за запись объектов в поток
ObjectInput и ObjectInputStream - same, имеет .readObject()

import java.io.*;

class MyClass implements Serializable{
    String s;
    int i;
    double d;

    public MyClass(String s, int i, double d){
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString(){
        return "s = %s, i = %d, d = %f".formatted(this.s, this.i, this.d);
    }
}

public class javaIOLearn {
    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serial"))){
            MyClass mc = new MyClass("Mardon", 19, 2.5);
            System.out.printf("До сериализации: %s\n", mc);
            oos.writeObject(mc);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serial"))){
            MyClass mc = (MyClass) ois.readObject();
            System.out.printf("После сериализации: %s\n", mc);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

фильтр десериализации - некоторый контроль над процессом. Например, проверка на класс:
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serial"))){
            ObjectInputFilter myFilter = ObjectInputFilter.Config.createFilter("MyClass;!*");
            ois.setObjectInputFilter(myFilter);
            MyClass mc = (MyClass)ois.readObject();
        } catch (Exception e){ // !* - означает отбросить все остальные классы
            e.printStackTrace(); // ! - отбросить класс, * - все классы
        }

Можно определить фильтр на уровне машины JVM, который будет использоваться во всех объектах O.I.S. :
ObjectInputFilter.Config.setSerialFilter(myFilter) - нужно указать до создания потока
Фильтры устанавливаются только один раз

Значения фильтров укзаываются через ';' с помощью разных шаблонов: "MyClass;!*;maxbytes=80"
 */







