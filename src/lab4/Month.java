package lab4;

public enum Month //Перелік місяців, з їхніми скороченими назвами та кількістю днів
{
    JANUARY("сч", 31),
    FEBRUARY("лт", 29),
    MARCH("бр", 31),
    APRIL("кв", 30),
    MAY("тр", 31),
    JUNE("чр", 30),
    JULY("лп", 31),
    AUGUST("ср", 31),
    SEPTEMBER("вр", 30),
    OCTOBER("жв", 31),
    NOVEMBER("лс", 30),
    DECEMBER("гр", 31);

    private final String name; //Скорочена назва
    private final int days; //Кількість днів

    Month(String name, int days)
    {
        this.name = name;
        this.days = days;
    }

    public String getName() { return name; }

    public int getDays() { return days; }
}