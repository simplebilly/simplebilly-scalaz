package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import ComplianceTraining._

case class ComplianceTraining (
  /* Whether HR can assign this training as required for employees. */
  assignable: Option[Boolean],
/* Stable code used by plugins and frontend players (e.g. \"data_privacy\"). */
  code: Option[String],
createdAt: Option[OffsetDateTime],
deletedAt: Option[OffsetDateTime],
description: Option[String],
id: Option[UUID],
/* Minimum score (0–100) required to pass. */
  passScore: Option[Integer],
/* Marketplace plugin platform id when source = Plugin. */
  pluginPlatform: Option[String],
source: Option[TrainingSource],
tenantId: Option[UUID],
title: Option[String],
updatedAt: Option[OffsetDateTime],
/* Certificate validity in months; null = no expiry. */
  validityMonths: Option[Integer])

object ComplianceTraining {
  import DateTimeCodecs._

  implicit val ComplianceTrainingCodecJson: CodecJson[ComplianceTraining] = CodecJson.derive[ComplianceTraining]
  implicit val ComplianceTrainingDecoder: EntityDecoder[ComplianceTraining] = jsonOf[ComplianceTraining]
  implicit val ComplianceTrainingEncoder: EntityEncoder[ComplianceTraining] = jsonEncoderOf[ComplianceTraining]
}
