package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ScopeTotal._

case class ScopeTotal (
  scope: String,
tco2e: String)

object ScopeTotal {
  import DateTimeCodecs._

  implicit val ScopeTotalCodecJson: CodecJson[ScopeTotal] = CodecJson.derive[ScopeTotal]
  implicit val ScopeTotalDecoder: EntityDecoder[ScopeTotal] = jsonOf[ScopeTotal]
  implicit val ScopeTotalEncoder: EntityEncoder[ScopeTotal] = jsonEncoderOf[ScopeTotal]
}
