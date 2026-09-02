package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SepaDirectDebitResponse._

case class SepaDirectDebitResponse (
  `contentType`: String,
filename: String,
xmlContent: String)

object SepaDirectDebitResponse {
  import DateTimeCodecs._

  implicit val SepaDirectDebitResponseCodecJson: CodecJson[SepaDirectDebitResponse] = CodecJson.derive[SepaDirectDebitResponse]
  implicit val SepaDirectDebitResponseDecoder: EntityDecoder[SepaDirectDebitResponse] = jsonOf[SepaDirectDebitResponse]
  implicit val SepaDirectDebitResponseEncoder: EntityEncoder[SepaDirectDebitResponse] = jsonEncoderOf[SepaDirectDebitResponse]
}
