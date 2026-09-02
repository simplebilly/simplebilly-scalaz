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

import org.openapitools.client.api.GoodsReceipt
import org.openapitools.client.api.PluginError

object GoodsReceiptApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createGoodsReceipt(host: String, goodsReceipt: GoodsReceipt): Task[GoodsReceipt] = {
    implicit val returnTypeDecoder: EntityDecoder[GoodsReceipt] = jsonOf[GoodsReceipt]

    val path = "/api/v1/goods-receipts"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(goodsReceipt)
      resp          <- client.expect[GoodsReceipt](req)

    } yield resp
  }

  def deleteGoodsReceipt(host: String, goodsReceiptId: String): Task[Unit] = {
    val path = "/api/v1/goods-receipts/{goods_receipt_id}".replaceAll("\\{" + "goods_receipt_id" + "\\}",escape(goodsReceiptId.toString))

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

  def getGoodsReceipt(host: String, goodsReceiptId: String): Task[GoodsReceipt] = {
    implicit val returnTypeDecoder: EntityDecoder[GoodsReceipt] = jsonOf[GoodsReceipt]

    val path = "/api/v1/goods-receipts/{goods_receipt_id}".replaceAll("\\{" + "goods_receipt_id" + "\\}",escape(goodsReceiptId.toString))

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
      resp          <- client.expect[GoodsReceipt](req)

    } yield resp
  }

  def listGoodsReceipts(host: String, page: Integer, pageSize: Integer, purchaseOrderId: String, supplierName: String, warehouseId: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], purchaseOrderIdQuery: QueryParam[String], supplierNameQuery: QueryParam[String], warehouseIdQuery: QueryParam[String]): Task[List[GoodsReceipt]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[GoodsReceipt]] = jsonOf[List[GoodsReceipt]]

    val path = "/api/v1/goods-receipts/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("purchaseOrderId", Some(purchase_order_idQuery.toParamString(purchase_order_id))), ("supplierName", Some(supplier_nameQuery.toParamString(supplier_name))), ("warehouseId", Some(warehouse_idQuery.toParamString(warehouse_id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[GoodsReceipt]](req)

    } yield resp
  }

}

class HttpServiceGoodsReceiptApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createGoodsReceipt(goodsReceipt: GoodsReceipt): Task[GoodsReceipt] = {
    implicit val returnTypeDecoder: EntityDecoder[GoodsReceipt] = jsonOf[GoodsReceipt]

    val path = "/api/v1/goods-receipts"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(goodsReceipt)
      resp          <- client.expect[GoodsReceipt](req)

    } yield resp
  }

  def deleteGoodsReceipt(goodsReceiptId: String): Task[Unit] = {
    val path = "/api/v1/goods-receipts/{goods_receipt_id}".replaceAll("\\{" + "goods_receipt_id" + "\\}",escape(goodsReceiptId.toString))

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

  def getGoodsReceipt(goodsReceiptId: String): Task[GoodsReceipt] = {
    implicit val returnTypeDecoder: EntityDecoder[GoodsReceipt] = jsonOf[GoodsReceipt]

    val path = "/api/v1/goods-receipts/{goods_receipt_id}".replaceAll("\\{" + "goods_receipt_id" + "\\}",escape(goodsReceiptId.toString))

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
      resp          <- client.expect[GoodsReceipt](req)

    } yield resp
  }

  def listGoodsReceipts(page: Integer, pageSize: Integer, purchaseOrderId: String, supplierName: String, warehouseId: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], purchaseOrderIdQuery: QueryParam[String], supplierNameQuery: QueryParam[String], warehouseIdQuery: QueryParam[String]): Task[List[GoodsReceipt]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[GoodsReceipt]] = jsonOf[List[GoodsReceipt]]

    val path = "/api/v1/goods-receipts/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("purchaseOrderId", Some(purchase_order_idQuery.toParamString(purchase_order_id))), ("supplierName", Some(supplier_nameQuery.toParamString(supplier_name))), ("warehouseId", Some(warehouse_idQuery.toParamString(warehouse_id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[GoodsReceipt]](req)

    } yield resp
  }

}
