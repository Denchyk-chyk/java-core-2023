package lab5;

import java.util.Arrays;

public class Operation <T>
{
    private int size;
    private T[] array;

    private Set<T> operationWithSets(Set<T> a, Set<T> b, int startSize, boolean incCondition, int sizeInc, int startIndex, Set<T> inner, Set<T> outer, boolean addCondition) //Метод, що є основою для всіх інших
    {
        size = startSize; //Кількість елементів у кінцевій множині
        //При об'єднанні це спочатку довжина множини A, яка потім ЗБІЛЬШИТЬСЯ залежно від значення B
        //При перетині це 0, який потім ЗБІЛЬШИТЬСЯ залежно від значення множини B
        //При відніманні це спочатку довжина множини A, яка потім ЗМЕНШИТЬСЯ залежно від значення множини B

        for (T element : b.getSet()) //Знаходження кількості елементів
        {
            //При об'єднанні довжина ЗБІЛЬШИТЬСЯ на 1, якщо A НЕ містить елемент з B
            //При перетині довжина ЗБІЛЬШИТЬСЯ на 1, якщо A містить елемент з B
            //При відніманні довжина ЗМЕНШИТЬСЯ на 1, якщо A містить елемент з B

            if (a.contains(element) == incCondition)
                size += sizeInc;
        }

        array = Arrays.copyOf(a.getSet(), size); //Створення кінцевої множини на основі множини A

        int i = startIndex; //Індекс, з якого починається ітерація масиву для додавання елементів
        //При об'єднанні це довжина множини A, оскількм вихідна множив вже містить всі її елементи
        //В інших випадках це 0

        for (T element : outer.getSet()) //Проводиться перевірка На наявність елементів із одніжї з мно;ин в іншій
        {
            //При об'єднанні ми додаємо елемент з B, якщо його НЕМА в A
            //При перетині ми додаємо елемент з B, якщо він Є в A
            //При об'єднанні ми додаємо елемент з A, якщо його НЕМА в И
            if (inner.contains(element) == addCondition)
            {
                array[i] = element; //Додавання елементів з множини outer
                i++; //Переміщення вказівника
            }
        }

        return new Set<T>(array); //Створення екземпляра класу Set на основі створеного масиву
    }

    public Set<T> unionSets(Set<T> a, Set<T> b) //Об'єднання множин
    {
        return operationWithSets(a, b, a.getSet().length, false,1, a.getSet().length, a, b, false);
    }

    public Set<T> intersectionSets(Set<T> a, Set<T> b) //Перетин множин
    {
        return operationWithSets(a, b, 0, true,1, 0, a, b, true);
    }

    public Set<T> differanceSets(Set<T> a, Set<T> b) //Різниця множин
    {
        return operationWithSets(a, b, a.getSet().length, true,-1, 0, b, a, false);
    }

    public Set<T> symmetricDiffSets(Set<T> a, Set<T> b) //Симетрична різниця множин
    {
        return differanceSets(unionSets(a, b), intersectionSets(a, b)); //A ∆ B = (A ∪ B) - (A ∩ B)
    }
}