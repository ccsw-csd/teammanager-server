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
import com.capgemini.coedevon.teammanager.prueba.Comisiones;
import com.capgemini.coedevon.teammanager.prueba.ConceptosEco;
import com.capgemini.coedevon.teammanager.prueba.ControlTecnico;
import com.capgemini.coedevon.teammanager.prueba.Cuotas;
import com.capgemini.coedevon.teammanager.prueba.GcPolizas;
import com.capgemini.coedevon.teammanager.prueba.GcRecibos;
import com.capgemini.coedevon.teammanager.prueba.GcTerceros;
import com.capgemini.coedevon.teammanager.prueba.InstalacionCuotas;
import com.capgemini.coedevon.teammanager.prueba.InstalacionRecibos;
import com.capgemini.coedevon.teammanager.prueba.RecibosGrupo;
import com.capgemini.coedevon.teammanager.prueba.RecibosPrima;
import com.capgemini.coedevon.teammanager.prueba.RecibosSinPrima;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import java.util.Date;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * InAnularSuplemento
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-20T06:08:01.090Z")
@Data
@JsonInclude(Include.NON_EMPTY)
public class InAnularSuplemento {
  @ApiModelProperty(value = "Causa del suplemento. Posibles valores en la tabla [[TRON.EMIS.CAUSA_SUPLEMENTO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codCausaSpto = null;

  @ApiModelProperty(required = true, value = "Codigo de compañia")
  private Integer codCia = null;

  @ApiModelProperty(value = "Detalle del suplemento")
  private String codDetSpto = null;

  @ApiModelProperty(value = "Codigo de idioma. Posibles valores en la tabla [[TRON.DATC.IDIOMAS]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codIdioma = null;

  @ApiModelProperty(value = "Motivo del suplemento. Posibles valores en la tabla [[TRON.EMIS.MOTIVOS_SUPLEMENTO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codMotivoSpto = null;

  @ApiModelProperty(value = "Codigo del suplemento. Posibles valores en la tabla en la tabla [[TRON.EMIS.CODIGOS_SUPLEMENTO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codSpto = null;

  @ApiModelProperty(value = "Código de suplemento de anulación de anualidad. Posibles valores en la tabla [[TRON.EMIS.CODIGOS_SUPLEMENTO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codSptoAa = null;

  @ApiModelProperty(value = "Código de suplemento de anulación de temporales. Posibles valores en la tabla [[TRON.EMIS.CODIGOS_SUPLEMENTO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private Integer codSptoTmp = null;

  @ApiModelProperty(value = "Código de origen del recibo. Posibles valores en la tabla [[TRON.EMIS.ORIGEN_RECIBO]] del activo RAM Catálogo de Tablas de Núcleo [1.0]")
  private String codTipOrigenRecibo = null;

  @ApiModelProperty(value = "Código de usuario")
  private String codUsr = null;

  @ApiModelProperty(value = "Fecha de emisión del suplemento. Formato de fecha ('yyyy-mm-ddThh:MM:ssZ')")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private Date fecEmSpto = null;

  @ApiModelProperty(value = "Fecha de anulacion del suplemento. Formato de fecha ('yyyy-mm-ddThh:MM:ssZ')")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private Date fecEmSptoAnul = null;

  @ApiModelProperty(value = "Fecha de firma. Formato de fecha ('yyyy-mm-ddThh:MM:ssZ')")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private Date fecFirma = null;

  @ApiModelProperty(value = "Fecha de mecanización. Formato de fecha ('yyyy-mm-ddThh:MM:ssZ')")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private Date fecMecanizacion = null;

  @ApiModelProperty(value = "Incremento para generar los nuevos números de suplemento")
  private BigDecimal incrementoSpto = null;

  @ApiModelProperty(value = "Incremento público para generar los nuevos números de suplemento")
  private BigDecimal incrementoSptoPublico = null;

  @ApiModelProperty(value = "Listado de comisiones")
  private List<Comisiones> listaComisiones = null;

  @ApiModelProperty(value = "Listado de conceptos economicos")
  private List<ConceptosEco> listaConceptosEco = null;

  @ApiModelProperty(value = "Lista Control Tecnico")
  private List<ControlTecnico> listaControlTecnico = null;

  @ApiModelProperty(value = "Listado de cuotas")
  private List<Cuotas> listaCuotas = null;

  @ApiModelProperty(value = "Listado de instalación cuotas")
  private List<InstalacionCuotas> listaInstalacionCuotas = null;

  @ApiModelProperty(value = "Listado de instalacion recibos")
  private List<InstalacionRecibos> listaInstalacionRecibos = null;

  @ApiModelProperty(value = "Listado de polizas")
  private List<GcPolizas> listaPolizas = null;

  @ApiModelProperty(value = "Listado de recibos")
  private List<GcRecibos> listaRecibos = null;

  @ApiModelProperty(value = "Listado de recibos grupo")
  private List<RecibosGrupo> listaRecibosGrupo = null;

  @ApiModelProperty(value = "Listado de recibos prima")
  private List<RecibosPrima> listaRecibosPrima = null;

  @ApiModelProperty(value = "Listado de recibos sin prima")
  private List<RecibosSinPrima> listaRecibosSinPrima = null;

  @ApiModelProperty(value = "Listado de recibos")
  private List<GcTerceros> listaTerceros = null;

  @ApiModelProperty(value = "Indicador de cuotas manuales. Posibles valores [S - Cuota Manual o N - Cuota no manual]")
  private String mcaCuotasManual = null;

  @ApiModelProperty(value = "Marca que indica si se llamará a la lógica que numera y graba los recibos. Posibles valores [S - Se invoca a la logica, N - No se invoca a la logica]")
  private String mcaNumeraRecibo = null;

  @ApiModelProperty(value = "Marca de suplemento temporal. Posibles valores [S - TEMPORAL, N - NO TEMPORAL]")
  private String mcaSptoTmp = null;

  @ApiModelProperty(required = true, value = "Número de aplicación")
  private Integer numApli = null;

  @ApiModelProperty(required = true, value = "Numero de póliza")
  private String numPoliza = null;

  @ApiModelProperty(required = true, value = "Nnúmero identificador del suplemento de la póliza")
  private Integer numSpto = null;

  @ApiModelProperty(value = "Numero de suplemento anulado")
  private Integer numSptoAnul = null;

  @ApiModelProperty(required = true, value = "Número identificador de suplemento de aplicación")
  private Integer numSptoApli = null;

  @ApiModelProperty(value = "Numero de suplemento anulado")
  private Integer numSptoApliAnul = null;

  @ApiModelProperty(value = "Número identificador de suplemento público de aplicación")
  private Integer numSptoApliPublico = null;

  @ApiModelProperty(value = "Numero de suplemento final")
  private Integer numSptoFin = null;

  @ApiModelProperty(value = "Nnúmero identificador del suplemento público de la póliza")
  private Integer numSptoPublico = null;

  @ApiModelProperty(value = "Observaciones")
  private String obsSpto = null;

  @ApiModelProperty(value = "Tipo de anulación. Posibles valores [1-Anulación del último suplemento, 2-Anulación de varios suplementos sin controles técnicos, 3-Anulación de varios suplementos con controles técnicos]")
  private String tipAnulacion = null;

  @ApiModelProperty(value = "Tipo sesion")
  private String tipSesion = null;



}

