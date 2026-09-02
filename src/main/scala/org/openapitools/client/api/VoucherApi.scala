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
import java.time.LocalDate
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.Voucher
import org.openapitools.client.api.VoucherCreate

object VoucherApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createVoucher(host: String, voucherCreate: VoucherCreate): Task[Voucher] = {
    implicit val returnTypeDecoder: EntityDecoder[Voucher] = jsonOf[Voucher]

    val path = "/api/v1/vouchers"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(voucherCreate)
      resp          <- client.expect[Voucher](req)

    } yield resp
  }

  def deleteVoucher(host: String, voucherId: String): Task[Unit] = {
    val path = "/api/v1/vouchers/{voucher_id}".replaceAll("\\{" + "voucher_id" + "\\}",escape(voucherId.toString))

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

  def getVoucher(host: String, voucherId: String): Task[Voucher] = {
    implicit val returnTypeDecoder: EntityDecoder[Voucher] = jsonOf[Voucher]

    val path = "/api/v1/vouchers/{voucher_id}".replaceAll("\\{" + "voucher_id" + "\\}",escape(voucherId.toString))

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
      resp          <- client.expect[Voucher](req)

    } yield resp
  }

  def listVouchers(host: String, page: Integer, pageSize: Integer, voucherType: String, voucherStatus: String, contactName: String, dateFrom: LocalDate, dateTo: LocalDate)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], voucherTypeQuery: QueryParam[String], voucherStatusQuery: QueryParam[String], contactNameQuery: QueryParam[String], dateFromQuery: QueryParam[LocalDate], dateToQuery: QueryParam[LocalDate]): Task[List[Voucher]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Voucher]] = jsonOf[List[Voucher]]

    val path = "/api/v1/vouchers/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("voucherType", Some(voucher_typeQuery.toParamString(voucher_type))), ("voucherStatus", Some(voucher_statusQuery.toParamString(voucher_status))), ("contactName", Some(contact_nameQuery.toParamString(contact_name))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Voucher]](req)

    } yield resp
  }

  def updateVoucher(host: String, voucherId: String, body: AnyType): Task[Voucher] = {
    implicit val returnTypeDecoder: EntityDecoder[Voucher] = jsonOf[Voucher]

    val path = "/api/v1/vouchers/{voucher_id}".replaceAll("\\{" + "voucher_id" + "\\}",escape(voucherId.toString))

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
      resp          <- client.expect[Voucher](req)

    } yield resp
  }

  def voucherRestore(host: String, voucherId: String): Task[Voucher] = {
    implicit val returnTypeDecoder: EntityDecoder[Voucher] = jsonOf[Voucher]

    val path = "/api/v1/vouchers/{voucher_id}/restore".replaceAll("\\{" + "voucher_id" + "\\}",escape(voucherId.toString))

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
      resp          <- client.expect[Voucher](req)

    } yield resp
  }

}

class HttpServiceVoucherApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createVoucher(voucherCreate: VoucherCreate): Task[Voucher] = {
    implicit val returnTypeDecoder: EntityDecoder[Voucher] = jsonOf[Voucher]

    val path = "/api/v1/vouchers"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(voucherCreate)
      resp          <- client.expect[Voucher](req)

    } yield resp
  }

  def deleteVoucher(voucherId: String): Task[Unit] = {
    val path = "/api/v1/vouchers/{voucher_id}".replaceAll("\\{" + "voucher_id" + "\\}",escape(voucherId.toString))

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

  def getVoucher(voucherId: String): Task[Voucher] = {
    implicit val returnTypeDecoder: EntityDecoder[Voucher] = jsonOf[Voucher]

    val path = "/api/v1/vouchers/{voucher_id}".replaceAll("\\{" + "voucher_id" + "\\}",escape(voucherId.toString))

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
      resp          <- client.expect[Voucher](req)

    } yield resp
  }

  def listVouchers(page: Integer, pageSize: Integer, voucherType: String, voucherStatus: String, contactName: String, dateFrom: LocalDate, dateTo: LocalDate)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], voucherTypeQuery: QueryParam[String], voucherStatusQuery: QueryParam[String], contactNameQuery: QueryParam[String], dateFromQuery: QueryParam[LocalDate], dateToQuery: QueryParam[LocalDate]): Task[List[Voucher]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Voucher]] = jsonOf[List[Voucher]]

    val path = "/api/v1/vouchers/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("voucherType", Some(voucher_typeQuery.toParamString(voucher_type))), ("voucherStatus", Some(voucher_statusQuery.toParamString(voucher_status))), ("contactName", Some(contact_nameQuery.toParamString(contact_name))), ("dateFrom", Some(date_fromQuery.toParamString(date_from))), ("dateTo", Some(date_toQuery.toParamString(date_to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Voucher]](req)

    } yield resp
  }

  def updateVoucher(voucherId: String, body: AnyType): Task[Voucher] = {
    implicit val returnTypeDecoder: EntityDecoder[Voucher] = jsonOf[Voucher]

    val path = "/api/v1/vouchers/{voucher_id}".replaceAll("\\{" + "voucher_id" + "\\}",escape(voucherId.toString))

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
      resp          <- client.expect[Voucher](req)

    } yield resp
  }

  def voucherRestore(voucherId: String): Task[Voucher] = {
    implicit val returnTypeDecoder: EntityDecoder[Voucher] = jsonOf[Voucher]

    val path = "/api/v1/vouchers/{voucher_id}/restore".replaceAll("\\{" + "voucher_id" + "\\}",escape(voucherId.toString))

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
      resp          <- client.expect[Voucher](req)

    } yield resp
  }

}
