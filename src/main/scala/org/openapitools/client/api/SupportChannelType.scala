package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SupportChannelType._

case class SupportChannelType (
  
object SupportChannelType {
  import DateTimeCodecs._

  implicit val SupportChannelTypeCodecJson: CodecJson[SupportChannelType] = CodecJson.derive[SupportChannelType]
  implicit val SupportChannelTypeDecoder: EntityDecoder[SupportChannelType] = jsonOf[SupportChannelType]
  implicit val SupportChannelTypeEncoder: EntityEncoder[SupportChannelType] = jsonEncoderOf[SupportChannelType]
}
