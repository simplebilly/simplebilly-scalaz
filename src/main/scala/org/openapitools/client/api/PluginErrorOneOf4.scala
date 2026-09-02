package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PluginErrorOneOf4._

case class PluginErrorOneOf4 (
  databaseError: List[Any])

object PluginErrorOneOf4 {
  import DateTimeCodecs._

  implicit val PluginErrorOneOf4CodecJson: CodecJson[PluginErrorOneOf4] = CodecJson.derive[PluginErrorOneOf4]
  implicit val PluginErrorOneOf4Decoder: EntityDecoder[PluginErrorOneOf4] = jsonOf[PluginErrorOneOf4]
  implicit val PluginErrorOneOf4Encoder: EntityEncoder[PluginErrorOneOf4] = jsonEncoderOf[PluginErrorOneOf4]
}
