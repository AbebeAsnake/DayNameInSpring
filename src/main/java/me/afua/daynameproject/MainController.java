package me.afua.daynameproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.DayOfWeek.*;

@Controller
public class MainController {
    //This is used to display pages
    @GetMapping("/")
    public String askForBirthday()
    {
        return "index";
    }

    //This is used to receive data from pages after the submit button has been pressed
    @PostMapping("/")
    public String getInput(HttpServletRequest request, Model model)
    {
        //Another way to get values from the user interface.
        //It's better to use the model (which we will see later),
        //but sometimes you also want to pass additional items to the
        //controller that the model may not necessarily contain.

        String enteredDate = request.getParameter("getdob");
        String showMe = request.getParameter("toshow");

        //Creating an instance of the class with the date that the user entered
        MyNameClass getName = new MyNameClass(enteredDate);

        //Using the method created in the class to get the full date format
        model.addAttribute("enteredDate",getName.fullDateFormat());

        //Passing the value of the radio button so it can be used later
        model.addAttribute("toshow",showMe);

        //Included the Chinese Zodiac as well
        model.addAttribute("animal",getName.getMyAnimal());

        //Showing another way in which the values of male and female name can be adjusted, so that
        //blank values will not display text in the view. This is a long-winded way (simpler, but much longer!)
        if(showMe.equalsIgnoreCase("female")|| showMe.equalsIgnoreCase("both"))
        {
            model.addAttribute("femalename",getName.getFemaleName());
        }
        else
        {
            model.addAttribute("femalename","");
        }
        if(showMe.equalsIgnoreCase("male")|| showMe.equalsIgnoreCase("both"))
        {
            model.addAttribute("malename",getName.getMaleName());
        }
        else
        {
            model.addAttribute("malename","");
        }
        return "shownames";
    }



}
