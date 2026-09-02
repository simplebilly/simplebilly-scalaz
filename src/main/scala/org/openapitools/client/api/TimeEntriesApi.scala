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

import org.openapitools.client.api.LaborCostRow
import java.time.LocalDate
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.TimeEntryClockIn
import org.openapitools.client.api.TimeEntryClockOut
import org.openapitools.client.api.TimeEntryDto
import java.util.UUID

object TimeEntriesApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def clockInTimeEntry(host: String, timeEntryClockIn: TimeEntryClockIn): Task[TimeEntryDto] = {
    implicit val returnTypeDecoder: EntityDecoder[TimeEntryDto] = jsonOf[TimeEntryDto]

    val path = "/api/v1/time-entries"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(timeEntryClockIn)
      resp          <- client.expect[TimeEntryDto](req)

    } yield resp
  }

  def clockOutTimeEntry(host: String, id: UUID, timeEntryClockOut: TimeEntryClockOut): Task[TimeEntryDto] = {
    implicit val returnTypeDecoder: EntityDecoder[TimeEntryDto] = jsonOf[TimeEntryDto]

    val path = "/api/v1/time-entries/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.PATCH
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(timeEntryClockOut)
      resp          <- client.expect[TimeEntryDto](req)

    } yield resp
  }

  def getLaborCosts(host: String, from: LocalDate, to: LocalDate, groupBy: String)(implicit fromQuery: QueryParam[LocalDate], toQuery: QueryParam[LocalDate], groupByQuery: QueryParam[String]): Task[List[LaborCostRow]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[LaborCostRow]] = jsonOf[List[LaborCostRow]]

    val path = "/api/v1/labor-costs"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))), ("groupBy", Some(group_byQuery.toParamString(group_by))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[LaborCostRow]](req)

    } yield resp
  }

  def listTimeEntries(host: String, from: LocalDate, to: LocalDate, active: Boolean, employeeId: UUID)(implicit fromQuery: QueryParam[LocalDate], toQuery: QueryParam[LocalDate], activeQuery: QueryParam[Boolean], employeeIdQuery: QueryParam[UUID]): Task[List[TimeEntryDto]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[TimeEntryDto]] = jsonOf[List[TimeEntryDto]]

    val path = "/api/v1/time-entries"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))), ("active", Some(activeQuery.toParamString(active))), ("employeeId", Some(employee_idQuery.toParamString(employee_id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[TimeEntryDto]](req)

    } yield resp
  }

}

class HttpServiceTimeEntriesApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def clockInTimeEntry(timeEntryClockIn: TimeEntryClockIn): Task[TimeEntryDto] = {
    implicit val returnTypeDecoder: EntityDecoder[TimeEntryDto] = jsonOf[TimeEntryDto]

    val path = "/api/v1/time-entries"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(timeEntryClockIn)
      resp          <- client.expect[TimeEntryDto](req)

    } yield resp
  }

  def clockOutTimeEntry(id: UUID, timeEntryClockOut: TimeEntryClockOut): Task[TimeEntryDto] = {
    implicit val returnTypeDecoder: EntityDecoder[TimeEntryDto] = jsonOf[TimeEntryDto]

    val path = "/api/v1/time-entries/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.PATCH
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(timeEntryClockOut)
      resp          <- client.expect[TimeEntryDto](req)

    } yield resp
  }

  def getLaborCosts(from: LocalDate, to: LocalDate, groupBy: String)(implicit fromQuery: QueryParam[LocalDate], toQuery: QueryParam[LocalDate], groupByQuery: QueryParam[String]): Task[List[LaborCostRow]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[LaborCostRow]] = jsonOf[List[LaborCostRow]]

    val path = "/api/v1/labor-costs"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))), ("groupBy", Some(group_byQuery.toParamString(group_by))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[LaborCostRow]](req)

    } yield resp
  }

  def listTimeEntries(from: LocalDate, to: LocalDate, active: Boolean, employeeId: UUID)(implicit fromQuery: QueryParam[LocalDate], toQuery: QueryParam[LocalDate], activeQuery: QueryParam[Boolean], employeeIdQuery: QueryParam[UUID]): Task[List[TimeEntryDto]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[TimeEntryDto]] = jsonOf[List[TimeEntryDto]]

    val path = "/api/v1/time-entries"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))), ("active", Some(activeQuery.toParamString(active))), ("employeeId", Some(employee_idQuery.toParamString(employee_id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[TimeEntryDto]](req)

    } yield resp
  }

}
