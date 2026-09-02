package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ConvertResponse._

case class ConvertResponse (
  invoiceId: String,
invoiceNumber: String,
proformaId: String,
proformaNumber: String)

object ConvertResponse {
  import DateTimeCodecs._

  implicit val ConvertResponseCodecJson: CodecJson[ConvertResponse] = CodecJson.derive[ConvertResponse]
  implicit val ConvertResponseDecoder: EntityDecoder[ConvertResponse] = jsonOf[ConvertResponse]
  implicit val ConvertResponseEncoder: EntityEncoder[ConvertResponse] = jsonEncoderOf[ConvertResponse]
}
