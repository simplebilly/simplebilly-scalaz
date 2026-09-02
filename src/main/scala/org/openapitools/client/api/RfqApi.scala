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
import org.openapitools.client.api.Rfq
import org.openapitools.client.api.RfqStatusUpdate

object RfqApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def convertRfq(host: String, rfqId: String): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/rfqs/{rfq_id}/convert".replaceAll("\\{" + "rfq_id" + "\\}",escape(rfqId.toString))

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

  def createRfq(host: String, rfq: Rfq): Task[Rfq] = {
    implicit val returnTypeDecoder: EntityDecoder[Rfq] = jsonOf[Rfq]

    val path = "/api/v1/rfqs"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(rfq)
      resp          <- client.expect[Rfq](req)

    } yield resp
  }

  def deleteRfq(host: String, rfqId: String): Task[Unit] = {
    val path = "/api/v1/rfqs/{rfq_id}".replaceAll("\\{" + "rfq_id" + "\\}",escape(rfqId.toString))

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

  def getRfq(host: String, rfqId: String): Task[Rfq] = {
    implicit val returnTypeDecoder: EntityDecoder[Rfq] = jsonOf[Rfq]

    val path = "/api/v1/rfqs/{rfq_id}".replaceAll("\\{" + "rfq_id" + "\\}",escape(rfqId.toString))

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
      resp          <- client.expect[Rfq](req)

    } yield resp
  }

  def listRfqs(host: String, page: Integer, pageSize: Integer, status: String, supplierName: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], supplierNameQuery: QueryParam[String]): Task[List[Rfq]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Rfq]] = jsonOf[List[Rfq]]

    val path = "/api/v1/rfqs/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("supplierName", Some(supplier_nameQuery.toParamString(supplier_name))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Rfq]](req)

    } yield resp
  }

  def updateRfq(host: String, rfqId: String, body: AnyType): Task[Rfq] = {
    implicit val returnTypeDecoder: EntityDecoder[Rfq] = jsonOf[Rfq]

    val path = "/api/v1/rfqs/{rfq_id}".replaceAll("\\{" + "rfq_id" + "\\}",escape(rfqId.toString))

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
      resp          <- client.expect[Rfq](req)

    } yield resp
  }

  def updateRfqStatus(host: String, rfqId: String, rfqStatusUpdate: RfqStatusUpdate): Task[Rfq] = {
    implicit val returnTypeDecoder: EntityDecoder[Rfq] = jsonOf[Rfq]

    val path = "/api/v1/rfqs/{rfq_id}/status".replaceAll("\\{" + "rfq_id" + "\\}",escape(rfqId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(rfqStatusUpdate)
      resp          <- client.expect[Rfq](req)

    } yield resp
  }

}

class HttpServiceRfqApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def convertRfq(rfqId: String): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/v1/rfqs/{rfq_id}/convert".replaceAll("\\{" + "rfq_id" + "\\}",escape(rfqId.toString))

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

  def createRfq(rfq: Rfq): Task[Rfq] = {
    implicit val returnTypeDecoder: EntityDecoder[Rfq] = jsonOf[Rfq]

    val path = "/api/v1/rfqs"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(rfq)
      resp          <- client.expect[Rfq](req)

    } yield resp
  }

  def deleteRfq(rfqId: String): Task[Unit] = {
    val path = "/api/v1/rfqs/{rfq_id}".replaceAll("\\{" + "rfq_id" + "\\}",escape(rfqId.toString))

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

  def getRfq(rfqId: String): Task[Rfq] = {
    implicit val returnTypeDecoder: EntityDecoder[Rfq] = jsonOf[Rfq]

    val path = "/api/v1/rfqs/{rfq_id}".replaceAll("\\{" + "rfq_id" + "\\}",escape(rfqId.toString))

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
      resp          <- client.expect[Rfq](req)

    } yield resp
  }

  def listRfqs(page: Integer, pageSize: Integer, status: String, supplierName: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], supplierNameQuery: QueryParam[String]): Task[List[Rfq]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Rfq]] = jsonOf[List[Rfq]]

    val path = "/api/v1/rfqs/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("supplierName", Some(supplier_nameQuery.toParamString(supplier_name))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Rfq]](req)

    } yield resp
  }

  def updateRfq(rfqId: String, body: AnyType): Task[Rfq] = {
    implicit val returnTypeDecoder: EntityDecoder[Rfq] = jsonOf[Rfq]

    val path = "/api/v1/rfqs/{rfq_id}".replaceAll("\\{" + "rfq_id" + "\\}",escape(rfqId.toString))

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
      resp          <- client.expect[Rfq](req)

    } yield resp
  }

  def updateRfqStatus(rfqId: String, rfqStatusUpdate: RfqStatusUpdate): Task[Rfq] = {
    implicit val returnTypeDecoder: EntityDecoder[Rfq] = jsonOf[Rfq]

    val path = "/api/v1/rfqs/{rfq_id}/status".replaceAll("\\{" + "rfq_id" + "\\}",escape(rfqId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(rfqStatusUpdate)
      resp          <- client.expect[Rfq](req)

    } yield resp
  }

}
