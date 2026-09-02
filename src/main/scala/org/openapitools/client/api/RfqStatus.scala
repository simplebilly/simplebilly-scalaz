package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import RfqStatus._

case class RfqStatus (
  
object RfqStatus {
  import DateTimeCodecs._

  implicit val RfqStatusCodecJson: CodecJson[RfqStatus] = CodecJson.derive[RfqStatus]
  implicit val RfqStatusDecoder: EntityDecoder[RfqStatus] = jsonOf[RfqStatus]
  implicit val RfqStatusEncoder: EntityEncoder[RfqStatus] = jsonEncoderOf[RfqStatus]
}
