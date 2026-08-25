package br.com.fiap._tdspa.javaadv.MyFirstSpringBootRestApplication.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/example")
public class ExampleResource {
//    @RequestMapping("/hello", method= RequestMethod.GET)
    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }
}
