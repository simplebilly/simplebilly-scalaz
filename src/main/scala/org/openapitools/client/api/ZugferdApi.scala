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


object ZugferdApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def generateZugferdApi(host: String, id: String, supplierName: String, supplierStreet: String, supplierCity: String, supplierZip: String, supplierCountry: String, supplierVatId: String)(implicit supplierNameQuery: QueryParam[String], supplierStreetQuery: QueryParam[String], supplierCityQuery: QueryParam[String], supplierZipQuery: QueryParam[String], supplierCountryQuery: QueryParam[String], supplierVatIdQuery: QueryParam[String]): Task[Unit] = {
    val path = "/api/v1/invoices/{id}/zugferd".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("supplierName", Some(supplier_nameQuery.toParamString(supplier_name))), ("supplierStreet", Some(supplier_streetQuery.toParamString(supplier_street))), ("supplierCity", Some(supplier_cityQuery.toParamString(supplier_city))), ("supplierZip", Some(supplier_zipQuery.toParamString(supplier_zip))), ("supplierCountry", Some(supplier_countryQuery.toParamString(supplier_country))), ("supplierVatId", Some(supplier_vat_idQuery.toParamString(supplier_vat_id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

}

class HttpServiceZugferdApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def generateZugferdApi(id: String, supplierName: String, supplierStreet: String, supplierCity: String, supplierZip: String, supplierCountry: String, supplierVatId: String)(implicit supplierNameQuery: QueryParam[String], supplierStreetQuery: QueryParam[String], supplierCityQuery: QueryParam[String], supplierZipQuery: QueryParam[String], supplierCountryQuery: QueryParam[String], supplierVatIdQuery: QueryParam[String]): Task[Unit] = {
    val path = "/api/v1/invoices/{id}/zugferd".replaceAll("\\{" + "id" + "\\}",escape(id.toString))

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("supplierName", Some(supplier_nameQuery.toParamString(supplier_name))), ("supplierStreet", Some(supplier_streetQuery.toParamString(supplier_street))), ("supplierCity", Some(supplier_cityQuery.toParamString(supplier_city))), ("supplierZip", Some(supplier_zipQuery.toParamString(supplier_zip))), ("supplierCountry", Some(supplier_countryQuery.toParamString(supplier_country))), ("supplierVatId", Some(supplier_vat_idQuery.toParamString(supplier_vat_id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

}
