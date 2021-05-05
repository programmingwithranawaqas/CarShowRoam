package com.example.carshowroam;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
   static ArrayList<Car> cars;

    @Override
    public void onCreate() {
        super.onCreate();
        cars = new ArrayList<>();
        cars.add(new Car("Mercedes", "Rana Waqas", "Polo", "03001234567"));
        cars.add(new Car("Nissan", "Ali Hamza", "Polo", "03001234567"));
        cars.add(new Car("Mercedes", "Rana Jawad", "Polo", "03001234567"));
        cars.add(new Car("Volkswagen", "Rana Waqar", "Polo", "03001234567"));
        cars.add(new Car("Mercedes", "Rana Waqas", "Polo", "03001234567"));
    }
}