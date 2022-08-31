//package project.file;
//
//import project.entity.Car;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class CSVSaver {
//
//    public static void saveDB(File file, List<Car> cars) throws IOException {
//        FileWriter fileWriter = new FileWriter(file);
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//
//        printWriter.println( "Car ID"+ ", " + "Price" + ", " + "Make" + ", " + "Rented");
//
//        for (Car car : cars) {
//            printWriter.println(car.getCarID() + ", " + car.getPrice() + ", " + car.getMake() + ", " + car.isRented());
//        }
//
//        printWriter.flush();
//        printWriter.close();
//
//    }
//
//
//    public static void removeCar(File file, int carID) throws FileNotFoundException {
//        File tempFile = new File("tempFile.csv");
//        PrintWriter printWriter = new PrintWriter(tempFile);
//        Scanner scanner = new Scanner(file);
//
//        Integer.toString(carID);
//
//        while (scanner.hasNext()){
//            String[] currentLine = scanner.nextLine().split(", ");
//            if (currentLine[0].equals(carID)) {
//                continue;
//            }
//            printWriter.println(currentLine);
//        }
//
//        printWriter.flush();
//        printWriter.close();
//        scanner.close();
//
//        tempFile.renameTo(file);
//    }
//
//    public static void addCar(File file, String[] carPropertiesInput) throws FileNotFoundException {
//        Scanner scanner = new Scanner(file);
//        String lastLine = "";
//
//        while (scanner.hasNext()){
//            lastLine = scanner.nextLine();
//        }
//
//        String[] lastCar = lastLine.split(", ");
//
//        String[] lastCarID = {lastCar[0]};
//
//        List<String> carProperties = new ArrayList<String>(List.of(lastCarID));
//        carProperties.addAll(List.of(carPropertiesInput));
//
//        Car car = createCar(carProperties);
//
//        PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, true));
//
//        printWriter.append(car.getCarID() + ", " + car.getPrice() + ", " + car.getMake() + ", " + car.isRented());
//
//        printWriter.flush();
//        printWriter.close();
//    }
//
//    private static Car createCar(List<String> carProperties) {
//        int carID = Integer.parseInt(carProperties.get(0)) + 1;
//        Double carPrice = Double.parseDouble(carProperties.get(1));
//        CarsMake carsMake = CarsMake.valueOf(carProperties.get(2));
//        boolean carRented = false;
//
//        Car car = new Car(carID, carPrice, carsMake, carRented, 0);
//        return car;
//    }
//
//}
