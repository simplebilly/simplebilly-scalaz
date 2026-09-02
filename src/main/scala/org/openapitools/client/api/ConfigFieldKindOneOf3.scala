package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ConfigFieldKindOneOf3._

case class ConfigFieldKindOneOf3 (
  options: List[String],
`type`: `Type`)

object ConfigFieldKindOneOf3 {
  import DateTimeCodecs._
  sealed trait `Type`
  case object Select extends `Type`

  object `Type` {
    def to`Type`(s: String): Option[`Type`] = s match {
      case "Select" => Some(Select)
      case _ => None
    }

    def from`Type`(x: `Type`): String = x match {
      case Select => "Select"
    }
  }

  implicit val `Type`EnumEncoder: EncodeJson[`Type`] =
    EncodeJson[`Type`](is => StringEncodeJson(`Type`.from`Type`(is)))

  implicit val `Type`EnumDecoder: DecodeJson[`Type`] =
    DecodeJson.optionDecoder[`Type`](n => n.string.flatMap(jStr => `Type`.to`Type`(jStr)), "`Type` failed to de-serialize")

  implicit val ConfigFieldKindOneOf3CodecJson: CodecJson[ConfigFieldKindOneOf3] = CodecJson.derive[ConfigFieldKindOneOf3]
  implicit val ConfigFieldKindOneOf3Decoder: EntityDecoder[ConfigFieldKindOneOf3] = jsonOf[ConfigFieldKindOneOf3]
  implicit val ConfigFieldKindOneOf3Encoder: EntityEncoder[ConfigFieldKindOneOf3] = jsonEncoderOf[ConfigFieldKindOneOf3]
}
