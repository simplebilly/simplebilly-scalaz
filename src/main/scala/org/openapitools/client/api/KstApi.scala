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

import org.openapitools.client.api.KstErgebnis

object KstApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def kstApi(host: String, year: Integer, gewinn: String)(implicit yearQuery: QueryParam[Integer], gewinnQuery: QueryParam[String]): Task[KstErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[KstErgebnis] = jsonOf[KstErgebnis]

    val path = "/api/v1/bookkeeping/kst"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("gewinn", Some(gewinnQuery.toParamString(gewinn))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[KstErgebnis](req)

    } yield resp
  }

}

class HttpServiceKstApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def kstApi(year: Integer, gewinn: String)(implicit yearQuery: QueryParam[Integer], gewinnQuery: QueryParam[String]): Task[KstErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[KstErgebnis] = jsonOf[KstErgebnis]

    val path = "/api/v1/bookkeeping/kst"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("gewinn", Some(gewinnQuery.toParamString(gewinn))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[KstErgebnis](req)

    } yield resp
  }

}
