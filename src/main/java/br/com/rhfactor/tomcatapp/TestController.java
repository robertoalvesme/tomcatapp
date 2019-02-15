package br.com.rhfactor.tomcatapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired private  UserService userService;

    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("home");
    }

    @GetMapping("/register")
    public ModelAndView register(User user){
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes){

        if (result.hasErrors()) {
            return register(user);
        }

        try{
            this.userService.save(user);
            redirectAttributes.addFlashAttribute("alert", "Created" );
        }catch (Exception e){
            logger.error("Error on save");
            redirectAttributes.addFlashAttribute("alert", "Error" );
            return register(user);
        }

        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/login")
    public ModelAndView login(User user){

        if( !SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser") ){
            return new ModelAndView("redirect:/secured/");
        }

        return new ModelAndView("login");
    }

    @GetMapping("/logout")
    public ModelAndView logout(User user){
        SecurityContextHolder.getContext().setAuthentication(null);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/secured")
    public ModelAndView secured(){
        return new ModelAndView("secured");
    }

}
