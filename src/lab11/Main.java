package lab11;

import java.lang.reflect.Method;

public class Main
{
    public static void main(String[] args)
    {
        for (Method method : new Database().getClass().getMethods())
        {
            if (method.isAnnotationPresent(Auditable.class))
            {
                Auditable annotaion = method.getDeclaredAnnotation(Auditable.class);
                System.out.println("Метод " + method.getName() + " підходить для аудиту. Тип: " + annotaion.value().getName());
            }

            if (method.isAnnotationPresent(Deprecated.class))
                System.out.println("Метод " + method.getName() + " дещо застарів");
        }
    }
}