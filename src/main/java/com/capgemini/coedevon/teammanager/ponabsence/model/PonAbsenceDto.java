package com.capgemini.coedevon.teammanager.ponabsence.model;

/**
 * @author pajimene
 *
 */
public class PonAbsenceDto {

  private Integer anio;

  private String codSaga;

  private String desde;

  private String hasta;

  private Integer dias;

  private Integer horas;

  private String estado;

  public PonAbsenceDto() {

  }

  public PonAbsenceDto(String dataLine) {

    String[] data = dataLine.split(";");

    this.anio = Integer.parseInt(data[0]);
    this.codSaga = data[1];
    this.desde = data[2];
    this.hasta = data[3];
    this.dias = Integer.parseInt(data[4]);
    this.horas = Integer.parseInt(data[5]);
    this.estado = data[6];

  }

  /**
   * @return anio
   */
  public Integer getAnio() {

    return this.anio;
  }

  /**
   * @param anio new value of {@link #getanio}.
   */
  public void setAnio(Integer anio) {

    this.anio = anio;
  }

  /**
   * @return codSaga
   */
  public String getCodSaga() {

    return this.codSaga;
  }

  /**
   * @param codSaga new value of {@link #getcodSaga}.
   */
  public void setCodSaga(String codSaga) {

    this.codSaga = codSaga;
  }

  /**
   * @return desde
   */
  public String getDesde() {

    return this.desde;
  }

  /**
   * @param desde new value of {@link #getdesde}.
   */
  public void setDesde(String desde) {

    this.desde = desde;
  }

  /**
   * @return hasta
   */
  public String getHasta() {

    return this.hasta;
  }

  /**
   * @param hasta new value of {@link #gethasta}.
   */
  public void setHasta(String hasta) {

    this.hasta = hasta;
  }

  /**
   * @return dias
   */
  public Integer getDias() {

    return this.dias;
  }

  /**
   * @param dias new value of {@link #getdias}.
   */
  public void setDias(Integer dias) {

    this.dias = dias;
  }

  /**
   * @return horas
   */
  public Integer getHoras() {

    return this.horas;
  }

  /**
   * @param horas new value of {@link #gethoras}.
   */
  public void setHoras(Integer horas) {

    this.horas = horas;
  }

  /**
   * @return estado
   */
  public String getEstado() {

    return this.estado;
  }

  /**
   * @param estado new value of {@link #getestado}.
   */
  public void setEstado(String estado) {

    this.estado = estado;
  }

}
