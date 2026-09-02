package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PluginErrorOneOf6._

case class PluginErrorOneOf6 (
  notImplemented: String)

object PluginErrorOneOf6 {
  import DateTimeCodecs._

  implicit val PluginErrorOneOf6CodecJson: CodecJson[PluginErrorOneOf6] = CodecJson.derive[PluginErrorOneOf6]
  implicit val PluginErrorOneOf6Decoder: EntityDecoder[PluginErrorOneOf6] = jsonOf[PluginErrorOneOf6]
  implicit val PluginErrorOneOf6Encoder: EntityEncoder[PluginErrorOneOf6] = jsonEncoderOf[PluginErrorOneOf6]
}
