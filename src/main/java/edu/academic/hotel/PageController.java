package edu.academic.hotel;
import org.springframework.stereotype.Controller; import org.springframework.web.bind.annotation.GetMapping;
@Controller public class PageController { @GetMapping({"/","/index.html"}) String home(){return "index";} }
