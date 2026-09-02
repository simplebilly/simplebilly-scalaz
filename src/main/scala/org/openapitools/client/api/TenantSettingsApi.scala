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
import org.openapitools.client.api.TenantSettings
import org.openapitools.client.api.UpdateTenantSettings

object TenantSettingsApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getTenantSettings(host: String): Task[TenantSettings] = {
    implicit val returnTypeDecoder: EntityDecoder[TenantSettings] = jsonOf[TenantSettings]

    val path = "/api/v1/settings/tenant"

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
      resp          <- client.expect[TenantSettings](req)

    } yield resp
  }

  def updateTenantSettings(host: String, updateTenantSettings: UpdateTenantSettings): Task[TenantSettings] = {
    implicit val returnTypeDecoder: EntityDecoder[TenantSettings] = jsonOf[TenantSettings]

    val path = "/api/v1/settings/tenant"

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateTenantSettings)
      resp          <- client.expect[TenantSettings](req)

    } yield resp
  }

}

class HttpServiceTenantSettingsApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getTenantSettings(): Task[TenantSettings] = {
    implicit val returnTypeDecoder: EntityDecoder[TenantSettings] = jsonOf[TenantSettings]

    val path = "/api/v1/settings/tenant"

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
      resp          <- client.expect[TenantSettings](req)

    } yield resp
  }

  def updateTenantSettings(updateTenantSettings: UpdateTenantSettings): Task[TenantSettings] = {
    implicit val returnTypeDecoder: EntityDecoder[TenantSettings] = jsonOf[TenantSettings]

    val path = "/api/v1/settings/tenant"

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateTenantSettings)
      resp          <- client.expect[TenantSettings](req)

    } yield resp
  }

}
