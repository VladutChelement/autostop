package project.file;


import project.entity.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//public class CSVReader {
//
//    public static List<Car> readDB(File file) throws FileNotFoundException {
//        List<Car> cars = new ArrayList();
//
//        Scanner scanner = new Scanner(file);
//        scanner.nextLine();
//
//        while (scanner.hasNext()){
//            String carString = scanner.nextLine();
//            String[] carProperties = carString.split(", ");
//            Car car = createCar(carProperties);
//            cars.add(car);
//        }
//        return cars;
//    }
//
//    private static Car createCar(String[] carProperties){
//        int carID = Integer.parseInt(carProperties[0]);
//        Double carPrice = Double.parseDouble(carProperties[1]);
//        CarsMake carsMake = CarsMake.valueOf(carProperties[2]);
//        boolean carRented = Boolean.parseBoolean(carProperties[3]);
//
//        Car car = new Car(carID, carPrice, carsMake, carRented, 0);
//        return car;
//    }
//
//    }
