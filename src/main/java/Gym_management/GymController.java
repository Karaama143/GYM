package Gym_management;


import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GymController {
    private final GymService service;

    public  GymController( GymService service) {
        this.service = service;
    }
    //requests

    @GetMapping("/")
    public String getHomePage() {
        return "home"; //view name
    }

    // inuu nageeyo page registerka

    @GetMapping("/Register")
    public String getRegister(){
        return "Register"; //view name
    }
    @GetMapping("/view")
    public String getview(){
        return "viewAll"; //view name
    }

    // xogta ayee qaadeysaa weena xareyneysa
    @PostMapping("/save")
    public String saveUnivegym(@ModelAttribute  Gym  gym){
        service.insertGym( gym);
        return "redirect:/All";
    }

    @GetMapping("/All")
    public String getAll(Model model, @Param("keyword") Long keyword){
        List< Gym> list = service.getAllGym(keyword);
        model.addAttribute("gym" , list);
        model.addAttribute("keyword" , keyword);
        return "viewAll";
    }

    @RequestMapping("/delete/{id}")
    public String deletegym(@PathVariable Long id){
        service.deleteGym(id);
        return "redirect:/All";
    }
    @RequestMapping("/Edit/{id}")
    public String Updategym(@PathVariable Long id, Model model){
        Gym gym = service.getGymById(id);
        model.addAttribute("gym" , gym);
        return "EditGym";  //view name
    }
}