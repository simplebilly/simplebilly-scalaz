package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CreateEmissionTarget._

case class CreateEmissionTarget (
  baseValue: String,
baseYear: Integer,
description: String,
scope: String,
targetValue: String,
targetYear: Integer)

object CreateEmissionTarget {
  import DateTimeCodecs._

  implicit val CreateEmissionTargetCodecJson: CodecJson[CreateEmissionTarget] = CodecJson.derive[CreateEmissionTarget]
  implicit val CreateEmissionTargetDecoder: EntityDecoder[CreateEmissionTarget] = jsonOf[CreateEmissionTarget]
  implicit val CreateEmissionTargetEncoder: EntityEncoder[CreateEmissionTarget] = jsonEncoderOf[CreateEmissionTarget]
}
