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

import org.openapitools.client.api.CreateEmissionEntry
import org.openapitools.client.api.CreateEmissionTarget
import org.openapitools.client.api.EmissionEntry
import org.openapitools.client.api.EmissionFactorResponse
import org.openapitools.client.api.EmissionTarget
import org.openapitools.client.api.EmissionsExportResponse
import org.openapitools.client.api.EmissionsReport
import org.openapitools.client.api.PluginError
import java.util.UUID

object EmissionsApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createEmissionEntryApi(host: String, createEmissionEntry: CreateEmissionEntry): Task[EmissionEntry] = {
    implicit val returnTypeDecoder: EntityDecoder[EmissionEntry] = jsonOf[EmissionEntry]

    val path = "/api/v1/bookkeeping/emissions/entries"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(createEmissionEntry)
      resp          <- client.expect[EmissionEntry](req)

    } yield resp
  }

  def createEmissionTargetApi(host: String, createEmissionTarget: CreateEmissionTarget): Task[EmissionTarget] = {
    implicit val returnTypeDecoder: EntityDecoder[EmissionTarget] = jsonOf[EmissionTarget]

    val path = "/api/v1/bookkeeping/emissions/targets"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(createEmissionTarget)
      resp          <- client.expect[EmissionTarget](req)

    } yield resp
  }

  def deleteEmissionEntryApi(host: String, id: UUID): Task[Unit] = {
    val path = "/api/v1/bookkeeping/emissions/entries/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def deleteEmissionTargetApi(host: String, id: UUID): Task[Unit] = {
    val path = "/api/v1/bookkeeping/emissions/targets/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def emissionsEntriesApi(host: String, year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[List[EmissionEntry]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[EmissionEntry]] = jsonOf[List[EmissionEntry]]

    val path = "/api/v1/bookkeeping/emissions/entries"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[EmissionEntry]](req)

    } yield resp
  }

  def emissionsExportApi(host: String, year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[EmissionsExportResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[EmissionsExportResponse] = jsonOf[EmissionsExportResponse]

    val path = "/api/v1/bookkeeping/emissions/export"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[EmissionsExportResponse](req)

    } yield resp
  }

  def emissionsFactorsApi(host: String): Task[List[EmissionFactorResponse]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[EmissionFactorResponse]] = jsonOf[List[EmissionFactorResponse]]

    val path = "/api/v1/bookkeeping/emissions/factors"

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
      resp          <- client.expect[List[EmissionFactorResponse]](req)

    } yield resp
  }

  def emissionsReportApi(host: String, year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[EmissionsReport] = {
    implicit val returnTypeDecoder: EntityDecoder[EmissionsReport] = jsonOf[EmissionsReport]

    val path = "/api/v1/bookkeeping/emissions/report"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[EmissionsReport](req)

    } yield resp
  }

  def emissionsTargetsApi(host: String): Task[List[EmissionTarget]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[EmissionTarget]] = jsonOf[List[EmissionTarget]]

    val path = "/api/v1/bookkeeping/emissions/targets"

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
      resp          <- client.expect[List[EmissionTarget]](req)

    } yield resp
  }

}

class HttpServiceEmissionsApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createEmissionEntryApi(createEmissionEntry: CreateEmissionEntry): Task[EmissionEntry] = {
    implicit val returnTypeDecoder: EntityDecoder[EmissionEntry] = jsonOf[EmissionEntry]

    val path = "/api/v1/bookkeeping/emissions/entries"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(createEmissionEntry)
      resp          <- client.expect[EmissionEntry](req)

    } yield resp
  }

  def createEmissionTargetApi(createEmissionTarget: CreateEmissionTarget): Task[EmissionTarget] = {
    implicit val returnTypeDecoder: EntityDecoder[EmissionTarget] = jsonOf[EmissionTarget]

    val path = "/api/v1/bookkeeping/emissions/targets"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(createEmissionTarget)
      resp          <- client.expect[EmissionTarget](req)

    } yield resp
  }

  def deleteEmissionEntryApi(id: UUID): Task[Unit] = {
    val path = "/api/v1/bookkeeping/emissions/entries/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def deleteEmissionTargetApi(id: UUID): Task[Unit] = {
    val path = "/api/v1/bookkeeping/emissions/targets/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def emissionsEntriesApi(year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[List[EmissionEntry]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[EmissionEntry]] = jsonOf[List[EmissionEntry]]

    val path = "/api/v1/bookkeeping/emissions/entries"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[EmissionEntry]](req)

    } yield resp
  }

  def emissionsExportApi(year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[EmissionsExportResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[EmissionsExportResponse] = jsonOf[EmissionsExportResponse]

    val path = "/api/v1/bookkeeping/emissions/export"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[EmissionsExportResponse](req)

    } yield resp
  }

  def emissionsFactorsApi(): Task[List[EmissionFactorResponse]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[EmissionFactorResponse]] = jsonOf[List[EmissionFactorResponse]]

    val path = "/api/v1/bookkeeping/emissions/factors"

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
      resp          <- client.expect[List[EmissionFactorResponse]](req)

    } yield resp
  }

  def emissionsReportApi(year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[EmissionsReport] = {
    implicit val returnTypeDecoder: EntityDecoder[EmissionsReport] = jsonOf[EmissionsReport]

    val path = "/api/v1/bookkeeping/emissions/report"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[EmissionsReport](req)

    } yield resp
  }

  def emissionsTargetsApi(): Task[List[EmissionTarget]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[EmissionTarget]] = jsonOf[List[EmissionTarget]]

    val path = "/api/v1/bookkeeping/emissions/targets"

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
      resp          <- client.expect[List[EmissionTarget]](req)

    } yield resp
  }

}
