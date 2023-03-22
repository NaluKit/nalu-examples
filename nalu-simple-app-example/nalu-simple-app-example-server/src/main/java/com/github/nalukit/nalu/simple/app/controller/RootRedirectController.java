package com.github.nalukit.nalu.simple.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RootRedirectController {

  @GetMapping("/")
  public ModelAndView redirectToIndexHtml(ModelMap model) {
    return new ModelAndView("redirect:/index.html");
  }

}
