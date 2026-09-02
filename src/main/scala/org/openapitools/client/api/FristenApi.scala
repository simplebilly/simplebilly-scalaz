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

import org.openapitools.client.api.FristenErgebnis

object FristenApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def fristenApi(host: String, bundesland: String, voranmeldungsrhythmus: String, dauerfristverlaengerung: Boolean, estAktiv: Boolean, gewstAktiv: Boolean, monate: Integer)(implicit bundeslandQuery: QueryParam[String], voranmeldungsrhythmusQuery: QueryParam[String], dauerfristverlaengerungQuery: QueryParam[Boolean], estAktivQuery: QueryParam[Boolean], gewstAktivQuery: QueryParam[Boolean], monateQuery: QueryParam[Integer]): Task[FristenErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[FristenErgebnis] = jsonOf[FristenErgebnis]

    val path = "/api/v1/bookkeeping/fristen"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("bundesland", Some(bundeslandQuery.toParamString(bundesland))), ("voranmeldungsrhythmus", Some(voranmeldungsrhythmusQuery.toParamString(voranmeldungsrhythmus))), ("dauerfristverlaengerung", Some(dauerfristverlaengerungQuery.toParamString(dauerfristverlaengerung))), ("estAktiv", Some(est_aktivQuery.toParamString(est_aktiv))), ("gewstAktiv", Some(gewst_aktivQuery.toParamString(gewst_aktiv))), ("monate", Some(monateQuery.toParamString(monate))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[FristenErgebnis](req)

    } yield resp
  }

}

class HttpServiceFristenApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def fristenApi(bundesland: String, voranmeldungsrhythmus: String, dauerfristverlaengerung: Boolean, estAktiv: Boolean, gewstAktiv: Boolean, monate: Integer)(implicit bundeslandQuery: QueryParam[String], voranmeldungsrhythmusQuery: QueryParam[String], dauerfristverlaengerungQuery: QueryParam[Boolean], estAktivQuery: QueryParam[Boolean], gewstAktivQuery: QueryParam[Boolean], monateQuery: QueryParam[Integer]): Task[FristenErgebnis] = {
    implicit val returnTypeDecoder: EntityDecoder[FristenErgebnis] = jsonOf[FristenErgebnis]

    val path = "/api/v1/bookkeeping/fristen"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("bundesland", Some(bundeslandQuery.toParamString(bundesland))), ("voranmeldungsrhythmus", Some(voranmeldungsrhythmusQuery.toParamString(voranmeldungsrhythmus))), ("dauerfristverlaengerung", Some(dauerfristverlaengerungQuery.toParamString(dauerfristverlaengerung))), ("estAktiv", Some(est_aktivQuery.toParamString(est_aktiv))), ("gewstAktiv", Some(gewst_aktivQuery.toParamString(gewst_aktiv))), ("monate", Some(monateQuery.toParamString(monate))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[FristenErgebnis](req)

    } yield resp
  }

}
