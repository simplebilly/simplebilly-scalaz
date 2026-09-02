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

import org.openapitools.client.api.CreateShipmentRequest
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.Shipment
import org.openapitools.client.api.ShipmentStatusUpdate
import org.openapitools.client.api.TrackOrderRequest
import org.openapitools.client.api.TrackOrderResponse
import org.openapitools.client.api.TrackingInfo

object ShipmentApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createShipment(host: String, shipment: Shipment): Task[Shipment] = {
    implicit val returnTypeDecoder: EntityDecoder[Shipment] = jsonOf[Shipment]

    val path = "/api/v1/shipments"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shipment)
      resp          <- client.expect[Shipment](req)

    } yield resp
  }

  def createShipmentFromOrder(host: String, orderNumber: String, createShipmentRequest: CreateShipmentRequest): Task[Shipment] = {
    implicit val returnTypeDecoder: EntityDecoder[Shipment] = jsonOf[Shipment]

    val path = "/api/v1/orders/{order_number}/shipments".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(createShipmentRequest)
      resp          <- client.expect[Shipment](req)

    } yield resp
  }

  def deleteShipment(host: String, shipmentId: String): Task[Unit] = {
    val path = "/api/v1/shipments/{shipment_id}".replaceAll("\\{" + "shipment_id" + "\\}",escape(shipmentId.toString))

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

  def getShipment(host: String, shipmentId: String): Task[Shipment] = {
    implicit val returnTypeDecoder: EntityDecoder[Shipment] = jsonOf[Shipment]

    val path = "/api/v1/shipments/{shipment_id}".replaceAll("\\{" + "shipment_id" + "\\}",escape(shipmentId.toString))

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
      resp          <- client.expect[Shipment](req)

    } yield resp
  }

  def listShipments(host: String, page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[Shipment]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Shipment]] = jsonOf[List[Shipment]]

    val path = "/api/v1/shipments"

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
      resp          <- client.expect[List[Shipment]](req)

    } yield resp
  }

  def trackOrderPublic(host: String, trackOrderRequest: TrackOrderRequest): Task[TrackOrderResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[TrackOrderResponse] = jsonOf[TrackOrderResponse]

    val path = "/api/v1/public/track"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(trackOrderRequest)
      resp          <- client.expect[TrackOrderResponse](req)

    } yield resp
  }

  def trackShipmentApi(host: String, shipmentId: String): Task[TrackingInfo] = {
    implicit val returnTypeDecoder: EntityDecoder[TrackingInfo] = jsonOf[TrackingInfo]

    val path = "/api/v1/shipments/{shipment_id}/tracking".replaceAll("\\{" + "shipment_id" + "\\}",escape(shipmentId.toString))

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
      resp          <- client.expect[TrackingInfo](req)

    } yield resp
  }

  def updateShipmentStatus(host: String, shipmentId: String, shipmentStatusUpdate: ShipmentStatusUpdate): Task[Shipment] = {
    implicit val returnTypeDecoder: EntityDecoder[Shipment] = jsonOf[Shipment]

    val path = "/api/v1/shipments/{shipment_id}/status".replaceAll("\\{" + "shipment_id" + "\\}",escape(shipmentId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shipmentStatusUpdate)
      resp          <- client.expect[Shipment](req)

    } yield resp
  }

}

class HttpServiceShipmentApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createShipment(shipment: Shipment): Task[Shipment] = {
    implicit val returnTypeDecoder: EntityDecoder[Shipment] = jsonOf[Shipment]

    val path = "/api/v1/shipments"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shipment)
      resp          <- client.expect[Shipment](req)

    } yield resp
  }

  def createShipmentFromOrder(orderNumber: String, createShipmentRequest: CreateShipmentRequest): Task[Shipment] = {
    implicit val returnTypeDecoder: EntityDecoder[Shipment] = jsonOf[Shipment]

    val path = "/api/v1/orders/{order_number}/shipments".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(createShipmentRequest)
      resp          <- client.expect[Shipment](req)

    } yield resp
  }

  def deleteShipment(shipmentId: String): Task[Unit] = {
    val path = "/api/v1/shipments/{shipment_id}".replaceAll("\\{" + "shipment_id" + "\\}",escape(shipmentId.toString))

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

  def getShipment(shipmentId: String): Task[Shipment] = {
    implicit val returnTypeDecoder: EntityDecoder[Shipment] = jsonOf[Shipment]

    val path = "/api/v1/shipments/{shipment_id}".replaceAll("\\{" + "shipment_id" + "\\}",escape(shipmentId.toString))

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
      resp          <- client.expect[Shipment](req)

    } yield resp
  }

  def listShipments(page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[Shipment]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Shipment]] = jsonOf[List[Shipment]]

    val path = "/api/v1/shipments"

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
      resp          <- client.expect[List[Shipment]](req)

    } yield resp
  }

  def trackOrderPublic(trackOrderRequest: TrackOrderRequest): Task[TrackOrderResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[TrackOrderResponse] = jsonOf[TrackOrderResponse]

    val path = "/api/v1/public/track"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(trackOrderRequest)
      resp          <- client.expect[TrackOrderResponse](req)

    } yield resp
  }

  def trackShipmentApi(shipmentId: String): Task[TrackingInfo] = {
    implicit val returnTypeDecoder: EntityDecoder[TrackingInfo] = jsonOf[TrackingInfo]

    val path = "/api/v1/shipments/{shipment_id}/tracking".replaceAll("\\{" + "shipment_id" + "\\}",escape(shipmentId.toString))

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
      resp          <- client.expect[TrackingInfo](req)

    } yield resp
  }

  def updateShipmentStatus(shipmentId: String, shipmentStatusUpdate: ShipmentStatusUpdate): Task[Shipment] = {
    implicit val returnTypeDecoder: EntityDecoder[Shipment] = jsonOf[Shipment]

    val path = "/api/v1/shipments/{shipment_id}/status".replaceAll("\\{" + "shipment_id" + "\\}",escape(shipmentId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shipmentStatusUpdate)
      resp          <- client.expect[Shipment](req)

    } yield resp
  }

}
