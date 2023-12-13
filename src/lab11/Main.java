package lab11;

import java.lang.reflect.Method;

public class Main
{
    public static void main(String[] args)
    {
        Database base = new Database();
        Method[] methods = base.getClass().getMethods();

        for (Method method : methods)
        {
            if (method.isAnnotationPresent(Auditable.class))
            {
                Auditable annotaion = method.getAnnotation(Auditable.class);
                System.out.println("Метод " + method.getName() + " підходить для аудиту. Тип: " + annotaion.value().getName());
            }

            if (method.isAnnotationPresent(Deprecated.class))
                System.out.println("Метод " + method.getName() + " дещо застарів");
        }
    }
}