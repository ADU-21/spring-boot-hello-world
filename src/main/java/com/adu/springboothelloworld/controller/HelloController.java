package com.adu.springboothelloworld.controller;

import com.adu.springboothelloworld.annotation.ControllerWebLog;
import com.adu.springboothelloworld.config.AppConfiguration;
import com.adu.springboothelloworld.model.User;
import com.adu.springboothelloworld.service.ThreadService;
import com.adu.springboothelloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jintang
 * @date 2019-10-29
 */
@RestController
public class HelloController implements ServletContextAware {
    private ServletContext servletContext;
    @Autowired
    private UserService userService;
    @Autowired
    private ThreadService threadService;
    @Autowired
    private AppConfiguration configuration;

    @GetMapping("/test")
    public String test(@RequestParam("name")String name) {
        if (configuration.isVar() ) {
            return name;
        }
        return "false";
    }

    @PostMapping("/hello")
    //@ControllerWebLog("asdadas")
    public Map<String, String> hello(User user) {
        Map<String, String> map = new HashMap<>();
        map.put("userName", user.getName());

        if (user.getName().equals("e")) {
            throw new RuntimeException("xxxxxxxx");
        }
        return map;
    }

    @PostMapping("/user")
    public User user(User user) {
        return user;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam("id") Long id) {
        return threadService.getUser(id);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    /**
     * Set up a custom property editor for converting form inputs to real objects
     *
     * @param request the current request
     * @param binder  the data binder
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Integer.class, null, new CustomNumberEditor(Integer.class, null, true));
        binder.registerCustomEditor(Long.class, null, new CustomNumberEditor(Long.class, null, true));
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
    }
}
