package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ApplicationStatusDto._

case class ApplicationStatusDto (
  postingId: Option[UUID],
status: String)

object ApplicationStatusDto {
  import DateTimeCodecs._

  implicit val ApplicationStatusDtoCodecJson: CodecJson[ApplicationStatusDto] = CodecJson.derive[ApplicationStatusDto]
  implicit val ApplicationStatusDtoDecoder: EntityDecoder[ApplicationStatusDto] = jsonOf[ApplicationStatusDto]
  implicit val ApplicationStatusDtoEncoder: EntityEncoder[ApplicationStatusDto] = jsonEncoderOf[ApplicationStatusDto]
}
