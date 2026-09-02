package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PluginPricingOneOf2._

case class PluginPricingOneOf2 (
  pricePerMonth: Double,
`type`: `Type`)

object PluginPricingOneOf2 {
  import DateTimeCodecs._
  sealed trait `Type`
  case object Recurring extends `Type`

  object `Type` {
    def to`Type`(s: String): Option[`Type`] = s match {
      case "Recurring" => Some(Recurring)
      case _ => None
    }

    def from`Type`(x: `Type`): String = x match {
      case Recurring => "Recurring"
    }
  }

  implicit val `Type`EnumEncoder: EncodeJson[`Type`] =
    EncodeJson[`Type`](is => StringEncodeJson(`Type`.from`Type`(is)))

  implicit val `Type`EnumDecoder: DecodeJson[`Type`] =
    DecodeJson.optionDecoder[`Type`](n => n.string.flatMap(jStr => `Type`.to`Type`(jStr)), "`Type` failed to de-serialize")

  implicit val PluginPricingOneOf2CodecJson: CodecJson[PluginPricingOneOf2] = CodecJson.derive[PluginPricingOneOf2]
  implicit val PluginPricingOneOf2Decoder: EntityDecoder[PluginPricingOneOf2] = jsonOf[PluginPricingOneOf2]
  implicit val PluginPricingOneOf2Encoder: EntityEncoder[PluginPricingOneOf2] = jsonEncoderOf[PluginPricingOneOf2]
}
