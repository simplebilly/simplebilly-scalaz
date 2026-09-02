package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PluginError._

case class PluginError (
  badRequest: List[Any],
notFound: List[Any],
unauthorized: List[Any],
internalError: List[Any],
databaseError: List[Any],
validationError: List[Any],
notImplemented: String)

object PluginError {
  import DateTimeCodecs._

  implicit val PluginErrorCodecJson: CodecJson[PluginError] = CodecJson.derive[PluginError]
  implicit val PluginErrorDecoder: EntityDecoder[PluginError] = jsonOf[PluginError]
  implicit val PluginErrorEncoder: EntityEncoder[PluginError] = jsonEncoderOf[PluginError]
}
