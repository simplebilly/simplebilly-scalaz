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
import org.openapitools.client.api.PayrollCreatePayload
import org.openapitools.client.api.PayrollPayPayload
import org.openapitools.client.api.PayrollRunApi
import java.util.UUID
import org.openapitools.client.api.YearlyPayrollSummary

object PayrollApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def payrollApprove(host: String, id: UUID): Task[PayrollRunApi] = {
    implicit val returnTypeDecoder: EntityDecoder[PayrollRunApi] = jsonOf[PayrollRunApi]

    val path = "/api/v1/payroll/{id}/approve".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[PayrollRunApi](req)

    } yield resp
  }

  def payrollAutopay(host: String, id: String, body: AnyType): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/payroll/{id}/autopay".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def payrollCalculate(host: String, id: UUID): Task[PayrollRunApi] = {
    implicit val returnTypeDecoder: EntityDecoder[PayrollRunApi] = jsonOf[PayrollRunApi]

    val path = "/api/v1/payroll/{id}/calculate".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[PayrollRunApi](req)

    } yield resp
  }

  def payrollCreate(host: String, payrollCreatePayload: PayrollCreatePayload): Task[PayrollRunApi] = {
    implicit val returnTypeDecoder: EntityDecoder[PayrollRunApi] = jsonOf[PayrollRunApi]

    val path = "/api/v1/payroll"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(payrollCreatePayload)
      resp          <- client.expect[PayrollRunApi](req)

    } yield resp
  }

  def payrollDelete(host: String, id: UUID): Task[Unit] = {
    val path = "/api/v1/payroll/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def payrollElsterExport(host: String, id: UUID): Task[Unit] = {
    val path = "/api/v1/payroll/{id}/elster-export".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def payrollEmail(host: String, id: String): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/payroll/{id}/email".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def payrollEntryPdf(host: String, id: String, entryId: String): Task[Unit] = {
    val path = "/api/v1/payroll/{id}/entries/{entry_id}/pdf".replaceAll("\\{" + "id" + "\\}",escape(id.toString)).replaceAll("\\{" + "entry_id" + "\\}",escape(entryId.toString))

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def payrollGet(host: String, id: UUID): Task[PayrollRunApi] = {
    implicit val returnTypeDecoder: EntityDecoder[PayrollRunApi] = jsonOf[PayrollRunApi]

    val path = "/api/v1/payroll/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[PayrollRunApi](req)

    } yield resp
  }

  def payrollList(host: String, year: Integer, status: String)(implicit yearQuery: QueryParam[Integer], statusQuery: QueryParam[String]): Task[List[PayrollRunApi]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PayrollRunApi]] = jsonOf[List[PayrollRunApi]]

    val path = "/api/v1/payroll"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("status", Some(statusQuery.toParamString(status))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[PayrollRunApi]](req)

    } yield resp
  }

  def payrollPay(host: String, id: UUID, payrollPayPayload: PayrollPayPayload): Task[PayrollRunApi] = {
    implicit val returnTypeDecoder: EntityDecoder[PayrollRunApi] = jsonOf[PayrollRunApi]

    val path = "/api/v1/payroll/{id}/pay".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(payrollPayPayload)
      resp          <- client.expect[PayrollRunApi](req)

    } yield resp
  }

  def payrollPdf(host: String, id: String): Task[Unit] = {
    val path = "/api/v1/payroll/{id}/pdf".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def payrollSummary(host: String, year: Integer): Task[YearlyPayrollSummary] = {
    implicit val returnTypeDecoder: EntityDecoder[YearlyPayrollSummary] = jsonOf[YearlyPayrollSummary]

    val path = "/api/v1/payroll/summary/{year}".replaceAll("\\{" + "year" + "\\}",escape(year.toString))

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
      resp          <- client.expect[YearlyPayrollSummary](req)

    } yield resp
  }

  def payrollSvMeldungen(host: String, id: UUID): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/payroll/{id}/sv-meldungen".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

}

class HttpServicePayrollApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def payrollApprove(id: UUID): Task[PayrollRunApi] = {
    implicit val returnTypeDecoder: EntityDecoder[PayrollRunApi] = jsonOf[PayrollRunApi]

    val path = "/api/v1/payroll/{id}/approve".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[PayrollRunApi](req)

    } yield resp
  }

  def payrollAutopay(id: String, body: AnyType): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/payroll/{id}/autopay".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def payrollCalculate(id: UUID): Task[PayrollRunApi] = {
    implicit val returnTypeDecoder: EntityDecoder[PayrollRunApi] = jsonOf[PayrollRunApi]

    val path = "/api/v1/payroll/{id}/calculate".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[PayrollRunApi](req)

    } yield resp
  }

  def payrollCreate(payrollCreatePayload: PayrollCreatePayload): Task[PayrollRunApi] = {
    implicit val returnTypeDecoder: EntityDecoder[PayrollRunApi] = jsonOf[PayrollRunApi]

    val path = "/api/v1/payroll"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(payrollCreatePayload)
      resp          <- client.expect[PayrollRunApi](req)

    } yield resp
  }

  def payrollDelete(id: UUID): Task[Unit] = {
    val path = "/api/v1/payroll/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def payrollElsterExport(id: UUID): Task[Unit] = {
    val path = "/api/v1/payroll/{id}/elster-export".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def payrollEmail(id: String): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/payroll/{id}/email".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def payrollEntryPdf(id: String, entryId: String): Task[Unit] = {
    val path = "/api/v1/payroll/{id}/entries/{entry_id}/pdf".replaceAll("\\{" + "id" + "\\}",escape(id.toString)).replaceAll("\\{" + "entry_id" + "\\}",escape(entryId.toString))

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def payrollGet(id: UUID): Task[PayrollRunApi] = {
    implicit val returnTypeDecoder: EntityDecoder[PayrollRunApi] = jsonOf[PayrollRunApi]

    val path = "/api/v1/payroll/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[PayrollRunApi](req)

    } yield resp
  }

  def payrollList(year: Integer, status: String)(implicit yearQuery: QueryParam[Integer], statusQuery: QueryParam[String]): Task[List[PayrollRunApi]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PayrollRunApi]] = jsonOf[List[PayrollRunApi]]

    val path = "/api/v1/payroll"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("status", Some(statusQuery.toParamString(status))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[PayrollRunApi]](req)

    } yield resp
  }

  def payrollPay(id: UUID, payrollPayPayload: PayrollPayPayload): Task[PayrollRunApi] = {
    implicit val returnTypeDecoder: EntityDecoder[PayrollRunApi] = jsonOf[PayrollRunApi]

    val path = "/api/v1/payroll/{id}/pay".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(payrollPayPayload)
      resp          <- client.expect[PayrollRunApi](req)

    } yield resp
  }

  def payrollPdf(id: String): Task[Unit] = {
    val path = "/api/v1/payroll/{id}/pdf".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def payrollSummary(year: Integer): Task[YearlyPayrollSummary] = {
    implicit val returnTypeDecoder: EntityDecoder[YearlyPayrollSummary] = jsonOf[YearlyPayrollSummary]

    val path = "/api/v1/payroll/summary/{year}".replaceAll("\\{" + "year" + "\\}",escape(year.toString))

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
      resp          <- client.expect[YearlyPayrollSummary](req)

    } yield resp
  }

  def payrollSvMeldungen(id: UUID): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/payroll/{id}/sv-meldungen".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

}
