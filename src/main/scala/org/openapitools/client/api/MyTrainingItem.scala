package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.UUID

import MyTrainingItem._

case class MyTrainingItem (
  assignmentId: UUID,
certificateId: Option[String],
code: String,
description: Option[String],
dueDate: Option[LocalDate],
lastScore: Option[Integer],
passScore: Integer,
passed: Option[Boolean],
status: AssignmentStatus,
title: String,
trainingId: UUID,
validUntil: Option[OffsetDateTime])

object MyTrainingItem {
  import DateTimeCodecs._

  implicit val MyTrainingItemCodecJson: CodecJson[MyTrainingItem] = CodecJson.derive[MyTrainingItem]
  implicit val MyTrainingItemDecoder: EntityDecoder[MyTrainingItem] = jsonOf[MyTrainingItem]
  implicit val MyTrainingItemEncoder: EntityEncoder[MyTrainingItem] = jsonEncoderOf[MyTrainingItem]
}
