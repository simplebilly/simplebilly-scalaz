package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import QuotaOverride._

case class QuotaOverride (
  features: Option[QuotaOverrideFeatures],
maxConnectors: Option[Integer],
maxInvoicesPerMonth: Option[Long],
maxUsers: Option[Integer],
metered: Option[Map[String, Long]],
/* Custom plan id; unknown ids resolve to enterprise limits. */
  plan: Option[String])

object QuotaOverride {
  import DateTimeCodecs._

  implicit val QuotaOverrideCodecJson: CodecJson[QuotaOverride] = CodecJson.derive[QuotaOverride]
  implicit val QuotaOverrideDecoder: EntityDecoder[QuotaOverride] = jsonOf[QuotaOverride]
  implicit val QuotaOverrideEncoder: EntityEncoder[QuotaOverride] = jsonEncoderOf[QuotaOverride]
}
