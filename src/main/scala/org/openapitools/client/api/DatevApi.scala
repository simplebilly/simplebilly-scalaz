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

import org.openapitools.client.api.DatevBookingPreview
import org.openapitools.client.api.DatevExportResponse

object DatevApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def datevExportApi(host: String, accountSchema: String, dateFrom: String, dateTo: String, page: Integer, pageSize: Integer)(implicit accountSchemaQuery: QueryParam[String], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[DatevExportResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[DatevExportResponse] = jsonOf[DatevExportResponse]

    val path = "/api/v1/bookkeeping/datev/export"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("accountSchema", Some(account_schemaQuery.toParamString(account_schema))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[DatevExportResponse](req)

    } yield resp
  }

  def datevPreviewApi(host: String, accountSchema: String, dateFrom: String, dateTo: String, page: Integer, pageSize: Integer)(implicit accountSchemaQuery: QueryParam[String], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[List[DatevBookingPreview]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[DatevBookingPreview]] = jsonOf[List[DatevBookingPreview]]

    val path = "/api/v1/bookkeeping/datev/preview"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("accountSchema", Some(account_schemaQuery.toParamString(account_schema))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[DatevBookingPreview]](req)

    } yield resp
  }

}

class HttpServiceDatevApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def datevExportApi(accountSchema: String, dateFrom: String, dateTo: String, page: Integer, pageSize: Integer)(implicit accountSchemaQuery: QueryParam[String], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[DatevExportResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[DatevExportResponse] = jsonOf[DatevExportResponse]

    val path = "/api/v1/bookkeeping/datev/export"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("accountSchema", Some(account_schemaQuery.toParamString(account_schema))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[DatevExportResponse](req)

    } yield resp
  }

  def datevPreviewApi(accountSchema: String, dateFrom: String, dateTo: String, page: Integer, pageSize: Integer)(implicit accountSchemaQuery: QueryParam[String], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[List[DatevBookingPreview]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[DatevBookingPreview]] = jsonOf[List[DatevBookingPreview]]

    val path = "/api/v1/bookkeeping/datev/preview"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("accountSchema", Some(account_schemaQuery.toParamString(account_schema))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[DatevBookingPreview]](req)

    } yield resp
  }

}
