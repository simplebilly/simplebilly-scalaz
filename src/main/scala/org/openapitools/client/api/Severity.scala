package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Severity._

case class Severity (
  
object Severity {
  import DateTimeCodecs._

  implicit val SeverityCodecJson: CodecJson[Severity] = CodecJson.derive[Severity]
  implicit val SeverityDecoder: EntityDecoder[Severity] = jsonOf[Severity]
  implicit val SeverityEncoder: EntityEncoder[Severity] = jsonEncoderOf[Severity]
}
