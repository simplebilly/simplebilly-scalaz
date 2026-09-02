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
import org.openapitools.client.api.ProviderInfo
import org.openapitools.client.api.RateRequest
import org.openapitools.client.api.RateResponse
import org.openapitools.client.api.ShippingCredentials

object ShippingApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getCredentialsApi(host: String): Task[ShippingCredentials] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingCredentials] = jsonOf[ShippingCredentials]

    val path = "/api/v1/shipping/credentials"

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
      resp          <- client.expect[ShippingCredentials](req)

    } yield resp
  }

  def getRatesApi(host: String, rateRequest: RateRequest): Task[RateResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[RateResponse] = jsonOf[RateResponse]

    val path = "/api/v1/shipping/rates"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(rateRequest)
      resp          <- client.expect[RateResponse](req)

    } yield resp
  }

  def listProvidersApi(host: String): Task[List[ProviderInfo]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ProviderInfo]] = jsonOf[List[ProviderInfo]]

    val path = "/api/v1/shipping/providers"

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
      resp          <- client.expect[List[ProviderInfo]](req)

    } yield resp
  }

  def saveCredentialsApi(host: String, shippingCredentials: ShippingCredentials): Task[ShippingCredentials] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingCredentials] = jsonOf[ShippingCredentials]

    val path = "/api/v1/shipping/credentials"

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shippingCredentials)
      resp          <- client.expect[ShippingCredentials](req)

    } yield resp
  }

}

class HttpServiceShippingApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getCredentialsApi(): Task[ShippingCredentials] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingCredentials] = jsonOf[ShippingCredentials]

    val path = "/api/v1/shipping/credentials"

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
      resp          <- client.expect[ShippingCredentials](req)

    } yield resp
  }

  def getRatesApi(rateRequest: RateRequest): Task[RateResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[RateResponse] = jsonOf[RateResponse]

    val path = "/api/v1/shipping/rates"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(rateRequest)
      resp          <- client.expect[RateResponse](req)

    } yield resp
  }

  def listProvidersApi(): Task[List[ProviderInfo]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ProviderInfo]] = jsonOf[List[ProviderInfo]]

    val path = "/api/v1/shipping/providers"

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
      resp          <- client.expect[List[ProviderInfo]](req)

    } yield resp
  }

  def saveCredentialsApi(shippingCredentials: ShippingCredentials): Task[ShippingCredentials] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingCredentials] = jsonOf[ShippingCredentials]

    val path = "/api/v1/shipping/credentials"

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shippingCredentials)
      resp          <- client.expect[ShippingCredentials](req)

    } yield resp
  }

}
