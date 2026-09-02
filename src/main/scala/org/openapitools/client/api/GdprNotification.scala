package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import GdprNotification._

case class GdprNotification (
  createdAt: OffsetDateTime,
id: UUID,
isRead: Boolean,
message: Option[String],
tenantId: UUID,
title: String)

object GdprNotification {
  import DateTimeCodecs._

  implicit val GdprNotificationCodecJson: CodecJson[GdprNotification] = CodecJson.derive[GdprNotification]
  implicit val GdprNotificationDecoder: EntityDecoder[GdprNotification] = jsonOf[GdprNotification]
  implicit val GdprNotificationEncoder: EntityEncoder[GdprNotification] = jsonEncoderOf[GdprNotification]
}
