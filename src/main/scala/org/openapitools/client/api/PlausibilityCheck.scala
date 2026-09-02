package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PlausibilityCheck._

case class PlausibilityCheck (
  detail: String,
id: String,
name: String,
severity: Severity,
status: CheckStatus)

object PlausibilityCheck {
  import DateTimeCodecs._

  implicit val PlausibilityCheckCodecJson: CodecJson[PlausibilityCheck] = CodecJson.derive[PlausibilityCheck]
  implicit val PlausibilityCheckDecoder: EntityDecoder[PlausibilityCheck] = jsonOf[PlausibilityCheck]
  implicit val PlausibilityCheckEncoder: EntityEncoder[PlausibilityCheck] = jsonEncoderOf[PlausibilityCheck]
}
