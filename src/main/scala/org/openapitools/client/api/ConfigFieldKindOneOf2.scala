package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ConfigFieldKindOneOf2._

case class ConfigFieldKindOneOf2 (
  `type`: `Type`)

object ConfigFieldKindOneOf2 {
  import DateTimeCodecs._
  sealed trait `Type`
  case object Url extends `Type`

  object `Type` {
    def to`Type`(s: String): Option[`Type`] = s match {
      case "Url" => Some(Url)
      case _ => None
    }

    def from`Type`(x: `Type`): String = x match {
      case Url => "Url"
    }
  }

  implicit val `Type`EnumEncoder: EncodeJson[`Type`] =
    EncodeJson[`Type`](is => StringEncodeJson(`Type`.from`Type`(is)))

  implicit val `Type`EnumDecoder: DecodeJson[`Type`] =
    DecodeJson.optionDecoder[`Type`](n => n.string.flatMap(jStr => `Type`.to`Type`(jStr)), "`Type` failed to de-serialize")

  implicit val ConfigFieldKindOneOf2CodecJson: CodecJson[ConfigFieldKindOneOf2] = CodecJson.derive[ConfigFieldKindOneOf2]
  implicit val ConfigFieldKindOneOf2Decoder: EntityDecoder[ConfigFieldKindOneOf2] = jsonOf[ConfigFieldKindOneOf2]
  implicit val ConfigFieldKindOneOf2Encoder: EntityEncoder[ConfigFieldKindOneOf2] = jsonEncoderOf[ConfigFieldKindOneOf2]
}
