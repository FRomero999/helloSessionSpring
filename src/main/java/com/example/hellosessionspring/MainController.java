package com.example.hellosessionspring;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class MainController {

    @GetMapping("/")
    public String home(Model salida, HttpServletRequest request){

        String mensaje = (String) request.getSession().getAttribute("mensaje");
        if(mensaje!=null) {
            salida.addAttribute("texto", mensaje);
        }
        return "home";
    }

    @GetMapping("/set/{texto}")
    public String set(@PathVariable String texto, HttpServletRequest request){
        request.getSession().setAttribute("mensaje",texto);

        return "redirect:/web/";
    }

    @GetMapping("/reset")
    public String reset(HttpServletRequest request){
        request.getSession().removeAttribute("mensaje");
        return "redirect:/web/";
    }

}
