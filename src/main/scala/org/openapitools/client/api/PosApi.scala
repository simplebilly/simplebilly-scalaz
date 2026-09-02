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
import org.openapitools.client.api.PosRegister
import org.openapitools.client.api.PosRegisterCreate
import org.openapitools.client.api.PosTable
import org.openapitools.client.api.PosTableCreate
import java.util.UUID

object PosApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def posBilling(host: String): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/billing"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posCreateOrder(host: String, body: AnyType): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/orders"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posCreateRegister(host: String, posRegisterCreate: PosRegisterCreate): Task[PosRegister] = {
    implicit val returnTypeDecoder: EntityDecoder[PosRegister] = jsonOf[PosRegister]

    val path = "/api/pos/registers"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(posRegisterCreate)
      resp          <- client.expect[PosRegister](req)

    } yield resp
  }

  def posCreateTable(host: String, posTableCreate: PosTableCreate): Task[PosTable] = {
    implicit val returnTypeDecoder: EntityDecoder[PosTable] = jsonOf[PosTable]

    val path = "/api/pos/tables"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(posTableCreate)
      resp          <- client.expect[PosTable](req)

    } yield resp
  }

  def posDisableRegister(host: String, id: UUID): Task[PosRegister] = {
    implicit val returnTypeDecoder: EntityDecoder[PosRegister] = jsonOf[PosRegister]

    val path = "/api/pos/registers/{id}/disable".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[PosRegister](req)

    } yield resp
  }

  def posFreeTable(host: String, id: UUID): Task[PosTable] = {
    implicit val returnTypeDecoder: EntityDecoder[PosTable] = jsonOf[PosTable]

    val path = "/api/pos/tables/{id}/free".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[PosTable](req)

    } yield resp
  }

  def posKasseClosing(host: String, body: AnyType): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/kasse/closing"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posKasseEntries(host: String): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/kasse/entries"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posKasseExport(host: String): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/kasse/export"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posKassePayInOut(host: String, body: AnyType): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/kasse/pay-in-out"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posListOrders(host: String, status: String)(implicit statusQuery: QueryParam[String]): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/orders"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("status", Some(statusQuery.toParamString(status))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posListProducts(host: String, q: String)(implicit qQuery: QueryParam[String]): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/products"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("q", Some(qQuery.toParamString(q))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posListRegisters(host: String): Task[List[PosRegister]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PosRegister]] = jsonOf[List[PosRegister]]

    val path = "/api/pos/registers"

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
      resp          <- client.expect[List[PosRegister]](req)

    } yield resp
  }

  def posListTables(host: String): Task[List[PosTable]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PosTable]] = jsonOf[List[PosTable]]

    val path = "/api/pos/tables"

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
      resp          <- client.expect[List[PosTable]](req)

    } yield resp
  }

  def posOrderPrint(host: String, orderNumber: String): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/orders/{order_number}/print".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posOrderReceipt(host: String, orderNumber: String): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/orders/{order_number}/receipt".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posPayOrder(host: String, orderNumber: String, body: AnyType): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/orders/{order_number}/pay".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posSumupCheckout(host: String, body: AnyType): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/sumup/checkout"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

}

class HttpServicePosApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def posBilling(): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/billing"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posCreateOrder(body: AnyType): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/orders"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posCreateRegister(posRegisterCreate: PosRegisterCreate): Task[PosRegister] = {
    implicit val returnTypeDecoder: EntityDecoder[PosRegister] = jsonOf[PosRegister]

    val path = "/api/pos/registers"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(posRegisterCreate)
      resp          <- client.expect[PosRegister](req)

    } yield resp
  }

  def posCreateTable(posTableCreate: PosTableCreate): Task[PosTable] = {
    implicit val returnTypeDecoder: EntityDecoder[PosTable] = jsonOf[PosTable]

    val path = "/api/pos/tables"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(posTableCreate)
      resp          <- client.expect[PosTable](req)

    } yield resp
  }

  def posDisableRegister(id: UUID): Task[PosRegister] = {
    implicit val returnTypeDecoder: EntityDecoder[PosRegister] = jsonOf[PosRegister]

    val path = "/api/pos/registers/{id}/disable".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[PosRegister](req)

    } yield resp
  }

  def posFreeTable(id: UUID): Task[PosTable] = {
    implicit val returnTypeDecoder: EntityDecoder[PosTable] = jsonOf[PosTable]

    val path = "/api/pos/tables/{id}/free".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[PosTable](req)

    } yield resp
  }

  def posKasseClosing(body: AnyType): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/kasse/closing"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posKasseEntries(): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/kasse/entries"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posKasseExport(): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/kasse/export"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posKassePayInOut(body: AnyType): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/kasse/pay-in-out"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posListOrders(status: String)(implicit statusQuery: QueryParam[String]): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/orders"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("status", Some(statusQuery.toParamString(status))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posListProducts(q: String)(implicit qQuery: QueryParam[String]): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/products"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("q", Some(qQuery.toParamString(q))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posListRegisters(): Task[List[PosRegister]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PosRegister]] = jsonOf[List[PosRegister]]

    val path = "/api/pos/registers"

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
      resp          <- client.expect[List[PosRegister]](req)

    } yield resp
  }

  def posListTables(): Task[List[PosTable]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PosTable]] = jsonOf[List[PosTable]]

    val path = "/api/pos/tables"

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
      resp          <- client.expect[List[PosTable]](req)

    } yield resp
  }

  def posOrderPrint(orderNumber: String): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/orders/{order_number}/print".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posOrderReceipt(orderNumber: String): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/orders/{order_number}/receipt".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posPayOrder(orderNumber: String, body: AnyType): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/orders/{order_number}/pay".replaceAll("\\{" + "order_number" + "\\}",escape(orderNumber.toString))

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

  def posSumupCheckout(body: AnyType): Task[AnyType] = {
    implicit val returnTypeDecoder: EntityDecoder[AnyType] = jsonOf[AnyType]

    val path = "/api/pos/sumup/checkout"

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
      resp          <- client.expect[AnyType](req)

    } yield resp
  }

}
