package lab3;

class Driver
{
    private String firstName; //Ім'я
    private String lastName; //Прізвище
    private int age; //Вік
    private String mark; //Марка автомобіля
    private String model; //Модель автомобіля
    private String color; //Колір автомобіля
    private int number; //Порядковий номер студента
    private static int count; //Кількість водіїв

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        if (age > 18 && age < 70)
            this.age = age;
    }

    public String getMark()
    {
        return mark;
    }

    public void setMark(String mark)
    {
        this.mark = mark;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public String GetFullInfo() //Довгий формат виводу даних про водія
    {
        return number + ". " + firstName + " " + lastName + " - " + age + "р | Автомобіль: " + mark + " " + model + ", колір - " + color.toLowerCase();
    }

    public String GetShortInfo() //Короткий формат виводу даних про водія
    {
        return (number + ". " + firstName + " " + lastName + " - " + mark + " " + model).toUpperCase();
    }

    private void AddToList() //Функція, що зберігає номер студента
    {
        count++;
        number = count;
    }

    public Driver() //Конструктор без параметрів
    {
        AddToList();

        firstName = "Noname";
        lastName = "Noname";
        age = 18;
        mark = "No info (mark)";
        model = "No info (model)";
        color = "No info (color)";
    }

    public Driver(String firstName, String lastName, int age, String mark, String model, String color) //Конструктор з параметрами
    {
        AddToList();

        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setMark(mark);
        setModel(model);
        setColor(color);
    }
}