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
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.ReorderProposalResponse

object ReorderProposalApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def applyReorderProposal(host: String, configuredOnly: Boolean, warehouseId: String)(implicit configuredOnlyQuery: QueryParam[Boolean], warehouseIdQuery: QueryParam[String]): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/reorder-proposals/apply"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("configuredOnly", Some(configuredOnlyQuery.toParamString(configuredOnly))), ("warehouseId", Some(warehouseIdQuery.toParamString(warehouseId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def getReorderProposal(host: String, configuredOnly: Boolean, warehouseId: String)(implicit configuredOnlyQuery: QueryParam[Boolean], warehouseIdQuery: QueryParam[String]): Task[ReorderProposalResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ReorderProposalResponse] = jsonOf[ReorderProposalResponse]

    val path = "/api/v1/reorder-proposals"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("configuredOnly", Some(configuredOnlyQuery.toParamString(configuredOnly))), ("warehouseId", Some(warehouseIdQuery.toParamString(warehouseId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[ReorderProposalResponse](req)

    } yield resp
  }

}

class HttpServiceReorderProposalApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def applyReorderProposal(configuredOnly: Boolean, warehouseId: String)(implicit configuredOnlyQuery: QueryParam[Boolean], warehouseIdQuery: QueryParam[String]): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/reorder-proposals/apply"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("configuredOnly", Some(configuredOnlyQuery.toParamString(configuredOnly))), ("warehouseId", Some(warehouseIdQuery.toParamString(warehouseId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def getReorderProposal(configuredOnly: Boolean, warehouseId: String)(implicit configuredOnlyQuery: QueryParam[Boolean], warehouseIdQuery: QueryParam[String]): Task[ReorderProposalResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ReorderProposalResponse] = jsonOf[ReorderProposalResponse]

    val path = "/api/v1/reorder-proposals"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("configuredOnly", Some(configuredOnlyQuery.toParamString(configuredOnly))), ("warehouseId", Some(warehouseIdQuery.toParamString(warehouseId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[ReorderProposalResponse](req)

    } yield resp
  }

}
