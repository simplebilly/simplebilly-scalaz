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

import org.openapitools.client.api.EuerDetailErgebnis
import org.openapitools.client.api.EuerErgebnis

object EuerApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def euerApi(host: String, year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[EuerErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[EuerErgebnis] = jsonOf[EuerErgebnis]

    val path = "/api/v1/bookkeeping/euer"

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
      resp          <- client.expect[EuerErgebnis](req)

    } yield resp
  }

  def euerKategorienApi(host: String, year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[EuerDetailErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[EuerDetailErgebnis] = jsonOf[EuerDetailErgebnis]

    val path = "/api/v1/bookkeeping/euer/kategorien"

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
      resp          <- client.expect[EuerDetailErgebnis](req)

    } yield resp
  }

}

class HttpServiceEuerApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def euerApi(year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[EuerErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[EuerErgebnis] = jsonOf[EuerErgebnis]

    val path = "/api/v1/bookkeeping/euer"

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
      resp          <- client.expect[EuerErgebnis](req)

    } yield resp
  }

  def euerKategorienApi(year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[EuerDetailErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[EuerDetailErgebnis] = jsonOf[EuerDetailErgebnis]

    val path = "/api/v1/bookkeeping/euer/kategorien"

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
      resp          <- client.expect[EuerDetailErgebnis](req)

    } yield resp
  }

}
