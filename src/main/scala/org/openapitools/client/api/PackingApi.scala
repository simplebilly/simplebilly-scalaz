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
import org.openapitools.client.api.PackingCompleteRequest
import org.openapitools.client.api.PackingCompleteResponse
import org.openapitools.client.api.PackingQueue
import org.openapitools.client.api.PackingVideoResponse
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.PrintDeliveryNoteResponse
import org.openapitools.client.api.PrintLabelResponse

object PackingApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def completePacking(host: String, orderNumber: String, packingCompleteRequest: PackingCompleteRequest): Task[PackingCompleteResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PackingCompleteResponse] = jsonOf[PackingCompleteResponse]

    val path = "/api/v1/packing/{order_number}/complete".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(packingCompleteRequest)
      resp          <- client.expect[PackingCompleteResponse](req)

    } yield resp
  }

  def getPackingQueue(host: String, page: Integer, pageSize: Integer, search: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String]): Task[PackingQueue] = {
    implicit val returnTypeDecoder: EntityDecoder[PackingQueue] = jsonOf[PackingQueue]

    val path = "/api/v1/packing/queue"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("search", Some(searchQuery.toParamString(search))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PackingQueue](req)

    } yield resp
  }

  def printDeliveryNote(host: String, orderNumber: String): Task[PrintDeliveryNoteResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PrintDeliveryNoteResponse] = jsonOf[PrintDeliveryNoteResponse]

    val path = "/api/v1/packing/{order_number}/print-delivery-note".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PrintDeliveryNoteResponse](req)

    } yield resp
  }

  def printLabel(host: String, orderNumber: String): Task[PrintLabelResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PrintLabelResponse] = jsonOf[PrintLabelResponse]

    val path = "/api/v1/packing/{order_number}/print-label".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PrintLabelResponse](req)

    } yield resp
  }

  def recordPackingVideo(host: String, orderNumber: String, body: AnyType): Task[PackingVideoResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PackingVideoResponse] = jsonOf[PackingVideoResponse]

    val path = "/api/v1/packing/{order_number}/record-video".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[PackingVideoResponse](req)

    } yield resp
  }

}

class HttpServicePackingApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def completePacking(orderNumber: String, packingCompleteRequest: PackingCompleteRequest): Task[PackingCompleteResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PackingCompleteResponse] = jsonOf[PackingCompleteResponse]

    val path = "/api/v1/packing/{order_number}/complete".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(packingCompleteRequest)
      resp          <- client.expect[PackingCompleteResponse](req)

    } yield resp
  }

  def getPackingQueue(page: Integer, pageSize: Integer, search: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String]): Task[PackingQueue] = {
    implicit val returnTypeDecoder: EntityDecoder[PackingQueue] = jsonOf[PackingQueue]

    val path = "/api/v1/packing/queue"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("search", Some(searchQuery.toParamString(search))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PackingQueue](req)

    } yield resp
  }

  def printDeliveryNote(orderNumber: String): Task[PrintDeliveryNoteResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PrintDeliveryNoteResponse] = jsonOf[PrintDeliveryNoteResponse]

    val path = "/api/v1/packing/{order_number}/print-delivery-note".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PrintDeliveryNoteResponse](req)

    } yield resp
  }

  def printLabel(orderNumber: String): Task[PrintLabelResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PrintLabelResponse] = jsonOf[PrintLabelResponse]

    val path = "/api/v1/packing/{order_number}/print-label".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PrintLabelResponse](req)

    } yield resp
  }

  def recordPackingVideo(orderNumber: String, body: AnyType): Task[PackingVideoResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PackingVideoResponse] = jsonOf[PackingVideoResponse]

    val path = "/api/v1/packing/{order_number}/record-video".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[PackingVideoResponse](req)

    } yield resp
  }

}
