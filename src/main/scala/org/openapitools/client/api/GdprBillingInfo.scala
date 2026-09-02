package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import GdprBillingInfo._

case class GdprBillingInfo (
  currentPeriodEnd: Option[OffsetDateTime],
currentPeriodStart: Option[OffsetDateTime],
plan: Option[String],
status: Option[String],
tenantId: UUID)

object GdprBillingInfo {
  import DateTimeCodecs._

  implicit val GdprBillingInfoCodecJson: CodecJson[GdprBillingInfo] = CodecJson.derive[GdprBillingInfo]
  implicit val GdprBillingInfoDecoder: EntityDecoder[GdprBillingInfo] = jsonOf[GdprBillingInfo]
  implicit val GdprBillingInfoEncoder: EntityEncoder[GdprBillingInfo] = jsonEncoderOf[GdprBillingInfo]
}
