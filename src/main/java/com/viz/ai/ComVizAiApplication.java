package com.viz.ai;

import com.viz.ai.annotation.EnableVizAI;
import com.viz.ai.annotation.Header;
import com.viz.ai.model.HeaderData;
import com.viz.ai.rest.VizAIController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;


@EnableVizAI
@SpringBootApplication
public class ComVizAiApplication { //} implements CommandLineRunner {

    @Autowired
    VizAIController runner;

    public static void main(String[] args) {
        SpringApplication.run(ComVizAiApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Method[] methods = runner.getClass().getMethods();
//
//        for (Method method : methods) {
//            Header annos = method.getAnnotation(Header.class);
//            if (annos != null) {
//                Annotation[] annotations = method.getDeclaredAnnotations();
//                Arrays.asList(annotations).stream().forEach(a -> {
//                    System.out.println("Annotation: "+a.annotationType().getSimpleName());
//                    if (a instanceof GetMapping) {
//                        GetMapping gm = (GetMapping) a;
//                        Parameter[] par = method.getParameters();
//                        Arrays.asList(par).stream().forEach(p -> {
//                            Annotation[] parAnno = p.getDeclaredAnnotations();
//                            Arrays.asList(parAnno).stream().forEach(pa -> {
//                                if (pa != null && pa instanceof PathVariable) {
//                                    PathVariable pv = (PathVariable) pa;
//                                    System.out.println(p.getName()+" is a PathVariable with value: "+pv.value());
//                                }
//                            });
//                        });
//                        System.out.println("URL Path: "+gm.value()[0] + " ");
//                    }
//                });
//
//                try {
//                    HeaderData output = (HeaderData) method.invoke(runner, 0);
//                    System.out.println("Output: " + output.getName() + ": " + output.getValue());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
