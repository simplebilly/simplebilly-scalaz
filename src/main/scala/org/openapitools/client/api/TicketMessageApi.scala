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

import org.openapitools.client.api.SendMessageDto
import org.openapitools.client.api.TicketMessage
import java.util.UUID

object TicketMessageApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def listMessagesApi(host: String, ticketId: UUID): Task[List[TicketMessage]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[TicketMessage]] = jsonOf[List[TicketMessage]]

    val path = "/api/v1/support/tickets/{ticket_id}/messages".replaceAll("\\{" + "ticket_id" + "\\}",escape(ticketId.toString))

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
      resp          <- client.expect[List[TicketMessage]](req)

    } yield resp
  }

  def sendMessageApi(host: String, ticketId: UUID, sendMessageDto: SendMessageDto): Task[TicketMessage] = {
    implicit val returnTypeDecoder: EntityDecoder[TicketMessage] = jsonOf[TicketMessage]

    val path = "/api/v1/support/tickets/{ticket_id}/messages".replaceAll("\\{" + "ticket_id" + "\\}",escape(ticketId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(sendMessageDto)
      resp          <- client.expect[TicketMessage](req)

    } yield resp
  }

}

class HttpServiceTicketMessageApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def listMessagesApi(ticketId: UUID): Task[List[TicketMessage]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[TicketMessage]] = jsonOf[List[TicketMessage]]

    val path = "/api/v1/support/tickets/{ticket_id}/messages".replaceAll("\\{" + "ticket_id" + "\\}",escape(ticketId.toString))

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
      resp          <- client.expect[List[TicketMessage]](req)

    } yield resp
  }

  def sendMessageApi(ticketId: UUID, sendMessageDto: SendMessageDto): Task[TicketMessage] = {
    implicit val returnTypeDecoder: EntityDecoder[TicketMessage] = jsonOf[TicketMessage]

    val path = "/api/v1/support/tickets/{ticket_id}/messages".replaceAll("\\{" + "ticket_id" + "\\}",escape(ticketId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(sendMessageDto)
      resp          <- client.expect[TicketMessage](req)

    } yield resp
  }

}
