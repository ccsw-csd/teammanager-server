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
 * StackTrace
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-20T06:08:01.090Z")
@Data
@JsonInclude(Include.NON_EMPTY)
public class StackTrace {
  @ApiModelProperty(value = "Nombre de la clase donde se realiza la llamada")
  private String declaringClass = null;

  @ApiModelProperty(value = "Nombre del fichero donde se define la clase")
  private String fileName = null;

  @ApiModelProperty(value = "Número de línea donde se produce la llamada")
  private Integer lineNumber = null;

  @ApiModelProperty(value = "Nombre del metodo de la clase donde se realiza la llamada")
  private String methodName = null;

  @ApiModelProperty(example = "false", value = "Indica si un método es nativo")
  private Boolean nativeMethod = null;



}

