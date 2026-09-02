package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import PayrollAutopayPayload._

case class PayrollAutopayPayload (
  debtorBic: Option[String],
debtorIban: Option[String],
debtorName: Option[String],
executionDate: Option[LocalDate])

object PayrollAutopayPayload {
  import DateTimeCodecs._

  implicit val PayrollAutopayPayloadCodecJson: CodecJson[PayrollAutopayPayload] = CodecJson.derive[PayrollAutopayPayload]
  implicit val PayrollAutopayPayloadDecoder: EntityDecoder[PayrollAutopayPayload] = jsonOf[PayrollAutopayPayload]
  implicit val PayrollAutopayPayloadEncoder: EntityEncoder[PayrollAutopayPayload] = jsonEncoderOf[PayrollAutopayPayload]
}
