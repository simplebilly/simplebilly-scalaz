package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import RfqStatusUpdate._

case class RfqStatusUpdate (
  status: String)

object RfqStatusUpdate {
  import DateTimeCodecs._

  implicit val RfqStatusUpdateCodecJson: CodecJson[RfqStatusUpdate] = CodecJson.derive[RfqStatusUpdate]
  implicit val RfqStatusUpdateDecoder: EntityDecoder[RfqStatusUpdate] = jsonOf[RfqStatusUpdate]
  implicit val RfqStatusUpdateEncoder: EntityEncoder[RfqStatusUpdate] = jsonEncoderOf[RfqStatusUpdate]
}
