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

import org.openapitools.client.api.PluginError
import org.openapitools.client.api.StockTransfer
import org.openapitools.client.api.StockTransferStatusUpdate

object StockTransferApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createStockTransfer(host: String, stockTransfer: StockTransfer): Task[StockTransfer] = {
    implicit val returnTypeDecoder: EntityDecoder[StockTransfer] = jsonOf[StockTransfer]

    val path = "/api/v1/stock-transfers"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(stockTransfer)
      resp          <- client.expect[StockTransfer](req)

    } yield resp
  }

  def deleteStockTransfer(host: String, stockTransferId: String): Task[Unit] = {
    val path = "/api/v1/stock-transfers/{stock_transfer_id}".replaceAll("\\{" + "stock_transfer_id" + "\\}",escape(stockTransferId.toString))

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

  def getStockTransfer(host: String, stockTransferId: String): Task[StockTransfer] = {
    implicit val returnTypeDecoder: EntityDecoder[StockTransfer] = jsonOf[StockTransfer]

    val path = "/api/v1/stock-transfers/{stock_transfer_id}".replaceAll("\\{" + "stock_transfer_id" + "\\}",escape(stockTransferId.toString))

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
      resp          <- client.expect[StockTransfer](req)

    } yield resp
  }

  def listStockTransfers(host: String, page: Integer, pageSize: Integer, status: String, warehouseId: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], warehouseIdQuery: QueryParam[String]): Task[List[StockTransfer]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[StockTransfer]] = jsonOf[List[StockTransfer]]

    val path = "/api/v1/stock-transfers/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("warehouseId", Some(warehouse_idQuery.toParamString(warehouse_id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[StockTransfer]](req)

    } yield resp
  }

  def updateStockTransferStatus(host: String, stockTransferId: String, stockTransferStatusUpdate: StockTransferStatusUpdate): Task[StockTransfer] = {
    implicit val returnTypeDecoder: EntityDecoder[StockTransfer] = jsonOf[StockTransfer]

    val path = "/api/v1/stock-transfers/{stock_transfer_id}/status".replaceAll("\\{" + "stock_transfer_id" + "\\}",escape(stockTransferId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(stockTransferStatusUpdate)
      resp          <- client.expect[StockTransfer](req)

    } yield resp
  }

}

class HttpServiceStockTransferApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createStockTransfer(stockTransfer: StockTransfer): Task[StockTransfer] = {
    implicit val returnTypeDecoder: EntityDecoder[StockTransfer] = jsonOf[StockTransfer]

    val path = "/api/v1/stock-transfers"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(stockTransfer)
      resp          <- client.expect[StockTransfer](req)

    } yield resp
  }

  def deleteStockTransfer(stockTransferId: String): Task[Unit] = {
    val path = "/api/v1/stock-transfers/{stock_transfer_id}".replaceAll("\\{" + "stock_transfer_id" + "\\}",escape(stockTransferId.toString))

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

  def getStockTransfer(stockTransferId: String): Task[StockTransfer] = {
    implicit val returnTypeDecoder: EntityDecoder[StockTransfer] = jsonOf[StockTransfer]

    val path = "/api/v1/stock-transfers/{stock_transfer_id}".replaceAll("\\{" + "stock_transfer_id" + "\\}",escape(stockTransferId.toString))

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
      resp          <- client.expect[StockTransfer](req)

    } yield resp
  }

  def listStockTransfers(page: Integer, pageSize: Integer, status: String, warehouseId: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], warehouseIdQuery: QueryParam[String]): Task[List[StockTransfer]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[StockTransfer]] = jsonOf[List[StockTransfer]]

    val path = "/api/v1/stock-transfers/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("warehouseId", Some(warehouse_idQuery.toParamString(warehouse_id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[StockTransfer]](req)

    } yield resp
  }

  def updateStockTransferStatus(stockTransferId: String, stockTransferStatusUpdate: StockTransferStatusUpdate): Task[StockTransfer] = {
    implicit val returnTypeDecoder: EntityDecoder[StockTransfer] = jsonOf[StockTransfer]

    val path = "/api/v1/stock-transfers/{stock_transfer_id}/status".replaceAll("\\{" + "stock_transfer_id" + "\\}",escape(stockTransferId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(stockTransferStatusUpdate)
      resp          <- client.expect[StockTransfer](req)

    } yield resp
  }

}
