package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SuitabilityRequest._

case class SuitabilityRequest (
  customerAnnualVolume: Option[Integer],
items: List[CartItemInput],
recipient: Address,
sender: Address)

object SuitabilityRequest {
  import DateTimeCodecs._

  implicit val SuitabilityRequestCodecJson: CodecJson[SuitabilityRequest] = CodecJson.derive[SuitabilityRequest]
  implicit val SuitabilityRequestDecoder: EntityDecoder[SuitabilityRequest] = jsonOf[SuitabilityRequest]
  implicit val SuitabilityRequestEncoder: EntityEncoder[SuitabilityRequest] = jsonEncoderOf[SuitabilityRequest]
}
