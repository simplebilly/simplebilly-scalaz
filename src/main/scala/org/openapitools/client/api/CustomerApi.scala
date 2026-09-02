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

import org.openapitools.client.api.Customer
import org.openapitools.client.api.CustomerCreate
import org.openapitools.client.api.CustomerUpdate
import org.openapitools.client.api.PluginError

object CustomerApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createCustomer(host: String, customerCreate: CustomerCreate): Task[Customer] = {
    implicit val returnTypeDecoder: EntityDecoder[Customer] = jsonOf[Customer]

    val path = "/api/v1/customers"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(customerCreate)
      resp          <- client.expect[Customer](req)

    } yield resp
  }

  def customerRestore(host: String, customerId: String): Task[Customer] = {
    implicit val returnTypeDecoder: EntityDecoder[Customer] = jsonOf[Customer]

    val path = "/api/v1/customers/{customer_id}/restore".replaceAll("\\{" + "customer_id" + "\\}",escape(customerId.toString))

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
      resp          <- client.expect[Customer](req)

    } yield resp
  }

  def deleteCustomer(host: String, customerId: String): Task[Unit] = {
    val path = "/api/v1/customers/{customer_id}".replaceAll("\\{" + "customer_id" + "\\}",escape(customerId.toString))

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

  def getCustomer(host: String, customerId: String): Task[Customer] = {
    implicit val returnTypeDecoder: EntityDecoder[Customer] = jsonOf[Customer]

    val path = "/api/v1/customers/{customer_id}".replaceAll("\\{" + "customer_id" + "\\}",escape(customerId.toString))

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
      resp          <- client.expect[Customer](req)

    } yield resp
  }

  def getCustomers(host: String, page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[Customer]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Customer]] = jsonOf[List[Customer]]

    val path = "/api/v1/customers/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("search", Some(searchQuery.toParamString(search))), ("includeDeleted", Some(include_deletedQuery.toParamString(include_deleted))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Customer]](req)

    } yield resp
  }

  def updateCustomer(host: String, customerId: String, customerUpdate: CustomerUpdate): Task[Customer] = {
    implicit val returnTypeDecoder: EntityDecoder[Customer] = jsonOf[Customer]

    val path = "/api/v1/customers/{customer_id}".replaceAll("\\{" + "customer_id" + "\\}",escape(customerId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(customerUpdate)
      resp          <- client.expect[Customer](req)

    } yield resp
  }

}

class HttpServiceCustomerApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createCustomer(customerCreate: CustomerCreate): Task[Customer] = {
    implicit val returnTypeDecoder: EntityDecoder[Customer] = jsonOf[Customer]

    val path = "/api/v1/customers"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(customerCreate)
      resp          <- client.expect[Customer](req)

    } yield resp
  }

  def customerRestore(customerId: String): Task[Customer] = {
    implicit val returnTypeDecoder: EntityDecoder[Customer] = jsonOf[Customer]

    val path = "/api/v1/customers/{customer_id}/restore".replaceAll("\\{" + "customer_id" + "\\}",escape(customerId.toString))

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
      resp          <- client.expect[Customer](req)

    } yield resp
  }

  def deleteCustomer(customerId: String): Task[Unit] = {
    val path = "/api/v1/customers/{customer_id}".replaceAll("\\{" + "customer_id" + "\\}",escape(customerId.toString))

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

  def getCustomer(customerId: String): Task[Customer] = {
    implicit val returnTypeDecoder: EntityDecoder[Customer] = jsonOf[Customer]

    val path = "/api/v1/customers/{customer_id}".replaceAll("\\{" + "customer_id" + "\\}",escape(customerId.toString))

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
      resp          <- client.expect[Customer](req)

    } yield resp
  }

  def getCustomers(page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[Customer]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Customer]] = jsonOf[List[Customer]]

    val path = "/api/v1/customers/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("search", Some(searchQuery.toParamString(search))), ("includeDeleted", Some(include_deletedQuery.toParamString(include_deleted))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Customer]](req)

    } yield resp
  }

  def updateCustomer(customerId: String, customerUpdate: CustomerUpdate): Task[Customer] = {
    implicit val returnTypeDecoder: EntityDecoder[Customer] = jsonOf[Customer]

    val path = "/api/v1/customers/{customer_id}".replaceAll("\\{" + "customer_id" + "\\}",escape(customerId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(customerUpdate)
      resp          <- client.expect[Customer](req)

    } yield resp
  }

}
