package org.moita.sb2.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class WebControllerExceptionHandler {

    private static final String DEFAULT_ERROR_VIEW = "err";
    private static final String datetime = "datetime";
    private static final String exception = "exception";
    private static final String url = "url";

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
            ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);

        mav.addObject(datetime, new Date());
        mav.addObject(exception, e);
        mav.addObject(url, request.getRequestURL());
        return mav;
    }
}
