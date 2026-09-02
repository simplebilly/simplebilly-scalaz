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
import org.openapitools.client.api.AppointmentStatusUpdate
import org.openapitools.client.api.DeliveryAppointment
import org.openapitools.client.api.DeliveryAppointmentCreate
import java.time.LocalDate
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.PublicDeliveryAppointmentRequest
import org.openapitools.client.api.PublicDeliveryAppointmentResponse
import org.openapitools.client.api.PublicDeliveryAppointmentStatusResponse

object DeliveryAppointmentApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createDeliveryAppointment(host: String, deliveryAppointmentCreate: DeliveryAppointmentCreate): Task[DeliveryAppointment] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryAppointment] = jsonOf[DeliveryAppointment]

    val path = "/api/v1/delivery-appointments"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(deliveryAppointmentCreate)
      resp          <- client.expect[DeliveryAppointment](req)

    } yield resp
  }

  def deleteDeliveryAppointment(host: String, appointmentId: String): Task[Unit] = {
    val path = "/api/v1/delivery-appointments/{appointment_id}".replaceAll("\\{" + "appointment_id" + "\\}",escape(appointmentId.toString))

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

  def getDeliveryAppointment(host: String, appointmentId: String): Task[DeliveryAppointment] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryAppointment] = jsonOf[DeliveryAppointment]

    val path = "/api/v1/delivery-appointments/{appointment_id}".replaceAll("\\{" + "appointment_id" + "\\}",escape(appointmentId.toString))

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
      resp          <- client.expect[DeliveryAppointment](req)

    } yield resp
  }

  def getPublicDeliveryAppointmentStatus(host: String, appointmentId: String, email: String, token: String)(implicit appointmentIdQuery: QueryParam[String], emailQuery: QueryParam[String], tokenQuery: QueryParam[String]): Task[PublicDeliveryAppointmentStatusResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PublicDeliveryAppointmentStatusResponse] = jsonOf[PublicDeliveryAppointmentStatusResponse]

    val path = "/api/v1/public/delivery-appointments/status"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("appointmentId", Some(appointmentIdQuery.toParamString(appointmentId))), ("email", Some(emailQuery.toParamString(email))), ("token", Some(tokenQuery.toParamString(token))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PublicDeliveryAppointmentStatusResponse](req)

    } yield resp
  }

  def listDeliveryAppointments(host: String, page: Integer, pageSize: Integer, status: String, warehouseId: String, from: LocalDate, to: LocalDate)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], warehouseIdQuery: QueryParam[String], fromQuery: QueryParam[LocalDate], toQuery: QueryParam[LocalDate]): Task[List[DeliveryAppointment]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[DeliveryAppointment]] = jsonOf[List[DeliveryAppointment]]

    val path = "/api/v1/delivery-appointments"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("warehouseId", Some(warehouse_idQuery.toParamString(warehouse_id))), ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[DeliveryAppointment]](req)

    } yield resp
  }

  def requestPublicDeliveryAppointment(host: String, publicDeliveryAppointmentRequest: PublicDeliveryAppointmentRequest): Task[PublicDeliveryAppointmentResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PublicDeliveryAppointmentResponse] = jsonOf[PublicDeliveryAppointmentResponse]

    val path = "/api/v1/public/delivery-appointments/request"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(publicDeliveryAppointmentRequest)
      resp          <- client.expect[PublicDeliveryAppointmentResponse](req)

    } yield resp
  }

  def updateDeliveryAppointment(host: String, appointmentId: String, body: AnyType): Task[DeliveryAppointment] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryAppointment] = jsonOf[DeliveryAppointment]

    val path = "/api/v1/delivery-appointments/{appointment_id}".replaceAll("\\{" + "appointment_id" + "\\}",escape(appointmentId.toString))

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
      resp          <- client.expect[DeliveryAppointment](req)

    } yield resp
  }

  def updateDeliveryAppointmentStatus(host: String, appointmentId: String, appointmentStatusUpdate: AppointmentStatusUpdate): Task[DeliveryAppointment] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryAppointment] = jsonOf[DeliveryAppointment]

    val path = "/api/v1/delivery-appointments/{appointment_id}/status".replaceAll("\\{" + "appointment_id" + "\\}",escape(appointmentId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(appointmentStatusUpdate)
      resp          <- client.expect[DeliveryAppointment](req)

    } yield resp
  }

}

class HttpServiceDeliveryAppointmentApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createDeliveryAppointment(deliveryAppointmentCreate: DeliveryAppointmentCreate): Task[DeliveryAppointment] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryAppointment] = jsonOf[DeliveryAppointment]

    val path = "/api/v1/delivery-appointments"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(deliveryAppointmentCreate)
      resp          <- client.expect[DeliveryAppointment](req)

    } yield resp
  }

  def deleteDeliveryAppointment(appointmentId: String): Task[Unit] = {
    val path = "/api/v1/delivery-appointments/{appointment_id}".replaceAll("\\{" + "appointment_id" + "\\}",escape(appointmentId.toString))

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

  def getDeliveryAppointment(appointmentId: String): Task[DeliveryAppointment] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryAppointment] = jsonOf[DeliveryAppointment]

    val path = "/api/v1/delivery-appointments/{appointment_id}".replaceAll("\\{" + "appointment_id" + "\\}",escape(appointmentId.toString))

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
      resp          <- client.expect[DeliveryAppointment](req)

    } yield resp
  }

  def getPublicDeliveryAppointmentStatus(appointmentId: String, email: String, token: String)(implicit appointmentIdQuery: QueryParam[String], emailQuery: QueryParam[String], tokenQuery: QueryParam[String]): Task[PublicDeliveryAppointmentStatusResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PublicDeliveryAppointmentStatusResponse] = jsonOf[PublicDeliveryAppointmentStatusResponse]

    val path = "/api/v1/public/delivery-appointments/status"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("appointmentId", Some(appointmentIdQuery.toParamString(appointmentId))), ("email", Some(emailQuery.toParamString(email))), ("token", Some(tokenQuery.toParamString(token))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[PublicDeliveryAppointmentStatusResponse](req)

    } yield resp
  }

  def listDeliveryAppointments(page: Integer, pageSize: Integer, status: String, warehouseId: String, from: LocalDate, to: LocalDate)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], warehouseIdQuery: QueryParam[String], fromQuery: QueryParam[LocalDate], toQuery: QueryParam[LocalDate]): Task[List[DeliveryAppointment]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[DeliveryAppointment]] = jsonOf[List[DeliveryAppointment]]

    val path = "/api/v1/delivery-appointments"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("warehouseId", Some(warehouse_idQuery.toParamString(warehouse_id))), ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[DeliveryAppointment]](req)

    } yield resp
  }

  def requestPublicDeliveryAppointment(publicDeliveryAppointmentRequest: PublicDeliveryAppointmentRequest): Task[PublicDeliveryAppointmentResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[PublicDeliveryAppointmentResponse] = jsonOf[PublicDeliveryAppointmentResponse]

    val path = "/api/v1/public/delivery-appointments/request"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(publicDeliveryAppointmentRequest)
      resp          <- client.expect[PublicDeliveryAppointmentResponse](req)

    } yield resp
  }

  def updateDeliveryAppointment(appointmentId: String, body: AnyType): Task[DeliveryAppointment] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryAppointment] = jsonOf[DeliveryAppointment]

    val path = "/api/v1/delivery-appointments/{appointment_id}".replaceAll("\\{" + "appointment_id" + "\\}",escape(appointmentId.toString))

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
      resp          <- client.expect[DeliveryAppointment](req)

    } yield resp
  }

  def updateDeliveryAppointmentStatus(appointmentId: String, appointmentStatusUpdate: AppointmentStatusUpdate): Task[DeliveryAppointment] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryAppointment] = jsonOf[DeliveryAppointment]

    val path = "/api/v1/delivery-appointments/{appointment_id}/status".replaceAll("\\{" + "appointment_id" + "\\}",escape(appointmentId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(appointmentStatusUpdate)
      resp          <- client.expect[DeliveryAppointment](req)

    } yield resp
  }

}
