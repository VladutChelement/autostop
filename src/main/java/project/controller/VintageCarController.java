package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.entity.Car;
import project.entity.CarType;
import project.entity.RentReturnDate;
import project.entity.VintageCar;
import project.repository.CarRepository;
import project.repository.RentReturnDateRepository;
import project.repository.VintageCarRepository;

import java.time.LocalDate;
import java.util.Set;

@Controller

public class VintageCarController {


    @Autowired
    private VintageCarRepository vintageCarRepository;
    @Autowired
    private RentReturnDateRepository rentReturnDateRepository;


    //---------------------------------- GET all cars ------------------------------
    @GetMapping("/vintageCars")
    public String getAllCars(Model model) {
        model.addAttribute("vCars", vintageCarRepository.findAll());
        return "vintageCars";
    }


    //------------------------------POST Car-------------------------

    @GetMapping("/saveVCar")
    public String greetingForm(Model model) {
        model.addAttribute("vintageCar", new VintageCar());
        return "saveVCar";
    }


    @PostMapping("/saveVCar")
    public String greetingSubmit(@ModelAttribute VintageCar vintageCar, Model model) {
        model.addAttribute("vintageCar", vintageCar);
        vintageCarRepository.save(vintageCar);
        return "redirect:/vintageCars";
    }

    //----------------------------Update---------------------------------------//


    @GetMapping("/updateVCar/{id}")
    public String getVintageCarById(@PathVariable Long id, Model model) {
        if (vintageCarRepository.findById(id).isPresent()) {
            model.addAttribute("vintageCar", vintageCarRepository.findById(id).get());
            return "updateVCar";
        }
        return ("Car not found for this id : " + id);
    }

    @RequestMapping(path = "/vintageCar/delete/{id}")
    public String deleteVintageCarById(Model model, @PathVariable("id") Long id) {
        vintageCarRepository.deleteById(id);
        return "redirect:/vintageCars";
    }


    @GetMapping(value = "/vintageCar/{carType}")
    public String getCarByType(@PathVariable("carType") CarType carType, Model model) {
        Set<VintageCar> vCars = vintageCarRepository.findByCarType(carType);
        if (vCars != null) {
            model.addAttribute("vCars", vCars);
        }
        return "vintageCars";
    }

    @GetMapping(value = "/vCar/rent/{id}")
    public String rentvCarForm(@PathVariable("id") Long id, Model model) {
        VintageCar vCar = vintageCarRepository.getById(id);
        RentReturnDate rentReturnDate = new RentReturnDate();
        rentReturnDate.setReturnDate(LocalDate.from(rentReturnDate.getRentDate().plusDays(1).atTime(10, 30)));
        model.addAttribute("rentReturnDate", rentReturnDate);
        model.addAttribute("vCar", vCar);
        return "rent-vCar";
    }

    @PostMapping(value = "/vCar/rent/{id}")
    public String rentvCar(@PathVariable("id") Long id, @ModelAttribute("rentReturnDate")
    @RequestBody RentReturnDate rentReturnDate, RedirectAttributes redirectAttributes) {
        rentReturnDate.setReturnDate(LocalDate.from(rentReturnDate.getRentDate().plusDays(1).atTime(10, 30)));
        rentReturnDateRepository.save(rentReturnDate);
        VintageCar vCar = vintageCarRepository.getById(id);
        vCar.setRentReturnDate(rentReturnDate);
        vintageCarRepository.save(vCar);
        redirectAttributes.addFlashAttribute("message", "The car has been rented successfully.");
        return "redirect:/vintageCars";
    }

}

