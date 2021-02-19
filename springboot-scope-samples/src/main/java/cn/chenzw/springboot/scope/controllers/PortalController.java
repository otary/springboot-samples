package cn.chenzw.springboot.scope.controllers;

import cn.chenzw.springboot.scope.service.PrototypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
@RequestMapping("/portal")
public class PortalController {

    @Autowired
    PrototypeService prototypeService;

    @Autowired
    WebApplicationContext wac;

    @GetMapping("/print")
    public void print() {
        PrototypeService prototypeBean = wac.getBean(PrototypeService.class);
        prototypeBean.print();
    }

    @GetMapping("/print2")
    public void print2() {
         prototypeService.print();
    }
}
