package lab4;

import lab3.Printer;
import java.util.Objects;

public class Driver extends VehicleOwner implements Printable //Водій
{
    private String mark = ""; //Марка автомобіля
    private String model = ""; //Модель автомобіля
    private String color = ""; //Колір автомобіля

    private int number; //Номер об'єкта
    protected static int count; //Кількість водіїв

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() { return number; }

    @Override
    protected void setVehicleInfo() //Пеервизначення відповідного методу класу VehicleOwner для заповнення інформації про автомобіль
    {
        mark = reader.readLine("Марка автомобіля");
        model = reader.readLine("Модель автомобіля");
        color = reader.readLine("Колір автомобіля");
    }

    @Override
    public String toString() //Перевизначення відповідного методу класу Object
    {
        String general = number + ". " + firstName + " " + lastName + " - " + day + " " + month.getName() + " " + year + "р (" + age + "рр)";
        String special = "Автомобіль" + (isOwner ? ": " + mark + " " + model + ", колір - " + color.toLowerCase() : " відсутній");

        return general + " | " + special;
    }

    @Override
    public int hashCode() //Перевизначення відповідного методу класу Object
    {
        return Objects.hash(firstName, lastName, day, month, year, model, mark, color);
    }

    @Override
    public boolean equals(Object obj) //Перевизначення відповідного методу класу Object
    {
        if (obj instanceof Driver driver)
            return Objects.equals(firstName, driver.firstName) && Objects.equals(lastName, driver.lastName) &&
                    Objects.equals(day, driver.day) && Objects.equals(month, driver.month) &&
                    Objects.equals(year, driver.year) && Objects.equals(model, driver.model) &&
                    Objects.equals(mark, driver.mark) && Objects.equals(color, driver.color) &&
                    Objects.equals(hashCode(), driver.hashCode());
        else return false;
    }

    @Override
    public void print() //Реалізація відповідного методу інтерфейсу Printable для виводу в консоль інформації про об'єкт
    {
        System.out.println(this);
        Printer.getInstance().printSpacer(isOwner ? "+" : "|");
    }

    public Driver clone() //Створення копії об'єкта
    {
        Driver driver = new Driver();

        driver.firstName = firstName;
        driver.lastName = lastName;
        driver.day = day;
        driver.month = month;
        driver.year = year;
        driver.age = age;
        driver.mark = mark;
        driver.model = model;
        driver.color = color;

        return driver;
    }

    private String compare(Object internal, Object external, String name) //Порівння 2 значень та форматований вивід результату перевірки
    {
        return Objects.equals(internal, external) ? "" : "\n " + name + ": " + internal + " ≠ " + external;
    }

    public String compareTo(Driver driver) //Порівняння 2 об'єктів та вивід інформації про поля, що відрізняються
    {
        if (equals(driver)) return "Об'єкти ідентичні";
        else return "Об'єкти мають відміннсті:" +
                compare(firstName, driver.firstName, "ім'я") +
                compare(lastName, driver.lastName, "прізвище") +
                compare(day, driver.day, "день народження") +
                compare(month, driver.month, "місяць народження") +
                compare(year, driver.year, "рік народження") +
                compare(mark, driver.mark, "марка автомобіля") +
                compare(model, driver.model, "модель автомобіля") +
                compare(color, driver.color, "колір автомобіля");
    }

    private void setNumber() //Збереження номера об'єкта
    {
        count++;
        number = count;
    }
    
    public void instantiate() //Створення екземпляру класу шляхом задавання значень всім його полям
    {
        instantiate(18);
        setNumber();
    }

    //Коструктор, якщо вік достатній

    public Driver(String firstName, String lastName, int year, int day, Month month, String mark, String model, String color)
    {
        super(firstName, lastName, year, day, month);
        isOwner = true;
        this.mark = mark;
        this.model = model;
        this.color = color;
        setNumber();
    }

    //Коструктор, якщо вік недостатній
    public Driver(String firstName, String lastName, int year, int day, Month month)
    {
        super(firstName, lastName, year, day, month);
        isOwner = false;
        setNumber();
    }

    //Порожній констуктор
    public Driver()
    {
        super();
        setNumber();
    }
}