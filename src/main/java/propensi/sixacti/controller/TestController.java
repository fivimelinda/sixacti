package propensi.sixacti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import propensi.sixacti.model.UserModel;

@Controller
public class TestController{

    @Qualifier("testServiceImpl")

    @Autowired
    private UserModel userModel;

    @PostMapping(value = "/")
    public String home(Model model){
        return "";
    }
}