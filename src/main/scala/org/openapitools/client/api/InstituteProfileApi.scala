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

import org.openapitools.client.api.InstituteProfile
import org.openapitools.client.api.InstituteProfileUpdate
import org.openapitools.client.api.PluginError

object InstituteProfileApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getInstituteProfile(host: String): Task[InstituteProfile] = {
    implicit val returnTypeDecoder: EntityDecoder[InstituteProfile] = jsonOf[InstituteProfile]

    val path = "/api/v1/institute-profile"

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
      resp          <- client.expect[InstituteProfile](req)

    } yield resp
  }

  def updateInstituteProfile(host: String, instituteProfileUpdate: InstituteProfileUpdate): Task[InstituteProfile] = {
    implicit val returnTypeDecoder: EntityDecoder[InstituteProfile] = jsonOf[InstituteProfile]

    val path = "/api/v1/institute-profile"

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(instituteProfileUpdate)
      resp          <- client.expect[InstituteProfile](req)

    } yield resp
  }

}

class HttpServiceInstituteProfileApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getInstituteProfile(): Task[InstituteProfile] = {
    implicit val returnTypeDecoder: EntityDecoder[InstituteProfile] = jsonOf[InstituteProfile]

    val path = "/api/v1/institute-profile"

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
      resp          <- client.expect[InstituteProfile](req)

    } yield resp
  }

  def updateInstituteProfile(instituteProfileUpdate: InstituteProfileUpdate): Task[InstituteProfile] = {
    implicit val returnTypeDecoder: EntityDecoder[InstituteProfile] = jsonOf[InstituteProfile]

    val path = "/api/v1/institute-profile"

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(instituteProfileUpdate)
      resp          <- client.expect[InstituteProfile](req)

    } yield resp
  }

}
