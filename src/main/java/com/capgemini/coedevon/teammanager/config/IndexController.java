package com.capgemini.coedevon.teammanager.config;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pajimene
 *
 */
@RequestMapping(value = "/")
@RestController
public class IndexController {

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public void index(HttpServletResponse response) throws IOException {

    response.sendRedirect("/index.html");
  }
}
