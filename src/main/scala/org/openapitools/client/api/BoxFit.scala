package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import BoxFit._

case class BoxFit (
  heightCm: Double,
itemCount: Integer,
lengthCm: Double,
volumeCm3: Double,
widthCm: Double)

object BoxFit {
  import DateTimeCodecs._

  implicit val BoxFitCodecJson: CodecJson[BoxFit] = CodecJson.derive[BoxFit]
  implicit val BoxFitDecoder: EntityDecoder[BoxFit] = jsonOf[BoxFit]
  implicit val BoxFitEncoder: EntityEncoder[BoxFit] = jsonEncoderOf[BoxFit]
}
