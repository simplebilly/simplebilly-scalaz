package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import QuotaOverrideFeatures._

case class QuotaOverrideFeatures (
  erp: Option[Boolean],
fancyReports: Option[Boolean],
taxAutomations: Option[Boolean])

object QuotaOverrideFeatures {
  import DateTimeCodecs._

  implicit val QuotaOverrideFeaturesCodecJson: CodecJson[QuotaOverrideFeatures] = CodecJson.derive[QuotaOverrideFeatures]
  implicit val QuotaOverrideFeaturesDecoder: EntityDecoder[QuotaOverrideFeatures] = jsonOf[QuotaOverrideFeatures]
  implicit val QuotaOverrideFeaturesEncoder: EntityEncoder[QuotaOverrideFeatures] = jsonEncoderOf[QuotaOverrideFeatures]
}
