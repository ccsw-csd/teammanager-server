package com.capgemini.coedevon.teammanager.group.model;

/**
 * TODO apastorm This type ...
 *
 */
public class RespuestaValidarBorradoDto {
  private String response;

  private boolean activo;

  /**
   * @return activo
   */
  public boolean isActivo() {

    return this.activo;
  }

  /**
   * @param activo new value of {@link #getactivo}.
   */
  public void setActivo(boolean activo) {

    this.activo = activo;
  }

  /**
   * @return Response
   */
  public String getResponse() {

    return this.response;
  }

  /**
   * @param Response new value of {@link #getresponse}.
   */
  public void setResponse(String response) {

    this.response = response;
  }

}
