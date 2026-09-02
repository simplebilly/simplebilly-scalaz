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

import org.openapitools.client.api.JahresUstErgebnis
import org.openapitools.client.api.UstvaErgebnis

object UstvaApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def jahresustApi(host: String, year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[JahresUstErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[JahresUstErgebnis] = jsonOf[JahresUstErgebnis]

    val path = "/api/v1/bookkeeping/jahresust"

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
      resp          <- client.expect[JahresUstErgebnis](req)

    } yield resp
  }

  def ustvaApi(host: String, zeitraum: String)(implicit zeitraumQuery: QueryParam[String]): Task[UstvaErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[UstvaErgebnis] = jsonOf[UstvaErgebnis]

    val path = "/api/v1/bookkeeping/ustva"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("zeitraum", Some(zeitraumQuery.toParamString(zeitraum))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[UstvaErgebnis](req)

    } yield resp
  }

}

class HttpServiceUstvaApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def jahresustApi(year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[JahresUstErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[JahresUstErgebnis] = jsonOf[JahresUstErgebnis]

    val path = "/api/v1/bookkeeping/jahresust"

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
      resp          <- client.expect[JahresUstErgebnis](req)

    } yield resp
  }

  def ustvaApi(zeitraum: String)(implicit zeitraumQuery: QueryParam[String]): Task[UstvaErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[UstvaErgebnis] = jsonOf[UstvaErgebnis]

    val path = "/api/v1/bookkeeping/ustva"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("zeitraum", Some(zeitraumQuery.toParamString(zeitraum))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[UstvaErgebnis](req)

    } yield resp
  }

}
