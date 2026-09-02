package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ConfigFieldKindOneOf1._

case class ConfigFieldKindOneOf1 (
  `type`: `Type`)

object ConfigFieldKindOneOf1 {
  import DateTimeCodecs._
  sealed trait `Type`
  case object Secret extends `Type`

  object `Type` {
    def to`Type`(s: String): Option[`Type`] = s match {
      case "Secret" => Some(Secret)
      case _ => None
    }

    def from`Type`(x: `Type`): String = x match {
      case Secret => "Secret"
    }
  }

  implicit val `Type`EnumEncoder: EncodeJson[`Type`] =
    EncodeJson[`Type`](is => StringEncodeJson(`Type`.from`Type`(is)))

  implicit val `Type`EnumDecoder: DecodeJson[`Type`] =
    DecodeJson.optionDecoder[`Type`](n => n.string.flatMap(jStr => `Type`.to`Type`(jStr)), "`Type` failed to de-serialize")

  implicit val ConfigFieldKindOneOf1CodecJson: CodecJson[ConfigFieldKindOneOf1] = CodecJson.derive[ConfigFieldKindOneOf1]
  implicit val ConfigFieldKindOneOf1Decoder: EntityDecoder[ConfigFieldKindOneOf1] = jsonOf[ConfigFieldKindOneOf1]
  implicit val ConfigFieldKindOneOf1Encoder: EntityEncoder[ConfigFieldKindOneOf1] = jsonEncoderOf[ConfigFieldKindOneOf1]
}
