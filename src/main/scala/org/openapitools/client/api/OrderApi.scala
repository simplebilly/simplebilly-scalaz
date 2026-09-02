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
import org.openapitools.client.api.Order
import org.openapitools.client.api.OrderStateUpdate
import org.openapitools.client.api.OrderTagsRequest
import org.openapitools.client.api.PluginError

object OrderApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def addOrderTags(host: String, orderId: String, orderTagsRequest: OrderTagsRequest): Task[Order] = {
    implicit val returnTypeDecoder: EntityDecoder[Order] = jsonOf[Order]

    val path = "/api/v1/orders/{order_id}/tags".replaceAll("\\{" + "order_id" + "\\}",escape(orderId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(orderTagsRequest)
      resp          <- client.expect[Order](req)

    } yield resp
  }

  def findOrderByExternalRef(host: String, extRef: String): Task[Order] = {
    implicit val returnTypeDecoder: EntityDecoder[Order] = jsonOf[Order]

    val path = "/api/v1/orders/by-ext-ref/{ext_ref}".replaceAll("\\{" + "ext_ref" + "\\}",escape(extRef.toString))

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
      resp          <- client.expect[Order](req)

    } yield resp
  }

  def getOrder(host: String, orderNumber: String): Task[Order] = {
    implicit val returnTypeDecoder: EntityDecoder[Order] = jsonOf[Order]

    val path = "/api/v1/order/{order_number}".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

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
      resp          <- client.expect[Order](req)

    } yield resp
  }

  def getOrders(host: String, page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[Order]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Order]] = jsonOf[List[Order]]

    val path = "/api/v1/orders"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("search", Some(searchQuery.toParamString(search))), ("includeDeleted", Some(include_deletedQuery.toParamString(include_deleted))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Order]](req)

    } yield resp
  }

  def patchOrder(host: String, orderId: String, body: AnyType): Task[Order] = {
    implicit val returnTypeDecoder: EntityDecoder[Order] = jsonOf[Order]

    val path = "/api/v1/orders/{order_id}".replaceAll("\\{" + "order_id" + "\\}",escape(orderId.toString))

    val httpMethod = Method.PATCH
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[Order](req)

    } yield resp
  }

  def replaceOrderTags(host: String, orderId: String, orderTagsRequest: OrderTagsRequest): Task[Order] = {
    implicit val returnTypeDecoder: EntityDecoder[Order] = jsonOf[Order]

    val path = "/api/v1/orders/{order_id}/tags".replaceAll("\\{" + "order_id" + "\\}",escape(orderId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(orderTagsRequest)
      resp          <- client.expect[Order](req)

    } yield resp
  }

  def updateOrderState(host: String, orderId: String, orderStateUpdate: OrderStateUpdate): Task[Order] = {
    implicit val returnTypeDecoder: EntityDecoder[Order] = jsonOf[Order]

    val path = "/api/v1/orders/{order_id}/state".replaceAll("\\{" + "order_id" + "\\}",escape(orderId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(orderStateUpdate)
      resp          <- client.expect[Order](req)

    } yield resp
  }

}

class HttpServiceOrderApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def addOrderTags(orderId: String, orderTagsRequest: OrderTagsRequest): Task[Order] = {
    implicit val returnTypeDecoder: EntityDecoder[Order] = jsonOf[Order]

    val path = "/api/v1/orders/{order_id}/tags".replaceAll("\\{" + "order_id" + "\\}",escape(orderId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(orderTagsRequest)
      resp          <- client.expect[Order](req)

    } yield resp
  }

  def findOrderByExternalRef(extRef: String): Task[Order] = {
    implicit val returnTypeDecoder: EntityDecoder[Order] = jsonOf[Order]

    val path = "/api/v1/orders/by-ext-ref/{ext_ref}".replaceAll("\\{" + "ext_ref" + "\\}",escape(extRef.toString))

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
      resp          <- client.expect[Order](req)

    } yield resp
  }

  def getOrder(orderNumber: String): Task[Order] = {
    implicit val returnTypeDecoder: EntityDecoder[Order] = jsonOf[Order]

    val path = "/api/v1/order/{order_number}".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

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
      resp          <- client.expect[Order](req)

    } yield resp
  }

  def getOrders(page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[Order]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Order]] = jsonOf[List[Order]]

    val path = "/api/v1/orders"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("search", Some(searchQuery.toParamString(search))), ("includeDeleted", Some(include_deletedQuery.toParamString(include_deleted))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Order]](req)

    } yield resp
  }

  def patchOrder(orderId: String, body: AnyType): Task[Order] = {
    implicit val returnTypeDecoder: EntityDecoder[Order] = jsonOf[Order]

    val path = "/api/v1/orders/{order_id}".replaceAll("\\{" + "order_id" + "\\}",escape(orderId.toString))

    val httpMethod = Method.PATCH
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[Order](req)

    } yield resp
  }

  def replaceOrderTags(orderId: String, orderTagsRequest: OrderTagsRequest): Task[Order] = {
    implicit val returnTypeDecoder: EntityDecoder[Order] = jsonOf[Order]

    val path = "/api/v1/orders/{order_id}/tags".replaceAll("\\{" + "order_id" + "\\}",escape(orderId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(orderTagsRequest)
      resp          <- client.expect[Order](req)

    } yield resp
  }

  def updateOrderState(orderId: String, orderStateUpdate: OrderStateUpdate): Task[Order] = {
    implicit val returnTypeDecoder: EntityDecoder[Order] = jsonOf[Order]

    val path = "/api/v1/orders/{order_id}/state".replaceAll("\\{" + "order_id" + "\\}",escape(orderId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(orderStateUpdate)
      resp          <- client.expect[Order](req)

    } yield resp
  }

}
