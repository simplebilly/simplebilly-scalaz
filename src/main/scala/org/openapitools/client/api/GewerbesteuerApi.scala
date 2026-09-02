package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import java.io.File
import java.net.URLEncoder
import java.util.UUID

import org.http4s._
import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.http4s.client._
import org.http4s.client.blaze.PooledHttp1Client
import org.http4s.headers._

import org.joda.time.DateTime

import scalaz.concurrent.Task

import HelperCodecs._

import org.openapitools.client.api.GewerbesteuerErgebnis

object GewerbesteuerApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def gewerbesteuerApi(host: String, year: Integer, hebesatz: String, gewerbeertrag: String, country: String, gemeindeschluessel: String)(implicit yearQuery: QueryParam[Integer], hebesatzQuery: QueryParam[String], gewerbeertragQuery: QueryParam[String], countryQuery: QueryParam[String], gemeindeschluesselQuery: QueryParam[String]): Task[GewerbesteuerErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[GewerbesteuerErgebnis] = jsonOf[GewerbesteuerErgebnis]

    val path = "/api/v1/bookkeeping/gewerbesteuer"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("hebesatz", Some(hebesatzQuery.toParamString(hebesatz))), ("gewerbeertrag", Some(gewerbeertragQuery.toParamString(gewerbeertrag))), ("country", Some(countryQuery.toParamString(country))), ("gemeindeschluessel", Some(gemeindeschluesselQuery.toParamString(gemeindeschluessel))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[GewerbesteuerErgebnis](req)

    } yield resp
  }

}

class HttpServiceGewerbesteuerApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def gewerbesteuerApi(year: Integer, hebesatz: String, gewerbeertrag: String, country: String, gemeindeschluessel: String)(implicit yearQuery: QueryParam[Integer], hebesatzQuery: QueryParam[String], gewerbeertragQuery: QueryParam[String], countryQuery: QueryParam[String], gemeindeschluesselQuery: QueryParam[String]): Task[GewerbesteuerErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[GewerbesteuerErgebnis] = jsonOf[GewerbesteuerErgebnis]

    val path = "/api/v1/bookkeeping/gewerbesteuer"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("hebesatz", Some(hebesatzQuery.toParamString(hebesatz))), ("gewerbeertrag", Some(gewerbeertragQuery.toParamString(gewerbeertrag))), ("country", Some(countryQuery.toParamString(country))), ("gemeindeschluessel", Some(gemeindeschluesselQuery.toParamString(gemeindeschluessel))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[GewerbesteuerErgebnis](req)

    } yield resp
  }

}
