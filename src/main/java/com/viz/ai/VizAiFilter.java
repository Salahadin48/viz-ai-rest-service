package com.viz.ai;

import com.viz.ai.annotation.Footer;
import com.viz.ai.annotation.Header;
import com.viz.ai.rest.VizAIController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Component
public class VizAiFilter implements Filter {

    @Autowired
    VizAIController runner;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String serverResponse = null;

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = ((HttpServletRequest) request).getRequestURL().toString();
        // String queryString = ((HttpServletRequest)request).getQueryString();
        System.out.println("URL: " + url);
        String inDemandAnnotation = getAnnotationNameFromRequestPath(req.getServletPath());
        System.out.println("Servlet Path: " + req.getServletPath());

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(req);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(res);
        try {
            chain.doFilter(requestWrapper, responseWrapper);

        } finally {

            AtomicReference<StringBuilder> builder = new AtomicReference<>();
            builder.set(new StringBuilder());
            byte[] responseArray = responseWrapper.getContentAsByteArray();

            Method[] methods = runner.getClass().getMethods();

            Arrays.stream(methods).forEach(m -> {
                Arrays.stream(m.getDeclaredAnnotations()).map(a -> a.annotationType()).filter(a -> a.getSimpleName().equals(inDemandAnnotation)).forEach(a -> {
                    System.out.println("Demanded and Found Annotation: " + a.getSimpleName());
                    if (a.getSimpleName().equals("Header")) {
                        builder.get().append("{ \"header\": ");
                        builder.get().append(new String(responseArray));
                        builder.get().append(" }");
                    } else if (a.getSimpleName().equals("Footer")) {
                        builder.get().append("{ \"footer\": ");
                        builder.get().append(new String(responseArray));
                        builder.get().append(" }");
                    }
                });
            });

//            for (Method method : methods) {
//                Annotation[] annotations = method.getDeclaredAnnotations();
//                Arrays.stream(annotations).map(ann -> ann.annotationType()).filter(x -> x.getSimpleName().equals("Header")||x.getSimpleName().equals("Footer")).forEach(a -> {
//                    if (a.getSimpleName().equals("Header")) {
//                        System.out.println(a.getSimpleName());
//                        Header annos = method.getAnnotation(Header.class);
//                        if (annos != null) {
//                            byte[] responseArray = responseWrapper.getContentAsByteArray();
//                            builder.set(new StringBuilder());
//                            builder.get().append("{ \"header\": ");
//                            builder.get().append(new String(responseArray));
//                            builder.get().append(" }");
//                        }
//                    } else if (a.getSimpleName().equals("Footer")) {
//                        System.out.println(a.getSimpleName());
//                        Footer annos = method.getAnnotation(Footer.class);
//                        if (annos != null) {
//                            byte[] responseArray = responseWrapper.getContentAsByteArray();
//                            builder.set(new StringBuilder());
//                            builder.get().append("{ \"footer\": ");
//                            builder.get().append(new String(responseArray));
//                            builder.get().append(" }");
//                        }
//                    }
//
//                });
//
//            }
            responseWrapper.resetBuffer();
            res.getHeaderNames().stream().forEach(h -> {
                responseWrapper.setHeader(h, res.getHeader(h));
            });
            responseWrapper.getWriter().write(builder.get().toString());
            responseWrapper.copyBodyToResponse();
        }
    }

    private String getAnnotationNameFromRequestPath(String servletPath) {
        String output = null;
        switch (servletPath) {
            case "/get/header":
                output = "Header";
                break;
            case "/get/footer":
                output = "Footer";
                break;
        }
        return output;
    }

    @Override
    public void destroy() {

    }
}
