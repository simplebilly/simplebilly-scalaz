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
import org.openapitools.client.api.OrderConfirmation
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.Quotation
import org.openapitools.client.api.QuotationCreate

object QuotationApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createQuotation(host: String, quotationCreate: QuotationCreate): Task[Quotation] = {
    implicit val returnTypeDecoder: EntityDecoder[Quotation] = jsonOf[Quotation]

    val path = "/api/v1/quotations"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(quotationCreate)
      resp          <- client.expect[Quotation](req)

    } yield resp
  }

  def deleteQuotation(host: String, quotationId: String): Task[Unit] = {
    val path = "/api/v1/quotations/{quotation_id}".replaceAll("\\{" + "quotation_id" + "\\}",escape(quotationId.toString))

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

  def downloadQuotationPdf(host: String, quotationId: String): Task[Unit] = {
    val path = "/api/v1/quotations/{quotation_id}/pdf".replaceAll("\\{" + "quotation_id" + "\\}",escape(quotationId.toString))

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

  def getQuotation(host: String, quotationId: String): Task[Quotation] = {
    implicit val returnTypeDecoder: EntityDecoder[Quotation] = jsonOf[Quotation]

    val path = "/api/v1/quotations/{quotation_id}".replaceAll("\\{" + "quotation_id" + "\\}",escape(quotationId.toString))

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
      resp          <- client.expect[Quotation](req)

    } yield resp
  }

  def listQuotations(host: String, page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[Quotation]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Quotation]] = jsonOf[List[Quotation]]

    val path = "/api/v1/quotations/"

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
      resp          <- client.expect[List[Quotation]](req)

    } yield resp
  }

  def pursueQuotation(host: String, quotationId: String): Task[OrderConfirmation] = {
    implicit val returnTypeDecoder: EntityDecoder[OrderConfirmation] = jsonOf[OrderConfirmation]

    val path = "/api/v1/quotations/{quotation_id}/pursue".replaceAll("\\{" + "quotation_id" + "\\}",escape(quotationId.toString))

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
      resp          <- client.expect[OrderConfirmation](req)

    } yield resp
  }

  def quotationRestore(host: String, quotationId: String): Task[Quotation] = {
    implicit val returnTypeDecoder: EntityDecoder[Quotation] = jsonOf[Quotation]

    val path = "/api/v1/quotations/{quotation_id}/restore".replaceAll("\\{" + "quotation_id" + "\\}",escape(quotationId.toString))

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
      resp          <- client.expect[Quotation](req)

    } yield resp
  }

  def updateQuotation(host: String, quotationId: String, body: AnyType): Task[Quotation] = {
    implicit val returnTypeDecoder: EntityDecoder[Quotation] = jsonOf[Quotation]

    val path = "/api/v1/quotations/{quotation_id}".replaceAll("\\{" + "quotation_id" + "\\}",escape(quotationId.toString))

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
      resp          <- client.expect[Quotation](req)

    } yield resp
  }

}

class HttpServiceQuotationApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createQuotation(quotationCreate: QuotationCreate): Task[Quotation] = {
    implicit val returnTypeDecoder: EntityDecoder[Quotation] = jsonOf[Quotation]

    val path = "/api/v1/quotations"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(quotationCreate)
      resp          <- client.expect[Quotation](req)

    } yield resp
  }

  def deleteQuotation(quotationId: String): Task[Unit] = {
    val path = "/api/v1/quotations/{quotation_id}".replaceAll("\\{" + "quotation_id" + "\\}",escape(quotationId.toString))

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

  def downloadQuotationPdf(quotationId: String): Task[Unit] = {
    val path = "/api/v1/quotations/{quotation_id}/pdf".replaceAll("\\{" + "quotation_id" + "\\}",escape(quotationId.toString))

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

  def getQuotation(quotationId: String): Task[Quotation] = {
    implicit val returnTypeDecoder: EntityDecoder[Quotation] = jsonOf[Quotation]

    val path = "/api/v1/quotations/{quotation_id}".replaceAll("\\{" + "quotation_id" + "\\}",escape(quotationId.toString))

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
      resp          <- client.expect[Quotation](req)

    } yield resp
  }

  def listQuotations(page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[Quotation]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Quotation]] = jsonOf[List[Quotation]]

    val path = "/api/v1/quotations/"

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
      resp          <- client.expect[List[Quotation]](req)

    } yield resp
  }

  def pursueQuotation(quotationId: String): Task[OrderConfirmation] = {
    implicit val returnTypeDecoder: EntityDecoder[OrderConfirmation] = jsonOf[OrderConfirmation]

    val path = "/api/v1/quotations/{quotation_id}/pursue".replaceAll("\\{" + "quotation_id" + "\\}",escape(quotationId.toString))

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
      resp          <- client.expect[OrderConfirmation](req)

    } yield resp
  }

  def quotationRestore(quotationId: String): Task[Quotation] = {
    implicit val returnTypeDecoder: EntityDecoder[Quotation] = jsonOf[Quotation]

    val path = "/api/v1/quotations/{quotation_id}/restore".replaceAll("\\{" + "quotation_id" + "\\}",escape(quotationId.toString))

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
      resp          <- client.expect[Quotation](req)

    } yield resp
  }

  def updateQuotation(quotationId: String, body: AnyType): Task[Quotation] = {
    implicit val returnTypeDecoder: EntityDecoder[Quotation] = jsonOf[Quotation]

    val path = "/api/v1/quotations/{quotation_id}".replaceAll("\\{" + "quotation_id" + "\\}",escape(quotationId.toString))

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
      resp          <- client.expect[Quotation](req)

    } yield resp
  }

}
