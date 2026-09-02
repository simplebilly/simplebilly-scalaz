package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ConfigFieldInfo._

case class ConfigFieldInfo (
  kind: ConfigFieldKind,
label: String,
name: String,
placeholder: Option[String],
required: Boolean)

object ConfigFieldInfo {
  import DateTimeCodecs._

  implicit val ConfigFieldInfoCodecJson: CodecJson[ConfigFieldInfo] = CodecJson.derive[ConfigFieldInfo]
  implicit val ConfigFieldInfoDecoder: EntityDecoder[ConfigFieldInfo] = jsonOf[ConfigFieldInfo]
  implicit val ConfigFieldInfoEncoder: EntityEncoder[ConfigFieldInfo] = jsonEncoderOf[ConfigFieldInfo]
}
