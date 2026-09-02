package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import Team._

case class Team (
  createdAt: OffsetDateTime,
description: Option[String],
id: UUID,
name: String,
parentTeamId: Option[UUID],
tenantId: UUID,
updatedAt: OffsetDateTime)

object Team {
  import DateTimeCodecs._

  implicit val TeamCodecJson: CodecJson[Team] = CodecJson.derive[Team]
  implicit val TeamDecoder: EntityDecoder[Team] = jsonOf[Team]
  implicit val TeamEncoder: EntityEncoder[Team] = jsonEncoderOf[Team]
}
