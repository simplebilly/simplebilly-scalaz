package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import RateRequest._

case class RateRequest (
  customer: Option[CustomerInfo],
packages: List[ModelPackage],
recipient: Address,
sender: Address)

object RateRequest {
  import DateTimeCodecs._

  implicit val RateRequestCodecJson: CodecJson[RateRequest] = CodecJson.derive[RateRequest]
  implicit val RateRequestDecoder: EntityDecoder[RateRequest] = jsonOf[RateRequest]
  implicit val RateRequestEncoder: EntityEncoder[RateRequest] = jsonEncoderOf[RateRequest]
}
