package se.demoserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class DemoController {
    int counter =0;
    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public ClassA epA() {
        ClassA a = new ClassA();
        System.out.println("called a time="+new Date());

        return a;
    }
    @RequestMapping(value = "/b", method = RequestMethod.GET)
    public ClassB epB() {
        ClassB b = new ClassB();
        System.out.println("called b time="+new Date());

        return b;
    }
    @RequestMapping(value = "/c", method = RequestMethod.GET)
    public InterfaceC epC() {
        System.out.println("called c at time "+new Date());
        if (++counter % 2 ==0) {
            ClassA a = new ClassA();
            System.out.println("called c, returned a, counter= "+counter);
            return a;
        }
        else {
            ClassB b = new ClassB();
            System.out.println("called c, returned b, counter= "+counter);
            return b;
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<InterfaceC> epList() {
        List<InterfaceC> ret = new ArrayList<>();
        ret.add(new ClassA());
        ret.add(new ClassB());
        ret.add(new ClassA());
        ret.add(new ClassB());
        return ret;
    }

}
