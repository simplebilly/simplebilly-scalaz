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
import org.openapitools.client.api.PriceTier
import org.openapitools.client.api.PriceTierCreate
import org.openapitools.client.api.PriceTierUpdate
import org.openapitools.client.api.ResolvedPriceResponse
import java.util.UUID

object PriceTierApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createPriceTier(host: String, priceTierCreate: PriceTierCreate): Task[PriceTier] = {
    implicit val returnTypeDecoder: EntityDecoder[PriceTier] = jsonOf[PriceTier]

    val path = "/api/v1/price-tiers"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(priceTierCreate)
      resp          <- client.expect[PriceTier](req)

    } yield resp
  }

  def deletePriceTier(host: String, priceTierId: String): Task[Unit] = {
    val path = "/api/v1/price-tiers/{price_tier_id}".replaceAll("\\{" + "price_tier_id" + "\\}",escape(priceTierId.toString))

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

  def getPriceTier(host: String, priceTierId: String): Task[PriceTier] = {
    implicit val returnTypeDecoder: EntityDecoder[PriceTier] = jsonOf[PriceTier]

    val path = "/api/v1/price-tiers/{price_tier_id}".replaceAll("\\{" + "price_tier_id" + "\\}",escape(priceTierId.toString))

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
      resp          <- client.expect[PriceTier](req)

    } yield resp
  }

  def getResolvedPrice(host: String, productId: UUID, quantity: Long, contactId: String)(implicit productIdQuery: QueryParam[UUID], quantityQuery: QueryParam[Long], contactIdQuery: QueryParam[String]): Task[ResolvedPriceResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ResolvedPriceResponse] = jsonOf[ResolvedPriceResponse]

    val path = "/api/v1/price-tiers/resolved"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("productId", Some(productIdQuery.toParamString(productId))), ("quantity", Some(quantityQuery.toParamString(quantity))), ("contactId", Some(contactIdQuery.toParamString(contactId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[ResolvedPriceResponse](req)

    } yield resp
  }

  def listPriceTiers(host: String, page: Integer, pageSize: Integer, productId: UUID, customerGroupId: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], productIdQuery: QueryParam[UUID], customerGroupIdQuery: QueryParam[String]): Task[List[PriceTier]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PriceTier]] = jsonOf[List[PriceTier]]

    val path = "/api/v1/price-tiers/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("productId", Some(product_idQuery.toParamString(product_id))), ("customerGroupId", Some(customer_group_idQuery.toParamString(customer_group_id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[PriceTier]](req)

    } yield resp
  }

  def updatePriceTier(host: String, priceTierId: String, priceTierUpdate: PriceTierUpdate): Task[PriceTier] = {
    implicit val returnTypeDecoder: EntityDecoder[PriceTier] = jsonOf[PriceTier]

    val path = "/api/v1/price-tiers/{price_tier_id}".replaceAll("\\{" + "price_tier_id" + "\\}",escape(priceTierId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(priceTierUpdate)
      resp          <- client.expect[PriceTier](req)

    } yield resp
  }

}

class HttpServicePriceTierApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createPriceTier(priceTierCreate: PriceTierCreate): Task[PriceTier] = {
    implicit val returnTypeDecoder: EntityDecoder[PriceTier] = jsonOf[PriceTier]

    val path = "/api/v1/price-tiers"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(priceTierCreate)
      resp          <- client.expect[PriceTier](req)

    } yield resp
  }

  def deletePriceTier(priceTierId: String): Task[Unit] = {
    val path = "/api/v1/price-tiers/{price_tier_id}".replaceAll("\\{" + "price_tier_id" + "\\}",escape(priceTierId.toString))

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

  def getPriceTier(priceTierId: String): Task[PriceTier] = {
    implicit val returnTypeDecoder: EntityDecoder[PriceTier] = jsonOf[PriceTier]

    val path = "/api/v1/price-tiers/{price_tier_id}".replaceAll("\\{" + "price_tier_id" + "\\}",escape(priceTierId.toString))

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
      resp          <- client.expect[PriceTier](req)

    } yield resp
  }

  def getResolvedPrice(productId: UUID, quantity: Long, contactId: String)(implicit productIdQuery: QueryParam[UUID], quantityQuery: QueryParam[Long], contactIdQuery: QueryParam[String]): Task[ResolvedPriceResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ResolvedPriceResponse] = jsonOf[ResolvedPriceResponse]

    val path = "/api/v1/price-tiers/resolved"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("productId", Some(productIdQuery.toParamString(productId))), ("quantity", Some(quantityQuery.toParamString(quantity))), ("contactId", Some(contactIdQuery.toParamString(contactId))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[ResolvedPriceResponse](req)

    } yield resp
  }

  def listPriceTiers(page: Integer, pageSize: Integer, productId: UUID, customerGroupId: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], productIdQuery: QueryParam[UUID], customerGroupIdQuery: QueryParam[String]): Task[List[PriceTier]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PriceTier]] = jsonOf[List[PriceTier]]

    val path = "/api/v1/price-tiers/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("productId", Some(product_idQuery.toParamString(product_id))), ("customerGroupId", Some(customer_group_idQuery.toParamString(customer_group_id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[PriceTier]](req)

    } yield resp
  }

  def updatePriceTier(priceTierId: String, priceTierUpdate: PriceTierUpdate): Task[PriceTier] = {
    implicit val returnTypeDecoder: EntityDecoder[PriceTier] = jsonOf[PriceTier]

    val path = "/api/v1/price-tiers/{price_tier_id}".replaceAll("\\{" + "price_tier_id" + "\\}",escape(priceTierId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(priceTierUpdate)
      resp          <- client.expect[PriceTier](req)

    } yield resp
  }

}
