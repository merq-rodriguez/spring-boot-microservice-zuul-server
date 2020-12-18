package com.example.app.zuulserver.filters;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PostElapseTimeFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(PreElapseTimeFilter.class);
  
  @Override
  public Object run() throws ZuulException {
    //Aqui se ejecuta la logica del filtro
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();

    log.info("Entrando a post filter");
    
    Long timeInit = (Long) request.getAttribute("timeInit");
    Long timeEnd = System.currentTimeMillis();
    Long timeElapsed = timeEnd - timeInit;
    
    log.info(String.format("Tiempo transcurrido en segundos: %s", timeElapsed.doubleValue() /1000.00));
    log.info(String.format("Tiempo transcurrido en milisegundos: %s", timeElapsed));
    return null;
  }

  @Override
  public boolean shouldFilter() {
    return false;
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public String filterType() {
    //Se establece el tipo de filtro (pre | post | route)
    return "post";
  }

}
