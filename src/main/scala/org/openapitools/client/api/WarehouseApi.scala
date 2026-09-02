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
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.Warehouse

object WarehouseApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createWarehouse(host: String, warehouse: Warehouse): Task[Warehouse] = {
    implicit val returnTypeDecoder: EntityDecoder[Warehouse] = jsonOf[Warehouse]

    val path = "/api/v1/warehouses"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(warehouse)
      resp          <- client.expect[Warehouse](req)

    } yield resp
  }

  def deleteWarehouse(host: String, warehouseId: String): Task[Unit] = {
    val path = "/api/v1/warehouses/{warehouse_id}".replaceAll("\\{" + "warehouse_id" + "\\}",escape(warehouseId.toString))

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

  def getWarehouse(host: String, warehouseId: String): Task[Warehouse] = {
    implicit val returnTypeDecoder: EntityDecoder[Warehouse] = jsonOf[Warehouse]

    val path = "/api/v1/warehouses/{warehouse_id}".replaceAll("\\{" + "warehouse_id" + "\\}",escape(warehouseId.toString))

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
      resp          <- client.expect[Warehouse](req)

    } yield resp
  }

  def listWarehouses(host: String, page: Integer, pageSize: Integer, search: String, isActive: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], isActiveQuery: QueryParam[Boolean]): Task[List[Warehouse]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Warehouse]] = jsonOf[List[Warehouse]]

    val path = "/api/v1/warehouses/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("search", Some(searchQuery.toParamString(search))), ("isActive", Some(is_activeQuery.toParamString(is_active))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Warehouse]](req)

    } yield resp
  }

  def updateWarehouse(host: String, warehouseId: String, body: AnyType): Task[Warehouse] = {
    implicit val returnTypeDecoder: EntityDecoder[Warehouse] = jsonOf[Warehouse]

    val path = "/api/v1/warehouses/{warehouse_id}".replaceAll("\\{" + "warehouse_id" + "\\}",escape(warehouseId.toString))

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
      resp          <- client.expect[Warehouse](req)

    } yield resp
  }

}

class HttpServiceWarehouseApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createWarehouse(warehouse: Warehouse): Task[Warehouse] = {
    implicit val returnTypeDecoder: EntityDecoder[Warehouse] = jsonOf[Warehouse]

    val path = "/api/v1/warehouses"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(warehouse)
      resp          <- client.expect[Warehouse](req)

    } yield resp
  }

  def deleteWarehouse(warehouseId: String): Task[Unit] = {
    val path = "/api/v1/warehouses/{warehouse_id}".replaceAll("\\{" + "warehouse_id" + "\\}",escape(warehouseId.toString))

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

  def getWarehouse(warehouseId: String): Task[Warehouse] = {
    implicit val returnTypeDecoder: EntityDecoder[Warehouse] = jsonOf[Warehouse]

    val path = "/api/v1/warehouses/{warehouse_id}".replaceAll("\\{" + "warehouse_id" + "\\}",escape(warehouseId.toString))

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
      resp          <- client.expect[Warehouse](req)

    } yield resp
  }

  def listWarehouses(page: Integer, pageSize: Integer, search: String, isActive: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], isActiveQuery: QueryParam[Boolean]): Task[List[Warehouse]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Warehouse]] = jsonOf[List[Warehouse]]

    val path = "/api/v1/warehouses/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("search", Some(searchQuery.toParamString(search))), ("isActive", Some(is_activeQuery.toParamString(is_active))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Warehouse]](req)

    } yield resp
  }

  def updateWarehouse(warehouseId: String, body: AnyType): Task[Warehouse] = {
    implicit val returnTypeDecoder: EntityDecoder[Warehouse] = jsonOf[Warehouse]

    val path = "/api/v1/warehouses/{warehouse_id}".replaceAll("\\{" + "warehouse_id" + "\\}",escape(warehouseId.toString))

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
      resp          <- client.expect[Warehouse](req)

    } yield resp
  }

}
