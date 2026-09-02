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

import org.openapitools.client.api.CreateTicketRequest
import org.openapitools.client.api.SupportTicket
import org.openapitools.client.api.SupportTicketUpdate
import java.util.UUID

object SupportTicketApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createTicketApi(host: String, createTicketRequest: CreateTicketRequest): Task[SupportTicket] = {
    implicit val returnTypeDecoder: EntityDecoder[SupportTicket] = jsonOf[SupportTicket]

    val path = "/api/v1/support/tickets"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(createTicketRequest)
      resp          <- client.expect[SupportTicket](req)

    } yield resp
  }

  def deleteTicketApi(host: String, ticketId: UUID): Task[Unit] = {
    val path = "/api/v1/support/tickets/{ticket_id}".replaceAll("\\{" + "ticket_id" + "\\}",escape(ticketId.toString))

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

  def getTicketApi(host: String, ticketId: UUID): Task[SupportTicket] = {
    implicit val returnTypeDecoder: EntityDecoder[SupportTicket] = jsonOf[SupportTicket]

    val path = "/api/v1/support/tickets/{ticket_id}".replaceAll("\\{" + "ticket_id" + "\\}",escape(ticketId.toString))

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
      resp          <- client.expect[SupportTicket](req)

    } yield resp
  }

  def listTicketsApi(host: String, status: String, priority: String, assignedTo: UUID, channelType: String, customerId: String, search: String, page: Integer, pageSize: Integer)(implicit statusQuery: QueryParam[String], priorityQuery: QueryParam[String], assignedToQuery: QueryParam[UUID], channelTypeQuery: QueryParam[String], customerIdQuery: QueryParam[String], searchQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[List[SupportTicket]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[SupportTicket]] = jsonOf[List[SupportTicket]]

    val path = "/api/v1/support/tickets"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("status", Some(statusQuery.toParamString(status))), ("priority", Some(priorityQuery.toParamString(priority))), ("assignedTo", Some(assigned_toQuery.toParamString(assigned_to))), ("channelType", Some(channel_typeQuery.toParamString(channel_type))), ("customerId", Some(customer_idQuery.toParamString(customer_id))), ("search", Some(searchQuery.toParamString(search))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[SupportTicket]](req)

    } yield resp
  }

  def updateTicketApi(host: String, ticketId: UUID, supportTicketUpdate: SupportTicketUpdate): Task[SupportTicket] = {
    implicit val returnTypeDecoder: EntityDecoder[SupportTicket] = jsonOf[SupportTicket]

    val path = "/api/v1/support/tickets/{ticket_id}".replaceAll("\\{" + "ticket_id" + "\\}",escape(ticketId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(supportTicketUpdate)
      resp          <- client.expect[SupportTicket](req)

    } yield resp
  }

}

class HttpServiceSupportTicketApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createTicketApi(createTicketRequest: CreateTicketRequest): Task[SupportTicket] = {
    implicit val returnTypeDecoder: EntityDecoder[SupportTicket] = jsonOf[SupportTicket]

    val path = "/api/v1/support/tickets"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(createTicketRequest)
      resp          <- client.expect[SupportTicket](req)

    } yield resp
  }

  def deleteTicketApi(ticketId: UUID): Task[Unit] = {
    val path = "/api/v1/support/tickets/{ticket_id}".replaceAll("\\{" + "ticket_id" + "\\}",escape(ticketId.toString))

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

  def getTicketApi(ticketId: UUID): Task[SupportTicket] = {
    implicit val returnTypeDecoder: EntityDecoder[SupportTicket] = jsonOf[SupportTicket]

    val path = "/api/v1/support/tickets/{ticket_id}".replaceAll("\\{" + "ticket_id" + "\\}",escape(ticketId.toString))

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
      resp          <- client.expect[SupportTicket](req)

    } yield resp
  }

  def listTicketsApi(status: String, priority: String, assignedTo: UUID, channelType: String, customerId: String, search: String, page: Integer, pageSize: Integer)(implicit statusQuery: QueryParam[String], priorityQuery: QueryParam[String], assignedToQuery: QueryParam[UUID], channelTypeQuery: QueryParam[String], customerIdQuery: QueryParam[String], searchQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[List[SupportTicket]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[SupportTicket]] = jsonOf[List[SupportTicket]]

    val path = "/api/v1/support/tickets"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("status", Some(statusQuery.toParamString(status))), ("priority", Some(priorityQuery.toParamString(priority))), ("assignedTo", Some(assigned_toQuery.toParamString(assigned_to))), ("channelType", Some(channel_typeQuery.toParamString(channel_type))), ("customerId", Some(customer_idQuery.toParamString(customer_id))), ("search", Some(searchQuery.toParamString(search))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[SupportTicket]](req)

    } yield resp
  }

  def updateTicketApi(ticketId: UUID, supportTicketUpdate: SupportTicketUpdate): Task[SupportTicket] = {
    implicit val returnTypeDecoder: EntityDecoder[SupportTicket] = jsonOf[SupportTicket]

    val path = "/api/v1/support/tickets/{ticket_id}".replaceAll("\\{" + "ticket_id" + "\\}",escape(ticketId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(supportTicketUpdate)
      resp          <- client.expect[SupportTicket](req)

    } yield resp
  }

}
