package JDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {

    final AtomicLong atomicLong = new AtomicLong();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User signMethod(@RequestParam(value = "name", required = true, defaultValue = "World")String name, char[] pass){
        return (new User(0, name, pass));
    }

    @RequestMapping("/registration")
    public User regMethod(@RequestParam(value = "name", required = false, defaultValue = "World")String name, char[] pass){
        return (new User(0, name, pass));
    }

    @RequestMapping("/exit")
    public void exitMethod(){
        System.exit(0);
    }

}
