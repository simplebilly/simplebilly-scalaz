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

import org.openapitools.client.api.AcceptInviteRequest
import org.openapitools.client.api.AuthResponse
import org.openapitools.client.api.ForgotPasswordRequest
import org.openapitools.client.api.LoginRequest
import org.openapitools.client.api.MagicLinkRequest
import org.openapitools.client.api.MagicLinkVerifyRequest
import org.openapitools.client.api.RegisterRequest
import org.openapitools.client.api.ResetPasswordRequest
import org.openapitools.client.api.TotpEnableRequest
import org.openapitools.client.api.TotpSetupResponse
import org.openapitools.client.api.VerifyEmailRequest

object AuthApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def acceptInvite(host: String, acceptInviteRequest: AcceptInviteRequest): Task[Unit] = {
    val path = "/auth/accept-invite"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(acceptInviteRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def forgotPassword(host: String, forgotPasswordRequest: ForgotPasswordRequest): Task[Unit] = {
    val path = "/auth/forgot-password"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(forgotPasswordRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def login(host: String, loginRequest: LoginRequest): Task[AuthResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[AuthResponse] = jsonOf[AuthResponse]

    val path = "/auth/login"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(loginRequest)
      resp          <- client.expect[AuthResponse](req)

    } yield resp
  }

  def logout(host: String): Task[Unit] = {
    val path = "/auth/logout"

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

  def magicLinkLogin(host: String, magicLinkRequest: MagicLinkRequest): Task[Unit] = {
    val path = "/auth/magic-link"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(magicLinkRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def magicLinkVerify(host: String, magicLinkVerifyRequest: MagicLinkVerifyRequest): Task[AuthResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[AuthResponse] = jsonOf[AuthResponse]

    val path = "/auth/magic-link/verify"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(magicLinkVerifyRequest)
      resp          <- client.expect[AuthResponse](req)

    } yield resp
  }

  def register(host: String, registerRequest: RegisterRequest): Task[AuthResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[AuthResponse] = jsonOf[AuthResponse]

    val path = "/auth/register"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(registerRequest)
      resp          <- client.expect[AuthResponse](req)

    } yield resp
  }

  def resetPassword(host: String, resetPasswordRequest: ResetPasswordRequest): Task[Unit] = {
    val path = "/auth/reset-password"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(resetPasswordRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def totpEnable(host: String, totpEnableRequest: TotpEnableRequest): Task[Unit] = {
    val path = "/auth/totp/enable"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(totpEnableRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def totpSetup(host: String): Task[TotpSetupResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[TotpSetupResponse] = jsonOf[TotpSetupResponse]

    val path = "/auth/totp/setup"

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
      resp          <- client.expect[TotpSetupResponse](req)

    } yield resp
  }

  def verifyEmail(host: String, verifyEmailRequest: VerifyEmailRequest): Task[Unit] = {
    val path = "/auth/verify-email"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(verifyEmailRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

}

class HttpServiceAuthApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def acceptInvite(acceptInviteRequest: AcceptInviteRequest): Task[Unit] = {
    val path = "/auth/accept-invite"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(acceptInviteRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def forgotPassword(forgotPasswordRequest: ForgotPasswordRequest): Task[Unit] = {
    val path = "/auth/forgot-password"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(forgotPasswordRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def login(loginRequest: LoginRequest): Task[AuthResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[AuthResponse] = jsonOf[AuthResponse]

    val path = "/auth/login"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(loginRequest)
      resp          <- client.expect[AuthResponse](req)

    } yield resp
  }

  def logout(): Task[Unit] = {
    val path = "/auth/logout"

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

  def magicLinkLogin(magicLinkRequest: MagicLinkRequest): Task[Unit] = {
    val path = "/auth/magic-link"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(magicLinkRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def magicLinkVerify(magicLinkVerifyRequest: MagicLinkVerifyRequest): Task[AuthResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[AuthResponse] = jsonOf[AuthResponse]

    val path = "/auth/magic-link/verify"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(magicLinkVerifyRequest)
      resp          <- client.expect[AuthResponse](req)

    } yield resp
  }

  def register(registerRequest: RegisterRequest): Task[AuthResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[AuthResponse] = jsonOf[AuthResponse]

    val path = "/auth/register"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(registerRequest)
      resp          <- client.expect[AuthResponse](req)

    } yield resp
  }

  def resetPassword(resetPasswordRequest: ResetPasswordRequest): Task[Unit] = {
    val path = "/auth/reset-password"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(resetPasswordRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def totpEnable(totpEnableRequest: TotpEnableRequest): Task[Unit] = {
    val path = "/auth/totp/enable"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(totpEnableRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def totpSetup(): Task[TotpSetupResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[TotpSetupResponse] = jsonOf[TotpSetupResponse]

    val path = "/auth/totp/setup"

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
      resp          <- client.expect[TotpSetupResponse](req)

    } yield resp
  }

  def verifyEmail(verifyEmailRequest: VerifyEmailRequest): Task[Unit] = {
    val path = "/auth/verify-email"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(verifyEmailRequest)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

}
