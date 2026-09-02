package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PluginPricingOneOf1._

case class PluginPricingOneOf1 (
  price: Double,
`type`: `Type`)

object PluginPricingOneOf1 {
  import DateTimeCodecs._
  sealed trait `Type`
  case object OneTime extends `Type`

  object `Type` {
    def to`Type`(s: String): Option[`Type`] = s match {
      case "OneTime" => Some(OneTime)
      case _ => None
    }

    def from`Type`(x: `Type`): String = x match {
      case OneTime => "OneTime"
    }
  }

  implicit val `Type`EnumEncoder: EncodeJson[`Type`] =
    EncodeJson[`Type`](is => StringEncodeJson(`Type`.from`Type`(is)))

  implicit val `Type`EnumDecoder: DecodeJson[`Type`] =
    DecodeJson.optionDecoder[`Type`](n => n.string.flatMap(jStr => `Type`.to`Type`(jStr)), "`Type` failed to de-serialize")

  implicit val PluginPricingOneOf1CodecJson: CodecJson[PluginPricingOneOf1] = CodecJson.derive[PluginPricingOneOf1]
  implicit val PluginPricingOneOf1Decoder: EntityDecoder[PluginPricingOneOf1] = jsonOf[PluginPricingOneOf1]
  implicit val PluginPricingOneOf1Encoder: EntityEncoder[PluginPricingOneOf1] = jsonEncoderOf[PluginPricingOneOf1]
}
