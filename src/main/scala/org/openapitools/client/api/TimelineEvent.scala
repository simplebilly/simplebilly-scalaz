package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import TimelineEvent._

case class TimelineEvent (
  /* RFC3339 UTC timestamp for sorting. */
  date: String,
detail: Option[String],
/* Source record id (stringified). */
  id: String,
status: Option[String],
title: String,
/* Source module: communication | quotation | order | invoice | attachment. */
  `type`: String)

object TimelineEvent {
  import DateTimeCodecs._

  implicit val TimelineEventCodecJson: CodecJson[TimelineEvent] = CodecJson.derive[TimelineEvent]
  implicit val TimelineEventDecoder: EntityDecoder[TimelineEvent] = jsonOf[TimelineEvent]
  implicit val TimelineEventEncoder: EntityEncoder[TimelineEvent] = jsonEncoderOf[TimelineEvent]
}
