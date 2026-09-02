package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CheckStatus._

case class CheckStatus (
  
object CheckStatus {
  import DateTimeCodecs._

  implicit val CheckStatusCodecJson: CodecJson[CheckStatus] = CodecJson.derive[CheckStatus]
  implicit val CheckStatusDecoder: EntityDecoder[CheckStatus] = jsonOf[CheckStatus]
  implicit val CheckStatusEncoder: EntityEncoder[CheckStatus] = jsonEncoderOf[CheckStatus]
}
