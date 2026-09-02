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

import java.time.LocalDate
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.StockMovement
import java.util.UUID

object StockMovementApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getStockMovement(host: String, movementId: String): Task[StockMovement] = {
    implicit val returnTypeDecoder: EntityDecoder[StockMovement] = jsonOf[StockMovement]

    val path = "/api/v1/stock-movements/{movement_id}".replaceAll("\\{" + "movement_id" + "\\}",escape(movementId.toString))

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
      resp          <- client.expect[StockMovement](req)

    } yield resp
  }

  def listStockMovements(host: String, page: Integer, pageSize: Integer, productId: UUID, warehouseId: String, movementType: String, from: LocalDate, to: LocalDate)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], productIdQuery: QueryParam[UUID], warehouseIdQuery: QueryParam[String], movementTypeQuery: QueryParam[String], fromQuery: QueryParam[LocalDate], toQuery: QueryParam[LocalDate]): Task[List[StockMovement]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[StockMovement]] = jsonOf[List[StockMovement]]

    val path = "/api/v1/stock-movements/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("productId", Some(productIdQuery.toParamString(productId))), ("warehouseId", Some(warehouseIdQuery.toParamString(warehouseId))), ("movementType", Some(movementTypeQuery.toParamString(movementType))), ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[StockMovement]](req)

    } yield resp
  }

}

class HttpServiceStockMovementApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getStockMovement(movementId: String): Task[StockMovement] = {
    implicit val returnTypeDecoder: EntityDecoder[StockMovement] = jsonOf[StockMovement]

    val path = "/api/v1/stock-movements/{movement_id}".replaceAll("\\{" + "movement_id" + "\\}",escape(movementId.toString))

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
      resp          <- client.expect[StockMovement](req)

    } yield resp
  }

  def listStockMovements(page: Integer, pageSize: Integer, productId: UUID, warehouseId: String, movementType: String, from: LocalDate, to: LocalDate)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], productIdQuery: QueryParam[UUID], warehouseIdQuery: QueryParam[String], movementTypeQuery: QueryParam[String], fromQuery: QueryParam[LocalDate], toQuery: QueryParam[LocalDate]): Task[List[StockMovement]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[StockMovement]] = jsonOf[List[StockMovement]]

    val path = "/api/v1/stock-movements/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("productId", Some(productIdQuery.toParamString(productId))), ("warehouseId", Some(warehouseIdQuery.toParamString(warehouseId))), ("movementType", Some(movementTypeQuery.toParamString(movementType))), ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[StockMovement]](req)

    } yield resp
  }

}
