package com.capgemini.coedevon.teammanager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.coedevon.teammanager.utils.UtilsServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PruebaTest {

  @Test
  public void Prueba() {

    UtilsServiceImpl service = new UtilsServiceImpl();
    Assert.assertEquals("1.3.1", service.getVersion());
  }
}
