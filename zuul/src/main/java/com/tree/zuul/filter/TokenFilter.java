package com.tree.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class TokenFilter extends ZuulFilter{

    @Override
    public String filterType() {
        return "pre";
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
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        log.info("--->> TokenFilter method: {}, url: {}", request.getMethod(), request.getRequestURL().toString());

        String authorization = request.getHeader("Authorization");
        if (StringUtils.isNotEmpty(authorization)) {
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(200);
            context.set("isSuccess", true);
            return null;
        }else {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(400);
            context.setResponseBody("token is empty");
            context.set("isSuccess", false);
            return null;
        }
    }
}
