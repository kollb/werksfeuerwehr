package mediator;

public interface ICommand {
    void requestTrucks(String location);
    void sendBackTrucks();
}
