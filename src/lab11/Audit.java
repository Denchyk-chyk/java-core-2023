package lab11;

public enum Audit
{
    RECORD("Додавання запису"),
    UPDATE("Оновлення запису"),
    DELETE("Видалення запису");

    Audit(String name)
    {
        this.name = name;
    }

    private final String name;

    public String getName()
    {
        return name;
    }
}