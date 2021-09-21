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
 * ORestGcReciboPmaS
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-20T06:08:01.090Z")
@Data
@JsonInclude(Include.NON_EMPTY)
public class ORestGcReciboPmaS {
  @ApiModelProperty(value = "Código de recibo que permite identificar unívocamente el recibo, permitiendo la actualización del numRecibo (en paralelo y por control técnico)")
  private Long codRecibo = null;

  @ApiModelProperty(value = "Formas de generación de remesa. Posibles valores en la tabla [[TRON.CSTR.COD_TIP_REMESA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codTipRemesa = null;

  @ApiModelProperty(value = "Fecha contable. Para el asiento de emisión, se puede utilizar como la primera fecha de puesta al cobro del recibo (primera fecha de remesa). Formato de fecha ('yyyy-mm-ddThh:MM:ssZ')")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private Date fecCtable = null;

  @ApiModelProperty(value = "Marca de descuento de comisiones. Posibles valores [S - si hay descuento, N - no hay descuento]")
  private String mcaDtoCom = null;

  @ApiModelProperty(value = "Marca que indica si es un movimiento que se tiene que tener en cuenta en el asiento de comisiones. Posibles valores  [S - si se tiene en cuenta, N - no se tiene en cuenta]")
  private String mcaOrigenCom = null;

  @ApiModelProperty(value = "Descripción asociada a las formas de generación de remesa. Posibles valores en la tabla [[TRON.CSTR.COD_TIP_REMESA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomCodTipRemesa = null;

  @ApiModelProperty(value = "Descripción asociada al tipo de coaseguro. Posibles valores en la tabla [[TRON.TPES.TIP_COA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomTipCoa = null;

  @ApiModelProperty(value = "Descripción asociada al tipo de remesa. Posibles valores en la tabla [[TRON.TPES.TIP_EMI_RECIBO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomTipEmiRecibo = null;

  @ApiModelProperty(value = "Movimiento de comisiones")
  private Integer numMvtoCom = null;

  @ApiModelProperty(value = "Número de recibo")
  private Long numRecibo = null;

  @ApiModelProperty(value = "Tipo de coaseguro. Posibles valores en la tabla [[TRON.TPES.TIP_COA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipCoa = null;

  @ApiModelProperty(value = "Tipo de remesa. Posibles valores en la tabla [[TRON.TPES.TIP_EMI_RECIBO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipEmiRecibo = null;



}
