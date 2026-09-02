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
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.ReplenishmentResponse

object ReplenishmentApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def applyReplenishments(host: String, targetWarehouseId: String, sourceWarehouseId: String)(implicit targetWarehouseIdQuery: QueryParam[String], sourceWarehouseIdQuery: QueryParam[String]): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/replenishments/apply"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("targetWarehouseId", Some(targetWarehouseIdQuery.toParamString(targetWarehouseId))), ("sourceWarehouseId", Some(sourceWarehouseIdQuery.toParamString(sourceWarehouseId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def getReplenishments(host: String, targetWarehouseId: String, sourceWarehouseId: String)(implicit targetWarehouseIdQuery: QueryParam[String], sourceWarehouseIdQuery: QueryParam[String]): Task[ReplenishmentResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ReplenishmentResponse] = jsonOf[ReplenishmentResponse]

    val path = "/api/v1/replenishments"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("targetWarehouseId", Some(targetWarehouseIdQuery.toParamString(targetWarehouseId))), ("sourceWarehouseId", Some(sourceWarehouseIdQuery.toParamString(sourceWarehouseId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[ReplenishmentResponse](req)

    } yield resp
  }

}

class HttpServiceReplenishmentApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def applyReplenishments(targetWarehouseId: String, sourceWarehouseId: String)(implicit targetWarehouseIdQuery: QueryParam[String], sourceWarehouseIdQuery: QueryParam[String]): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/replenishments/apply"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("targetWarehouseId", Some(targetWarehouseIdQuery.toParamString(targetWarehouseId))), ("sourceWarehouseId", Some(sourceWarehouseIdQuery.toParamString(sourceWarehouseId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def getReplenishments(targetWarehouseId: String, sourceWarehouseId: String)(implicit targetWarehouseIdQuery: QueryParam[String], sourceWarehouseIdQuery: QueryParam[String]): Task[ReplenishmentResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ReplenishmentResponse] = jsonOf[ReplenishmentResponse]

    val path = "/api/v1/replenishments"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("targetWarehouseId", Some(targetWarehouseIdQuery.toParamString(targetWarehouseId))), ("sourceWarehouseId", Some(sourceWarehouseIdQuery.toParamString(sourceWarehouseId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[ReplenishmentResponse](req)

    } yield resp
  }

}
