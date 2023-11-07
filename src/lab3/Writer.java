package lab3;

public class Writer //Клас призначений для спрощення форматованого виводу в консоль
{
    private static Writer instance;

    public void writeSpacer() //Роздільник із "-" або іншого символа
    {
        writeSpacer("-");
    }
    public void writeSpacer(String token) //Роздільник із "-" або іншого символа
    {
        System.out.println(token.repeat(80));
    }

    public <T> void print(String name, T[] array)
    {
        System.out.print(name + ": ");

        for (T element : array)
            System.out.print(element.toString() + " ");

        System.out.print("\n");
        writeSpacer();
    }

    private Writer() {}

    public static Writer getInstance()
    {
        if (instance == null)
            instance = new Writer();

        return instance;
    }
}