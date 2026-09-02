package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PluginPricingOneOf._

case class PluginPricingOneOf (
  `type`: `Type`)

object PluginPricingOneOf {
  import DateTimeCodecs._
  sealed trait `Type`
  case object Free extends `Type`

  object `Type` {
    def to`Type`(s: String): Option[`Type`] = s match {
      case "Free" => Some(Free)
      case _ => None
    }

    def from`Type`(x: `Type`): String = x match {
      case Free => "Free"
    }
  }

  implicit val `Type`EnumEncoder: EncodeJson[`Type`] =
    EncodeJson[`Type`](is => StringEncodeJson(`Type`.from`Type`(is)))

  implicit val `Type`EnumDecoder: DecodeJson[`Type`] =
    DecodeJson.optionDecoder[`Type`](n => n.string.flatMap(jStr => `Type`.to`Type`(jStr)), "`Type` failed to de-serialize")

  implicit val PluginPricingOneOfCodecJson: CodecJson[PluginPricingOneOf] = CodecJson.derive[PluginPricingOneOf]
  implicit val PluginPricingOneOfDecoder: EntityDecoder[PluginPricingOneOf] = jsonOf[PluginPricingOneOf]
  implicit val PluginPricingOneOfEncoder: EntityEncoder[PluginPricingOneOf] = jsonEncoderOf[PluginPricingOneOf]
}
