package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PluginErrorOneOf2._

case class PluginErrorOneOf2 (
  unauthorized: List[Any])

object PluginErrorOneOf2 {
  import DateTimeCodecs._

  implicit val PluginErrorOneOf2CodecJson: CodecJson[PluginErrorOneOf2] = CodecJson.derive[PluginErrorOneOf2]
  implicit val PluginErrorOneOf2Decoder: EntityDecoder[PluginErrorOneOf2] = jsonOf[PluginErrorOneOf2]
  implicit val PluginErrorOneOf2Encoder: EntityEncoder[PluginErrorOneOf2] = jsonEncoderOf[PluginErrorOneOf2]
}
