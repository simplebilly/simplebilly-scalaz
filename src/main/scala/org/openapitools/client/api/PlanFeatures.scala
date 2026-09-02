package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PlanFeatures._

case class PlanFeatures (
  connectors: Boolean,
erp: Boolean,
fancyReports: Boolean,
taxAutomations: Boolean)

object PlanFeatures {
  import DateTimeCodecs._

  implicit val PlanFeaturesCodecJson: CodecJson[PlanFeatures] = CodecJson.derive[PlanFeatures]
  implicit val PlanFeaturesDecoder: EntityDecoder[PlanFeatures] = jsonOf[PlanFeatures]
  implicit val PlanFeaturesEncoder: EntityEncoder[PlanFeatures] = jsonEncoderOf[PlanFeatures]
}
