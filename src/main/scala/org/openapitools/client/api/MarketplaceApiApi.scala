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

import org.openapitools.client.api.CreateConnectionRequest
import org.openapitools.client.api.MarketplaceConnection
import org.openapitools.client.api.OAuthAuthorizeRequest
import org.openapitools.client.api.OAuthAuthorizeResponse
import org.openapitools.client.api.OAuthCallbackRequest
import org.openapitools.client.api.PlatformInfo
import org.openapitools.client.api.SyncLog
import org.openapitools.client.api.SyncSummary
import org.openapitools.client.api.UpdateConnectionRequest
import org.openapitools.client.api.UpdateSyncDirectionRequest

object MarketplaceApiApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createConnectionApi(host: String, createConnectionRequest: CreateConnectionRequest): Task[MarketplaceConnection] = {
    implicit val returnTypeDecoder: EntityDecoder[MarketplaceConnection] = jsonOf[MarketplaceConnection]

    val path = "/api/v1/marketplace/connections"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(createConnectionRequest)
      resp          <- client.expect[MarketplaceConnection](req)

    } yield resp
  }

  def deleteConnectionApi(host: String, connectionId: String): Task[Unit] = {
    val path = "/api/v1/marketplace/connections/{connection_id}".replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

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

  def getConnectionApi(host: String, connectionId: String): Task[MarketplaceConnection] = {
    implicit val returnTypeDecoder: EntityDecoder[MarketplaceConnection] = jsonOf[MarketplaceConnection]

    val path = "/api/v1/marketplace/connections/{connection_id}".replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

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
      resp          <- client.expect[MarketplaceConnection](req)

    } yield resp
  }

  def getSyncDirectionApi(host: String, connectionId: String): Task[Unit] = {
    val path = "/api/v1/marketplace/connections/{connection_id}/directions".replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def getSyncLogsApi(host: String, connectionId: String): Task[List[SyncLog]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[SyncLog]] = jsonOf[List[SyncLog]]

    val path = "/api/v1/marketplace/connections/{connection_id}/logs".replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

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
      resp          <- client.expect[List[SyncLog]](req)

    } yield resp
  }

  def listConnectionsApi(host: String): Task[List[MarketplaceConnection]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[MarketplaceConnection]] = jsonOf[List[MarketplaceConnection]]

    val path = "/api/v1/marketplace/connections"

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
      resp          <- client.expect[List[MarketplaceConnection]](req)

    } yield resp
  }

  def listPlatformsApi(host: String): Task[List[PlatformInfo]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PlatformInfo]] = jsonOf[List[PlatformInfo]]

    val path = "/api/v1/marketplace/platforms"

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
      resp          <- client.expect[List[PlatformInfo]](req)

    } yield resp
  }

  def oauthAuthorizeApi(host: String, oAuthAuthorizeRequest: OAuthAuthorizeRequest): Task[OAuthAuthorizeResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[OAuthAuthorizeResponse] = jsonOf[OAuthAuthorizeResponse]

    val path = "/api/v1/marketplace/oauth/authorize"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(oAuthAuthorizeRequest)
      resp          <- client.expect[OAuthAuthorizeResponse](req)

    } yield resp
  }

  def oauthCallbackApi(host: String, oAuthCallbackRequest: OAuthCallbackRequest): Task[MarketplaceConnection] = {
    implicit val returnTypeDecoder: EntityDecoder[MarketplaceConnection] = jsonOf[MarketplaceConnection]

    val path = "/api/v1/marketplace/oauth/callback"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(oAuthCallbackRequest)
      resp          <- client.expect[MarketplaceConnection](req)

    } yield resp
  }

  def triggerSyncApi(host: String, connectionId: String, syncType: String, direction: String)(implicit syncTypeQuery: QueryParam[String], directionQuery: QueryParam[String]): Task[SyncSummary] = {
    implicit val returnTypeDecoder: EntityDecoder[SyncSummary] = jsonOf[SyncSummary]

    val path = "/api/v1/marketplace/connections/{connection_id}/sync".replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("syncType", Some(sync_typeQuery.toParamString(sync_type))), ("direction", Some(directionQuery.toParamString(direction))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[SyncSummary](req)

    } yield resp
  }

  def updateConnectionApi(host: String, connectionId: String, updateConnectionRequest: UpdateConnectionRequest): Task[MarketplaceConnection] = {
    implicit val returnTypeDecoder: EntityDecoder[MarketplaceConnection] = jsonOf[MarketplaceConnection]

    val path = "/api/v1/marketplace/connections/{connection_id}".replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateConnectionRequest)
      resp          <- client.expect[MarketplaceConnection](req)

    } yield resp
  }

  def updateSyncDirectionApi(host: String, connectionId: String, updateSyncDirectionRequest: UpdateSyncDirectionRequest): Task[Unit] = {
    val path = "/api/v1/marketplace/connections/{connection_id}/directions".replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateSyncDirectionRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def webhookReceiverApi(host: String, platform: String, connectionId: String): Task[Unit] = {
    val path = "/api/v1/marketplace/webhook/{platform}/{connection_id}".replaceAll("\\{" + "platform" + "\\}",escape(platform.toString)).replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

}

class HttpServiceMarketplaceApiApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createConnectionApi(createConnectionRequest: CreateConnectionRequest): Task[MarketplaceConnection] = {
    implicit val returnTypeDecoder: EntityDecoder[MarketplaceConnection] = jsonOf[MarketplaceConnection]

    val path = "/api/v1/marketplace/connections"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(createConnectionRequest)
      resp          <- client.expect[MarketplaceConnection](req)

    } yield resp
  }

  def deleteConnectionApi(connectionId: String): Task[Unit] = {
    val path = "/api/v1/marketplace/connections/{connection_id}".replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

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

  def getConnectionApi(connectionId: String): Task[MarketplaceConnection] = {
    implicit val returnTypeDecoder: EntityDecoder[MarketplaceConnection] = jsonOf[MarketplaceConnection]

    val path = "/api/v1/marketplace/connections/{connection_id}".replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

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
      resp          <- client.expect[MarketplaceConnection](req)

    } yield resp
  }

  def getSyncDirectionApi(connectionId: String): Task[Unit] = {
    val path = "/api/v1/marketplace/connections/{connection_id}/directions".replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def getSyncLogsApi(connectionId: String): Task[List[SyncLog]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[SyncLog]] = jsonOf[List[SyncLog]]

    val path = "/api/v1/marketplace/connections/{connection_id}/logs".replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

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
      resp          <- client.expect[List[SyncLog]](req)

    } yield resp
  }

  def listConnectionsApi(): Task[List[MarketplaceConnection]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[MarketplaceConnection]] = jsonOf[List[MarketplaceConnection]]

    val path = "/api/v1/marketplace/connections"

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
      resp          <- client.expect[List[MarketplaceConnection]](req)

    } yield resp
  }

  def listPlatformsApi(): Task[List[PlatformInfo]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PlatformInfo]] = jsonOf[List[PlatformInfo]]

    val path = "/api/v1/marketplace/platforms"

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
      resp          <- client.expect[List[PlatformInfo]](req)

    } yield resp
  }

  def oauthAuthorizeApi(oAuthAuthorizeRequest: OAuthAuthorizeRequest): Task[OAuthAuthorizeResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[OAuthAuthorizeResponse] = jsonOf[OAuthAuthorizeResponse]

    val path = "/api/v1/marketplace/oauth/authorize"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(oAuthAuthorizeRequest)
      resp          <- client.expect[OAuthAuthorizeResponse](req)

    } yield resp
  }

  def oauthCallbackApi(oAuthCallbackRequest: OAuthCallbackRequest): Task[MarketplaceConnection] = {
    implicit val returnTypeDecoder: EntityDecoder[MarketplaceConnection] = jsonOf[MarketplaceConnection]

    val path = "/api/v1/marketplace/oauth/callback"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(oAuthCallbackRequest)
      resp          <- client.expect[MarketplaceConnection](req)

    } yield resp
  }

  def triggerSyncApi(connectionId: String, syncType: String, direction: String)(implicit syncTypeQuery: QueryParam[String], directionQuery: QueryParam[String]): Task[SyncSummary] = {
    implicit val returnTypeDecoder: EntityDecoder[SyncSummary] = jsonOf[SyncSummary]

    val path = "/api/v1/marketplace/connections/{connection_id}/sync".replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("syncType", Some(sync_typeQuery.toParamString(sync_type))), ("direction", Some(directionQuery.toParamString(direction))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[SyncSummary](req)

    } yield resp
  }

  def updateConnectionApi(connectionId: String, updateConnectionRequest: UpdateConnectionRequest): Task[MarketplaceConnection] = {
    implicit val returnTypeDecoder: EntityDecoder[MarketplaceConnection] = jsonOf[MarketplaceConnection]

    val path = "/api/v1/marketplace/connections/{connection_id}".replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateConnectionRequest)
      resp          <- client.expect[MarketplaceConnection](req)

    } yield resp
  }

  def updateSyncDirectionApi(connectionId: String, updateSyncDirectionRequest: UpdateSyncDirectionRequest): Task[Unit] = {
    val path = "/api/v1/marketplace/connections/{connection_id}/directions".replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateSyncDirectionRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def webhookReceiverApi(platform: String, connectionId: String): Task[Unit] = {
    val path = "/api/v1/marketplace/webhook/{platform}/{connection_id}".replaceAll("\\{" + "platform" + "\\}",escape(platform.toString)).replaceAll("\\{" + "connection_id" + "\\}",escape(connectionId.toString))

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

}
