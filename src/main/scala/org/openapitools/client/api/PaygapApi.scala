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

import org.openapitools.client.api.PayGapExportResponse
import org.openapitools.client.api.PayGapInfoResponse
import org.openapitools.client.api.PayGapReport
import org.openapitools.client.api.PluginError
import java.util.UUID

object PaygapApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def paygapAuskunftApi(host: String, employeeId: UUID): Task[PayGapInfoResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PayGapInfoResponse] = jsonOf[PayGapInfoResponse]

    val path = "/api/v1/bookkeeping/paygap/auskunft/{employee_id}".replaceAll("\\{" + "employee_id" + "\\}",escape(employeeId.toString))

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PayGapInfoResponse](req)

    } yield resp
  }

  def paygapExportApi(host: String): Task[PayGapExportResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PayGapExportResponse] = jsonOf[PayGapExportResponse]

    val path = "/api/v1/bookkeeping/paygap/export"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PayGapExportResponse](req)

    } yield resp
  }

  def paygapReportApi(host: String): Task[PayGapReport] = {
    implicit val returnTypeDecoder: EntityDecoder[PayGapReport] = jsonOf[PayGapReport]

    val path = "/api/v1/bookkeeping/paygap/report"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PayGapReport](req)

    } yield resp
  }

}

class HttpServicePaygapApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def paygapAuskunftApi(employeeId: UUID): Task[PayGapInfoResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PayGapInfoResponse] = jsonOf[PayGapInfoResponse]

    val path = "/api/v1/bookkeeping/paygap/auskunft/{employee_id}".replaceAll("\\{" + "employee_id" + "\\}",escape(employeeId.toString))

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PayGapInfoResponse](req)

    } yield resp
  }

  def paygapExportApi(): Task[PayGapExportResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PayGapExportResponse] = jsonOf[PayGapExportResponse]

    val path = "/api/v1/bookkeeping/paygap/export"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PayGapExportResponse](req)

    } yield resp
  }

  def paygapReportApi(): Task[PayGapReport] = {
    implicit val returnTypeDecoder: EntityDecoder[PayGapReport] = jsonOf[PayGapReport]

    val path = "/api/v1/bookkeeping/paygap/report"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PayGapReport](req)

    } yield resp
  }

}
