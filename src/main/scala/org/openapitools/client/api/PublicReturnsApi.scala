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
import org.openapitools.client.api.PublicReturnRequest
import org.openapitools.client.api.PublicReturnResponse
import org.openapitools.client.api.PublicReturnStatusResponse

object PublicReturnsApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getPublicReturnStatus(host: String, email: String, returnNumber: String, returnOrderId: String, orderNumber: String)(implicit returnNumberQuery: QueryParam[String], returnOrderIdQuery: QueryParam[String], emailQuery: QueryParam[String], orderNumberQuery: QueryParam[String]): Task[PublicReturnStatusResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PublicReturnStatusResponse] = jsonOf[PublicReturnStatusResponse]

    val path = "/api/v1/public/returns/status"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("returnNumber", Some(returnNumberQuery.toParamString(returnNumber))), ("returnOrderId", Some(returnOrderIdQuery.toParamString(returnOrderId))), ("email", Some(emailQuery.toParamString(email))), ("orderNumber", Some(orderNumberQuery.toParamString(orderNumber))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PublicReturnStatusResponse](req)

    } yield resp
  }

  def listPublicReturns(host: String, orderNumber: String, email: String)(implicit orderNumberQuery: QueryParam[String], emailQuery: QueryParam[String]): Task[List[PublicReturnStatusResponse]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PublicReturnStatusResponse]] = jsonOf[List[PublicReturnStatusResponse]]

    val path = "/api/v1/public/returns/list"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("orderNumber", Some(orderNumberQuery.toParamString(orderNumber))), ("email", Some(emailQuery.toParamString(email))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[PublicReturnStatusResponse]](req)

    } yield resp
  }

  def requestPublicReturn(host: String, publicReturnRequest: PublicReturnRequest): Task[PublicReturnResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PublicReturnResponse] = jsonOf[PublicReturnResponse]

    val path = "/api/v1/public/returns/request"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(publicReturnRequest)
      resp          <- client.expect[PublicReturnResponse](req)

    } yield resp
  }

}

class HttpServicePublicReturnsApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getPublicReturnStatus(email: String, returnNumber: String, returnOrderId: String, orderNumber: String)(implicit returnNumberQuery: QueryParam[String], returnOrderIdQuery: QueryParam[String], emailQuery: QueryParam[String], orderNumberQuery: QueryParam[String]): Task[PublicReturnStatusResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PublicReturnStatusResponse] = jsonOf[PublicReturnStatusResponse]

    val path = "/api/v1/public/returns/status"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("returnNumber", Some(returnNumberQuery.toParamString(returnNumber))), ("returnOrderId", Some(returnOrderIdQuery.toParamString(returnOrderId))), ("email", Some(emailQuery.toParamString(email))), ("orderNumber", Some(orderNumberQuery.toParamString(orderNumber))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PublicReturnStatusResponse](req)

    } yield resp
  }

  def listPublicReturns(orderNumber: String, email: String)(implicit orderNumberQuery: QueryParam[String], emailQuery: QueryParam[String]): Task[List[PublicReturnStatusResponse]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PublicReturnStatusResponse]] = jsonOf[List[PublicReturnStatusResponse]]

    val path = "/api/v1/public/returns/list"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("orderNumber", Some(orderNumberQuery.toParamString(orderNumber))), ("email", Some(emailQuery.toParamString(email))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[PublicReturnStatusResponse]](req)

    } yield resp
  }

  def requestPublicReturn(publicReturnRequest: PublicReturnRequest): Task[PublicReturnResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PublicReturnResponse] = jsonOf[PublicReturnResponse]

    val path = "/api/v1/public/returns/request"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(publicReturnRequest)
      resp          <- client.expect[PublicReturnResponse](req)

    } yield resp
  }

}
