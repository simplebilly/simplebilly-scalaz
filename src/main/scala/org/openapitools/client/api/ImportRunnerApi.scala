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

import org.openapitools.client.api.ImportJobStatus
import org.openapitools.client.api.ImportStartRequest
import org.openapitools.client.api.ImportStartResponse
import org.openapitools.client.api.ImportTestRequest
import org.openapitools.client.api.ImportTestResponse
import org.openapitools.client.api.PluginError

object ImportRunnerApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getImportStatus(host: String, jobId: String): Task[ImportJobStatus] = {
    implicit val returnTypeDecoder: EntityDecoder[ImportJobStatus] = jsonOf[ImportJobStatus]

    val path = "/api/v1/import/{job_id}".replaceAll("\\{" + "job_id" + "\\}",escape(jobId.toString))

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
      resp          <- client.expect[ImportJobStatus](req)

    } yield resp
  }

  def startImport(host: String, importStartRequest: ImportStartRequest): Task[ImportStartResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ImportStartResponse] = jsonOf[ImportStartResponse]

    val path = "/api/v1/import/start"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(importStartRequest)
      resp          <- client.expect[ImportStartResponse](req)

    } yield resp
  }

  def testImportConnection(host: String, importTestRequest: ImportTestRequest): Task[ImportTestResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ImportTestResponse] = jsonOf[ImportTestResponse]

    val path = "/api/v1/import/test"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(importTestRequest)
      resp          <- client.expect[ImportTestResponse](req)

    } yield resp
  }

}

class HttpServiceImportRunnerApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getImportStatus(jobId: String): Task[ImportJobStatus] = {
    implicit val returnTypeDecoder: EntityDecoder[ImportJobStatus] = jsonOf[ImportJobStatus]

    val path = "/api/v1/import/{job_id}".replaceAll("\\{" + "job_id" + "\\}",escape(jobId.toString))

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
      resp          <- client.expect[ImportJobStatus](req)

    } yield resp
  }

  def startImport(importStartRequest: ImportStartRequest): Task[ImportStartResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ImportStartResponse] = jsonOf[ImportStartResponse]

    val path = "/api/v1/import/start"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(importStartRequest)
      resp          <- client.expect[ImportStartResponse](req)

    } yield resp
  }

  def testImportConnection(importTestRequest: ImportTestRequest): Task[ImportTestResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ImportTestResponse] = jsonOf[ImportTestResponse]

    val path = "/api/v1/import/test"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(importTestRequest)
      resp          <- client.expect[ImportTestResponse](req)

    } yield resp
  }

}
