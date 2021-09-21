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
 * Desglose
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-20T06:08:01.090Z")
@Data
@JsonInclude(Include.NON_EMPTY)
public class Desglose {
  @ApiModelProperty(value = "Abreviatura del desglose")
  private String abrDes = null;

  @ApiModelProperty(value = "atributo de desglose")
  private String atrDes1 = null;

  @ApiModelProperty(value = "atributo de desglose")
  private String atrDes2 = null;

  @ApiModelProperty(value = "atributo de desglose")
  private String atrDes3 = null;

  @ApiModelProperty(value = "codigo de compañia. Posibles valores en la tabla [[TRON.DATC.COMPANIAS]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codCia = null;

  @ApiModelProperty(value = "codigo de la cobertura. Posibles valores en la tabla [[TRON.EMIS.COBERTURAS_CIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codCob = null;

  @ApiModelProperty(value = "codigo de concepto de desglose. Posibles valores en la tabla [[TRON.EMIS.CONCEPTOS_DESGLOSE_CIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codDes = null;

  @ApiModelProperty(value = "concepto economico. Posibles valores en la tabla [[TRON.TESO.CONCEPTOS_ECONOMICOS_RECIBOS]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codEco = null;

  @ApiModelProperty(value = "codigo de moneda. Posibles valores en la tabla [[TRON.DATC.MONEDAS]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codMon = null;

  @ApiModelProperty(value = "codigo de la forma de pago/plan de pago. Posibles valores en la tabla [[TRON.EMIS.PLANES_PAGO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codPlanPago = null;

  @ApiModelProperty(value = "fecha de validez. Formato de fecha ('yyyy-mm-ddThh:MM:ssZ')")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private Date fecValidez = null;

  @ApiModelProperty(value = "importe acumulado en la anualidad")
  private BigDecimal impAcumAnual = null;

  @ApiModelProperty(value = "importe del concepto de desglose para una anualidad completa. independientemente de la fecha de efecto del suplemento (o de la emision si se trata del suplemento 0), los calculos se realizan por una anualidad completa. el dato que indica lo que se va cobrar por el concepto de desglose en el periodo vigente (que puede no ser una anualidad completa) es el importe acumulado anual.")
  private BigDecimal impAnual = null;

  @ApiModelProperty(value = "si se ha elegido como tipo de calculo  importe o importe por unidad, se almacena este importe")
  private BigDecimal impCal = null;

  @ApiModelProperty(value = "importe de prima minima")
  private BigDecimal impCalMin = null;

  @ApiModelProperty(value = "importe no consumido en el momento de realizar el suplemento si el suplemento es el 0 (emision de la poliza) el importe no consumido sera 0.")
  private BigDecimal impNoConsumido = null;

  @ApiModelProperty(value = "importe del concepto de desglose para el suplemento se almacena aqui el importe de prima correspondiente al suplemento. si el suplemento es el 0 (emision de la poliza) sera el importe total.")
  private BigDecimal impSpto = null;

  @ApiModelProperty(value = "marca que indica si es prorrateable el concepto. Posibles valores [S - PRORRATEABLE, N - NO PRORRATEABLE]")
  private String mcaAplicaProrrata = null;

  @ApiModelProperty(value = "marca que indica si el concepto se calcula de forma automatica, aunque la poliza tenga primas manuales. Posibles valores [S - AUTOMATICO, N - NO AUTOMATICO]")
  private String mcaCalAut = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 0 a nivel de cobertura. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalC0 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 1 a nivel de cobertura. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalC1 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 2 a nivel de cobertura. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalC2 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 3 a nivel de cobertura. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalC3 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 4 a nivel de cobertura. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalC4 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 5 a nivel de cobertura. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalC5 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 6 a nivel de cobertura. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalC6 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 7 a nivel de cobertura. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalC7 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 8 a nivel de cobertura. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalC8 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 9 a nivel de cobertura. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalC9 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 0 a nivel de poliza. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalP0 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 1 a nivel de poliza. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalP1 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 2 a nivel de poliza. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalP2 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 3 a nivel de poliza. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalP3 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 4 a nivel de poliza. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalP4 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 0 a nivel de riesgo. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalR0 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 1 a nivel de riesgo. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalR1 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 2 a nivel de riesgo. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalR2 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 3 a nivel de riesgo. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalR3 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 4 a nivel de riesgo. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalR4 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 0 a nivel total de poliza. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalT0 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 1 a nivel total de poliza. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalT1 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 2 a nivel total de poliza. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalT2 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 3 a nivel total de poliza. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalT3 = null;

  @ApiModelProperty(value = "marca que indica si se acumula o no en el bloque 4 a nivel total de poliza. Posibles valores [S - SE ACUMULA, N - NO SE ACUMULA]")
  private String mcaDepositaCalT4 = null;

  @ApiModelProperty(value = "marca que indica si el concepto se devuelve en caso de anulacion de la poliza. Posibles valores [S - SE DEVUELVE, N - NO SE DEVUELVE]")
  private String mcaDev = null;

  @ApiModelProperty(value = "marca de inhabilitacion del registro. Esta marca se utilizará para indicar si se solicita recuperar las ocurrencias habilitadas, inhabilitadas o todas: - valor N: Registros habilitados - valor S: Registros inhabilitados - valor A: Ambos. Si se envía vacío, el valor por defecto es A.")
  private String mcaInh = "A";

  @ApiModelProperty(value = "si el campo tip_act_aum_no_mod es (4) objeto, se indica el nombre del objeto")
  private String nomPrgAumNoMod = null;

  @ApiModelProperty(value = "si el campo tip_act_aum_si_mod es (4) objeto, se indica el nombre del objeto")
  private String nomPrgAumSiMod = null;

  @ApiModelProperty(value = "si en campo tip_act_baj_no_mod es (4) objeto, se indica el nombre del objeto")
  private String nomPrgBajaNoMod = null;

  @ApiModelProperty(value = "si el campo tip_act_baj_si_mod es (4)objeto, indica el nombre del objeto")
  private String nomPrgBajaSiMod = null;

  @ApiModelProperty(value = "procedimiento de calculo")
  private String nomPrgCal = null;

  @ApiModelProperty(value = "procedimiento de calculo de la prima minima")
  private String nomPrgCalMin = null;

  @ApiModelProperty(value = "si el campo tip_act_man_no_mod es (4) objeto indica el nombre del objeto")
  private String nomPrgManNoMod = null;

  @ApiModelProperty(value = "si el campo tip_act_man_si_mod es (4) objeto, indica el nombre del objeto")
  private String nomPrgManSiMod = null;

  @ApiModelProperty(value = "procedimiento de calculo de importe no consumido")
  private String nomPrgNoConsumido = null;

  @ApiModelProperty(value = "número de aplicación")
  private Integer numApli = null;

  @ApiModelProperty(value = "numero de periodo")
  private Integer numPeriodo = null;

  @ApiModelProperty(value = "numero de póliza.")
  private String numPoliza = null;

  @ApiModelProperty(value = "numero de riesgo.")
  private Integer numRiesgo = null;

  @ApiModelProperty(value = "secuencia de la fila")
  private Integer numSecu = null;

  @ApiModelProperty(value = "número identificador del suplemento de la póliza")
  private Integer numSpto = null;

  @ApiModelProperty(value = "número identificador de suplemento de aplicación")
  private Integer numSptoApli = null;

  @ApiModelProperty(value = "tasa aplicada al calculo del importe del concepto de desglose")
  private Integer numTasaDes = null;

  @ApiModelProperty(value = "si se ha elegido como tipo de calculo tanto por ciento o tanto por mil, se almacena el tanto")
  private BigDecimal tasaCal = null;

  @ApiModelProperty(value = "indica el tipo de accion que tomara en el caso de que un suplemento aumente el capital sin modificar la estructura de contratacion (1) tarifa actual (2) tarifa original (3) mixta (4) objeto. Posibles valores en la tabla [[TRON.TPES.TIP_ACCION_AUM_NO_MOD]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipAccionAumNoMod = null;

  @ApiModelProperty(value = "indica el tipo de accion que tomara en el caso de que un suplemento aumente el capital y se ha cambiado la estructura de contratacion (1) tarifa actual (4) objeto. Posibles valores en la tabla [[TRON.TPES.TIP_ACCION_AUM_SI_MOD]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipAccionAumSiMod = null;

  @ApiModelProperty(value = "indica el tipo de accion que tomara en un suplemento que baja el capital sin modificar la estructura de contratacion (1)tarifa actual (2)tarifa original (4)objeto. Posibles valores en la tabla [[TRON.TPES.TIP_ACCION_BAJA_NO_MOD]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipAccionBajaNoMod = null;

  @ApiModelProperty(value = "indica el tipo de accion que tomara en un suplemento que baja el capital y se ha modificado la estructura de contratacion (1)tarifa actual (4) objeto. Posibles valores en la tabla [[TRON.TPES.TIP_ACCION_BAJA_SI_MOD]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipAccionBajaSiMod = null;

  @ApiModelProperty(value = "indica el tipo de accion que tomara en el caso de que un suplemento se mantenga el capital vigente sin modificar la estructura de contratacion (2) tarifa original (4) objeto. Posibles valores en la tabla [[TRON.TPES.TIP_ACCION_MAN_NO_MOD]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipAccionManNoMod = null;

  @ApiModelProperty(value = "indica el tipo de accion que tomara en el caso de que un suplemento se mantenga el capital vigente y modifica la estructura de contratacion (1) tarifa actual (4) objeto. Posibles valores en la tabla [[TRON.TPES.TIP_ACCION_MAN_SI_MOD]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipAccionManSiMod = null;

  @ApiModelProperty(value = "calculo utilizado. Posibles valores en la tabla [[TRON.TPES.TIP_APLICA_DES]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipAplicaDes = null;

  @ApiModelProperty(value = "base de calculo. Posibles valores en la tabla [[TRON.TPES.TIP_BASE_CAL]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipBaseCal = null;

  @ApiModelProperty(value = "tipo de calculo. Posibles valores en la tabla [[TRON.TPES.TIP_CAL_DES]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipCalDes = null;

  @ApiModelProperty(value = "se informa aqui el tipo de prima minima definido para la cobertura (0) sin prima minima (1) importe fijo (2) tabla (3) objeto. Posibles valores en la tabla [[TRON.TPES.TIP_CAL_MIN]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipCalMin = null;

  @ApiModelProperty(value = "tipo de concepto económico sus valores estarán definidos en la g1010031 y son (n) prima neta, (b) bonificación, (r) recargo, (i) impuesto. Posibles valores en la tabla [[TRON.TPES.TIP_COD_ECO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipCodEco = null;

  @ApiModelProperty(value = "indica el tipo de desglose. Posibles valores en la tabla [[TRON.TPES.TIP_DES]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipDes = null;



}

