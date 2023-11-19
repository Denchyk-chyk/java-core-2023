package lab3;

public class Printer //Клас призначений для спрощення форматованого виводу в консоль
{
    private static Printer instance;

    public void printSpacer() //Роздільник із "-" або іншого символа
    {
        printSpacer("-");
    }
    public void printSpacer(String token) //Роздільник із "-" або іншого символа
    {
        System.out.println(token.repeat(80));
    }

    public void printHeader(String header, boolean top, boolean bottom)
    {
        if (top) printSpacer();
        System.out.println(header);
        if (bottom) printSpacer();
    }

    public <T> void print(String name, T[] array)
    {
        System.out.print(name + ": ");

        for (T element : array)
            System.out.print(element.toString() + " ");

        System.out.print("\n");
        printSpacer();
    }

    private Printer() {}

    public static Printer getInstance()
    {
        if (instance == null)
            instance = new Printer();

        return instance;
    }
}