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

import org.openapitools.client.api.GroupFigure
import org.openapitools.client.api.GroupFigureCreate
import org.openapitools.client.api.GroupFigureUpdate
import org.openapitools.client.api.PluginError

object GroupFigureApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createGroupFigure(host: String, groupFigureCreate: GroupFigureCreate): Task[GroupFigure] = {
    implicit val returnTypeDecoder: EntityDecoder[GroupFigure] = jsonOf[GroupFigure]

    val path = "/api/v1/group-figures"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(groupFigureCreate)
      resp          <- client.expect[GroupFigure](req)

    } yield resp
  }

  def deleteGroupFigure(host: String, year: Integer): Task[Unit] = {
    val path = "/api/v1/group-figures/{year}".replaceAll("\\{" + "year" + "\\}",escape(year.toString))

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

  def getGroupFigure(host: String, year: Integer): Task[GroupFigure] = {
    implicit val returnTypeDecoder: EntityDecoder[GroupFigure] = jsonOf[GroupFigure]

    val path = "/api/v1/group-figures/{year}".replaceAll("\\{" + "year" + "\\}",escape(year.toString))

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
      resp          <- client.expect[GroupFigure](req)

    } yield resp
  }

  def getGroupFigures(host: String, page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[GroupFigure]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[GroupFigure]] = jsonOf[List[GroupFigure]]

    val path = "/api/v1/group-figures/"

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
      resp          <- client.expect[List[GroupFigure]](req)

    } yield resp
  }

  def updateGroupFigure(host: String, year: Integer, groupFigureUpdate: GroupFigureUpdate): Task[GroupFigure] = {
    implicit val returnTypeDecoder: EntityDecoder[GroupFigure] = jsonOf[GroupFigure]

    val path = "/api/v1/group-figures/{year}".replaceAll("\\{" + "year" + "\\}",escape(year.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(groupFigureUpdate)
      resp          <- client.expect[GroupFigure](req)

    } yield resp
  }

}

class HttpServiceGroupFigureApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createGroupFigure(groupFigureCreate: GroupFigureCreate): Task[GroupFigure] = {
    implicit val returnTypeDecoder: EntityDecoder[GroupFigure] = jsonOf[GroupFigure]

    val path = "/api/v1/group-figures"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(groupFigureCreate)
      resp          <- client.expect[GroupFigure](req)

    } yield resp
  }

  def deleteGroupFigure(year: Integer): Task[Unit] = {
    val path = "/api/v1/group-figures/{year}".replaceAll("\\{" + "year" + "\\}",escape(year.toString))

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

  def getGroupFigure(year: Integer): Task[GroupFigure] = {
    implicit val returnTypeDecoder: EntityDecoder[GroupFigure] = jsonOf[GroupFigure]

    val path = "/api/v1/group-figures/{year}".replaceAll("\\{" + "year" + "\\}",escape(year.toString))

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
      resp          <- client.expect[GroupFigure](req)

    } yield resp
  }

  def getGroupFigures(page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[GroupFigure]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[GroupFigure]] = jsonOf[List[GroupFigure]]

    val path = "/api/v1/group-figures/"

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
      resp          <- client.expect[List[GroupFigure]](req)

    } yield resp
  }

  def updateGroupFigure(year: Integer, groupFigureUpdate: GroupFigureUpdate): Task[GroupFigure] = {
    implicit val returnTypeDecoder: EntityDecoder[GroupFigure] = jsonOf[GroupFigure]

    val path = "/api/v1/group-figures/{year}".replaceAll("\\{" + "year" + "\\}",escape(year.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(groupFigureUpdate)
      resp          <- client.expect[GroupFigure](req)

    } yield resp
  }

}
