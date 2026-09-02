package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EmissionFactorResponse._

case class EmissionFactorResponse (
  categoryId: String,
kgCo2ePerUnit: Double,
nameDe: String,
source: String,
unit: String,
version: String)

object EmissionFactorResponse {
  import DateTimeCodecs._

  implicit val EmissionFactorResponseCodecJson: CodecJson[EmissionFactorResponse] = CodecJson.derive[EmissionFactorResponse]
  implicit val EmissionFactorResponseDecoder: EntityDecoder[EmissionFactorResponse] = jsonOf[EmissionFactorResponse]
  implicit val EmissionFactorResponseEncoder: EntityEncoder[EmissionFactorResponse] = jsonEncoderOf[EmissionFactorResponse]
}
