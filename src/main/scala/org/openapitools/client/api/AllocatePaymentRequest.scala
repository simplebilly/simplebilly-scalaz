package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import AllocatePaymentRequest._

case class AllocatePaymentRequest (
  amount: Double,
invoiceId: String,
paymentId: UUID)

object AllocatePaymentRequest {
  import DateTimeCodecs._

  implicit val AllocatePaymentRequestCodecJson: CodecJson[AllocatePaymentRequest] = CodecJson.derive[AllocatePaymentRequest]
  implicit val AllocatePaymentRequestDecoder: EntityDecoder[AllocatePaymentRequest] = jsonOf[AllocatePaymentRequest]
  implicit val AllocatePaymentRequestEncoder: EntityEncoder[AllocatePaymentRequest] = jsonEncoderOf[AllocatePaymentRequest]
}
