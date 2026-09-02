package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Plan._

case class Plan (
  features: PlanFeatures,
id: String,
limits: PlanLimits,
name: String,
priceEur: Double)

object Plan {
  import DateTimeCodecs._

  implicit val PlanCodecJson: CodecJson[Plan] = CodecJson.derive[Plan]
  implicit val PlanDecoder: EntityDecoder[Plan] = jsonOf[Plan]
  implicit val PlanEncoder: EntityEncoder[Plan] = jsonEncoderOf[Plan]
}
