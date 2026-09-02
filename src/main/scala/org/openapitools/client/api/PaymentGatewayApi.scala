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

import org.openapitools.client.api.AnyType
import org.openapitools.client.api.GatewayOAuthAuthorizeRequest
import org.openapitools.client.api.GatewayOAuthAuthorizeResponse
import org.openapitools.client.api.GatewayOAuthCallbackRequest
import org.openapitools.client.api.PaymentGateway
import org.openapitools.client.api.PluginError

object PaymentGatewayApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createPaymentGatewayApi(host: String, body: AnyType): Task[PaymentGateway] = {
    implicit val returnTypeDecoder: EntityDecoder[PaymentGateway] = jsonOf[PaymentGateway]

    val path = "/api/v1/payment-gateways"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[PaymentGateway](req)

    } yield resp
  }

  def deletePaymentGatewayApi(host: String, gatewayId: String): Task[Unit] = {
    val path = "/api/v1/payment-gateways/{gateway_id}".replaceAll("\\{" + "gateway_id" + "\\}",escape(gatewayId.toString))

    val httpMethod = Method.DELETE
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def listPaymentGatewaysApi(host: String): Task[List[PaymentGateway]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PaymentGateway]] = jsonOf[List[PaymentGateway]]

    val path = "/api/v1/payment-gateways/"

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
      resp          <- client.expect[List[PaymentGateway]](req)

    } yield resp
  }

  def oauthAuthorizeApi(host: String, gatewayOAuthAuthorizeRequest: GatewayOAuthAuthorizeRequest): Task[GatewayOAuthAuthorizeResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GatewayOAuthAuthorizeResponse] = jsonOf[GatewayOAuthAuthorizeResponse]

    val path = "/api/v1/payment-gateways/oauth/authorize"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(gatewayOAuthAuthorizeRequest)
      resp          <- client.expect[GatewayOAuthAuthorizeResponse](req)

    } yield resp
  }

  def oauthCallbackApi(host: String, gatewayOAuthCallbackRequest: GatewayOAuthCallbackRequest): Task[PaymentGateway] = {
    implicit val returnTypeDecoder: EntityDecoder[PaymentGateway] = jsonOf[PaymentGateway]

    val path = "/api/v1/payment-gateways/oauth/callback"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(gatewayOAuthCallbackRequest)
      resp          <- client.expect[PaymentGateway](req)

    } yield resp
  }

  def updatePaymentGatewayApi(host: String, gatewayId: String, body: AnyType): Task[PaymentGateway] = {
    implicit val returnTypeDecoder: EntityDecoder[PaymentGateway] = jsonOf[PaymentGateway]

    val path = "/api/v1/payment-gateways/{gateway_id}".replaceAll("\\{" + "gateway_id" + "\\}",escape(gatewayId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[PaymentGateway](req)

    } yield resp
  }

}

class HttpServicePaymentGatewayApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createPaymentGatewayApi(body: AnyType): Task[PaymentGateway] = {
    implicit val returnTypeDecoder: EntityDecoder[PaymentGateway] = jsonOf[PaymentGateway]

    val path = "/api/v1/payment-gateways"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[PaymentGateway](req)

    } yield resp
  }

  def deletePaymentGatewayApi(gatewayId: String): Task[Unit] = {
    val path = "/api/v1/payment-gateways/{gateway_id}".replaceAll("\\{" + "gateway_id" + "\\}",escape(gatewayId.toString))

    val httpMethod = Method.DELETE
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def listPaymentGatewaysApi(): Task[List[PaymentGateway]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PaymentGateway]] = jsonOf[List[PaymentGateway]]

    val path = "/api/v1/payment-gateways/"

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
      resp          <- client.expect[List[PaymentGateway]](req)

    } yield resp
  }

  def oauthAuthorizeApi(gatewayOAuthAuthorizeRequest: GatewayOAuthAuthorizeRequest): Task[GatewayOAuthAuthorizeResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GatewayOAuthAuthorizeResponse] = jsonOf[GatewayOAuthAuthorizeResponse]

    val path = "/api/v1/payment-gateways/oauth/authorize"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(gatewayOAuthAuthorizeRequest)
      resp          <- client.expect[GatewayOAuthAuthorizeResponse](req)

    } yield resp
  }

  def oauthCallbackApi(gatewayOAuthCallbackRequest: GatewayOAuthCallbackRequest): Task[PaymentGateway] = {
    implicit val returnTypeDecoder: EntityDecoder[PaymentGateway] = jsonOf[PaymentGateway]

    val path = "/api/v1/payment-gateways/oauth/callback"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(gatewayOAuthCallbackRequest)
      resp          <- client.expect[PaymentGateway](req)

    } yield resp
  }

  def updatePaymentGatewayApi(gatewayId: String, body: AnyType): Task[PaymentGateway] = {
    implicit val returnTypeDecoder: EntityDecoder[PaymentGateway] = jsonOf[PaymentGateway]

    val path = "/api/v1/payment-gateways/{gateway_id}".replaceAll("\\{" + "gateway_id" + "\\}",escape(gatewayId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[PaymentGateway](req)

    } yield resp
  }

}
