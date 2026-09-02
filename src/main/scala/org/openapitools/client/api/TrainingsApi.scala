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

import org.openapitools.client.api.HrTrainingOverview
import org.openapitools.client.api.MyTrainingItem
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.SubmitResultDto
import org.openapitools.client.api.SubmitResultResponse
import org.openapitools.client.api.TrainingContent

object TrainingsApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getMyTrainings(host: String): Task[List[MyTrainingItem]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[MyTrainingItem]] = jsonOf[List[MyTrainingItem]]

    val path = "/api/v1/trainings/me"

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
      resp          <- client.expect[List[MyTrainingItem]](req)

    } yield resp
  }

  def getTrainingContent(host: String, code: String): Task[TrainingContent] = {
    implicit val returnTypeDecoder: EntityDecoder[TrainingContent] = jsonOf[TrainingContent]

    val path = "/api/v1/trainings/content/{code}".replaceAll("\\{" + "code" + "\\}",escape(code.toString))

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
      resp          <- client.expect[TrainingContent](req)

    } yield resp
  }

  def getTrainingOverview(host: String): Task[List[HrTrainingOverview]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[HrTrainingOverview]] = jsonOf[List[HrTrainingOverview]]

    val path = "/api/v1/trainings/overview"

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
      resp          <- client.expect[List[HrTrainingOverview]](req)

    } yield resp
  }

  def submitTrainingResult(host: String, submitResultDto: SubmitResultDto): Task[SubmitResultResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[SubmitResultResponse] = jsonOf[SubmitResultResponse]

    val path = "/api/v1/trainings/submit-result"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(submitResultDto)
      resp          <- client.expect[SubmitResultResponse](req)

    } yield resp
  }

}

class HttpServiceTrainingsApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getMyTrainings(): Task[List[MyTrainingItem]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[MyTrainingItem]] = jsonOf[List[MyTrainingItem]]

    val path = "/api/v1/trainings/me"

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
      resp          <- client.expect[List[MyTrainingItem]](req)

    } yield resp
  }

  def getTrainingContent(code: String): Task[TrainingContent] = {
    implicit val returnTypeDecoder: EntityDecoder[TrainingContent] = jsonOf[TrainingContent]

    val path = "/api/v1/trainings/content/{code}".replaceAll("\\{" + "code" + "\\}",escape(code.toString))

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
      resp          <- client.expect[TrainingContent](req)

    } yield resp
  }

  def getTrainingOverview(): Task[List[HrTrainingOverview]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[HrTrainingOverview]] = jsonOf[List[HrTrainingOverview]]

    val path = "/api/v1/trainings/overview"

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
      resp          <- client.expect[List[HrTrainingOverview]](req)

    } yield resp
  }

  def submitTrainingResult(submitResultDto: SubmitResultDto): Task[SubmitResultResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[SubmitResultResponse] = jsonOf[SubmitResultResponse]

    val path = "/api/v1/trainings/submit-result"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(submitResultDto)
      resp          <- client.expect[SubmitResultResponse](req)

    } yield resp
  }

}
