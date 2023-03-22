package com.github.nalukit.nalu.simple.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AppErrorController
    implements org.springframework.boot.web.servlet.error.ErrorController {

  @GetMapping("/error")
  public ModelAndView handleError(HttpServletRequest request,
                                  RedirectAttributes redirectAttributes,
                                  Model model) {
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

    redirectAttributes.getFlashAttributes()
                      .clear();
    redirectAttributes.asMap()
                      .clear();

    model.asMap()
         .clear();

    if (status != null) {
      int statusCode = Integer.parseInt(status.toString());
      if (statusCode == HttpStatus.NOT_FOUND.value()) {
        return new ModelAndView("redirect:/error/error-404.html");
      } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
        return new ModelAndView("redirect:/error/error-500.html");
      }
    }
    return new ModelAndView("redirect:/error/error.html");
  }
}
