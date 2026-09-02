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

import org.openapitools.client.api.AnyType
import org.openapitools.client.api.PluginError
import org.openapitools.client.api.PostingCategory

object PostingCategoryApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createPostingCategory(host: String, body: AnyType): Task[PostingCategory] = {
    implicit val returnTypeDecoder: EntityDecoder[PostingCategory] = jsonOf[PostingCategory]

    val path = "/api/v1/posting-categories"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[PostingCategory](req)

    } yield resp
  }

  def deletePostingCategory(host: String, categoryId: String): Task[Unit] = {
    val path = "/api/v1/posting-categories/{category_id}".replaceAll("\\{" + "category_id" + "\\}",escape(categoryId.toString))

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

  def listPostingCategories(host: String): Task[List[PostingCategory]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PostingCategory]] = jsonOf[List[PostingCategory]]

    val path = "/api/v1/posting-categories"

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
      resp          <- client.expect[List[PostingCategory]](req)

    } yield resp
  }

  def seedPostingCategories(host: String, skrVersion: String): Task[Unit] = {
    val path = "/api/v1/posting-categories/seed/{skr_version}".replaceAll("\\{" + "skr_version" + "\\}",escape(skrVersion.toString))

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

  def updatePostingCategory(host: String, categoryId: String, body: AnyType): Task[PostingCategory] = {
    implicit val returnTypeDecoder: EntityDecoder[PostingCategory] = jsonOf[PostingCategory]

    val path = "/api/v1/posting-categories/{category_id}".replaceAll("\\{" + "category_id" + "\\}",escape(categoryId.toString))

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
      resp          <- client.expect[PostingCategory](req)

    } yield resp
  }

}

class HttpServicePostingCategoryApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createPostingCategory(body: AnyType): Task[PostingCategory] = {
    implicit val returnTypeDecoder: EntityDecoder[PostingCategory] = jsonOf[PostingCategory]

    val path = "/api/v1/posting-categories"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[PostingCategory](req)

    } yield resp
  }

  def deletePostingCategory(categoryId: String): Task[Unit] = {
    val path = "/api/v1/posting-categories/{category_id}".replaceAll("\\{" + "category_id" + "\\}",escape(categoryId.toString))

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

  def listPostingCategories(): Task[List[PostingCategory]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[PostingCategory]] = jsonOf[List[PostingCategory]]

    val path = "/api/v1/posting-categories"

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
      resp          <- client.expect[List[PostingCategory]](req)

    } yield resp
  }

  def seedPostingCategories(skrVersion: String): Task[Unit] = {
    val path = "/api/v1/posting-categories/seed/{skr_version}".replaceAll("\\{" + "skr_version" + "\\}",escape(skrVersion.toString))

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

  def updatePostingCategory(categoryId: String, body: AnyType): Task[PostingCategory] = {
    implicit val returnTypeDecoder: EntityDecoder[PostingCategory] = jsonOf[PostingCategory]

    val path = "/api/v1/posting-categories/{category_id}".replaceAll("\\{" + "category_id" + "\\}",escape(categoryId.toString))

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
      resp          <- client.expect[PostingCategory](req)

    } yield resp
  }

}
