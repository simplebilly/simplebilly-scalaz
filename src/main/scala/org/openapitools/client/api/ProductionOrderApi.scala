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
import org.openapitools.client.api.ProductionOrder
import org.openapitools.client.api.ProductionOrderCosting
import org.openapitools.client.api.ProductionOrderStatusUpdate
import java.util.UUID

object ProductionOrderApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createProductionOrder(host: String, productionOrder: ProductionOrder): Task[ProductionOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductionOrder] = jsonOf[ProductionOrder]

    val path = "/api/v1/production-orders"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productionOrder)
      resp          <- client.expect[ProductionOrder](req)

    } yield resp
  }

  def deleteProductionOrder(host: String, productionOrderId: UUID): Task[Unit] = {
    val path = "/api/v1/production-orders/{production_order_id}".replaceAll("\\{" + "production_order_id" + "\\}",escape(productionOrderId.toString))

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

  def getProductionOrder(host: String, productionOrderId: UUID): Task[ProductionOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductionOrder] = jsonOf[ProductionOrder]

    val path = "/api/v1/production-orders/{production_order_id}".replaceAll("\\{" + "production_order_id" + "\\}",escape(productionOrderId.toString))

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
      resp          <- client.expect[ProductionOrder](req)

    } yield resp
  }

  def listProductionOrders(host: String, page: Integer, pageSize: Integer, search: String, status: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], statusQuery: QueryParam[String]): Task[List[ProductionOrder]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ProductionOrder]] = jsonOf[List[ProductionOrder]]

    val path = "/api/v1/production-orders/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("search", Some(searchQuery.toParamString(search))), ("status", Some(statusQuery.toParamString(status))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ProductionOrder]](req)

    } yield resp
  }

  def productionOrderCosting(host: String, productionOrderId: UUID): Task[ProductionOrderCosting] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductionOrderCosting] = jsonOf[ProductionOrderCosting]

    val path = "/api/v1/production-orders/{production_order_id}/costing".replaceAll("\\{" + "production_order_id" + "\\}",escape(productionOrderId.toString))

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
      resp          <- client.expect[ProductionOrderCosting](req)

    } yield resp
  }

  def updateProductionOrder(host: String, productionOrderId: UUID, productionOrder: ProductionOrder): Task[ProductionOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductionOrder] = jsonOf[ProductionOrder]

    val path = "/api/v1/production-orders/{production_order_id}".replaceAll("\\{" + "production_order_id" + "\\}",escape(productionOrderId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productionOrder)
      resp          <- client.expect[ProductionOrder](req)

    } yield resp
  }

  def updateProductionOrderStatus(host: String, productionOrderId: UUID, productionOrderStatusUpdate: ProductionOrderStatusUpdate): Task[ProductionOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductionOrder] = jsonOf[ProductionOrder]

    val path = "/api/v1/production-orders/{production_order_id}/status".replaceAll("\\{" + "production_order_id" + "\\}",escape(productionOrderId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productionOrderStatusUpdate)
      resp          <- client.expect[ProductionOrder](req)

    } yield resp
  }

}

class HttpServiceProductionOrderApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createProductionOrder(productionOrder: ProductionOrder): Task[ProductionOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductionOrder] = jsonOf[ProductionOrder]

    val path = "/api/v1/production-orders"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productionOrder)
      resp          <- client.expect[ProductionOrder](req)

    } yield resp
  }

  def deleteProductionOrder(productionOrderId: UUID): Task[Unit] = {
    val path = "/api/v1/production-orders/{production_order_id}".replaceAll("\\{" + "production_order_id" + "\\}",escape(productionOrderId.toString))

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

  def getProductionOrder(productionOrderId: UUID): Task[ProductionOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductionOrder] = jsonOf[ProductionOrder]

    val path = "/api/v1/production-orders/{production_order_id}".replaceAll("\\{" + "production_order_id" + "\\}",escape(productionOrderId.toString))

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
      resp          <- client.expect[ProductionOrder](req)

    } yield resp
  }

  def listProductionOrders(page: Integer, pageSize: Integer, search: String, status: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], statusQuery: QueryParam[String]): Task[List[ProductionOrder]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ProductionOrder]] = jsonOf[List[ProductionOrder]]

    val path = "/api/v1/production-orders/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("search", Some(searchQuery.toParamString(search))), ("status", Some(statusQuery.toParamString(status))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ProductionOrder]](req)

    } yield resp
  }

  def productionOrderCosting(productionOrderId: UUID): Task[ProductionOrderCosting] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductionOrderCosting] = jsonOf[ProductionOrderCosting]

    val path = "/api/v1/production-orders/{production_order_id}/costing".replaceAll("\\{" + "production_order_id" + "\\}",escape(productionOrderId.toString))

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
      resp          <- client.expect[ProductionOrderCosting](req)

    } yield resp
  }

  def updateProductionOrder(productionOrderId: UUID, productionOrder: ProductionOrder): Task[ProductionOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductionOrder] = jsonOf[ProductionOrder]

    val path = "/api/v1/production-orders/{production_order_id}".replaceAll("\\{" + "production_order_id" + "\\}",escape(productionOrderId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productionOrder)
      resp          <- client.expect[ProductionOrder](req)

    } yield resp
  }

  def updateProductionOrderStatus(productionOrderId: UUID, productionOrderStatusUpdate: ProductionOrderStatusUpdate): Task[ProductionOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductionOrder] = jsonOf[ProductionOrder]

    val path = "/api/v1/production-orders/{production_order_id}/status".replaceAll("\\{" + "production_order_id" + "\\}",escape(productionOrderId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productionOrderStatusUpdate)
      resp          <- client.expect[ProductionOrder](req)

    } yield resp
  }

}
