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

import org.openapitools.client.api.SepaDirectDebitResponse

object CreateSepaDirectDebitApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createSepaDirectDebitApi(host: String, creditorName: String, creditorIban: String, creditorId: String, mandateId: String, mandateDate: String, debtorName: String, debtorIban: String, amount: String, collectionDate: String, creditorBic: String, debtorBic: String, description: String)(implicit creditorNameQuery: QueryParam[String], creditorIbanQuery: QueryParam[String], creditorBicQuery: QueryParam[String], creditorIdQuery: QueryParam[String], mandateIdQuery: QueryParam[String], mandateDateQuery: QueryParam[String], debtorNameQuery: QueryParam[String], debtorIbanQuery: QueryParam[String], debtorBicQuery: QueryParam[String], amountQuery: QueryParam[String], collectionDateQuery: QueryParam[String], descriptionQuery: QueryParam[String]): Task[SepaDirectDebitResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[SepaDirectDebitResponse] = jsonOf[SepaDirectDebitResponse]

    val path = "/api/v1/bookkeeping/sepa-direct-debit"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("creditorName", Some(creditor_nameQuery.toParamString(creditor_name))), ("creditorIban", Some(creditor_ibanQuery.toParamString(creditor_iban))), ("creditorBic", Some(creditor_bicQuery.toParamString(creditor_bic))), ("creditorId", Some(creditor_idQuery.toParamString(creditor_id))), ("mandateId", Some(mandate_idQuery.toParamString(mandate_id))), ("mandateDate", Some(mandate_dateQuery.toParamString(mandate_date))), ("debtorName", Some(debtor_nameQuery.toParamString(debtor_name))), ("debtorIban", Some(debtor_ibanQuery.toParamString(debtor_iban))), ("debtorBic", Some(debtor_bicQuery.toParamString(debtor_bic))), ("amount", Some(amountQuery.toParamString(amount))), ("collectionDate", Some(collection_dateQuery.toParamString(collection_date))), ("description", Some(descriptionQuery.toParamString(description))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[SepaDirectDebitResponse](req)

    } yield resp
  }

}

class HttpServiceCreateSepaDirectDebitApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def createSepaDirectDebitApi(creditorName: String, creditorIban: String, creditorId: String, mandateId: String, mandateDate: String, debtorName: String, debtorIban: String, amount: String, collectionDate: String, creditorBic: String, debtorBic: String, description: String)(implicit creditorNameQuery: QueryParam[String], creditorIbanQuery: QueryParam[String], creditorBicQuery: QueryParam[String], creditorIdQuery: QueryParam[String], mandateIdQuery: QueryParam[String], mandateDateQuery: QueryParam[String], debtorNameQuery: QueryParam[String], debtorIbanQuery: QueryParam[String], debtorBicQuery: QueryParam[String], amountQuery: QueryParam[String], collectionDateQuery: QueryParam[String], descriptionQuery: QueryParam[String]): Task[SepaDirectDebitResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[SepaDirectDebitResponse] = jsonOf[SepaDirectDebitResponse]

    val path = "/api/v1/bookkeeping/sepa-direct-debit"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("creditorName", Some(creditor_nameQuery.toParamString(creditor_name))), ("creditorIban", Some(creditor_ibanQuery.toParamString(creditor_iban))), ("creditorBic", Some(creditor_bicQuery.toParamString(creditor_bic))), ("creditorId", Some(creditor_idQuery.toParamString(creditor_id))), ("mandateId", Some(mandate_idQuery.toParamString(mandate_id))), ("mandateDate", Some(mandate_dateQuery.toParamString(mandate_date))), ("debtorName", Some(debtor_nameQuery.toParamString(debtor_name))), ("debtorIban", Some(debtor_ibanQuery.toParamString(debtor_iban))), ("debtorBic", Some(debtor_bicQuery.toParamString(debtor_bic))), ("amount", Some(amountQuery.toParamString(amount))), ("collectionDate", Some(collection_dateQuery.toParamString(collection_date))), ("description", Some(descriptionQuery.toParamString(description))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[SepaDirectDebitResponse](req)

    } yield resp
  }

}
