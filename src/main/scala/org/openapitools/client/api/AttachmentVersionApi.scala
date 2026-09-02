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
import org.openapitools.client.api.AttachmentVersion
import org.openapitools.client.api.NewVersionRequest
import org.openapitools.client.api.PluginError
import java.util.UUID

object AttachmentVersionApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createAttachmentVersion(host: String, attachmentId: UUID, newVersionRequest: NewVersionRequest): Task[AttachmentVersion] = {
    implicit val returnTypeDecoder: EntityDecoder[AttachmentVersion] = jsonOf[AttachmentVersion]

    val path = "/api/v1/attachments/{attachment_id}/versions".replaceAll("\\{" + "attachment_id" + "\\}",escape(attachmentId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(newVersionRequest)
      resp          <- client.expect[AttachmentVersion](req)

    } yield resp
  }

  def listAttachmentVersions(host: String, attachmentId: UUID): Task[List[AttachmentVersion]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[AttachmentVersion]] = jsonOf[List[AttachmentVersion]]

    val path = "/api/v1/attachments/{attachment_id}/versions".replaceAll("\\{" + "attachment_id" + "\\}",escape(attachmentId.toString))

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
      resp          <- client.expect[List[AttachmentVersion]](req)

    } yield resp
  }

  def restoreAttachmentVersion(host: String, attachmentId: UUID, versionId: UUID): Task[Attachment] = {
    implicit val returnTypeDecoder: EntityDecoder[Attachment] = jsonOf[Attachment]

    val path = "/api/v1/attachments/{attachment_id}/versions/{version_id}/restore".replaceAll("\\{" + "attachment_id" + "\\}",escape(attachmentId.toString)).replaceAll("\\{" + "version_id" + "\\}",escape(versionId.toString))

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

}

class HttpServiceAttachmentVersionApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createAttachmentVersion(attachmentId: UUID, newVersionRequest: NewVersionRequest): Task[AttachmentVersion] = {
    implicit val returnTypeDecoder: EntityDecoder[AttachmentVersion] = jsonOf[AttachmentVersion]

    val path = "/api/v1/attachments/{attachment_id}/versions".replaceAll("\\{" + "attachment_id" + "\\}",escape(attachmentId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(newVersionRequest)
      resp          <- client.expect[AttachmentVersion](req)

    } yield resp
  }

  def listAttachmentVersions(attachmentId: UUID): Task[List[AttachmentVersion]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[AttachmentVersion]] = jsonOf[List[AttachmentVersion]]

    val path = "/api/v1/attachments/{attachment_id}/versions".replaceAll("\\{" + "attachment_id" + "\\}",escape(attachmentId.toString))

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
      resp          <- client.expect[List[AttachmentVersion]](req)

    } yield resp
  }

  def restoreAttachmentVersion(attachmentId: UUID, versionId: UUID): Task[Attachment] = {
    implicit val returnTypeDecoder: EntityDecoder[Attachment] = jsonOf[Attachment]

    val path = "/api/v1/attachments/{attachment_id}/versions/{version_id}/restore".replaceAll("\\{" + "attachment_id" + "\\}",escape(attachmentId.toString)).replaceAll("\\{" + "version_id" + "\\}",escape(versionId.toString))

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

}
