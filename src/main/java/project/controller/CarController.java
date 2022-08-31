package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.entity.Car;
import project.entity.CarType;
import project.entity.RentReturnDate;
import project.repository.CarRepository;
import project.repository.RentReturnDateRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Controller
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RentReturnDateRepository rentReturnDateRepository;
    @Autowired
    NamedParameterJdbcTemplate jdbc;
    //---------------------------------- GET all cars ------------------------------
    @GetMapping("/viewCars")
    public String getAllCars(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "viewCars";
    }
    //-------------------------------------------------------------------


    //------------------------------POST -------------------------
    @GetMapping("/saveCar")
    public String greetingForm(Model model) {
        model.addAttribute("carObject", new Car());
        return "saveCar";
    }

    @PostMapping("/saveCar")
    public String greetingSubmit(@ModelAttribute Car car, Model model) {
        model.addAttribute("carObject", car);
        carRepository.save(car);
        return "redirect:/viewCars";
    }

    //----------------------------Update---------------------------------------//



    @GetMapping("/updateCar/{id}")
    public String getCarById(@PathVariable Long id, Model model) {
        if (carRepository.findById(id).isPresent()) {
            model.addAttribute("car", carRepository.findById(id).get());
            return "updateCar";
        }
        return ("Car not found for this id : " + id);
    }

    @RequestMapping(path = "/car/delete/{id}")
    public String deleteCarById(Model model, @PathVariable("id") Long id) {
        carRepository.deleteById(id);
        return "redirect:/viewCars";
    }
    @GetMapping(value = "/car/rent/{id}")
    public String rentCarForm(@PathVariable("id") Long id, Model model) {
        Car car = carRepository.getById(id);
        RentReturnDate rentReturnDate = new RentReturnDate();
        rentReturnDate.setReturnDate(LocalDate.from(rentReturnDate.getRentDate().plusDays(1).atTime(10,30)));
        model.addAttribute("rentReturnDate", rentReturnDate);
        model.addAttribute("car", car);
        return "rent-car";
    }

    @PostMapping(value = "/car/rent/{id}")
    public String rentCar(@PathVariable("id") Long id, @ModelAttribute("rentReturnDate")
    @RequestBody RentReturnDate rentReturnDate, RedirectAttributes redirectAttributes) {
        rentReturnDate.setReturnDate(LocalDate.from(rentReturnDate.getRentDate().plusDays(1).atTime(10,30)));
        rentReturnDateRepository.save(rentReturnDate);
        Car car = carRepository.getById(id);
        car.setRentReturnDate(rentReturnDate);
        carRepository.save(car);
        redirectAttributes.addFlashAttribute("message4", "The car has been rented successfully.");
        return "redirect:/viewCars";
    }



    @GetMapping(value = "/car/{carType}")
    public String getCarByType(@PathVariable("carType") CarType carType, Model model) {
        Set<Car> cars = carRepository.findByCarType(carType);
        if(cars != null) {
            model.addAttribute("cars", cars);
        }
        return "viewCars";
    }



}
