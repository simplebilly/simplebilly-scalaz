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
import org.openapitools.client.api.StockAdjustment
import java.util.UUID
import org.openapitools.client.api.WarehouseStock

object WarehouseStockApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createWarehouseStock(host: String, warehouseId: String, stockAdjustment: StockAdjustment): Task[WarehouseStock] = {
    implicit val returnTypeDecoder: EntityDecoder[WarehouseStock] = jsonOf[WarehouseStock]

    val path = "/api/v1/warehouses/{warehouse_id}/stock".replaceAll("\\{" + "warehouse_id" + "\\}",escape(warehouseId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(stockAdjustment)
      resp          <- client.expect[WarehouseStock](req)

    } yield resp
  }

  def deleteWarehouseStock(host: String, warehouseId: String, productId: UUID): Task[Unit] = {
    val path = "/api/v1/warehouses/{warehouse_id}/stock/{product_id}".replaceAll("\\{" + "warehouse_id" + "\\}",escape(warehouseId.toString)).replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

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

  def listWarehouseStock(host: String, warehouseId: String): Task[List[WarehouseStock]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[WarehouseStock]] = jsonOf[List[WarehouseStock]]

    val path = "/api/v1/warehouses/{warehouse_id}/stock".replaceAll("\\{" + "warehouse_id" + "\\}",escape(warehouseId.toString))

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
      resp          <- client.expect[List[WarehouseStock]](req)

    } yield resp
  }

  def updateWarehouseStock(host: String, warehouseId: String, productId: UUID, stockAdjustment: StockAdjustment): Task[WarehouseStock] = {
    implicit val returnTypeDecoder: EntityDecoder[WarehouseStock] = jsonOf[WarehouseStock]

    val path = "/api/v1/warehouses/{warehouse_id}/stock/{product_id}".replaceAll("\\{" + "warehouse_id" + "\\}",escape(warehouseId.toString)).replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(stockAdjustment)
      resp          <- client.expect[WarehouseStock](req)

    } yield resp
  }

}

class HttpServiceWarehouseStockApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createWarehouseStock(warehouseId: String, stockAdjustment: StockAdjustment): Task[WarehouseStock] = {
    implicit val returnTypeDecoder: EntityDecoder[WarehouseStock] = jsonOf[WarehouseStock]

    val path = "/api/v1/warehouses/{warehouse_id}/stock".replaceAll("\\{" + "warehouse_id" + "\\}",escape(warehouseId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(stockAdjustment)
      resp          <- client.expect[WarehouseStock](req)

    } yield resp
  }

  def deleteWarehouseStock(warehouseId: String, productId: UUID): Task[Unit] = {
    val path = "/api/v1/warehouses/{warehouse_id}/stock/{product_id}".replaceAll("\\{" + "warehouse_id" + "\\}",escape(warehouseId.toString)).replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

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

  def listWarehouseStock(warehouseId: String): Task[List[WarehouseStock]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[WarehouseStock]] = jsonOf[List[WarehouseStock]]

    val path = "/api/v1/warehouses/{warehouse_id}/stock".replaceAll("\\{" + "warehouse_id" + "\\}",escape(warehouseId.toString))

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
      resp          <- client.expect[List[WarehouseStock]](req)

    } yield resp
  }

  def updateWarehouseStock(warehouseId: String, productId: UUID, stockAdjustment: StockAdjustment): Task[WarehouseStock] = {
    implicit val returnTypeDecoder: EntityDecoder[WarehouseStock] = jsonOf[WarehouseStock]

    val path = "/api/v1/warehouses/{warehouse_id}/stock/{product_id}".replaceAll("\\{" + "warehouse_id" + "\\}",escape(warehouseId.toString)).replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(stockAdjustment)
      resp          <- client.expect[WarehouseStock](req)

    } yield resp
  }

}
