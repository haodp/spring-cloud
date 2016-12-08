package com.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.demo.filter.PostAccessFilter;
import com.demo.filter.PreAccessFilter;
import com.demo.filter.RouteAccessFilter;
import com.netflix.zuul.context.ContextLifecycleFilter;
import com.netflix.zuul.filters.FilterRegistry;
import com.netflix.zuul.http.ZuulServlet;
import com.netflix.zuul.monitoring.MonitoringHelper;

@EnableZuulProxy
@SpringCloudApplication
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

//	@Bean
//	public PreAccessFilter accessFilter() {
//		MonitoringHelper.initMocks();
//		return new PreAccessFilter();
//	}

	@Component
	public static class MyCommandLineRunner implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			MonitoringHelper.initMocks();
			initJavaFilters();
		}

		private void initJavaFilters() {
			final FilterRegistry r = FilterRegistry.instance();
			r.put("preExe", new PreAccessFilter());
			r.put("routeExe", new RouteAccessFilter());
			r.put("postExe", new PostAccessFilter());
		}
	}

	/**
	 * TODO等待调查
	 * 动态路由的监控  http://localhost:5555/test
	 *
	 * @return
	 */
	@Bean
	public ServletRegistrationBean zuulServlet() {
		ServletRegistrationBean servlet = new ServletRegistrationBean(new ZuulServlet());
		servlet.addUrlMappings("/test");
		return servlet;
	}

	@Bean
	public FilterRegistrationBean contextLifecycleFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean(new ContextLifecycleFilter());
		filter.addUrlPatterns("/*");
		return filter;
	}

}
