package lab4;

import java.lang.reflect.Method;
import java.util.Objects;

public abstract class Driver implements Paintable //Водій
{
    protected String firstName;
    protected String lastName;
    protected Mark mark;
    protected String model;
    protected String color;

    protected static int count; //Кількість водіїв

    @Name("Ім'я")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Name("Прізвище")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Name("Марка автомобіля")
    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Name("Модель автомобіля")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Name("Колір автомобіля")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Driver driver)) return false;
        return Objects.equals(firstName, driver.firstName) &&
                Objects.equals(lastName, driver.lastName) &&
                Objects.equals(mark, driver.mark) &&
                Objects.equals(model, driver.model) &&
                Objects.equals(color, driver.color);
    }


    //Основна частина конструктора
    public void instant(String firstName, String lastName, Mark mark, String model, String color)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
        this.model = model;
        this.color = color;
        count++;
    }

    @Override
    public String toString()
    {
        return firstName + " " + lastName + " | " + mark.getName() + " " + model + ", колір - " + color.toLowerCase();
    }

    public String compareTo(Object o)
    {
        Class<?> type = o.getClass();
        if (type != getClass()) return "Водії різних типів";
        if (equals(o)) return "Водії однакові";
        else
        {
            StringBuilder differences = new StringBuilder("Водії різні (зокрема різне наступне):");
            for (Method method : type.getMethods()) //Порівнянн всіх методів, що мають відповідну анотацію
            {
                if (method.isAnnotationPresent(Name.class))
                {
                    try //Заглушка
                    {
                        if (!Objects.equals(method.invoke(this), method.invoke(o)))
                            differences.append(" ").append(method.getAnnotation(Name.class).value().toLowerCase());
                    } catch (Exception e) {};
                }
            }
            return differences.toString();
        }
    }
}