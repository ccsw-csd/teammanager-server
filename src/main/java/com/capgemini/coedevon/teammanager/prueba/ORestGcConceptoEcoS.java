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
 * ORestGcConceptoEcoS
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-20T06:08:01.090Z")
@Data
@JsonInclude(Include.NON_EMPTY)
public class ORestGcConceptoEcoS {
  @ApiModelProperty(value = "Nombre corto del concepto_economico")
  private String abrEco = null;

  @ApiModelProperty(value = "atributo económico. Mutualidad almacena IMP_COB_CPC_CARGO, importe de cargo de la cobertura especifica para el concepto prima cuota de la cuota en cuestion.")
  private BigDecimal atrEco1 = null;

  @ApiModelProperty(value = "Campo clave")
  private String clave = null;

  @ApiModelProperty(value = "Codigo de la cobertura. Posibles valores en la tabla [[TRON.EMIS.COBERTURAS_CIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codCob = null;

  @ApiModelProperty(value = "Codigo de concepto economico. Posibles valores en la tabla [[TRON.TESO.CONCEPTOS_ECONOMICOS_RECIBOS]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codEco = null;

  @ApiModelProperty(value = "Codigo de idioma. Posibles valores en la tabla [[TRON.DATC.IDIOMAS]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codIdioma = null;

  @ApiModelProperty(value = "Fecha de validez. Formato de fecha ('yyyy-mm-ddThh:MM:ssZ')")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private Date fecValidez = null;

  @ApiModelProperty(value = "Importe del concepto economico para la cuota en cuestion")
  private BigDecimal impEco = null;

  @ApiModelProperty(value = "Importe de concepto economico del recibo")
  private BigDecimal impEcoRecibo = null;

  @ApiModelProperty(value = "Importe resto del concepto economico")
  private BigDecimal impEcoResto = null;

  @ApiModelProperty(value = "Importe total del concepto economico")
  private BigDecimal impEcoTotal = null;

  @ApiModelProperty(value = "Indica si se aplica la cuota 1. Posibles valores [S - SI SE APLICA, N - NO SE APLICA]")
  private String mcaAplicaCuota1 = null;

  @ApiModelProperty(value = "Indica si se calculan comisiones. Posibles valores [S - SI SE CALCULAN, N - NO SE CALCULAN]")
  private String mcaCalCom = null;

  @ApiModelProperty(value = "Indica si se fracciona o el importe total pasa al primer recibo. Posibles valores [S - SE FRACCIONA, N - NO SE FRACCIONA]")
  private String mcaFracc = null;

  @ApiModelProperty(value = "Marca de inhabilitacion del registro. Posibles valores [S - REGISTRO INHABILITADO, N - REGISTRO HABITLITADO]")
  private String mcaInh = null;

  @ApiModelProperty(value = "Indica si el concepto es especifico para el calculo de intereses (planes de pago). Posibles valores [S - ES ESPECIFICO, N - NO ES ESPECIFICO]")
  private String mcaInteres = null;

  @ApiModelProperty(value = "Indica si se calcula el porcentaje de impuestos. Posibles valores [S - SI SE CALCULA, N - NO SE CALCULA]")
  private String mcaPctImp = null;

  @ApiModelProperty(value = "Marca que indica si un cod_eco es un recargo del plan de pago cliente. Posibles valores [S - SI ES RECARGO, N - NO ES RECARGO]")
  private String mcaRecFracPpc = null;

  @ApiModelProperty(value = "Marca que indica si el numero de orden de pago esta reservado. Posibles valores [S - RESERVADO, N - NO RESERVADO]")
  private String mcaReserva = null;

  @ApiModelProperty(value = "Descripcion reducida de la cobertura. Posibles valores en la tabla [[TRON.EMIS.COBERTURAS_CIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomCob = null;

  @ApiModelProperty(value = "Descripcion del concepto economico. Posibles valores en la tabla [[TRON.TESO.CONCEPTOS_ECONOMICOS_RECIBOS]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomEco = null;

  @ApiModelProperty(value = "Procedimiento de calculo")
  private String nomPrgCal = null;

  @ApiModelProperty(value = "Descripción asociada al tipo de concepto económico. Posibles valores en la tabla [[TRON.TPES.TIP_COD_ECO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomTipCodEco = null;

  @ApiModelProperty(value = "Numero de cuota")
  private Integer numCuota = null;

  @ApiModelProperty(value = "Numero de recibo")
  private Long numRecibo = null;

  @ApiModelProperty(value = "Numero de secuencia del concepto economico")
  private Integer numSecuEco = null;

  @ApiModelProperty(value = "Porcentaje del concepto economico")
  private BigDecimal pctEco = null;

  @ApiModelProperty(value = "Tipo de concepto económico. Posibles valores en la tabla [[TRON.TPES.TIP_COD_ECO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipCodEco = null;



}
