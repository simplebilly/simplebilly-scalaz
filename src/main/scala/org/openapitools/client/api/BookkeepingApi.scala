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

import org.openapitools.client.api.AllocatePaymentRequest
import org.openapitools.client.api.BWAReport
import org.openapitools.client.api.CashflowReport
import org.openapitools.client.api.DunningResult
import org.openapitools.client.api.ElsterStatus
import org.openapitools.client.api.Invoice
import org.openapitools.client.api.LiquidityPosition
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.Verfahrensdokumentation

object BookkeepingApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def allocatePaymentApi(host: String, allocatePaymentRequest: AllocatePaymentRequest): Task[Unit] = {
    val path = "/api/v1/payments/allocate"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(allocatePaymentRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def bwaReportApi(host: String, year: Integer, month: Integer)(implicit yearQuery: QueryParam[Integer], monthQuery: QueryParam[Integer]): Task[BWAReport] = {
    implicit val returnTypeDecoder: EntityDecoder[BWAReport] = jsonOf[BWAReport]

    val path = "/api/v1/bookkeeping/bwa"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("month", Some(monthQuery.toParamString(month))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[BWAReport](req)

    } yield resp
  }

  def elsterStatusApi(host: String): Task[ElsterStatus] = {
    implicit val returnTypeDecoder: EntityDecoder[ElsterStatus] = jsonOf[ElsterStatus]

    val path = "/api/v1/bookkeeping/elster/status"

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
      resp          <- client.expect[ElsterStatus](req)

    } yield resp
  }

  def elsterValidateApi(host: String, zeitraum: String)(implicit zeitraumQuery: QueryParam[String]): Task[Unit] = {
    val path = "/api/v1/bookkeeping/ustva/elster-validate"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("zeitraum", Some(zeitraumQuery.toParamString(zeitraum))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def elsterXmlApi(host: String, zeitraum: String)(implicit zeitraumQuery: QueryParam[String]): Task[Unit] = {
    val path = "/api/v1/bookkeeping/ustva/elster-xml"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("zeitraum", Some(zeitraumQuery.toParamString(zeitraum))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def getCashflow(host: String, year: Integer, month: Integer)(implicit yearQuery: QueryParam[Integer], monthQuery: QueryParam[Integer]): Task[CashflowReport] = {
    implicit val returnTypeDecoder: EntityDecoder[CashflowReport] = jsonOf[CashflowReport]

    val path = "/api/v1/bookkeeping/cashflow"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("month", Some(monthQuery.toParamString(month))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[CashflowReport](req)

    } yield resp
  }

  def getLiquidity(host: String): Task[LiquidityPosition] = {
    implicit val returnTypeDecoder: EntityDecoder[LiquidityPosition] = jsonOf[LiquidityPosition]

    val path = "/api/v1/bookkeeping/liquidity"

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
      resp          <- client.expect[LiquidityPosition](req)

    } yield resp
  }

  def getOpenInvoicesApi(host: String, customerId: String): Task[List[Invoice]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Invoice]] = jsonOf[List[Invoice]]

    val path = "/api/v1/payments/open-invoices/{customer_id}".replaceAll("\\{" + "customer_id" + "\\}",escape(customerId.toString))

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
      resp          <- client.expect[List[Invoice]](req)

    } yield resp
  }

  def getVerfahrensdokumentation(host: String): Task[Verfahrensdokumentation] = {
    implicit val returnTypeDecoder: EntityDecoder[Verfahrensdokumentation] = jsonOf[Verfahrensdokumentation]

    val path = "/api/v1/bookkeeping/verfahrensdokumentation"

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
      resp          <- client.expect[Verfahrensdokumentation](req)

    } yield resp
  }

  def runDunningApi(host: String): Task[DunningResult] = {
    implicit val returnTypeDecoder: EntityDecoder[DunningResult] = jsonOf[DunningResult]

    val path = "/api/v1/bookkeeping/dunning"

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
      resp          <- client.expect[DunningResult](req)

    } yield resp
  }

}

class HttpServiceBookkeepingApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def allocatePaymentApi(allocatePaymentRequest: AllocatePaymentRequest): Task[Unit] = {
    val path = "/api/v1/payments/allocate"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(allocatePaymentRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def bwaReportApi(year: Integer, month: Integer)(implicit yearQuery: QueryParam[Integer], monthQuery: QueryParam[Integer]): Task[BWAReport] = {
    implicit val returnTypeDecoder: EntityDecoder[BWAReport] = jsonOf[BWAReport]

    val path = "/api/v1/bookkeeping/bwa"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("month", Some(monthQuery.toParamString(month))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[BWAReport](req)

    } yield resp
  }

  def elsterStatusApi(): Task[ElsterStatus] = {
    implicit val returnTypeDecoder: EntityDecoder[ElsterStatus] = jsonOf[ElsterStatus]

    val path = "/api/v1/bookkeeping/elster/status"

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
      resp          <- client.expect[ElsterStatus](req)

    } yield resp
  }

  def elsterValidateApi(zeitraum: String)(implicit zeitraumQuery: QueryParam[String]): Task[Unit] = {
    val path = "/api/v1/bookkeeping/ustva/elster-validate"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("zeitraum", Some(zeitraumQuery.toParamString(zeitraum))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def elsterXmlApi(zeitraum: String)(implicit zeitraumQuery: QueryParam[String]): Task[Unit] = {
    val path = "/api/v1/bookkeeping/ustva/elster-xml"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("zeitraum", Some(zeitraumQuery.toParamString(zeitraum))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def getCashflow(year: Integer, month: Integer)(implicit yearQuery: QueryParam[Integer], monthQuery: QueryParam[Integer]): Task[CashflowReport] = {
    implicit val returnTypeDecoder: EntityDecoder[CashflowReport] = jsonOf[CashflowReport]

    val path = "/api/v1/bookkeeping/cashflow"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("month", Some(monthQuery.toParamString(month))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[CashflowReport](req)

    } yield resp
  }

  def getLiquidity(): Task[LiquidityPosition] = {
    implicit val returnTypeDecoder: EntityDecoder[LiquidityPosition] = jsonOf[LiquidityPosition]

    val path = "/api/v1/bookkeeping/liquidity"

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
      resp          <- client.expect[LiquidityPosition](req)

    } yield resp
  }

  def getOpenInvoicesApi(customerId: String): Task[List[Invoice]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Invoice]] = jsonOf[List[Invoice]]

    val path = "/api/v1/payments/open-invoices/{customer_id}".replaceAll("\\{" + "customer_id" + "\\}",escape(customerId.toString))

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
      resp          <- client.expect[List[Invoice]](req)

    } yield resp
  }

  def getVerfahrensdokumentation(): Task[Verfahrensdokumentation] = {
    implicit val returnTypeDecoder: EntityDecoder[Verfahrensdokumentation] = jsonOf[Verfahrensdokumentation]

    val path = "/api/v1/bookkeeping/verfahrensdokumentation"

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
      resp          <- client.expect[Verfahrensdokumentation](req)

    } yield resp
  }

  def runDunningApi(): Task[DunningResult] = {
    implicit val returnTypeDecoder: EntityDecoder[DunningResult] = jsonOf[DunningResult]

    val path = "/api/v1/bookkeeping/dunning"

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
      resp          <- client.expect[DunningResult](req)

    } yield resp
  }

}
