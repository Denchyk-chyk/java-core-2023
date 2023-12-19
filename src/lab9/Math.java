package lab9;

public class Math {
    public static void main(String[] args) {
        print(2.75f, 1.25f);
        print(0, 4);
    }

    private static void print(float a, float b) { //Обчислення з урахуванням ділення на 0
        try {
            System.out.println(calculate(a, b));
        } catch (ArithmeticException e) { //Обробка помилки
            System.out.println(0);
        }
    }

    private static float calculate(float a, float b) throws ArithmeticException { //Обчислення виразу b*b(a-b)/a
        float value = a * a * (a - b) / a;
        if (Double.isNaN(value)) //Результат ділення 0 на 0
            throw new ArithmeticException(); //Викидання помилки

        return value;
    }
}