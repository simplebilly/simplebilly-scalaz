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

import org.openapitools.client.api.Coupon
import org.openapitools.client.api.CouponCreate
import org.openapitools.client.api.CouponUpdate
import org.openapitools.client.api.PluginError

object CouponApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def couponRestore(host: String, couponId: String): Task[Coupon] = {
    implicit val returnTypeDecoder: EntityDecoder[Coupon] = jsonOf[Coupon]

    val path = "/api/v1/coupons/{coupon_id}/restore".replaceAll("\\{" + "coupon_id" + "\\}",escape(couponId.toString))

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
      resp          <- client.expect[Coupon](req)

    } yield resp
  }

  def createCoupon(host: String, couponCreate: CouponCreate): Task[Coupon] = {
    implicit val returnTypeDecoder: EntityDecoder[Coupon] = jsonOf[Coupon]

    val path = "/api/v1/coupons"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(couponCreate)
      resp          <- client.expect[Coupon](req)

    } yield resp
  }

  def deleteCoupon(host: String, couponId: String): Task[Unit] = {
    val path = "/api/v1/coupons/{coupon_id}".replaceAll("\\{" + "coupon_id" + "\\}",escape(couponId.toString))

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

  def getCoupon(host: String, couponId: String): Task[Coupon] = {
    implicit val returnTypeDecoder: EntityDecoder[Coupon] = jsonOf[Coupon]

    val path = "/api/v1/coupons/{coupon_id}".replaceAll("\\{" + "coupon_id" + "\\}",escape(couponId.toString))

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
      resp          <- client.expect[Coupon](req)

    } yield resp
  }

  def listCoupons(host: String, page: Integer, pageSize: Integer, isActive: Boolean, code: String, discountType: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], isActiveQuery: QueryParam[Boolean], codeQuery: QueryParam[String], discountTypeQuery: QueryParam[String]): Task[List[Coupon]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Coupon]] = jsonOf[List[Coupon]]

    val path = "/api/v1/coupons/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("isActive", Some(is_activeQuery.toParamString(is_active))), ("code", Some(codeQuery.toParamString(code))), ("discountType", Some(discount_typeQuery.toParamString(discount_type))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Coupon]](req)

    } yield resp
  }

  def updateCoupon(host: String, couponId: String, couponUpdate: CouponUpdate): Task[Coupon] = {
    implicit val returnTypeDecoder: EntityDecoder[Coupon] = jsonOf[Coupon]

    val path = "/api/v1/coupons/{coupon_id}".replaceAll("\\{" + "coupon_id" + "\\}",escape(couponId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(couponUpdate)
      resp          <- client.expect[Coupon](req)

    } yield resp
  }

}

class HttpServiceCouponApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def couponRestore(couponId: String): Task[Coupon] = {
    implicit val returnTypeDecoder: EntityDecoder[Coupon] = jsonOf[Coupon]

    val path = "/api/v1/coupons/{coupon_id}/restore".replaceAll("\\{" + "coupon_id" + "\\}",escape(couponId.toString))

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
      resp          <- client.expect[Coupon](req)

    } yield resp
  }

  def createCoupon(couponCreate: CouponCreate): Task[Coupon] = {
    implicit val returnTypeDecoder: EntityDecoder[Coupon] = jsonOf[Coupon]

    val path = "/api/v1/coupons"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(couponCreate)
      resp          <- client.expect[Coupon](req)

    } yield resp
  }

  def deleteCoupon(couponId: String): Task[Unit] = {
    val path = "/api/v1/coupons/{coupon_id}".replaceAll("\\{" + "coupon_id" + "\\}",escape(couponId.toString))

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

  def getCoupon(couponId: String): Task[Coupon] = {
    implicit val returnTypeDecoder: EntityDecoder[Coupon] = jsonOf[Coupon]

    val path = "/api/v1/coupons/{coupon_id}".replaceAll("\\{" + "coupon_id" + "\\}",escape(couponId.toString))

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
      resp          <- client.expect[Coupon](req)

    } yield resp
  }

  def listCoupons(page: Integer, pageSize: Integer, isActive: Boolean, code: String, discountType: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], isActiveQuery: QueryParam[Boolean], codeQuery: QueryParam[String], discountTypeQuery: QueryParam[String]): Task[List[Coupon]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Coupon]] = jsonOf[List[Coupon]]

    val path = "/api/v1/coupons/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("isActive", Some(is_activeQuery.toParamString(is_active))), ("code", Some(codeQuery.toParamString(code))), ("discountType", Some(discount_typeQuery.toParamString(discount_type))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Coupon]](req)

    } yield resp
  }

  def updateCoupon(couponId: String, couponUpdate: CouponUpdate): Task[Coupon] = {
    implicit val returnTypeDecoder: EntityDecoder[Coupon] = jsonOf[Coupon]

    val path = "/api/v1/coupons/{coupon_id}".replaceAll("\\{" + "coupon_id" + "\\}",escape(couponId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(couponUpdate)
      resp          <- client.expect[Coupon](req)

    } yield resp
  }

}
