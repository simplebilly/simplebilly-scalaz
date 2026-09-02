package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SyncSummary._

case class SyncSummary (
  errorMessage: Option[String],
itemsFailed: Option[Integer],
itemsSynced: Option[Integer])

object SyncSummary {
  import DateTimeCodecs._

  implicit val SyncSummaryCodecJson: CodecJson[SyncSummary] = CodecJson.derive[SyncSummary]
  implicit val SyncSummaryDecoder: EntityDecoder[SyncSummary] = jsonOf[SyncSummary]
  implicit val SyncSummaryEncoder: EntityEncoder[SyncSummary] = jsonEncoderOf[SyncSummary]
}
