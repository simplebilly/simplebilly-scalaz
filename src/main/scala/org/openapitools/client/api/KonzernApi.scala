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

import org.openapitools.client.api.KonzernExportResponse
import org.openapitools.client.api.KonzernStatus

object KonzernApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def konzernExportApi(host: String, year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[KonzernExportResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[KonzernExportResponse] = jsonOf[KonzernExportResponse]

    val path = "/api/v1/bookkeeping/konzern/status/export"

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
      resp          <- client.expect[KonzernExportResponse](req)

    } yield resp
  }

  def konzernStatusApi(host: String, year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[KonzernStatus] = {
    implicit val returnTypeDecoder: EntityDecoder[KonzernStatus] = jsonOf[KonzernStatus]

    val path = "/api/v1/bookkeeping/konzern/status"

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
      resp          <- client.expect[KonzernStatus](req)

    } yield resp
  }

}

class HttpServiceKonzernApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def konzernExportApi(year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[KonzernExportResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[KonzernExportResponse] = jsonOf[KonzernExportResponse]

    val path = "/api/v1/bookkeeping/konzern/status/export"

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
      resp          <- client.expect[KonzernExportResponse](req)

    } yield resp
  }

  def konzernStatusApi(year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[KonzernStatus] = {
    implicit val returnTypeDecoder: EntityDecoder[KonzernStatus] = jsonOf[KonzernStatus]

    val path = "/api/v1/bookkeeping/konzern/status"

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
      resp          <- client.expect[KonzernStatus](req)

    } yield resp
  }

}
