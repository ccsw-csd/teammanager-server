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
 * ORestPlzClausulaS
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-20T06:08:01.090Z")
@Data
@JsonInclude(Include.NON_EMPTY)
public class ORestPlzClausulaS {
  @ApiModelProperty(value = "Abreviatura de la clausula")
  private String abrClausula = null;

  @ApiModelProperty(value = "Codigo de compañia, Posibles valores en la tabla [[TRON.DATC.COMPANIAS]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codCia = null;

  @ApiModelProperty(value = "Codigo de clausula. Posibles valores en la tabla [[TRON.EMIS.CLAUSULAS_POLIZA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codClausula = null;

  @ApiModelProperty(value = "Codigo de la cobertura. . Posibles valores en la tabla [[TRON.EMIS.COBERTURAS_CIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codCob = null;

  @ApiModelProperty(value = "Marca de impresion. Posibles valores [S - IMPRESA, N - NO IMPRESA]")
  private String mcaImpresion = null;

  @ApiModelProperty(value = "Marca de inhabilitacion del registro. Esta marca se utilizará para indicar si se solicita recuperar las ocurrencias habilitadas, inhabilitadas o todas: - valor N: Registros habilitados - valor S: Registros inhabilitados - valor A: Ambos. Si se envía vacío, el valor por defecto es A.")
  private String mcaInh = "A";

  @ApiModelProperty(value = "Marca que indica si la estructura comercial del elemento ha sido modificada. Posibles valores [S - MEDIFICADA, N - NO MODIFICADA]")
  private String mcaMod = null;

  @ApiModelProperty(value = "Marca que indica la clausula seleccionada. Posibles valores [S - SE SELECCIONA, N - NO SE SELECCIONA]")
  private String mcaSeleccion = null;

  @ApiModelProperty(value = "Marca que indica si incluye texto variable. Posibles valores [S - SE INCLUYE, N - NO SE INCLUYE]")
  private String mcaTxtVariable = null;

  @ApiModelProperty(value = "Nombre  de la compania, Posibles valores en la tabla [[TRON.DATC.COMPANIAS]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomCia = null;

  @ApiModelProperty(value = "Nombre de la clausula. Posibles valores en la tabla [[TRON.EMIS.CLAUSULAS_POLIZA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomClausula = null;

  @ApiModelProperty(value = "Descripcion reducida de la cobertura. . Posibles valores en la tabla [[TRON.EMIS.COBERTURAS_CIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomCob = null;

  @ApiModelProperty(value = "Descripcion del procedimiento que determina si se selecciona la clausula")
  private String nomPrgClausula = null;

  @ApiModelProperty(value = "Descripcion de la accion a realizar con la fila. Posibles valores en la tabla [[TRON.TPES.TIP_ACCION_BATCH_EM]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomTipAccionBatchEm = null;

  @ApiModelProperty(value = "Descripcion tipo de accion de la clausula. Posibles valores en la tabla [[TRON.TPES.TIP_ACCION_CLAUSULA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomTipAccionClausula = null;

  @ApiModelProperty(value = "Descripcion tipo de asociacion a la emision. Posibles valores en la tabla [[TRON.TPES.TIP_ASOC_EM]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomTipAsocEm = null;

  @ApiModelProperty(value = "Descricpcion del tipo de modelo (n-normal, e-encriptado, p-personalizado)")
  private String nomTipModel = null;

  @ApiModelProperty(value = "Número de aplicación")
  private Integer numApli = null;

  @ApiModelProperty(value = "Numero de periodo")
  private Integer numPeriodo = null;

  @ApiModelProperty(value = "Numero de póliza")
  private String numPoliza = null;

  @ApiModelProperty(value = "Numero de riesgo.")
  private Integer numRiesgo = null;

  @ApiModelProperty(value = "Secuencia de la fila")
  private Integer numSecu = null;

  @ApiModelProperty(value = "Número identificador del suplemento de la póliza")
  private Integer numSpto = null;

  @ApiModelProperty(value = "Número identificador de suplemento de aplicación")
  private Integer numSptoApli = null;

  @ApiModelProperty(value = "Accion a realizar con la fila. Posibles valores en la tabla [[TRON.TPES.TIP_ACCION_BATCH_EM]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipAccionBatchEm = null;

  @ApiModelProperty(value = "Tipo de accion de la clausula. Posibles valores en la tabla [[TRON.TPES.TIP_ACCION_CLAUSULA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipAccionClausula = null;

  @ApiModelProperty(value = "Tipo de asociacion a la emision. Posibles valores en la tabla [[TRON.TPES.TIP_ASOC_EM]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipAsocEm = null;

  @ApiModelProperty(value = "Tipo de modelo (n-normal, e-encriptado, p-personalizado)")
  private String tipModel = null;



}

