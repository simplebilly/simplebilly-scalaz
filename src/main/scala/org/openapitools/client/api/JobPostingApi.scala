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

import org.openapitools.client.api.JobPosting
import org.openapitools.client.api.JobPostingCreate
import org.openapitools.client.api.JobPostingUpdate
import org.openapitools.client.api.PluginError
import java.util.UUID

object JobPostingApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createJobPosting(host: String, jobPostingCreate: JobPostingCreate): Task[JobPosting] = {
    implicit val returnTypeDecoder: EntityDecoder[JobPosting] = jsonOf[JobPosting]

    val path = "/api/v1/job-postings"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(jobPostingCreate)
      resp          <- client.expect[JobPosting](req)

    } yield resp
  }

  def deleteJobPosting(host: String, id: UUID): Task[Unit] = {
    val path = "/api/v1/job-postings/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def getJobPosting(host: String, id: UUID): Task[JobPosting] = {
    implicit val returnTypeDecoder: EntityDecoder[JobPosting] = jsonOf[JobPosting]

    val path = "/api/v1/job-postings/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[JobPosting](req)

    } yield resp
  }

  def listJobPostings(host: String, status: String, page: Integer, pageSize: Integer)(implicit statusQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[List[JobPosting]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[JobPosting]] = jsonOf[List[JobPosting]]

    val path = "/api/v1/job-postings"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("status", Some(statusQuery.toParamString(status))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[JobPosting]](req)

    } yield resp
  }

  def updateJobPosting(host: String, id: UUID, jobPostingUpdate: JobPostingUpdate): Task[JobPosting] = {
    implicit val returnTypeDecoder: EntityDecoder[JobPosting] = jsonOf[JobPosting]

    val path = "/api/v1/job-postings/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(jobPostingUpdate)
      resp          <- client.expect[JobPosting](req)

    } yield resp
  }

}

class HttpServiceJobPostingApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createJobPosting(jobPostingCreate: JobPostingCreate): Task[JobPosting] = {
    implicit val returnTypeDecoder: EntityDecoder[JobPosting] = jsonOf[JobPosting]

    val path = "/api/v1/job-postings"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(jobPostingCreate)
      resp          <- client.expect[JobPosting](req)

    } yield resp
  }

  def deleteJobPosting(id: UUID): Task[Unit] = {
    val path = "/api/v1/job-postings/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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

  def getJobPosting(id: UUID): Task[JobPosting] = {
    implicit val returnTypeDecoder: EntityDecoder[JobPosting] = jsonOf[JobPosting]

    val path = "/api/v1/job-postings/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

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
      resp          <- client.expect[JobPosting](req)

    } yield resp
  }

  def listJobPostings(status: String, page: Integer, pageSize: Integer)(implicit statusQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[List[JobPosting]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[JobPosting]] = jsonOf[List[JobPosting]]

    val path = "/api/v1/job-postings"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("status", Some(statusQuery.toParamString(status))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[JobPosting]](req)

    } yield resp
  }

  def updateJobPosting(id: UUID, jobPostingUpdate: JobPostingUpdate): Task[JobPosting] = {
    implicit val returnTypeDecoder: EntityDecoder[JobPosting] = jsonOf[JobPosting]

    val path = "/api/v1/job-postings/{id}".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(jobPostingUpdate)
      resp          <- client.expect[JobPosting](req)

    } yield resp
  }

}
