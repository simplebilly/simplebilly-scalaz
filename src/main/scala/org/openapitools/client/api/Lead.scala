package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import Lead._

case class Lead (
  company: Option[String],
convertedAt: Option[OffsetDateTime],
createdAt: OffsetDateTime,
email: Option[String],
firstContactAt: OffsetDateTime,
name: String,
notes: Option[String],
phone: Option[String],
score: Integer,
source: String,
status: LeadStatus,
tags: AnyType,
tenantId: UUID,
updatedAt: Option[OffsetDateTime])

object Lead {
  import DateTimeCodecs._

  implicit val LeadCodecJson: CodecJson[Lead] = CodecJson.derive[Lead]
  implicit val LeadDecoder: EntityDecoder[Lead] = jsonOf[Lead]
  implicit val LeadEncoder: EntityEncoder[Lead] = jsonEncoderOf[Lead]
}
