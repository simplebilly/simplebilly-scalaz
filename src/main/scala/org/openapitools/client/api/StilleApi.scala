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

import org.openapitools.client.api.StilleExportResponse
import org.openapitools.client.api.StilleReport

object StilleApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def stilleExportApi(host: String, year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[StilleExportResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[StilleExportResponse] = jsonOf[StilleExportResponse]

    val path = "/api/v1/bookkeeping/stille/export"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[StilleExportResponse](req)

    } yield resp
  }

  def stilleReportApi(host: String, year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[StilleReport] = {
    implicit val returnTypeDecoder: EntityDecoder[StilleReport] = jsonOf[StilleReport]

    val path = "/api/v1/bookkeeping/stille/report"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[StilleReport](req)

    } yield resp
  }

}

class HttpServiceStilleApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def stilleExportApi(year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[StilleExportResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[StilleExportResponse] = jsonOf[StilleExportResponse]

    val path = "/api/v1/bookkeeping/stille/export"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[StilleExportResponse](req)

    } yield resp
  }

  def stilleReportApi(year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[StilleReport] = {
    implicit val returnTypeDecoder: EntityDecoder[StilleReport] = jsonOf[StilleReport]

    val path = "/api/v1/bookkeeping/stille/report"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[StilleReport](req)

    } yield resp
  }

}
