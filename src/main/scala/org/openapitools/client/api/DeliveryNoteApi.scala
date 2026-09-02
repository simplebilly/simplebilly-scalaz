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
import org.openapitools.client.api.DeliveryNoteCreate
import org.openapitools.client.api.Invoice
import org.openapitools.client.api.PluginError

object DeliveryNoteApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createDeliveryNote(host: String, deliveryNoteCreate: DeliveryNoteCreate): Task[DeliveryNote] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryNote] = jsonOf[DeliveryNote]

    val path = "/api/v1/delivery-notes"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(deliveryNoteCreate)
      resp          <- client.expect[DeliveryNote](req)

    } yield resp
  }

  def deleteDeliveryNote(host: String, deliveryNoteId: String): Task[Unit] = {
    val path = "/api/v1/delivery-notes/{delivery_note_id}".replaceAll("\\{" + "delivery_note_id" + "\\}",escape(deliveryNoteId.toString))

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

  def deliverynoteRestore(host: String, deliveryNoteId: String): Task[DeliveryNote] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryNote] = jsonOf[DeliveryNote]

    val path = "/api/v1/delivery-notes/{delivery_note_id}/restore".replaceAll("\\{" + "delivery_note_id" + "\\}",escape(deliveryNoteId.toString))

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

  def downloadDeliveryNotePdf(host: String, deliveryNoteId: String): Task[Unit] = {
    val path = "/api/v1/delivery-notes/{delivery_note_id}/pdf".replaceAll("\\{" + "delivery_note_id" + "\\}",escape(deliveryNoteId.toString))

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

  def getDeliveryNote(host: String, deliveryNoteId: String): Task[DeliveryNote] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryNote] = jsonOf[DeliveryNote]

    val path = "/api/v1/delivery-notes/{delivery_note_id}".replaceAll("\\{" + "delivery_note_id" + "\\}",escape(deliveryNoteId.toString))

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
      resp          <- client.expect[DeliveryNote](req)

    } yield resp
  }

  def listDeliveryNotes(host: String, page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[DeliveryNote]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[DeliveryNote]] = jsonOf[List[DeliveryNote]]

    val path = "/api/v1/delivery-notes/"

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
      resp          <- client.expect[List[DeliveryNote]](req)

    } yield resp
  }

  def pursueDeliveryNote(host: String, deliveryNoteId: String): Task[Invoice] = {
    implicit val returnTypeDecoder: EntityDecoder[Invoice] = jsonOf[Invoice]

    val path = "/api/v1/delivery-notes/{delivery_note_id}/pursue".replaceAll("\\{" + "delivery_note_id" + "\\}",escape(deliveryNoteId.toString))

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
      resp          <- client.expect[Invoice](req)

    } yield resp
  }

}

class HttpServiceDeliveryNoteApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createDeliveryNote(deliveryNoteCreate: DeliveryNoteCreate): Task[DeliveryNote] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryNote] = jsonOf[DeliveryNote]

    val path = "/api/v1/delivery-notes"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(deliveryNoteCreate)
      resp          <- client.expect[DeliveryNote](req)

    } yield resp
  }

  def deleteDeliveryNote(deliveryNoteId: String): Task[Unit] = {
    val path = "/api/v1/delivery-notes/{delivery_note_id}".replaceAll("\\{" + "delivery_note_id" + "\\}",escape(deliveryNoteId.toString))

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

  def deliverynoteRestore(deliveryNoteId: String): Task[DeliveryNote] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryNote] = jsonOf[DeliveryNote]

    val path = "/api/v1/delivery-notes/{delivery_note_id}/restore".replaceAll("\\{" + "delivery_note_id" + "\\}",escape(deliveryNoteId.toString))

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

  def downloadDeliveryNotePdf(deliveryNoteId: String): Task[Unit] = {
    val path = "/api/v1/delivery-notes/{delivery_note_id}/pdf".replaceAll("\\{" + "delivery_note_id" + "\\}",escape(deliveryNoteId.toString))

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

  def getDeliveryNote(deliveryNoteId: String): Task[DeliveryNote] = {
    implicit val returnTypeDecoder: EntityDecoder[DeliveryNote] = jsonOf[DeliveryNote]

    val path = "/api/v1/delivery-notes/{delivery_note_id}".replaceAll("\\{" + "delivery_note_id" + "\\}",escape(deliveryNoteId.toString))

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
      resp          <- client.expect[DeliveryNote](req)

    } yield resp
  }

  def listDeliveryNotes(page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[DeliveryNote]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[DeliveryNote]] = jsonOf[List[DeliveryNote]]

    val path = "/api/v1/delivery-notes/"

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
      resp          <- client.expect[List[DeliveryNote]](req)

    } yield resp
  }

  def pursueDeliveryNote(deliveryNoteId: String): Task[Invoice] = {
    implicit val returnTypeDecoder: EntityDecoder[Invoice] = jsonOf[Invoice]

    val path = "/api/v1/delivery-notes/{delivery_note_id}/pursue".replaceAll("\\{" + "delivery_note_id" + "\\}",escape(deliveryNoteId.toString))

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
      resp          <- client.expect[Invoice](req)

    } yield resp
  }

}
