package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import LeadUpdate._

case class LeadUpdate (
  company: Option[String],
convertedAt: Option[OffsetDateTime],
createdAt: Option[OffsetDateTime],
email: Option[String],
firstContactAt: Option[OffsetDateTime],
name: Option[String],
notes: Option[String],
phone: Option[String],
score: Option[Integer],
source: Option[String],
status: Option[LeadStatus],
tags: Option[AnyType],
tenantId: Option[UUID],
updatedAt: Option[OffsetDateTime])

object LeadUpdate {
  import DateTimeCodecs._

  implicit val LeadUpdateCodecJson: CodecJson[LeadUpdate] = CodecJson.derive[LeadUpdate]
  implicit val LeadUpdateDecoder: EntityDecoder[LeadUpdate] = jsonOf[LeadUpdate]
  implicit val LeadUpdateEncoder: EntityEncoder[LeadUpdate] = jsonEncoderOf[LeadUpdate]
}
