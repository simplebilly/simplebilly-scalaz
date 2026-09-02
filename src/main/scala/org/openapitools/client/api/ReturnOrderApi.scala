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
import org.openapitools.client.api.ReturnLogisticsQueueItem
import org.openapitools.client.api.ReturnLogisticsSummary
import org.openapitools.client.api.ReturnOrder
import org.openapitools.client.api.ReturnOrderStatusUpdate

object ReturnOrderApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createReturnOrder(host: String, returnOrder: ReturnOrder): Task[ReturnOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ReturnOrder] = jsonOf[ReturnOrder]

    val path = "/api/v1/returns"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(returnOrder)
      resp          <- client.expect[ReturnOrder](req)

    } yield resp
  }

  def deleteReturnOrder(host: String, returnOrderId: String): Task[Unit] = {
    val path = "/api/v1/returns/{return_order_id}".replaceAll("\\{" + "return_order_id" + "\\}",escape(returnOrderId.toString))

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

  def getReturnOrder(host: String, returnOrderId: String): Task[ReturnOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ReturnOrder] = jsonOf[ReturnOrder]

    val path = "/api/v1/returns/{return_order_id}".replaceAll("\\{" + "return_order_id" + "\\}",escape(returnOrderId.toString))

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
      resp          <- client.expect[ReturnOrder](req)

    } yield resp
  }

  def listReturnOrders(host: String, page: Integer, pageSize: Integer, status: String, customerName: String, orderNumber: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], customerNameQuery: QueryParam[String], orderNumberQuery: QueryParam[String]): Task[List[ReturnOrder]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ReturnOrder]] = jsonOf[List[ReturnOrder]]

    val path = "/api/v1/returns/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("customerName", Some(customer_nameQuery.toParamString(customer_name))), ("orderNumber", Some(order_numberQuery.toParamString(order_number))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ReturnOrder]](req)

    } yield resp
  }

  def returnLogisticsQueue(host: String): Task[List[ReturnLogisticsQueueItem]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ReturnLogisticsQueueItem]] = jsonOf[List[ReturnLogisticsQueueItem]]

    val path = "/api/v1/returns/logistics-queue"

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
      resp          <- client.expect[List[ReturnLogisticsQueueItem]](req)

    } yield resp
  }

  def returnLogisticsSummary(host: String): Task[ReturnLogisticsSummary] = {
    implicit val returnTypeDecoder: EntityDecoder[ReturnLogisticsSummary] = jsonOf[ReturnLogisticsSummary]

    val path = "/api/v1/returns/logistics-summary"

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
      resp          <- client.expect[ReturnLogisticsSummary](req)

    } yield resp
  }

  def updateReturnOrder(host: String, returnOrderId: String, body: AnyType): Task[ReturnOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ReturnOrder] = jsonOf[ReturnOrder]

    val path = "/api/v1/returns/{return_order_id}".replaceAll("\\{" + "return_order_id" + "\\}",escape(returnOrderId.toString))

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
      resp          <- client.expect[ReturnOrder](req)

    } yield resp
  }

  def updateReturnOrderStatus(host: String, returnOrderId: String, returnOrderStatusUpdate: ReturnOrderStatusUpdate): Task[ReturnOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ReturnOrder] = jsonOf[ReturnOrder]

    val path = "/api/v1/returns/{return_order_id}/status".replaceAll("\\{" + "return_order_id" + "\\}",escape(returnOrderId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(returnOrderStatusUpdate)
      resp          <- client.expect[ReturnOrder](req)

    } yield resp
  }

}

class HttpServiceReturnOrderApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createReturnOrder(returnOrder: ReturnOrder): Task[ReturnOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ReturnOrder] = jsonOf[ReturnOrder]

    val path = "/api/v1/returns"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(returnOrder)
      resp          <- client.expect[ReturnOrder](req)

    } yield resp
  }

  def deleteReturnOrder(returnOrderId: String): Task[Unit] = {
    val path = "/api/v1/returns/{return_order_id}".replaceAll("\\{" + "return_order_id" + "\\}",escape(returnOrderId.toString))

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

  def getReturnOrder(returnOrderId: String): Task[ReturnOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ReturnOrder] = jsonOf[ReturnOrder]

    val path = "/api/v1/returns/{return_order_id}".replaceAll("\\{" + "return_order_id" + "\\}",escape(returnOrderId.toString))

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
      resp          <- client.expect[ReturnOrder](req)

    } yield resp
  }

  def listReturnOrders(page: Integer, pageSize: Integer, status: String, customerName: String, orderNumber: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], customerNameQuery: QueryParam[String], orderNumberQuery: QueryParam[String]): Task[List[ReturnOrder]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ReturnOrder]] = jsonOf[List[ReturnOrder]]

    val path = "/api/v1/returns/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("customerName", Some(customer_nameQuery.toParamString(customer_name))), ("orderNumber", Some(order_numberQuery.toParamString(order_number))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ReturnOrder]](req)

    } yield resp
  }

  def returnLogisticsQueue(): Task[List[ReturnLogisticsQueueItem]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ReturnLogisticsQueueItem]] = jsonOf[List[ReturnLogisticsQueueItem]]

    val path = "/api/v1/returns/logistics-queue"

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
      resp          <- client.expect[List[ReturnLogisticsQueueItem]](req)

    } yield resp
  }

  def returnLogisticsSummary(): Task[ReturnLogisticsSummary] = {
    implicit val returnTypeDecoder: EntityDecoder[ReturnLogisticsSummary] = jsonOf[ReturnLogisticsSummary]

    val path = "/api/v1/returns/logistics-summary"

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
      resp          <- client.expect[ReturnLogisticsSummary](req)

    } yield resp
  }

  def updateReturnOrder(returnOrderId: String, body: AnyType): Task[ReturnOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ReturnOrder] = jsonOf[ReturnOrder]

    val path = "/api/v1/returns/{return_order_id}".replaceAll("\\{" + "return_order_id" + "\\}",escape(returnOrderId.toString))

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
      resp          <- client.expect[ReturnOrder](req)

    } yield resp
  }

  def updateReturnOrderStatus(returnOrderId: String, returnOrderStatusUpdate: ReturnOrderStatusUpdate): Task[ReturnOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[ReturnOrder] = jsonOf[ReturnOrder]

    val path = "/api/v1/returns/{return_order_id}/status".replaceAll("\\{" + "return_order_id" + "\\}",escape(returnOrderId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(returnOrderStatusUpdate)
      resp          <- client.expect[ReturnOrder](req)

    } yield resp
  }

}
