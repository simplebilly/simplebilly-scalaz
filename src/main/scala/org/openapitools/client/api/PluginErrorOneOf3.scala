package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PluginErrorOneOf3._

case class PluginErrorOneOf3 (
  internalError: List[Any])

object PluginErrorOneOf3 {
  import DateTimeCodecs._

  implicit val PluginErrorOneOf3CodecJson: CodecJson[PluginErrorOneOf3] = CodecJson.derive[PluginErrorOneOf3]
  implicit val PluginErrorOneOf3Decoder: EntityDecoder[PluginErrorOneOf3] = jsonOf[PluginErrorOneOf3]
  implicit val PluginErrorOneOf3Encoder: EntityEncoder[PluginErrorOneOf3] = jsonEncoderOf[PluginErrorOneOf3]
}
