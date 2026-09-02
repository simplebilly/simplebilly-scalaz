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

import org.openapitools.client.api.GezReport

object GezApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def gezApi(host: String, jahr: Integer, betriebsstaetten: String, kfz: Long, hotelzimmer: Long, beschaefigte: Long)(implicit jahrQuery: QueryParam[Integer], betriebsstaettenQuery: QueryParam[String], kfzQuery: QueryParam[Long], hotelzimmerQuery: QueryParam[Long], beschaefigteQuery: QueryParam[Long]): Task[GezReport] = {
    implicit val returnTypeDecoder: EntityDecoder[GezReport] = jsonOf[GezReport]

    val path = "/api/v1/bookkeeping/gez"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("jahr", Some(jahrQuery.toParamString(jahr))), ("betriebsstaetten", Some(betriebsstaettenQuery.toParamString(betriebsstaetten))), ("kfz", Some(kfzQuery.toParamString(kfz))), ("hotelzimmer", Some(hotelzimmerQuery.toParamString(hotelzimmer))), ("beschaefigte", Some(beschaefigteQuery.toParamString(beschaefigte))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[GezReport](req)

    } yield resp
  }

}

class HttpServiceGezApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def gezApi(jahr: Integer, betriebsstaetten: String, kfz: Long, hotelzimmer: Long, beschaefigte: Long)(implicit jahrQuery: QueryParam[Integer], betriebsstaettenQuery: QueryParam[String], kfzQuery: QueryParam[Long], hotelzimmerQuery: QueryParam[Long], beschaefigteQuery: QueryParam[Long]): Task[GezReport] = {
    implicit val returnTypeDecoder: EntityDecoder[GezReport] = jsonOf[GezReport]

    val path = "/api/v1/bookkeeping/gez"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("jahr", Some(jahrQuery.toParamString(jahr))), ("betriebsstaetten", Some(betriebsstaettenQuery.toParamString(betriebsstaetten))), ("kfz", Some(kfzQuery.toParamString(kfz))), ("hotelzimmer", Some(hotelzimmerQuery.toParamString(hotelzimmer))), ("beschaefigte", Some(beschaefigteQuery.toParamString(beschaefigte))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[GezReport](req)

    } yield resp
  }

}
