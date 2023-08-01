package com.Homework.Homework06;

public class VehiclesFactory {
    private static Horse horse = new Horse(); //饿汉式
    private VehiclesFactory(){}
    public static Horse getHorse() {
        return horse;
    }
    public static Boat getBoat() {
        return new Boat();
    }
}
