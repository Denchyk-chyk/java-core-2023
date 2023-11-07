package lab7;

public class Main
{
    public static void main(String[] args)
    {
        Computer computer = new Computer("Asus", "TUF 17", 16, 512);
        Computer.Processor processor = computer.new Processor("Intel Core I5", 3.5, 8);
        computer.setProcessor(processor);

        System.out.println("Виробник: " + computer.getDeveloper());
        System.out.println("Модель: " + computer.getModel());
        System.out.println("Оперативна пам'ять: " + computer.getRamSize());
        System.out.println("Постійна пам'ять: " + computer.getDriveSize());
        System.out.println("Процесор: " + computer.getProcessor());

        computer.getProcessor().boost(1.1);
    }
}