package com.github.nalukit.example.nalu.server.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@SuppressWarnings("serial")
public class TreckingService
    extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response)
      throws ServletException, IOException {
    this.doPost(request,
                response);
  }

  @Override
  protected void doPost(HttpServletRequest request,
                        HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println(request.getReader()
                              .lines()
                              .collect(Collectors.joining(System.lineSeparator())));
  }

}