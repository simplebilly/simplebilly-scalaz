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
import org.openapitools.client.api.Shareholder
import org.openapitools.client.api.ShareholderCreate
import org.openapitools.client.api.ShareholderUpdate
import java.util.UUID

object ShareholderApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createShareholder(host: String, shareholderCreate: ShareholderCreate): Task[Shareholder] = {
    implicit val returnTypeDecoder: EntityDecoder[Shareholder] = jsonOf[Shareholder]

    val path = "/api/v1/shareholders"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shareholderCreate)
      resp          <- client.expect[Shareholder](req)

    } yield resp
  }

  def deleteShareholder(host: String, id: UUID): Task[Unit] = {
    val path = "/api/v1/shareholders/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def getShareholder(host: String, id: UUID): Task[Shareholder] = {
    implicit val returnTypeDecoder: EntityDecoder[Shareholder] = jsonOf[Shareholder]

    val path = "/api/v1/shareholders/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[Shareholder](req)

    } yield resp
  }

  def getShareholders(host: String, page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[Shareholder]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Shareholder]] = jsonOf[List[Shareholder]]

    val path = "/api/v1/shareholders/"

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
      resp          <- client.expect[List[Shareholder]](req)

    } yield resp
  }

  def updateShareholder(host: String, id: UUID, shareholderUpdate: ShareholderUpdate): Task[Shareholder] = {
    implicit val returnTypeDecoder: EntityDecoder[Shareholder] = jsonOf[Shareholder]

    val path = "/api/v1/shareholders/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shareholderUpdate)
      resp          <- client.expect[Shareholder](req)

    } yield resp
  }

}

class HttpServiceShareholderApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createShareholder(shareholderCreate: ShareholderCreate): Task[Shareholder] = {
    implicit val returnTypeDecoder: EntityDecoder[Shareholder] = jsonOf[Shareholder]

    val path = "/api/v1/shareholders"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shareholderCreate)
      resp          <- client.expect[Shareholder](req)

    } yield resp
  }

  def deleteShareholder(id: UUID): Task[Unit] = {
    val path = "/api/v1/shareholders/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def getShareholder(id: UUID): Task[Shareholder] = {
    implicit val returnTypeDecoder: EntityDecoder[Shareholder] = jsonOf[Shareholder]

    val path = "/api/v1/shareholders/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[Shareholder](req)

    } yield resp
  }

  def getShareholders(page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[Shareholder]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Shareholder]] = jsonOf[List[Shareholder]]

    val path = "/api/v1/shareholders/"

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
      resp          <- client.expect[List[Shareholder]](req)

    } yield resp
  }

  def updateShareholder(id: UUID, shareholderUpdate: ShareholderUpdate): Task[Shareholder] = {
    implicit val returnTypeDecoder: EntityDecoder[Shareholder] = jsonOf[Shareholder]

    val path = "/api/v1/shareholders/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shareholderUpdate)
      resp          <- client.expect[Shareholder](req)

    } yield resp
  }

}
