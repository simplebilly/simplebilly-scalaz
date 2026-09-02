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

import org.openapitools.client.api.Activity
import org.openapitools.client.api.ActivityStatusUpdate
import org.openapitools.client.api.AnyType
import org.openapitools.client.api.PluginError

object ActivityApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createActivity(host: String, activity: Activity): Task[Activity] = {
    implicit val returnTypeDecoder: EntityDecoder[Activity] = jsonOf[Activity]

    val path = "/api/v1/activities"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(activity)
      resp          <- client.expect[Activity](req)

    } yield resp
  }

  def deleteActivity(host: String, activityId: String): Task[Unit] = {
    val path = "/api/v1/activities/{activity_id}".replaceAll("\\{" + "activity_id" + "\\}",escape(activityId.toString))

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

  def getActivity(host: String, activityId: String): Task[Activity] = {
    implicit val returnTypeDecoder: EntityDecoder[Activity] = jsonOf[Activity]

    val path = "/api/v1/activities/{activity_id}".replaceAll("\\{" + "activity_id" + "\\}",escape(activityId.toString))

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
      resp          <- client.expect[Activity](req)

    } yield resp
  }

  def listActivities(host: String, page: Integer, pageSize: Integer, contactId: String, activityType: String, status: String, assignedTo: String, overdueOnly: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], contactIdQuery: QueryParam[String], activityTypeQuery: QueryParam[String], statusQuery: QueryParam[String], assignedToQuery: QueryParam[String], overdueOnlyQuery: QueryParam[Boolean]): Task[List[Activity]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Activity]] = jsonOf[List[Activity]]

    val path = "/api/v1/activities/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("contactId", Some(contactIdQuery.toParamString(contactId))), ("activityType", Some(activityTypeQuery.toParamString(activityType))), ("status", Some(statusQuery.toParamString(status))), ("assignedTo", Some(assignedToQuery.toParamString(assignedTo))), ("overdueOnly", Some(overdueOnlyQuery.toParamString(overdueOnly))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Activity]](req)

    } yield resp
  }

  def updateActivity(host: String, activityId: String, body: AnyType): Task[Activity] = {
    implicit val returnTypeDecoder: EntityDecoder[Activity] = jsonOf[Activity]

    val path = "/api/v1/activities/{activity_id}".replaceAll("\\{" + "activity_id" + "\\}",escape(activityId.toString))

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
      resp          <- client.expect[Activity](req)

    } yield resp
  }

  def updateActivityStatus(host: String, activityId: String, activityStatusUpdate: ActivityStatusUpdate): Task[Activity] = {
    implicit val returnTypeDecoder: EntityDecoder[Activity] = jsonOf[Activity]

    val path = "/api/v1/activities/{activity_id}/status".replaceAll("\\{" + "activity_id" + "\\}",escape(activityId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(activityStatusUpdate)
      resp          <- client.expect[Activity](req)

    } yield resp
  }

}

class HttpServiceActivityApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createActivity(activity: Activity): Task[Activity] = {
    implicit val returnTypeDecoder: EntityDecoder[Activity] = jsonOf[Activity]

    val path = "/api/v1/activities"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(activity)
      resp          <- client.expect[Activity](req)

    } yield resp
  }

  def deleteActivity(activityId: String): Task[Unit] = {
    val path = "/api/v1/activities/{activity_id}".replaceAll("\\{" + "activity_id" + "\\}",escape(activityId.toString))

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

  def getActivity(activityId: String): Task[Activity] = {
    implicit val returnTypeDecoder: EntityDecoder[Activity] = jsonOf[Activity]

    val path = "/api/v1/activities/{activity_id}".replaceAll("\\{" + "activity_id" + "\\}",escape(activityId.toString))

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
      resp          <- client.expect[Activity](req)

    } yield resp
  }

  def listActivities(page: Integer, pageSize: Integer, contactId: String, activityType: String, status: String, assignedTo: String, overdueOnly: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], contactIdQuery: QueryParam[String], activityTypeQuery: QueryParam[String], statusQuery: QueryParam[String], assignedToQuery: QueryParam[String], overdueOnlyQuery: QueryParam[Boolean]): Task[List[Activity]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Activity]] = jsonOf[List[Activity]]

    val path = "/api/v1/activities/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))), ("contactId", Some(contactIdQuery.toParamString(contactId))), ("activityType", Some(activityTypeQuery.toParamString(activityType))), ("status", Some(statusQuery.toParamString(status))), ("assignedTo", Some(assignedToQuery.toParamString(assignedTo))), ("overdueOnly", Some(overdueOnlyQuery.toParamString(overdueOnly))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Activity]](req)

    } yield resp
  }

  def updateActivity(activityId: String, body: AnyType): Task[Activity] = {
    implicit val returnTypeDecoder: EntityDecoder[Activity] = jsonOf[Activity]

    val path = "/api/v1/activities/{activity_id}".replaceAll("\\{" + "activity_id" + "\\}",escape(activityId.toString))

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
      resp          <- client.expect[Activity](req)

    } yield resp
  }

  def updateActivityStatus(activityId: String, activityStatusUpdate: ActivityStatusUpdate): Task[Activity] = {
    implicit val returnTypeDecoder: EntityDecoder[Activity] = jsonOf[Activity]

    val path = "/api/v1/activities/{activity_id}/status".replaceAll("\\{" + "activity_id" + "\\}",escape(activityId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(activityStatusUpdate)
      resp          <- client.expect[Activity](req)

    } yield resp
  }

}
