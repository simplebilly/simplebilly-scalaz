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

import org.openapitools.client.api.GoBDExportResponse
import org.openapitools.client.api.PluginError

object GobdExportApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def buchhalterCsvApi(host: String, dateFrom: String, dateTo: String)(implicit dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String]): Task[GoBDExportResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GoBDExportResponse] = jsonOf[GoBDExportResponse]

    val path = "/api/v1/bookkeeping/buchhalter-csv"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[GoBDExportResponse](req)

    } yield resp
  }

  def gobdExportApi(host: String, year: Integer, format: String)(implicit yearQuery: QueryParam[Integer], formatQuery: QueryParam[String]): Task[Unit] = {
    val path = "/api/v1/bookkeeping/gobd"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("format", Some(formatQuery.toParamString(format))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

}

class HttpServiceGobdExportApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def buchhalterCsvApi(dateFrom: String, dateTo: String)(implicit dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String]): Task[GoBDExportResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GoBDExportResponse] = jsonOf[GoBDExportResponse]

    val path = "/api/v1/bookkeeping/buchhalter-csv"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[GoBDExportResponse](req)

    } yield resp
  }

  def gobdExportApi(year: Integer, format: String)(implicit yearQuery: QueryParam[Integer], formatQuery: QueryParam[String]): Task[Unit] = {
    val path = "/api/v1/bookkeeping/gobd"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("format", Some(formatQuery.toParamString(format))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

}
