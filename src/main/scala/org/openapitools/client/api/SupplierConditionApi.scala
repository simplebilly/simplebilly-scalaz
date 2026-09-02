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
import org.openapitools.client.api.SupplierCondition
import org.openapitools.client.api.SupplierConditionCreate
import org.openapitools.client.api.SupplierConditionUpdate

object SupplierConditionApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createSupplierCondition(host: String, supplierConditionCreate: SupplierConditionCreate): Task[SupplierCondition] = {
    implicit val returnTypeDecoder: EntityDecoder[SupplierCondition] = jsonOf[SupplierCondition]

    val path = "/api/v1/supplier-conditions"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(supplierConditionCreate)
      resp          <- client.expect[SupplierCondition](req)

    } yield resp
  }

  def deleteSupplierCondition(host: String, supplierConditionId: String): Task[Unit] = {
    val path = "/api/v1/supplier-conditions/{supplier_condition_id}".replaceAll("\\{" + "supplier_condition_id" + "\\}",escape(supplierConditionId.toString))

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

  def getSupplierCondition(host: String, supplierConditionId: String): Task[SupplierCondition] = {
    implicit val returnTypeDecoder: EntityDecoder[SupplierCondition] = jsonOf[SupplierCondition]

    val path = "/api/v1/supplier-conditions/{supplier_condition_id}".replaceAll("\\{" + "supplier_condition_id" + "\\}",escape(supplierConditionId.toString))

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
      resp          <- client.expect[SupplierCondition](req)

    } yield resp
  }

  def listSupplierConditions(host: String, page: Integer, pageSize: Integer, supplierContactId: String, search: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], supplierContactIdQuery: QueryParam[String], searchQuery: QueryParam[String]): Task[List[SupplierCondition]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[SupplierCondition]] = jsonOf[List[SupplierCondition]]

    val path = "/api/v1/supplier-conditions/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("supplierContactId", Some(supplier_contact_idQuery.toParamString(supplier_contact_id))), ("search", Some(searchQuery.toParamString(search))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[SupplierCondition]](req)

    } yield resp
  }

  def updateSupplierCondition(host: String, supplierConditionId: String, supplierConditionUpdate: SupplierConditionUpdate): Task[SupplierCondition] = {
    implicit val returnTypeDecoder: EntityDecoder[SupplierCondition] = jsonOf[SupplierCondition]

    val path = "/api/v1/supplier-conditions/{supplier_condition_id}".replaceAll("\\{" + "supplier_condition_id" + "\\}",escape(supplierConditionId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(supplierConditionUpdate)
      resp          <- client.expect[SupplierCondition](req)

    } yield resp
  }

}

class HttpServiceSupplierConditionApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createSupplierCondition(supplierConditionCreate: SupplierConditionCreate): Task[SupplierCondition] = {
    implicit val returnTypeDecoder: EntityDecoder[SupplierCondition] = jsonOf[SupplierCondition]

    val path = "/api/v1/supplier-conditions"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(supplierConditionCreate)
      resp          <- client.expect[SupplierCondition](req)

    } yield resp
  }

  def deleteSupplierCondition(supplierConditionId: String): Task[Unit] = {
    val path = "/api/v1/supplier-conditions/{supplier_condition_id}".replaceAll("\\{" + "supplier_condition_id" + "\\}",escape(supplierConditionId.toString))

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

  def getSupplierCondition(supplierConditionId: String): Task[SupplierCondition] = {
    implicit val returnTypeDecoder: EntityDecoder[SupplierCondition] = jsonOf[SupplierCondition]

    val path = "/api/v1/supplier-conditions/{supplier_condition_id}".replaceAll("\\{" + "supplier_condition_id" + "\\}",escape(supplierConditionId.toString))

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
      resp          <- client.expect[SupplierCondition](req)

    } yield resp
  }

  def listSupplierConditions(page: Integer, pageSize: Integer, supplierContactId: String, search: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], supplierContactIdQuery: QueryParam[String], searchQuery: QueryParam[String]): Task[List[SupplierCondition]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[SupplierCondition]] = jsonOf[List[SupplierCondition]]

    val path = "/api/v1/supplier-conditions/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("supplierContactId", Some(supplier_contact_idQuery.toParamString(supplier_contact_id))), ("search", Some(searchQuery.toParamString(search))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[SupplierCondition]](req)

    } yield resp
  }

  def updateSupplierCondition(supplierConditionId: String, supplierConditionUpdate: SupplierConditionUpdate): Task[SupplierCondition] = {
    implicit val returnTypeDecoder: EntityDecoder[SupplierCondition] = jsonOf[SupplierCondition]

    val path = "/api/v1/supplier-conditions/{supplier_condition_id}".replaceAll("\\{" + "supplier_condition_id" + "\\}",escape(supplierConditionId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(supplierConditionUpdate)
      resp          <- client.expect[SupplierCondition](req)

    } yield resp
  }

}
