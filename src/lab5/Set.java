package lab5;

import java.util.Arrays;

public class Set <T> //Множина
{
    private T[] set;

    public T[] getSet() { return set; }

    public void setSet(T[] set) //В цьому сетері проводиться видалення всіх дублікатів із вхідного масиву
    {
        int size = set.length; //Кількість елементів множини

        for (int i = 0; i < size; i++) //Ітерація всіх вхідного елементів масиву
        {
            for (int j = i + 1; j < size; j++) //Ітерація всіх елементів після поточного
            {
                if (set[j].equals(set[i])) //Звіряння елементів з поточним
                {
                    for (int k = j + 1; k < size; k++) //Видалення елемента і зсунення наступних
                        set[k - 1] = set[k];

                    size--; //Зменшення розміру множини через видалення елемента
                    j--; //Повернення ітератора на попередню позицію
                }
            }
        }

        this.set = Arrays.copyOf(set, size); //Створення множини шляхом обрізання вхідного масива
    }

    public boolean contains(T value) //Перевіряє наявність у множині відповідного елемента
    {git add out/production/Labs/lab5/Main.class out/production/Labs/lab5/Operation.class out/production/Labs/lab5/Set.class src/lab5/Operation.java src/lab5/Set.java
        for (T element : set)
            if (element == value) return true;

        return  false;
    }

    public Set(T[] set)
    {
        setSet(set);
    }
}