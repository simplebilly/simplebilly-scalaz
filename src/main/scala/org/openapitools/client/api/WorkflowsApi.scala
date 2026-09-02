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

import org.openapitools.client.api.PluginError
import org.openapitools.client.api.Workflow
import org.openapitools.client.api.WorkflowEnabledUpdate

object WorkflowsApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def listWorkflowsApi(host: String): Task[List[Workflow]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Workflow]] = jsonOf[List[Workflow]]

    val path = "/api/v1/workflows"

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
      resp          <- client.expect[List[Workflow]](req)

    } yield resp
  }

  def setWorkflowEnabledApi(host: String, workflowId: String, workflowEnabledUpdate: WorkflowEnabledUpdate): Task[Workflow] = {
    implicit val returnTypeDecoder: EntityDecoder[Workflow] = jsonOf[Workflow]

    val path = "/api/v1/workflows/{workflow_id}/enabled".replaceAll("\\{" + "workflow_id" + "\\}",escape(workflowId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(workflowEnabledUpdate)
      resp          <- client.expect[Workflow](req)

    } yield resp
  }

}

class HttpServiceWorkflowsApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def listWorkflowsApi(): Task[List[Workflow]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Workflow]] = jsonOf[List[Workflow]]

    val path = "/api/v1/workflows"

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
      resp          <- client.expect[List[Workflow]](req)

    } yield resp
  }

  def setWorkflowEnabledApi(workflowId: String, workflowEnabledUpdate: WorkflowEnabledUpdate): Task[Workflow] = {
    implicit val returnTypeDecoder: EntityDecoder[Workflow] = jsonOf[Workflow]

    val path = "/api/v1/workflows/{workflow_id}/enabled".replaceAll("\\{" + "workflow_id" + "\\}",escape(workflowId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(workflowEnabledUpdate)
      resp          <- client.expect[Workflow](req)

    } yield resp
  }

}
