package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ConfigFieldKindOneOf4._

case class ConfigFieldKindOneOf4 (
  `type`: `Type`)

object ConfigFieldKindOneOf4 {
  import DateTimeCodecs._
  sealed trait `Type`
  case object Bool extends `Type`

  object `Type` {
    def to`Type`(s: String): Option[`Type`] = s match {
      case "Bool" => Some(Bool)
      case _ => None
    }

    def from`Type`(x: `Type`): String = x match {
      case Bool => "Bool"
    }
  }

  implicit val `Type`EnumEncoder: EncodeJson[`Type`] =
    EncodeJson[`Type`](is => StringEncodeJson(`Type`.from`Type`(is)))

  implicit val `Type`EnumDecoder: DecodeJson[`Type`] =
    DecodeJson.optionDecoder[`Type`](n => n.string.flatMap(jStr => `Type`.to`Type`(jStr)), "`Type` failed to de-serialize")

  implicit val ConfigFieldKindOneOf4CodecJson: CodecJson[ConfigFieldKindOneOf4] = CodecJson.derive[ConfigFieldKindOneOf4]
  implicit val ConfigFieldKindOneOf4Decoder: EntityDecoder[ConfigFieldKindOneOf4] = jsonOf[ConfigFieldKindOneOf4]
  implicit val ConfigFieldKindOneOf4Encoder: EntityEncoder[ConfigFieldKindOneOf4] = jsonEncoderOf[ConfigFieldKindOneOf4]
}
