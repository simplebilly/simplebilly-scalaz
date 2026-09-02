package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import NotificationDto._

case class NotificationDto (
  createdAt: OffsetDateTime,
id: UUID,
isRead: Boolean,
message: Option[String],
sentViaEmail: Boolean,
tenantId: UUID,
title: String,
userId: UUID)

object NotificationDto {
  import DateTimeCodecs._

  implicit val NotificationDtoCodecJson: CodecJson[NotificationDto] = CodecJson.derive[NotificationDto]
  implicit val NotificationDtoDecoder: EntityDecoder[NotificationDto] = jsonOf[NotificationDto]
  implicit val NotificationDtoEncoder: EntityEncoder[NotificationDto] = jsonEncoderOf[NotificationDto]
}
