package lab4;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        Driver[] drivers = new Driver[] { //Масив водіїв
            new Racer("Льюіс", "Гамільтон", Mark.MB, "W12", "сріблястий", "Mercedes-AMG Petronas Formula One Team"),
            new Racer("Макс", "Ферстаппен", Mark.RBR, "RB16B", "червоний", "Red Bull Racing"),
            new Racer("Себастьян", "Феттель", Mark.AST, "AMR21", "зелений", "Aston Martin Cognizant Formula One Team"),
            new Racer("Фернандо", "Алонсо", Mark.ALP, "A521", "блакитний", "Alpine F1 Team"),
            new Racer("Джордж", "Расселл", Mark.WIL, "FW43B", "білий", "Williams Racing"),
            new Racer("Фернандо", "Алонсо", Mark.ALP, "A521", "блакитний", "Alpine F1 Team"),
            new Taxist("Іван", "Петренко", Mark.TYT, "Camry", "чорний", "Таксі Люкс"),
            new Taxist("Марія", "Іванова", Mark.FRD, "Focus", "жовтий", "Експрес Таксі"),
            new Taxist("Олександр", "Сидоров", Mark.HYND, "Accord", "сірий", "Престиж Таксі"),
            new Taxist("Марія", "Іванова", Mark.FRD, "Focus", "жовтий", "Експрес Таксі"),
            new Racer("Макс", "Ферстаппен", Mark.RBR, "RB16B", "червоний", "Red Bull Racing"),
            new Racer("Джордж", "Расселл", Mark.WIL, "FW43B", "білий", "Williams Racing"),
        };

        System.out.println(Arrays.toString(drivers)); //Вивід всіх водіїв

        for (Driver first : drivers) //Попарне порівнянн всіх водіїв
        {
            for (Driver second : drivers)
                System.out.print((first.equals(second) ? 1 : 0) + " ");
            System.out.print("\n");
        }

        //Детальне порівння деяких водіїв
        System.out.println(drivers[0].compareTo(drivers[6])); //Різні типи
        System.out.println(drivers[2].compareTo(drivers[3])); //Різні об'єкти
        System.out.println(drivers[1].compareTo(drivers[10])); //Однакові об'єкти

        //Застосування інтерфейсу
        System.out.print(drivers[0]);
        drivers[0].paint("чорний");
        System.out.print(drivers[0]);
        System.out.print(drivers[7]);
        drivers[7].paint("червоний");
        System.out.print(drivers[7]);

        //Вивід кількості водіїв через анонімний клас
        System.out.println((new Racer() { public int getCount() { return count; } }).getCount());
    }
}