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

import org.openapitools.client.api.Bom
import org.openapitools.client.api.BomCreate
import org.openapitools.client.api.BomUpdate
import org.openapitools.client.api.PluginError
import java.util.UUID

object BomApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createBom(host: String, bomCreate: BomCreate): Task[Bom] = {
    implicit val returnTypeDecoder: EntityDecoder[Bom] = jsonOf[Bom]

    val path = "/api/v1/boms"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(bomCreate)
      resp          <- client.expect[Bom](req)

    } yield resp
  }

  def deleteBom(host: String, bomId: UUID): Task[Unit] = {
    val path = "/api/v1/boms/{bom_id}".replaceAll("\\{" + "bom_id" + "\\}",escape(bomId.toString))

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

  def getBom(host: String, bomId: UUID): Task[Bom] = {
    implicit val returnTypeDecoder: EntityDecoder[Bom] = jsonOf[Bom]

    val path = "/api/v1/boms/{bom_id}".replaceAll("\\{" + "bom_id" + "\\}",escape(bomId.toString))

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
      resp          <- client.expect[Bom](req)

    } yield resp
  }

  def listBoms(host: String, page: Integer, pageSize: Integer, search: String, productId: UUID)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], productIdQuery: QueryParam[UUID]): Task[List[Bom]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Bom]] = jsonOf[List[Bom]]

    val path = "/api/v1/boms/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("search", Some(searchQuery.toParamString(search))), ("productId", Some(productIdQuery.toParamString(productId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Bom]](req)

    } yield resp
  }

  def updateBom(host: String, bomId: UUID, bomUpdate: BomUpdate): Task[Bom] = {
    implicit val returnTypeDecoder: EntityDecoder[Bom] = jsonOf[Bom]

    val path = "/api/v1/boms/{bom_id}".replaceAll("\\{" + "bom_id" + "\\}",escape(bomId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(bomUpdate)
      resp          <- client.expect[Bom](req)

    } yield resp
  }

}

class HttpServiceBomApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createBom(bomCreate: BomCreate): Task[Bom] = {
    implicit val returnTypeDecoder: EntityDecoder[Bom] = jsonOf[Bom]

    val path = "/api/v1/boms"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(bomCreate)
      resp          <- client.expect[Bom](req)

    } yield resp
  }

  def deleteBom(bomId: UUID): Task[Unit] = {
    val path = "/api/v1/boms/{bom_id}".replaceAll("\\{" + "bom_id" + "\\}",escape(bomId.toString))

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

  def getBom(bomId: UUID): Task[Bom] = {
    implicit val returnTypeDecoder: EntityDecoder[Bom] = jsonOf[Bom]

    val path = "/api/v1/boms/{bom_id}".replaceAll("\\{" + "bom_id" + "\\}",escape(bomId.toString))

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
      resp          <- client.expect[Bom](req)

    } yield resp
  }

  def listBoms(page: Integer, pageSize: Integer, search: String, productId: UUID)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], productIdQuery: QueryParam[UUID]): Task[List[Bom]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Bom]] = jsonOf[List[Bom]]

    val path = "/api/v1/boms/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("search", Some(searchQuery.toParamString(search))), ("productId", Some(productIdQuery.toParamString(productId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Bom]](req)

    } yield resp
  }

  def updateBom(bomId: UUID, bomUpdate: BomUpdate): Task[Bom] = {
    implicit val returnTypeDecoder: EntityDecoder[Bom] = jsonOf[Bom]

    val path = "/api/v1/boms/{bom_id}".replaceAll("\\{" + "bom_id" + "\\}",escape(bomId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(bomUpdate)
      resp          <- client.expect[Bom](req)

    } yield resp
  }

}
