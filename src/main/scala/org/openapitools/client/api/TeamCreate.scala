package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import TeamCreate._

case class TeamCreate (
  description: Option[String],
name: String,
parentTeamId: Option[UUID])

object TeamCreate {
  import DateTimeCodecs._

  implicit val TeamCreateCodecJson: CodecJson[TeamCreate] = CodecJson.derive[TeamCreate]
  implicit val TeamCreateDecoder: EntityDecoder[TeamCreate] = jsonOf[TeamCreate]
  implicit val TeamCreateEncoder: EntityEncoder[TeamCreate] = jsonEncoderOf[TeamCreate]
}
