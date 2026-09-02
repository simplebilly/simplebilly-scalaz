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

import org.openapitools.client.api.EBilanzReport

object EbilanzApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def ebilanzReportApi(host: String, year: Integer, dateFrom: String, dateTo: String)(implicit yearQuery: QueryParam[Integer], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String]): Task[EBilanzReport] = {
    implicit val returnTypeDecoder: EntityDecoder[EBilanzReport] = jsonOf[EBilanzReport]

    val path = "/api/v1/bookkeeping/ebilanz"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[EBilanzReport](req)

    } yield resp
  }

  def ebilanzXbrlExportApi(host: String, year: Integer, dateFrom: String, dateTo: String)(implicit yearQuery: QueryParam[Integer], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String]): Task[Unit] = {
    val path = "/api/v1/bookkeeping/ebilanz/xbrl"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

}

class HttpServiceEbilanzApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def ebilanzReportApi(year: Integer, dateFrom: String, dateTo: String)(implicit yearQuery: QueryParam[Integer], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String]): Task[EBilanzReport] = {
    implicit val returnTypeDecoder: EntityDecoder[EBilanzReport] = jsonOf[EBilanzReport]

    val path = "/api/v1/bookkeeping/ebilanz"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[EBilanzReport](req)

    } yield resp
  }

  def ebilanzXbrlExportApi(year: Integer, dateFrom: String, dateTo: String)(implicit yearQuery: QueryParam[Integer], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String]): Task[Unit] = {
    val path = "/api/v1/bookkeeping/ebilanz/xbrl"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

}
