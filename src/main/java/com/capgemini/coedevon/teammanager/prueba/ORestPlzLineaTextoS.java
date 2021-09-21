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
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * ORestPlzLineaTextoS
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-20T06:08:01.090Z")
@Data
@JsonInclude(Include.NON_EMPTY)
public class ORestPlzLineaTextoS {
  @ApiModelProperty(value = "codigo de campo de valor almacenado. Posibles valores en la tabla [[TRON.EMIS.DATOS_VARIABLES_CIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codCampo = null;

  @ApiModelProperty(value = "codigo de compañia. Posibles valores en la tabla [[TRON.DATC.COMPANIAS]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codCia = null;

  @ApiModelProperty(value = "codigo de clausula. Posibles valores en la tabla [[TRON.EMIS.CLAUSULAS_POLIZA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codClausula = null;

  @ApiModelProperty(value = "codigo de la cobertura. Posibles valores en la tabla [[TRON.EMIS.COBERTURAS_CIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codCob = null;

  @ApiModelProperty(value = "codigo del texto, (carta) que se quiere enviar)")
  private String codTxt = null;

  @ApiModelProperty(value = "usuario que crea/actualiza el registro")
  private String codUsr = null;

  @ApiModelProperty(value = "Marca que indica si incluye texto variable. Posibles valores [S - INCLUYE, N - NO INCLUYE]")
  private String mcaTxtVariable = null;

  @ApiModelProperty(value = "nombre de campo. Posibles valores en la tabla [[TRON.EMIS.DATOS_VARIABLES_CIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomCampo = null;

  @ApiModelProperty(value = "nombre  de la compania. Posibles valores en la tabla [[TRON.DATC.COMPANIAS]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomCia = null;

  @ApiModelProperty(value = "nombre de la clausula. Posibles valores en la tabla [[TRON.EMIS.CLAUSULAS_POLIZA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomClausula = null;

  @ApiModelProperty(value = "descripcion reducida de la cobertura. Posibles valores en la tabla [[TRON.EMIS.COBERTURAS_CIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomCob = null;

  @ApiModelProperty(value = "número de aplicación")
  private Integer numApli = null;

  @ApiModelProperty(value = "numero de periodo")
  private Integer numPeriodo = null;

  @ApiModelProperty(value = "numero de póliza")
  private String numPoliza = null;

  @ApiModelProperty(value = "numero de riesgo.")
  private Integer numRiesgo = null;

  @ApiModelProperty(value = "secuencia del texto")
  private Integer numSecuValTxt = null;

  @ApiModelProperty(value = "número identificador del suplemento de la póliza")
  private Integer numSpto = null;

  @ApiModelProperty(value = "número identificador de suplemento de aplicación")
  private Integer numSptoApli = null;

  @ApiModelProperty(value = "texto de la clausula")
  private String valTxt = null;



}

