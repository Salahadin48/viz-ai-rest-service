package com.viz.ai;

import com.viz.ai.annotation.Header;
import com.viz.ai.model.HeaderData;
import com.viz.ai.rest.VizAIController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

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

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(req);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(res);
        try {
            chain.doFilter(requestWrapper, responseWrapper);

        } finally {

            StringBuilder builder = null;

            Method[] methods = runner.getClass().getMethods();

            for (Method method : methods) {
                Header annos = method.getAnnotation(Header.class);
                if (annos != null) {
                    byte[] responseArray = responseWrapper.getContentAsByteArray();
                    builder = new StringBuilder();
                    builder.append("{ \"header\": ");
                    builder.append(new String(responseArray));
                    builder.append(" }");
                }
            }
            responseWrapper.resetBuffer();
            res.getHeaderNames().stream().forEach(h -> {
                responseWrapper.setHeader(h, res.getHeader(h));
            });
            responseWrapper.getWriter().write(builder.toString());
            responseWrapper.copyBodyToResponse();
        }


        Method[] methods = runner.getClass().getMethods();

        for (Method method : methods) {
            Header annos = method.getAnnotation(Header.class);
            if (annos != null) {
//                Annotation[] annotations = method.getDeclaredAnnotations();
//                Arrays.asList(annotations).stream().forEach(a -> {
//                    System.out.println("Annotation: " + a.annotationType().getSimpleName());
//                    if (a instanceof GetMapping) {
//                        GetMapping gm = (GetMapping) a;
//                        Parameter[] par = method.getParameters();
//                        Arrays.asList(par).stream().forEach(p -> {
//                            Annotation[] parAnno = p.getDeclaredAnnotations();
//                            Arrays.asList(parAnno).stream().forEach(pa -> {
//                                if (pa != null && pa instanceof PathVariable) {
//                                    PathVariable pv = (PathVariable) pa;
//                                    System.out.println(p.getName() + " is a PathVariable with value: " + pv.value());
//                                }
//                            });
//                        });
//                        System.out.println("URL Path: " + gm.value()[0] + " ");
//                    }
//                });

//                try {
//                    HeaderData output = (HeaderData) method.invoke(runner, 0);
//                    System.out.println("Output: " + output.getName() + ": " + output.getValue());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

            }
        }

    }

    @Override
    public void destroy() {

    }
}
