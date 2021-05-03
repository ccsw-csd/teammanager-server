package com.capgemini.coedevon.teammanager.utils;

import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.ws.rs.core.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author pajimene
 *
 */
@Service
public class UtilsServiceImpl implements UtilsService {

  private static final Logger LOG = LoggerFactory.getLogger(UtilsServiceImpl.class);

  /**
   * {@inheritDoc}
   */
  @Override
  public String getVersion() {

    try {
      return new Manifest(Application.class.getResourceAsStream("/META-INF/MANIFEST.MF")).getMainAttributes()
          .get(Attributes.Name.IMPLEMENTATION_VERSION).toString();
    } catch (IOException e) {
      LOG.error("Error al extraer la version", e);
    }

    return "?";
  }

}