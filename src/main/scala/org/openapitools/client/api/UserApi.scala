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

import org.openapitools.client.api.ApiResponseString
import org.openapitools.client.api.ApiResponseTeam
import org.openapitools.client.api.ApiResponseUserProfile
import org.openapitools.client.api.ApiResponseVecTeam
import org.openapitools.client.api.ApiResponseVecUserTenantInfo
import org.openapitools.client.api.ChangePasswordRequest
import org.openapitools.client.api.InviteRequest
import org.openapitools.client.api.RemoveUserRequest
import org.openapitools.client.api.TeamCreate
import org.openapitools.client.api.UpdateProfileRequest

object UserApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def changePassword(host: String, changePasswordRequest: ChangePasswordRequest): Task[Unit] = {
    val path = "/user/change-password"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(changePasswordRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def createTeam(host: String, teamCreate: TeamCreate): Task[ApiResponseTeam] = {
    implicit val returnTypeDecoder: EntityDecoder[ApiResponseTeam] = jsonOf[ApiResponseTeam]

    val path = "/user/teams"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(teamCreate)
      resp          <- client.expect[ApiResponseTeam](req)

    } yield resp
  }

  def generateApiKey(host: String): Task[ApiResponseString] = {
    implicit val returnTypeDecoder: EntityDecoder[ApiResponseString] = jsonOf[ApiResponseString]

    val path = "/user/api-key"

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
      resp          <- client.expect[ApiResponseString](req)

    } yield resp
  }

  def inviteUser(host: String, inviteRequest: InviteRequest): Task[Unit] = {
    val path = "/user/invite"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(inviteRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def listTeams(host: String): Task[ApiResponseVecTeam] = {
    implicit val returnTypeDecoder: EntityDecoder[ApiResponseVecTeam] = jsonOf[ApiResponseVecTeam]

    val path = "/user/teams"

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
      resp          <- client.expect[ApiResponseVecTeam](req)

    } yield resp
  }

  def removeUserFromOrg(host: String, removeUserRequest: RemoveUserRequest): Task[Unit] = {
    val path = "/user/remove"

    val httpMethod = Method.DELETE
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(removeUserRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def updateProfile(host: String, updateProfileRequest: UpdateProfileRequest): Task[Unit] = {
    val path = "/user/profile"

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateProfileRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def userProfile(host: String): Task[ApiResponseUserProfile] = {
    implicit val returnTypeDecoder: EntityDecoder[ApiResponseUserProfile] = jsonOf[ApiResponseUserProfile]

    val path = "/user/profile"

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
      resp          <- client.expect[ApiResponseUserProfile](req)

    } yield resp
  }

  def userTenants(host: String): Task[ApiResponseVecUserTenantInfo] = {
    implicit val returnTypeDecoder: EntityDecoder[ApiResponseVecUserTenantInfo] = jsonOf[ApiResponseVecUserTenantInfo]

    val path = "/user/tenants"

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
      resp          <- client.expect[ApiResponseVecUserTenantInfo](req)

    } yield resp
  }

}

class HttpServiceUserApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def changePassword(changePasswordRequest: ChangePasswordRequest): Task[Unit] = {
    val path = "/user/change-password"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(changePasswordRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def createTeam(teamCreate: TeamCreate): Task[ApiResponseTeam] = {
    implicit val returnTypeDecoder: EntityDecoder[ApiResponseTeam] = jsonOf[ApiResponseTeam]

    val path = "/user/teams"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(teamCreate)
      resp          <- client.expect[ApiResponseTeam](req)

    } yield resp
  }

  def generateApiKey(): Task[ApiResponseString] = {
    implicit val returnTypeDecoder: EntityDecoder[ApiResponseString] = jsonOf[ApiResponseString]

    val path = "/user/api-key"

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
      resp          <- client.expect[ApiResponseString](req)

    } yield resp
  }

  def inviteUser(inviteRequest: InviteRequest): Task[Unit] = {
    val path = "/user/invite"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(inviteRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def listTeams(): Task[ApiResponseVecTeam] = {
    implicit val returnTypeDecoder: EntityDecoder[ApiResponseVecTeam] = jsonOf[ApiResponseVecTeam]

    val path = "/user/teams"

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
      resp          <- client.expect[ApiResponseVecTeam](req)

    } yield resp
  }

  def removeUserFromOrg(removeUserRequest: RemoveUserRequest): Task[Unit] = {
    val path = "/user/remove"

    val httpMethod = Method.DELETE
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(removeUserRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def updateProfile(updateProfileRequest: UpdateProfileRequest): Task[Unit] = {
    val path = "/user/profile"

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateProfileRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def userProfile(): Task[ApiResponseUserProfile] = {
    implicit val returnTypeDecoder: EntityDecoder[ApiResponseUserProfile] = jsonOf[ApiResponseUserProfile]

    val path = "/user/profile"

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
      resp          <- client.expect[ApiResponseUserProfile](req)

    } yield resp
  }

  def userTenants(): Task[ApiResponseVecUserTenantInfo] = {
    implicit val returnTypeDecoder: EntityDecoder[ApiResponseVecUserTenantInfo] = jsonOf[ApiResponseVecUserTenantInfo]

    val path = "/user/tenants"

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
      resp          <- client.expect[ApiResponseVecUserTenantInfo](req)

    } yield resp
  }

}
