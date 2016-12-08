package com.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class RouteAccessFilter extends ZuulFilter  {

    private static Logger log = LoggerFactory.getLogger(RouteAccessFilter.class);

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("running RoutingFilter");
//        try {
//        	System.out.println("running RoutingFilter2");
//        	// 业务跳转
////            RequestContext.getCurrentContext().getResponse().sendRedirect("https://github.com/haodp/spring-cloud/tree/master/cloud-config-repo");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }

}
