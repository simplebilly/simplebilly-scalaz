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

import org.openapitools.client.api.PluginError
import org.openapitools.client.api.SilentPartner
import org.openapitools.client.api.SilentPartnerCreate
import org.openapitools.client.api.SilentPartnerUpdate
import java.util.UUID

object SilentPartnerApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createSilentPartner(host: String, silentPartnerCreate: SilentPartnerCreate): Task[SilentPartner] = {
    implicit val returnTypeDecoder: EntityDecoder[SilentPartner] = jsonOf[SilentPartner]

    val path = "/api/v1/silent-partners"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(silentPartnerCreate)
      resp          <- client.expect[SilentPartner](req)

    } yield resp
  }

  def deleteSilentPartner(host: String, id: UUID): Task[Unit] = {
    val path = "/api/v1/silent-partners/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def getSilentPartner(host: String, id: UUID): Task[SilentPartner] = {
    implicit val returnTypeDecoder: EntityDecoder[SilentPartner] = jsonOf[SilentPartner]

    val path = "/api/v1/silent-partners/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[SilentPartner](req)

    } yield resp
  }

  def getSilentPartners(host: String, page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[SilentPartner]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[SilentPartner]] = jsonOf[List[SilentPartner]]

    val path = "/api/v1/silent-partners/"

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
      resp          <- client.expect[List[SilentPartner]](req)

    } yield resp
  }

  def updateSilentPartner(host: String, id: UUID, silentPartnerUpdate: SilentPartnerUpdate): Task[SilentPartner] = {
    implicit val returnTypeDecoder: EntityDecoder[SilentPartner] = jsonOf[SilentPartner]

    val path = "/api/v1/silent-partners/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(silentPartnerUpdate)
      resp          <- client.expect[SilentPartner](req)

    } yield resp
  }

}

class HttpServiceSilentPartnerApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createSilentPartner(silentPartnerCreate: SilentPartnerCreate): Task[SilentPartner] = {
    implicit val returnTypeDecoder: EntityDecoder[SilentPartner] = jsonOf[SilentPartner]

    val path = "/api/v1/silent-partners"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(silentPartnerCreate)
      resp          <- client.expect[SilentPartner](req)

    } yield resp
  }

  def deleteSilentPartner(id: UUID): Task[Unit] = {
    val path = "/api/v1/silent-partners/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def getSilentPartner(id: UUID): Task[SilentPartner] = {
    implicit val returnTypeDecoder: EntityDecoder[SilentPartner] = jsonOf[SilentPartner]

    val path = "/api/v1/silent-partners/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[SilentPartner](req)

    } yield resp
  }

  def getSilentPartners(page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[SilentPartner]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[SilentPartner]] = jsonOf[List[SilentPartner]]

    val path = "/api/v1/silent-partners/"

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
      resp          <- client.expect[List[SilentPartner]](req)

    } yield resp
  }

  def updateSilentPartner(id: UUID, silentPartnerUpdate: SilentPartnerUpdate): Task[SilentPartner] = {
    implicit val returnTypeDecoder: EntityDecoder[SilentPartner] = jsonOf[SilentPartner]

    val path = "/api/v1/silent-partners/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(silentPartnerUpdate)
      resp          <- client.expect[SilentPartner](req)

    } yield resp
  }

}
