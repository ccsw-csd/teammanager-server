package com.capgemini.coedevon.teammanager;
import org.junit.Assert;
import org.junit.Test;

import com.capgemini.coedevon.teammanager.utils.UtilsServiceImpl;

public class PruebaTest {

  @Test
  public void Prueba() {

    UtilsServiceImpl service = new UtilsServiceImpl();
    Assert.assertEquals("1.3.1", service.getVersion());
  }
}
