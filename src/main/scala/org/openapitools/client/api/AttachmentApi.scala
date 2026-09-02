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

import org.openapitools.client.api.Attachment
import org.openapitools.client.api.AttachmentCreate
import org.openapitools.client.api.OcrTextRequest
import org.openapitools.client.api.PluginError
import java.util.UUID

object AttachmentApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def attachmentRestore(host: String, id: UUID): Task[Attachment] = {
    implicit val returnTypeDecoder: EntityDecoder[Attachment] = jsonOf[Attachment]

    val path = "/api/v1/attachments/{id}/restore".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[Attachment](req)

    } yield resp
  }

  def createAttachment(host: String, attachmentCreate: AttachmentCreate): Task[Attachment] = {
    implicit val returnTypeDecoder: EntityDecoder[Attachment] = jsonOf[Attachment]

    val path = "/api/v1/attachments"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(attachmentCreate)
      resp          <- client.expect[Attachment](req)

    } yield resp
  }

  def deleteAttachment(host: String, id: UUID): Task[Unit] = {
    val path = "/api/v1/attachments/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def getAttachment(host: String, id: UUID): Task[Attachment] = {
    implicit val returnTypeDecoder: EntityDecoder[Attachment] = jsonOf[Attachment]

    val path = "/api/v1/attachments/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[Attachment](req)

    } yield resp
  }

  def listAttachments(host: String, page: Integer, pageSize: Integer, contactId: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], contactIdQuery: QueryParam[String]): Task[List[Attachment]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Attachment]] = jsonOf[List[Attachment]]

    val path = "/api/v1/attachments/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("contactId", Some(contactIdQuery.toParamString(contactId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Attachment]](req)

    } yield resp
  }

  def saveAttachmentOcrText(host: String, attachmentId: UUID, ocrTextRequest: OcrTextRequest): Task[Attachment] = {
    implicit val returnTypeDecoder: EntityDecoder[Attachment] = jsonOf[Attachment]

    val path = "/api/v1/attachments/{attachment_id}/ocr-text".replaceAll("\\{" + "attachment_id" + "\\}",escape(attachmentId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(ocrTextRequest)
      resp          <- client.expect[Attachment](req)

    } yield resp
  }

}

class HttpServiceAttachmentApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def attachmentRestore(id: UUID): Task[Attachment] = {
    implicit val returnTypeDecoder: EntityDecoder[Attachment] = jsonOf[Attachment]

    val path = "/api/v1/attachments/{id}/restore".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[Attachment](req)

    } yield resp
  }

  def createAttachment(attachmentCreate: AttachmentCreate): Task[Attachment] = {
    implicit val returnTypeDecoder: EntityDecoder[Attachment] = jsonOf[Attachment]

    val path = "/api/v1/attachments"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(attachmentCreate)
      resp          <- client.expect[Attachment](req)

    } yield resp
  }

  def deleteAttachment(id: UUID): Task[Unit] = {
    val path = "/api/v1/attachments/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def getAttachment(id: UUID): Task[Attachment] = {
    implicit val returnTypeDecoder: EntityDecoder[Attachment] = jsonOf[Attachment]

    val path = "/api/v1/attachments/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[Attachment](req)

    } yield resp
  }

  def listAttachments(page: Integer, pageSize: Integer, contactId: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], contactIdQuery: QueryParam[String]): Task[List[Attachment]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Attachment]] = jsonOf[List[Attachment]]

    val path = "/api/v1/attachments/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("contactId", Some(contactIdQuery.toParamString(contactId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Attachment]](req)

    } yield resp
  }

  def saveAttachmentOcrText(attachmentId: UUID, ocrTextRequest: OcrTextRequest): Task[Attachment] = {
    implicit val returnTypeDecoder: EntityDecoder[Attachment] = jsonOf[Attachment]

    val path = "/api/v1/attachments/{attachment_id}/ocr-text".replaceAll("\\{" + "attachment_id" + "\\}",escape(attachmentId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(ocrTextRequest)
      resp          <- client.expect[Attachment](req)

    } yield resp
  }

}
