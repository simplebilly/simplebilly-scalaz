package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import InstrumentType._

case class InstrumentType (
  
object InstrumentType {
  import DateTimeCodecs._

  implicit val InstrumentTypeCodecJson: CodecJson[InstrumentType] = CodecJson.derive[InstrumentType]
  implicit val InstrumentTypeDecoder: EntityDecoder[InstrumentType] = jsonOf[InstrumentType]
  implicit val InstrumentTypeEncoder: EntityEncoder[InstrumentType] = jsonEncoderOf[InstrumentType]
}
