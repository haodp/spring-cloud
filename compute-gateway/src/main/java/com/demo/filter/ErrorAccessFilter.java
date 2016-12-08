package com.demo.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ErrorAccessFilter extends ZuulFilter  {

    private static Logger log = LoggerFactory.getLogger(ErrorAccessFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 错误的场合，跳到错误画面。
     */
    @Override
    public Object run() {
        System.out.println("running error");
      try {
    	System.out.println("running RoutingFilter2");
    	// 业务跳转
        RequestContext.getCurrentContext().getResponse().sendRedirect("https://github.com/haodp/spring-cloud/tree/master/cloud-config-repo");
      } catch (IOException e) {
    	  e.printStackTrace();
      }
        return null;
    }

}
