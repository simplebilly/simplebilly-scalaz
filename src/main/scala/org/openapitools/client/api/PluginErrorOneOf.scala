package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PluginErrorOneOf._

case class PluginErrorOneOf (
  badRequest: List[Any])

object PluginErrorOneOf {
  import DateTimeCodecs._

  implicit val PluginErrorOneOfCodecJson: CodecJson[PluginErrorOneOf] = CodecJson.derive[PluginErrorOneOf]
  implicit val PluginErrorOneOfDecoder: EntityDecoder[PluginErrorOneOf] = jsonOf[PluginErrorOneOf]
  implicit val PluginErrorOneOfEncoder: EntityEncoder[PluginErrorOneOf] = jsonEncoderOf[PluginErrorOneOf]
}
