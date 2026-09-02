package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PluginErrorOneOf5._

case class PluginErrorOneOf5 (
  validationError: List[Any])

object PluginErrorOneOf5 {
  import DateTimeCodecs._

  implicit val PluginErrorOneOf5CodecJson: CodecJson[PluginErrorOneOf5] = CodecJson.derive[PluginErrorOneOf5]
  implicit val PluginErrorOneOf5Decoder: EntityDecoder[PluginErrorOneOf5] = jsonOf[PluginErrorOneOf5]
  implicit val PluginErrorOneOf5Encoder: EntityEncoder[PluginErrorOneOf5] = jsonEncoderOf[PluginErrorOneOf5]
}
