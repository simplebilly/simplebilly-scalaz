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
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.SupplierInvoice
import org.openapitools.client.api.SupplierInvoiceStatusUpdate

object SupplierInvoiceApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createSupplierInvoice(host: String, supplierInvoice: SupplierInvoice): Task[SupplierInvoice] = {
    implicit val returnTypeDecoder: EntityDecoder[SupplierInvoice] = jsonOf[SupplierInvoice]

    val path = "/api/v1/supplier-invoices"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(supplierInvoice)
      resp          <- client.expect[SupplierInvoice](req)

    } yield resp
  }

  def deleteSupplierInvoice(host: String, supplierInvoiceId: String): Task[Unit] = {
    val path = "/api/v1/supplier-invoices/{supplier_invoice_id}".replaceAll("\\{" + "supplier_invoice_id" + "\\}",escape(supplierInvoiceId.toString))

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

  def getSupplierInvoice(host: String, supplierInvoiceId: String): Task[SupplierInvoice] = {
    implicit val returnTypeDecoder: EntityDecoder[SupplierInvoice] = jsonOf[SupplierInvoice]

    val path = "/api/v1/supplier-invoices/{supplier_invoice_id}".replaceAll("\\{" + "supplier_invoice_id" + "\\}",escape(supplierInvoiceId.toString))

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
      resp          <- client.expect[SupplierInvoice](req)

    } yield resp
  }

  def listSupplierInvoices(host: String, page: Integer, pageSize: Integer, status: String, purchaseOrderId: String, supplierName: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], purchaseOrderIdQuery: QueryParam[String], supplierNameQuery: QueryParam[String]): Task[List[SupplierInvoice]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[SupplierInvoice]] = jsonOf[List[SupplierInvoice]]

    val path = "/api/v1/supplier-invoices/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("purchaseOrderId", Some(purchase_order_idQuery.toParamString(purchase_order_id))), ("supplierName", Some(supplier_nameQuery.toParamString(supplier_name))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[SupplierInvoice]](req)

    } yield resp
  }

  def updateSupplierInvoice(host: String, supplierInvoiceId: String, body: AnyType): Task[SupplierInvoice] = {
    implicit val returnTypeDecoder: EntityDecoder[SupplierInvoice] = jsonOf[SupplierInvoice]

    val path = "/api/v1/supplier-invoices/{supplier_invoice_id}".replaceAll("\\{" + "supplier_invoice_id" + "\\}",escape(supplierInvoiceId.toString))

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
      resp          <- client.expect[SupplierInvoice](req)

    } yield resp
  }

  def updateSupplierInvoiceStatus(host: String, supplierInvoiceId: String, supplierInvoiceStatusUpdate: SupplierInvoiceStatusUpdate): Task[SupplierInvoice] = {
    implicit val returnTypeDecoder: EntityDecoder[SupplierInvoice] = jsonOf[SupplierInvoice]

    val path = "/api/v1/supplier-invoices/{supplier_invoice_id}/status".replaceAll("\\{" + "supplier_invoice_id" + "\\}",escape(supplierInvoiceId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(supplierInvoiceStatusUpdate)
      resp          <- client.expect[SupplierInvoice](req)

    } yield resp
  }

}

class HttpServiceSupplierInvoiceApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createSupplierInvoice(supplierInvoice: SupplierInvoice): Task[SupplierInvoice] = {
    implicit val returnTypeDecoder: EntityDecoder[SupplierInvoice] = jsonOf[SupplierInvoice]

    val path = "/api/v1/supplier-invoices"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(supplierInvoice)
      resp          <- client.expect[SupplierInvoice](req)

    } yield resp
  }

  def deleteSupplierInvoice(supplierInvoiceId: String): Task[Unit] = {
    val path = "/api/v1/supplier-invoices/{supplier_invoice_id}".replaceAll("\\{" + "supplier_invoice_id" + "\\}",escape(supplierInvoiceId.toString))

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

  def getSupplierInvoice(supplierInvoiceId: String): Task[SupplierInvoice] = {
    implicit val returnTypeDecoder: EntityDecoder[SupplierInvoice] = jsonOf[SupplierInvoice]

    val path = "/api/v1/supplier-invoices/{supplier_invoice_id}".replaceAll("\\{" + "supplier_invoice_id" + "\\}",escape(supplierInvoiceId.toString))

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
      resp          <- client.expect[SupplierInvoice](req)

    } yield resp
  }

  def listSupplierInvoices(page: Integer, pageSize: Integer, status: String, purchaseOrderId: String, supplierName: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], purchaseOrderIdQuery: QueryParam[String], supplierNameQuery: QueryParam[String]): Task[List[SupplierInvoice]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[SupplierInvoice]] = jsonOf[List[SupplierInvoice]]

    val path = "/api/v1/supplier-invoices/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("purchaseOrderId", Some(purchase_order_idQuery.toParamString(purchase_order_id))), ("supplierName", Some(supplier_nameQuery.toParamString(supplier_name))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[SupplierInvoice]](req)

    } yield resp
  }

  def updateSupplierInvoice(supplierInvoiceId: String, body: AnyType): Task[SupplierInvoice] = {
    implicit val returnTypeDecoder: EntityDecoder[SupplierInvoice] = jsonOf[SupplierInvoice]

    val path = "/api/v1/supplier-invoices/{supplier_invoice_id}".replaceAll("\\{" + "supplier_invoice_id" + "\\}",escape(supplierInvoiceId.toString))

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
      resp          <- client.expect[SupplierInvoice](req)

    } yield resp
  }

  def updateSupplierInvoiceStatus(supplierInvoiceId: String, supplierInvoiceStatusUpdate: SupplierInvoiceStatusUpdate): Task[SupplierInvoice] = {
    implicit val returnTypeDecoder: EntityDecoder[SupplierInvoice] = jsonOf[SupplierInvoice]

    val path = "/api/v1/supplier-invoices/{supplier_invoice_id}/status".replaceAll("\\{" + "supplier_invoice_id" + "\\}",escape(supplierInvoiceId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(supplierInvoiceStatusUpdate)
      resp          <- client.expect[SupplierInvoice](req)

    } yield resp
  }

}
