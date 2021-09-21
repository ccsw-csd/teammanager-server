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
import java.math.BigDecimal;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * ORestPlzInfAdicionalAgrS
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-20T06:08:01.090Z")
@Data
@JsonInclude(Include.NON_EMPTY)
public class ORestPlzInfAdicionalAgrS {
  @ApiModelProperty(value = "Abreviatura del campo")
  private String abrCampo = null;

  @ApiModelProperty(value = "codigo de agravante. Posibles valores en la tabla [[TRON.EMIS.AGRAVANTES]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codAgr = null;

  @ApiModelProperty(value = "codigo de campo de valor almacenado. Posibles valores en la tabla [[TRON.EMIS.DATOS_VARIABLES_CIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codCampo = null;

  @ApiModelProperty(value = "codigo de compañia. Posibles valores en la tabla [[TRON.DATC.COMPANIAS]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codCia = null;

  @ApiModelProperty(value = "codigo de la cobertura. Posibles valores en la tabla [[TRON.EMIS.COBERTURAS_CIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codCob = null;

  @ApiModelProperty(value = "codigo del indice de revalorizacion. Posibles valores en la tabla [[TRON.EMIS.INDICES_REFERENCIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codIndice = null;

  @ApiModelProperty(value = "forma de intervencion. Posibles valores en la tabla [[TRON.ESTR.INTERVENCIONES_AGENTES]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codInterv = null;

  @ApiModelProperty(value = "codigo de lista")
  private Integer codListaOcu = null;

  @ApiModelProperty(value = "version de la lista de valores")
  private Integer codVersionAyuda = null;

  @ApiModelProperty(value = "Integeritud del campo")
  private Integer lngCampo = null;

  @ApiModelProperty(value = "Marca que indica si los calculos se han realizado por este tercero. Posibles valores [S - REALIZADOS, N - NO REALIZADOS]")
  private String mcaCal = null;

  @ApiModelProperty(value = "Marca que indica si se consolida en la operacion. Posibles valores [S - CONSOLIDA, N - NO CONSOLIDA]")
  private String mcaConsolida = null;

  @ApiModelProperty(value = "Marca que indica si la revalorizacion, actua como depreciacion. Posibles valores [S - DEPRECIA, N - NO DEPRECIA]")
  private String mcaDeprecia = null;

  @ApiModelProperty(value = "Marca qie indica si se grabara el dato al rechazar la poliza. Posibles valores [S - SE GRABARA, N - NO SE GRABARA]")
  private String mcaGrabaRechazo = null;

  @ApiModelProperty(value = "marca de inhabilitacion del registro. Esta marca se utilizará para indicar si se solicita recuperar las ocurrencias habilitadas, inhabilitadas o todas: - valor N: Registros habilitados - valor S: Registros inhabilitados - valor A: Ambos. Si se envía vacío, el valor por defecto es A.")
  private String mcaInh = "A";

  @ApiModelProperty(value = "Marca que indica si la contratacion de la cobertura provoca la necesidad de tener inspeccionado el riesgo. Posibles valores [S - INSPECCIONADO, N - NO INSPECCIONADO]")
  private String mcaInsp = null;

  @ApiModelProperty(value = "Marca que indica si es obligatorio. Posibles valores [S - OBLIGATORIO, N - NO OBLIGATORIO]")
  private String mcaObl = null;

  @ApiModelProperty(value = "marca de presupuesto")
  private String mcaPresupuesto = null;

  @ApiModelProperty(value = "Marca que si es: S si se ha de inicializar el dv con el valor por defecto y N en caso contrario")
  private String mcaRefresca = null;

  @ApiModelProperty(value = "marca de que indica si es actualizable. Posibles valores [S - ACTUALIZABLE, N - NO ACTUALIZABLE]")
  private String mcaSalto = null;

  @ApiModelProperty(value = "Marca que indica si el valor del dato se pedira en un riesgo copiado. Posibles valores [S - SE PEDIRA, N - NO SE PEDIRA]")
  private String mcaSolicitaEnCopia = null;

  @ApiModelProperty(value = "marca que indica si el dato variable es susceptible de ser traducido o no. Posibles valores [S - SE TRADUCIRA, N - NO SE TRADUCIRA]")
  private String mcaTraducible = null;

  @ApiModelProperty(value = "Marca que indica si es unico en la base de datos. Posibles valores [S - ES UNICO, N - NO ES UNICO]")
  private String mcaUnico = null;

  @ApiModelProperty(value = "Marca que lanza la validacion aunque no tenga valor. Posibles valores [S - LANZA VALIDACION, N - NO LANZA VALIDACION]")
  private String mcaValidaSiNull = null;

  @ApiModelProperty(value = "Marca que indica si es visible. Posibles valores [S - VISIBLE, N - NO VISIBLE]")
  private String mcaVisible = null;

  @ApiModelProperty(value = "descripcion del agravante. Posibles valores en la tabla [[TRON.EMIS.AGRAVANTES]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomAgr = null;

  @ApiModelProperty(value = "nombre de campo")
  private String nomCampo = null;

  @ApiModelProperty(value = "nombre  de la compania. Posibles valores en la tabla [[TRON.DATC.COMPANIAS]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomCia = null;

  @ApiModelProperty(value = "descripcion reducida de la cobertura. Posibles valores en la tabla [[TRON.EMIS.COBERTURAS_CIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomCob = null;

  @ApiModelProperty(value = "Descripcion version de la lista de valores")
  private String nomCodVersionAyuda = null;

  @ApiModelProperty(value = "nombre del indice. por ejemplo 'indice de precios al consumo' (ipc). Posibles valores en la tabla [[TRON.EMIS.INDICES_REFERENCIA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomIndice = null;

  @ApiModelProperty(value = "descripcion de la intervencion. Posibles valores en la tabla [[TRON.ESTR.INTERVENCIONES_AGENTES]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomInterv = null;

  @ApiModelProperty(value = "nombre de lista de ocurrencias")
  private String nomListaOcu = null;

  @ApiModelProperty(value = "procedimiento de validacion")
  private String nomPrgCampo = null;

  @ApiModelProperty(value = "procedimiento de pre-field")
  private String nomPrgPreCampo = null;

  @ApiModelProperty(value = "en caso de revalorizar por objeto, este campo indica el nombre del objeto")
  private String nomPrgRevalorizaEsp = null;

  @ApiModelProperty(value = "Descripcion del tipo de campo. Posibles valores en la tabla [[TRON.TPES.TIP_CAMPO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomTipCampo = null;

  @ApiModelProperty(value = "Descripcion del nivel del dato variable. Posibles valores en la tabla [[TRON.TPES.TIP_NIVEL]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomTipNivel = null;

  @ApiModelProperty(value = "Descripcion del origen del dato variable. Posibles valores en la tabla [[TRON.TPES.TIP_ORIGEN_DV]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomTipOrigenDv = null;

  @ApiModelProperty(value = "Descripcion que indica si revaloriza o no en la renovacion (1) no regulariza (2) especial (3) riesgo. Posibles valores en la tabla [[TRON.TPES.TIP_REVALORIZA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomTipRevaloriza = null;

  @ApiModelProperty(value = "Descripcion del tipo de revalorizacion. Posibles valores en la tabla [[TRON.TPES.TIP_REVALORIZA_ESP]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String nomTipRevalorizaEsp = null;

  @ApiModelProperty(value = "número de aplicación")
  private Integer numApli = null;

  @ApiModelProperty(value = "numero de periodo")
  private Integer numPeriodo = null;

  @ApiModelProperty(value = "numero de póliza")
  private String numPoliza = null;

  @ApiModelProperty(value = "numero de riesgo.")
  private Integer numRiesgo = null;

  @ApiModelProperty(value = "secuencia de la fila")
  private Integer numSecu = null;

  @ApiModelProperty(value = "número identificador del suplemento de la póliza")
  private Integer numSpto = null;

  @ApiModelProperty(value = "número identificador de suplemento de aplicación")
  private Integer numSptoApli = null;

  @ApiModelProperty(value = "porcentaje de revalorizacion")
  private BigDecimal pctRevalorizaEsp = null;

  @ApiModelProperty(value = "tipo de campo. Posibles valores en la tabla [[TRON.TPES.TIP_CAMPO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipCampo = null;

  @ApiModelProperty(value = "nivel del dato variable. Posibles valores en la tabla [[TRON.TPES.TIP_NIVEL]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipNivel = null;

  @ApiModelProperty(value = "origen del dato variable. Posibles valores en la tabla [[TRON.TPES.TIP_ORIGEN_DV]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipOrigenDv = null;

  @ApiModelProperty(value = "indica si revaloriza o no en la renovacion (1) no regulariza (2) especial (3) riesgo. Posibles valores en la tabla [[TRON.TPES.TIP_REVALORIZA]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipRevaloriza = null;

  @ApiModelProperty(value = "tipo de revalorizacion. Posibles valores en la tabla [[TRON.TPES.TIP_REVALORIZA_ESP]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String tipRevalorizaEsp = null;

  @ApiModelProperty(value = "descripcion del dato variable")
  private String txtCampo = null;

  @ApiModelProperty(value = "valor del dato variable")
  private String valCampo = null;

  @ApiModelProperty(value = "las 10 primeras posiciones del valor del dato variable")
  private String valCorCampo = null;

  @ApiModelProperty(value = "valor por defecto")
  private String valDef = null;

  @ApiModelProperty(value = "valor del origen de la informacion")
  private String valOrigenDv = null;



}

