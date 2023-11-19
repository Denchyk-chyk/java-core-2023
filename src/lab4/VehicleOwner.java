package lab4;

public abstract class VehicleOwner //Власник транспортного засобу, наприклад автомобіля
{
    protected String firstName; //Ім'я
    protected String lastName; //Прізвище

    //Дата народження
    protected int year;
    protected int day;
    protected Month month;

    protected int age; //Порахований вік
    protected boolean isOwner; //Зберігай інформацію про те, чи людина може володіти транспортним засобом залежно від віку

    protected Reader reader; //Клас для зчитування даних з консолі

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }

    public int getDay() { return day; }

    public void setDay(int day) { this.day = day; }
    public int getAge() { return age; }

    public Month getMonth() { return month; }

    public void enterMonth(Month month) { this.month = month; }

    protected abstract void setVehicleInfo(); //Ввід інформації про транспортний засіб

    private void enterMonth() //Ввід місяця (повторення вводу, якщо число перевищуйє 12)
    {
        int month = reader.readInteger("Місяць народження (1-12)");
        if (month > 12)
        {
            System.out.println("Некоректні дані");
            enterMonth();
        }
        else
        {
            this.month = Month.values()[month - 1];
        }
    }

    private void enterDay() //Ввід дня місяця (повторення вводу, якщо число перевищує кількість днів у цьому місяці)
    {
        int day = reader.readInteger("День місяця (1-" + month.getDays() + ")");
        if (day > month.getDays())
        {
            System.out.println("Некоректні дані");
            enterDay();
        }
        else
        {
            this.day = day;
        }
    }

    private void enterYear() //Ввід року (повторення вводу, якщо число перевищує поточний рік)
    {
        int year = reader.readInteger("Рік народження");
        if (year > 2023)
        {
            System.out.println("Некоректні дані");
            enterYear();
        }
        else
        {
            this.year = year;
        }
    }

    public void instantiate(int minAge) //Створення екземпляру класу шляхом задавання значень всім його полям
    {
        reader = new Reader();

        //Ввід імені
        firstName = reader.readLine("Ім'я");
        lastName = reader.readLine("Прізвище");

        //Ввід дати народження
        enterMonth();
        enterDay();
        enterYear();

        //Знаходження віку на основі дати народження
        int month = this.month.ordinal() + 1;
        age = 2023 - year - (month > 10 || (month == 10 && day > 22) ? 1 : 0);

        //Присвоєння інформації про транспортний засіб або заборона цього залежно від віку
        if (isOwner = age >= minAge)
            setVehicleInfo();
        else
            System.out.println("Вік недостатній для володіння відповідним транспортним засобом");
    }

    //Конструктор
    public VehicleOwner(String firstName, String lastName, int year, int day, Month month)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.day = day;
        this.month = month;

        int monthNumber = this.month.ordinal() + 1;
        age = 2023 - year - (monthNumber > 10 || (monthNumber == 10 && day > 22) ? 1 : 0);
    }

    //Порожній конструктор
    public VehicleOwner() {}
}