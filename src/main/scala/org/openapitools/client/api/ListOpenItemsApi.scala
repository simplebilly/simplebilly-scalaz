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

import org.openapitools.client.api.OpenItem

object ListOpenItemsApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def listOpenItemsApi(host: String, reminderLevel1Days: Long, reminderLevel2Days: Long, reminderLevel3Days: Long, customerId: String)(implicit reminderLevel1DaysQuery: QueryParam[Long], reminderLevel2DaysQuery: QueryParam[Long], reminderLevel3DaysQuery: QueryParam[Long], customerIdQuery: QueryParam[String]): Task[List[OpenItem]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[OpenItem]] = jsonOf[List[OpenItem]]

    val path = "/api/v1/bookkeeping/open-items"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("reminderLevel1Days", Some(reminder_level1_daysQuery.toParamString(reminder_level1_days))), ("reminderLevel2Days", Some(reminder_level2_daysQuery.toParamString(reminder_level2_days))), ("reminderLevel3Days", Some(reminder_level3_daysQuery.toParamString(reminder_level3_days))), ("customerId", Some(customer_idQuery.toParamString(customer_id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[OpenItem]](req)

    } yield resp
  }

}

class HttpServiceListOpenItemsApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def listOpenItemsApi(reminderLevel1Days: Long, reminderLevel2Days: Long, reminderLevel3Days: Long, customerId: String)(implicit reminderLevel1DaysQuery: QueryParam[Long], reminderLevel2DaysQuery: QueryParam[Long], reminderLevel3DaysQuery: QueryParam[Long], customerIdQuery: QueryParam[String]): Task[List[OpenItem]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[OpenItem]] = jsonOf[List[OpenItem]]

    val path = "/api/v1/bookkeeping/open-items"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("reminderLevel1Days", Some(reminder_level1_daysQuery.toParamString(reminder_level1_days))), ("reminderLevel2Days", Some(reminder_level2_daysQuery.toParamString(reminder_level2_days))), ("reminderLevel3Days", Some(reminder_level3_daysQuery.toParamString(reminder_level3_days))), ("customerId", Some(customer_idQuery.toParamString(customer_id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[OpenItem]](req)

    } yield resp
  }

}
