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

import org.openapitools.client.api.QRCodeResponse

object GenerateQrcodeApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def generateQrcodeApi(host: String, iban: String, id: String, holderName: String, bic: String, amount: String, reference: String, purpose: String)(implicit ibanQuery: QueryParam[String], holderNameQuery: QueryParam[String], bicQuery: QueryParam[String], amountQuery: QueryParam[String], referenceQuery: QueryParam[String], purposeQuery: QueryParam[String]): Task[QRCodeResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[QRCodeResponse] = jsonOf[QRCodeResponse]

    val path = "/api/v1/invoices/{id}/qrcode".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("iban", Some(ibanQuery.toParamString(iban))), ("holderName", Some(holder_nameQuery.toParamString(holder_name))), ("bic", Some(bicQuery.toParamString(bic))), ("amount", Some(amountQuery.toParamString(amount))), ("reference", Some(referenceQuery.toParamString(reference))), ("purpose", Some(purposeQuery.toParamString(purpose))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[QRCodeResponse](req)

    } yield resp
  }

}

class HttpServiceGenerateQrcodeApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def generateQrcodeApi(iban: String, id: String, holderName: String, bic: String, amount: String, reference: String, purpose: String)(implicit ibanQuery: QueryParam[String], holderNameQuery: QueryParam[String], bicQuery: QueryParam[String], amountQuery: QueryParam[String], referenceQuery: QueryParam[String], purposeQuery: QueryParam[String]): Task[QRCodeResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[QRCodeResponse] = jsonOf[QRCodeResponse]

    val path = "/api/v1/invoices/{id}/qrcode".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("iban", Some(ibanQuery.toParamString(iban))), ("holderName", Some(holder_nameQuery.toParamString(holder_name))), ("bic", Some(bicQuery.toParamString(bic))), ("amount", Some(amountQuery.toParamString(amount))), ("reference", Some(referenceQuery.toParamString(reference))), ("purpose", Some(purposeQuery.toParamString(purpose))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[QRCodeResponse](req)

    } yield resp
  }

}
