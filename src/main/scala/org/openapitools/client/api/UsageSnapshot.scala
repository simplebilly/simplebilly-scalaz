package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import UsageSnapshot._

case class UsageSnapshot (
  connectors: Long,
invoicesThisMonth: Long,
overageSeats: Long,
users: Long)

object UsageSnapshot {
  import DateTimeCodecs._

  implicit val UsageSnapshotCodecJson: CodecJson[UsageSnapshot] = CodecJson.derive[UsageSnapshot]
  implicit val UsageSnapshotDecoder: EntityDecoder[UsageSnapshot] = jsonOf[UsageSnapshot]
  implicit val UsageSnapshotEncoder: EntityEncoder[UsageSnapshot] = jsonEncoderOf[UsageSnapshot]
}
