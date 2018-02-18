package com.finance.web;

import com.finance.model.Client;
import com.finance.model.Role;
import com.finance.repository.ClientDAO;
import com.finance.repository.RoleDAO;
import com.finance.service.SecurityService;
import com.finance.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ClientController {


    @Autowired
    private ServiceImpl service;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private ClientDAO clientDAO;

/*        @Autowired
        private UserValidator userValidator;*/

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcomep(Model model) {
            return "welcome";
        }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Model model) {
            return "user";
        }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }

    @RequestMapping(value = "/startPage", method = RequestMethod.GET)
    public String start(Model model) {
        return "startPage";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Client());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Client clientForm, BindingResult bindingResult, Model model) {
//            userValidator.validate(clientForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        service.createClient(clientForm);

        securityService.autoLogin(clientForm.getPhonenumber(), clientForm.getPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    private String init(Model model){
        List<Client> clients = new ArrayList<Client>();
        roleDAO.saveAndFlush(new Role("ROLE_ADMIN"));
        roleDAO.saveAndFlush(new Role("ROLE_USER"));
        Date currentDate = new Date();
        clients.add(new Client("admin", "admin", currentDate, "admin", "admin", "admin"));
        for(int i=1; i<3; i++){
            clients.add(new Client("user_"+i, "user_"+i, currentDate, "user_"+i, "user_"+i, "user_"+i));
        }
        for(Client client: clients){
            clientDAO.saveAndFlush(client);
            service.createClient(client);
        }
        return "login";
    }
}
