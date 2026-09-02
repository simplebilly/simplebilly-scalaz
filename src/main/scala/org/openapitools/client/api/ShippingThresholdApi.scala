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

import org.openapitools.client.api.DeliverableResponse
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.ShippingThreshold
import org.openapitools.client.api.ShippingThresholdCreate
import org.openapitools.client.api.ShippingThresholdUpdate
import java.util.UUID

object ShippingThresholdApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createShippingThreshold(host: String, shippingThresholdCreate: ShippingThresholdCreate): Task[ShippingThreshold] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingThreshold] = jsonOf[ShippingThreshold]

    val path = "/api/v1/shipping-thresholds"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shippingThresholdCreate)
      resp          <- client.expect[ShippingThreshold](req)

    } yield resp
  }

  def deleteShippingThreshold(host: String, thresholdId: String): Task[Unit] = {
    val path = "/api/v1/shipping-thresholds/{threshold_id}".replaceAll("\\{" + "threshold_id" + "\\}",escape(thresholdId.toString))

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

  def getDeliverable(host: String, productId: UUID, warehouseId: String)(implicit productIdQuery: QueryParam[UUID], warehouseIdQuery: QueryParam[String]): Task[DeliverableResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliverableResponse] = jsonOf[DeliverableResponse]

    val path = "/api/v1/shipping-thresholds/deliverable"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("productId", Some(productIdQuery.toParamString(productId))), ("warehouseId", Some(warehouseIdQuery.toParamString(warehouseId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[DeliverableResponse](req)

    } yield resp
  }

  def getShippingThreshold(host: String, thresholdId: String): Task[ShippingThreshold] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingThreshold] = jsonOf[ShippingThreshold]

    val path = "/api/v1/shipping-thresholds/{threshold_id}".replaceAll("\\{" + "threshold_id" + "\\}",escape(thresholdId.toString))

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
      resp          <- client.expect[ShippingThreshold](req)

    } yield resp
  }

  def listShippingThresholds(host: String, page: Integer, pageSize: Integer, productId: UUID, warehouseId: String, isActive: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], productIdQuery: QueryParam[UUID], warehouseIdQuery: QueryParam[String], isActiveQuery: QueryParam[Boolean]): Task[List[ShippingThreshold]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ShippingThreshold]] = jsonOf[List[ShippingThreshold]]

    val path = "/api/v1/shipping-thresholds/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("productId", Some(product_idQuery.toParamString(product_id))), ("warehouseId", Some(warehouse_idQuery.toParamString(warehouse_id))), ("isActive", Some(is_activeQuery.toParamString(is_active))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ShippingThreshold]](req)

    } yield resp
  }

  def updateShippingThreshold(host: String, thresholdId: String, shippingThresholdUpdate: ShippingThresholdUpdate): Task[ShippingThreshold] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingThreshold] = jsonOf[ShippingThreshold]

    val path = "/api/v1/shipping-thresholds/{threshold_id}".replaceAll("\\{" + "threshold_id" + "\\}",escape(thresholdId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shippingThresholdUpdate)
      resp          <- client.expect[ShippingThreshold](req)

    } yield resp
  }

}

class HttpServiceShippingThresholdApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createShippingThreshold(shippingThresholdCreate: ShippingThresholdCreate): Task[ShippingThreshold] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingThreshold] = jsonOf[ShippingThreshold]

    val path = "/api/v1/shipping-thresholds"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shippingThresholdCreate)
      resp          <- client.expect[ShippingThreshold](req)

    } yield resp
  }

  def deleteShippingThreshold(thresholdId: String): Task[Unit] = {
    val path = "/api/v1/shipping-thresholds/{threshold_id}".replaceAll("\\{" + "threshold_id" + "\\}",escape(thresholdId.toString))

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

  def getDeliverable(productId: UUID, warehouseId: String)(implicit productIdQuery: QueryParam[UUID], warehouseIdQuery: QueryParam[String]): Task[DeliverableResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliverableResponse] = jsonOf[DeliverableResponse]

    val path = "/api/v1/shipping-thresholds/deliverable"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("productId", Some(productIdQuery.toParamString(productId))), ("warehouseId", Some(warehouseIdQuery.toParamString(warehouseId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[DeliverableResponse](req)

    } yield resp
  }

  def getShippingThreshold(thresholdId: String): Task[ShippingThreshold] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingThreshold] = jsonOf[ShippingThreshold]

    val path = "/api/v1/shipping-thresholds/{threshold_id}".replaceAll("\\{" + "threshold_id" + "\\}",escape(thresholdId.toString))

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
      resp          <- client.expect[ShippingThreshold](req)

    } yield resp
  }

  def listShippingThresholds(page: Integer, pageSize: Integer, productId: UUID, warehouseId: String, isActive: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], productIdQuery: QueryParam[UUID], warehouseIdQuery: QueryParam[String], isActiveQuery: QueryParam[Boolean]): Task[List[ShippingThreshold]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ShippingThreshold]] = jsonOf[List[ShippingThreshold]]

    val path = "/api/v1/shipping-thresholds/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("productId", Some(product_idQuery.toParamString(product_id))), ("warehouseId", Some(warehouse_idQuery.toParamString(warehouse_id))), ("isActive", Some(is_activeQuery.toParamString(is_active))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ShippingThreshold]](req)

    } yield resp
  }

  def updateShippingThreshold(thresholdId: String, shippingThresholdUpdate: ShippingThresholdUpdate): Task[ShippingThreshold] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingThreshold] = jsonOf[ShippingThreshold]

    val path = "/api/v1/shipping-thresholds/{threshold_id}".replaceAll("\\{" + "threshold_id" + "\\}",escape(thresholdId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shippingThresholdUpdate)
      resp          <- client.expect[ShippingThreshold](req)

    } yield resp
  }

}
