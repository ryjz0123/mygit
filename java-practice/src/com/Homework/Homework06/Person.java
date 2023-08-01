package com.Homework.Homework06;

public class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver() {
        if (vehicles == null || !(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();

        }
        vehicles.work();
    }
    public void Walk() {
        if (vehicles == null || !(vehicles instanceof Horse))
            vehicles = VehiclesFactory.getHorse();
        vehicles.work();
    }
    public static void main(String[] args) {
        Person person = new Person("唐僧", new Boat());
        person.Walk();
        person.passRiver();
        person.Walk();
    }
}
