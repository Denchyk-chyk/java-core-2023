package lab10;

@FunctionalInterface
public interface Comparison <T>
{
    abstract boolean execute(T first, T second);
}