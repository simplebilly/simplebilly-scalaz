package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PosRegisterStatus._

case class PosRegisterStatus (
  
object PosRegisterStatus {
  import DateTimeCodecs._

  implicit val PosRegisterStatusCodecJson: CodecJson[PosRegisterStatus] = CodecJson.derive[PosRegisterStatus]
  implicit val PosRegisterStatusDecoder: EntityDecoder[PosRegisterStatus] = jsonOf[PosRegisterStatus]
  implicit val PosRegisterStatusEncoder: EntityEncoder[PosRegisterStatus] = jsonEncoderOf[PosRegisterStatus]
}
