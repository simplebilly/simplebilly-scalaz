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

import org.openapitools.client.api.BilanzReport
import org.openapitools.client.api.GuVReport
import org.openapitools.client.api.KontoReport
import org.openapitools.client.api.UmsatzsteuerReport

object ReportsApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def bilanzReportApi(host: String, year: Integer, month: Integer, dateFrom: String, dateTo: String, page: Integer, pageSize: Integer)(implicit yearQuery: QueryParam[Integer], monthQuery: QueryParam[Integer], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[BilanzReport] = {
    implicit val returnTypeDecoder: EntityDecoder[BilanzReport] = jsonOf[BilanzReport]

    val path = "/api/v1/bookkeeping/reports/bilanz"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("month", Some(monthQuery.toParamString(month))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[BilanzReport](req)

    } yield resp
  }

  def guvReportApi(host: String, year: Integer, month: Integer, dateFrom: String, dateTo: String, page: Integer, pageSize: Integer)(implicit yearQuery: QueryParam[Integer], monthQuery: QueryParam[Integer], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[GuVReport] = {
    implicit val returnTypeDecoder: EntityDecoder[GuVReport] = jsonOf[GuVReport]

    val path = "/api/v1/bookkeeping/reports/guv"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("month", Some(monthQuery.toParamString(month))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[GuVReport](req)

    } yield resp
  }

  def kontenansichtReportApi(host: String, year: Integer, month: Integer, dateFrom: String, dateTo: String, page: Integer, pageSize: Integer)(implicit yearQuery: QueryParam[Integer], monthQuery: QueryParam[Integer], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[KontoReport] = {
    implicit val returnTypeDecoder: EntityDecoder[KontoReport] = jsonOf[KontoReport]

    val path = "/api/v1/bookkeeping/reports/kontenansicht"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("month", Some(monthQuery.toParamString(month))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[KontoReport](req)

    } yield resp
  }

  def umsatzsteuerReportApi(host: String, year: Integer, month: Integer, dateFrom: String, dateTo: String, page: Integer, pageSize: Integer)(implicit yearQuery: QueryParam[Integer], monthQuery: QueryParam[Integer], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[UmsatzsteuerReport] = {
    implicit val returnTypeDecoder: EntityDecoder[UmsatzsteuerReport] = jsonOf[UmsatzsteuerReport]

    val path = "/api/v1/bookkeeping/reports/umsatzsteuer"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("month", Some(monthQuery.toParamString(month))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[UmsatzsteuerReport](req)

    } yield resp
  }

}

class HttpServiceReportsApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def bilanzReportApi(year: Integer, month: Integer, dateFrom: String, dateTo: String, page: Integer, pageSize: Integer)(implicit yearQuery: QueryParam[Integer], monthQuery: QueryParam[Integer], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[BilanzReport] = {
    implicit val returnTypeDecoder: EntityDecoder[BilanzReport] = jsonOf[BilanzReport]

    val path = "/api/v1/bookkeeping/reports/bilanz"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("month", Some(monthQuery.toParamString(month))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[BilanzReport](req)

    } yield resp
  }

  def guvReportApi(year: Integer, month: Integer, dateFrom: String, dateTo: String, page: Integer, pageSize: Integer)(implicit yearQuery: QueryParam[Integer], monthQuery: QueryParam[Integer], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[GuVReport] = {
    implicit val returnTypeDecoder: EntityDecoder[GuVReport] = jsonOf[GuVReport]

    val path = "/api/v1/bookkeeping/reports/guv"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("month", Some(monthQuery.toParamString(month))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[GuVReport](req)

    } yield resp
  }

  def kontenansichtReportApi(year: Integer, month: Integer, dateFrom: String, dateTo: String, page: Integer, pageSize: Integer)(implicit yearQuery: QueryParam[Integer], monthQuery: QueryParam[Integer], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[KontoReport] = {
    implicit val returnTypeDecoder: EntityDecoder[KontoReport] = jsonOf[KontoReport]

    val path = "/api/v1/bookkeeping/reports/kontenansicht"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("month", Some(monthQuery.toParamString(month))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[KontoReport](req)

    } yield resp
  }

  def umsatzsteuerReportApi(year: Integer, month: Integer, dateFrom: String, dateTo: String, page: Integer, pageSize: Integer)(implicit yearQuery: QueryParam[Integer], monthQuery: QueryParam[Integer], dateFromQuery: QueryParam[String], dateToQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[UmsatzsteuerReport] = {
    implicit val returnTypeDecoder: EntityDecoder[UmsatzsteuerReport] = jsonOf[UmsatzsteuerReport]

    val path = "/api/v1/bookkeeping/reports/umsatzsteuer"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("month", Some(monthQuery.toParamString(month))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[UmsatzsteuerReport](req)

    } yield resp
  }

}
