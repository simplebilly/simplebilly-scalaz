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

import org.openapitools.client.api.GewinnverwendungsExportResponse
import org.openapitools.client.api.GewinnverwendungsReport

object GewinnverwendungApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def gewinnverwendungApi(host: String, year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[GewinnverwendungsReport] = {
    implicit val returnTypeDecoder: EntityDecoder[GewinnverwendungsReport] = jsonOf[GewinnverwendungsReport]

    val path = "/api/v1/bookkeeping/gewinnverwendung"

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
      resp          <- client.expect[GewinnverwendungsReport](req)

    } yield resp
  }

  def gewinnverwendungExportApi(host: String, year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[GewinnverwendungsExportResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GewinnverwendungsExportResponse] = jsonOf[GewinnverwendungsExportResponse]

    val path = "/api/v1/bookkeeping/gewinnverwendung/export"

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
      resp          <- client.expect[GewinnverwendungsExportResponse](req)

    } yield resp
  }

}

class HttpServiceGewinnverwendungApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def gewinnverwendungApi(year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[GewinnverwendungsReport] = {
    implicit val returnTypeDecoder: EntityDecoder[GewinnverwendungsReport] = jsonOf[GewinnverwendungsReport]

    val path = "/api/v1/bookkeeping/gewinnverwendung"

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
      resp          <- client.expect[GewinnverwendungsReport](req)

    } yield resp
  }

  def gewinnverwendungExportApi(year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[GewinnverwendungsExportResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GewinnverwendungsExportResponse] = jsonOf[GewinnverwendungsExportResponse]

    val path = "/api/v1/bookkeeping/gewinnverwendung/export"

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
      resp          <- client.expect[GewinnverwendungsExportResponse](req)

    } yield resp
  }

}
