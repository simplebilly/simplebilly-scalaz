package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PluginErrorOneOf1._

case class PluginErrorOneOf1 (
  notFound: List[Any])

object PluginErrorOneOf1 {
  import DateTimeCodecs._

  implicit val PluginErrorOneOf1CodecJson: CodecJson[PluginErrorOneOf1] = CodecJson.derive[PluginErrorOneOf1]
  implicit val PluginErrorOneOf1Decoder: EntityDecoder[PluginErrorOneOf1] = jsonOf[PluginErrorOneOf1]
  implicit val PluginErrorOneOf1Encoder: EntityEncoder[PluginErrorOneOf1] = jsonEncoderOf[PluginErrorOneOf1]
}
