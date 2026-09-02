package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GatewayType._

case class GatewayType (
  
object GatewayType {
  import DateTimeCodecs._

  implicit val GatewayTypeCodecJson: CodecJson[GatewayType] = CodecJson.derive[GatewayType]
  implicit val GatewayTypeDecoder: EntityDecoder[GatewayType] = jsonOf[GatewayType]
  implicit val GatewayTypeEncoder: EntityEncoder[GatewayType] = jsonEncoderOf[GatewayType]
}
