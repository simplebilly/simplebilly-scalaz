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
import org.openapitools.client.api.ShippingRule
import org.openapitools.client.api.ShippingRuleCreate
import org.openapitools.client.api.ShippingRuleUpdate

object ShippingRuleApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createShippingRule(host: String, shippingRuleCreate: ShippingRuleCreate): Task[ShippingRule] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingRule] = jsonOf[ShippingRule]

    val path = "/api/v1/shipping-rules"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shippingRuleCreate)
      resp          <- client.expect[ShippingRule](req)

    } yield resp
  }

  def deleteShippingRule(host: String, ruleId: String): Task[Unit] = {
    val path = "/api/v1/shipping-rules/{rule_id}".replaceAll("\\{" + "rule_id" + "\\}",escape(ruleId.toString))

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

  def getShippingRule(host: String, ruleId: String): Task[ShippingRule] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingRule] = jsonOf[ShippingRule]

    val path = "/api/v1/shipping-rules/{rule_id}".replaceAll("\\{" + "rule_id" + "\\}",escape(ruleId.toString))

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
      resp          <- client.expect[ShippingRule](req)

    } yield resp
  }

  def listShippingRules(host: String, page: Integer, pageSize: Integer, country: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], countryQuery: QueryParam[String]): Task[List[ShippingRule]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ShippingRule]] = jsonOf[List[ShippingRule]]

    val path = "/api/v1/shipping-rules/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("country", Some(countryQuery.toParamString(country))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ShippingRule]](req)

    } yield resp
  }

  def updateShippingRule(host: String, ruleId: String, shippingRuleUpdate: ShippingRuleUpdate): Task[ShippingRule] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingRule] = jsonOf[ShippingRule]

    val path = "/api/v1/shipping-rules/{rule_id}".replaceAll("\\{" + "rule_id" + "\\}",escape(ruleId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shippingRuleUpdate)
      resp          <- client.expect[ShippingRule](req)

    } yield resp
  }

}

class HttpServiceShippingRuleApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createShippingRule(shippingRuleCreate: ShippingRuleCreate): Task[ShippingRule] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingRule] = jsonOf[ShippingRule]

    val path = "/api/v1/shipping-rules"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shippingRuleCreate)
      resp          <- client.expect[ShippingRule](req)

    } yield resp
  }

  def deleteShippingRule(ruleId: String): Task[Unit] = {
    val path = "/api/v1/shipping-rules/{rule_id}".replaceAll("\\{" + "rule_id" + "\\}",escape(ruleId.toString))

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

  def getShippingRule(ruleId: String): Task[ShippingRule] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingRule] = jsonOf[ShippingRule]

    val path = "/api/v1/shipping-rules/{rule_id}".replaceAll("\\{" + "rule_id" + "\\}",escape(ruleId.toString))

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
      resp          <- client.expect[ShippingRule](req)

    } yield resp
  }

  def listShippingRules(page: Integer, pageSize: Integer, country: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], countryQuery: QueryParam[String]): Task[List[ShippingRule]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ShippingRule]] = jsonOf[List[ShippingRule]]

    val path = "/api/v1/shipping-rules/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("country", Some(countryQuery.toParamString(country))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ShippingRule]](req)

    } yield resp
  }

  def updateShippingRule(ruleId: String, shippingRuleUpdate: ShippingRuleUpdate): Task[ShippingRule] = {
    implicit val returnTypeDecoder: EntityDecoder[ShippingRule] = jsonOf[ShippingRule]

    val path = "/api/v1/shipping-rules/{rule_id}".replaceAll("\\{" + "rule_id" + "\\}",escape(ruleId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(shippingRuleUpdate)
      resp          <- client.expect[ShippingRule](req)

    } yield resp
  }

}
