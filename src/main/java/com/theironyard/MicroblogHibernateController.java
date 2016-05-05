package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by tristangreeno on 5/5/16.
 */
@Controller
public class MicroblogHibernateController {
    @Autowired
    MessageRepo messageRepo;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("username"));
        List<Message> messages = (List<Message>) messageRepo.findAll();
        model.addAttribute("messages", messages);
        return "home";
    }

    @RequestMapping(path = "/delete-all", method = RequestMethod.POST)
    public String clear(){
        messageRepo.deleteAll();
        return "redirect:/";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username) {
        session.setAttribute("username", username);
        return "redirect:/";
    }

    @RequestMapping(path = "/create-message", method = RequestMethod.POST)
    public String add(String text) {
        messageRepo.save(new Message(text));
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delete(Integer id) {
        messageRepo.delete(id);
        return "redirect:/";
    }
}