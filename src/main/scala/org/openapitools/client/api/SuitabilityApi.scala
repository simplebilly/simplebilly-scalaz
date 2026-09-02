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

import org.openapitools.client.api.PluginError
import org.openapitools.client.api.SuitabilityRequest
import org.openapitools.client.api.SuitabilityResult

object SuitabilityApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def shippingSuitabilityApi(host: String, suitabilityRequest: SuitabilityRequest): Task[SuitabilityResult] = {
    implicit val returnTypeDecoder: EntityDecoder[SuitabilityResult] = jsonOf[SuitabilityResult]

    val path = "/api/v1/shipping/suitability"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(suitabilityRequest)
      resp          <- client.expect[SuitabilityResult](req)

    } yield resp
  }

}

class HttpServiceSuitabilityApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def shippingSuitabilityApi(suitabilityRequest: SuitabilityRequest): Task[SuitabilityResult] = {
    implicit val returnTypeDecoder: EntityDecoder[SuitabilityResult] = jsonOf[SuitabilityResult]

    val path = "/api/v1/shipping/suitability"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(suitabilityRequest)
      resp          <- client.expect[SuitabilityResult](req)

    } yield resp
  }

}
