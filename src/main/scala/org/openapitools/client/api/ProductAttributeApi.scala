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
import org.openapitools.client.api.ProductAttribute
import org.openapitools.client.api.ProductAttributeCreate
import org.openapitools.client.api.ProductAttributeUpdate
import java.util.UUID

object ProductAttributeApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createProductAttribute(host: String, productAttributeCreate: ProductAttributeCreate): Task[ProductAttribute] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductAttribute] = jsonOf[ProductAttribute]

    val path = "/api/v1/product-attributes"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productAttributeCreate)
      resp          <- client.expect[ProductAttribute](req)

    } yield resp
  }

  def deleteProductAttribute(host: String, attributeId: String): Task[Unit] = {
    val path = "/api/v1/product-attributes/{attribute_id}".replaceAll("\\{" + "attribute_id" + "\\}",escape(attributeId.toString))

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

  def getProductAttribute(host: String, attributeId: String): Task[ProductAttribute] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductAttribute] = jsonOf[ProductAttribute]

    val path = "/api/v1/product-attributes/{attribute_id}".replaceAll("\\{" + "attribute_id" + "\\}",escape(attributeId.toString))

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
      resp          <- client.expect[ProductAttribute](req)

    } yield resp
  }

  def listProductAttributes(host: String, page: Integer, pageSize: Integer, productId: UUID, isFilterable: Boolean, search: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], productIdQuery: QueryParam[UUID], isFilterableQuery: QueryParam[Boolean], searchQuery: QueryParam[String]): Task[List[ProductAttribute]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ProductAttribute]] = jsonOf[List[ProductAttribute]]

    val path = "/api/v1/product-attributes/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("productId", Some(product_idQuery.toParamString(product_id))), ("isFilterable", Some(is_filterableQuery.toParamString(is_filterable))), ("search", Some(searchQuery.toParamString(search))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ProductAttribute]](req)

    } yield resp
  }

  def updateProductAttribute(host: String, attributeId: String, productAttributeUpdate: ProductAttributeUpdate): Task[ProductAttribute] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductAttribute] = jsonOf[ProductAttribute]

    val path = "/api/v1/product-attributes/{attribute_id}".replaceAll("\\{" + "attribute_id" + "\\}",escape(attributeId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productAttributeUpdate)
      resp          <- client.expect[ProductAttribute](req)

    } yield resp
  }

}

class HttpServiceProductAttributeApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createProductAttribute(productAttributeCreate: ProductAttributeCreate): Task[ProductAttribute] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductAttribute] = jsonOf[ProductAttribute]

    val path = "/api/v1/product-attributes"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productAttributeCreate)
      resp          <- client.expect[ProductAttribute](req)

    } yield resp
  }

  def deleteProductAttribute(attributeId: String): Task[Unit] = {
    val path = "/api/v1/product-attributes/{attribute_id}".replaceAll("\\{" + "attribute_id" + "\\}",escape(attributeId.toString))

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

  def getProductAttribute(attributeId: String): Task[ProductAttribute] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductAttribute] = jsonOf[ProductAttribute]

    val path = "/api/v1/product-attributes/{attribute_id}".replaceAll("\\{" + "attribute_id" + "\\}",escape(attributeId.toString))

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
      resp          <- client.expect[ProductAttribute](req)

    } yield resp
  }

  def listProductAttributes(page: Integer, pageSize: Integer, productId: UUID, isFilterable: Boolean, search: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], productIdQuery: QueryParam[UUID], isFilterableQuery: QueryParam[Boolean], searchQuery: QueryParam[String]): Task[List[ProductAttribute]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ProductAttribute]] = jsonOf[List[ProductAttribute]]

    val path = "/api/v1/product-attributes/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("productId", Some(product_idQuery.toParamString(product_id))), ("isFilterable", Some(is_filterableQuery.toParamString(is_filterable))), ("search", Some(searchQuery.toParamString(search))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ProductAttribute]](req)

    } yield resp
  }

  def updateProductAttribute(attributeId: String, productAttributeUpdate: ProductAttributeUpdate): Task[ProductAttribute] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductAttribute] = jsonOf[ProductAttribute]

    val path = "/api/v1/product-attributes/{attribute_id}".replaceAll("\\{" + "attribute_id" + "\\}",escape(attributeId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productAttributeUpdate)
      resp          <- client.expect[ProductAttribute](req)

    } yield resp
  }

}
