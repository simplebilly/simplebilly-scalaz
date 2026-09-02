package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SuitabilityResult._

case class SuitabilityResult (
  methods: List[MethodSuitability],
recommendedBox: Option[BoxFit],
requiresInsurance: Boolean,
totalValue: String,
totalWeightKg: Double)

object SuitabilityResult {
  import DateTimeCodecs._

  implicit val SuitabilityResultCodecJson: CodecJson[SuitabilityResult] = CodecJson.derive[SuitabilityResult]
  implicit val SuitabilityResultDecoder: EntityDecoder[SuitabilityResult] = jsonOf[SuitabilityResult]
  implicit val SuitabilityResultEncoder: EntityEncoder[SuitabilityResult] = jsonEncoderOf[SuitabilityResult]
}
