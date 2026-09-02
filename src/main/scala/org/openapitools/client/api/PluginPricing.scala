package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PluginPricing._

case class PluginPricing (
  `type`: `Type`,
price: Double,
pricePerMonth: Double)

object PluginPricing {
  import DateTimeCodecs._
  sealed trait `Type`
  case object Free extends `Type`
  case object OneTime extends `Type`
  case object Recurring extends `Type`

  object `Type` {
    def to`Type`(s: String): Option[`Type`] = s match {
      case "Free" => Some(Free)
      case "OneTime" => Some(OneTime)
      case "Recurring" => Some(Recurring)
      case _ => None
    }

    def from`Type`(x: `Type`): String = x match {
      case Free => "Free"
      case OneTime => "OneTime"
      case Recurring => "Recurring"
    }
  }

  implicit val `Type`EnumEncoder: EncodeJson[`Type`] =
    EncodeJson[`Type`](is => StringEncodeJson(`Type`.from`Type`(is)))

  implicit val `Type`EnumDecoder: DecodeJson[`Type`] =
    DecodeJson.optionDecoder[`Type`](n => n.string.flatMap(jStr => `Type`.to`Type`(jStr)), "`Type` failed to de-serialize")

  implicit val PluginPricingCodecJson: CodecJson[PluginPricing] = CodecJson.derive[PluginPricing]
  implicit val PluginPricingDecoder: EntityDecoder[PluginPricing] = jsonOf[PluginPricing]
  implicit val PluginPricingEncoder: EntityEncoder[PluginPricing] = jsonEncoderOf[PluginPricing]
}
