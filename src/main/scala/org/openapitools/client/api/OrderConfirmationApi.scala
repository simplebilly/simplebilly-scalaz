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

import org.openapitools.client.api.DeliveryNote
import org.openapitools.client.api.OrderConfirmation
import org.openapitools.client.api.OrderConfirmationCreate
import org.openapitools.client.api.PluginError

object OrderConfirmationApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createConfirmation(host: String, orderConfirmationCreate: OrderConfirmationCreate): Task[OrderConfirmation] = {
    implicit val returnTypeDecoder: EntityDecoder[OrderConfirmation] = jsonOf[OrderConfirmation]

    val path = "/api/v1/order-confirmations"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(orderConfirmationCreate)
      resp          <- client.expect[OrderConfirmation](req)

    } yield resp
  }

  def deleteConfirmation(host: String, confirmationId: String): Task[Unit] = {
    val path = "/api/v1/order-confirmations/{confirmation_id}".replaceAll("\\{" + "confirmation_id" + "\\}",escape(confirmationId.toString))

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

  def downloadConfirmationPdf(host: String, confirmationId: String): Task[Unit] = {
    val path = "/api/v1/order-confirmations/{confirmation_id}/pdf".replaceAll("\\{" + "confirmation_id" + "\\}",escape(confirmationId.toString))

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def getConfirmation(host: String, confirmationId: String): Task[OrderConfirmation] = {
    implicit val returnTypeDecoder: EntityDecoder[OrderConfirmation] = jsonOf[OrderConfirmation]

    val path = "/api/v1/order-confirmations/{confirmation_id}".replaceAll("\\{" + "confirmation_id" + "\\}",escape(confirmationId.toString))

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
      resp          <- client.expect[OrderConfirmation](req)

    } yield resp
  }

  def listConfirmations(host: String, page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[OrderConfirmation]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[OrderConfirmation]] = jsonOf[List[OrderConfirmation]]

    val path = "/api/v1/order-confirmations/"

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
      resp          <- client.expect[List[OrderConfirmation]](req)

    } yield resp
  }

  def orderconfirmationRestore(host: String, confirmationId: String): Task[OrderConfirmation] = {
    implicit val returnTypeDecoder: EntityDecoder[OrderConfirmation] = jsonOf[OrderConfirmation]

    val path = "/api/v1/order-confirmations/{confirmation_id}/restore".replaceAll("\\{" + "confirmation_id" + "\\}",escape(confirmationId.toString))

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
      resp          <- client.expect[OrderConfirmation](req)

    } yield resp
  }

  def pursueConfirmation(host: String, confirmationId: String): Task[DeliveryNote] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryNote] = jsonOf[DeliveryNote]

    val path = "/api/v1/order-confirmations/{confirmation_id}/pursue".replaceAll("\\{" + "confirmation_id" + "\\}",escape(confirmationId.toString))

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
      resp          <- client.expect[DeliveryNote](req)

    } yield resp
  }

}

class HttpServiceOrderConfirmationApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createConfirmation(orderConfirmationCreate: OrderConfirmationCreate): Task[OrderConfirmation] = {
    implicit val returnTypeDecoder: EntityDecoder[OrderConfirmation] = jsonOf[OrderConfirmation]

    val path = "/api/v1/order-confirmations"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(orderConfirmationCreate)
      resp          <- client.expect[OrderConfirmation](req)

    } yield resp
  }

  def deleteConfirmation(confirmationId: String): Task[Unit] = {
    val path = "/api/v1/order-confirmations/{confirmation_id}".replaceAll("\\{" + "confirmation_id" + "\\}",escape(confirmationId.toString))

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

  def downloadConfirmationPdf(confirmationId: String): Task[Unit] = {
    val path = "/api/v1/order-confirmations/{confirmation_id}/pdf".replaceAll("\\{" + "confirmation_id" + "\\}",escape(confirmationId.toString))

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def getConfirmation(confirmationId: String): Task[OrderConfirmation] = {
    implicit val returnTypeDecoder: EntityDecoder[OrderConfirmation] = jsonOf[OrderConfirmation]

    val path = "/api/v1/order-confirmations/{confirmation_id}".replaceAll("\\{" + "confirmation_id" + "\\}",escape(confirmationId.toString))

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
      resp          <- client.expect[OrderConfirmation](req)

    } yield resp
  }

  def listConfirmations(page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[OrderConfirmation]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[OrderConfirmation]] = jsonOf[List[OrderConfirmation]]

    val path = "/api/v1/order-confirmations/"

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
      resp          <- client.expect[List[OrderConfirmation]](req)

    } yield resp
  }

  def orderconfirmationRestore(confirmationId: String): Task[OrderConfirmation] = {
    implicit val returnTypeDecoder: EntityDecoder[OrderConfirmation] = jsonOf[OrderConfirmation]

    val path = "/api/v1/order-confirmations/{confirmation_id}/restore".replaceAll("\\{" + "confirmation_id" + "\\}",escape(confirmationId.toString))

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
      resp          <- client.expect[OrderConfirmation](req)

    } yield resp
  }

  def pursueConfirmation(confirmationId: String): Task[DeliveryNote] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryNote] = jsonOf[DeliveryNote]

    val path = "/api/v1/order-confirmations/{confirmation_id}/pursue".replaceAll("\\{" + "confirmation_id" + "\\}",escape(confirmationId.toString))

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
      resp          <- client.expect[DeliveryNote](req)

    } yield resp
  }

}
