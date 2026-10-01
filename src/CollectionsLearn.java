import java.util.*;


// Компаратор, который сохраняет элементы в обратном порядке
class MyComp implements Comparator<String>{
    @Override
    public int compare(String aStr, String bStr){
        return bStr.compareTo(aStr);
    }
}
public class CollectionsLearn {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>(new MyComp());
        ts.addAll(Set.of("A", "B", "C", "D", "E", "F"));
        ts.forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");

        // тот же компаратор, но наоборот будет в порядке алфавита
        Comparator<String> c =(aStr, bStr) -> bStr.compareTo(aStr);
        TreeSet<String> ts2 = new TreeSet<>(c.reversed());
        ts2.addAll(ts);
        ts2.forEach(System.out::println);
    }
}

// collections
/*
Collection - интерфейс, основа всех коллекций
AbstractCollection - класс, реализует большую часть интерфейса Collection
AbstractQueue - наследует AbstractCollection, реализует часть Queue
AbstractSet - наследует AbstractCollection, реализует большую часть Set
AbstractList - наследует от AbstractCollection, реализует большую часть List
AbstractSequentialList - наследует AbstractList, последовательный доступ к элементам

ArrayDequeue - динамическая двусторонняя очередь, от AbstractCollection и интерфейса Dequeue
EnumSet - наследует AbstractSet, используется с перечислениями


ArrayList:
Динамический массив, наследует AbstractList, который может увеличиваться или уменьшаться от
добавления/удаления элементов
ArrayList()
ArrayList(Collection<? extends Е> с)
ArrayList(int capacity)

void ensureCapacity(int сар) - увеличивает ёмкость списка, если мы знаем что будем много добавлять
trimToSize() - уменьшает ёмкость до размера списка
toArray() - преобразует в обычный массив типа Object
ia = al.toArray(ia); - современный способ с указанием типа
String[] result = al.toArray(new String[0]); - более быстро и рекомендуется так
al.toArray(new T[size]) - использовать уже созданный массив


LinkedList:
add() - вставка элементов в лист по индексу или в конец
set() - изменение уже существующего элемента
связанный список, наследует от AbstractSequentialList

HashSet - наследует AbstractSet, для хэш таблиц:
HashSet(int capacity)
HashSet(int capacity, float fillRatio) - коэффициент заполнения (0.0-1.0) насколько полной может быть таблица
перед увеличением её размера (0.75 дефолтно)

LinkedHashSet:
Аналогичные конструкторы, элементы отображаются в порядке их добавления наследует HashSet, итерация в
порядке вставки

TreeSet - наследует AbstractSet, дерево:
всё хранится в отсортированном порядке по возрастанию. Быстрый доступ и извлечение. Подходит для организации
и хранения больших объёмов отсортированной информации с быстрым поиском. Можно создавать сабсеты

PriorityQueue - наследует AbstractQueue, очередь на основе приоритетов:
при создании можно указывать компаратор для расстановки приоритета элементов


                       ~~~~~~~~~~~~~~~~~~~ Итератор ~~~~~~~~~~~~~~~~~~~
ИТЕРАТОР - позволяет циклически проходить по коллекции получая или удаляя элементы.
.iterator() - метод в каждой коллекции, возвращает итератор для начала коллекции
.listIterator() - имеется у списков, позволяет обращаться к элементу с конца
.hasNext() - возвращает true если есть следующий элемент
.next() - возвращает следующий элемент списка до конца
.set() - изменяет текущий элемент
.remove() - удаляет из списка текущий элемент
.previous() - уходит назад
.add() - добавляет элемент перед следующим next элементом
.default void forEachRemaining(Consumer<? super Е> action) - действие для каждого оставшегося
int nextIndex() - индекс следующего
previousIndex()

        Использование итератора
        ArrayList<String> al = new ArrayList<>(List.of("A","B","C","D","E","F","G","H"));
        Iterator<String> alItr = al.iterator();
        String el;
        while(alItr.hasNext()){
            el = alItr.next();
            System.out.print(el+" ");
        }

        ListIterator<String> alListItr = al.listIterator();
        int i = 1;
        while (alListItr.hasNext()){
            el = alListItr.next();
            alListItr.set(el+i);
            i++;
        }


                          ~~~~~~~~~~~~~~~~~~~ Сплитератор ~~~~~~~~~~~~~~~~~~~
схож с итератором, но имеет больше функциональных возможностей и поддерживает параллельную итерацию
characteristics() - получить характеристики сплитератора
hasCharacteristics() - узнать присутствует ли характеристика
estimateSize() - возвращает количество элементов оставшихся для итерации
getExactSizeIfKnown() - оставшееся количество элементов, которые нужно подвергнуть итерации
boolean tryAdvance(Consumer<? super Т>action) - действие над следующим элементом итерации
возвращает true/false если элемент есть/нет
Spliterator<T>trySplit() - разбивает сплитератор на части и возвращает ссылку на новый для части
Исходный сплитератор проходит по одной части последовательности, а возвращаемый по другой

Для обычного использования просто вызываем tryAdvance() пока он не вернёт false или
для одного и того же действия forEachRemaining()

Применения действия обеспечивает обобщённый функциональный интерфейс Consumer ( void accept(T objRef) )

        ArrayList<String> al = new ArrayList<>(List.of("A","B","C","D","E","F","G","H"));
        Spliterator<String> splitr = al.spliterator();

        splitr.forEachRemaining(System.out::print);
        System.out.println();

        splitr = al.spliterator(); // каждый раз нужно создавать новый итератор/сплитератор
        ArrayList<String> alLow = new ArrayList<>();
        while(splitr.tryAdvance(n -> alLow.add(n.toLowerCase())));
        alLow.forEach(System.out::println);
*/

// работа с картами
/*
        РАБОТА С КАРТАМИ - они не поддерживают for-each штуки (итераторы и т.д.), кроме метода forEach
Не являются по сути коллекцией, т.к. не реализуют интерфейс collections

interface Мар<К, V> - для ключ-значений
put() - базовая функция для добавления пары ключ-значение
compute() - функция для вычисления нового значения определённому ключу
computeIfAЬsent() - то же самое, если значения нет по ключу
computeIfPresent() - если существует
containsKey() - есть ли ключ
containsValue() - same
copyOf() - возвращает неизменяемую копию мапы, указанной в параметрах
equals() - если мапа имеет те же элементы
forEach() - над каждым элементом действие
getOrDefault(Object k, V defVal )
keySet()
default V merge (K k, V v, BiFunction<? super V, ? super V, ? extends V> func) - если ключ k отсутствует,
добавляется новая пара k, v и возвращается v. Иначе func возвращает новое значение на основе старого,
ключ обновляется.
putAll()
putIfAbsent()
remove(Object k, Object v) - удаляет именно пару ключ значение
remove(Object k) - удаляет по ключу
replace() - замена по ключу/значению и тд, есть разные перегрузки
replaceAll() - заменяет все элементу на возвращение значения от функции
size() - кол-во пар
Collection<V> values() - коллекция со значениями

Интерфейс NаvigаblеМар - поддерживает извлечение элементов по совпадением с заданым ключом
ceilingEntry(), ceilingKey() - ищет наименьший ключ k который больше или равен
Интерфейс Мар.Entry - работа с элементами карт

КЛАССЫ:
AbstractMap - большая реализация интерфейса Map
EnumМap - для работы с перечисляемыми ключами
HashМap
treeMap - карты в древовидном порядке, все элементы отсортированы и быстрый доступ к элементам
WeakНashМap - хэш таблица со слабыми ключами (подвергает сборке мусора неиспользуемых элементов карт)
LinkedНashМap - расширяет HashMap (если order=true, то итерация в порядке последнего доступа, если
false, то в связанном списке в порядке вставки)
IdentityHashМap - использует равенство ссылок при сравнении документов

        HashMap<String, Integer> hm = new HashMap<>(Map.of(
                "Oleg", 12,
                "Mardon", 10,
                "Chebik", 19,
                "überraschung", 10
        ));
        // получить и отобразить множество элементов
        Set<Map.Entry<String, Integer>> es = hm.entrySet();
        es.forEach(System.out::println);


                   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Компараторы~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
TreeSet и TreeMap хранят значения в отсортированном порядке, который можно изменить с помощью компаратора
interface Comparator<T> с методами compare() и equals(), который можно не переопределять
reversed() - получить компаратор с обратным порядком (B перед A, C перед B...)
reverseOrder() и naturalOrder()
thenComparing() - другой вид сравнения если элементы равны

// Компаратор, который сохраняет элементы в обратном порядке
class MyComp implements Comparator<String>{
    @Override
    public int compare(String aStr, String bStr){
        return bStr.compareTo(aStr);
    }
}
public class CollectionsLearn {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>(new MyComp());
        ts.addAll(Set.of("A", "B", "C", "D", "E", "F"));
        ts.forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");

        // тот же компаратор, но наоборот будет в порядке алфавита
        Comparator<String> c =(aStr, bStr) -> bStr.compareTo(aStr);
        TreeSet<String> ts2 = new TreeSet<>(c.reversed());
        ts2.addAll(ts);
        ts2.forEach(System.out::println);
    }
}

Компараторы также можно использовать в методах сортировки как вид сортировки
*/

// Разные штуки
/*
Arrays - класс с разными удобными статическими методами для работы с массивами
.sort() - сортировать, можно поместить компаратор
.fill() - заполнить чем-то
.binarySearch() - бинарный поиск


*/






