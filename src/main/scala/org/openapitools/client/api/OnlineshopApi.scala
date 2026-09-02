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
import org.openapitools.client.api.SmtpConfig

object OnlineshopApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getSmtpConfigApi(host: String): Task[SmtpConfig] = {
    implicit val returnTypeDecoder: EntityDecoder[SmtpConfig] = jsonOf[SmtpConfig]

    val path = "/api/v1/settings/smtp"

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
      resp          <- client.expect[SmtpConfig](req)

    } yield resp
  }

  def saveSmtpConfigApi(host: String, smtpConfig: SmtpConfig): Task[SmtpConfig] = {
    implicit val returnTypeDecoder: EntityDecoder[SmtpConfig] = jsonOf[SmtpConfig]

    val path = "/api/v1/settings/smtp"

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(smtpConfig)
      resp          <- client.expect[SmtpConfig](req)

    } yield resp
  }

}

class HttpServiceOnlineshopApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getSmtpConfigApi(): Task[SmtpConfig] = {
    implicit val returnTypeDecoder: EntityDecoder[SmtpConfig] = jsonOf[SmtpConfig]

    val path = "/api/v1/settings/smtp"

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
      resp          <- client.expect[SmtpConfig](req)

    } yield resp
  }

  def saveSmtpConfigApi(smtpConfig: SmtpConfig): Task[SmtpConfig] = {
    implicit val returnTypeDecoder: EntityDecoder[SmtpConfig] = jsonOf[SmtpConfig]

    val path = "/api/v1/settings/smtp"

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(smtpConfig)
      resp          <- client.expect[SmtpConfig](req)

    } yield resp
  }

}
