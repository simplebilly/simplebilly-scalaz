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
import org.openapitools.client.api.ConvertResponse
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.ProformaInvoice

object ProformaInvoiceApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def convertProformaToInvoice(host: String, proformaId: String): Task[ConvertResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ConvertResponse] = jsonOf[ConvertResponse]

    val path = "/api/v1/proforma-invoices/{proforma_id}/convert".replaceAll("\\{" + "proforma_id" + "\\}",escape(proformaId.toString))

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
      resp          <- client.expect[ConvertResponse](req)

    } yield resp
  }

  def createProformaInvoice(host: String, proformaInvoice: ProformaInvoice): Task[ProformaInvoice] = {
    implicit val returnTypeDecoder: EntityDecoder[ProformaInvoice] = jsonOf[ProformaInvoice]

    val path = "/api/v1/proforma-invoices"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(proformaInvoice)
      resp          <- client.expect[ProformaInvoice](req)

    } yield resp
  }

  def deleteProformaInvoice(host: String, proformaId: String): Task[Unit] = {
    val path = "/api/v1/proforma-invoices/{proforma_id}".replaceAll("\\{" + "proforma_id" + "\\}",escape(proformaId.toString))

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

  def getProformaInvoice(host: String, proformaId: String): Task[ProformaInvoice] = {
    implicit val returnTypeDecoder: EntityDecoder[ProformaInvoice] = jsonOf[ProformaInvoice]

    val path = "/api/v1/proforma-invoices/{proforma_id}".replaceAll("\\{" + "proforma_id" + "\\}",escape(proformaId.toString))

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
      resp          <- client.expect[ProformaInvoice](req)

    } yield resp
  }

  def listProformaInvoices(host: String, page: Integer, pageSize: Integer, status: String, customerId: String, orderNumber: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], customerIdQuery: QueryParam[String], orderNumberQuery: QueryParam[String]): Task[List[ProformaInvoice]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ProformaInvoice]] = jsonOf[List[ProformaInvoice]]

    val path = "/api/v1/proforma-invoices/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("customerId", Some(customer_idQuery.toParamString(customer_id))), ("orderNumber", Some(order_numberQuery.toParamString(order_number))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ProformaInvoice]](req)

    } yield resp
  }

  def updateProformaInvoice(host: String, proformaId: String, body: AnyType): Task[ProformaInvoice] = {
    implicit val returnTypeDecoder: EntityDecoder[ProformaInvoice] = jsonOf[ProformaInvoice]

    val path = "/api/v1/proforma-invoices/{proforma_id}".replaceAll("\\{" + "proforma_id" + "\\}",escape(proformaId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[ProformaInvoice](req)

    } yield resp
  }

}

class HttpServiceProformaInvoiceApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def convertProformaToInvoice(proformaId: String): Task[ConvertResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ConvertResponse] = jsonOf[ConvertResponse]

    val path = "/api/v1/proforma-invoices/{proforma_id}/convert".replaceAll("\\{" + "proforma_id" + "\\}",escape(proformaId.toString))

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
      resp          <- client.expect[ConvertResponse](req)

    } yield resp
  }

  def createProformaInvoice(proformaInvoice: ProformaInvoice): Task[ProformaInvoice] = {
    implicit val returnTypeDecoder: EntityDecoder[ProformaInvoice] = jsonOf[ProformaInvoice]

    val path = "/api/v1/proforma-invoices"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(proformaInvoice)
      resp          <- client.expect[ProformaInvoice](req)

    } yield resp
  }

  def deleteProformaInvoice(proformaId: String): Task[Unit] = {
    val path = "/api/v1/proforma-invoices/{proforma_id}".replaceAll("\\{" + "proforma_id" + "\\}",escape(proformaId.toString))

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

  def getProformaInvoice(proformaId: String): Task[ProformaInvoice] = {
    implicit val returnTypeDecoder: EntityDecoder[ProformaInvoice] = jsonOf[ProformaInvoice]

    val path = "/api/v1/proforma-invoices/{proforma_id}".replaceAll("\\{" + "proforma_id" + "\\}",escape(proformaId.toString))

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
      resp          <- client.expect[ProformaInvoice](req)

    } yield resp
  }

  def listProformaInvoices(page: Integer, pageSize: Integer, status: String, customerId: String, orderNumber: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], customerIdQuery: QueryParam[String], orderNumberQuery: QueryParam[String]): Task[List[ProformaInvoice]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ProformaInvoice]] = jsonOf[List[ProformaInvoice]]

    val path = "/api/v1/proforma-invoices/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("customerId", Some(customer_idQuery.toParamString(customer_id))), ("orderNumber", Some(order_numberQuery.toParamString(order_number))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ProformaInvoice]](req)

    } yield resp
  }

  def updateProformaInvoice(proformaId: String, body: AnyType): Task[ProformaInvoice] = {
    implicit val returnTypeDecoder: EntityDecoder[ProformaInvoice] = jsonOf[ProformaInvoice]

    val path = "/api/v1/proforma-invoices/{proforma_id}".replaceAll("\\{" + "proforma_id" + "\\}",escape(proformaId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[ProformaInvoice](req)

    } yield resp
  }

}
