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

import org.openapitools.client.api.CommunicationChannel
import org.openapitools.client.api.CommunicationDirection
import org.openapitools.client.api.ContactHistoryResponse
import org.openapitools.client.api.CustomerCommunication
import org.openapitools.client.api.CustomerCommunicationCreate
import org.openapitools.client.api.CustomerCommunicationUpdate
import java.time.LocalDate
import org.openapitools.client.api.PluginError

object CustomerCommunicationApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createCommunication(host: String, customerCommunicationCreate: CustomerCommunicationCreate): Task[CustomerCommunication] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerCommunication] = jsonOf[CustomerCommunication]

    val path = "/api/v1/communications"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(customerCommunicationCreate)
      resp          <- client.expect[CustomerCommunication](req)

    } yield resp
  }

  def customercommunicationRestore(host: String, communicationId: String): Task[CustomerCommunication] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerCommunication] = jsonOf[CustomerCommunication]

    val path = "/api/v1/communications/{communication_id}/restore".replaceAll("\\{" + "communication_id" + "\\}",escape(communicationId.toString))

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
      resp          <- client.expect[CustomerCommunication](req)

    } yield resp
  }

  def deleteCommunication(host: String, communicationId: String): Task[Unit] = {
    val path = "/api/v1/communications/{communication_id}".replaceAll("\\{" + "communication_id" + "\\}",escape(communicationId.toString))

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

  def getCommunication(host: String, communicationId: String): Task[CustomerCommunication] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerCommunication] = jsonOf[CustomerCommunication]

    val path = "/api/v1/communications/{communication_id}".replaceAll("\\{" + "communication_id" + "\\}",escape(communicationId.toString))

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
      resp          <- client.expect[CustomerCommunication](req)

    } yield resp
  }

  def getContactHistory(host: String, contactId: String): Task[ContactHistoryResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ContactHistoryResponse] = jsonOf[ContactHistoryResponse]

    val path = "/api/v1/contacts/{contact_id}/communications".replaceAll("\\{" + "contact_id" + "\\}",escape(contactId.toString))

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
      resp          <- client.expect[ContactHistoryResponse](req)

    } yield resp
  }

  def listCommunications(host: String, page: Integer, pageSize: Integer, contactId: String, channel: CommunicationChannel, direction: CommunicationDirection, from: LocalDate, to: LocalDate)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], contactIdQuery: QueryParam[String], channelQuery: QueryParam[CommunicationChannel], directionQuery: QueryParam[CommunicationDirection], fromQuery: QueryParam[LocalDate], toQuery: QueryParam[LocalDate]): Task[List[CustomerCommunication]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[CustomerCommunication]] = jsonOf[List[CustomerCommunication]]

    val path = "/api/v1/communications/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("contactId", Some(contact_idQuery.toParamString(contact_id))), ("channel", Some(channelQuery.toParamString(channel))), ("direction", Some(directionQuery.toParamString(direction))), ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[CustomerCommunication]](req)

    } yield resp
  }

  def updateCommunication(host: String, communicationId: String, customerCommunicationUpdate: CustomerCommunicationUpdate): Task[CustomerCommunication] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerCommunication] = jsonOf[CustomerCommunication]

    val path = "/api/v1/communications/{communication_id}".replaceAll("\\{" + "communication_id" + "\\}",escape(communicationId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(customerCommunicationUpdate)
      resp          <- client.expect[CustomerCommunication](req)

    } yield resp
  }

}

class HttpServiceCustomerCommunicationApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createCommunication(customerCommunicationCreate: CustomerCommunicationCreate): Task[CustomerCommunication] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerCommunication] = jsonOf[CustomerCommunication]

    val path = "/api/v1/communications"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(customerCommunicationCreate)
      resp          <- client.expect[CustomerCommunication](req)

    } yield resp
  }

  def customercommunicationRestore(communicationId: String): Task[CustomerCommunication] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerCommunication] = jsonOf[CustomerCommunication]

    val path = "/api/v1/communications/{communication_id}/restore".replaceAll("\\{" + "communication_id" + "\\}",escape(communicationId.toString))

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
      resp          <- client.expect[CustomerCommunication](req)

    } yield resp
  }

  def deleteCommunication(communicationId: String): Task[Unit] = {
    val path = "/api/v1/communications/{communication_id}".replaceAll("\\{" + "communication_id" + "\\}",escape(communicationId.toString))

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

  def getCommunication(communicationId: String): Task[CustomerCommunication] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerCommunication] = jsonOf[CustomerCommunication]

    val path = "/api/v1/communications/{communication_id}".replaceAll("\\{" + "communication_id" + "\\}",escape(communicationId.toString))

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
      resp          <- client.expect[CustomerCommunication](req)

    } yield resp
  }

  def getContactHistory(contactId: String): Task[ContactHistoryResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[ContactHistoryResponse] = jsonOf[ContactHistoryResponse]

    val path = "/api/v1/contacts/{contact_id}/communications".replaceAll("\\{" + "contact_id" + "\\}",escape(contactId.toString))

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
      resp          <- client.expect[ContactHistoryResponse](req)

    } yield resp
  }

  def listCommunications(page: Integer, pageSize: Integer, contactId: String, channel: CommunicationChannel, direction: CommunicationDirection, from: LocalDate, to: LocalDate)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], contactIdQuery: QueryParam[String], channelQuery: QueryParam[CommunicationChannel], directionQuery: QueryParam[CommunicationDirection], fromQuery: QueryParam[LocalDate], toQuery: QueryParam[LocalDate]): Task[List[CustomerCommunication]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[CustomerCommunication]] = jsonOf[List[CustomerCommunication]]

    val path = "/api/v1/communications/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("contactId", Some(contact_idQuery.toParamString(contact_id))), ("channel", Some(channelQuery.toParamString(channel))), ("direction", Some(directionQuery.toParamString(direction))), ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[CustomerCommunication]](req)

    } yield resp
  }

  def updateCommunication(communicationId: String, customerCommunicationUpdate: CustomerCommunicationUpdate): Task[CustomerCommunication] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerCommunication] = jsonOf[CustomerCommunication]

    val path = "/api/v1/communications/{communication_id}".replaceAll("\\{" + "communication_id" + "\\}",escape(communicationId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(customerCommunicationUpdate)
      resp          <- client.expect[CustomerCommunication](req)

    } yield resp
  }

}
