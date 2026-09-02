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

import org.openapitools.client.api.Budget
import org.openapitools.client.api.BudgetErgebnis
import org.openapitools.client.api.BudgetGoalRequest
import org.openapitools.client.api.PluginError

object BudgetsApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def budgetsApi(host: String, year: Integer, month: Integer)(implicit yearQuery: QueryParam[Integer], monthQuery: QueryParam[Integer]): Task[BudgetErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[BudgetErgebnis] = jsonOf[BudgetErgebnis]

    val path = "/api/v1/bookkeeping/budgets"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("month", Some(monthQuery.toParamString(month))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[BudgetErgebnis](req)

    } yield resp
  }

  def upsertBudgetGoalApi(host: String, category: String, budgetGoalRequest: BudgetGoalRequest): Task[Budget] = {
    implicit val returnTypeDecoder: EntityDecoder[Budget] = jsonOf[Budget]

    val path = "/api/v1/bookkeeping/budgets/goals/{category}".replaceAll("\\{" + "category" + "\\}",escape(category.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(budgetGoalRequest)
      resp          <- client.expect[Budget](req)

    } yield resp
  }

}

class HttpServiceBudgetsApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def budgetsApi(year: Integer, month: Integer)(implicit yearQuery: QueryParam[Integer], monthQuery: QueryParam[Integer]): Task[BudgetErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[BudgetErgebnis] = jsonOf[BudgetErgebnis]

    val path = "/api/v1/bookkeeping/budgets"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("year", Some(yearQuery.toParamString(year))), ("month", Some(monthQuery.toParamString(month))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[BudgetErgebnis](req)

    } yield resp
  }

  def upsertBudgetGoalApi(category: String, budgetGoalRequest: BudgetGoalRequest): Task[Budget] = {
    implicit val returnTypeDecoder: EntityDecoder[Budget] = jsonOf[Budget]

    val path = "/api/v1/bookkeeping/budgets/goals/{category}".replaceAll("\\{" + "category" + "\\}",escape(category.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(budgetGoalRequest)
      resp          <- client.expect[Budget](req)

    } yield resp
  }

}
