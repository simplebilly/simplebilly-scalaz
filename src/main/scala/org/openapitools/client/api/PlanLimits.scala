package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PlanLimits._

case class PlanLimits (
  maxConnectors: Integer,
maxInvoicesPerMonth: Long,
maxUsers: Integer,
metered: Option[Map[String, Long]],
/* Connectors that are *not* included in this plan (require a higher tier). Empty = all connectors included on this plan. */
  paidConnectors: List[String])

object PlanLimits {
  import DateTimeCodecs._

  implicit val PlanLimitsCodecJson: CodecJson[PlanLimits] = CodecJson.derive[PlanLimits]
  implicit val PlanLimitsDecoder: EntityDecoder[PlanLimits] = jsonOf[PlanLimits]
  implicit val PlanLimitsEncoder: EntityEncoder[PlanLimits] = jsonEncoderOf[PlanLimits]
}
