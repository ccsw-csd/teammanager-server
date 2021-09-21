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
 * ORestGcComisionS
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-20T06:08:01.090Z")
@Data
@JsonInclude(Include.NON_EMPTY)
public class ORestGcComisionS {
  @ApiModelProperty(value = "Codigo de la cobertura. Posibles valores en la tabla [[TRON.EMIS.COBERTURAS_CIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codCob = null;

  @ApiModelProperty(value = "Codigo del cuadro de comision")
  private String codCuadroCom = null;

  @ApiModelProperty(value = "Codigo de intervencion del agente. Posibles valores en la tabla [[TRON.ESTR.INTERVENCIONES_AGENTES]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codIntervAgt = null;

  @ApiModelProperty(value = "Codigo de la modalidad.")
  private Integer codModalidad = null;

  @ApiModelProperty(value = "Codigo de tercero agente")
  private String codTerceroAgt = null;

  @ApiModelProperty(value = "Usuario que crea/actualiza el registro")
  private String codUsr = null;

  @ApiModelProperty(value = "Fecha de actualización. Formato de fecha ('yyyy-mm-ddThh:MM:ssZ')")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private Date fecActu = null;

  @ApiModelProperty(value = "Importe de la prima base para las comisiones netas")
  private BigDecimal impBaseNeta = null;

  @ApiModelProperty(value = "Importe de la prima base para las comisiones sobre los recargos")
  private BigDecimal impBaseReca = null;

  @ApiModelProperty(value = "Comision que se le paga al agente y que se calcula en base a la prima neta bonificada")
  private BigDecimal impComNeta = null;

  @ApiModelProperty(value = "Comision extra que recibe el agente sobre el recargo")
  private BigDecimal impComReca = null;

  @ApiModelProperty(value = "Marca que indica si es un movimiento de anulación. Posibles valores [S - SI ES ANULACION, N - NO ES ANULACION]")
  private String mcaInhCom = null;

  @ApiModelProperty(value = "Marca de vigente. Posibles valores [S - SI ES VIGENTE, N - NO ES VIGENTE]")
  private String mcaVigente = null;

  @ApiModelProperty(value = "Descripcion reducida de la cobertura. Posibles valores en la tabla [[TRON.EMIS.COBERTURAS_CIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomCob = null;

  @ApiModelProperty(value = "Descripción ascociada al codigo del agente")
  private String nomCodTerceroAgt = null;

  @ApiModelProperty(value = "Descripción de la intervencion del agente. Posibles valores en la tabla [[TRON.ESTR.INTERVENCIONES_AGENTES]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomIntervAgt = null;

  @ApiModelProperty(value = "Descripcion de la modalidad")
  private String nomModalidad = null;

  @ApiModelProperty(value = "Descripción del agente")
  private String nomTerceroAgt = null;

  @ApiModelProperty(value = "Descripción asociada al tipo de intervenciones del agente. Posibles valores en la tabla [[TRON.TPES.TIP_INTERV_AGT]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomTipIntervAgt = null;

  @ApiModelProperty(value = "Numero de cuota")
  private Integer numCuota = null;

  @ApiModelProperty(value = "Numero de movimiento de comisiones")
  private Integer numMvtoCom = null;

  @ApiModelProperty(value = "Numero de recibo")
  private Long numRecibo = null;

  @ApiModelProperty(value = "Numero de riesgo.")
  private Integer numRiesgo = null;

  @ApiModelProperty(value = "Porcentaje relativo sobre el agente principal")
  private BigDecimal pctAgt = null;

  @ApiModelProperty(value = "Tipo de intervenciones del agente. Posibles valores en la tabla [[TRON.TPES.TIP_INTERV_AGT]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipIntervAgt = null;



}

