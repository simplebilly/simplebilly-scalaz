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

import org.openapitools.client.api.PlausibilityReport

object PlausibilityApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def plausibilityCheckApi(host: String, dateFrom: String, dateTo: String)(implicit dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String]): Task[PlausibilityReport] = {
    implicit val returnTypeDecoder: EntityDecoder[PlausibilityReport] = jsonOf[PlausibilityReport]

    val path = "/api/v1/bookkeeping/plausibility"

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
      resp          <- client.expect[PlausibilityReport](req)

    } yield resp
  }

}

class HttpServicePlausibilityApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def plausibilityCheckApi(dateFrom: String, dateTo: String)(implicit dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String]): Task[PlausibilityReport] = {
    implicit val returnTypeDecoder: EntityDecoder[PlausibilityReport] = jsonOf[PlausibilityReport]

    val path = "/api/v1/bookkeeping/plausibility"

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
      resp          <- client.expect[PlausibilityReport](req)

    } yield resp
  }

}
