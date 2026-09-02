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

import org.openapitools.client.api.AnyType
import org.openapitools.client.api.CustomerGroup
import org.openapitools.client.api.CustomerGroupCreate
import org.openapitools.client.api.CustomerGroupUpdate
import org.openapitools.client.api.PluginError

object CustomerGroupApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def addGroupMembers(host: String, customerGroupId: String, body: AnyType): Task[CustomerGroup] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerGroup] = jsonOf[CustomerGroup]

    val path = "/api/v1/customer-groups/{customer_group_id}/members".replaceAll("\\{" + "customer_group_id" + "\\}",escape(customerGroupId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[CustomerGroup](req)

    } yield resp
  }

  def createCustomerGroup(host: String, customerGroupCreate: CustomerGroupCreate): Task[CustomerGroup] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerGroup] = jsonOf[CustomerGroup]

    val path = "/api/v1/customer-groups"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(customerGroupCreate)
      resp          <- client.expect[CustomerGroup](req)

    } yield resp
  }

  def deleteCustomerGroup(host: String, customerGroupId: String): Task[Unit] = {
    val path = "/api/v1/customer-groups/{customer_group_id}".replaceAll("\\{" + "customer_group_id" + "\\}",escape(customerGroupId.toString))

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

  def getCustomerGroup(host: String, customerGroupId: String): Task[CustomerGroup] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerGroup] = jsonOf[CustomerGroup]

    val path = "/api/v1/customer-groups/{customer_group_id}".replaceAll("\\{" + "customer_group_id" + "\\}",escape(customerGroupId.toString))

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
      resp          <- client.expect[CustomerGroup](req)

    } yield resp
  }

  def listCustomerGroups(host: String, page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[CustomerGroup]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[CustomerGroup]] = jsonOf[List[CustomerGroup]]

    val path = "/api/v1/customer-groups/"

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
      resp          <- client.expect[List[CustomerGroup]](req)

    } yield resp
  }

  def updateCustomerGroup(host: String, customerGroupId: String, customerGroupUpdate: CustomerGroupUpdate): Task[CustomerGroup] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerGroup] = jsonOf[CustomerGroup]

    val path = "/api/v1/customer-groups/{customer_group_id}".replaceAll("\\{" + "customer_group_id" + "\\}",escape(customerGroupId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(customerGroupUpdate)
      resp          <- client.expect[CustomerGroup](req)

    } yield resp
  }

}

class HttpServiceCustomerGroupApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def addGroupMembers(customerGroupId: String, body: AnyType): Task[CustomerGroup] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerGroup] = jsonOf[CustomerGroup]

    val path = "/api/v1/customer-groups/{customer_group_id}/members".replaceAll("\\{" + "customer_group_id" + "\\}",escape(customerGroupId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[CustomerGroup](req)

    } yield resp
  }

  def createCustomerGroup(customerGroupCreate: CustomerGroupCreate): Task[CustomerGroup] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerGroup] = jsonOf[CustomerGroup]

    val path = "/api/v1/customer-groups"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(customerGroupCreate)
      resp          <- client.expect[CustomerGroup](req)

    } yield resp
  }

  def deleteCustomerGroup(customerGroupId: String): Task[Unit] = {
    val path = "/api/v1/customer-groups/{customer_group_id}".replaceAll("\\{" + "customer_group_id" + "\\}",escape(customerGroupId.toString))

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

  def getCustomerGroup(customerGroupId: String): Task[CustomerGroup] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerGroup] = jsonOf[CustomerGroup]

    val path = "/api/v1/customer-groups/{customer_group_id}".replaceAll("\\{" + "customer_group_id" + "\\}",escape(customerGroupId.toString))

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
      resp          <- client.expect[CustomerGroup](req)

    } yield resp
  }

  def listCustomerGroups(page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[CustomerGroup]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[CustomerGroup]] = jsonOf[List[CustomerGroup]]

    val path = "/api/v1/customer-groups/"

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
      resp          <- client.expect[List[CustomerGroup]](req)

    } yield resp
  }

  def updateCustomerGroup(customerGroupId: String, customerGroupUpdate: CustomerGroupUpdate): Task[CustomerGroup] = {
    implicit val returnTypeDecoder: EntityDecoder[CustomerGroup] = jsonOf[CustomerGroup]

    val path = "/api/v1/customer-groups/{customer_group_id}".replaceAll("\\{" + "customer_group_id" + "\\}",escape(customerGroupId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(customerGroupUpdate)
      resp          <- client.expect[CustomerGroup](req)

    } yield resp
  }

}
