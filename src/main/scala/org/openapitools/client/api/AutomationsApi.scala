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

import org.openapitools.client.api.AutomationDto
import org.openapitools.client.api.UpdateAutomation

object AutomationsApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def listAutomations(host: String): Task[List[AutomationDto]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[AutomationDto]] = jsonOf[List[AutomationDto]]

    val path = "/api/v1/automations"

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
      resp          <- client.expect[List[AutomationDto]](req)

    } yield resp
  }

  def triggerAutomation(host: String, key: String): Task[Any] = {
    implicit val returnTypeDecoder: EntityDecoder[Any] = jsonOf[Any]

    val path = "/api/v1/automations/{key}/trigger".replaceAll("\\{" + "key" + "\\}",escape(key.toString))

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
      resp          <- client.expect[Any](req)

    } yield resp
  }

  def updateAutomation(host: String, key: String, updateAutomation: UpdateAutomation): Task[AutomationDto] = {
    implicit val returnTypeDecoder: EntityDecoder[AutomationDto] = jsonOf[AutomationDto]

    val path = "/api/v1/automations/{key}".replaceAll("\\{" + "key" + "\\}",escape(key.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateAutomation)
      resp          <- client.expect[AutomationDto](req)

    } yield resp
  }

}

class HttpServiceAutomationsApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def listAutomations(): Task[List[AutomationDto]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[AutomationDto]] = jsonOf[List[AutomationDto]]

    val path = "/api/v1/automations"

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
      resp          <- client.expect[List[AutomationDto]](req)

    } yield resp
  }

  def triggerAutomation(key: String): Task[Any] = {
    implicit val returnTypeDecoder: EntityDecoder[Any] = jsonOf[Any]

    val path = "/api/v1/automations/{key}/trigger".replaceAll("\\{" + "key" + "\\}",escape(key.toString))

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
      resp          <- client.expect[Any](req)

    } yield resp
  }

  def updateAutomation(key: String, updateAutomation: UpdateAutomation): Task[AutomationDto] = {
    implicit val returnTypeDecoder: EntityDecoder[AutomationDto] = jsonOf[AutomationDto]

    val path = "/api/v1/automations/{key}".replaceAll("\\{" + "key" + "\\}",escape(key.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateAutomation)
      resp          <- client.expect[AutomationDto](req)

    } yield resp
  }

}
