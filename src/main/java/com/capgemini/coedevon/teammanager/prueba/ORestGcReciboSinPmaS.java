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
 * ORestGcReciboSinPmaS
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-20T06:08:01.090Z")
@Data
@JsonInclude(Include.NON_EMPTY)
public class ORestGcReciboSinPmaS {
  @ApiModelProperty(value = "Código de documento. Posibles valores en la tabla [[TRON.TPES.TIP_CLASE_DOCTO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codDocto = null;

  @ApiModelProperty(value = "Código de elemento interno (estructura-nivel-elemento) de la estructura a la que está asignado el recibo.")
  private String codIntElem = null;

  @ApiModelProperty(value = "Código del tipo de recibo. Posibles valores en la tabla [[TRON.CSTR.COD_TIP_RECIBO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codTipRecibo = null;

  @ApiModelProperty(value = "Fecha contable. Para el asiento de emisión, se puede utilizar como la primera fecha de puesta al cobro del recibo (primera fecha de remesa). Formato de fecha ('yyyy-mm-ddThh:MM:ssZ')")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private Date fecCtable = null;

  @ApiModelProperty(value = "Descripción asociada al código de documento. Posibles valores en la tabla [[TRON.TPES.TIP_CLASE_DOCTO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomDocto = null;

  @ApiModelProperty(value = "Descripción del tipo de recibo. Posibles valores en la tabla [[TRON.CSTR.COD_TIP_RECIBO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomTipRecibo = null;

  @ApiModelProperty(value = "Número de documento, número de factura")
  private String numDocto = null;

  @ApiModelProperty(value = "Número de expediente")
  private Integer numExp = null;

  @ApiModelProperty(value = "Número de orden pago/cobro para siniestros")
  private String numOrdPagocobSini = null;

  @ApiModelProperty(value = "Número de recibo")
  private Long numRecibo = null;

  @ApiModelProperty(value = "Número de referencia del recibo")
  private String numRefRecibo = null;

  @ApiModelProperty(value = "Número de siniestro")
  private String numSini = null;

  @ApiModelProperty(value = "Observaciones del recibo")
  private String obsRecibo = null;



}

