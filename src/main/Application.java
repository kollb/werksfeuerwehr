package main;

public class Application {


    public static void main(String... args) {
        // Create Buildings and "Brandmeldezentrale"
        Building B1 = new Building("B1",1,2);
        FireAlarmControl F1 = new FireAlarmControl(B1);
        Building B2 = new Building("B2",2,3);
        FireAlarmControl F2 = new FireAlarmControl(B2);
        Building B3 = new Building("B3",3,1);
        FireAlarmControl F3 = new FireAlarmControl(B3);
        Building B4 = new Building("B4",4,2);
        FireAlarmControl F4 = new FireAlarmControl(B4);
        Building B5 = new Building("B5",5,2);
        FireAlarmControl F5 = new FireAlarmControl(B5);
        Building B6 = new Building("B6",6,3);
        FireAlarmControl F6 = new FireAlarmControl(B6);


    }
}
