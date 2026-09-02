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

import org.openapitools.client.api.CreateChannelDto
import org.openapitools.client.api.SupportChannel
import java.util.UUID
import org.openapitools.client.api.UpdateChannelDto

object SupportChannelApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createChannelApi(host: String, createChannelDto: CreateChannelDto): Task[SupportChannel] = {
    implicit val returnTypeDecoder: EntityDecoder[SupportChannel] = jsonOf[SupportChannel]

    val path = "/api/v1/support/channels"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(createChannelDto)
      resp          <- client.expect[SupportChannel](req)

    } yield resp
  }

  def deleteChannelApi(host: String, channelId: UUID): Task[Unit] = {
    val path = "/api/v1/support/channels/{channel_id}".replaceAll("\\{" + "channel_id" + "\\}",escape(channelId.toString))

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

  def listChannelsApi(host: String): Task[List[SupportChannel]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[SupportChannel]] = jsonOf[List[SupportChannel]]

    val path = "/api/v1/support/channels"

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
      resp          <- client.expect[List[SupportChannel]](req)

    } yield resp
  }

  def updateChannelApi(host: String, channelId: UUID, updateChannelDto: UpdateChannelDto): Task[SupportChannel] = {
    implicit val returnTypeDecoder: EntityDecoder[SupportChannel] = jsonOf[SupportChannel]

    val path = "/api/v1/support/channels/{channel_id}".replaceAll("\\{" + "channel_id" + "\\}",escape(channelId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateChannelDto)
      resp          <- client.expect[SupportChannel](req)

    } yield resp
  }

}

class HttpServiceSupportChannelApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createChannelApi(createChannelDto: CreateChannelDto): Task[SupportChannel] = {
    implicit val returnTypeDecoder: EntityDecoder[SupportChannel] = jsonOf[SupportChannel]

    val path = "/api/v1/support/channels"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(createChannelDto)
      resp          <- client.expect[SupportChannel](req)

    } yield resp
  }

  def deleteChannelApi(channelId: UUID): Task[Unit] = {
    val path = "/api/v1/support/channels/{channel_id}".replaceAll("\\{" + "channel_id" + "\\}",escape(channelId.toString))

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

  def listChannelsApi(): Task[List[SupportChannel]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[SupportChannel]] = jsonOf[List[SupportChannel]]

    val path = "/api/v1/support/channels"

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
      resp          <- client.expect[List[SupportChannel]](req)

    } yield resp
  }

  def updateChannelApi(channelId: UUID, updateChannelDto: UpdateChannelDto): Task[SupportChannel] = {
    implicit val returnTypeDecoder: EntityDecoder[SupportChannel] = jsonOf[SupportChannel]

    val path = "/api/v1/support/channels/{channel_id}".replaceAll("\\{" + "channel_id" + "\\}",escape(channelId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateChannelDto)
      resp          <- client.expect[SupportChannel](req)

    } yield resp
  }

}
