package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ComplianceTrainingUpdate._

case class ComplianceTrainingUpdate (
  /* Whether HR can assign this training as required for employees. */
  assignable: Option[Boolean],
/* Stable code used by plugins and frontend players (e.g. \"data_privacy\"). */
  code: Option[String],
description: Option[String],
/* Minimum score (0–100) required to pass. */
  passScore: Option[Integer],
/* Marketplace plugin platform id when source = Plugin. */
  pluginPlatform: Option[String],
source: Option[TrainingSource],
title: Option[String],
/* Certificate validity in months; null = no expiry. */
  validityMonths: Option[Integer])

object ComplianceTrainingUpdate {
  import DateTimeCodecs._

  implicit val ComplianceTrainingUpdateCodecJson: CodecJson[ComplianceTrainingUpdate] = CodecJson.derive[ComplianceTrainingUpdate]
  implicit val ComplianceTrainingUpdateDecoder: EntityDecoder[ComplianceTrainingUpdate] = jsonOf[ComplianceTrainingUpdate]
  implicit val ComplianceTrainingUpdateEncoder: EntityEncoder[ComplianceTrainingUpdate] = jsonEncoderOf[ComplianceTrainingUpdate]
}
