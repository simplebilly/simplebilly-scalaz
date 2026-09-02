package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ElsterStatus._

case class ElsterStatus (
  certConfigured: Boolean,
ericAvailable: Boolean,
ericVersion: Option[String],
featureEnabled: Boolean,
hint: String,
mode: String,
vendorIdConfigured: Boolean)

object ElsterStatus {
  import DateTimeCodecs._

  implicit val ElsterStatusCodecJson: CodecJson[ElsterStatus] = CodecJson.derive[ElsterStatus]
  implicit val ElsterStatusDecoder: EntityDecoder[ElsterStatus] = jsonOf[ElsterStatus]
  implicit val ElsterStatusEncoder: EntityEncoder[ElsterStatus] = jsonEncoderOf[ElsterStatus]
}
