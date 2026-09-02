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

import org.openapitools.client.api.TenantUser
import java.util.UUID
import org.openapitools.client.api.UpdatePermissionsPayload
import org.openapitools.client.api.UpdateRolePayload

object UserManagementApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getUser(host: String, userId: UUID): Task[TenantUser] = {
    implicit val returnTypeDecoder: EntityDecoder[TenantUser] = jsonOf[TenantUser]

    val path = "/api/v1/users/{user_id}".replaceAll("\\{" + "user_id" + "\\}",escape(userId.toString))

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
      resp          <- client.expect[TenantUser](req)

    } yield resp
  }

  def listUsers(host: String): Task[List[TenantUser]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[TenantUser]] = jsonOf[List[TenantUser]]

    val path = "/api/v1/users"

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
      resp          <- client.expect[List[TenantUser]](req)

    } yield resp
  }

  def removeUser(host: String, userId: UUID): Task[Unit] = {
    val path = "/api/v1/users/{user_id}".replaceAll("\\{" + "user_id" + "\\}",escape(userId.toString))

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

  def updateUserPermissions(host: String, userId: UUID, updatePermissionsPayload: UpdatePermissionsPayload): Task[Unit] = {
    val path = "/api/v1/users/{user_id}/permissions".replaceAll("\\{" + "user_id" + "\\}",escape(userId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updatePermissionsPayload)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def updateUserRole(host: String, userId: UUID, updateRolePayload: UpdateRolePayload): Task[Unit] = {
    val path = "/api/v1/users/{user_id}/role".replaceAll("\\{" + "user_id" + "\\}",escape(userId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateRolePayload)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

}

class HttpServiceUserManagementApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getUser(userId: UUID): Task[TenantUser] = {
    implicit val returnTypeDecoder: EntityDecoder[TenantUser] = jsonOf[TenantUser]

    val path = "/api/v1/users/{user_id}".replaceAll("\\{" + "user_id" + "\\}",escape(userId.toString))

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
      resp          <- client.expect[TenantUser](req)

    } yield resp
  }

  def listUsers(): Task[List[TenantUser]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[TenantUser]] = jsonOf[List[TenantUser]]

    val path = "/api/v1/users"

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
      resp          <- client.expect[List[TenantUser]](req)

    } yield resp
  }

  def removeUser(userId: UUID): Task[Unit] = {
    val path = "/api/v1/users/{user_id}".replaceAll("\\{" + "user_id" + "\\}",escape(userId.toString))

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

  def updateUserPermissions(userId: UUID, updatePermissionsPayload: UpdatePermissionsPayload): Task[Unit] = {
    val path = "/api/v1/users/{user_id}/permissions".replaceAll("\\{" + "user_id" + "\\}",escape(userId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updatePermissionsPayload)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def updateUserRole(userId: UUID, updateRolePayload: UpdateRolePayload): Task[Unit] = {
    val path = "/api/v1/users/{user_id}/role".replaceAll("\\{" + "user_id" + "\\}",escape(userId.toString))

    val httpMethod = Method.PUT
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(updateRolePayload)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

}
