package iterator;

public interface IIterator {
    boolean hasNextNormalFireTruck();
    boolean hasNextSpecialFireTruck();
    Object nextNormalFiretruck();
    Object nextSpecialFiretruck();
}