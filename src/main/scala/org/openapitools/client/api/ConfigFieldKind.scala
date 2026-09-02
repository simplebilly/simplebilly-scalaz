package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ConfigFieldKind._

case class ConfigFieldKind (
  `type`: `Type`,
options: List[String])

object ConfigFieldKind {
  import DateTimeCodecs._
  sealed trait `Type`
  case object Text extends `Type`
  case object Secret extends `Type`
  case object Url extends `Type`
  case object Select extends `Type`
  case object Bool extends `Type`

  object `Type` {
    def to`Type`(s: String): Option[`Type`] = s match {
      case "Text" => Some(Text)
      case "Secret" => Some(Secret)
      case "Url" => Some(Url)
      case "Select" => Some(Select)
      case "Bool" => Some(Bool)
      case _ => None
    }

    def from`Type`(x: `Type`): String = x match {
      case Text => "Text"
      case Secret => "Secret"
      case Url => "Url"
      case Select => "Select"
      case Bool => "Bool"
    }
  }

  implicit val `Type`EnumEncoder: EncodeJson[`Type`] =
    EncodeJson[`Type`](is => StringEncodeJson(`Type`.from`Type`(is)))

  implicit val `Type`EnumDecoder: DecodeJson[`Type`] =
    DecodeJson.optionDecoder[`Type`](n => n.string.flatMap(jStr => `Type`.to`Type`(jStr)), "`Type` failed to de-serialize")

  implicit val ConfigFieldKindCodecJson: CodecJson[ConfigFieldKind] = CodecJson.derive[ConfigFieldKind]
  implicit val ConfigFieldKindDecoder: EntityDecoder[ConfigFieldKind] = jsonOf[ConfigFieldKind]
  implicit val ConfigFieldKindEncoder: EntityEncoder[ConfigFieldKind] = jsonEncoderOf[ConfigFieldKind]
}
