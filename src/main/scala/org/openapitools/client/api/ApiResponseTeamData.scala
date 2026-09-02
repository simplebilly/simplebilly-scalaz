package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import ApiResponseTeamData._

case class ApiResponseTeamData (
  createdAt: OffsetDateTime,
description: Option[String],
id: UUID,
name: String,
parentTeamId: Option[UUID],
tenantId: UUID,
updatedAt: OffsetDateTime)

object ApiResponseTeamData {
  import DateTimeCodecs._

  implicit val ApiResponseTeamDataCodecJson: CodecJson[ApiResponseTeamData] = CodecJson.derive[ApiResponseTeamData]
  implicit val ApiResponseTeamDataDecoder: EntityDecoder[ApiResponseTeamData] = jsonOf[ApiResponseTeamData]
  implicit val ApiResponseTeamDataEncoder: EntityEncoder[ApiResponseTeamData] = jsonEncoderOf[ApiResponseTeamData]
}
