package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DpaStatus._

case class DpaStatus (
  accepted: Boolean,
acceptedAt: Option[String],
acceptedBy: Option[String],
version: Option[String])

object DpaStatus {
  import DateTimeCodecs._

  implicit val DpaStatusCodecJson: CodecJson[DpaStatus] = CodecJson.derive[DpaStatus]
  implicit val DpaStatusDecoder: EntityDecoder[DpaStatus] = jsonOf[DpaStatus]
  implicit val DpaStatusEncoder: EntityEncoder[DpaStatus] = jsonEncoderOf[DpaStatus]
}
