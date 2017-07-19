package ua.vld.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.vld.model.User;
import ua.vld.service.UserService;
import ua.vld.to.UserTo;
import ua.vld.util.UserUtil;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        UserTo userTo = new UserTo();
        modelAndView.addObject("userTo", userTo);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid UserTo userTo, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findByLogin(userTo.getLogin());
        if (userExists != null) {
            bindingResult
                    .rejectValue("login", "error.userTo",
                            "There is already a user registered with the login provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            User user = UserUtil.createNewFromTo(userTo);
            userService.save(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("userTo", new UserTo());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }

    @RequestMapping(value="/phonebook", method = RequestMethod.GET)
    public ModelAndView phoneBook(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("phonebook");
        return modelAndView;
    }

}
