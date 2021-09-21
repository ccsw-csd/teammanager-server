/*
 * Tratar Datos Pólizas (NT21)
 * El servicio descrito en el siguiente documento hace referencia a las operaciones de tratamiento de polizas en la base de datos de tron21.
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.capgemini.coedevon.teammanager.prueba;

import java.util.Objects;
import java.util.Arrays;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.IOException;
import java.util.Date;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * GcPolizas
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-20T06:08:01.090Z")
@Data
@JsonInclude(Include.NON_EMPTY)
public class GcPolizas {
  @ApiModelProperty(value = "Código interno del elemento")
  private String codIntElem = null;

  @ApiModelProperty(value = "Código de la oficina bancaria.")
  private String codOficina = null;

  @ApiModelProperty(value = "Codigo de la forma de pago/plan de pago. Posibles valores en la tabla [[TRON.EMIS.PLANES_PAGO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codPlanPago = null;

  @ApiModelProperty(value = "Codigo del ramo. Posibles valores en la tabla [[TRON.EMIS.RAMOS]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codRamo = null;

  @ApiModelProperty(value = "Codigo del sector. Posibles valores en la tabla [[TRON.DATC.SECTORES]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codSector = null;

  @ApiModelProperty(value = "Codigo de tercero agente")
  private String codTerceroAgt = null;

  @ApiModelProperty(value = "Tipo de negocio. Posibles valores en la tabla [[TRON.CSTR.COD_TIP_NEGOCIO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codTipNegocio = null;

  @ApiModelProperty(value = "Fecha de efecto de la poliza. Formato de fecha ('yyyy-mm-ddThh:MM:ssZ')")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private Date fecEfecPoliza = null;

  @ApiModelProperty(value = "Fecha de emision inicial de la poliza. Formato de fecha ('yyyy-mm-ddThh:MM:ssZ')")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private Date fecEm = null;

  @ApiModelProperty(value = "Fecha de validez de la intervención. Formato de fecha ('yyyy-mm-ddThh:MM:ssZ')")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private Date fecValidezInterv = null;

  @ApiModelProperty(value = "Fecha de vencimiento de la poliza. Formato de fecha ('yyyy-mm-ddThh:MM:ssZ')")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private Date fecVctoPoliza = null;

  @ApiModelProperty(value = "Nombre del contrato")
  private String nomContrato = null;

  @ApiModelProperty(value = "Descripcion del riesgo")
  private String nomRiesgo = null;

  @ApiModelProperty(value = "Número de aplicación")
  private Integer numApli = null;

  @ApiModelProperty(value = "Numero de contrato")
  private Integer numContrato = null;

  @ApiModelProperty(value = "Numero de cuotas que tienE")
  private Integer numCuotas = null;

  @ApiModelProperty(value = "Numero de periodo del recibo")
  private Integer numPeriodoRecibo = null;

  @ApiModelProperty(value = "Numero de póliza")
  private String numPoliza = null;

  @ApiModelProperty(value = "Numero de poliza grupo")
  private String numPolizaGrupo = null;

  @ApiModelProperty(value = "Numero de recibo")
  private Long numRecibo = null;

  @ApiModelProperty(value = "Numero de renovaciones")
  private Integer numRenovaciones = null;

  @ApiModelProperty(value = "Número identificador del suplemento de la póliza")
  private Integer numSpto = null;

  @ApiModelProperty(value = "Número identificador de suplemento de aplicación")
  private Integer numSptoApli = null;

  @ApiModelProperty(value = "Tipo de reaseguro. Posibles valores en la tabla [[TRON.TPES.TIP_REA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipRea = null;

  @ApiModelProperty(value = "Tipo de situación de la póliza. Posibles valores en la tabla [[TRON.TPES.TIP_SITU_POLIZA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipSituPoliza = null;



}
