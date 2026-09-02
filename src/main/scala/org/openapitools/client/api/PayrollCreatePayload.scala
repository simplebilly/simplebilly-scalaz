package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import PayrollCreatePayload._

case class PayrollCreatePayload (
  employeeIds: List[UUID],
extraPayments: Option[List[ExtraPayment]],
month: Integer,
year: Integer)

object PayrollCreatePayload {
  import DateTimeCodecs._

  implicit val PayrollCreatePayloadCodecJson: CodecJson[PayrollCreatePayload] = CodecJson.derive[PayrollCreatePayload]
  implicit val PayrollCreatePayloadDecoder: EntityDecoder[PayrollCreatePayload] = jsonOf[PayrollCreatePayload]
  implicit val PayrollCreatePayloadEncoder: EntityEncoder[PayrollCreatePayload] = jsonEncoderOf[PayrollCreatePayload]
}
