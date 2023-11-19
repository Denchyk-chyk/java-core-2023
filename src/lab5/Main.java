package lab5;

import lab3.Printer;

import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        //Тестові дані
        print(new Set<>(new Integer[] {1, 3, 5, 7, 9}), new Set<>(new Integer[] {1, 2, 3, 5, 7})); //Непарні та прості числа < 10
        print(new Set<>(new Character[] {'q', 'w', 'e', 'r', 't', 'y'}), new Set<>(new Character[] {'v', 'a', 'r', 'i', 'e', 't', 'y'})); //Слова 'qwerty' та 'veriaty'

        while (true) print(); //Ввід даних з консолі
    }

    private static void print() //Створення двох числових та символьних множин і проведення операцій над ними
    {
        //Числові множини
        Set<Integer> aInt = readIntegers("Перша цілочисельна множина");
        Set<Integer> bInt = readIntegers("Друга цілочисельна множина");
        print(aInt, bInt);

        //Символьні множини
        Set<Character> aChar = readCharacters("Перша символьна множина");
        Set<Character> bChar = readCharacters("Друга символьна множина");
        print(aChar, bChar);
    }

    private static Set<Integer> readIntegers(String header) //Створює множину чисел з рядка в консолі
    {
        System.out.println(header + ":"); //Вивід заголовка
        ArrayList<Integer> numbers = new ArrayList<>(); //Ініціалізація списку
        Scanner scanner = new Scanner(new Scanner(System.in).nextLine()); //Ініціалізація сканера для зчитування чисел з рядка з консолі

        while (scanner.hasNextInt()) //Запис всіх чисел з рядка в список
            numbers.add(scanner.nextInt());

        return new Set<>(numbers.toArray(new Integer[0])); //Створення множини зі списку
    }

    private static Set<Character> readCharacters(String header)  //Створює множину символів з рядка в консолі
    {
        System.out.println(header + ":");  //Вивід заголовка
        String text = new Scanner(System.in).nextLine(); //Зчитування рядка з консолі
        ArrayList<Character> characters = new ArrayList<>(); //Ініціалізація списку

        for (int i = 0; i < text.length(); i++) //Запис кожного символа з рядка в список
            characters.add(text.charAt(i));

        return new Set<>(characters.toArray(new Character[0])); //Створення множини зі списку
    }

    private static <T> void print(Set<T> a, Set<T> b) //Здійснює всі дії з множинами
    {
        Printer writer = Printer.getInstance(); //Клас для виводу масивів

        //Вивід множин
        writer.print("A", a.getSet());
        writer.print("B", b.getSet());

        //Вивід результатів операцій
        writer.print("A ∪ B", Operator.unionSets(a, b).getSet());
        writer.print("A ∩ B", Operator.intersectionSets(a, b).getSet());
        writer.print("A \\ B", Operator.differanceSets(a, b).getSet());
        writer.print("B \\ A", Operator.differanceSets(b, a).getSet());
        writer.print("", Operator.symmetricDiffSets(a, b).getSet());
    }
}