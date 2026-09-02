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
import org.openapitools.client.api.GenerateVariantsRequest
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.ProductVariant
import java.util.UUID

object ProductVariantApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createProductVariant(host: String, productVariant: ProductVariant): Task[ProductVariant] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductVariant] = jsonOf[ProductVariant]

    val path = "/api/v1/product-variants"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productVariant)
      resp          <- client.expect[ProductVariant](req)

    } yield resp
  }

  def deleteProductVariant(host: String, variantId: String): Task[Unit] = {
    val path = "/api/v1/product-variants/{variant_id}".replaceAll("\\{" + "variant_id" + "\\}",escape(variantId.toString))

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

  def generateProductVariants(host: String, generateVariantsRequest: GenerateVariantsRequest): Task[List[ProductVariant]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ProductVariant]] = jsonOf[List[ProductVariant]]

    val path = "/api/v1/product-variants/generate"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(generateVariantsRequest)
      resp          <- client.expect[List[ProductVariant]](req)

    } yield resp
  }

  def getProductVariant(host: String, variantId: String): Task[ProductVariant] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductVariant] = jsonOf[ProductVariant]

    val path = "/api/v1/product-variants/{variant_id}".replaceAll("\\{" + "variant_id" + "\\}",escape(variantId.toString))

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
      resp          <- client.expect[ProductVariant](req)

    } yield resp
  }

  def listProductVariants(host: String, page: Integer, pageSize: Integer, productId: UUID, isActive: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], productIdQuery: QueryParam[UUID], isActiveQuery: QueryParam[Boolean]): Task[List[ProductVariant]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ProductVariant]] = jsonOf[List[ProductVariant]]

    val path = "/api/v1/product-variants/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("productId", Some(product_idQuery.toParamString(product_id))), ("isActive", Some(is_activeQuery.toParamString(is_active))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ProductVariant]](req)

    } yield resp
  }

  def updateProductVariant(host: String, variantId: String, body: AnyType): Task[ProductVariant] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductVariant] = jsonOf[ProductVariant]

    val path = "/api/v1/product-variants/{variant_id}".replaceAll("\\{" + "variant_id" + "\\}",escape(variantId.toString))

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
      resp          <- client.expect[ProductVariant](req)

    } yield resp
  }

}

class HttpServiceProductVariantApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createProductVariant(productVariant: ProductVariant): Task[ProductVariant] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductVariant] = jsonOf[ProductVariant]

    val path = "/api/v1/product-variants"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(productVariant)
      resp          <- client.expect[ProductVariant](req)

    } yield resp
  }

  def deleteProductVariant(variantId: String): Task[Unit] = {
    val path = "/api/v1/product-variants/{variant_id}".replaceAll("\\{" + "variant_id" + "\\}",escape(variantId.toString))

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

  def generateProductVariants(generateVariantsRequest: GenerateVariantsRequest): Task[List[ProductVariant]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ProductVariant]] = jsonOf[List[ProductVariant]]

    val path = "/api/v1/product-variants/generate"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(generateVariantsRequest)
      resp          <- client.expect[List[ProductVariant]](req)

    } yield resp
  }

  def getProductVariant(variantId: String): Task[ProductVariant] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductVariant] = jsonOf[ProductVariant]

    val path = "/api/v1/product-variants/{variant_id}".replaceAll("\\{" + "variant_id" + "\\}",escape(variantId.toString))

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
      resp          <- client.expect[ProductVariant](req)

    } yield resp
  }

  def listProductVariants(page: Integer, pageSize: Integer, productId: UUID, isActive: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], productIdQuery: QueryParam[UUID], isActiveQuery: QueryParam[Boolean]): Task[List[ProductVariant]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ProductVariant]] = jsonOf[List[ProductVariant]]

    val path = "/api/v1/product-variants/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("productId", Some(product_idQuery.toParamString(product_id))), ("isActive", Some(is_activeQuery.toParamString(is_active))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ProductVariant]](req)

    } yield resp
  }

  def updateProductVariant(variantId: String, body: AnyType): Task[ProductVariant] = {
    implicit val returnTypeDecoder: EntityDecoder[ProductVariant] = jsonOf[ProductVariant]

    val path = "/api/v1/product-variants/{variant_id}".replaceAll("\\{" + "variant_id" + "\\}",escape(variantId.toString))

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
      resp          <- client.expect[ProductVariant](req)

    } yield resp
  }

}
