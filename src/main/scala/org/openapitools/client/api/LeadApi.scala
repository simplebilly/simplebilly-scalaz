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

import org.openapitools.client.api.Lead
import org.openapitools.client.api.LeadUpdate
import java.util.UUID

object LeadApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def listLeadsApi(host: String, status: String, source: String, search: String, page: Integer, pageSize: Integer)(implicit statusQuery: QueryParam[String], sourceQuery: QueryParam[String], searchQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[List[Lead]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Lead]] = jsonOf[List[Lead]]

    val path = "/api/v1/support/leads"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("status", Some(statusQuery.toParamString(status))), ("source", Some(sourceQuery.toParamString(source))), ("search", Some(searchQuery.toParamString(search))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Lead]](req)

    } yield resp
  }

  def updateLeadApi(host: String, leadId: UUID, leadUpdate: LeadUpdate): Task[Lead] = {
    implicit val returnTypeDecoder: EntityDecoder[Lead] = jsonOf[Lead]

    val path = "/api/v1/support/leads/{lead_id}".replaceAll("\\{" + "lead_id" + "\\}",escape(leadId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(leadUpdate)
      resp          <- client.expect[Lead](req)

    } yield resp
  }

}

class HttpServiceLeadApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def listLeadsApi(status: String, source: String, search: String, page: Integer, pageSize: Integer)(implicit statusQuery: QueryParam[String], sourceQuery: QueryParam[String], searchQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[List[Lead]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Lead]] = jsonOf[List[Lead]]

    val path = "/api/v1/support/leads"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("status", Some(statusQuery.toParamString(status))), ("source", Some(sourceQuery.toParamString(source))), ("search", Some(searchQuery.toParamString(search))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Lead]](req)

    } yield resp
  }

  def updateLeadApi(leadId: UUID, leadUpdate: LeadUpdate): Task[Lead] = {
    implicit val returnTypeDecoder: EntityDecoder[Lead] = jsonOf[Lead]

    val path = "/api/v1/support/leads/{lead_id}".replaceAll("\\{" + "lead_id" + "\\}",escape(leadId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(leadUpdate)
      resp          <- client.expect[Lead](req)

    } yield resp
  }

}
