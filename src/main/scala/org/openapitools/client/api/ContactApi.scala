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
import org.openapitools.client.api.Contact
import org.openapitools.client.api.ContactTimelineResponse
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.SalesVolumeReport

object ContactApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def contactSchema(host: String): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/contacts/schema"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def contactTimeline(host: String, contactId: String): Task[ContactTimelineResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ContactTimelineResponse] = jsonOf[ContactTimelineResponse]

    val path = "/api/v1/contacts/{contact_id}/timeline".replaceAll("\\{" + "contact_id" + "\\}",escape(contactId.toString))

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
      resp          <- client.expect[ContactTimelineResponse](req)

    } yield resp
  }

  def createContact(host: String, body: AnyType): Task[Contact] = {
    implicit val returnTypeDecoder: EntityDecoder[Contact] = jsonOf[Contact]

    val path = "/api/v1/contacts"

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
      resp          <- client.expect[Contact](req)

    } yield resp
  }

  def deleteContact(host: String, contactId: String): Task[Unit] = {
    val path = "/api/v1/contacts/{contact_id}".replaceAll("\\{" + "contact_id" + "\\}",escape(contactId.toString))

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

  def getContact(host: String, contactId: String): Task[Contact] = {
    implicit val returnTypeDecoder: EntityDecoder[Contact] = jsonOf[Contact]

    val path = "/api/v1/contacts/{contact_id}".replaceAll("\\{" + "contact_id" + "\\}",escape(contactId.toString))

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
      resp          <- client.expect[Contact](req)

    } yield resp
  }

  def listContacts(host: String, page: Integer, pageSize: Integer, search: String, contactType: String, tag: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], contactTypeQuery: QueryParam[String], tagQuery: QueryParam[String]): Task[List[Contact]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Contact]] = jsonOf[List[Contact]]

    val path = "/api/v1/contacts"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("search", Some(searchQuery.toParamString(search))), ("contactType", Some(contact_typeQuery.toParamString(contact_type))), ("tag", Some(tagQuery.toParamString(tag))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Contact]](req)

    } yield resp
  }

  def salesVolume(host: String, page: Integer, pageSize: Integer, search: String, contactType: String, tag: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], contactTypeQuery: QueryParam[String], tagQuery: QueryParam[String]): Task[SalesVolumeReport] = {
    implicit val returnTypeDecoder: EntityDecoder[SalesVolumeReport] = jsonOf[SalesVolumeReport]

    val path = "/api/v1/contacts/sales-volume"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("search", Some(searchQuery.toParamString(search))), ("contactType", Some(contact_typeQuery.toParamString(contact_type))), ("tag", Some(tagQuery.toParamString(tag))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[SalesVolumeReport](req)

    } yield resp
  }

  def updateContact(host: String, contactId: String, body: AnyType): Task[Contact] = {
    implicit val returnTypeDecoder: EntityDecoder[Contact] = jsonOf[Contact]

    val path = "/api/v1/contacts/{contact_id}".replaceAll("\\{" + "contact_id" + "\\}",escape(contactId.toString))

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
      resp          <- client.expect[Contact](req)

    } yield resp
  }

}

class HttpServiceContactApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def contactSchema(): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/contacts/schema"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def contactTimeline(contactId: String): Task[ContactTimelineResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ContactTimelineResponse] = jsonOf[ContactTimelineResponse]

    val path = "/api/v1/contacts/{contact_id}/timeline".replaceAll("\\{" + "contact_id" + "\\}",escape(contactId.toString))

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
      resp          <- client.expect[ContactTimelineResponse](req)

    } yield resp
  }

  def createContact(body: AnyType): Task[Contact] = {
    implicit val returnTypeDecoder: EntityDecoder[Contact] = jsonOf[Contact]

    val path = "/api/v1/contacts"

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
      resp          <- client.expect[Contact](req)

    } yield resp
  }

  def deleteContact(contactId: String): Task[Unit] = {
    val path = "/api/v1/contacts/{contact_id}".replaceAll("\\{" + "contact_id" + "\\}",escape(contactId.toString))

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

  def getContact(contactId: String): Task[Contact] = {
    implicit val returnTypeDecoder: EntityDecoder[Contact] = jsonOf[Contact]

    val path = "/api/v1/contacts/{contact_id}".replaceAll("\\{" + "contact_id" + "\\}",escape(contactId.toString))

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
      resp          <- client.expect[Contact](req)

    } yield resp
  }

  def listContacts(page: Integer, pageSize: Integer, search: String, contactType: String, tag: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], contactTypeQuery: QueryParam[String], tagQuery: QueryParam[String]): Task[List[Contact]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Contact]] = jsonOf[List[Contact]]

    val path = "/api/v1/contacts"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("search", Some(searchQuery.toParamString(search))), ("contactType", Some(contact_typeQuery.toParamString(contact_type))), ("tag", Some(tagQuery.toParamString(tag))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Contact]](req)

    } yield resp
  }

  def salesVolume(page: Integer, pageSize: Integer, search: String, contactType: String, tag: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], contactTypeQuery: QueryParam[String], tagQuery: QueryParam[String]): Task[SalesVolumeReport] = {
    implicit val returnTypeDecoder: EntityDecoder[SalesVolumeReport] = jsonOf[SalesVolumeReport]

    val path = "/api/v1/contacts/sales-volume"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("search", Some(searchQuery.toParamString(search))), ("contactType", Some(contact_typeQuery.toParamString(contact_type))), ("tag", Some(tagQuery.toParamString(tag))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[SalesVolumeReport](req)

    } yield resp
  }

  def updateContact(contactId: String, body: AnyType): Task[Contact] = {
    implicit val returnTypeDecoder: EntityDecoder[Contact] = jsonOf[Contact]

    val path = "/api/v1/contacts/{contact_id}".replaceAll("\\{" + "contact_id" + "\\}",escape(contactId.toString))

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
      resp          <- client.expect[Contact](req)

    } yield resp
  }

}
