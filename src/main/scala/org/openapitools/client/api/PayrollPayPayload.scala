package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import PayrollPayPayload._

case class PayrollPayPayload (
  paymentDate: LocalDate)

object PayrollPayPayload {
  import DateTimeCodecs._

  implicit val PayrollPayPayloadCodecJson: CodecJson[PayrollPayPayload] = CodecJson.derive[PayrollPayPayload]
  implicit val PayrollPayPayloadDecoder: EntityDecoder[PayrollPayPayload] = jsonOf[PayrollPayPayload]
  implicit val PayrollPayPayloadEncoder: EntityEncoder[PayrollPayPayload] = jsonEncoderOf[PayrollPayPayload]
}
