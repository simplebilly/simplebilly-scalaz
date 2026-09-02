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
import org.openapitools.client.api.Product
import org.openapitools.client.api.ProductCreate
import org.openapitools.client.api.ProductStock
import org.openapitools.client.api.ProductUpdate
import org.openapitools.client.api.StockUpdateRequest
import java.util.UUID

object ProductApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createProductApi(host: String, productCreate: ProductCreate): Task[Product] = {
    implicit val returnTypeDecoder: EntityDecoder[Product] = jsonOf[Product]

    val path = "/api/v1/products"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productCreate)
      resp          <- client.expect[Product](req)

    } yield resp
  }

  def deleteProductApi(host: String, productId: UUID): Task[Unit] = {
    val path = "/api/v1/products/{product_id}".replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

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

  def getProductApi(host: String, productId: UUID): Task[Product] = {
    implicit val returnTypeDecoder: EntityDecoder[Product] = jsonOf[Product]

    val path = "/api/v1/products/{product_id}".replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

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
      resp          <- client.expect[Product](req)

    } yield resp
  }

  def getProductStockApi(host: String, productId: UUID): Task[ProductStock] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductStock] = jsonOf[ProductStock]

    val path = "/api/v1/products/{product_id}/stock".replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

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
      resp          <- client.expect[ProductStock](req)

    } yield resp
  }

  def getProductsApi(host: String, page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[Product]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Product]] = jsonOf[List[Product]]

    val path = "/api/v1/products/"

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
      resp          <- client.expect[List[Product]](req)

    } yield resp
  }

  def listLowStockProductsApi(host: String, threshold: Long)(implicit thresholdQuery: QueryParam[Long]): Task[List[ProductStock]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ProductStock]] = jsonOf[List[ProductStock]]

    val path = "/api/v1/products/low-stock"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("threshold", Some(thresholdQuery.toParamString(threshold))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ProductStock]](req)

    } yield resp
  }

  def productRestore(host: String, productId: UUID): Task[Product] = {
    implicit val returnTypeDecoder: EntityDecoder[Product] = jsonOf[Product]

    val path = "/api/v1/products/{product_id}/restore".replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

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
      resp          <- client.expect[Product](req)

    } yield resp
  }

  def updateProductApi(host: String, productId: UUID, productUpdate: ProductUpdate): Task[Product] = {
    implicit val returnTypeDecoder: EntityDecoder[Product] = jsonOf[Product]

    val path = "/api/v1/products/{product_id}".replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productUpdate)
      resp          <- client.expect[Product](req)

    } yield resp
  }

  def updateProductStockApi(host: String, productId: UUID, stockUpdateRequest: StockUpdateRequest): Task[ProductStock] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductStock] = jsonOf[ProductStock]

    val path = "/api/v1/products/{product_id}/stock".replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(stockUpdateRequest)
      resp          <- client.expect[ProductStock](req)

    } yield resp
  }

}

class HttpServiceProductApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createProductApi(productCreate: ProductCreate): Task[Product] = {
    implicit val returnTypeDecoder: EntityDecoder[Product] = jsonOf[Product]

    val path = "/api/v1/products"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productCreate)
      resp          <- client.expect[Product](req)

    } yield resp
  }

  def deleteProductApi(productId: UUID): Task[Unit] = {
    val path = "/api/v1/products/{product_id}".replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

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

  def getProductApi(productId: UUID): Task[Product] = {
    implicit val returnTypeDecoder: EntityDecoder[Product] = jsonOf[Product]

    val path = "/api/v1/products/{product_id}".replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

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
      resp          <- client.expect[Product](req)

    } yield resp
  }

  def getProductStockApi(productId: UUID): Task[ProductStock] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductStock] = jsonOf[ProductStock]

    val path = "/api/v1/products/{product_id}/stock".replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

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
      resp          <- client.expect[ProductStock](req)

    } yield resp
  }

  def getProductsApi(page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[Product]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Product]] = jsonOf[List[Product]]

    val path = "/api/v1/products/"

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
      resp          <- client.expect[List[Product]](req)

    } yield resp
  }

  def listLowStockProductsApi(threshold: Long)(implicit thresholdQuery: QueryParam[Long]): Task[List[ProductStock]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ProductStock]] = jsonOf[List[ProductStock]]

    val path = "/api/v1/products/low-stock"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("threshold", Some(thresholdQuery.toParamString(threshold))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ProductStock]](req)

    } yield resp
  }

  def productRestore(productId: UUID): Task[Product] = {
    implicit val returnTypeDecoder: EntityDecoder[Product] = jsonOf[Product]

    val path = "/api/v1/products/{product_id}/restore".replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

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
      resp          <- client.expect[Product](req)

    } yield resp
  }

  def updateProductApi(productId: UUID, productUpdate: ProductUpdate): Task[Product] = {
    implicit val returnTypeDecoder: EntityDecoder[Product] = jsonOf[Product]

    val path = "/api/v1/products/{product_id}".replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productUpdate)
      resp          <- client.expect[Product](req)

    } yield resp
  }

  def updateProductStockApi(productId: UUID, stockUpdateRequest: StockUpdateRequest): Task[ProductStock] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductStock] = jsonOf[ProductStock]

    val path = "/api/v1/products/{product_id}/stock".replaceAll("\\{" + "product_id" + "\\}",escape(productId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(stockUpdateRequest)
      resp          <- client.expect[ProductStock](req)

    } yield resp
  }

}
