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
import org.openapitools.client.api.GenerateCountRequest
import org.openapitools.client.api.InventoryCount
import org.openapitools.client.api.InventoryCountStatusUpdate
import org.openapitools.client.api.PluginError

object InventoryCountApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createInventoryCount(host: String, inventoryCount: InventoryCount): Task[InventoryCount] = {
    implicit val returnTypeDecoder: EntityDecoder[InventoryCount] = jsonOf[InventoryCount]

    val path = "/api/v1/inventory-counts"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(inventoryCount)
      resp          <- client.expect[InventoryCount](req)

    } yield resp
  }

  def deleteInventoryCount(host: String, inventoryCountId: String): Task[Unit] = {
    val path = "/api/v1/inventory-counts/{inventory_count_id}".replaceAll("\\{" + "inventory_count_id" + "\\}",escape(inventoryCountId.toString))

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

  def generateInventoryCount(host: String, generateCountRequest: GenerateCountRequest): Task[InventoryCount] = {
    implicit val returnTypeDecoder: EntityDecoder[InventoryCount] = jsonOf[InventoryCount]

    val path = "/api/v1/inventory-counts/generate"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(generateCountRequest)
      resp          <- client.expect[InventoryCount](req)

    } yield resp
  }

  def getInventoryCount(host: String, inventoryCountId: String): Task[InventoryCount] = {
    implicit val returnTypeDecoder: EntityDecoder[InventoryCount] = jsonOf[InventoryCount]

    val path = "/api/v1/inventory-counts/{inventory_count_id}".replaceAll("\\{" + "inventory_count_id" + "\\}",escape(inventoryCountId.toString))

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
      resp          <- client.expect[InventoryCount](req)

    } yield resp
  }

  def listInventoryCounts(host: String, page: Integer, pageSize: Integer, status: String, warehouseId: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], warehouseIdQuery: QueryParam[String]): Task[List[InventoryCount]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[InventoryCount]] = jsonOf[List[InventoryCount]]

    val path = "/api/v1/inventory-counts/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("warehouseId", Some(warehouse_idQuery.toParamString(warehouse_id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[InventoryCount]](req)

    } yield resp
  }

  def updateInventoryCount(host: String, inventoryCountId: String, body: AnyType): Task[InventoryCount] = {
    implicit val returnTypeDecoder: EntityDecoder[InventoryCount] = jsonOf[InventoryCount]

    val path = "/api/v1/inventory-counts/{inventory_count_id}".replaceAll("\\{" + "inventory_count_id" + "\\}",escape(inventoryCountId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[InventoryCount](req)

    } yield resp
  }

  def updateInventoryCountStatus(host: String, inventoryCountId: String, inventoryCountStatusUpdate: InventoryCountStatusUpdate): Task[InventoryCount] = {
    implicit val returnTypeDecoder: EntityDecoder[InventoryCount] = jsonOf[InventoryCount]

    val path = "/api/v1/inventory-counts/{inventory_count_id}/status".replaceAll("\\{" + "inventory_count_id" + "\\}",escape(inventoryCountId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(inventoryCountStatusUpdate)
      resp          <- client.expect[InventoryCount](req)

    } yield resp
  }

}

class HttpServiceInventoryCountApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createInventoryCount(inventoryCount: InventoryCount): Task[InventoryCount] = {
    implicit val returnTypeDecoder: EntityDecoder[InventoryCount] = jsonOf[InventoryCount]

    val path = "/api/v1/inventory-counts"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(inventoryCount)
      resp          <- client.expect[InventoryCount](req)

    } yield resp
  }

  def deleteInventoryCount(inventoryCountId: String): Task[Unit] = {
    val path = "/api/v1/inventory-counts/{inventory_count_id}".replaceAll("\\{" + "inventory_count_id" + "\\}",escape(inventoryCountId.toString))

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

  def generateInventoryCount(generateCountRequest: GenerateCountRequest): Task[InventoryCount] = {
    implicit val returnTypeDecoder: EntityDecoder[InventoryCount] = jsonOf[InventoryCount]

    val path = "/api/v1/inventory-counts/generate"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(generateCountRequest)
      resp          <- client.expect[InventoryCount](req)

    } yield resp
  }

  def getInventoryCount(inventoryCountId: String): Task[InventoryCount] = {
    implicit val returnTypeDecoder: EntityDecoder[InventoryCount] = jsonOf[InventoryCount]

    val path = "/api/v1/inventory-counts/{inventory_count_id}".replaceAll("\\{" + "inventory_count_id" + "\\}",escape(inventoryCountId.toString))

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
      resp          <- client.expect[InventoryCount](req)

    } yield resp
  }

  def listInventoryCounts(page: Integer, pageSize: Integer, status: String, warehouseId: String)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], statusQuery: QueryParam[String], warehouseIdQuery: QueryParam[String]): Task[List[InventoryCount]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[InventoryCount]] = jsonOf[List[InventoryCount]]

    val path = "/api/v1/inventory-counts/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("status", Some(statusQuery.toParamString(status))), ("warehouseId", Some(warehouse_idQuery.toParamString(warehouse_id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[InventoryCount]](req)

    } yield resp
  }

  def updateInventoryCount(inventoryCountId: String, body: AnyType): Task[InventoryCount] = {
    implicit val returnTypeDecoder: EntityDecoder[InventoryCount] = jsonOf[InventoryCount]

    val path = "/api/v1/inventory-counts/{inventory_count_id}".replaceAll("\\{" + "inventory_count_id" + "\\}",escape(inventoryCountId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[InventoryCount](req)

    } yield resp
  }

  def updateInventoryCountStatus(inventoryCountId: String, inventoryCountStatusUpdate: InventoryCountStatusUpdate): Task[InventoryCount] = {
    implicit val returnTypeDecoder: EntityDecoder[InventoryCount] = jsonOf[InventoryCount]

    val path = "/api/v1/inventory-counts/{inventory_count_id}/status".replaceAll("\\{" + "inventory_count_id" + "\\}",escape(inventoryCountId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(inventoryCountStatusUpdate)
      resp          <- client.expect[InventoryCount](req)

    } yield resp
  }

}
