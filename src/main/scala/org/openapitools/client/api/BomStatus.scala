package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import BomStatus._

case class BomStatus (
  
object BomStatus {
  import DateTimeCodecs._

  implicit val BomStatusCodecJson: CodecJson[BomStatus] = CodecJson.derive[BomStatus]
  implicit val BomStatusDecoder: EntityDecoder[BomStatus] = jsonOf[BomStatus]
  implicit val BomStatusEncoder: EntityEncoder[BomStatus] = jsonEncoderOf[BomStatus]
}
