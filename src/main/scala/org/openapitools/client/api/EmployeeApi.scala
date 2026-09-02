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

import org.openapitools.client.api.Employee
import org.openapitools.client.api.EmployeeCreate
import org.openapitools.client.api.EmployeeUpdate
import org.openapitools.client.api.PayrollSummary
import org.openapitools.client.api.PluginError
import java.util.UUID

object EmployeeApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createEmployee(host: String, employeeCreate: EmployeeCreate): Task[Employee] = {
    implicit val returnTypeDecoder: EntityDecoder[Employee] = jsonOf[Employee]

    val path = "/api/v1/employees"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(employeeCreate)
      resp          <- client.expect[Employee](req)

    } yield resp
  }

  def deleteEmployee(host: String, id: UUID): Task[Unit] = {
    val path = "/api/v1/employees/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def employeeRestore(host: String, id: UUID): Task[Employee] = {
    implicit val returnTypeDecoder: EntityDecoder[Employee] = jsonOf[Employee]

    val path = "/api/v1/employees/{id}/restore".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[Employee](req)

    } yield resp
  }

  def getEmployee(host: String, id: UUID): Task[Employee] = {
    implicit val returnTypeDecoder: EntityDecoder[Employee] = jsonOf[Employee]

    val path = "/api/v1/employees/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[Employee](req)

    } yield resp
  }

  def getEmployeePayrollSummary(host: String, id: UUID, year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[PayrollSummary] = {
    implicit val returnTypeDecoder: EntityDecoder[PayrollSummary] = jsonOf[PayrollSummary]

    val path = "/api/v1/employees/{id}/payroll-summary".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[PayrollSummary](req)

    } yield resp
  }

  def getEmployees(host: String, page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[Employee]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Employee]] = jsonOf[List[Employee]]

    val path = "/api/v1/employees/"

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
      resp          <- client.expect[List[Employee]](req)

    } yield resp
  }

  def updateEmployee(host: String, id: UUID, employeeUpdate: EmployeeUpdate): Task[Employee] = {
    implicit val returnTypeDecoder: EntityDecoder[Employee] = jsonOf[Employee]

    val path = "/api/v1/employees/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(employeeUpdate)
      resp          <- client.expect[Employee](req)

    } yield resp
  }

}

class HttpServiceEmployeeApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createEmployee(employeeCreate: EmployeeCreate): Task[Employee] = {
    implicit val returnTypeDecoder: EntityDecoder[Employee] = jsonOf[Employee]

    val path = "/api/v1/employees"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(employeeCreate)
      resp          <- client.expect[Employee](req)

    } yield resp
  }

  def deleteEmployee(id: UUID): Task[Unit] = {
    val path = "/api/v1/employees/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def employeeRestore(id: UUID): Task[Employee] = {
    implicit val returnTypeDecoder: EntityDecoder[Employee] = jsonOf[Employee]

    val path = "/api/v1/employees/{id}/restore".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[Employee](req)

    } yield resp
  }

  def getEmployee(id: UUID): Task[Employee] = {
    implicit val returnTypeDecoder: EntityDecoder[Employee] = jsonOf[Employee]

    val path = "/api/v1/employees/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[Employee](req)

    } yield resp
  }

  def getEmployeePayrollSummary(id: UUID, year: Integer)(implicit yearQuery: QueryParam[Integer]): Task[PayrollSummary] = {
    implicit val returnTypeDecoder: EntityDecoder[PayrollSummary] = jsonOf[PayrollSummary]

    val path = "/api/v1/employees/{id}/payroll-summary".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[PayrollSummary](req)

    } yield resp
  }

  def getEmployees(page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[Employee]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Employee]] = jsonOf[List[Employee]]

    val path = "/api/v1/employees/"

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
      resp          <- client.expect[List[Employee]](req)

    } yield resp
  }

  def updateEmployee(id: UUID, employeeUpdate: EmployeeUpdate): Task[Employee] = {
    implicit val returnTypeDecoder: EntityDecoder[Employee] = jsonOf[Employee]

    val path = "/api/v1/employees/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(employeeUpdate)
      resp          <- client.expect[Employee](req)

    } yield resp
  }

}
