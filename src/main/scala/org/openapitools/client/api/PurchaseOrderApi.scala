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
import org.openapitools.client.api.InvoiceMatchRequest
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.PurchaseOrder
import org.openapitools.client.api.PurchaseOrderStatusUpdate

object PurchaseOrderApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createPurchaseOrder(host: String, purchaseOrder: PurchaseOrder): Task[PurchaseOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[PurchaseOrder] = jsonOf[PurchaseOrder]

    val path = "/api/v1/purchase-orders"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(purchaseOrder)
      resp          <- client.expect[PurchaseOrder](req)

    } yield resp
  }

  def deletePurchaseOrder(host: String, purchaseOrderId: String): Task[Unit] = {
    val path = "/api/v1/purchase-orders/{purchase_order_id}".replaceAll("\\{" + "purchase_order_id" + "\\}",escape(purchaseOrderId.toString))

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

  def getPurchaseOrder(host: String, purchaseOrderId: String): Task[PurchaseOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[PurchaseOrder] = jsonOf[PurchaseOrder]

    val path = "/api/v1/purchase-orders/{purchase_order_id}".replaceAll("\\{" + "purchase_order_id" + "\\}",escape(purchaseOrderId.toString))

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
      resp          <- client.expect[PurchaseOrder](req)

    } yield resp
  }

  def listPurchaseOrders(host: String, page: Integer, pageSize: Integer, status: String, supplierName: String, search: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], supplierNameQuery: QueryParam[String], searchQuery: QueryParam[String]): Task[List[PurchaseOrder]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PurchaseOrder]] = jsonOf[List[PurchaseOrder]]

    val path = "/api/v1/purchase-orders/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("supplierName", Some(supplier_nameQuery.toParamString(supplier_name))), ("search", Some(searchQuery.toParamString(search))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[PurchaseOrder]](req)

    } yield resp
  }

  def matchInvoice(host: String, purchaseOrderId: String, invoiceMatchRequest: InvoiceMatchRequest): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/purchase-orders/{purchase_order_id}/match-invoice".replaceAll("\\{" + "purchase_order_id" + "\\}",escape(purchaseOrderId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(invoiceMatchRequest)
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def updatePurchaseOrder(host: String, purchaseOrderId: String, body: AnyType): Task[PurchaseOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[PurchaseOrder] = jsonOf[PurchaseOrder]

    val path = "/api/v1/purchase-orders/{purchase_order_id}".replaceAll("\\{" + "purchase_order_id" + "\\}",escape(purchaseOrderId.toString))

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
      resp          <- client.expect[PurchaseOrder](req)

    } yield resp
  }

  def updatePurchaseOrderStatus(host: String, purchaseOrderId: String, purchaseOrderStatusUpdate: PurchaseOrderStatusUpdate): Task[PurchaseOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[PurchaseOrder] = jsonOf[PurchaseOrder]

    val path = "/api/v1/purchase-orders/{purchase_order_id}/status".replaceAll("\\{" + "purchase_order_id" + "\\}",escape(purchaseOrderId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(purchaseOrderStatusUpdate)
      resp          <- client.expect[PurchaseOrder](req)

    } yield resp
  }

}

class HttpServicePurchaseOrderApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createPurchaseOrder(purchaseOrder: PurchaseOrder): Task[PurchaseOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[PurchaseOrder] = jsonOf[PurchaseOrder]

    val path = "/api/v1/purchase-orders"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(purchaseOrder)
      resp          <- client.expect[PurchaseOrder](req)

    } yield resp
  }

  def deletePurchaseOrder(purchaseOrderId: String): Task[Unit] = {
    val path = "/api/v1/purchase-orders/{purchase_order_id}".replaceAll("\\{" + "purchase_order_id" + "\\}",escape(purchaseOrderId.toString))

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

  def getPurchaseOrder(purchaseOrderId: String): Task[PurchaseOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[PurchaseOrder] = jsonOf[PurchaseOrder]

    val path = "/api/v1/purchase-orders/{purchase_order_id}".replaceAll("\\{" + "purchase_order_id" + "\\}",escape(purchaseOrderId.toString))

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
      resp          <- client.expect[PurchaseOrder](req)

    } yield resp
  }

  def listPurchaseOrders(page: Integer, pageSize: Integer, status: String, supplierName: String, search: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], supplierNameQuery: QueryParam[String], searchQuery: QueryParam[String]): Task[List[PurchaseOrder]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PurchaseOrder]] = jsonOf[List[PurchaseOrder]]

    val path = "/api/v1/purchase-orders/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("supplierName", Some(supplier_nameQuery.toParamString(supplier_name))), ("search", Some(searchQuery.toParamString(search))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[PurchaseOrder]](req)

    } yield resp
  }

  def matchInvoice(purchaseOrderId: String, invoiceMatchRequest: InvoiceMatchRequest): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/purchase-orders/{purchase_order_id}/match-invoice".replaceAll("\\{" + "purchase_order_id" + "\\}",escape(purchaseOrderId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(invoiceMatchRequest)
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def updatePurchaseOrder(purchaseOrderId: String, body: AnyType): Task[PurchaseOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[PurchaseOrder] = jsonOf[PurchaseOrder]

    val path = "/api/v1/purchase-orders/{purchase_order_id}".replaceAll("\\{" + "purchase_order_id" + "\\}",escape(purchaseOrderId.toString))

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
      resp          <- client.expect[PurchaseOrder](req)

    } yield resp
  }

  def updatePurchaseOrderStatus(purchaseOrderId: String, purchaseOrderStatusUpdate: PurchaseOrderStatusUpdate): Task[PurchaseOrder] = {
    implicit val returnTypeDecoder: EntityDecoder[PurchaseOrder] = jsonOf[PurchaseOrder]

    val path = "/api/v1/purchase-orders/{purchase_order_id}/status".replaceAll("\\{" + "purchase_order_id" + "\\}",escape(purchaseOrderId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(purchaseOrderStatusUpdate)
      resp          <- client.expect[PurchaseOrder](req)

    } yield resp
  }

}
