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
import com.capgemini.coedevon.teammanager.prueba.OGnrMensajeAdvertS;
import com.capgemini.coedevon.teammanager.prueba.ORestGcComisionS;
import com.capgemini.coedevon.teammanager.prueba.ORestGcConceptoEcoS;
import com.capgemini.coedevon.teammanager.prueba.ORestGcCuotaS;
import com.capgemini.coedevon.teammanager.prueba.ORestGcInstCuotaS;
import com.capgemini.coedevon.teammanager.prueba.ORestGcInstReciboS;
import com.capgemini.coedevon.teammanager.prueba.ORestGcPolizaS;
import com.capgemini.coedevon.teammanager.prueba.ORestGcReciboGrpS;
import com.capgemini.coedevon.teammanager.prueba.ORestGcReciboPmaS;
import com.capgemini.coedevon.teammanager.prueba.ORestGcReciboS;
import com.capgemini.coedevon.teammanager.prueba.ORestGcReciboSinPmaS;
import com.capgemini.coedevon.teammanager.prueba.ORestGcTerceroS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzAgravanteS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzClausulaS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzCoaseguroS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzCoberturaS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzControlTecnicoS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzDesgloseS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzEmInfGeneralS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzEmIntervS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzFranquiciaCobS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzInfAdicionalAgrS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzInfAdicionalOcuS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzInfAdicionalS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzInstPolizaS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzInstRiesgoS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzIntervAgtS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzIntervDepS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzLimiteCobS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzLineaTextoS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzOcurrenciaS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzPeriodoS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzPlanPagoS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzRiesgoS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzSatRiesgosS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzSatSptoPptaS;
import com.capgemini.coedevon.teammanager.prueba.ORestPlzTextoS;
import com.capgemini.coedevon.teammanager.prueba.OutDDTerceros;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * OutTraspasarPoliza
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-20T06:08:01.090Z")
@Data
@JsonInclude(Include.NON_EMPTY)
public class OutTraspasarPoliza {
  @ApiModelProperty(value = "Codigo interno de unicidad")
  private String codIntUnicidad = null;

  @ApiModelProperty(required = true, value = "Información general de la poliza")
  private ORestPlzEmInfGeneralS infGeneral = null;

  @ApiModelProperty(value = "Lista de advertencias")
  private List<OGnrMensajeAdvertS> listaAdvertencias = null;

  @ApiModelProperty(value = "Lista Agravante")
  private List<ORestPlzAgravanteS> listaAgravante = null;

  @ApiModelProperty(value = "Lista Clausula")
  private List<ORestPlzClausulaS> listaClausula = null;

  @ApiModelProperty(value = "Lista coaseguros")
  private List<ORestPlzCoaseguroS> listaCoaseguro = null;

  @ApiModelProperty(value = "Lista de coberturas")
  private List<ORestPlzCoberturaS> listaCobertura = null;

  @ApiModelProperty(value = "Listado de comisiones")
  private List<ORestGcComisionS> listaComisiones = null;

  @ApiModelProperty(value = "Listado de conceptos economicos")
  private List<ORestGcConceptoEcoS> listaConceptosEco = null;

  @ApiModelProperty(value = "Lista Control Tecnico")
  private List<ORestPlzControlTecnicoS> listaControlTecnico = null;

  @ApiModelProperty(value = "Listado de cuotas")
  private List<ORestGcCuotaS> listaCuotas = null;

  @ApiModelProperty(value = "Lista de Datos de Terceros")
  private List<OutDDTerceros> listaDDTerceros = null;

  @ApiModelProperty(value = "Lista Desglose")
  private List<ORestPlzDesgloseS> listaDesglose = null;

  @ApiModelProperty(value = "Lista de franquicias por coberturas")
  private List<ORestPlzFranquiciaCobS> listaFranquiciaCob = null;

  @ApiModelProperty(value = "Lista de informacion adicional")
  private List<ORestPlzInfAdicionalS> listaInfAdicional = null;

  @ApiModelProperty(value = "Lista informacion adicional Agravante")
  private List<ORestPlzInfAdicionalAgrS> listaInfAdicionalAgr = null;

  @ApiModelProperty(value = "Lista de informacion de ocurrencias")
  private List<ORestPlzInfAdicionalOcuS> listaInfAdicionalOcu = null;

  @ApiModelProperty(value = "Listado de instalación cuotas")
  private List<ORestGcInstCuotaS> listaInstalacionCuotas = null;

  @ApiModelProperty(value = "Lista Instalacion Poliza")
  private List<ORestPlzInstPolizaS> listaInstalacionPoliza = null;

  @ApiModelProperty(value = "Listado de instalacion recibos")
  private List<ORestGcInstReciboS> listaInstalacionRecibos = null;

  @ApiModelProperty(value = "Lista Instalacion Riesgo")
  private List<ORestPlzInstRiesgoS> listaInstalacionRiesgo = null;

  @ApiModelProperty(value = "Lista Intervencion de agentes")
  private List<ORestPlzIntervAgtS> listaIntervAgt = null;

  @ApiModelProperty(value = "Lista de intervenciones dependientes")
  private List<ORestPlzIntervDepS> listaIntervDep = null;

  @ApiModelProperty(value = "Lista de intervencion Poliza")
  private List<ORestPlzEmIntervS> listaIntervencionPlz = null;

  @ApiModelProperty(value = "Lista de limites por coberturas")
  private List<ORestPlzLimiteCobS> listaLimiteCob = null;

  @ApiModelProperty(value = "Lista de linea de textos")
  private List<ORestPlzLineaTextoS> listaLineaTexto = null;

  @ApiModelProperty(value = "Lista de ocurrencias")
  private List<ORestPlzOcurrenciaS> listaOcurrencia = null;

  @ApiModelProperty(value = "Lista de Periodo")
  private List<ORestPlzPeriodoS> listaPeriodo = null;

  @ApiModelProperty(value = "Lista plan pago")
  private List<ORestPlzPlanPagoS> listaPlanPago = null;

  @ApiModelProperty(value = "Listado de polizas")
  private List<ORestGcPolizaS> listaPolizas = null;

  @ApiModelProperty(value = "Listado de recibos")
  private List<ORestGcReciboS> listaRecibos = null;

  @ApiModelProperty(value = "Listado de recibos grupo")
  private List<ORestGcReciboGrpS> listaRecibosGrupo = null;

  @ApiModelProperty(value = "Listado de recibos prima")
  private List<ORestGcReciboPmaS> listaRecibosPrima = null;

  @ApiModelProperty(value = "Listado de recibos sin prima")
  private List<ORestGcReciboSinPmaS> listaRecibosSinPrima = null;

  @ApiModelProperty(value = "Lista de Riesgos")
  private List<ORestPlzRiesgoS> listaRiesgo = null;

  @ApiModelProperty(value = "Lista Satelite Riesgo")
  private List<ORestPlzSatRiesgosS> listaSateliteRiesgo = null;

  @ApiModelProperty(value = "Listado de recibos de terceros")
  private List<ORestGcTerceroS> listaTerceros = null;

  @ApiModelProperty(value = "Lista de textos")
  private List<ORestPlzTextoS> listaTexto = null;

  @ApiModelProperty(value = "Satelite Suplemento")
  private ORestPlzSatSptoPptaS sateliteSpto = null;



}

