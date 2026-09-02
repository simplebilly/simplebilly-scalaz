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
import org.openapitools.client.api.DeliveryDate
import org.openapitools.client.api.DeliveryDateCreate
import org.openapitools.client.api.DeliveryDateStatusUpdate
import java.time.LocalDate
import org.openapitools.client.api.PluginError

object DeliveryDateApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createDeliveryDate(host: String, deliveryDateCreate: DeliveryDateCreate): Task[DeliveryDate] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryDate] = jsonOf[DeliveryDate]

    val path = "/api/v1/delivery-dates"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(deliveryDateCreate)
      resp          <- client.expect[DeliveryDate](req)

    } yield resp
  }

  def deleteDeliveryDate(host: String, deliveryDateId: String): Task[Unit] = {
    val path = "/api/v1/delivery-dates/{delivery_date_id}".replaceAll("\\{" + "delivery_date_id" + "\\}",escape(deliveryDateId.toString))

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

  def getDeliveryDate(host: String, deliveryDateId: String): Task[DeliveryDate] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryDate] = jsonOf[DeliveryDate]

    val path = "/api/v1/delivery-dates/{delivery_date_id}".replaceAll("\\{" + "delivery_date_id" + "\\}",escape(deliveryDateId.toString))

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
      resp          <- client.expect[DeliveryDate](req)

    } yield resp
  }

  def getDeliveryPerformance(host: String, page: Integer, pageSize: Integer, orderNumber: String, status: String, from: LocalDate, to: LocalDate)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], orderNumberQuery: QueryParam[String], statusQuery: QueryParam[String], fromQuery: QueryParam[LocalDate], toQuery: QueryParam[LocalDate]): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/delivery-dates/performance"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("orderNumber", Some(orderNumberQuery.toParamString(orderNumber))), ("status", Some(statusQuery.toParamString(status))), ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def listDeliveryDates(host: String, page: Integer, pageSize: Integer, orderNumber: String, status: String, from: LocalDate, to: LocalDate)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], orderNumberQuery: QueryParam[String], statusQuery: QueryParam[String], fromQuery: QueryParam[LocalDate], toQuery: QueryParam[LocalDate]): Task[List[DeliveryDate]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[DeliveryDate]] = jsonOf[List[DeliveryDate]]

    val path = "/api/v1/delivery-dates/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("orderNumber", Some(orderNumberQuery.toParamString(orderNumber))), ("status", Some(statusQuery.toParamString(status))), ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[DeliveryDate]](req)

    } yield resp
  }

  def updateDeliveryDate(host: String, deliveryDateId: String, body: AnyType): Task[DeliveryDate] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryDate] = jsonOf[DeliveryDate]

    val path = "/api/v1/delivery-dates/{delivery_date_id}".replaceAll("\\{" + "delivery_date_id" + "\\}",escape(deliveryDateId.toString))

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
      resp          <- client.expect[DeliveryDate](req)

    } yield resp
  }

  def updateDeliveryDateStatus(host: String, deliveryDateId: String, deliveryDateStatusUpdate: DeliveryDateStatusUpdate): Task[DeliveryDate] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryDate] = jsonOf[DeliveryDate]

    val path = "/api/v1/delivery-dates/{delivery_date_id}/status".replaceAll("\\{" + "delivery_date_id" + "\\}",escape(deliveryDateId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(deliveryDateStatusUpdate)
      resp          <- client.expect[DeliveryDate](req)

    } yield resp
  }

}

class HttpServiceDeliveryDateApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createDeliveryDate(deliveryDateCreate: DeliveryDateCreate): Task[DeliveryDate] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryDate] = jsonOf[DeliveryDate]

    val path = "/api/v1/delivery-dates"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(deliveryDateCreate)
      resp          <- client.expect[DeliveryDate](req)

    } yield resp
  }

  def deleteDeliveryDate(deliveryDateId: String): Task[Unit] = {
    val path = "/api/v1/delivery-dates/{delivery_date_id}".replaceAll("\\{" + "delivery_date_id" + "\\}",escape(deliveryDateId.toString))

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

  def getDeliveryDate(deliveryDateId: String): Task[DeliveryDate] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryDate] = jsonOf[DeliveryDate]

    val path = "/api/v1/delivery-dates/{delivery_date_id}".replaceAll("\\{" + "delivery_date_id" + "\\}",escape(deliveryDateId.toString))

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
      resp          <- client.expect[DeliveryDate](req)

    } yield resp
  }

  def getDeliveryPerformance(page: Integer, pageSize: Integer, orderNumber: String, status: String, from: LocalDate, to: LocalDate)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], orderNumberQuery: QueryParam[String], statusQuery: QueryParam[String], fromQuery: QueryParam[LocalDate], toQuery: QueryParam[LocalDate]): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/delivery-dates/performance"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("orderNumber", Some(orderNumberQuery.toParamString(orderNumber))), ("status", Some(statusQuery.toParamString(status))), ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def listDeliveryDates(page: Integer, pageSize: Integer, orderNumber: String, status: String, from: LocalDate, to: LocalDate)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], orderNumberQuery: QueryParam[String], statusQuery: QueryParam[String], fromQuery: QueryParam[LocalDate], toQuery: QueryParam[LocalDate]): Task[List[DeliveryDate]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[DeliveryDate]] = jsonOf[List[DeliveryDate]]

    val path = "/api/v1/delivery-dates/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("orderNumber", Some(orderNumberQuery.toParamString(orderNumber))), ("status", Some(statusQuery.toParamString(status))), ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[DeliveryDate]](req)

    } yield resp
  }

  def updateDeliveryDate(deliveryDateId: String, body: AnyType): Task[DeliveryDate] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryDate] = jsonOf[DeliveryDate]

    val path = "/api/v1/delivery-dates/{delivery_date_id}".replaceAll("\\{" + "delivery_date_id" + "\\}",escape(deliveryDateId.toString))

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
      resp          <- client.expect[DeliveryDate](req)

    } yield resp
  }

  def updateDeliveryDateStatus(deliveryDateId: String, deliveryDateStatusUpdate: DeliveryDateStatusUpdate): Task[DeliveryDate] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryDate] = jsonOf[DeliveryDate]

    val path = "/api/v1/delivery-dates/{delivery_date_id}/status".replaceAll("\\{" + "delivery_date_id" + "\\}",escape(deliveryDateId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(deliveryDateStatusUpdate)
      resp          <- client.expect[DeliveryDate](req)

    } yield resp
  }

}
