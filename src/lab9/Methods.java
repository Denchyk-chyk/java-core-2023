package lab9;

public class Methods {

    public void check(float a, float b) throws  IllegalAccessException //Перевіряє всі можливі виключення
    {
        if (a < 0 && b > 0)
            throw new IllegalArgumentException();
        else if ((a == 0 || b == 0) && a != b)
            throw new ArithmeticException();
        else if (a == 0 && b == 0)
            throw new IllegalAccessException();
        else if (a > 0 && b > 0)
            throw new NullPointerException();
    }

    public float add(float a, float b) throws IllegalAccessException //+
    {
        check(a, b);
        return a + b;
    }

    public float remove(float a, float b) throws IllegalAccessException //-
    {
        check(a, b);
        return a - b;
    }

    public float multiple(float a, float b) throws IllegalAccessException //×
    {
        check(a, b);
        return a * b;
    }

    public float divide(float a, float b) throws IllegalAccessException //÷
    {
        check(a, b);
        return a / b;
    }
}