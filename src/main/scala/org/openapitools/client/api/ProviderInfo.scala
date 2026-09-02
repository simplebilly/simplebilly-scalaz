package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ProviderInfo._

case class ProviderInfo (
  displayName: String,
name: String,
requiresApiKey: Boolean,
services: List[String],
supportsLabelCreation: Boolean,
supportsRateEstimation: Boolean,
supportsTracking: Boolean)

object ProviderInfo {
  import DateTimeCodecs._

  implicit val ProviderInfoCodecJson: CodecJson[ProviderInfo] = CodecJson.derive[ProviderInfo]
  implicit val ProviderInfoDecoder: EntityDecoder[ProviderInfo] = jsonOf[ProviderInfo]
  implicit val ProviderInfoEncoder: EntityEncoder[ProviderInfo] = jsonEncoderOf[ProviderInfo]
}
