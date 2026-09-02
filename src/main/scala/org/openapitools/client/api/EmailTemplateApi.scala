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
import org.openapitools.client.api.EmailTemplate
import org.openapitools.client.api.EmailTemplateCreate
import org.openapitools.client.api.EmailTemplateUpdate
import org.openapitools.client.api.PluginError

object EmailTemplateApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createEmailTemplate(host: String, emailTemplateCreate: EmailTemplateCreate): Task[EmailTemplate] = {
    implicit val returnTypeDecoder: EntityDecoder[EmailTemplate] = jsonOf[EmailTemplate]

    val path = "/api/v1/email-templates"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(emailTemplateCreate)
      resp          <- client.expect[EmailTemplate](req)

    } yield resp
  }

  def deleteEmailTemplate(host: String, emailTemplateId: String): Task[Unit] = {
    val path = "/api/v1/email-templates/{email_template_id}".replaceAll("\\{" + "email_template_id" + "\\}",escape(emailTemplateId.toString))

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

  def getEmailTemplate(host: String, emailTemplateId: String): Task[EmailTemplate] = {
    implicit val returnTypeDecoder: EntityDecoder[EmailTemplate] = jsonOf[EmailTemplate]

    val path = "/api/v1/email-templates/{email_template_id}".replaceAll("\\{" + "email_template_id" + "\\}",escape(emailTemplateId.toString))

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
      resp          <- client.expect[EmailTemplate](req)

    } yield resp
  }

  def listEmailTemplates(host: String, page: Integer, pageSize: Integer, status: String, search: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], searchQuery: QueryParam[String]): Task[List[EmailTemplate]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[EmailTemplate]] = jsonOf[List[EmailTemplate]]

    val path = "/api/v1/email-templates/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("status", Some(statusQuery.toParamString(status))), ("search", Some(searchQuery.toParamString(search))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[EmailTemplate]](req)

    } yield resp
  }

  def renderEmailTemplate(host: String, emailTemplateId: String, body: AnyType): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/email-templates/{email_template_id}/render".replaceAll("\\{" + "email_template_id" + "\\}",escape(emailTemplateId.toString))

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def updateEmailTemplate(host: String, emailTemplateId: String, emailTemplateUpdate: EmailTemplateUpdate): Task[EmailTemplate] = {
    implicit val returnTypeDecoder: EntityDecoder[EmailTemplate] = jsonOf[EmailTemplate]

    val path = "/api/v1/email-templates/{email_template_id}".replaceAll("\\{" + "email_template_id" + "\\}",escape(emailTemplateId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(emailTemplateUpdate)
      resp          <- client.expect[EmailTemplate](req)

    } yield resp
  }

}

class HttpServiceEmailTemplateApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createEmailTemplate(emailTemplateCreate: EmailTemplateCreate): Task[EmailTemplate] = {
    implicit val returnTypeDecoder: EntityDecoder[EmailTemplate] = jsonOf[EmailTemplate]

    val path = "/api/v1/email-templates"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(emailTemplateCreate)
      resp          <- client.expect[EmailTemplate](req)

    } yield resp
  }

  def deleteEmailTemplate(emailTemplateId: String): Task[Unit] = {
    val path = "/api/v1/email-templates/{email_template_id}".replaceAll("\\{" + "email_template_id" + "\\}",escape(emailTemplateId.toString))

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

  def getEmailTemplate(emailTemplateId: String): Task[EmailTemplate] = {
    implicit val returnTypeDecoder: EntityDecoder[EmailTemplate] = jsonOf[EmailTemplate]

    val path = "/api/v1/email-templates/{email_template_id}".replaceAll("\\{" + "email_template_id" + "\\}",escape(emailTemplateId.toString))

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
      resp          <- client.expect[EmailTemplate](req)

    } yield resp
  }

  def listEmailTemplates(page: Integer, pageSize: Integer, status: String, search: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], searchQuery: QueryParam[String]): Task[List[EmailTemplate]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[EmailTemplate]] = jsonOf[List[EmailTemplate]]

    val path = "/api/v1/email-templates/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("status", Some(statusQuery.toParamString(status))), ("search", Some(searchQuery.toParamString(search))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[EmailTemplate]](req)

    } yield resp
  }

  def renderEmailTemplate(emailTemplateId: String, body: AnyType): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/email-templates/{email_template_id}/render".replaceAll("\\{" + "email_template_id" + "\\}",escape(emailTemplateId.toString))

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def updateEmailTemplate(emailTemplateId: String, emailTemplateUpdate: EmailTemplateUpdate): Task[EmailTemplate] = {
    implicit val returnTypeDecoder: EntityDecoder[EmailTemplate] = jsonOf[EmailTemplate]

    val path = "/api/v1/email-templates/{email_template_id}".replaceAll("\\{" + "email_template_id" + "\\}",escape(emailTemplateId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(emailTemplateUpdate)
      resp          <- client.expect[EmailTemplate](req)

    } yield resp
  }

}
