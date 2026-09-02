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

import org.openapitools.client.api.BankLookup
import org.openapitools.client.api.HebesatzLookup

object BankingApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def bankLookupApi(host: String, iban: String)(implicit ibanQuery: QueryParam[String]): Task[BankLookup] = {
    implicit val returnTypeDecoder: EntityDecoder[BankLookup] = jsonOf[BankLookup]

    val path = "/api/v1/bookkeeping/banking/lookup"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("iban", Some(ibanQuery.toParamString(iban))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[BankLookup](req)

    } yield resp
  }

  def bankTransactionsApi(host: String): Task[Unit] = {
    val path = "/api/v1/bookkeeping/banking/transactions"

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def hebesatzLookupApi(host: String, gemeindeschluessel: String, plz: String, name: String, stichtag: String, countryCode: String)(implicit gemeindeschluesselQuery: QueryParam[String], plzQuery: QueryParam[String], nameQuery: QueryParam[String], stichtagQuery: QueryParam[String], countryCodeQuery: QueryParam[String]): Task[List[HebesatzLookup]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[HebesatzLookup]] = jsonOf[List[HebesatzLookup]]

    val path = "/api/v1/bookkeeping/hebesatz"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("gemeindeschluessel", Some(gemeindeschluesselQuery.toParamString(gemeindeschluessel))), ("plz", Some(plzQuery.toParamString(plz))), ("name", Some(nameQuery.toParamString(name))), ("stichtag", Some(stichtagQuery.toParamString(stichtag))), ("countryCode", Some(country_codeQuery.toParamString(country_code))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[HebesatzLookup]](req)

    } yield resp
  }

}

class HttpServiceBankingApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def bankLookupApi(iban: String)(implicit ibanQuery: QueryParam[String]): Task[BankLookup] = {
    implicit val returnTypeDecoder: EntityDecoder[BankLookup] = jsonOf[BankLookup]

    val path = "/api/v1/bookkeeping/banking/lookup"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("iban", Some(ibanQuery.toParamString(iban))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[BankLookup](req)

    } yield resp
  }

  def bankTransactionsApi(): Task[Unit] = {
    val path = "/api/v1/bookkeeping/banking/transactions"

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def hebesatzLookupApi(gemeindeschluessel: String, plz: String, name: String, stichtag: String, countryCode: String)(implicit gemeindeschluesselQuery: QueryParam[String], plzQuery: QueryParam[String], nameQuery: QueryParam[String], stichtagQuery: QueryParam[String], countryCodeQuery: QueryParam[String]): Task[List[HebesatzLookup]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[HebesatzLookup]] = jsonOf[List[HebesatzLookup]]

    val path = "/api/v1/bookkeeping/hebesatz"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("gemeindeschluessel", Some(gemeindeschluesselQuery.toParamString(gemeindeschluessel))), ("plz", Some(plzQuery.toParamString(plz))), ("name", Some(nameQuery.toParamString(name))), ("stichtag", Some(stichtagQuery.toParamString(stichtag))), ("countryCode", Some(country_codeQuery.toParamString(country_code))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[HebesatzLookup]](req)

    } yield resp
  }

}
