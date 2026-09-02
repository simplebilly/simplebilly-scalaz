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

import org.openapitools.client.api.ComplianceTraining
import org.openapitools.client.api.ComplianceTrainingCreate
import org.openapitools.client.api.ComplianceTrainingUpdate
import org.openapitools.client.api.PluginError
import java.util.UUID

object ComplianceTrainingApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createComplianceTraining(host: String, complianceTrainingCreate: ComplianceTrainingCreate): Task[ComplianceTraining] = {
    implicit val returnTypeDecoder: EntityDecoder[ComplianceTraining] = jsonOf[ComplianceTraining]

    val path = "/api/v1/compliance-trainings"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(complianceTrainingCreate)
      resp          <- client.expect[ComplianceTraining](req)

    } yield resp
  }

  def deleteComplianceTraining(host: String, id: UUID): Task[Unit] = {
    val path = "/api/v1/compliance-trainings/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def getComplianceTraining(host: String, id: UUID): Task[ComplianceTraining] = {
    implicit val returnTypeDecoder: EntityDecoder[ComplianceTraining] = jsonOf[ComplianceTraining]

    val path = "/api/v1/compliance-trainings/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[ComplianceTraining](req)

    } yield resp
  }

  def getComplianceTrainings(host: String, page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[ComplianceTraining]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ComplianceTraining]] = jsonOf[List[ComplianceTraining]]

    val path = "/api/v1/compliance-trainings/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("search", Some(searchQuery.toParamString(search))), ("includeDeleted", Some(include_deletedQuery.toParamString(include_deleted))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ComplianceTraining]](req)

    } yield resp
  }

  def updateComplianceTraining(host: String, id: UUID, complianceTrainingUpdate: ComplianceTrainingUpdate): Task[ComplianceTraining] = {
    implicit val returnTypeDecoder: EntityDecoder[ComplianceTraining] = jsonOf[ComplianceTraining]

    val path = "/api/v1/compliance-trainings/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(complianceTrainingUpdate)
      resp          <- client.expect[ComplianceTraining](req)

    } yield resp
  }

}

class HttpServiceComplianceTrainingApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createComplianceTraining(complianceTrainingCreate: ComplianceTrainingCreate): Task[ComplianceTraining] = {
    implicit val returnTypeDecoder: EntityDecoder[ComplianceTraining] = jsonOf[ComplianceTraining]

    val path = "/api/v1/compliance-trainings"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(complianceTrainingCreate)
      resp          <- client.expect[ComplianceTraining](req)

    } yield resp
  }

  def deleteComplianceTraining(id: UUID): Task[Unit] = {
    val path = "/api/v1/compliance-trainings/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def getComplianceTraining(id: UUID): Task[ComplianceTraining] = {
    implicit val returnTypeDecoder: EntityDecoder[ComplianceTraining] = jsonOf[ComplianceTraining]

    val path = "/api/v1/compliance-trainings/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[ComplianceTraining](req)

    } yield resp
  }

  def getComplianceTrainings(page: Integer, pageSize: Integer, search: String, includeDeleted: Boolean)(implicit pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer], searchQuery: QueryParam[String], includeDeletedQuery: QueryParam[Boolean]): Task[List[ComplianceTraining]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[ComplianceTraining]] = jsonOf[List[ComplianceTraining]]

    val path = "/api/v1/compliance-trainings/"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(page_sizeQuery.toParamString(page_size))), ("search", Some(searchQuery.toParamString(search))), ("includeDeleted", Some(include_deletedQuery.toParamString(include_deleted))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[ComplianceTraining]](req)

    } yield resp
  }

  def updateComplianceTraining(id: UUID, complianceTrainingUpdate: ComplianceTrainingUpdate): Task[ComplianceTraining] = {
    implicit val returnTypeDecoder: EntityDecoder[ComplianceTraining] = jsonOf[ComplianceTraining]

    val path = "/api/v1/compliance-trainings/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(complianceTrainingUpdate)
      resp          <- client.expect[ComplianceTraining](req)

    } yield resp
  }

}
