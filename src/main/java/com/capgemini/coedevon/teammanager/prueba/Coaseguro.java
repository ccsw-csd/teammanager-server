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
import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Coaseguro
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-20T06:08:01.090Z")
@Data
@JsonInclude(Include.NON_EMPTY)
public class Coaseguro {
  @ApiModelProperty(value = "Abreviatura del cuadro")
  private String abrCuadroCoa = null;

  @ApiModelProperty(value = "Codigo de compañia.  Posibles valores en la tabla [[TRON.DATC.COMPANIAS]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codCia = null;

  @ApiModelProperty(value = "Cuadro de coaseguro cedido")
  private String codCuadroCoa = null;

  @ApiModelProperty(value = "Codigo de la compañia coaseguradora")
  private String codIntCoa = null;

  @ApiModelProperty(value = "Codigo de tercero en caso de tener clave alterna")
  private String codTercero = null;

  @ApiModelProperty(value = "Fecha de la remesa. Formato de fecha ('yyyy-mm-ddThh:MM:ssZ')")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private Date fecRemesaCoa = null;

  @ApiModelProperty(value = "Marca que indica si el reaseguro por cuenta comun. . Posibles valores [S - ES POR CUENTA COMUN, N - NO ES POR CUENTA COMUN]")
  private String mcaCtaComun = null;

  @ApiModelProperty(value = "Estado que se toma por defecto. Posibles valores [S - TOMA VALOR POR DEFECTO, N - NO TOMA VALOR POR DEFECTO]")
  private String mcaDef = null;

  @ApiModelProperty(value = "Marca de inhabilitacion del registro. Esta marca se utilizará para indicar si se solicita recuperar las ocurrencias habilitadas, inhabilitadas o todas: - valor N: Registros habilitados - valor S: Registros inhabilitados - valor A: Ambos. Si se envía vacío, el valor por defecto es A.")
  private String mcaInh = "A";

  @ApiModelProperty(value = "Número de aplicación")
  private Integer numApli = null;

  @ApiModelProperty(value = "Numero de póliza")
  private String numPoliza = null;

  @ApiModelProperty(value = "Numero de poliza a la que pertenece el coaseguro en la compañia coaseguradora")
  private String numPolizaCoa = null;

  @ApiModelProperty(value = "Identificador del coasegurador")
  private String numRemesaCoa = null;

  @ApiModelProperty(value = "Número identificador del suplemento de la póliza")
  private Integer numSpto = null;

  @ApiModelProperty(value = "Número identificador de suplemento de aplicación")
  private Integer numSptoApli = null;

  @ApiModelProperty(value = "Numero de suplemento a la que pertenece el coaseguro en la compañia coaseguradora")
  private String numSptoCoa = null;

  @ApiModelProperty(value = "Porcentaje de comision")
  private BigDecimal pctComCoa1 = null;

  @ApiModelProperty(value = "Porcentaje de comision")
  private BigDecimal pctComCoa2 = null;

  @ApiModelProperty(value = "Porcentaje de comision")
  private BigDecimal pctComCoa3 = null;

  @ApiModelProperty(value = "Porcentaje de comision")
  private BigDecimal pctComCoa4 = null;

  @ApiModelProperty(value = "Porcentaje participacion de la coaseguradora")
  private BigDecimal pctParticipaCoa = null;

  @ApiModelProperty(value = "Accion a realizar con la fila. Posibles valores en la tabla [[TRON.TPES.TIP_ACCION_BATCH_EM]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipAccionBatchEm = null;



}
