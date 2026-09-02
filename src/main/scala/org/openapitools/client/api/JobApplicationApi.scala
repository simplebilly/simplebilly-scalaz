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

import org.openapitools.client.api.ApplicationStatusDto
import org.openapitools.client.api.JobApplication
import org.openapitools.client.api.PublicPosting
import java.util.UUID

object JobApplicationApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def applyPublic(host: String, postingId: UUID): Task[Unit] = {
    val path = "/api/v1/public/jobs/{posting_id}/apply".replaceAll("\\{" + "posting_id" + "\\}",escape(postingId.toString))

    val httpMethod = Method.POST
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

  def deleteJobApplication(host: String, applicationId: UUID): Task[JobApplication] = {
    implicit val returnTypeDecoder: EntityDecoder[JobApplication] = jsonOf[JobApplication]

    val path = "/api/v1/job-applications/{application_id}".replaceAll("\\{" + "application_id" + "\\}",escape(applicationId.toString))

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
      resp          <- client.expect[JobApplication](req)

    } yield resp
  }

  def downloadCv(host: String, applicationId: UUID): Task[Unit] = {
    val path = "/api/v1/job-applications/{application_id}/cv".replaceAll("\\{" + "application_id" + "\\}",escape(applicationId.toString))

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

  def getJobApplication(host: String, applicationId: UUID): Task[JobApplication] = {
    implicit val returnTypeDecoder: EntityDecoder[JobApplication] = jsonOf[JobApplication]

    val path = "/api/v1/job-applications/{application_id}".replaceAll("\\{" + "application_id" + "\\}",escape(applicationId.toString))

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
      resp          <- client.expect[JobApplication](req)

    } yield resp
  }

  def inboundEmail(host: String): Task[Unit] = {
    val path = "/api/v1/public/jobs/inbound-email"

    val httpMethod = Method.POST
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

  def listJobApplications(host: String, postingId: UUID, status: String, page: Integer, pageSize: Integer)(implicit postingIdQuery: QueryParam[UUID], statusQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[List[JobApplication]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[JobApplication]] = jsonOf[List[JobApplication]]

    val path = "/api/v1/job-applications"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("postingId", Some(postingIdQuery.toParamString(postingId))), ("status", Some(statusQuery.toParamString(status))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[JobApplication]](req)

    } yield resp
  }

  def listPublicPostings(host: String): Task[List[PublicPosting]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PublicPosting]] = jsonOf[List[PublicPosting]]

    val path = "/api/v1/public/jobs"

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
      resp          <- client.expect[List[PublicPosting]](req)

    } yield resp
  }

  def scoreJobApplication(host: String, applicationId: UUID): Task[JobApplication] = {
    implicit val returnTypeDecoder: EntityDecoder[JobApplication] = jsonOf[JobApplication]

    val path = "/api/v1/job-applications/{application_id}/score".replaceAll("\\{" + "application_id" + "\\}",escape(applicationId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[JobApplication](req)

    } yield resp
  }

  def updateJobApplicationStatus(host: String, applicationId: UUID, applicationStatusDto: ApplicationStatusDto): Task[JobApplication] = {
    implicit val returnTypeDecoder: EntityDecoder[JobApplication] = jsonOf[JobApplication]

    val path = "/api/v1/job-applications/{application_id}/status".replaceAll("\\{" + "application_id" + "\\}",escape(applicationId.toString))

    val httpMethod = Method.PATCH
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(applicationStatusDto)
      resp          <- client.expect[JobApplication](req)

    } yield resp
  }

}

class HttpServiceJobApplicationApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def applyPublic(postingId: UUID): Task[Unit] = {
    val path = "/api/v1/public/jobs/{posting_id}/apply".replaceAll("\\{" + "posting_id" + "\\}",escape(postingId.toString))

    val httpMethod = Method.POST
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

  def deleteJobApplication(applicationId: UUID): Task[JobApplication] = {
    implicit val returnTypeDecoder: EntityDecoder[JobApplication] = jsonOf[JobApplication]

    val path = "/api/v1/job-applications/{application_id}".replaceAll("\\{" + "application_id" + "\\}",escape(applicationId.toString))

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
      resp          <- client.expect[JobApplication](req)

    } yield resp
  }

  def downloadCv(applicationId: UUID): Task[Unit] = {
    val path = "/api/v1/job-applications/{application_id}/cv".replaceAll("\\{" + "application_id" + "\\}",escape(applicationId.toString))

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

  def getJobApplication(applicationId: UUID): Task[JobApplication] = {
    implicit val returnTypeDecoder: EntityDecoder[JobApplication] = jsonOf[JobApplication]

    val path = "/api/v1/job-applications/{application_id}".replaceAll("\\{" + "application_id" + "\\}",escape(applicationId.toString))

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
      resp          <- client.expect[JobApplication](req)

    } yield resp
  }

  def inboundEmail(): Task[Unit] = {
    val path = "/api/v1/public/jobs/inbound-email"

    val httpMethod = Method.POST
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

  def listJobApplications(postingId: UUID, status: String, page: Integer, pageSize: Integer)(implicit postingIdQuery: QueryParam[UUID], statusQuery: QueryParam[String], pageQuery: QueryParam[Integer], pageSizeQuery: QueryParam[Integer]): Task[List[JobApplication]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[JobApplication]] = jsonOf[List[JobApplication]]

    val path = "/api/v1/job-applications"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("postingId", Some(postingIdQuery.toParamString(postingId))), ("status", Some(statusQuery.toParamString(status))), ("page", Some(pageQuery.toParamString(page))), ("pageSize", Some(pageSizeQuery.toParamString(pageSize))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[JobApplication]](req)

    } yield resp
  }

  def listPublicPostings(): Task[List[PublicPosting]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PublicPosting]] = jsonOf[List[PublicPosting]]

    val path = "/api/v1/public/jobs"

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
      resp          <- client.expect[List[PublicPosting]](req)

    } yield resp
  }

  def scoreJobApplication(applicationId: UUID): Task[JobApplication] = {
    implicit val returnTypeDecoder: EntityDecoder[JobApplication] = jsonOf[JobApplication]

    val path = "/api/v1/job-applications/{application_id}/score".replaceAll("\\{" + "application_id" + "\\}",escape(applicationId.toString))

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[JobApplication](req)

    } yield resp
  }

  def updateJobApplicationStatus(applicationId: UUID, applicationStatusDto: ApplicationStatusDto): Task[JobApplication] = {
    implicit val returnTypeDecoder: EntityDecoder[JobApplication] = jsonOf[JobApplication]

    val path = "/api/v1/job-applications/{application_id}/status".replaceAll("\\{" + "application_id" + "\\}",escape(applicationId.toString))

    val httpMethod = Method.PATCH
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(applicationStatusDto)
      resp          <- client.expect[JobApplication](req)

    } yield resp
  }

}
