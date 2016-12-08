package com.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PostAccessFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PostAccessFilter.class);

	@Override
	public String filterType() {
		return "post";
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
		System.out.println("running javaPostFilter");
		System.out.println(RequestContext.getCurrentContext().get("name").toString());
		return null;
	}

}
