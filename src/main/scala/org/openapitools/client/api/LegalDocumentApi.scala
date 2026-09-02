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

import org.openapitools.client.api.LegalDocument
import org.openapitools.client.api.LegalDocumentReset
import org.openapitools.client.api.LegalDocumentUpsert
import org.openapitools.client.api.PluginError

object LegalDocumentApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getLegalDocuments(host: String): Task[List[LegalDocument]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[LegalDocument]] = jsonOf[List[LegalDocument]]

    val path = "/api/v1/legal/documents"

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
      resp          <- client.expect[List[LegalDocument]](req)

    } yield resp
  }

  def resetLegalDocuments(host: String, legalDocumentReset: LegalDocumentReset): Task[List[LegalDocument]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[LegalDocument]] = jsonOf[List[LegalDocument]]

    val path = "/api/v1/legal/documents/reset"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(legalDocumentReset)
      resp          <- client.expect[List[LegalDocument]](req)

    } yield resp
  }

  def upsertLegalDocuments(host: String, legalDocumentUpsert: List[LegalDocumentUpsert]): Task[List[LegalDocument]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[LegalDocument]] = jsonOf[List[LegalDocument]]

    val path = "/api/v1/legal/documents"

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(legalDocumentUpsert)
      resp          <- client.expect[List[LegalDocument]](req)

    } yield resp
  }

}

class HttpServiceLegalDocumentApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getLegalDocuments(): Task[List[LegalDocument]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[LegalDocument]] = jsonOf[List[LegalDocument]]

    val path = "/api/v1/legal/documents"

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
      resp          <- client.expect[List[LegalDocument]](req)

    } yield resp
  }

  def resetLegalDocuments(legalDocumentReset: LegalDocumentReset): Task[List[LegalDocument]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[LegalDocument]] = jsonOf[List[LegalDocument]]

    val path = "/api/v1/legal/documents/reset"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(legalDocumentReset)
      resp          <- client.expect[List[LegalDocument]](req)

    } yield resp
  }

  def upsertLegalDocuments(legalDocumentUpsert: List[LegalDocumentUpsert]): Task[List[LegalDocument]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[LegalDocument]] = jsonOf[List[LegalDocument]]

    val path = "/api/v1/legal/documents"

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(legalDocumentUpsert)
      resp          <- client.expect[List[LegalDocument]](req)

    } yield resp
  }

}
