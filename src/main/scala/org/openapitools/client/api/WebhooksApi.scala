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

import org.openapitools.client.api.CreateSubscriptionRequest
import org.openapitools.client.api.EmitEventRequest
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.UpdateSubscriptionRequest
import org.openapitools.client.api.WebhookEvent
import org.openapitools.client.api.WebhookSubscription

object WebhooksApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createSubscription(host: String, createSubscriptionRequest: CreateSubscriptionRequest): Task[WebhookSubscription] = {
    implicit val returnTypeDecoder: EntityDecoder[WebhookSubscription] = jsonOf[WebhookSubscription]

    val path = "/api/v1/webhook-subscriptions"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(createSubscriptionRequest)
      resp          <- client.expect[WebhookSubscription](req)

    } yield resp
  }

  def deleteSubscription(host: String, subscriptionId: String): Task[Unit] = {
    val path = "/api/v1/webhook-subscriptions/{subscription_id}".replaceAll("\\{" + "subscription_id" + "\\}",escape(subscriptionId.toString))

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

  def emitApi(host: String, emitEventRequest: EmitEventRequest): Task[Unit] = {
    val path = "/api/v1/webhooks/emit"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(emitEventRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def listEvent(host: String): Task[List[WebhookEvent]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[WebhookEvent]] = jsonOf[List[WebhookEvent]]

    val path = "/api/v1/webhook-events"

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
      resp          <- client.expect[List[WebhookEvent]](req)

    } yield resp
  }

  def listSubscriptions(host: String): Task[List[WebhookSubscription]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[WebhookSubscription]] = jsonOf[List[WebhookSubscription]]

    val path = "/api/v1/webhook-subscriptions"

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
      resp          <- client.expect[List[WebhookSubscription]](req)

    } yield resp
  }

  def updateSubscription(host: String, subscriptionId: String, updateSubscriptionRequest: UpdateSubscriptionRequest): Task[WebhookSubscription] = {
    implicit val returnTypeDecoder: EntityDecoder[WebhookSubscription] = jsonOf[WebhookSubscription]

    val path = "/api/v1/webhook-subscriptions/{subscription_id}".replaceAll("\\{" + "subscription_id" + "\\}",escape(subscriptionId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateSubscriptionRequest)
      resp          <- client.expect[WebhookSubscription](req)

    } yield resp
  }

}

class HttpServiceWebhooksApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createSubscription(createSubscriptionRequest: CreateSubscriptionRequest): Task[WebhookSubscription] = {
    implicit val returnTypeDecoder: EntityDecoder[WebhookSubscription] = jsonOf[WebhookSubscription]

    val path = "/api/v1/webhook-subscriptions"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(createSubscriptionRequest)
      resp          <- client.expect[WebhookSubscription](req)

    } yield resp
  }

  def deleteSubscription(subscriptionId: String): Task[Unit] = {
    val path = "/api/v1/webhook-subscriptions/{subscription_id}".replaceAll("\\{" + "subscription_id" + "\\}",escape(subscriptionId.toString))

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

  def emitApi(emitEventRequest: EmitEventRequest): Task[Unit] = {
    val path = "/api/v1/webhooks/emit"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(emitEventRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def listEvent(): Task[List[WebhookEvent]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[WebhookEvent]] = jsonOf[List[WebhookEvent]]

    val path = "/api/v1/webhook-events"

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
      resp          <- client.expect[List[WebhookEvent]](req)

    } yield resp
  }

  def listSubscriptions(): Task[List[WebhookSubscription]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[WebhookSubscription]] = jsonOf[List[WebhookSubscription]]

    val path = "/api/v1/webhook-subscriptions"

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
      resp          <- client.expect[List[WebhookSubscription]](req)

    } yield resp
  }

  def updateSubscription(subscriptionId: String, updateSubscriptionRequest: UpdateSubscriptionRequest): Task[WebhookSubscription] = {
    implicit val returnTypeDecoder: EntityDecoder[WebhookSubscription] = jsonOf[WebhookSubscription]

    val path = "/api/v1/webhook-subscriptions/{subscription_id}".replaceAll("\\{" + "subscription_id" + "\\}",escape(subscriptionId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateSubscriptionRequest)
      resp          <- client.expect[WebhookSubscription](req)

    } yield resp
  }

}
