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
import com.capgemini.coedevon.teammanager.prueba.CuotaC;
import com.capgemini.coedevon.teammanager.prueba.GcPolizas;
import com.capgemini.coedevon.teammanager.prueba.GcRecibos;
import com.capgemini.coedevon.teammanager.prueba.InstalacionRecibos;
import com.capgemini.coedevon.teammanager.prueba.RecibosGrupo;
import com.capgemini.coedevon.teammanager.prueba.RecibosPrima;
import com.capgemini.coedevon.teammanager.prueba.RecibosSinPrima;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * ReciboC
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-20T06:08:01.090Z")
@Data
@JsonInclude(Include.NON_EMPTY)
public class ReciboC {
  @ApiModelProperty(value = "Listado de instalacion recibos")
  private InstalacionRecibos instalacionRecibo = null;

  @ApiModelProperty(value = "Listado de cuotas complejo")
  private List<CuotaC> listaCuotasC = null;

  @ApiModelProperty(value = "Listado de polizas")
  private GcPolizas poliza = null;

  @ApiModelProperty(value = "recibo")
  private GcRecibos recibo = null;

  @ApiModelProperty(value = "Listado de recibos grupo")
  private RecibosGrupo reciboGrupo = null;

  @ApiModelProperty(value = "recibo prima")
  private RecibosPrima reciboPrima = null;

  @ApiModelProperty(value = "recibo sin prima")
  private RecibosSinPrima reciboSinPrima = null;



}
