package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PartialFeatureSettings._

case class PartialFeatureSettings (
  onlineshop: Option[Boolean],
reportBilanz: Option[Boolean],
reportBwa: Option[Boolean],
reportEuer: Option[Boolean],
reportGewerbesteuer: Option[Boolean],
reportGuv: Option[Boolean],
reportKst: Option[Boolean],
reportUstva: Option[Boolean])

object PartialFeatureSettings {
  import DateTimeCodecs._

  implicit val PartialFeatureSettingsCodecJson: CodecJson[PartialFeatureSettings] = CodecJson.derive[PartialFeatureSettings]
  implicit val PartialFeatureSettingsDecoder: EntityDecoder[PartialFeatureSettings] = jsonOf[PartialFeatureSettings]
  implicit val PartialFeatureSettingsEncoder: EntityEncoder[PartialFeatureSettings] = jsonEncoderOf[PartialFeatureSettings]
}
