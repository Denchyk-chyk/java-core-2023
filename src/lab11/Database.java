package lab11;

public class Database
{
    @Deprecated
    @Auditable(Audit.RECORD)
    public void recordInOldWay(int value)
    {
        System.out.println("Додано\\");
        System.out.print(value);
    }

    @Auditable(Audit.RECORD)
    public void record(int value)
    {
        System.out.println("Додано " + value);
    }

    @Auditable(Audit.UPDATE)
    public void update(int previous, int next)
    {
        System.out.println("Оновлено " + previous + " => " + next);
    }

    @Auditable(Audit.DELETE)
    public void delete(int value)
    {
        System.out.println("Видалено " + value);
    }
}